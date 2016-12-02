/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.tukaani.xz.SeekableInputStream;

public class SeekableFileInputStream
extends SeekableInputStream {
    protected RandomAccessFile randomAccessFile;

    public SeekableFileInputStream(File file) throws FileNotFoundException {
        this.randomAccessFile = new RandomAccessFile(file, "r");
    }

    public SeekableFileInputStream(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    public SeekableFileInputStream(String string) throws FileNotFoundException {
        this.randomAccessFile = new RandomAccessFile(string, "r");
    }

    public void close() throws IOException {
        this.randomAccessFile.close();
    }

    @Override
    public long length() throws IOException {
        return this.randomAccessFile.length();
    }

    @Override
    public long position() throws IOException {
        return this.randomAccessFile.getFilePointer();
    }

    public int read() throws IOException {
        return this.randomAccessFile.read();
    }

    public int read(byte[] arrby) throws IOException {
        return this.randomAccessFile.read(arrby);
    }

    public int read(byte[] arrby, int n, int n2) throws IOException {
        return this.randomAccessFile.read(arrby, n, n2);
    }

    @Override
    public void seek(long l) throws IOException {
        this.randomAccessFile.seek(l);
    }
}

