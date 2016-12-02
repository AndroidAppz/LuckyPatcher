/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package org.tukaani.xz;

import java.io.IOException;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.simple.SimpleFilter;

class SimpleOutputStream
extends FinishableOutputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FILTER_BUF_SIZE = 4096;
    private IOException exception = null;
    private final byte[] filterBuf = new byte[4096];
    private boolean finished = false;
    private FinishableOutputStream out;
    private int pos = 0;
    private final SimpleFilter simpleFilter;
    private final byte[] tempBuf = new byte[1];
    private int unfiltered = 0;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !SimpleOutputStream.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    SimpleOutputStream(FinishableOutputStream finishableOutputStream, SimpleFilter simpleFilter) {
        if (finishableOutputStream == null) {
            throw new NullPointerException();
        }
        this.out = finishableOutputStream;
        this.simpleFilter = simpleFilter;
    }

    static int getMemoryUsage() {
        return 5;
    }

    private void writePending() throws IOException {
        if (!$assertionsDisabled && this.finished) {
            throw new AssertionError();
        }
        if (this.exception != null) {
            throw this.exception;
        }
        try {
            this.out.write(this.filterBuf, this.pos, this.unfiltered);
        }
        catch (IOException var1_1) {
            this.exception = var1_1;
            throw var1_1;
        }
        this.finished = true;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void close() throws IOException {
        if (this.out == null) ** GOTO lbl14
        if (!this.finished) {
            this.writePending();
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
        this.writePending();
        try {
            this.out.finish();
            return;
        }
        catch (IOException var1_1) {
            this.exception = var1_1;
            throw var1_1;
        }
    }

    public void flush() throws IOException {
        throw new UnsupportedOptionsException("Flushing is not supported");
    }

    public void write(int n) throws IOException {
        this.tempBuf[0] = (byte)n;
        this.write(this.tempBuf, 0, 1);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void write(byte[] var1, int var2_3, int var3_2) throws IOException {
        if (var2_3 < 0) throw new IndexOutOfBoundsException();
        if (var3_2 < 0) throw new IndexOutOfBoundsException();
        if (var2_3 + var3_2 < 0) throw new IndexOutOfBoundsException();
        if (var2_3 + var3_2 > var1.length) {
            throw new IndexOutOfBoundsException();
        }
        if (this.exception != null) {
            throw this.exception;
        }
        if (!this.finished) ** GOTO lbl17
        throw new XZIOException("Stream finished or closed");
lbl-1000: // 1 sources:
        {
            this.unfiltered -= var5_5;
            this.out.write(this.filterBuf, this.pos, var5_5);
            this.pos = var5_5 + this.pos;
            if (this.pos + this.unfiltered == 4096) {
                System.arraycopy((Object)this.filterBuf, (int)this.pos, (Object)this.filterBuf, (int)0, (int)this.unfiltered);
                this.pos = 0;
            }
lbl17: // 4 sources:
            if (var3_2 <= 0) return;
            var4_4 = Math.min((int)var3_2, (int)(4096 - (this.pos + this.unfiltered)));
            System.arraycopy((Object)var1, (int)var2_3, (Object)this.filterBuf, (int)(this.pos + this.unfiltered), (int)var4_4);
            var2_3 += var4_4;
            var3_2 -= var4_4;
            this.unfiltered = var4_4 + this.unfiltered;
            var5_5 = this.simpleFilter.code(this.filterBuf, this.pos, this.unfiltered);
            ** while (SimpleOutputStream.$assertionsDisabled || var5_5 <= this.unfiltered)
        }
lbl25: // 1 sources:
        throw new AssertionError();
        catch (IOException var6_6) {
            this.exception = var6_6;
            throw var6_6;
        }
    }
}

