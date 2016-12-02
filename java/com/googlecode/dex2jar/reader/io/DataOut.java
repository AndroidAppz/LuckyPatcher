package com.googlecode.dex2jar.reader.io;

import java.io.IOException;

public interface DataOut {
    void writeByte(int i) throws IOException;

    void writeBytes(byte[] bArr) throws IOException;

    void writeInt(int i) throws IOException;

    void writeShort(int i) throws IOException;
}
