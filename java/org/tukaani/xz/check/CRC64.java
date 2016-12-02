/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.tukaani.xz.check;

import org.tukaani.xz.check.Check;

public class CRC64
extends Check {
    private static final long[] crcTable = new long[256];
    private static final long poly = -3932672073523589310L;
    private long crc = -1;

    /*
     * Enabled aggressive block sorting
     */
    static {
        int n = 0;
        while (n < crcTable.length) {
            long l = n;
            for (int i = 0; i < 8; ++i) {
                if ((l & 1) == 1) {
                    l = -3932672073523589310L ^ l >>> 1;
                    continue;
                }
                l >>>= 1;
            }
            CRC64.crcTable[n] = l;
            ++n;
        }
    }

    public CRC64() {
        this.size = 8;
        this.name = "CRC64";
    }

    @Override
    public byte[] finish() {
        long l = -1 ^ this.crc;
        this.crc = -1;
        byte[] arrby = new byte[8];
        for (int i = 0; i < arrby.length; ++i) {
            arrby[i] = (byte)(l >> i * 8);
        }
        return arrby;
    }

    @Override
    public void update(byte[] arrby, int n, int n2) {
        int n3 = n + n2;
        int n4 = n;
        while (n4 < n3) {
            long[] arrl = crcTable;
            int n5 = n4 + 1;
            this.crc = arrl[255 & (arrby[n4] ^ (int)this.crc)] ^ this.crc >>> 8;
            n4 = n5;
        }
    }
}

