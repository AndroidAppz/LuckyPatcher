/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 */
package org.tukaani.xz;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.tukaani.xz.BCJDecoder;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.CountingInputStream;
import org.tukaani.xz.DeltaDecoder;
import org.tukaani.xz.FilterCoder;
import org.tukaani.xz.FilterDecoder;
import org.tukaani.xz.IndexIndicatorException;
import org.tukaani.xz.LZMA2Decoder;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.RawCoder;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;

class BlockInputStream
extends InputStream {
    private final Check check;
    private long compressedSizeInHeader = -1;
    private long compressedSizeLimit;
    private boolean endReached = false;
    private InputStream filterChain;
    private final int headerSize;
    private final CountingInputStream inCounted;
    private final DataInputStream inData;
    private final byte[] tempBuf = new byte[1];
    private long uncompressedSize = 0;
    private long uncompressedSizeInHeader = -1;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public BlockInputStream(InputStream inputStream, Check check, int n, long l, long l2) throws IOException, IndexIndicatorException {
        DataInputStream dataInputStream;
        CountingInputStream countingInputStream;
        int n2;
        this.check = check;
        this.inData = dataInputStream = new DataInputStream(inputStream);
        byte[] arrby = new byte[1024];
        this.inData.readFully(arrby, 0, 1);
        if (arrby[0] == 0) {
            throw new IndexIndicatorException();
        }
        this.headerSize = 4 * (1 + (255 & arrby[0]));
        this.inData.readFully(arrby, 1, -1 + this.headerSize);
        if (!DecoderUtil.isCRC32Valid(arrby, 0, -4 + this.headerSize, -4 + this.headerSize)) {
            throw new CorruptedInputException("XZ Block Header is corrupt");
        }
        if ((60 & arrby[1]) != 0) {
            throw new UnsupportedOptionsException("Unsupported options in XZ Block Header");
        }
        int n3 = 1 + (3 & arrby[1]);
        long[] arrl = new long[n3];
        byte[][] arrarrby = new byte[n3][];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby, 2, -6 + this.headerSize);
        try {
            this.compressedSizeLimit = 9223372036854775804L - (long)this.headerSize - (long)check.getSize();
            if ((64 & arrby[1]) != 0) {
                this.compressedSizeInHeader = DecoderUtil.decodeVLI((InputStream)byteArrayInputStream);
                if (this.compressedSizeInHeader == 0 || this.compressedSizeInHeader > this.compressedSizeLimit) {
                    throw new CorruptedInputException();
                }
                this.compressedSizeLimit = this.compressedSizeInHeader;
            }
        }
        catch (IOException var14_12) {
            throw new CorruptedInputException("XZ Block Header is corrupt");
        }
        if ((128 & arrby[1]) != 0) {
            this.uncompressedSizeInHeader = DecoderUtil.decodeVLI((InputStream)byteArrayInputStream);
        }
        for (int i = 0; i < n3; ++i) {
            arrl[i] = DecoderUtil.decodeVLI((InputStream)byteArrayInputStream);
            long l3 = DecoderUtil.decodeVLI((InputStream)byteArrayInputStream);
            if (l3 > (long)byteArrayInputStream.available()) {
                throw new CorruptedInputException();
            }
            arrarrby[i] = new byte[(int)l3];
            byteArrayInputStream.read(arrarrby[i]);
        }
        for (int j = byteArrayInputStream.available(); j > 0; --j) {
            if (byteArrayInputStream.read() == 0) continue;
            throw new UnsupportedOptionsException("Unsupported options in XZ Block Header");
        }
        if (l != -1) {
            int n4 = this.headerSize + check.getSize();
            if ((long)n4 >= l) {
                throw new CorruptedInputException("XZ Index does not match a Block Header");
            }
            long l4 = l - (long)n4;
            if (l4 > this.compressedSizeLimit || this.compressedSizeInHeader != -1 && this.compressedSizeInHeader != l4) {
                throw new CorruptedInputException("XZ Index does not match a Block Header");
            }
            if (this.uncompressedSizeInHeader != -1 && this.uncompressedSizeInHeader != l2) {
                throw new CorruptedInputException("XZ Index does not match a Block Header");
            }
            this.compressedSizeLimit = l4;
            this.compressedSizeInHeader = l4;
            this.uncompressedSizeInHeader = l2;
        }
        FilterCoder[] arrfilterCoder = new FilterDecoder[arrl.length];
        for (int k = 0; k < (n2 = arrfilterCoder.length); ++k) {
            BCJDecoder bCJDecoder;
            if (arrl[k] == 33) {
                arrfilterCoder[k] = new LZMA2Decoder(arrarrby[k]);
                continue;
            }
            if (arrl[k] == 3) {
                arrfilterCoder[k] = new DeltaDecoder(arrarrby[k]);
                continue;
            }
            if (!BCJDecoder.isBCJFilterID(arrl[k])) {
                throw new UnsupportedOptionsException("Unknown Filter ID " + arrl[k]);
            }
            arrfilterCoder[k] = bCJDecoder = new BCJDecoder(arrl[k], arrarrby[k]);
        }
        RawCoder.validate(arrfilterCoder);
        if (n >= 0) {
            int n5;
            int n6 = 0;
            for (int i2 = 0; i2 < (n5 = arrfilterCoder.length); n6 += arrfilterCoder[i2].getMemoryUsage(), ++i2) {
            }
            if (n6 > n) {
                MemoryLimitException memoryLimitException = new MemoryLimitException(n6, n);
                throw memoryLimitException;
            }
        }
        this.filterChain = this.inCounted = (countingInputStream = new CountingInputStream(inputStream));
        int n7 = -1 + arrfilterCoder.length;
        while (n7 >= 0) {
            this.filterChain = arrfilterCoder[n7].getInputStream(this.filterChain);
            --n7;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void validate() throws IOException {
        long l = this.inCounted.getSize();
        if (this.compressedSizeInHeader != -1) {
            if (this.compressedSizeInHeader != l) throw new CorruptedInputException();
        }
        if (this.uncompressedSizeInHeader != -1 && this.uncompressedSizeInHeader != this.uncompressedSize) {
            throw new CorruptedInputException();
        }
        do {
            long l2 = l;
            l = l2 + 1;
            if ((3 & l2) != 0) continue;
            byte[] arrby = new byte[this.check.getSize()];
            this.inData.readFully(arrby);
            if (Arrays.equals((byte[])this.check.finish(), (byte[])arrby)) return;
            throw new CorruptedInputException("Integrity check (" + this.check.getName() + ") does not match");
        } while (this.inData.readUnsignedByte() == 0);
        throw new CorruptedInputException();
    }

    public int available() throws IOException {
        return this.filterChain.available();
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public long getUnpaddedSize() {
        return (long)this.headerSize + this.inCounted.getSize() + (long)this.check.getSize();
    }

    public int read() throws IOException {
        if (this.read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return 255 & this.tempBuf[0];
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int read(byte[] arrby, int n, int n2) throws IOException {
        if (this.endReached) {
            return -1;
        }
        int n3 = this.filterChain.read(arrby, n, n2);
        if (n3 > 0) {
            this.check.update(arrby, n, n3);
            this.uncompressedSize += (long)n3;
            long l = this.inCounted.getSize();
            if (l < 0) throw new CorruptedInputException();
            if (l > this.compressedSizeLimit) throw new CorruptedInputException();
            if (this.uncompressedSize < 0) throw new CorruptedInputException();
            if (this.uncompressedSizeInHeader != -1 && this.uncompressedSize > this.uncompressedSizeInHeader) {
                throw new CorruptedInputException();
            }
            if (n3 >= n2) {
                if (this.uncompressedSize != this.uncompressedSizeInHeader) return n3;
            }
            if (this.filterChain.read() != -1) {
                throw new CorruptedInputException();
            }
            super.validate();
            this.endReached = true;
            return n3;
        }
        if (n3 != -1) return n3;
        super.validate();
        this.endReached = true;
        return n3;
    }
}

