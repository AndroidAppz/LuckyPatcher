package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.BlockInfo;
import org.tukaani.xz.index.IndexDecoder;

public class SeekableXZInputStream extends SeekableInputStream {
    static final /* synthetic */ boolean $assertionsDisabled = (!SeekableXZInputStream.class.desiredAssertionStatus());
    private int blockCount;
    private BlockInputStream blockDecoder;
    private Check check;
    private int checkTypes;
    private final BlockInfo curBlockInfo;
    private long curPos;
    private boolean endReached;
    private IOException exception;
    private SeekableInputStream in;
    private int indexMemoryUsage;
    private long largestBlockSize;
    private final int memoryLimit;
    private final BlockInfo queriedBlockInfo;
    private boolean seekNeeded;
    private long seekPos;
    private final ArrayList streams;
    private final byte[] tempBuf;
    private long uncompressedSize;

    public SeekableXZInputStream(SeekableInputStream in) throws IOException {
        this(in, -1);
    }

    public SeekableXZInputStream(SeekableInputStream in, int memoryLimit) throws IOException {
        this.indexMemoryUsage = 0;
        this.streams = new ArrayList();
        this.checkTypes = 0;
        this.uncompressedSize = 0;
        this.largestBlockSize = 0;
        this.blockCount = 0;
        this.blockDecoder = null;
        this.curPos = 0;
        this.seekNeeded = false;
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        this.in = in;
        DataInputStream inData = new DataInputStream(in);
        in.seek(0);
        byte[] buf = new byte[XZ.HEADER_MAGIC.length];
        inData.readFully(buf);
        if (Arrays.equals(buf, XZ.HEADER_MAGIC)) {
            long pos = in.length();
            if ((3 & pos) != 0) {
                throw new CorruptedInputException("XZ file size is not a multiple of 4 bytes");
            }
            buf = new byte[12];
            long streamPadding = 0;
            while (pos > 0) {
                if (pos < 12) {
                    throw new CorruptedInputException();
                }
                in.seek(pos - 12);
                inData.readFully(buf);
                if (buf[8] == (byte) 0 && buf[9] == (byte) 0 && buf[10] == (byte) 0 && buf[11] == (byte) 0) {
                    streamPadding += 4;
                    pos -= 4;
                } else {
                    pos -= 12;
                    StreamFlags streamFooter = DecoderUtil.decodeStreamFooter(buf);
                    if (streamFooter.backwardSize >= pos) {
                        throw new CorruptedInputException("Backward Size in XZ Stream Footer is too big");
                    }
                    this.check = Check.getInstance(streamFooter.checkType);
                    this.checkTypes |= 1 << streamFooter.checkType;
                    in.seek(pos - streamFooter.backwardSize);
                    try {
                        IndexDecoder index = new IndexDecoder(in, streamFooter, streamPadding, memoryLimit);
                        this.indexMemoryUsage += index.getMemoryUsage();
                        if (memoryLimit >= 0) {
                            memoryLimit -= index.getMemoryUsage();
                            if (!$assertionsDisabled && memoryLimit < 0) {
                                throw new AssertionError();
                            }
                        }
                        if (this.largestBlockSize < index.getLargestBlockSize()) {
                            this.largestBlockSize = index.getLargestBlockSize();
                        }
                        long off = index.getStreamSize() - 12;
                        if (pos < off) {
                            throw new CorruptedInputException("XZ Index indicates too big compressed size for the XZ Stream");
                        }
                        pos -= off;
                        in.seek(pos);
                        inData.readFully(buf);
                        if (DecoderUtil.areStreamFlagsEqual(DecoderUtil.decodeStreamHeader(buf), streamFooter)) {
                            this.uncompressedSize += index.getUncompressedSize();
                            if (this.uncompressedSize < 0) {
                                throw new UnsupportedOptionsException("XZ file is too big");
                            }
                            this.blockCount += index.getRecordCount();
                            if (this.blockCount < 0) {
                                throw new UnsupportedOptionsException("XZ file has over 2147483647 Blocks");
                            }
                            this.streams.add(index);
                            streamPadding = 0;
                        } else {
                            throw new CorruptedInputException("XZ Stream Footer does not match Stream Header");
                        }
                    } catch (MemoryLimitException e) {
                        if ($assertionsDisabled || memoryLimit >= 0) {
                            throw new MemoryLimitException(e.getMemoryNeeded() + this.indexMemoryUsage, this.indexMemoryUsage + memoryLimit);
                        }
                        throw new AssertionError();
                    }
                }
            }
            if ($assertionsDisabled || pos == 0) {
                this.memoryLimit = memoryLimit;
                IndexDecoder prev = (IndexDecoder) this.streams.get(this.streams.size() - 1);
                for (int i = this.streams.size() - 2; i >= 0; i--) {
                    IndexDecoder cur = (IndexDecoder) this.streams.get(i);
                    cur.setOffsets(prev);
                    prev = cur;
                }
                IndexDecoder first = (IndexDecoder) this.streams.get(this.streams.size() - 1);
                this.curBlockInfo = new BlockInfo(first);
                this.queriedBlockInfo = new BlockInfo(first);
                return;
            }
            throw new AssertionError();
        }
        throw new XZFormatException();
    }

