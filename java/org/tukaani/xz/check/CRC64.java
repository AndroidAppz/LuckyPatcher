package org.tukaani.xz.check;

import pxb.android.ResConst;

public class CRC64 extends Check {
    private static final long[] crcTable = new long[ResConst.RES_XML_START_NAMESPACE_TYPE];
    private static final long poly = -3932672073523589310L;
    private long crc;

    static {
        for (int b = 0; b < crcTable.length; b++) {
            long r = (long) b;
            for (int i = 0; i < 8; i++) {
                if ((r & 1) == 1) {
                    r = (r >>> 1) ^ poly;
                } else {
                    r >>>= 1;
                }
            }
            crcTable[b] = r;
        }
    }

    public CRC64() {
        this.crc = -1;
        this.size = 8;
        this.name = "CRC64";
    }

    public void update(byte[] buf, int off, int len) {
        int end = off + len;
        int off2 = off;
        while (off2 < end) {
            off = off2 + 1;
            this.crc = crcTable[(buf[off2] ^ ((int) this.crc)) & 255] ^ (this.crc >>> 8);
            off2 = off;
        }
    }

    public byte[] finish() {
        long value = this.crc ^ -1;
        this.crc = -1;
        byte[] buf = new byte[8];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = (byte) ((int) (value >> (i * 8)));
        }
        return buf;
    }
}
