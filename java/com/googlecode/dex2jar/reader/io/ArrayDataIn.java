/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Stack
 */
package com.googlecode.dex2jar.reader.io;

import com.googlecode.dex2jar.reader.io.DataIn;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Stack;

public class ArrayDataIn
extends ByteArrayInputStream
implements DataIn {
    private boolean isLE;
    private Stack<Integer> stack;

    public ArrayDataIn(byte[] arrby, int n, int n2, boolean bl) {
        super(arrby, n, n2);
        this.stack = new Stack();
        this.isLE = bl;
    }

    public ArrayDataIn(byte[] arrby, boolean bl) {
        super(arrby);
        this.stack = new Stack();
        this.isLE = bl;
    }

    public static ArrayDataIn be(byte[] arrby) {
        return new ArrayDataIn(arrby, false);
    }

    public static ArrayDataIn be(byte[] arrby, int n, int n2) {
        return new ArrayDataIn(arrby, n, n2, false);
    }

    public static ArrayDataIn le(byte[] arrby) {
        return new ArrayDataIn(arrby, true);
    }

    public static ArrayDataIn le(byte[] arrby, int n, int n2) {
        return new ArrayDataIn(arrby, n, n2, true);
    }

    @Override
    public int getCurrentPosition() {
        return this.pos - this.mark;
    }

    @Override
    public void move(int n) {
        this.pos = n + this.mark;
    }

    @Override
    public void pop() {
        this.pos = (Integer)this.stack.pop();
    }

    @Override
    public void push() {
        this.stack.push((Object)this.pos);
    }

    @Override
    public void pushMove(int n) {
        this.push();
        this.move(n);
    }

    @Override
    public int readByte() {
        return (byte)this.readUByte();
    }

    @Override
    public byte[] readBytes(int n) {
        byte[] arrby = new byte[n];
        try {
            super.read(arrby);
            return arrby;
        }
        catch (IOException var3_3) {
            throw new RuntimeException((Throwable)var3_3);
        }
    }

    @Override
    public int readIntx() {
        return this.readUIntx();
    }

    @Override
    public long readLeb128() {
        int n;
        int n2 = 0;
        long l = 0;
        do {
            n = this.readUByte();
            l |= (long)(n & 127) << n2;
            n2 += 7;
        } while ((n & 128) != 0);
        if ((l & 1 << n2 - 1) != 0) {
            l -= 1 << n2;
        }
        return l;
    }

    @Override
    public int readShortx() {
        return (short)this.readUShortx();
    }

    @Override
    public int readUByte() {
        if (this.pos >= this.count) {
            throw new RuntimeException("EOF");
        }
        return super.read();
    }

    @Override
    public int readUIntx() {
        if (this.isLE) {
            return this.readUByte() | this.readUByte() << 8 | this.readUByte() << 16 | this.readUByte() << 24;
        }
        return this.readUByte() << 24 | this.readUByte() << 16 | this.readUByte() << 8 | this.readUByte();
    }

    @Override
    public long readULeb128() {
        long l = 0;
        int n = 0;
        int n2 = this.readUByte();
        while ((n2 & 128) != 0) {
            l |= (long)((n2 & 127) << n);
            n += 7;
            n2 = this.readUByte();
        }
        return l | (long)((n2 & 127) << n);
    }

    @Override
    public int readUShortx() {
        if (this.isLE) {
            return this.readUByte() | this.readUByte() << 8;
        }
        return this.readUByte() << 8 | this.readUByte();
    }

    @Override
    public void skip(int n) {
        super.skip((long)n);
    }
}

