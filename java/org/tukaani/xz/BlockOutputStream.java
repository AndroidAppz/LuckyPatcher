package org.tukaani.xz;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.EncoderUtil;
import org.tukaani.xz.common.Util;

class BlockOutputStream extends FinishableOutputStream {
    private final Check check;
    private final long compressedSizeLimit;
    private FinishableOutputStream filterChain;
    private final int headerSize;
    private final OutputStream out;
    private final CountingOutputStream outCounted;
    private final byte[] tempBuf = new byte[1];
    private long uncompressedSize = 0;

    public BlockOutputStream(OutputStream out, FilterEncoder[] filters, Check check) throws IOException {
        int i;
        this.out = out;
        this.check = check;
        this.outCounted = new CountingOutputStream(out);
        this.filterChain = this.outCounted;
        for (i = filters.length - 1; i >= 0; i--) {
            this.filterChain = filters[i].getOutputStream(this.filterChain);
        }
        ByteArrayOutputStream bufStream = new ByteArrayOutputStream();
        bufStream.write(0);
        bufStream.write(filters.length - 1);
        for (i = 0; i < filters.length; i++) {
            EncoderUtil.encodeVLI(bufStream, filters[i].getFilterID());
            byte[] filterProps = filters[i].getFilterProps();
            EncoderUtil.encodeVLI(bufStream, (long) filterProps.length);
            bufStream.write(filterProps);
        }
        while ((bufStream.size() & 3) != 0) {
            bufStream.write(0);
        }
        byte[] buf = bufStream.toByteArray();
        this.headerSize = buf.length + 4;
        if (this.headerSize > Util.BLOCK_HEADER_SIZE_MAX) {
            throw new UnsupportedOptionsException();
        }
        buf[0] = (byte) (buf.length / 4);
        out.write(buf);
        EncoderUtil.writeCRC32(out, buf);
        this.compressedSizeLimit = (9223372036854775804L - ((long) this.headerSize)) - ((long) check.getSize());
    }

    public void write(int b) throws IOException {
        this.tempBuf[0] = (byte) b;
        write(this.tempBuf, 0, 1);
    }

    public void write(byte[] buf, int off, int len) throws IOException {
        this.filterChain.write(buf, off, len);
        this.check.update(buf, off, len);
        this.uncompressedSize += (long) len;
        validate();
    }

    public void flush() throws IOException {
        this.filterChain.flush();
        validate();
    }

    public void finish() throws IOException {
        this.filterChain.finish();
        validate();
        for (long i = this.outCounted.getSize(); (3 & i) != 0; i++) {
            this.out.write(0);
        }
        this.out.write(this.check.finish());
    }

    private void validate() throws IOException {
        long compressedSize = this.outCounted.getSize();
        if (compressedSize < 0 || compressedSize > this.compressedSizeLimit || this.uncompressedSize < 0) {
            throw new XZIOException("XZ Stream has grown too big");
        }
    }

    public long getUnpaddedSize() {
        return (((long) this.headerSize) + this.outCounted.getSize()) + ((long) this.check.getSize());
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }
}
