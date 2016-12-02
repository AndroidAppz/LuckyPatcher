/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.String
 *  java.util.zip.DataFormatException
 *  java.util.zip.Inflater
 */
package net.lingala.zip4j.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import net.lingala.zip4j.io.PartInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.unzip.UnzipEngine;

public class InflaterInputStream
extends PartInputStream {
    private byte[] buff = new byte[4096];
    private long bytesWritten;
    private Inflater inflater = new Inflater(true);
    private byte[] oneByteBuff = new byte[1];
    private long uncompressedSize;
    private UnzipEngine unzipEngine;

    public InflaterInputStream(RandomAccessFile randomAccessFile, long l, long l2, UnzipEngine unzipEngine) {
        super(randomAccessFile, l, l2, unzipEngine);
        this.unzipEngine = unzipEngine;
        this.bytesWritten = 0;
        this.uncompressedSize = unzipEngine.getFileHeader().getUncompressedSize();
    }

    private void fill() throws IOException {
        int n = super.read(this.buff, 0, this.buff.length);
        if (n == -1) {
            throw new EOFException("Unexpected end of ZLIB input stream");
        }
        this.inflater.setInput(this.buff, 0, n);
    }

    private void finishInflating() throws IOException {
        byte[] arrby = new byte[1024];
        while (super.read(arrby, 0, 1024) != -1) {
        }
        this.checkAndReadAESMacBytes();
    }

    @Override
    public int available() {
        if (this.inflater.finished()) {
            return 0;
        }
        return 1;
    }

    @Override
    public void close() throws IOException {
        this.inflater.end();
        super.close();
    }

    @Override
    public UnzipEngine getUnzipEngine() {
        return super.getUnzipEngine();
    }

    @Override
    public int read() throws IOException {
        if (this.read(this.oneByteBuff, 0, 1) == -1) {
            return -1;
        }
        return 255 & this.oneByteBuff[0];
    }

    @Override
    public int read(byte[] arrby) throws IOException {
        if (arrby == null) {
            throw new NullPointerException("input buffer is null");
        }
        return this.read(arrby, 0, arrby.length);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public int read(byte[] arrby, int n, int n2) throws IOException {
        if (arrby == null) {
            throw new NullPointerException("input buffer is null");
        }
        if (n < 0 || n2 < 0 || n2 > arrby.length - n) {
            throw new IndexOutOfBoundsException();
        }
        if (n2 == 0) {
            return 0;
        }
        try {
            if (this.bytesWritten >= this.uncompressedSize) {
                super.finishInflating();
                return -1;
            }
            do {
                int n3;
                if ((n3 = this.inflater.inflate(arrby, n, n2)) != 0) {
                    this.bytesWritten += (long)n3;
                    return n3;
                }
                if (this.inflater.finished() || this.inflater.needsDictionary()) {
                    super.finishInflating();
                    return -1;
                }
                if (!this.inflater.needsInput()) continue;
                super.fill();
            } while (true);
        }
        catch (DataFormatException var4_5) {
            String string = "Invalid ZLIB data format";
            if (var4_5.getMessage() != null) {
                string = var4_5.getMessage();
            }
            if (this.unzipEngine != null && this.unzipEngine.getLocalFileHeader().isEncrypted() && this.unzipEngine.getLocalFileHeader().getEncryptionMethod() == 0) {
                string = string + " - Wrong Password?";
            }
            throw new IOException(string);
        }
    }

    @Override
    public void seek(long l) throws IOException {
        super.seek(l);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long skip(long l) throws IOException {
        if (l < 0) {
            throw new IllegalArgumentException("negative skip length");
        }
        int n = (int)Math.min((long)l, (long)Integer.MAX_VALUE);
        int n2 = 0;
        byte[] arrby = new byte[512];
        while (n2 < n) {
            int n3;
            int n4 = n - n2;
            if (n4 > arrby.length) {
                n4 = arrby.length;
            }
            if ((n3 = this.read(arrby, 0, n4)) == -1) {
                return n2;
            }
            n2 += n3;
        }
        return n2;
    }
}

