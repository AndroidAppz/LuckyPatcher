package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.EncoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexEncoder;

public class XZOutputStream extends FinishableOutputStream {
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

    public XZOutputStream(OutputStream out, FilterOptions filterOptions) throws IOException {
        this(out, filterOptions, 4);
    }

    public XZOutputStream(OutputStream out, FilterOptions filterOptions, int checkType) throws IOException {
        this(out, new FilterOptions[]{filterOptions}, checkType);
    }

    public XZOutputStream(OutputStream out, FilterOptions[] filterOptions) throws IOException {
        this(out, filterOptions, 4);
    }

    public XZOutputStream(OutputStream out, FilterOptions[] filterOptions, int checkType) throws IOException {
        this.streamFlags = new StreamFlags();
        this.index = new IndexEncoder();
        this.blockEncoder = null;
        this.exception = null;
        this.finished = false;
        this.tempBuf = new byte[1];
        this.out = out;
        updateFilters(filterOptions);
        this.streamFlags.checkType = checkType;
        this.check = Check.getInstance(checkType);
        encodeStreamHeader();
    }

    public void updateFilters(FilterOptions filterOptions) throws XZIOException {
        updateFilters(new FilterOptions[]{filterOptions});
    }

    public void updateFilters(FilterOptions[] filterOptions) throws XZIOException {
        if (this.blockEncoder != null) {
            throw new UnsupportedOptionsException("Changing filter options in the middle of a XZ Block not implemented");
        } else if (filterOptions.length < 1 || filterOptions.length > 4) {
            throw new UnsupportedOptionsException("XZ filter chain must be 1-4 filters");
        } else {
            this.filtersSupportFlushing = true;
            FilterEncoder[] newFilters = new FilterEncoder[filterOptions.length];
            for (int i = 0; i < filterOptions.length; i++) {
                newFilters[i] = filterOptions[i].getFilterEncoder();
                this.filtersSupportFlushing &= newFilters[i].supportsFlushing();
            }
            RawCoder.validate(newFilters);
            this.filters = newFilters;
        }
    }

    public void write(int b) throws IOException {
        this.tempBuf[0] = (byte) b;
        write(this.tempBuf, 0, 1);
    }

    public void write(byte[] buf, int off, int len) throws IOException {
        if (off < 0 || len < 0 || off + len < 0 || off + len > buf.length) {
            throw new IndexOutOfBoundsException();
        } else if (this.exception != null) {
            throw this.exception;
        } else if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        } else {
            try {
                if (this.blockEncoder == null) {
                    this.blockEncoder = new BlockOutputStream(this.out, this.filters, this.check);
                }
                this.blockEncoder.write(buf, off, len);
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public void endBlock() throws IOException {
        if (this.exception != null) {
            throw this.exception;
        } else if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        } else if (this.blockEncoder != null) {
            try {
                this.blockEncoder.finish();
                this.index.add(this.blockEncoder.getUnpaddedSize(), this.blockEncoder.getUncompressedSize());
                this.blockEncoder = null;
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public void flush() throws IOException {
        if (this.exception != null) {
            throw this.exception;
        } else if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        } else {
            try {
                if (this.blockEncoder == null) {
                    this.out.flush();
                } else if (this.filtersSupportFlushing) {
                    this.blockEncoder.flush();
                } else {
                    endBlock();
                    this.out.flush();
                }
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            endBlock();
            try {
                this.index.encode(this.out);
                encodeStreamFooter();
                this.finished = true;
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public void close() throws IOException {
        if (this.out != null) {
            try {
                finish();
            } catch (IOException e) {
            }
            try {
                this.out.close();
            } catch (IOException e2) {
                if (this.exception == null) {
                    this.exception = e2;
                }
            }
            this.out = null;
        }
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void encodeStreamFlags(byte[] buf, int off) {
        buf[off] = (byte) 0;
        buf[off + 1] = (byte) this.streamFlags.checkType;
    }

    private void encodeStreamHeader() throws IOException {
        this.out.write(XZ.HEADER_MAGIC);
        byte[] buf = new byte[2];
        encodeStreamFlags(buf, 0);
        this.out.write(buf);
        EncoderUtil.writeCRC32(this.out, buf);
    }

    private void encodeStreamFooter() throws IOException {
        byte[] buf = new byte[6];
        long backwardSize = (this.index.getIndexSize() / 4) - 1;
        for (int i = 0; i < 4; i++) {
            buf[i] = (byte) ((int) (backwardSize >>> (i * 8)));
        }
        encodeStreamFlags(buf, 4);
        EncoderUtil.writeCRC32(this.out, buf);
        this.out.write(buf);
        this.out.write(XZ.FOOTER_MAGIC);
    }
}
