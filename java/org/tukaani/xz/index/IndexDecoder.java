/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 */
package org.tukaani.xz.index;

import java.io.IOException;
import org.tukaani.xz.SeekableInputStream;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.BlockInfo;
import org.tukaani.xz.index.IndexBase;

public class IndexDecoder
extends IndexBase {
    static final /* synthetic */ boolean $assertionsDisabled;
    private long compressedOffset;
    private long largestBlockSize;
    private final int memoryUsage;
    private int recordOffset;
    private final StreamFlags streamFlags;
    private final long streamPadding;
    private final long[] uncompressed;
    private long uncompressedOffset;
    private final long[] unpadded;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !IndexDecoder.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    /*
     * Exception decompiling
     */
    public IndexDecoder(SeekableInputStream var1, StreamFlags var2_4, long var3_3, int var5_2) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl24 : TryStatement: try { 1[TRYBLOCK]

        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
        // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.RemoveDeterministicJumps.apply(RemoveDeterministicJumps.java:35)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:507)
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

    public long getLargestBlockSize() {
        return this.largestBlockSize;
    }

    public int getMemoryUsage() {
        return this.memoryUsage;
    }

    public int getRecordCount() {
        return (int)this.recordCount;
    }

    public StreamFlags getStreamFlags() {
        return this.streamFlags;
    }

    public long getUncompressedSize() {
        return this.uncompressedSum;
    }

    public boolean hasRecord(int n) {
        if (n >= this.recordOffset && (long)n < (long)this.recordOffset + this.recordCount) {
            return true;
        }
        return false;
    }

    public boolean hasUncompressedOffset(long l) {
        if (l >= this.uncompressedOffset && l < this.uncompressedOffset + this.uncompressedSum) {
            return true;
        }
        return false;
    }

    public void locateBlock(BlockInfo blockInfo, long l) {
        if (!$assertionsDisabled && l < this.uncompressedOffset) {
            throw new AssertionError();
        }
        long l2 = l - this.uncompressedOffset;
        if (!$assertionsDisabled && l2 >= this.uncompressedSum) {
            throw new AssertionError();
        }
        int n = 0;
        int n2 = -1 + this.unpadded.length;
        while (n < n2) {
            int n3 = n + (n2 - n) / 2;
            if (this.uncompressed[n3] <= l2) {
                n = n3 + 1;
                continue;
            }
            n2 = n3;
        }
        this.setBlockInfo(blockInfo, n + this.recordOffset);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setBlockInfo(BlockInfo blockInfo, int n) {
        if (!$assertionsDisabled && n < this.recordOffset) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && (long)(n - this.recordOffset) >= this.recordCount) {
            throw new AssertionError();
        }
        blockInfo.index = this;
        blockInfo.blockNumber = n;
        int n2 = n - this.recordOffset;
        if (n2 == 0) {
            blockInfo.compressedOffset = 0;
            blockInfo.uncompressedOffset = 0;
        } else {
            blockInfo.compressedOffset = -4 & 3 + this.unpadded[n2 - 1];
            blockInfo.uncompressedOffset = this.uncompressed[n2 - 1];
        }
        blockInfo.unpaddedSize = this.unpadded[n2] - blockInfo.compressedOffset;
        blockInfo.uncompressedSize = this.uncompressed[n2] - blockInfo.uncompressedOffset;
        blockInfo.compressedOffset += 12 + this.compressedOffset;
        blockInfo.uncompressedOffset += this.uncompressedOffset;
    }

    public void setOffsets(IndexDecoder indexDecoder) {
        this.recordOffset = indexDecoder.recordOffset + (int)indexDecoder.recordCount;
        this.compressedOffset = indexDecoder.compressedOffset + indexDecoder.getStreamSize() + indexDecoder.streamPadding;
        if (!$assertionsDisabled && (3 & this.compressedOffset) != 0) {
            throw new AssertionError();
        }
        this.uncompressedOffset = indexDecoder.uncompressedOffset + indexDecoder.uncompressedSum;
    }
}

