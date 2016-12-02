/*
 * Decompiled with CFR 0_110.
 */
package org.tukaani.xz.lz;

import org.tukaani.xz.lz.CRC32Hash;
import org.tukaani.xz.lz.LZEncoder;

final class Hash234
extends CRC32Hash {
    private static final int HASH_2_MASK = 1023;
    private static final int HASH_2_SIZE = 1024;
    private static final int HASH_3_MASK = 65535;
    private static final int HASH_3_SIZE = 65536;
    private final int[] hash2Table = new int[1024];
    private int hash2Value = 0;
    private final int[] hash3Table = new int[65536];
    private int hash3Value = 0;
    private final int hash4Mask;
    private final int[] hash4Table;
    private int hash4Value = 0;

    Hash234(int n) {
        this.hash4Table = new int[Hash234.getHash4Size(n)];
        this.hash4Mask = -1 + this.hash4Table.length;
    }

    static int getHash4Size(int n) {
        int n2 = n - 1;
        int n3 = n2 | n2 >>> 1;
        int n4 = n3 | n3 >>> 2;
        int n5 = n4 | n4 >>> 4;
        int n6 = 65535 | (n5 | n5 >>> 8) >>> 1;
        if (n6 > 16777216) {
            n6 >>>= 1;
        }
        return n6 + 1;
    }

    static int getMemoryUsage(int n) {
        return 4 + (66560 + Hash234.getHash4Size(n)) / 256;
    }

    void calcHashes(byte[] arrby, int n) {
        int n2 = crcTable[255 & arrby[n]] ^ 255 & arrby[n + 1];
        this.hash2Value = n2 & 1023;
        int n3 = n2 ^ (255 & arrby[n + 2]) << 8;
        this.hash3Value = 65535 & n3;
        this.hash4Value = (n3 ^ crcTable[255 & arrby[n + 3]] << 5) & this.hash4Mask;
    }

    int getHash2Pos() {
        return this.hash2Table[this.hash2Value];
    }

    int getHash3Pos() {
        return this.hash3Table[this.hash3Value];
    }

    int getHash4Pos() {
        return this.hash4Table[this.hash4Value];
    }

    void normalize(int n) {
        LZEncoder.normalize(this.hash2Table, n);
        LZEncoder.normalize(this.hash3Table, n);
        LZEncoder.normalize(this.hash4Table, n);
    }

    void updateTables(int n) {
        this.hash2Table[this.hash2Value] = n;
        this.hash3Table[this.hash3Value] = n;
        this.hash4Table[this.hash4Value] = n;
    }
}

