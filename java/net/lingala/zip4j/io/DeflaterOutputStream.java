/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.String
 *  java.util.zip.Deflater
 */
package net.lingala.zip4j.io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.CipherOutputStream;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;

public class DeflaterOutputStream
extends CipherOutputStream {
    private byte[] buff = new byte[4096];
    protected Deflater deflater = new Deflater();
    private boolean firstBytesRead = false;

    public DeflaterOutputStream(OutputStream outputStream, ZipModel zipModel) {
        super(outputStream, zipModel);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void deflate() throws IOException {
        int n = this.deflater.deflate(this.buff, 0, this.buff.length);
        if (n <= 0) return;
        if (this.deflater.finished()) {
            if (n == 4) {
                return;
            }
            if (n < 4) {
                this.decrementCompressedFileSize(4 - n);
                return;
            }
            n -= 4;
        }
        if (!this.firstBytesRead) {
            super.write(this.buff, 2, n - 2);
            this.firstBytesRead = true;
            return;
        }
        super.write(this.buff, 0, n);
    }

    @Override
    public void closeEntry() throws IOException, ZipException {
        if (this.zipParameters.getCompressionMethod() == 8) {
            if (!this.deflater.finished()) {
                this.deflater.finish();
                while (!this.deflater.finished()) {
                    this.deflate();
                }
            }
            this.firstBytesRead = false;
        }
        super.closeEntry();
    }

    @Override
    public void finish() throws IOException, ZipException {
        super.finish();
    }

    @Override
    public void putNextEntry(File file, ZipParameters zipParameters) throws ZipException {
        super.putNextEntry(file, zipParameters);
        if (zipParameters.getCompressionMethod() == 8) {
            this.deflater.reset();
            if ((zipParameters.getCompressionLevel() < 0 || zipParameters.getCompressionLevel() > 9) && zipParameters.getCompressionLevel() != -1) {
                throw new ZipException("invalid compression level for deflater. compression level should be in the range of 0-9");
            }
            this.deflater.setLevel(zipParameters.getCompressionLevel());
        }
    }

    @Override
    public void write(int n) throws IOException {
        byte[] arrby = new byte[]{(byte)n};
        this.write(arrby, 0, 1);
    }

    @Override
    public void write(byte[] arrby) throws IOException {
        this.write(arrby, 0, arrby.length);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void write(byte[] arrby, int n, int n2) throws IOException {
        if (this.zipParameters.getCompressionMethod() != 8) {
            super.write(arrby, n, n2);
            return;
        } else {
            this.deflater.setInput(arrby, n, n2);
            while (!this.deflater.needsInput()) {
                super.deflate();
            }
        }
    }
}

