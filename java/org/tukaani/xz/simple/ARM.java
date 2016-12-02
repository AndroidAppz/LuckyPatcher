package org.tukaani.xz.simple;

public final class ARM implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public ARM(boolean isEncoder, int startPos) {
        this.isEncoder = isEncoder;
        this.pos = startPos + 8;
    }

    public int code(byte[] buf, int off, int len) {
        int end = (off + len) - 4;
        int i = off;
        while (i <= end) {
            if ((buf[i + 3] & 255) == 235) {
                int dest;
                int src = ((((buf[i + 2] & 255) << 16) | ((buf[i + 1] & 255) << 8)) | (buf[i] & 255)) << 2;
                if (this.isEncoder) {
                    dest = src + ((this.pos + i) - off);
                } else {
                    dest = src - ((this.pos + i) - off);
                }
                dest >>>= 2;
                buf[i + 2] = (byte) (dest >>> 16);
                buf[i + 1] = (byte) (dest >>> 8);
                buf[i] = (byte) dest;
            }
            i += 4;
        }
        i -= off;
        this.pos += i;
        return i;
    }
}
