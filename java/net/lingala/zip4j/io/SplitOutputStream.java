/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.RandomAccessFile
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 */
package net.lingala.zip4j.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

public class SplitOutputStream
extends OutputStream {
    private long bytesWrittenForThisPart;
    private int currSplitFileCounter;
    private File outFile;
    private RandomAccessFile raf;
    private long splitLength;
    private File zipFile;

    public SplitOutputStream(File file) throws FileNotFoundException, ZipException {
        super(file, -1);
    }

    public SplitOutputStream(File file, long l) throws FileNotFoundException, ZipException {
        if (l >= 0 && l < 65536) {
            throw new ZipException("split length less than minimum allowed split length of 65536 Bytes");
        }
        this.raf = new RandomAccessFile(file, "rw");
        this.splitLength = l;
        this.outFile = file;
        this.zipFile = file;
        this.currSplitFileCounter = 0;
        this.bytesWrittenForThisPart = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public SplitOutputStream(String string) throws FileNotFoundException, ZipException {
        File file = Zip4jUtil.isStringNotNullAndNotEmpty(string) ? new File(string) : null;
        super(file);
    }

    /*
     * Enabled aggressive block sorting
     */
    public SplitOutputStream(String string, long l) throws FileNotFoundException, ZipException {
        File file = !Zip4jUtil.isStringNotNullAndNotEmpty(string) ? new File(string) : null;
        super(file, l);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean isHeaderData(byte[] arrby) {
        if (arrby == null) return false;
        if (arrby.length < 4) {
            return false;
        }
        int n = Raw.readIntLittleEndian(arrby, 0);
        long[] arrl = Zip4jUtil.getAllHeaderSignatures();
        if (arrl == null) return false;
        if (arrl.length <= 0) return false;
        int n2 = 0;
        while (n2 < arrl.length) {
            if (arrl[n2] != 134695760 && arrl[n2] == (long)n) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void startNextSplitFile() throws IOException {
        String string;
        File file;
        try {
            String string2 = Zip4jUtil.getZipFileNameWithoutExt(this.outFile.getName());
            string = this.zipFile.getAbsolutePath();
            String string3 = this.outFile.getParent() == null ? "" : this.outFile.getParent() + System.getProperty((String)"file.separator");
            file = this.currSplitFileCounter < 9 ? new File(string3 + string2 + ".z0" + (1 + this.currSplitFileCounter)) : new File(string3 + string2 + ".z" + (1 + this.currSplitFileCounter));
        }
        catch (ZipException var1_5) {
            throw new IOException(var1_5.getMessage());
        }
        this.raf.close();
        if (file.exists()) {
            throw new IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
        }
        if (!this.zipFile.renameTo(file)) {
            throw new IOException("cannot rename newly created split file");
        }
        this.zipFile = new File(string);
        this.raf = new RandomAccessFile(this.zipFile, "rw");
        this.currSplitFileCounter = 1 + this.currSplitFileCounter;
    }

    public boolean checkBuffSizeAndStartNextSplitFile(int n) throws ZipException {
        if (n < 0) {
            throw new ZipException("negative buffersize for checkBuffSizeAndStartNextSplitFile");
        }
        if (!this.isBuffSizeFitForCurrSplitFile(n)) {
            try {
                super.startNextSplitFile();
                this.bytesWrittenForThisPart = 0;
                return true;
            }
            catch (IOException var2_2) {
                throw new ZipException((Throwable)var2_2);
            }
        }
        return false;
    }

    public void close() throws IOException {
        if (this.raf != null) {
            this.raf.close();
        }
    }

    public void flush() throws IOException {
    }

    public int getCurrSplitFileCounter() {
        return this.currSplitFileCounter;
    }

    public long getFilePointer() throws IOException {
        return this.raf.getFilePointer();
    }

    public long getSplitLength() {
        return this.splitLength;
    }

    public boolean isBuffSizeFitForCurrSplitFile(int n) throws ZipException {
        if (n < 0) {
            throw new ZipException("negative buffersize for isBuffSizeFitForCurrSplitFile");
        }
        if (this.splitLength < 65536 || this.bytesWrittenForThisPart + (long)n <= this.splitLength) {
            return true;
        }
        return false;
    }

    public boolean isSplitZipFile() {
        if (this.splitLength != -1) {
            return true;
        }
        return false;
    }

    public void seek(long l) throws IOException {
        this.raf.seek(l);
    }

    public void write(int n) throws IOException {
        byte[] arrby = new byte[]{(byte)n};
        this.write(arrby, 0, 1);
    }

    public void write(byte[] arrby) throws IOException {
        this.write(arrby, 0, arrby.length);
    }

    public void write(byte[] arrby, int n, int n2) throws IOException {
        if (n2 <= 0) {
            return;
        }
        if (this.splitLength != -1) {
            if (this.splitLength < 65536) {
                throw new IOException("split length less than minimum allowed split length of 65536 Bytes");
            }
            if (this.bytesWrittenForThisPart >= this.splitLength) {
                super.startNextSplitFile();
                this.raf.write(arrby, n, n2);
                this.bytesWrittenForThisPart = n2;
                return;
            }
            if (this.bytesWrittenForThisPart + (long)n2 > this.splitLength) {
                if (super.isHeaderData(arrby)) {
                    super.startNextSplitFile();
                    this.raf.write(arrby, n, n2);
                    this.bytesWrittenForThisPart = n2;
                    return;
                }
                this.raf.write(arrby, n, (int)(this.splitLength - this.bytesWrittenForThisPart));
                super.startNextSplitFile();
                this.raf.write(arrby, n + (int)(this.splitLength - this.bytesWrittenForThisPart), (int)((long)n2 - (this.splitLength - this.bytesWrittenForThisPart)));
                this.bytesWrittenForThisPart = (long)n2 - (this.splitLength - this.bytesWrittenForThisPart);
                return;
            }
            this.raf.write(arrby, n, n2);
            this.bytesWrittenForThisPart += (long)n2;
            return;
        }
        this.raf.write(arrby, n, n2);
        this.bytesWrittenForThisPart += (long)n2;
    }
}