    public int getCheckTypes() {
        return this.checkTypes;
    }

    public int getIndexMemoryUsage() {
        return this.indexMemoryUsage;
    }

    public long getLargestBlockSize() {
        return this.largestBlockSize;
    }

    public int getStreamCount() {
        return this.streams.size();
    }

    public int getBlockCount() {
        return this.blockCount;
    }

    public long getBlockPos(int blockNumber) {
        locateBlockByNumber(this.queriedBlockInfo, blockNumber);
        return this.queriedBlockInfo.uncompressedOffset;
    }

    public long getBlockSize(int blockNumber) {
        locateBlockByNumber(this.queriedBlockInfo, blockNumber);
        return this.queriedBlockInfo.uncompressedSize;
    }

    public long getBlockCompPos(int blockNumber) {
        locateBlockByNumber(this.queriedBlockInfo, blockNumber);
        return this.queriedBlockInfo.compressedOffset;
    }

    public long getBlockCompSize(int blockNumber) {
        locateBlockByNumber(this.queriedBlockInfo, blockNumber);
        return (this.queriedBlockInfo.unpaddedSize + 3) & -4;
    }

    public int getBlockCheckType(int blockNumber) {
        locateBlockByNumber(this.queriedBlockInfo, blockNumber);
        return this.queriedBlockInfo.getCheckType();
    }

    public int getBlockNumber(long pos) {
        locateBlockByPos(this.queriedBlockInfo, pos);
        return this.queriedBlockInfo.blockNumber;
    }

    public int read() throws IOException {
        return read(this.tempBuf, 0, 1) == -1 ? -1 : this.tempBuf[0] & 255;
    }

