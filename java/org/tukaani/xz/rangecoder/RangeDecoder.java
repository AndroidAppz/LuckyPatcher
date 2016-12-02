/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 */
package org.tukaani.xz.rangecoder;

import java.io.IOException;
import org.tukaani.xz.rangecoder.RangeCoder;

public abstract class RangeDecoder
extends RangeCoder {
    int code = 0;
    int range = 0;

    public int decodeBit(short[] arrs, int n) throws IOException {
        this.normalize();
        short s = arrs[n];
        int n2 = s * (this.range >>> 11);
        if ((Integer.MIN_VALUE ^ this.code) < (Integer.MIN_VALUE ^ n2)) {
            this.range = n2;
            arrs[n] = (short)(s + (2048 - s >>> 5));
            return 0;
        }
        this.range -= n2;
        this.code -= n2;
        arrs[n] = (short)(s - (s >>> 5));
        return 1;
    }

    public int decodeBitTree(short[] arrs) throws IOException {
        int n = 1;
        while ((n = n << 1 | this.decodeBit(arrs, n)) < arrs.length) {
        }
        return n - arrs.length;
    }

    public int decodeDirectBits(int n) throws IOException {
        int n2 = 0;
        do {
            this.normalize();
            this.range >>>= 1;
            int n3 = this.code - this.range >>> 31;
            this.code -= this.range & n3 - 1;
            n2 = n2 << 1 | 1 - n3;
        } while (--n != 0);
        return n2;
    }

    public int decodeReverseBitTree(short[] arrs) throws IOException {
        int n = 1;
        int n2 = 0;
        int n3 = 0;
        do {
            int n4 = this.decodeBit(arrs, n);
            n = n4 | n << 1;
            int n5 = n2 + 1;
            n3 |= n4 << n2;
            if (n >= arrs.length) {
                return n3;
            }
            n2 = n5;
        } while (true);
    }

    public abstract void normalize() throws IOException;
}

