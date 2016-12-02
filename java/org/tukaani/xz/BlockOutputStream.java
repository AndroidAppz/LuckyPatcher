/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.CountingOutputStream;
import org.tukaani.xz.FilterEncoder;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.EncoderUtil;

class BlockOutputStream
extends FinishableOutputStream {
    private final Check check;
    private final long compressedSizeLimit;
    private FinishableOutputStream filterChain;
    private final int headerSize;
    private final OutputStream out;
    private final CountingOutputStream outCounted;
    private final byte[] tempBuf = new byte[1];
    private long uncompressedSize = 0;

    public BlockOutputStream(OutputStream outputStream, FilterEncoder[] arrfilterEncoder, Check check) throws IOException {
        this.out = outputStream;
        this.check = check;
        this.filterChain = this.outCounted = new CountingOutputStream(outputStream);
        for (int i = -1 + arrfilterEncoder.length; i >= 0; --i) {
            this.filterChain = arrfilterEncoder[i].getOutputStream(this.filterChain);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(-1 + arrfilterEncoder.length);
        for (int j = 0; j < arrfilterEncoder.length; ++j) {
            EncoderUtil.encodeVLI((OutputStream)byteArrayOutputStream, arrfilterEncoder[j].getFilterID());
            byte[] arrby = arrfilterEncoder[j].getFilterProps();
            EncoderUtil.encodeVLI((OutputStream)byteArrayOutputStream, arrby.length);
            byteArrayOutputStream.write(arrby);
        }
        while ((3 & byteArrayOutputStream.size()) != 0) {
            byteArrayOutputStream.write(0);
        }
        byte[] arrby = byteArrayOutputStream.toByteArray();
        this.headerSize = 4 + arrby.length;
        if (this.headerSize > 1024) {
            throw new UnsupportedOptionsException();
        }
        arrby[0] = (byte)(arrby.length / 4);
        outputStream.write(arrby);
        EncoderUtil.writeCRC32(outputStream, arrby);
        this.compressedSizeLimit = 9223372036854775804L - (long)this.headerSize - (long)check.getSize();
    }

    private void validate() throws IOException {
        long l = this.outCounted.getSize();
        if (l < 0 || l > this.compressedSizeLimit || this.uncompressedSize < 0) {
            throw new XZIOException("XZ Stream has grown too big");
        }
    }

    @Override
    public void finish() throws IOException {
        this.filterChain.finish();
        this.validate();
        long l = this.outCounted.getSize();
        while ((3 & l) != 0) {
            this.out.write(0);
            ++l;
        }
        this.out.write(this.check.finish());
    }

    public void flush() throws IOException {
        this.filterChain.flush();
        this.validate();
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public long getUnpaddedSize() {
        return (long)this.headerSize + this.outCounted.getSize() + (long)this.check.getSize();
    }

    public void write(int n) throws IOException {
        this.tempBuf[0] = (byte)n;
        this.write(this.tempBuf, 0, 1);
    }

    public void write(byte[] arrby, int n, int n2) throws IOException {
        this.filterChain.write(arrby, n, n2);
        this.check.update(arrby, n, n2);
        this.uncompressedSize += (long)n2;
        super.validate();
    }
}

