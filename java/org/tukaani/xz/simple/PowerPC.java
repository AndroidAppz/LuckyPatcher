package org.tukaani.xz.simple;

public final class PowerPC implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public PowerPC(boolean isEncoder, int startPos) {
        this.isEncoder = isEncoder;
        this.pos = startPos;
    }

    public int code(byte[] buf, int off, int len) {
        int end = (off + len) - 4;
        int i = off;
        while (i <= end) {
            if ((buf[i] & 252) == 72 && (buf[i + 3] & 3) == 1) {
                int dest;
                int src = ((((buf[i] & 3) << 24) | ((buf[i + 1] & 255) << 16)) | ((buf[i + 2] & 255) << 8)) | (buf[i + 3] & 252);
                if (this.isEncoder) {
                    dest = src + ((this.pos + i) - off);
                } else {
                    dest = src - ((this.pos + i) - off);
                }
                buf[i] = (byte) (((dest >>> 24) & 3) | 72);
                buf[i + 1] = (byte) (dest >>> 16);
                buf[i + 2] = (byte) (dest >>> 8);
                buf[i + 3] = (byte) ((buf[i + 3] & 3) | dest);
            }
            i += 4;
        }
        i -= off;
        this.pos += i;
        return i;
    }
}
