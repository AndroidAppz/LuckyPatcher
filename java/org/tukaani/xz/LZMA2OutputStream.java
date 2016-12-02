/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lzma.LZMAEncoder;
import org.tukaani.xz.rangecoder.RangeEncoder;

class LZMA2OutputStream
extends FinishableOutputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int COMPRESSED_SIZE_MAX = 65536;
    private boolean dictResetNeeded = true;
    private IOException exception = null;
    private boolean finished = false;
    private final LZEncoder lz;
    private final LZMAEncoder lzma;
    private FinishableOutputStream out;
    private final DataOutputStream outData;
    private int pendingSize = 0;
    private final int props;
    private boolean propsNeeded = true;
    private final RangeEncoder rc;
    private boolean stateResetNeeded = true;
    private final byte[] tempBuf = new byte[1];

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !LZMA2OutputStream.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    LZMA2OutputStream(FinishableOutputStream finishableOutputStream, LZMA2Options lZMA2Options) {
        if (finishableOutputStream == null) {
            throw new NullPointerException();
        }
        this.out = finishableOutputStream;
        this.outData = new DataOutputStream((OutputStream)finishableOutputStream);
        this.rc = new RangeEncoder(65536);
        int n = lZMA2Options.getDictSize();
        int n2 = LZMA2OutputStream.getExtraSizeBefore(n);
        this.lzma = LZMAEncoder.getInstance(this.rc, lZMA2Options.getLc(), lZMA2Options.getLp(), lZMA2Options.getPb(), lZMA2Options.getMode(), n, n2, lZMA2Options.getNiceLen(), lZMA2Options.getMatchFinder(), lZMA2Options.getDepthLimit());
        this.lz = this.lzma.getLZEncoder();
        byte[] arrby = lZMA2Options.getPresetDict();
        if (arrby != null && arrby.length > 0) {
            this.lz.setPresetDict(n, arrby);
            this.dictResetNeeded = false;
        }
        this.props = 9 * (5 * lZMA2Options.getPb() + lZMA2Options.getLp()) + lZMA2Options.getLc();
    }

    private static int getExtraSizeBefore(int n) {
        if (65536 > n) {
            return 65536 - n;
        }
        return 0;
    }

    static int getMemoryUsage(LZMA2Options lZMA2Options) {
        int n = lZMA2Options.getDictSize();
        int n2 = LZMA2OutputStream.getExtraSizeBefore(n);
        return 70 + LZMAEncoder.getMemoryUsage(lZMA2Options.getMode(), n, n2, lZMA2Options.getMatchFinder());
    }

    /*
     * Enabled aggressive block sorting
     */
    private void writeChunk() throws IOException {
        int n = this.rc.finish();
        int n2 = this.lzma.getUncompressedSize();
        if (!$assertionsDisabled && n <= 0) {
            throw new AssertionError(n);
        }
        if (!$assertionsDisabled && n2 <= 0) {
            throw new AssertionError(n2);
        }
        if (n + 2 < n2) {
            this.writeLZMA(n2, n);
        } else {
            this.lzma.reset();
            n2 = this.lzma.getUncompressedSize();
            if (!$assertionsDisabled && n2 <= 0) {
                throw new AssertionError(n2);
            }
            this.writeUncompressed(n2);
        }
        this.pendingSize -= n2;
        this.lzma.resetUncompressedSize();
        this.rc.reset();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void writeEndMarker() throws IOException {
        if (!$assertionsDisabled && this.finished) {
            throw new AssertionError();
        }
        if (this.exception != null) {
            throw this.exception;
        }
        this.lz.setFinishing();
        try {
            while (this.pendingSize > 0) {
                this.lzma.encodeForLZMA2();
                this.writeChunk();
            }
            this.out.write(0);
        }
        catch (IOException var1_1) {
            this.exception = var1_1;
            throw var1_1;
        }
        this.finished = true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void writeLZMA(int n, int n2) throws IOException {
        int n3 = this.propsNeeded ? (this.dictResetNeeded ? 224 : 192) : (this.stateResetNeeded ? 160 : 128);
        int n4 = n3 | n - 1 >>> 16;
        this.outData.writeByte(n4);
        this.outData.writeShort(n - 1);
        this.outData.writeShort(n2 - 1);
        if (this.propsNeeded) {
            this.outData.writeByte(this.props);
        }
        this.rc.write(this.out);
        this.propsNeeded = false;
        this.stateResetNeeded = false;
        this.dictResetNeeded = false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void writeUncompressed(int n) throws IOException {
        do {
            if (n <= 0) {
                this.stateResetNeeded = true;
                return;
            }
            int n2 = Math.min((int)n, (int)65536);
            DataOutputStream dataOutputStream = this.outData;
            int n3 = this.dictResetNeeded ? 1 : 2;
            dataOutputStream.writeByte(n3);
            this.outData.writeShort(n2 - 1);
            this.lz.copyUncompressed(this.out, n, n2);
            n -= n2;
            this.dictResetNeeded = false;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void close() throws IOException {
        if (this.out == null) ** GOTO lbl14
        if (!this.finished) {
            this.writeEndMarker();
        }
lbl5: // 4 sources:
        do {
            try {
                this.out.close();
            }
            catch (IOException var1_1) {
                if (this.exception != null) ** GOTO lbl12
                this.exception = var1_1;
                ** continue;
            }
lbl12: // 3 sources:
            do {
                this.out = null;
lbl14: // 2 sources:
                if (this.exception == null) return;
                throw this.exception;
                break;
            } while (true);
            break;
        } while (true);
        catch (IOException var2_2) {
            ** continue;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void finish() throws IOException {
        if (this.finished) return;
        this.writeEndMarker();
        try {
            this.out.finish();
        }
        catch (IOException iOException) {
            this.exception = iOException;
            throw iOException;
        }
        this.finished = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void flush() throws IOException {
        if (this.exception != null) {
            throw this.exception;
        }
        if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        }
        try {
            this.lz.setFlushing();
            while (this.pendingSize > 0) {
                this.lzma.encodeForLZMA2();
                this.writeChunk();
            }
            this.out.flush();
            return;
        }
        catch (IOException var1_1) {
            this.exception = var1_1;
            throw var1_1;
        }
    }

    public void write(int n) throws IOException {
        this.tempBuf[0] = (byte)n;
        this.write(this.tempBuf, 0, 1);
    }

    public void write(byte[] arrby, int n, int n2) throws IOException {
        if (n < 0 || n2 < 0 || n + n2 < 0 || n + n2 > arrby.length) {
            throw new IndexOutOfBoundsException();
        }
        if (this.exception != null) {
            throw this.exception;
        }
        if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        }
        while (n2 > 0) {
            int n3;
            try {
                n3 = this.lz.fillWindow(arrby, n, n2);
            }
            catch (IOException var4_5) {
                this.exception = var4_5;
                throw var4_5;
            }
            n += n3;
            n2 -= n3;
            this.pendingSize = n3 + this.pendingSize;
            if (!this.lzma.encodeForLZMA2()) continue;
            super.writeChunk();
            continue;
        }
    }
}

