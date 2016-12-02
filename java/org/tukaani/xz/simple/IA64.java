/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.simple;

import org.tukaani.xz.simple.SimpleFilter;

public final class IA64
implements SimpleFilter {
    private static final int[] BRANCH_TABLE = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 6, 6, 0, 0, 7, 7, 4, 4, 0, 0, 4, 4, 0, 0};
    private final boolean isEncoder;
    private int pos;

    public IA64(boolean bl, int n) {
        this.isEncoder = bl;
        this.pos = n;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public int code(byte[] arrby, int n, int n2) {
        int n3 = -16 + (n + n2);
        int n4 = n;
        do {
            if (n4 > n3) {
                int n5 = n4 - n;
                this.pos = n5 + this.pos;
                return n5;
            }
            int n6 = 31 & arrby[n4];
            int n7 = BRANCH_TABLE[n6];
            int n8 = 5;
            for (int i = 0; i < 3; ++i, n8 += 41) {
                if ((1 & n7 >>> i) == 0) continue;
                int n9 = n8 >>> 3;
                int n10 = n8 & 7;
                long l = 0;
                for (int j = 0; j < 6; l |= (255 & (long)arrby[j + (n4 + n9)]) << j * 8, ++j) {
                }
                long l2 = l >>> n10;
                if ((15 & l2 >>> 37) != 5 || (7 & l2 >>> 9) != 0) continue;
                int n11 = ((int)(1048575 & l2 >>> 13) | (1 & (int)(l2 >>> 36)) << 20) << 4;
                int n12 = this.isEncoder ? n11 + (n4 + this.pos - n) : n11 - (n4 + this.pos - n);
                int n13 = n12 >>> 4;
                long l3 = l2 & -77309403137L | (1048575 & (long)n13) << 13 | (0x100000 & (long)n13) << 16;
                long l4 = l & (long)(-1 + (1 << n10)) | l3 << n10;
                for (int k = 0; k < 6; ++k) {
                    arrby[k + (n4 + n9)] = (byte)(l4 >>> k * 8);
                }
            }
            n4 += 16;
        } while (true);
    }
}

