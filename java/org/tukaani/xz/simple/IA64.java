package org.tukaani.xz.simple;

public final class IA64 implements SimpleFilter {
    private static final int[] BRANCH_TABLE;
    private final boolean isEncoder;
    private int pos;

    static {
        int[] iArr = new int[32];
        iArr[16] = 4;
        iArr[17] = 4;
        iArr[18] = 6;
        iArr[19] = 6;
        iArr[22] = 7;
        iArr[23] = 7;
        iArr[24] = 4;
        iArr[25] = 4;
        iArr[28] = 4;
        iArr[29] = 4;
        BRANCH_TABLE = iArr;
    }

    public IA64(boolean isEncoder, int startPos) {
        this.isEncoder = isEncoder;
        this.pos = startPos;
    }

    public int code(byte[] buf, int off, int len) {
        int end = (off + len) - 16;
        int i = off;
        while (i <= end) {
            int mask = BRANCH_TABLE[buf[i] & 31];
            int slot = 0;
            int bitPos = 5;
            while (slot < 3) {
                if (((mask >>> slot) & 1) != 0) {
                    int j;
                    int bytePos = bitPos >>> 3;
                    int bitRes = bitPos & 7;
                    long instr = 0;
                    for (j = 0; j < 6; j++) {
                        instr |= (((long) buf[(i + bytePos) + j]) & 255) << (j * 8);
                    }
                    long instrNorm = instr >>> bitRes;
                    if (((instrNorm >>> 37) & 15) == 5 && ((instrNorm >>> 9) & 7) == 0) {
                        int dest;
                        int src = (((int) ((instrNorm >>> 13) & 1048575)) | ((((int) (instrNorm >>> 36)) & 1) << 20)) << 4;
                        if (this.isEncoder) {
                            dest = src + ((this.pos + i) - off);
                        } else {
                            dest = src - ((this.pos + i) - off);
                        }
                        dest >>>= 4;
                        instr = (instr & ((long) ((1 << bitRes) - 1))) | ((((instrNorm & -77309403137L) | ((((long) dest) & 1048575) << 13)) | ((((long) dest) & 1048576) << 16)) << bitRes);
                        for (j = 0; j < 6; j++) {
                            buf[(i + bytePos) + j] = (byte) ((int) (instr >>> (j * 8)));
                        }
                    }
                }
                slot++;
                bitPos += 41;
            }
            i += 16;
        }
        i -= off;
        this.pos += i;
        return i;
    }
}
