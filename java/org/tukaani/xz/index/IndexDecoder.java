package org.tukaani.xz.index;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.SeekableInputStream;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;

public class IndexDecoder extends IndexBase {
    static final /* synthetic */ boolean $assertionsDisabled = (!IndexDecoder.class.desiredAssertionStatus());
    private long compressedOffset = 0;
    private long largestBlockSize = 0;
    private final int memoryUsage;
    private int recordOffset = 0;
    private final StreamFlags streamFlags;
    private final long streamPadding;
    private final long[] uncompressed;
    private long uncompressedOffset = 0;
    private final long[] unpadded;

    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }

    public IndexDecoder(SeekableInputStream in, StreamFlags streamFooterFlags, long streamPadding, int memoryLimit) throws IOException {
        super(new CorruptedInputException("XZ Index is corrupt"));
        this.streamFlags = streamFooterFlags;
        this.streamPadding = streamPadding;
        long endPos = (in.position() + streamFooterFlags.backwardSize) - 4;
        CRC32 crc32 = new CRC32();
        CheckedInputStream inChecked = new CheckedInputStream(in, crc32);
        if (inChecked.read() != 0) {
            throw new CorruptedInputException("XZ Index is corrupt");
        }
        try {
            long count = DecoderUtil.decodeVLI(inChecked);
            if (count >= streamFooterFlags.backwardSize / 2) {
                throw new CorruptedInputException("XZ Index is corrupt");
            } else if (count > 2147483647L) {
                throw new UnsupportedOptionsException("XZ Index has over 2147483647 Records");
            } else {
                this.memoryUsage = ((int) (((16 * count) + 1023) / 1024)) + 1;
                if (memoryLimit < 0 || this.memoryUsage <= memoryLimit) {
                    this.unpadded = new long[((int) count)];
                    this.uncompressed = new long[((int) count)];
                    int record = 0;
                    int i = (int) count;
                    while (i > 0) {
                        long unpaddedSize = DecoderUtil.decodeVLI(inChecked);
                        long uncompressedSize = DecoderUtil.decodeVLI(inChecked);
                        if (in.position() > endPos) {
                            throw new CorruptedInputException("XZ Index is corrupt");
                        }
                        this.unpadded[record] = this.blocksSum + unpaddedSize;
                        this.uncompressed[record] = this.uncompressedSum + uncompressedSize;
                        record++;
                        super.add(unpaddedSize, uncompressedSize);
                        if ($assertionsDisabled || ((long) record) == this.recordCount) {
                            if (this.largestBlockSize < uncompressedSize) {
                                this.largestBlockSize = uncompressedSize;
                            }
                            i--;
                        } else {
                            throw new AssertionError();
                        }
                    }
                    int indexPaddingSize = getIndexPaddingSize();
                    if (in.position() + ((long) indexPaddingSize) != endPos) {
                        throw new CorruptedInputException("XZ Index is corrupt");
                    }
                    do {
                        int indexPaddingSize2 = indexPaddingSize;
                        indexPaddingSize = indexPaddingSize2 - 1;
                        if (indexPaddingSize2 <= 0) {
                            long value = crc32.getValue();
                            for (i = 0; i < 4; i++) {
                                if (((value >>> (i * 8)) & 255) != ((long) in.read())) {
                                    throw new CorruptedInputException("XZ Index is corrupt");
                                }
                            }
                            return;
                        }
                    } while (inChecked.read() == 0);
                    throw new CorruptedInputException("XZ Index is corrupt");
                }
                throw new MemoryLimitException(this.memoryUsage, memoryLimit);
            }
        } catch (EOFException e) {
            throw new CorruptedInputException("XZ Index is corrupt");
        }
    }

    public void setOffsets(IndexDecoder prev) {
        this.recordOffset = prev.recordOffset + ((int) prev.recordCount);
        this.compressedOffset = (prev.compressedOffset + prev.getStreamSize()) + prev.streamPadding;
        if ($assertionsDisabled || (this.compressedOffset & 3) == 0) {
            this.uncompressedOffset = prev.uncompressedOffset + prev.uncompressedSum;
            return;
        }
        throw new AssertionError();
    }

    public int getMemoryUsage() {
        return this.memoryUsage;
    }

    public StreamFlags getStreamFlags() {
        return this.streamFlags;
    }

    public int getRecordCount() {
        return (int) this.recordCount;
    }

    public long getUncompressedSize() {
        return this.uncompressedSum;
    }

    public long getLargestBlockSize() {
        return this.largestBlockSize;
    }

    public boolean hasUncompressedOffset(long pos) {
        return pos >= this.uncompressedOffset && pos < this.uncompressedOffset + this.uncompressedSum;
    }

    public boolean hasRecord(int blockNumber) {
        return blockNumber >= this.recordOffset && ((long) blockNumber) < ((long) this.recordOffset) + this.recordCount;
    }

    public void locateBlock(BlockInfo info, long target) {
        if ($assertionsDisabled || target >= this.uncompressedOffset) {
            target -= this.uncompressedOffset;
            if ($assertionsDisabled || target < this.uncompressedSum) {
                int left = 0;
                int right = this.unpadded.length - 1;
                while (left < right) {
                    int i = left + ((right - left) / 2);
                    if (this.uncompressed[i] <= target) {
                        left = i + 1;
                    } else {
                        right = i;
                    }
                }
                setBlockInfo(info, this.recordOffset + left);
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public void setBlockInfo(BlockInfo info, int blockNumber) {
        if (!$assertionsDisabled && blockNumber < this.recordOffset) {
            throw new AssertionError();
        } else if ($assertionsDisabled || ((long) (blockNumber - this.recordOffset)) < this.recordCount) {
            info.index = this;
            info.blockNumber = blockNumber;
            int pos = blockNumber - this.recordOffset;
            if (pos == 0) {
                info.compressedOffset = 0;
                info.uncompressedOffset = 0;
            } else {
                info.compressedOffset = (this.unpadded[pos - 1] + 3) & -4;
                info.uncompressedOffset = this.uncompressed[pos - 1];
            }
            info.unpaddedSize = this.unpadded[pos] - info.compressedOffset;
            info.uncompressedSize = this.uncompressed[pos] - info.uncompressedOffset;
            info.compressedOffset += this.compressedOffset + 12;
            info.uncompressedOffset += this.uncompressedOffset;
        } else {
            throw new AssertionError();
        }
    }
}
