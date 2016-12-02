/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz;

public class XZ {
    public static final int CHECK_CRC32 = 1;
    public static final int CHECK_CRC64 = 4;
    public static final int CHECK_NONE = 0;
    public static final int CHECK_SHA256 = 10;
    public static final byte[] FOOTER_MAGIC;
    public static final byte[] HEADER_MAGIC;

    static {
        HEADER_MAGIC = new byte[]{-3, 55, 122, 88, 90, 0};
        FOOTER_MAGIC = new byte[]{89, 90};
    }

    private XZ() {
    }
}

