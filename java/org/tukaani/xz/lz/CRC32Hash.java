/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.lz;

class CRC32Hash {
    private static final int CRC32_POLY = -306674912;
    static final int[] crcTable = new int[256];

    /*
     * Enabled aggressive block sorting
     */
    static {
        int n = 0;
        while (n < 256) {
            int n2 = n;
            for (int i = 0; i < 8; ++i) {
                if ((n2 & 1) != 0) {
                    n2 = -306674912 ^ n2 >>> 1;
                    continue;
                }
                n2 >>>= 1;
            }
            CRC32Hash.crcTable[n] = n2;
            ++n;
        }
    }

    CRC32Hash() {
    }
}

