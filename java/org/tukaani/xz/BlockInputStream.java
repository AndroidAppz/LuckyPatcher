package org.tukaani.xz;

import com.chelpus.Common;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.Util;

class BlockInputStream extends InputStream {
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

    public BlockInputStream(InputStream in, Check check, int memoryLimit, long unpaddedSizeInIndex, long uncompressedSizeInIndex) throws IOException, IndexIndicatorException {
        this.check = check;
        this.inData = new DataInputStream(in);
        byte[] buf = new byte[Util.BLOCK_HEADER_SIZE_MAX];
        this.inData.readFully(buf, 0, 1);
        if (buf[0] == (byte) 0) {
            throw new IndexIndicatorException();
        }
        this.headerSize = ((buf[0] & 255) + 1) * 4;
        this.inData.readFully(buf, 1, this.headerSize - 1);
        if (!DecoderUtil.isCRC32Valid(buf, 0, this.headerSize - 4, this.headerSize - 4)) {
            throw new CorruptedInputException("XZ Block Header is corrupt");
        } else if ((buf[1] & 60) != 0) {
            throw new UnsupportedOptionsException("Unsupported options in XZ Block Header");
        } else {
            int filterCount = (buf[1] & 3) + 1;
            long[] filterIDs = new long[filterCount];
            byte[][] filterProps = new byte[filterCount][];
            ByteArrayInputStream bufStream = new ByteArrayInputStream(buf, 2, this.headerSize - 6);
            try {
                int i;
                this.compressedSizeLimit = (9223372036854775804L - ((long) this.headerSize)) - ((long) check.getSize());
                if ((buf[1] & 64) != 0) {
                    this.compressedSizeInHeader = DecoderUtil.decodeVLI(bufStream);
                    if (this.compressedSizeInHeader == 0 || this.compressedSizeInHeader > this.compressedSizeLimit) {
                        throw new CorruptedInputException();
                    }
                    this.compressedSizeLimit = this.compressedSizeInHeader;
                }
                if ((buf[1] & Common.INSTALL_ALLOW_DOWNGRADE) != 0) {
                    this.uncompressedSizeInHeader = DecoderUtil.decodeVLI(bufStream);
                }
                for (i = 0; i < filterCount; i++) {
                    filterIDs[i] = DecoderUtil.decodeVLI(bufStream);
                    long filterPropsSize = DecoderUtil.decodeVLI(bufStream);
                    if (filterPropsSize > ((long) bufStream.available())) {
                        throw new CorruptedInputException();
                    }
                    filterProps[i] = new byte[((int) filterPropsSize)];
                    bufStream.read(filterProps[i]);
                }
                for (i = bufStream.available(); i > 0; i--) {
                    if (bufStream.read() != 0) {
                        throw new UnsupportedOptionsException("Unsupported options in XZ Block Header");
                    }
                }
                if (unpaddedSizeInIndex != -1) {
                    int headerAndCheckSize = this.headerSize + check.getSize();
                    if (((long) headerAndCheckSize) >= unpaddedSizeInIndex) {
                        throw new CorruptedInputException("XZ Index does not match a Block Header");
                    }
                    long compressedSizeFromIndex = unpaddedSizeInIndex - ((long) headerAndCheckSize);
                    if (compressedSizeFromIndex > this.compressedSizeLimit || !(this.compressedSizeInHeader == -1 || this.compressedSizeInHeader == compressedSizeFromIndex)) {
                        throw new CorruptedInputException("XZ Index does not match a Block Header");
                    } else if (this.uncompressedSizeInHeader == -1 || this.uncompressedSizeInHeader == uncompressedSizeInIndex) {
                        this.compressedSizeLimit = compressedSizeFromIndex;
                        this.compressedSizeInHeader = compressedSizeFromIndex;
                        this.uncompressedSizeInHeader = uncompressedSizeInIndex;
                    } else {
                        throw new CorruptedInputException("XZ Index does not match a Block Header");
                    }
                }
                FilterDecoder[] filters = new FilterDecoder[filterIDs.length];
                for (i = 0; i < filters.length; i++) {
                    if (filterIDs[i] == 33) {
                        filters[i] = new LZMA2Decoder(filterProps[i]);
                    } else if (filterIDs[i] == 3) {
                        filters[i] = new DeltaDecoder(filterProps[i]);
                    } else if (BCJCoder.isBCJFilterID(filterIDs[i])) {
                        filters[i] = new BCJDecoder(filterIDs[i], filterProps[i]);
                    } else {
                        throw new UnsupportedOptionsException("Unknown Filter ID " + filterIDs[i]);
                    }
                }
                RawCoder.validate(filters);
                if (memoryLimit >= 0) {
                    int memoryNeeded = 0;
                    for (FilterDecoder memoryUsage : filters) {
                        memoryNeeded += memoryUsage.getMemoryUsage();
                    }
                    if (memoryNeeded > memoryLimit) {
                        throw new MemoryLimitException(memoryNeeded, memoryLimit);
                    }
                }
                this.inCounted = new CountingInputStream(in);
                this.filterChain = this.inCounted;
                for (i = filters.length - 1; i >= 0; i--) {
                    this.filterChain = filters[i].getInputStream(this.filterChain);
                }
            } catch (IOException e) {
                throw new CorruptedInputException("XZ Block Header is corrupt");
            }
        }
    }

    public int read() throws IOException {
        return read(this.tempBuf, 0, 1) == -1 ? -1 : this.tempBuf[0] & 255;
    }

    public int read(byte[] buf, int off, int len) throws IOException {
        if (this.endReached) {
            return -1;
        }
        int ret = this.filterChain.read(buf, off, len);
        if (ret > 0) {
            this.check.update(buf, off, ret);
            this.uncompressedSize += (long) ret;
            long compressedSize = this.inCounted.getSize();
            if (compressedSize < 0 || compressedSize > this.compressedSizeLimit || this.uncompressedSize < 0 || (this.uncompressedSizeInHeader != -1 && this.uncompressedSize > this.uncompressedSizeInHeader)) {
                throw new CorruptedInputException();
            } else if (ret >= len && this.uncompressedSize != this.uncompressedSizeInHeader) {
                return ret;
            } else {
                if (this.filterChain.read() != -1) {
                    throw new CorruptedInputException();
                }
                validate();
                this.endReached = true;
                return ret;
            }
        } else if (ret != -1) {
            return ret;
        } else {
            validate();
            this.endReached = true;
            return ret;
        }
    }

    private void validate() throws IOException {
        long compressedSize = this.inCounted.getSize();
        if ((this.compressedSizeInHeader == -1 || this.compressedSizeInHeader == compressedSize) && (this.uncompressedSizeInHeader == -1 || this.uncompressedSizeInHeader == this.uncompressedSize)) {
            do {
                long j = compressedSize;
                compressedSize = j + 1;
                if ((3 & j) == 0) {
                    byte[] storedCheck = new byte[this.check.getSize()];
                    this.inData.readFully(storedCheck);
                    if (!Arrays.equals(this.check.finish(), storedCheck)) {
                        throw new CorruptedInputException("Integrity check (" + this.check.getName() + ") does not match");
                    }
                    return;
                }
            } while (this.inData.readUnsignedByte() == 0);
            throw new CorruptedInputException();
        }
        throw new CorruptedInputException();
    }

    public int available() throws IOException {
        return this.filterChain.available();
    }

    public long getUnpaddedSize() {
        return (((long) this.headerSize) + this.inCounted.getSize()) + ((long) this.check.getSize());
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }
}
