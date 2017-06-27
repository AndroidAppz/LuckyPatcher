package org.tukaani.xz.simple;

public final class X86 implements SimpleFilter {
    private static final boolean[] MASK_TO_ALLOWED_STATUS;
    private static final int[] MASK_TO_BIT_NUMBER;
    private final boolean isEncoder;
    private int pos;
    private int prevMask = 0;

    static {
        r0 = new boolean[8];
        MASK_TO_ALLOWED_STATUS = r0;
        int[] iArr = new int[8];
        iArr[1] = 1;
        iArr[2] = 2;
        iArr[3] = 2;
        iArr[4] = 3;
        iArr[5] = 3;
        iArr[6] = 3;
        iArr[7] = 3;
        MASK_TO_BIT_NUMBER = iArr;
    }

    private static boolean test86MSByte(byte b) {
        int i = b & 255;
        return i == 0 || i == 255;
    }

    public X86(boolean isEncoder, int startPos) {
        this.isEncoder = isEncoder;
        this.pos = startPos + 5;
    }

    public int code(byte[] buf, int off, int len) {
        int i = 0;
        int prevPos = off - 1;
        int end = (off + len) - 5;
        int i2 = off;
        while (i2 <= end) {
            if ((buf[i2] & 254) == 232) {
                prevPos = i2 - prevPos;
                if ((prevPos & -4) != 0) {
                    this.prevMask = 0;
                } else {
                    this.prevMask = (this.prevMask << (prevPos - 1)) & 7;
                    if (this.prevMask != 0 && (!MASK_TO_ALLOWED_STATUS[this.prevMask] || test86MSByte(buf[(i2 + 4) - MASK_TO_BIT_NUMBER[this.prevMask]]))) {
                        prevPos = i2;
                        this.prevMask = (this.prevMask << 1) | 1;
                    }
                }
                prevPos = i2;
                if (test86MSByte(buf[i2 + 4])) {
                    int dest;
                    int src = (((buf[i2 + 1] & 255) | ((buf[i2 + 2] & 255) << 8)) | ((buf[i2 + 3] & 255) << 16)) | ((buf[i2 + 4] & 255) << 24);
                    while (true) {
                        if (this.isEncoder) {
                            dest = src + ((this.pos + i2) - off);
                        } else {
                            dest = src - ((this.pos + i2) - off);
                        }
                        if (this.prevMask != 0) {
                            int index = MASK_TO_BIT_NUMBER[this.prevMask] * 8;
                            if (!test86MSByte((byte) (dest >>> (24 - index)))) {
                                break;
                            }
                            src = dest ^ ((1 << (32 - index)) - 1);
                        } else {
                            break;
                        }
                    }
                    buf[i2 + 1] = (byte) dest;
                    buf[i2 + 2] = (byte) (dest >>> 8);
                    buf[i2 + 3] = (byte) (dest >>> 16);
                    buf[i2 + 4] = (byte) ((((dest >>> 24) & 1) - 1) ^ -1);
                    i2 += 4;
                } else {
                    this.prevMask = (this.prevMask << 1) | 1;
                }
            }
            i2++;
        }
        prevPos = i2 - prevPos;
        if ((prevPos & -4) == 0) {
            i = this.prevMask << (prevPos - 1);
        }
        this.prevMask = i;
        i2 -= off;
        this.pos += i2;
        return i2;
    }
}
