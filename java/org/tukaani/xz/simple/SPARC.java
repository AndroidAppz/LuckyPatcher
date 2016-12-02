package org.tukaani.xz.simple;

public final class SPARC implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public SPARC(boolean isEncoder, int startPos) {
        this.isEncoder = isEncoder;
        this.pos = startPos;
    }

    public int code(byte[] buf, int off, int len) {
        int end = (off + len) - 4;
        int i = off;
        while (i <= end) {
            if ((buf[i] == (byte) 64 && (buf[i + 1] & 192) == 0) || (buf[i] == Byte.MAX_VALUE && (buf[i + 1] & 192) == 192)) {
                int dest;
                int src = (((((buf[i] & 255) << 24) | ((buf[i + 1] & 255) << 16)) | ((buf[i + 2] & 255) << 8)) | (buf[i + 3] & 255)) << 2;
                if (this.isEncoder) {
                    dest = src + ((this.pos + i) - off);
                } else {
                    dest = src - ((this.pos + i) - off);
                }
                dest >>>= 2;
                dest = ((((0 - ((dest >>> 22) & 1)) << 22) & 1073741823) | (4194303 & dest)) | 1073741824;
                buf[i] = (byte) (dest >>> 24);
                buf[i + 1] = (byte) (dest >>> 16);
                buf[i + 2] = (byte) (dest >>> 8);
                buf[i + 3] = (byte) dest;
            }
            i += 4;
        }
        i -= off;
        this.pos += i;
        return i;
    }
}
