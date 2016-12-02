/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 */
package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.BaseInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.unzip.UnzipEngine;

public class PartInputStream
extends BaseInputStream {
    private byte[] aesBlockByte;
    private int aesBytesReturned;
    private long bytesRead;
    private int count;
    private IDecrypter decrypter;
    private boolean isAESEncryptedFile;
    private long length;
    private byte[] oneByteBuff;
    private RandomAccessFile raf;
    private UnzipEngine unzipEngine;

    /*
     * Enabled aggressive block sorting
     */
    public PartInputStream(RandomAccessFile randomAccessFile, long l, long l2, UnzipEngine unzipEngine) {
        int n = 1;
        this.oneByteBuff = new byte[n];
        this.aesBlockByte = new byte[16];
        this.aesBytesReturned = 0;
        this.isAESEncryptedFile = false;
        this.count = -1;
        this.raf = randomAccessFile;
        this.unzipEngine = unzipEngine;
        this.decrypter = unzipEngine.getDecrypter();
        this.bytesRead = 0;
        this.length = l2;
        if (!unzipEngine.getFileHeader().isEncrypted() || unzipEngine.getFileHeader().getEncryptionMethod() != 99) {
            n = 0;
        }
        this.isAESEncryptedFile = n;
    }

    @Override
    public int available() {
        long l = this.length - this.bytesRead;
        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)l;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void checkAndReadAESMacBytes() throws IOException {
        if (!this.isAESEncryptedFile || this.decrypter == null || !(this.decrypter instanceof AESDecrypter) || ((AESDecrypter)this.decrypter).getStoredMac() != null) {
            return;
        }
        byte[] arrby = new byte[10];
        int n = this.raf.read(arrby);
        if (n != 10) {
            if (!this.unzipEngine.getZipModel().isSplitArchive()) throw new IOException("Error occured while reading stored AES authentication bytes");
            this.raf.close();
            this.raf = this.unzipEngine.startNextSplitFile();
            n + this.raf.read(arrby, n, 10 - n);
        }
        ((AESDecrypter)this.unzipEngine.getDecrypter()).setStoredMac(arrby);
    }

    public void close() throws IOException {
        this.raf.close();
    }

    @Override
    public UnzipEngine getUnzipEngine() {
        return this.unzipEngine;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public int read() throws IOException {
        if (this.bytesRead >= this.length) {
            return -1;
        }
        if (!this.isAESEncryptedFile) {
            if (this.read(this.oneByteBuff, 0, 1) == -1) return -1;
            return 255 & this.oneByteBuff[0];
        }
        if (this.aesBytesReturned == 0 || this.aesBytesReturned == 16) {
            if (this.read(this.aesBlockByte) == -1) return -1;
            this.aesBytesReturned = 0;
        }
        byte[] arrby = this.aesBlockByte;
        int n = this.aesBytesReturned;
        this.aesBytesReturned = n + 1;
        return 255 & arrby[n];
    }

    public int read(byte[] arrby) throws IOException {
        return this.read(arrby, 0, arrby.length);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public int read(byte[] arrby, int n, int n2) throws IOException {
        RandomAccessFile randomAccessFile;
        if ((long)n2 > this.length - this.bytesRead && (n2 = (int)(this.length - this.bytesRead)) == 0) {
            this.checkAndReadAESMacBytes();
            return -1;
        }
        if (this.unzipEngine.getDecrypter() instanceof AESDecrypter && this.bytesRead + (long)n2 < this.length && n2 % 16 != 0) {
            n2 -= n2 % 16;
        }
        RandomAccessFile randomAccessFile2 = randomAccessFile = this.raf;
        // MONITORENTER : randomAccessFile2
        this.count = this.raf.read(arrby, n, n2);
        if (this.count < n2 && this.unzipEngine.getZipModel().isSplitArchive()) {
            int n3;
            this.raf.close();
            this.raf = this.unzipEngine.startNextSplitFile();
            if (this.count < 0) {
                this.count = 0;
            }
            if ((n3 = this.raf.read(arrby, this.count, n2 - this.count)) > 0) {
                this.count = n3 + this.count;
            }
        }
        // MONITOREXIT : randomAccessFile2
        if (this.count > 0) {
            if (this.decrypter != null) {
                this.decrypter.decryptData(arrby, n, this.count);
            }
            this.bytesRead += (long)this.count;
        }
        if (this.bytesRead < this.length) return this.count;
        this.checkAndReadAESMacBytes();
        return this.count;
        catch (ZipException zipException) {
            throw new IOException(zipException.getMessage());
        }
    }

    @Override
    public void seek(long l) throws IOException {
        this.raf.seek(l);
    }

    public long skip(long l) throws IOException {
        if (l < 0) {
            throw new IllegalArgumentException();
        }
        if (l > this.length - this.bytesRead) {
            l = this.length - this.bytesRead;
        }
        this.bytesRead = l + this.bytesRead;
        return l;
    }
}

