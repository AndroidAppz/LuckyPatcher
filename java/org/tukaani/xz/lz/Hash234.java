package org.tukaani.xz.lz;

import pxb.android.ResConst;

final class Hash234 extends CRC32Hash {
    private static final int HASH_2_MASK = 1023;
    private static final int HASH_2_SIZE = 1024;
    private static final int HASH_3_MASK = 65535;
    private static final int HASH_3_SIZE = 65536;
    private final int[] hash2Table = new int[HASH_2_SIZE];
    private int hash2Value = 0;
    private final int[] hash3Table = new int[HASH_3_SIZE];
    private int hash3Value = 0;
    private final int hash4Mask;
    private final int[] hash4Table;
    private int hash4Value = 0;

    static int getHash4Size(int dictSize) {
        int h = dictSize - 1;
        h |= h >>> 1;
        h |= h >>> 2;
        h |= h >>> 4;
        h = ((h | (h >>> 8)) >>> 1) | HASH_3_MASK;
        if (h > 16777216) {
            h >>>= 1;
        }
        return h + 1;
    }

    static int getMemoryUsage(int dictSize) {
        return ((66560 + getHash4Size(dictSize)) / ResConst.RES_XML_START_NAMESPACE_TYPE) + 4;
    }

    Hash234(int dictSize) {
        this.hash4Table = new int[getHash4Size(dictSize)];
        this.hash4Mask = this.hash4Table.length - 1;
    }

    void calcHashes(byte[] buf, int off) {
        int temp = crcTable[buf[off] & 255] ^ (buf[off + 1] & 255);
        this.hash2Value = temp & HASH_2_MASK;
        temp ^= (buf[off + 2] & 255) << 8;
        this.hash3Value = HASH_3_MASK & temp;
        this.hash4Value = this.hash4Mask & (temp ^ (crcTable[buf[off + 3] & 255] << 5));
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

    void updateTables(int pos) {
        this.hash2Table[this.hash2Value] = pos;
        this.hash3Table[this.hash3Value] = pos;
        this.hash4Table[this.hash4Value] = pos;
    }

    void normalize(int normalizeOffset) {
        LZEncoder.normalize(this.hash2Table, normalizeOffset);
        LZEncoder.normalize(this.hash3Table, normalizeOffset);
        LZEncoder.normalize(this.hash4Table, normalizeOffset);
    }
}
