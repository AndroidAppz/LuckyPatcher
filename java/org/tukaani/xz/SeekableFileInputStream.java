package org.tukaani.xz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.util.InternalZipConstants;

public class SeekableFileInputStream extends SeekableInputStream {
    protected RandomAccessFile randomAccessFile;

    public SeekableFileInputStream(File file) throws FileNotFoundException {
        this.randomAccessFile = new RandomAccessFile(file, InternalZipConstants.READ_MODE);
    }

    public SeekableFileInputStream(String name) throws FileNotFoundException {
        this.randomAccessFile = new RandomAccessFile(name, InternalZipConstants.READ_MODE);
    }

    public SeekableFileInputStream(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    public int read() throws IOException {
        return this.randomAccessFile.read();
    }

    public int read(byte[] buf) throws IOException {
        return this.randomAccessFile.read(buf);
    }

    public int read(byte[] buf, int off, int len) throws IOException {
        return this.randomAccessFile.read(buf, off, len);
    }

    public void close() throws IOException {
        this.randomAccessFile.close();
    }

    public long length() throws IOException {
        return this.randomAccessFile.length();
    }

    public long position() throws IOException {
        return this.randomAccessFile.getFilePointer();
    }

    public void seek(long pos) throws IOException {
        this.randomAccessFile.seek(pos);
    }
}
