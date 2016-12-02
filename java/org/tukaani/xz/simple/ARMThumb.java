/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.simple;

import org.tukaani.xz.simple.SimpleFilter;

public final class ARMThumb
implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public ARMThumb(boolean bl, int n) {
        this.isEncoder = bl;
        this.pos = n + 4;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public int code(byte[] arrby, int n, int n2) {
        int n3 = -4 + (n + n2);
        int n4 = n;
        do {
            if (n4 > n3) {
                int n5 = n4 - n;
                this.pos = n5 + this.pos;
                return n5;
            }
            if ((248 & arrby[n4 + 1]) == 240 && (248 & arrby[n4 + 3]) == 248) {
                int n6 = ((7 & arrby[n4 + 1]) << 19 | (255 & arrby[n4]) << 11 | (7 & arrby[n4 + 3]) << 8 | 255 & arrby[n4 + 2]) << 1;
                int n7 = this.isEncoder ? n6 + (n4 + this.pos - n) : n6 - (n4 + this.pos - n);
                int n8 = n7 >>> 1;
                arrby[n4 + 1] = (byte)(240 | 7 & n8 >>> 19);
                arrby[n4] = (byte)(n8 >>> 11);
                arrby[n4 + 3] = (byte)(248 | 7 & n8 >>> 8);
                arrby[n4 + 2] = (byte)n8;
                n4 += 2;
            }
            n4 += 2;
        } while (true);
    }
}

