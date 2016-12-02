/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.common;

public class Util {
    public static final long BACKWARD_SIZE_MAX = 0x400000000L;
    public static final int BLOCK_HEADER_SIZE_MAX = 1024;
    public static final int STREAM_HEADER_SIZE = 12;
    public static final long VLI_MAX = Long.MAX_VALUE;
    public static final int VLI_SIZE_MAX = 9;

    public static int getVLISize(long l) {
        int n = 0;
        do {
            ++n;
        } while ((l >>= 7) != 0);
        return n;
    }
}

