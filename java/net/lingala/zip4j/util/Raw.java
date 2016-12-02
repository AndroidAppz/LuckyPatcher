/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataInput
 *  java.io.IOException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package net.lingala.zip4j.util;

import java.io.DataInput;
import java.io.IOException;
import net.lingala.zip4j.exception.ZipException;

public class Raw {
    public static byte bitArrayToByte(int[] arrn) throws ZipException {
        if (arrn == null) {
            throw new ZipException("bit array is null, cannot calculate byte from bits");
        }
        if (arrn.length != 8) {
            throw new ZipException("invalid bit array length, cannot calculate byte");
        }
        if (!Raw.checkBits(arrn)) {
            throw new ZipException("invalid bits provided, bits contain other values than 0 or 1");
        }
        int n = 0;
        for (int i = 0; i < arrn.length; ++i) {
            n = (int)((double)n + Math.pow((double)2.0, (double)i) * (double)arrn[i]);
        }
        return (byte)n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean checkBits(int[] arrn) {
        int n = 1;
        int n2 = 0;
        while (n2 < arrn.length) {
            if (arrn[n2] != 0 && arrn[n2] != n) {
                return (boolean)0;
            }
            ++n2;
        }
        return (boolean)n;
    }

    public static byte[] convertCharArrayToByteArray(char[] arrc) {
        if (arrc == null) {
            throw new NullPointerException();
        }
        byte[] arrby = new byte[arrc.length];
        for (int i = 0; i < arrc.length; ++i) {
            arrby[i] = (byte)arrc[i];
        }
        return arrby;
    }

    public static void prepareBuffAESIVBytes(byte[] arrby, int n, int n2) {
        arrby[0] = (byte)n;
        arrby[1] = (byte)(n >> 8);
        arrby[2] = (byte)(n >> 16);
        arrby[3] = (byte)(n >> 24);
        arrby[4] = 0;
        arrby[5] = 0;
        arrby[6] = 0;
        arrby[7] = 0;
        arrby[8] = 0;
        arrby[9] = 0;
        arrby[10] = 0;
        arrby[11] = 0;
        arrby[12] = 0;
        arrby[13] = 0;
        arrby[14] = 0;
        arrby[15] = 0;
    }

    public static int readIntLittleEndian(byte[] arrby, int n) {
        return 255 & arrby[n] | (255 & arrby[n + 1]) << 8 | (255 & arrby[n + 2] | (255 & arrby[n + 3]) << 8) << 16;
    }

    public static int readLeInt(DataInput dataInput, byte[] arrby) throws ZipException {
        try {
            dataInput.readFully(arrby, 0, 4);
        }
        catch (IOException var2_2) {
            throw new ZipException((Throwable)var2_2);
        }
        return 255 & arrby[0] | (255 & arrby[1]) << 8 | (255 & arrby[2] | (255 & arrby[3]) << 8) << 16;
    }

    public static long readLongLittleEndian(byte[] arrby, int n) {
        return (((((((0 | (long)(255 & arrby[n + 7])) << 8 | (long)(255 & arrby[n + 6])) << 8 | (long)(255 & arrby[n + 5])) << 8 | (long)(255 & arrby[n + 4])) << 8 | (long)(255 & arrby[n + 3])) << 8 | (long)(255 & arrby[n + 2])) << 8 | (long)(255 & arrby[n + 1])) << 8 | (long)(255 & arrby[n]);
    }

    public static final short readShortBigEndian(byte[] arrby, int n) {
        return (short)((short)((short)(0 | 255 & arrby[n]) << 8) | 255 & arrby[n + 1]);
    }

    public static int readShortLittleEndian(byte[] arrby, int n) {
        return 255 & arrby[n] | (255 & arrby[n + 1]) << 8;
    }

    public static byte[] toByteArray(int n) {
        byte[] arrby = new byte[]{(byte)n, (byte)(n >> 8), (byte)(n >> 16), (byte)(n >> 24)};
        return arrby;
    }

    public static byte[] toByteArray(int n, int n2) {
        byte[] arrby = new byte[n2];
        byte[] arrby2 = Raw.toByteArray(n);
        for (int i = 0; i < arrby2.length && i < n2; ++i) {
            arrby[i] = arrby2[i];
        }
        return arrby;
    }

    public static final void writeIntLittleEndian(byte[] arrby, int n, int n2) {
        arrby[n + 3] = (byte)(n2 >>> 24);
        arrby[n + 2] = (byte)(n2 >>> 16);
        arrby[n + 1] = (byte)(n2 >>> 8);
        arrby[n] = (byte)(n2 & 255);
    }

    public static void writeLongLittleEndian(byte[] arrby, int n, long l) {
        arrby[n + 7] = (byte)(l >>> 56);
        arrby[n + 6] = (byte)(l >>> 48);
        arrby[n + 5] = (byte)(l >>> 40);
        arrby[n + 4] = (byte)(l >>> 32);
        arrby[n + 3] = (byte)(l >>> 24);
        arrby[n + 2] = (byte)(l >>> 16);
        arrby[n + 1] = (byte)(l >>> 8);
        arrby[n] = (byte)(255 & l);
    }

    public static final void writeShortLittleEndian(byte[] arrby, int n, short s) {
        arrby[n + 1] = (byte)(s >>> 8);
        arrby[n] = (byte)(s & 255);
    }
}

