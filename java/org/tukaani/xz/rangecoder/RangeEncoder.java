/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.AssertionError
 */
package org.tukaani.xz.rangecoder;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.rangecoder.RangeCoder;

public final class RangeEncoder
extends RangeCoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BIT_PRICE_SHIFT_BITS = 4;
    private static final int MOVE_REDUCING_BITS = 4;
    private static final int[] prices;
    private final byte[] buf;
    private int bufPos;
    private byte cache;
    private int cacheSize;
    private long low;
    private int range;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !RangeEncoder.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
        prices = new int[128];
        int n = 8;
        while (n < 2048) {
            int n2 = n;
            int n3 = 0;
            for (int i = 0; i < 4; ++i) {
                n2 *= n2;
                n3 <<= 1;
                while ((-65536 & n2) != 0) {
                    n2 >>>= 1;
                    ++n3;
                }
            }
            RangeEncoder.prices[n >> 4] = 161 - n3;
            n += 16;
        }
    }

    public RangeEncoder(int n) {
        this.buf = new byte[n];
        this.reset();
    }

    public static int getBitPrice(int n, int n2) {
        if (!$assertionsDisabled && n2 != 0 && n2 != 1) {
            throw new AssertionError();
        }
        return prices[(n ^ 2047 & - n2) >>> 4];
    }

    public static int getBitTreePrice(short[] arrs, int n) {
        int n2 = 0;
        int n3 = n | arrs.length;
        do {
            int n4 = n3 & 1;
            n2 += RangeEncoder.getBitPrice(arrs[n3 >>>= 1], n4);
        } while (n3 != 1);
        return n2;
    }

    public static int getDirectBitsPrice(int n) {
        return n << 4;
    }

    public static int getReverseBitTreePrice(short[] arrs, int n) {
        int n2 = 0;
        int n3 = 1;
        int n4 = n | arrs.length;
        do {
            int n5 = n4 & 1;
            n2 += RangeEncoder.getBitPrice(arrs[n3], n5);
            n3 = n5 | n3 << 1;
        } while ((n4 >>>= 1) != 1);
        return n2;
    }

    private void shiftLow() {
        int n = (int)(this.low >>> 32);
        if (n != 0 || this.low < 0xFF000000L) {
            int n2;
            int n3 = this.cache;
            do {
                byte[] arrby = this.buf;
                int n4 = this.bufPos;
                this.bufPos = n4 + 1;
                arrby[n4] = (byte)(n3 + n);
                n3 = 255;
                this.cacheSize = n2 = -1 + this.cacheSize;
            } while (n2 != 0);
            this.cache = (byte)(this.low >>> 24);
        }
        this.cacheSize = 1 + this.cacheSize;
        this.low = (0xFFFFFF & this.low) << 8;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void encodeBit(short[] arrs, int n, int n2) {
        short s = arrs[n];
        int n3 = s * (this.range >>> 11);
        if (n2 == 0) {
            this.range = n3;
            arrs[n] = (short)(s + (2048 - s >>> 5));
        } else {
            this.low += 0xFFFFFFFFL & (long)n3;
            this.range -= n3;
            arrs[n] = (short)(s - (s >>> 5));
        }
        if ((-16777216 & this.range) == 0) {
            this.range <<= 8;
            super.shiftLow();
        }
    }

    public void encodeBitTree(short[] arrs, int n) {
        int n2 = 1;
        int n3 = arrs.length;
        do {
            int n4 = n & (n3 >>>= 1);
            this.encodeBit(arrs, n2, n4);
            n2 <<= 1;
            if (n4 == 0) continue;
            n2 |= 1;
        } while (n3 != 1);
    }

    public void encodeDirectBits(int n, int n2) {
        do {
            this.range >>>= 1;
            long l = this.low;
            int n3 = this.range;
            this.low = l + (long)(n3 & 0 - (1 & n >>> --n2));
            if ((-16777216 & this.range) != 0) continue;
            this.range <<= 8;
            super.shiftLow();
        } while (n2 != 0);
    }

    public void encodeReverseBitTree(short[] arrs, int n) {
        int n2 = 1;
        int n3 = n | arrs.length;
        do {
            int n4 = n3 & 1;
            this.encodeBit(arrs, n2, n4);
            n2 = n4 | n2 << 1;
        } while ((n3 >>>= 1) != 1);
    }

    public int finish() {
        for (int i = 0; i < 5; ++i) {
            this.shiftLow();
        }
        return this.bufPos;
    }

    public int getPendingSize() {
        return -1 + (5 + (this.bufPos + this.cacheSize));
    }

    public void reset() {
        this.low = 0;
        this.range = -1;
        this.cache = 0;
        this.cacheSize = 1;
        this.bufPos = 0;
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write(this.buf, 0, this.bufPos);
    }
}

