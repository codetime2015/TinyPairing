/**
 *
 * This file provides implementation for BF IBE BassicIdent, which is IND-ID-CPA secure
 * The version is the general version, in the way that all random numbers are represented and operated as large integers.
 * Conversions from and to trinary representation are needed.
 *
 *
 * Author: Xiaokang Xiong (xkxiong@gmail.com)
 * Date: Jul, 2009
 */

#include "sha1.h"

module BF_IBEM{
    provides interface BF_IBE;
    uses interface BaseField;
    uses interface PointArith;
    uses interface Pairing;
    uses interface GetRandom;
    uses interface SHA1;
}

implementation{
    
    bool hashxor_with_extelmt(ExtElement2* extelmt, UInt* msg, uint32_t len, UInt* hmsg){
        SHA1Context ctx;
        UInt sha1sum[SHA1HashSize];
        UInt i,j, b;
        
        b = len%SHA1HashSize;
        if(b==0) b=SHA1HashSize;
        if(len>0)
            len=(len-1)/SHA1HashSize;
        if(call SHA1.reset(&ctx)!=shaSuccess) return FALSE;
        if(call SHA1.update(&ctx, (UInt*) extelmt, ELEMENT_LEN*6)!=shaSuccess) return FALSE;
        if(call SHA1.digest(&ctx, sha1sum)!=shaSuccess) return FALSE;
        if(len>0){
            for(i=0;i<SHA1HashSize;i++)
                hmsg[i] = msg[i] ^ sha1sum[i];
            
            for(j=1;j<=len;j++){
                if(call SHA1.reset(&ctx)!=shaSuccess) return FALSE;
                if(call SHA1.update(&ctx, sha1sum, SHA1HashSize)!=shaSuccess) return FALSE;
                if(call SHA1.digest(&ctx, sha1sum)!=shaSuccess) return FALSE;
                if(j<len){
                    for(i=0;i<SHA1HashSize;i++)
                        hmsg[i] = msg[i] ^ sha1sum[i];
                }
            }
        }
        for(i=0;i<b;i++)
            hmsg[i] = msg[i] ^ sha1sum[i];
        
        return TRUE;
    }
    
    /*
     * Setup
     * Input a point as generator
     * Output master key mk, and public key pk.
     * Master key is generated by convert a random binary string to a trinary element
     */
    command void BF_IBE.setup(Point* generator, BigInt mk, Point* pk){
        
        call GetRandom.generator(generator);
        call GetRandom.bigint(mk);
        
        call PointArith.mult_proj2(mk, generator, pk);
    }
    
    /*
     * Private key extration
     * Input a binary ID of length len, given a master key mk
     * Output the decrypt key dID of such ID
     * Return 1 if success, 0 if fail (ID cannot be mapped to a point)
     */
    command UInt BF_IBE.keyextract(UInt* ID, uint32_t len, BigInt mk, Point* dID){
        Point pID;
        if(call PointArith.map2point(ID, len, &pID)==0) return 0;
        call PointArith.mult_proj2(mk, &pID, dID);
        return 1;
    }
    
    /*
     * Encryption
     * Input the system public key pk, encrypt a message msg of length len, under a public ID
     * Output the ciphertext C0=rP and C1
     */
    command bool BF_IBE.encrypt(Point* generator, Point* pk, UInt* msg, uint32_t len, UInt*ID, uint32_t idlen, Point* C0, UInt* C1){
        BigInt r;
        ExtElement2 gIDr;
        Point QID;
        
        
        call GetRandom.bigint(r);
        
        //C0
        call PointArith.mult_proj2(r, generator, C0);
        
        //C1
        call PointArith.map2point(ID, idlen, &QID);
        call PointArith.mult_proj2(r, &QID, &QID);//QID=r*QID
        call Pairing.pairing(&QID, pk, &gIDr);
        //hash gIDr and XOR with message
        hashxor_with_extelmt(&gIDr, msg, len, C1);
        
        return TRUE;
    }
    
    /*
     * Decryption
     */
    command bool BF_IBE.decrypt(Point* dID, Point* C0, UInt* C1, uint32_t len, UInt* msg){
        ExtElement2 extelmt;
        
        call Pairing.pairing(dID, C0, &extelmt);
        //hash extelmt and XOR with C1 to recover msg
        if(hashxor_with_extelmt(&extelmt, C1, len, msg)==FALSE) return FALSE;
        
        return TRUE;
    }
}