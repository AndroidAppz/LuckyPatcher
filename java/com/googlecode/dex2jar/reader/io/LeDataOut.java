/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 */
package com.googlecode.dex2jar.reader.io;

import com.googlecode.dex2jar.reader.io.DataOut;
import java.io.IOException;
import java.io.OutputStream;

public class LeDataOut
implements DataOut {
    private OutputStream os;

    public LeDataOut(OutputStream outputStream) {
        this.os = outputStream;
    }

    @Override
    public void writeByte(int n) throws IOException {
        this.os.write(n);
    }

    @Override
    public void writeBytes(byte[] arrby) throws IOException {
        this.os.write(arrby);
    }

    @Override
    public void writeInt(int n) throws IOException {
        this.os.write(n);
        this.os.write(n >> 8);
        this.os.write(n >> 16);
        this.os.write(n >>> 24);
    }

    @Override
    public void writeShort(int n) throws IOException {
        this.os.write(n);
        this.os.write(n >> 8);
    }
}

