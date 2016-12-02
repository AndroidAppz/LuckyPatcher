/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.BlockInputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexHash;

public class SingleXZInputStream
extends InputStream {
    private BlockInputStream blockDecoder = null;
    private Check check;
    private boolean endReached = false;
    private IOException exception = null;
    private InputStream in;
    private final IndexHash indexHash = new IndexHash();
    private int memoryLimit;
    private StreamFlags streamHeaderFlags;
    private final byte[] tempBuf = new byte[1];

    public SingleXZInputStream(InputStream inputStream) throws IOException {
        super.initialize(inputStream, -1);
    }

    public SingleXZInputStream(InputStream inputStream, int n) throws IOException {
        super.initialize(inputStream, n);
    }

    SingleXZInputStream(InputStream inputStream, int n, byte[] arrby) throws IOException {
        super.initialize(inputStream, n, arrby);
    }

    private void initialize(InputStream inputStream, int n) throws IOException {
        byte[] arrby = new byte[12];
        new DataInputStream(inputStream).readFully(arrby);
        super.initialize(inputStream, n, arrby);
    }

    private void initialize(InputStream inputStream, int n, byte[] arrby) throws IOException {
        this.in = inputStream;
        this.memoryLimit = n;
        this.streamHeaderFlags = DecoderUtil.decodeStreamHeader(arrby);
        this.check = Check.getInstance(this.streamHeaderFlags.checkType);
    }

    private void validateStreamFooter() throws IOException {
        byte[] arrby = new byte[12];
        new DataInputStream(this.in).readFully(arrby);
        StreamFlags streamFlags = DecoderUtil.decodeStreamFooter(arrby);
        if (!DecoderUtil.areStreamFlagsEqual(this.streamHeaderFlags, streamFlags) || this.indexHash.getIndexSize() != streamFlags.backwardSize) {
            throw new CorruptedInputException("XZ Stream Footer does not match Stream Header");
        }
    }

    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (this.exception != null) {
            throw this.exception;
        }
        if (this.blockDecoder == null) {
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

    public String getCheckName() {
        return this.check.getName();
    }

    public int getCheckType() {
        return this.streamHeaderFlags.checkType;
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
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 2[TRYBLOCK]
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
}

