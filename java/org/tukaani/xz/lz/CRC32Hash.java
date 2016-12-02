package org.tukaani.xz.lz;

import pxb.android.ResConst;

class CRC32Hash {
    private static final int CRC32_POLY = -306674912;
    static final int[] crcTable = new int[ResConst.RES_XML_START_NAMESPACE_TYPE];

    CRC32Hash() {
    }

    static {
        for (int i = 0; i < ResConst.RES_XML_START_NAMESPACE_TYPE; i++) {
            int r = i;
            for (int j = 0; j < 8; j++) {
                if ((r & 1) != 0) {
                    r = (r >>> 1) ^ CRC32_POLY;
                } else {
                    r >>>= 1;
                }
            }
            crcTable[i] = r;
        }
    }
}
