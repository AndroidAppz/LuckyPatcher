package com.googlecode.dex2jar.reader.io;

import java.io.IOException;
import java.io.OutputStream;

public class LeDataOut implements DataOut {
    private OutputStream os;

    public LeDataOut(OutputStream os) {
        this.os = os;
    }

    public void writeByte(int v) throws IOException {
        this.os.write(v);
    }

    public void writeBytes(byte[] bs) throws IOException {
        this.os.write(bs);
    }

    public void writeInt(int v) throws IOException {
        this.os.write(v);
        this.os.write(v >> 8);
        this.os.write(v >> 16);
        this.os.write(v >>> 24);
    }

    public void writeShort(int v) throws IOException {
        this.os.write(v);
        this.os.write(v >> 8);
    }
}
