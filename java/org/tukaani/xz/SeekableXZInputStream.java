/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 */
package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.tukaani.xz.BlockInputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.IndexIndicatorException;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.SeekableInputStream;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZFormatException;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.BlockInfo;
import org.tukaani.xz.index.IndexDecoder;

public class SeekableXZInputStream
extends SeekableInputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
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

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !SeekableXZInputStream.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream) throws IOException {
        super(seekableInputStream, -1);
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, int n) throws IOException {
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
        this.in = seekableInputStream;
        DataInputStream dataInputStream = new DataInputStream((InputStream)seekableInputStream);
        seekableInputStream.seek(0);
        byte[] arrby = new byte[XZ.HEADER_MAGIC.length];
        dataInputStream.readFully(arrby);
        if (!Arrays.equals((byte[])arrby, (byte[])XZ.HEADER_MAGIC)) {
            throw new XZFormatException();
        }
        long l = seekableInputStream.length();
        if ((3 & l) != 0) {
            throw new CorruptedInputException("XZ file size is not a multiple of 4 bytes");
        }
        byte[] arrby2 = new byte[12];
        long l2 = 0;
        while (l > 0) {
            long l3;
            IndexDecoder indexDecoder;
            if (l < 12) {
                throw new CorruptedInputException();
            }
            seekableInputStream.seek(l - 12);
            dataInputStream.readFully(arrby2);
            if (arrby2[8] == 0 && arrby2[9] == 0 && arrby2[10] == 0 && arrby2[11] == 0) {
                l2 += 4;
                l -= 4;
                continue;
            }
            long l4 = l - 12;
            StreamFlags streamFlags = DecoderUtil.decodeStreamFooter(arrby2);
            if (streamFlags.backwardSize >= l4) {
                throw new CorruptedInputException("Backward Size in XZ Stream Footer is too big");
            }
            this.check = Check.getInstance(streamFlags.checkType);
            this.checkTypes |= 1 << streamFlags.checkType;
            seekableInputStream.seek(l4 - streamFlags.backwardSize);
            try {
                indexDecoder = new IndexDecoder(seekableInputStream, streamFlags, l2, n);
            }
            catch (MemoryLimitException var21_12) {
                if (!$assertionsDisabled && n < 0) {
                    throw new AssertionError();
                }
                throw new MemoryLimitException(var21_12.getMemoryNeeded() + this.indexMemoryUsage, n + this.indexMemoryUsage);
            }
            this.indexMemoryUsage += indexDecoder.getMemoryUsage();
            if (n >= 0 && !$assertionsDisabled && (n -= indexDecoder.getMemoryUsage()) < 0) {
                throw new AssertionError();
            }
            if (this.largestBlockSize < indexDecoder.getLargestBlockSize()) {
                this.largestBlockSize = indexDecoder.getLargestBlockSize();
            }
            if (l4 < (l3 = indexDecoder.getStreamSize() - 12)) {
                throw new CorruptedInputException("XZ Index indicates too big compressed size for the XZ Stream");
            }
            l = l4 - l3;
            seekableInputStream.seek(l);
            dataInputStream.readFully(arrby2);
            if (!DecoderUtil.areStreamFlagsEqual(DecoderUtil.decodeStreamHeader(arrby2), streamFlags)) {
                throw new CorruptedInputException("XZ Stream Footer does not match Stream Header");
            }
            this.uncompressedSize += indexDecoder.getUncompressedSize();
            if (this.uncompressedSize < 0) {
                throw new UnsupportedOptionsException("XZ file is too big");
            }
            this.blockCount += indexDecoder.getRecordCount();
            if (this.blockCount < 0) {
                throw new UnsupportedOptionsException("XZ file has over 2147483647 Blocks");
            }
            this.streams.add((Object)indexDecoder);
            l2 = 0;
        }
        if (!$assertionsDisabled && l != 0) {
            throw new AssertionError();
        }
        this.memoryLimit = n;
        IndexDecoder indexDecoder = (IndexDecoder)this.streams.get(-1 + this.streams.size());
        for (int i = -2 + this.streams.size(); i >= 0; --i) {
            IndexDecoder indexDecoder2 = (IndexDecoder)this.streams.get(i);
            indexDecoder2.setOffsets(indexDecoder);
            indexDecoder = indexDecoder2;
        }
        IndexDecoder indexDecoder3 = (IndexDecoder)this.streams.get(-1 + this.streams.size());
        this.curBlockInfo = new BlockInfo(indexDecoder3);
        this.queriedBlockInfo = new BlockInfo(indexDecoder3);
    }

    private void initBlockDecoder() throws IOException {
        try {
            this.blockDecoder = null;
            this.blockDecoder = new BlockInputStream(this.in, this.check, this.memoryLimit, this.curBlockInfo.unpaddedSize, this.curBlockInfo.uncompressedSize);
            return;
        }
        catch (MemoryLimitException var2_1) {
            if (!$assertionsDisabled && this.memoryLimit < 0) {
                throw new AssertionError();
            }
            throw new MemoryLimitException(var2_1.getMemoryNeeded() + this.indexMemoryUsage, this.memoryLimit + this.indexMemoryUsage);
        }
        catch (IndexIndicatorException var1_2) {
            throw new CorruptedInputException();
        }
    }

    private void locateBlockByNumber(BlockInfo blockInfo, int n) {
        if (n < 0 || n >= this.blockCount) {
            throw new IndexOutOfBoundsException("Invalid XZ Block number: " + n);
        }
        if (blockInfo.blockNumber == n) {
            return;
        }
        int n2 = 0;
        do {
            IndexDecoder indexDecoder;
            if ((indexDecoder = (IndexDecoder)this.streams.get(n2)).hasRecord(n)) {
                indexDecoder.setBlockInfo(blockInfo, n);
                return;
            }
            ++n2;
        } while (true);
    }

    private void locateBlockByPos(BlockInfo blockInfo, long l) {
        if (l < 0 || l >= this.uncompressedSize) {
            throw new IndexOutOfBoundsException("Invalid uncompressed position: " + l);
        }
        int n = 0;
        do {
            IndexDecoder indexDecoder;
            if ((indexDecoder = (IndexDecoder)this.streams.get(n)).hasUncompressedOffset(l)) {
                indexDecoder.locateBlock(blockInfo, l);
                if (!$assertionsDisabled && (3 & blockInfo.compressedOffset) != 0) {
                    throw new AssertionError();
                }
                break;
            }
            ++n;
        } while (true);
        if (!$assertionsDisabled && blockInfo.uncompressedSize <= 0) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && l < blockInfo.uncompressedOffset) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && l >= blockInfo.uncompressedOffset + blockInfo.uncompressedSize) {
            throw new AssertionError();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void seek() throws IOException {
        if (!this.seekNeeded) {
            if (this.curBlockInfo.hasNext()) {
                this.curBlockInfo.setNext();
                this.initBlockDecoder();
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
        this.locateBlockByPos(this.curBlockInfo, this.seekPos);
        if (this.curPos <= this.curBlockInfo.uncompressedOffset || this.curPos > this.seekPos) {
            this.in.seek(this.curBlockInfo.compressedOffset);
            this.check = Check.getInstance(this.curBlockInfo.getCheckType());
            this.initBlockDecoder();
            this.curPos = this.curBlockInfo.uncompressedOffset;
        }
        if (this.seekPos <= this.curPos) return;
        {
            long l = this.seekPos - this.curPos;
            if (this.blockDecoder.skip(l) != l) {
                throw new CorruptedInputException();
            }
        }
        this.curPos = this.seekPos;
    }

    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (this.exception != null) {
            throw this.exception;
        }
        if (this.endReached || this.seekNeeded || this.blockDecoder == null) {
            return 0;
        }
        return this.blockDecoder.available();
    }

    public void close() throws IOException {
        if (this.in != null) {
            this.in.close();
        }
        return;
        finally {
            this.in = null;
        }
    }

    public int getBlockCheckType(int n) {
        super.locateBlockByNumber(this.queriedBlockInfo, n);
        return this.queriedBlockInfo.getCheckType();
    }

    public long getBlockCompPos(int n) {
        super.locateBlockByNumber(this.queriedBlockInfo, n);
        return this.queriedBlockInfo.compressedOffset;
    }

    public long getBlockCompSize(int n) {
        super.locateBlockByNumber(this.queriedBlockInfo, n);
        return -4 & 3 + this.queriedBlockInfo.unpaddedSize;
    }

    public int getBlockCount() {
        return this.blockCount;
    }

    public int getBlockNumber(long l) {
        super.locateBlockByPos(this.queriedBlockInfo, l);
        return this.queriedBlockInfo.blockNumber;
    }

    public long getBlockPos(int n) {
        super.locateBlockByNumber(this.queriedBlockInfo, n);
        return this.queriedBlockInfo.uncompressedOffset;
    }

    public long getBlockSize(int n) {
        super.locateBlockByNumber(this.queriedBlockInfo, n);
        return this.queriedBlockInfo.uncompressedSize;
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

    @Override
    public long length() {
        return this.uncompressedSize;
    }

    @Override
    public long position() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (this.seekNeeded) {
            return this.seekPos;
        }
        return this.curPos;
    }

    public int read() throws IOException {
        if (this.read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return 255 & this.tempBuf[0];
    }

    /*
     * Exception decompiling
     */
    public int read(byte[] var1, int var2_3, int var3_2) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 1[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void seek(long l) throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (l < 0) {
            throw new XZIOException("Negative seek position: " + l);
        }
        this.seekPos = l;
        this.seekNeeded = true;
    }

    public void seekToBlock(int n) throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (n < 0 || n >= this.blockCount) {
            throw new XZIOException("Invalid XZ Block number: " + n);
        }
        this.seekPos = this.getBlockPos(n);
        this.seekNeeded = true;
    }
}

