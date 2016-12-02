/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.util.zip.CRC32
 */
package org.tukaani.xz.check;

import org.tukaani.xz.check.Check;

public class CRC32
extends Check {
    private final java.util.zip.CRC32 state = new java.util.zip.CRC32();

    public CRC32() {
        this.size = 4;
        this.name = "CRC32";
    }

    @Override
    public byte[] finish() {
        long l = this.state.getValue();
        byte[] arrby = new byte[]{(byte)l, (byte)(l >>> 8), (byte)(l >>> 16), (byte)(l >>> 24)};
        this.state.reset();
        return arrby;
    }

    @Override
    public void update(byte[] arrby, int n, int n2) {
        this.state.update(arrby, n, n2);
    }
}

