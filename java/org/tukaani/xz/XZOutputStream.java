/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.BlockOutputStream;
import org.tukaani.xz.FilterCoder;
import org.tukaani.xz.FilterEncoder;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.RawCoder;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.EncoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexEncoder;

public class XZOutputStream
extends FinishableOutputStream {
    private BlockOutputStream blockEncoder;
    private final Check check;
    private IOException exception;
    private FilterEncoder[] filters;
    private boolean filtersSupportFlushing;
    private boolean finished;
    private final IndexEncoder index;
    private OutputStream out;
    private final StreamFlags streamFlags;
    private final byte[] tempBuf;

    public XZOutputStream(OutputStream outputStream, FilterOptions filterOptions) throws IOException {
        super(outputStream, filterOptions, 4);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions filterOptions, int n) throws IOException {
        super(outputStream, new FilterOptions[]{filterOptions}, n);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions[] arrfilterOptions) throws IOException {
        super(outputStream, arrfilterOptions, 4);
    }

    public XZOutputStream(OutputStream outputStream, FilterOptions[] arrfilterOptions, int n) throws IOException {
        this.streamFlags = new StreamFlags();
        this.index = new IndexEncoder();
        this.blockEncoder = null;
        this.exception = null;
        this.finished = false;
        this.tempBuf = new byte[1];
        this.out = outputStream;
        this.updateFilters(arrfilterOptions);
        this.streamFlags.checkType = n;
        this.check = Check.getInstance(n);
        super.encodeStreamHeader();
    }

    private void encodeStreamFlags(byte[] arrby, int n) {
        arrby[n] = 0;
        arrby[n + 1] = (byte)this.streamFlags.checkType;
    }

    private void encodeStreamFooter() throws IOException {
        byte[] arrby = new byte[6];
        long l = this.index.getIndexSize() / 4 - 1;
        for (int i = 0; i < 4; ++i) {
            arrby[i] = (byte)(l >>> i * 8);
        }
        this.encodeStreamFlags(arrby, 4);
        EncoderUtil.writeCRC32(this.out, arrby);
        this.out.write(arrby);
        this.out.write(XZ.FOOTER_MAGIC);
    }

    private void encodeStreamHeader() throws IOException {
        this.out.write(XZ.HEADER_MAGIC);
        byte[] arrby = new byte[2];
        this.encodeStreamFlags(arrby, 0);
        this.out.write(arrby);
        EncoderUtil.writeCRC32(this.out, arrby);
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void close() throws IOException {
        if (this.out == null) ** GOTO lbl15
        try {
            this.finish();
        }
        catch (IOException var1_2) {
            ** continue;
        }
lbl6: // 2 sources:
        do {
            try {
                this.out.close();
            }
            catch (IOException var2_1) {
                if (this.exception != null) ** GOTO lbl13
                this.exception = var2_1;
                ** continue;
            }
lbl13: // 3 sources:
            do {
                this.out = null;
lbl15: // 2 sources:
                if (this.exception == null) return;
                throw this.exception;
                break;
            } while (true);
            break;
        } while (true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void endBlock() throws IOException {
        if (this.exception != null) {
            throw this.exception;
        }
        if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        }
        if (this.blockEncoder == null) return;
        try {
            this.blockEncoder.finish();
            this.index.add(this.blockEncoder.getUnpaddedSize(), this.blockEncoder.getUncompressedSize());
            this.blockEncoder = null;
            return;
        }
        catch (IOException var1_1) {
            this.exception = var1_1;
            throw var1_1;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void finish() throws IOException {
        if (this.finished) return;
        this.endBlock();
        try {
            this.index.encode(this.out);
            this.encodeStreamFooter();
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
            if (this.blockEncoder != null) {
                if (this.filtersSupportFlushing) {
                    this.blockEncoder.flush();
                    return;
                }
                this.endBlock();
                this.out.flush();
                return;
            }
            this.out.flush();
            return;
        }
        catch (IOException var1_1) {
            this.exception = var1_1;
            throw var1_1;
        }
    }

    public void updateFilters(FilterOptions filterOptions) throws XZIOException {
        this.updateFilters(new FilterOptions[]{filterOptions});
    }

    public void updateFilters(FilterOptions[] arrfilterOptions) throws XZIOException {
        if (this.blockEncoder != null) {
            throw new UnsupportedOptionsException("Changing filter options in the middle of a XZ Block not implemented");
        }
        if (arrfilterOptions.length < 1 || arrfilterOptions.length > 4) {
            throw new UnsupportedOptionsException("XZ filter chain must be 1-4 filters");
        }
        this.filtersSupportFlushing = true;
        FilterCoder[] arrfilterCoder = new FilterEncoder[arrfilterOptions.length];
        for (int i = 0; i < arrfilterOptions.length; ++i) {
            arrfilterCoder[i] = arrfilterOptions[i].getFilterEncoder();
            this.filtersSupportFlushing &= arrfilterCoder[i].supportsFlushing();
        }
        RawCoder.validate(arrfilterCoder);
        this.filters = arrfilterCoder;
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
        try {
            if (this.blockEncoder == null) {
                this.blockEncoder = new BlockOutputStream(this.out, this.filters, this.check);
            }
            this.blockEncoder.write(arrby, n, n2);
            return;
        }
        catch (IOException var4_4) {
            this.exception = var4_4;
            throw var4_4;
        }
    }
}

