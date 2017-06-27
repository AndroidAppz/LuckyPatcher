package org.tukaani.xz;

public class XZ {
    public static final int CHECK_CRC32 = 1;
    public static final int CHECK_CRC64 = 4;
    public static final int CHECK_NONE = 0;
    public static final int CHECK_SHA256 = 10;
    public static final byte[] FOOTER_MAGIC = new byte[]{(byte) 89, (byte) 90};
    public static final byte[] HEADER_MAGIC;

    static {
        byte[] bArr = new byte[6];
        bArr[CHECK_NONE] = (byte) -3;
        bArr[CHECK_CRC32] = (byte) 55;
        bArr[2] = (byte) 122;
        bArr[3] = (byte) 88;
        bArr[CHECK_CRC64] = (byte) 90;
        HEADER_MAGIC = bArr;
    }

    private XZ() {
    }
}
