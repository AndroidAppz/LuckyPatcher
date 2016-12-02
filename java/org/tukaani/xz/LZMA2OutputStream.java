package org.tukaani.xz;

import com.chelpus.Common;
import java.io.DataOutputStream;
import java.io.IOException;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lzma.LZMAEncoder;
import org.tukaani.xz.rangecoder.RangeEncoder;

class LZMA2OutputStream extends FinishableOutputStream {
    static final /* synthetic */ boolean $assertionsDisabled = (!LZMA2OutputStream.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    static final int COMPRESSED_SIZE_MAX = 65536;
    private boolean dictResetNeeded = true;
    private IOException exception = null;
    private boolean finished = $assertionsDisabled;
    private final LZEncoder lz;
    private final LZMAEncoder lzma;
    private FinishableOutputStream out;
    private final DataOutputStream outData;
    private int pendingSize = 0;
    private final int props;
    private boolean propsNeeded = true;
    private final RangeEncoder rc;
    private boolean stateResetNeeded = true;
    private final byte[] tempBuf = new byte[1];

    private static int getExtraSizeBefore(int dictSize) {
        return COMPRESSED_SIZE_MAX > dictSize ? COMPRESSED_SIZE_MAX - dictSize : 0;
    }

    static int getMemoryUsage(LZMA2Options options) {
        int dictSize = options.getDictSize();
        return LZMAEncoder.getMemoryUsage(options.getMode(), dictSize, getExtraSizeBefore(dictSize), options.getMatchFinder()) + 70;
    }

    LZMA2OutputStream(FinishableOutputStream out, LZMA2Options options) {
        if (out == null) {
            throw new NullPointerException();
        }
        this.out = out;
        this.outData = new DataOutputStream(out);
        this.rc = new RangeEncoder(COMPRESSED_SIZE_MAX);
        int dictSize = options.getDictSize();
        this.lzma = LZMAEncoder.getInstance(this.rc, options.getLc(), options.getLp(), options.getPb(), options.getMode(), dictSize, getExtraSizeBefore(dictSize), options.getNiceLen(), options.getMatchFinder(), options.getDepthLimit());
        this.lz = this.lzma.getLZEncoder();
        byte[] presetDict = options.getPresetDict();
        if (presetDict != null && presetDict.length > 0) {
            this.lz.setPresetDict(dictSize, presetDict);
            this.dictResetNeeded = $assertionsDisabled;
        }
        this.props = (((options.getPb() * 5) + options.getLp()) * 9) + options.getLc();
    }

    public void write(int b) throws IOException {
        this.tempBuf[0] = (byte) b;
        write(this.tempBuf, 0, 1);
    }

    public void write(byte[] buf, int off, int len) throws IOException {
        if (off < 0 || len < 0 || off + len < 0 || off + len > buf.length) {
            throw new IndexOutOfBoundsException();
        } else if (this.exception != null) {
            throw this.exception;
        } else if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        } else {
            while (len > 0) {
                try {
                    int used = this.lz.fillWindow(buf, off, len);
                    off += used;
                    len -= used;
                    this.pendingSize += used;
                    if (this.lzma.encodeForLZMA2()) {
                        writeChunk();
                    }
                } catch (IOException e) {
                    this.exception = e;
                    throw e;
                }
            }
        }
    }

    private void writeChunk() throws IOException {
        int compressedSize = this.rc.finish();
        int uncompressedSize = this.lzma.getUncompressedSize();
        if (!$assertionsDisabled && compressedSize <= 0) {
            throw new AssertionError(compressedSize);
        } else if ($assertionsDisabled || uncompressedSize > 0) {
            if (compressedSize + 2 < uncompressedSize) {
                writeLZMA(uncompressedSize, compressedSize);
            } else {
                this.lzma.reset();
                uncompressedSize = this.lzma.getUncompressedSize();
                if ($assertionsDisabled || uncompressedSize > 0) {
                    writeUncompressed(uncompressedSize);
                } else {
                    throw new AssertionError(uncompressedSize);
                }
            }
            this.pendingSize -= uncompressedSize;
            this.lzma.resetUncompressedSize();
            this.rc.reset();
        } else {
            throw new AssertionError(uncompressedSize);
        }
    }

    private void writeLZMA(int uncompressedSize, int compressedSize) throws IOException {
        int control;
        if (this.propsNeeded) {
            if (this.dictResetNeeded) {
                control = 224;
            } else {
                control = 192;
            }
        } else if (this.stateResetNeeded) {
            control = 160;
        } else {
            control = Common.INSTALL_ALLOW_DOWNGRADE;
        }
        this.outData.writeByte(control | ((uncompressedSize - 1) >>> 16));
        this.outData.writeShort(uncompressedSize - 1);
        this.outData.writeShort(compressedSize - 1);
        if (this.propsNeeded) {
            this.outData.writeByte(this.props);
        }
        this.rc.write(this.out);
        this.propsNeeded = $assertionsDisabled;
        this.stateResetNeeded = $assertionsDisabled;
        this.dictResetNeeded = $assertionsDisabled;
    }

    private void writeUncompressed(int uncompressedSize) throws IOException {
        while (uncompressedSize > 0) {
            int chunkSize = Math.min(uncompressedSize, COMPRESSED_SIZE_MAX);
            this.outData.writeByte(this.dictResetNeeded ? 1 : 2);
            this.outData.writeShort(chunkSize - 1);
            this.lz.copyUncompressed(this.out, uncompressedSize, chunkSize);
            uncompressedSize -= chunkSize;
            this.dictResetNeeded = $assertionsDisabled;
        }
        this.stateResetNeeded = true;
    }

    private void writeEndMarker() throws IOException {
        if (!$assertionsDisabled && this.finished) {
            throw new AssertionError();
        } else if (this.exception != null) {
            throw this.exception;
        } else {
            this.lz.setFinishing();
            while (this.pendingSize > 0) {
                try {
                    this.lzma.encodeForLZMA2();
                    writeChunk();
                } catch (IOException e) {
                    this.exception = e;
                    throw e;
                }
            }
            this.out.write(0);
            this.finished = true;
        }
    }

    public void flush() throws IOException {
        if (this.exception != null) {
            throw this.exception;
        } else if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        } else {
            try {
                this.lz.setFlushing();
                while (this.pendingSize > 0) {
                    this.lzma.encodeForLZMA2();
                    writeChunk();
                }
                this.out.flush();
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            writeEndMarker();
            try {
                this.out.finish();
                this.finished = true;
            } catch (IOException e) {
                this.exception = e;
                throw e;
            }
        }
    }

    public void close() throws IOException {
        if (this.out != null) {
            if (!this.finished) {
                try {
                    writeEndMarker();
                } catch (IOException e) {
                }
            }
            try {
                this.out.close();
            } catch (IOException e2) {
                if (this.exception == null) {
                    this.exception = e2;
                }
            }
            this.out = null;
        }
        if (this.exception != null) {
            throw this.exception;
        }
    }
}
