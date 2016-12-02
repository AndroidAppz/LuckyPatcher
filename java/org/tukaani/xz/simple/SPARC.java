/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.simple;

import org.tukaani.xz.simple.SimpleFilter;

public final class SPARC
implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public SPARC(boolean bl, int n) {
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
            if (arrby[n4] == 64 && (192 & arrby[n4 + 1]) == 0 || arrby[n4] == 127 && (192 & arrby[n4 + 1]) == 192) {
                int n6 = ((255 & arrby[n4]) << 24 | (255 & arrby[n4 + 1]) << 16 | (255 & arrby[n4 + 2]) << 8 | 255 & arrby[n4 + 3]) << 2;
                int n7 = this.isEncoder ? n6 + (n4 + this.pos - n) : n6 - (n4 + this.pos - n);
                int n8 = n7 >>> 2;
                int n9 = 1073741824 | (1073741823 & 0 - (1 & n8 >>> 22) << 22 | 4194303 & n8);
                arrby[n4] = (byte)(n9 >>> 24);
                arrby[n4 + 1] = (byte)(n9 >>> 16);
                arrby[n4 + 2] = (byte)(n9 >>> 8);
                arrby[n4 + 3] = (byte)n9;
            }
            n4 += 4;
        } while (true);
    }
}

