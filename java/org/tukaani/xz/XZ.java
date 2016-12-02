package org.tukaani.xz;

public class XZ {
    public static final int CHECK_CRC32 = 1;
    public static final int CHECK_CRC64 = 4;
    public static final int CHECK_NONE = 0;
    public static final int CHECK_SHA256 = 10;
    public static final byte[] FOOTER_MAGIC = new byte[]{(byte) 89, (byte) 90};
    public static final byte[] HEADER_MAGIC = new byte[]{(byte) -3, (byte) 55, (byte) 122, (byte) 88, (byte) 90, (byte) 0};

    private XZ() {
    }
}
