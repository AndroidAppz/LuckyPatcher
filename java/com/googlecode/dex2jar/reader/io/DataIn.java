/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.googlecode.dex2jar.reader.io;

public interface DataIn {
    public int getCurrentPosition();

    public void move(int var1);

    public void pop();

    public void push();

    public void pushMove(int var1);

    public int readByte();

    public byte[] readBytes(int var1);

    public int readIntx();

    public long readLeb128();

    public int readShortx();

    public int readUByte();

    public int readUIntx();

    public long readULeb128();

    public int readUShortx();

    public void skip(int var1);
}

