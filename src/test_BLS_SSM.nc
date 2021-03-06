/**
 *
 * Sample code for BLS Short Signature
 *
 * Author: Xiaokang Xiong <xkxiong@gmail.com>
 * Date: Sep, 2008
 */
#include "crypto.h"
#include "TimeSerial.h"

module test_BLS_SSM
{
    uses interface Boot;
    uses interface Leds;
    uses interface BLS_SS;
    uses interface SplitControl;
    uses interface AMSend as SerialSend;
    uses interface Packet;
    
    uses interface Counter<TMilli, uint32_t>;
    uses interface Alarm<TMilli, uint32_t>;
    
}

implementation
{
    uint8_t ctr_c;
    
    void testing()
    {
    uint32_t start, end;
    Point pk,pp,generator;
    BigInt sk;
    CpElement sig;
    //ExtElement2 e1, e2;
    UInt msg[8] = "abcdeghi";
    int8_t result;
    time_msg *tmsg;
    message_t packet1;
    UInt i;
    
    tmsg = (time_msg*)call Packet.getPayload(&packet1, sizeof(time_msg));
    if (tmsg == NULL) {return;}
    if (call Packet.maxPayloadLength() < sizeof(time_msg)) {
        return;
    }
    
    tmsg->t1=0;
    tmsg->t2=0;
    tmsg->t3=0;
    tmsg->t4=0;
    ctr_c=0;
    for(i=0;i<10;i++){
        start = call Counter.get();
        call BLS_SS.keygen(&generator, &pk, sk);
        end = call Counter.get();
        tmsg->t1 += end - start;
        
        start = call Counter.get();
        call BLS_SS.sign(msg, sizeof(msg), sk, sig);
        end = call Counter.get();
        tmsg->t2 += end - start;
        
        start = call Counter.get();
        result = call BLS_SS.verify(&generator, &pk, msg, sizeof(msg), sig);
        end = call Counter.get();
        tmsg->t3 += end - start;
    }
    tmsg->t4=0;
    tmsg->overflow = ctr_c;
    tmsg->result = result;
    
    if(call SerialSend.send(AM_BROADCAST_ADDR, &packet1, sizeof(time_msg))==SUCCESS)
        call Leds.led2Toggle();
    
    }
    
    
    event void Boot.booted()
    {
    call SplitControl.start();
    }
    
    event void SplitControl.startDone(error_t err) {
        if (err == SUCCESS) {
            testing();
        }
    }
    
    event void SplitControl.stopDone(error_t err) {}
    
    event void SerialSend.sendDone(message_t* bufPtr, error_t error) {}
    
    async event void Counter.overflow(){
        ctr_c++;
    }
    
    async event void Alarm.fired(){
        
    }
    
}
