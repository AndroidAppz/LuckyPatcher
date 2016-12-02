/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package com.googlecode.dex2jar.reader.io;

import java.io.IOException;

public interface DataOut {
    public void writeByte(int var1) throws IOException;

    public void writeBytes(byte[] var1) throws IOException;

    public void writeInt(int var1) throws IOException;

    public void writeShort(int var1) throws IOException;
}