    public int read(byte[] buf, int off, int len) throws IOException {
        if (off < 0 || len < 0 || off + len < 0 || off + len > buf.length) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        } else {
            if (this.in == null) {
                throw new XZIOException("Stream closed");
            } else if (this.exception != null) {
                throw this.exception;
            } else {
                int size = 0;
                try {
                    if (this.seekNeeded) {
                        seek();
                    }
                    if (this.endReached) {
                        return -1;
                    }
                    while (len > 0) {
                        if (this.blockDecoder == null) {
                            seek();
                            if (this.endReached) {
                                return size;
                            }
                        }
                        int ret = this.blockDecoder.read(buf, off, len);
                        if (ret > 0) {
                            this.curPos += (long) ret;
                            size += ret;
                            off += ret;
                            len -= ret;
                        } else if (ret == -1) {
                            this.blockDecoder = null;
                        }
                    }
                    return size;
                } catch (IOException e) {
                    IOException e2 = e;
                    if (e2 instanceof EOFException) {
                        e2 = new CorruptedInputException();
                    }
                    this.exception = e2;
                    if (null != null) {
                        return 0;
                    }
                    throw e2;
                }
            }
        }
    }

    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        } else if (this.exception != null) {
            throw this.exception;
        } else if (this.endReached || this.seekNeeded || this.blockDecoder == null) {
            return 0;
        } else {
            return this.blockDecoder.available();
        }
    }

    public void close() throws IOException {
        if (this.in != null) {
            try {
                this.in.close();
            } finally {
                this.in = null;
            }
        }
    }

    public long length() {
        return this.uncompressedSize;
    }

    public long position() throws IOException {
        if (this.in != null) {
            return this.seekNeeded ? this.seekPos : this.curPos;
        } else {
            throw new XZIOException("Stream closed");
        }
    }

    public void seek(long pos) throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        } else if (pos < 0) {
            throw new XZIOException("Negative seek position: " + pos);
        } else {
            this.seekPos = pos;
            this.seekNeeded = true;
        }
    }

    public void seekToBlock(int blockNumber) throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        } else if (blockNumber < 0 || blockNumber >= this.blockCount) {
            throw new XZIOException("Invalid XZ Block number: " + blockNumber);
        } else {
            this.seekPos = getBlockPos(blockNumber);
            this.seekNeeded = true;
        }
    }

    private void seek() throws IOException {
        if (!this.seekNeeded) {
            if (this.curBlockInfo.hasNext()) {
                this.curBlockInfo.setNext();
                initBlockDecoder();
                return;
            }
            this.seekPos = this.curPos;
        }
        this.seekNeeded = false;
        if (this.seekPos >= this.uncompressedSize) {
            this.curPos = this.seekPos;
            this.blockDecoder = null;
            this.endReached = true;
            return;
        }
        this.endReached = false;
        locateBlockByPos(this.curBlockInfo, this.seekPos);
        if (this.curPos <= this.curBlockInfo.uncompressedOffset || this.curPos > this.seekPos) {
            this.in.seek(this.curBlockInfo.compressedOffset);
            this.check = Check.getInstance(this.curBlockInfo.getCheckType());
            initBlockDecoder();
            this.curPos = this.curBlockInfo.uncompressedOffset;
        }
        if (this.seekPos > this.curPos) {
            long skipAmount = this.seekPos - this.curPos;
            if (this.blockDecoder.skip(skipAmount) != skipAmount) {
                throw new CorruptedInputException();
            }
            this.curPos = this.seekPos;
        }
    }

    private void locateBlockByPos(BlockInfo info, long pos) {
        if (pos < 0 || pos >= this.uncompressedSize) {
            throw new IndexOutOfBoundsException("Invalid uncompressed position: " + pos);
        }
        IndexDecoder index;
        int i = 0;
        while (true) {
            index = (IndexDecoder) this.streams.get(i);
            if (index.hasUncompressedOffset(pos)) {
                break;
            }
            i++;
        }
        index.locateBlock(info, pos);
        if (!$assertionsDisabled && (info.compressedOffset & 3) != 0) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && info.uncompressedSize <= 0) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && pos < info.uncompressedOffset) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && pos >= info.uncompressedOffset + info.uncompressedSize) {
            throw new AssertionError();
        }
    }

    private void locateBlockByNumber(BlockInfo info, int blockNumber) {
        if (blockNumber < 0 || blockNumber >= this.blockCount) {
            throw new IndexOutOfBoundsException("Invalid XZ Block number: " + blockNumber);
        } else if (info.blockNumber != blockNumber) {
            int i = 0;
            while (true) {
                IndexDecoder index = (IndexDecoder) this.streams.get(i);
                if (index.hasRecord(blockNumber)) {
                    index.setBlockInfo(info, blockNumber);
                    return;
                }
                i++;
            }
        }
    }

    private void initBlockDecoder() throws IOException {
        try {
            this.blockDecoder = null;
            this.blockDecoder = new BlockInputStream(this.in, this.check, this.memoryLimit, this.curBlockInfo.unpaddedSize, this.curBlockInfo.uncompressedSize);
        } catch (MemoryLimitException e) {
            if ($assertionsDisabled || this.memoryLimit >= 0) {
                throw new MemoryLimitException(e.getMemoryNeeded() + this.indexMemoryUsage, this.memoryLimit + this.indexMemoryUsage);
            }
            throw new AssertionError();
        } catch (IndexIndicatorException e2) {
            throw new CorruptedInputException();
        }
    }
}
