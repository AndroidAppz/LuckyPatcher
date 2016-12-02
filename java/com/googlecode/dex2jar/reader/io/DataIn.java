package com.googlecode.dex2jar.reader.io;

public interface DataIn {
    int getCurrentPosition();

    void move(int i);

    void pop();

    void push();

    void pushMove(int i);

    int readByte();

    byte[] readBytes(int i);

    int readIntx();

    long readLeb128();

    int readShortx();

    int readUByte();

    int readUIntx();

    long readULeb128();

    int readUShortx();

    void skip(int i);
}
