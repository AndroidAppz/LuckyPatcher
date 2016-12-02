/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.simple;

import org.tukaani.xz.simple.SimpleFilter;

public final class PowerPC
implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public PowerPC(boolean bl, int n) {
        this.isEncoder = bl;
        this.pos = n;
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
            if ((252 & arrby[n4]) == 72 && (3 & arrby[n4 + 3]) == 1) {
                int n6 = (3 & arrby[n4]) << 24 | (255 & arrby[n4 + 1]) << 16 | (255 & arrby[n4 + 2]) << 8 | 252 & arrby[n4 + 3];
                int n7 = this.isEncoder ? n6 + (n4 + this.pos - n) : n6 - (n4 + this.pos - n);
                arrby[n4] = (byte)(72 | 3 & n7 >>> 24);
                arrby[n4 + 1] = (byte)(n7 >>> 16);
                arrby[n4 + 2] = (byte)(n7 >>> 8);
                arrby[n4 + 3] = (byte)(n7 | 3 & arrby[n4 + 3]);
            }
            n4 += 4;
        } while (true);
    }
}

