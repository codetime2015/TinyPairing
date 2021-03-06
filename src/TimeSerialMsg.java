/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'TimeSerialMsg'
 * message type.
 */

public class TimeSerialMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 18;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 11;

    /** Create a new TimeSerialMsg of size 18. */
    public TimeSerialMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new TimeSerialMsg of the given data_length. */
    public TimeSerialMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TimeSerialMsg with the given data_length
     * and base offset.
     */
    public TimeSerialMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TimeSerialMsg using the given byte array
     * as backing store.
     */
    public TimeSerialMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TimeSerialMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public TimeSerialMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TimeSerialMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public TimeSerialMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TimeSerialMsg embedded in the given message
     * at the given base offset.
     */
    public TimeSerialMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TimeSerialMsg embedded in the given message
     * at the given base offset and length.
     */
    public TimeSerialMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <TimeSerialMsg> \n";
      try {
        s += "  [t1=0x"+Long.toHexString(get_t1())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [t2=0x"+Long.toHexString(get_t2())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [t3=0x"+Long.toHexString(get_t3())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [t4=0x"+Long.toHexString(get_t4())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [overflow=0x"+Long.toHexString(get_overflow())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [result=0x"+Long.toHexString(get_result())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: t1
    //   Field type: long, unsigned
    //   Offset (bits): 0
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 't1' is signed (false).
     */
    public static boolean isSigned_t1() {
        return false;
    }

    /**
     * Return whether the field 't1' is an array (false).
     */
    public static boolean isArray_t1() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 't1'
     */
    public static int offset_t1() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 't1'
     */
    public static int offsetBits_t1() {
        return 0;
    }

    /**
     * Return the value (as a long) of the field 't1'
     */
    public long get_t1() {
        return (long)getUIntBEElement(offsetBits_t1(), 32);
    }

    /**
     * Set the value of the field 't1'
     */
    public void set_t1(long value) {
        setUIntBEElement(offsetBits_t1(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 't1'
     */
    public static int size_t1() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 't1'
     */
    public static int sizeBits_t1() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: t2
    //   Field type: long, unsigned
    //   Offset (bits): 32
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 't2' is signed (false).
     */
    public static boolean isSigned_t2() {
        return false;
    }

    /**
     * Return whether the field 't2' is an array (false).
     */
    public static boolean isArray_t2() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 't2'
     */
    public static int offset_t2() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 't2'
     */
    public static int offsetBits_t2() {
        return 32;
    }

    /**
     * Return the value (as a long) of the field 't2'
     */
    public long get_t2() {
        return (long)getUIntBEElement(offsetBits_t2(), 32);
    }

    /**
     * Set the value of the field 't2'
     */
    public void set_t2(long value) {
        setUIntBEElement(offsetBits_t2(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 't2'
     */
    public static int size_t2() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 't2'
     */
    public static int sizeBits_t2() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: t3
    //   Field type: long, unsigned
    //   Offset (bits): 64
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 't3' is signed (false).
     */
    public static boolean isSigned_t3() {
        return false;
    }

    /**
     * Return whether the field 't3' is an array (false).
     */
    public static boolean isArray_t3() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 't3'
     */
    public static int offset_t3() {
        return (64 / 8);
    }

    /**
     * Return the offset (in bits) of the field 't3'
     */
    public static int offsetBits_t3() {
        return 64;
    }

    /**
     * Return the value (as a long) of the field 't3'
     */
    public long get_t3() {
        return (long)getUIntBEElement(offsetBits_t3(), 32);
    }

    /**
     * Set the value of the field 't3'
     */
    public void set_t3(long value) {
        setUIntBEElement(offsetBits_t3(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 't3'
     */
    public static int size_t3() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 't3'
     */
    public static int sizeBits_t3() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: t4
    //   Field type: long, unsigned
    //   Offset (bits): 96
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 't4' is signed (false).
     */
    public static boolean isSigned_t4() {
        return false;
    }

    /**
     * Return whether the field 't4' is an array (false).
     */
    public static boolean isArray_t4() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 't4'
     */
    public static int offset_t4() {
        return (96 / 8);
    }

    /**
     * Return the offset (in bits) of the field 't4'
     */
    public static int offsetBits_t4() {
        return 96;
    }

    /**
     * Return the value (as a long) of the field 't4'
     */
    public long get_t4() {
        return (long)getUIntBEElement(offsetBits_t4(), 32);
    }

    /**
     * Set the value of the field 't4'
     */
    public void set_t4(long value) {
        setUIntBEElement(offsetBits_t4(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 't4'
     */
    public static int size_t4() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 't4'
     */
    public static int sizeBits_t4() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: overflow
    //   Field type: short, unsigned
    //   Offset (bits): 128
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'overflow' is signed (false).
     */
    public static boolean isSigned_overflow() {
        return false;
    }

    /**
     * Return whether the field 'overflow' is an array (false).
     */
    public static boolean isArray_overflow() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'overflow'
     */
    public static int offset_overflow() {
        return (128 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'overflow'
     */
    public static int offsetBits_overflow() {
        return 128;
    }

    /**
     * Return the value (as a short) of the field 'overflow'
     */
    public short get_overflow() {
        return (short)getUIntBEElement(offsetBits_overflow(), 8);
    }

    /**
     * Set the value of the field 'overflow'
     */
    public void set_overflow(short value) {
        setUIntBEElement(offsetBits_overflow(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'overflow'
     */
    public static int size_overflow() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'overflow'
     */
    public static int sizeBits_overflow() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: result
    //   Field type: short, unsigned
    //   Offset (bits): 136
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'result' is signed (false).
     */
    public static boolean isSigned_result() {
        return false;
    }

    /**
     * Return whether the field 'result' is an array (false).
     */
    public static boolean isArray_result() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'result'
     */
    public static int offset_result() {
        return (136 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'result'
     */
    public static int offsetBits_result() {
        return 136;
    }

    /**
     * Return the value (as a short) of the field 'result'
     */
    public short get_result() {
        return (short)getUIntBEElement(offsetBits_result(), 8);
    }

    /**
     * Set the value of the field 'result'
     */
    public void set_result(short value) {
        setUIntBEElement(offsetBits_result(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'result'
     */
    public static int size_result() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'result'
     */
    public static int sizeBits_result() {
        return 8;
    }

}
