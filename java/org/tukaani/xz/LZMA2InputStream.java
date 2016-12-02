/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromBuffer;

public class LZMA2InputStream
extends InputStream {
    private static final int COMPRESSED_SIZE_MAX = 65536;
    public static final int DICT_SIZE_MAX = 2147483632;
    public static final int DICT_SIZE_MIN = 4096;
    private boolean endReached;
    private IOException exception;
    private DataInputStream in;
    private boolean isLZMAChunk;
    private final LZDecoder lz;
    private LZMADecoder lzma;
    private boolean needDictReset;
    private boolean needProps;
    private final RangeDecoderFromBuffer rc;
    private final byte[] tempBuf;
    private int uncompressedSize;

    public LZMA2InputStream(InputStream inputStream, int n) {
        super(inputStream, n, null);
    }

    public LZMA2InputStream(InputStream inputStream, int n, byte[] arrby) {
        this.rc = new RangeDecoderFromBuffer(65536);
        this.uncompressedSize = 0;
        this.needDictReset = true;
        this.needProps = true;
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        if (inputStream == null) {
            throw new NullPointerException();
        }
        this.in = new DataInputStream(inputStream);
        this.lz = new LZDecoder(LZMA2InputStream.getDictSize(n), arrby);
        if (arrby != null && arrby.length > 0) {
            this.needDictReset = false;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void decodeChunkHeader() throws IOException {
        int n = this.in.readUnsignedByte();
        if (n == 0) {
            this.endReached = true;
            return;
        }
        if (n >= 224 || n == 1) {
            this.needProps = true;
            this.needDictReset = false;
            this.lz.reset();
        } else if (this.needDictReset) {
            throw new CorruptedInputException();
        }
        if (n >= 128) {
            this.isLZMAChunk = true;
            this.uncompressedSize = (n & 31) << 16;
            this.uncompressedSize += 1 + this.in.readUnsignedShort();
            int n2 = 1 + this.in.readUnsignedShort();
            if (n >= 192) {
                this.needProps = false;
                this.decodeProps();
            } else {
                if (this.needProps) {
                    throw new CorruptedInputException();
                }
                if (n >= 160) {
                    this.lzma.reset();
                }
            }
            this.rc.prepareInputBuffer(this.in, n2);
            return;
        }
        if (n > 2) {
            throw new CorruptedInputException();
        }
        this.isLZMAChunk = false;
        this.uncompressedSize = 1 + this.in.readUnsignedShort();
    }

    private void decodeProps() throws IOException {
        int n = this.in.readUnsignedByte();
        if (n > 224) {
            throw new CorruptedInputException();
        }
        int n2 = n / 45;
        int n3 = n - 5 * (n2 * 9);
        int n4 = n3 / 9;
        int n5 = n3 - n4 * 9;
        if (n5 + n4 > 4) {
            throw new CorruptedInputException();
        }
        this.lzma = new LZMADecoder(this.lz, this.rc, n5, n4, n2);
    }

    private static int getDictSize(int n) {
        if (n < 4096 || n > 2147483632) {
            throw new IllegalArgumentException("Unsupported dictionary size " + n);
        }
        return -16 & n + 15;
    }

    public static int getMemoryUsage(int n) {
        return 104 + LZMA2InputStream.getDictSize(n) / 1024;
    }

    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (this.exception != null) {
            throw this.exception;
        }
        return this.uncompressedSize;
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
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 0[TRYBLOCK]
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

