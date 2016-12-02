package com.googlecode.dex2jar.reader.io;

import com.chelpus.Common;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Stack;

public class ArrayDataIn extends ByteArrayInputStream implements DataIn {
    private boolean isLE;
    private Stack<Integer> stack = new Stack();

    public static ArrayDataIn be(byte[] data) {
        return new ArrayDataIn(data, false);
    }

    public static ArrayDataIn be(byte[] data, int offset, int length) {
        return new ArrayDataIn(data, offset, length, false);
    }

    public static ArrayDataIn le(byte[] data) {
        return new ArrayDataIn(data, true);
    }

    public static ArrayDataIn le(byte[] data, int offset, int length) {
        return new ArrayDataIn(data, offset, length, true);
    }

    public ArrayDataIn(byte[] data, boolean isLE) {
        super(data);
        this.isLE = isLE;
    }

    public ArrayDataIn(byte[] buf, int offset, int length, boolean isLE) {
        super(buf, offset, length);
        this.isLE = isLE;
    }

    public int getCurrentPosition() {
        return this.pos - this.mark;
    }

    public void move(int absOffset) {
        this.pos = this.mark + absOffset;
    }

    public void pop() {
        this.pos = ((Integer) this.stack.pop()).intValue();
    }

    public void push() {
        this.stack.push(Integer.valueOf(this.pos));
    }

    public void pushMove(int absOffset) {
        push();
        move(absOffset);
    }

    public int readByte() {
        return (byte) readUByte();
    }

    public byte[] readBytes(int size) {
        byte[] data = new byte[size];
        try {
            super.read(data);
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int readIntx() {
        return readUIntx();
    }

    public long readLeb128() {
        int bitpos = 0;
        long vln = 0;
        int inp;
        do {
            inp = readUByte();
            vln |= ((long) (inp & 127)) << bitpos;
            bitpos += 7;
        } while ((inp & Common.INSTALL_ALLOW_DOWNGRADE) != 0);
        if (((1 << (bitpos - 1)) & vln) != 0) {
            return vln - (1 << bitpos);
        }
        return vln;
    }

    public int readShortx() {
        return (short) readUShortx();
    }

    public int readUByte() {
        if (this.pos < this.count) {
            return super.read();
        }
        throw new RuntimeException("EOF");
    }

    public int readUIntx() {
        if (this.isLE) {
            return ((readUByte() | (readUByte() << 8)) | (readUByte() << 16)) | (readUByte() << 24);
        }
        return (((readUByte() << 24) | (readUByte() << 16)) | (readUByte() << 8)) | readUByte();
    }

    public long readULeb128() {
        long value = 0;
        int count = 0;
        int b = readUByte();
        while ((b & Common.INSTALL_ALLOW_DOWNGRADE) != 0) {
            value |= (long) ((b & 127) << count);
            count += 7;
            b = readUByte();
        }
        return value | ((long) ((b & 127) << count));
    }

    public int readUShortx() {
        if (this.isLE) {
            return readUByte() | (readUByte() << 8);
        }
        return (readUByte() << 8) | readUByte();
    }

    public void skip(int bytes) {
        super.skip((long) bytes);
    }
}
