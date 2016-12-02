/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromStream;

public class LZMAInputStream
extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DICT_SIZE_MAX = 2147483632;
    private boolean endReached;
    private IOException exception;
    private InputStream in;
    private LZDecoder lz;
    private LZMADecoder lzma;
    private RangeDecoderFromStream rc;
    private long remainingSize;
    private final byte[] tempBuf;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !LZMAInputStream.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    public LZMAInputStream(InputStream inputStream) throws IOException {
        super(inputStream, -1);
    }

    public LZMAInputStream(InputStream inputStream, int n) throws IOException {
        this.endReached = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte by = dataInputStream.readByte();
        int n2 = 0;
        for (int i = 0; i < 4; ++i) {
            n2 |= dataInputStream.readUnsignedByte() << i * 8;
        }
        long l = 0;
        for (int j = 0; j < 8; ++j) {
            l |= (long)dataInputStream.readUnsignedByte() << j * 8;
        }
        int n3 = LZMAInputStream.getMemoryUsage(n2, by);
        if (n != -1 && n3 > n) {
            throw new MemoryLimitException(n3, n);
        }
        super.initialize(inputStream, l, by, n2, null);
    }

    public LZMAInputStream(InputStream inputStream, long l, byte by, int n) throws IOException {
        this.endReached = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        super.initialize(inputStream, l, by, n, null);
    }

    public LZMAInputStream(InputStream inputStream, long l, byte by, int n, byte[] arrby) throws IOException {
        this.endReached = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        this.initialize(inputStream, l, by, n, arrby);
    }

    public LZMAInputStream(InputStream inputStream, long l, int n, int n2, int n3, int n4, byte[] arrby) throws IOException {
        this.endReached = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        super.initialize(inputStream, l, n, n2, n3, n4, arrby);
    }

    private static int getDictSize(int n) {
        if (n < 0 || n > 2147483632) {
            throw new IllegalArgumentException("LZMA dictionary is too big for this implementation");
        }
        if (n < 4096) {
            n = 4096;
        }
        return -16 & n + 15;
    }

    public static int getMemoryUsage(int n, byte by) throws UnsupportedOptionsException, CorruptedInputException {
        if (n < 0 || n > 2147483632) {
            throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
        }
        int n2 = by & 255;
        if (n2 > 224) {
            throw new CorruptedInputException("Invalid LZMA properties byte");
        }
        int n3 = n2 % 45;
        int n4 = n3 / 9;
        return LZMAInputStream.getMemoryUsage(n, n3 - n4 * 9, n4);
    }

    public static int getMemoryUsage(int n, int n2, int n3) {
        if (n2 < 0 || n2 > 8 || n3 < 0 || n3 > 4) {
            throw new IllegalArgumentException("Invalid lc or lp");
        }
        return 10 + LZMAInputStream.getDictSize(n) / 1024 + (1536 << n2 + n3) / 1024;
    }

    private void initialize(InputStream inputStream, long l, byte by, int n, byte[] arrby) throws IOException {
        if (l < -1) {
            throw new UnsupportedOptionsException("Uncompressed size is too big");
        }
        int n2 = by & 255;
        if (n2 > 224) {
            throw new CorruptedInputException("Invalid LZMA properties byte");
        }
        int n3 = n2 / 45;
        int n4 = n2 - 5 * (n3 * 9);
        int n5 = n4 / 9;
        int n6 = n4 - n5 * 9;
        if (n < 0 || n > 2147483632) {
            throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
        }
        this.initialize(inputStream, l, n6, n5, n3, n, arrby);
    }

    private void initialize(InputStream inputStream, long l, int n, int n2, int n3, int n4, byte[] arrby) throws IOException {
        if (l < -1 || n < 0 || n > 8 || n2 < 0 || n2 > 4 || n3 < 0 || n3 > 4) {
            throw new IllegalArgumentException();
        }
        this.in = inputStream;
        int n5 = LZMAInputStream.getDictSize(n4);
        if (l >= 0 && (long)n5 > l) {
            n5 = LZMAInputStream.getDictSize((int)l);
        }
        this.lz = new LZDecoder(LZMAInputStream.getDictSize(n5), arrby);
        this.rc = new RangeDecoderFromStream(inputStream);
        this.lzma = new LZMADecoder(this.lz, this.rc, n, n2, n3);
        this.remainingSize = l;
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read(byte[] arrby, int n, int n2) throws IOException {
        if (n < 0) throw new IndexOutOfBoundsException();
        if (n2 < 0) throw new IndexOutOfBoundsException();
        if (n + n2 < 0) throw new IndexOutOfBoundsException();
        if (n + n2 > arrby.length) {
            throw new IndexOutOfBoundsException();
        }
        if (n2 == 0) {
            return 0;
        }
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (this.exception != null) {
            throw this.exception;
        }
        if (this.endReached) {
            return -1;
        }
        int n3 = 0;
        do {
            int n4;
            if (n2 <= 0) return n3;
            int n5 = n2;
            try {
                if (this.remainingSize >= 0 && this.remainingSize < (long)n2) {
                    n5 = (int)this.remainingSize;
                }
                this.lz.setLimit(n5);
                try {
                    this.lzma.decode();
                }
                catch (CorruptedInputException var7_7) {
                    if (this.remainingSize != -1) throw var7_7;
                    if (!this.lzma.endMarkerDetected()) {
                        throw var7_7;
                    }
                    this.endReached = true;
                    this.rc.normalize();
                }
                n4 = this.lz.flush(arrby, n);
                n += n4;
                n2 -= n4;
                n3 += n4;
            }
            catch (IOException var6_8) {
                this.exception = var6_8;
                throw var6_8;
            }
            if (this.remainingSize < 0) continue;
            this.remainingSize -= (long)n4;
            if (!$assertionsDisabled && this.remainingSize < 0) {
                throw new AssertionError();
            }
            if (this.remainingSize != 0) continue;
            this.endReached = true;
        } while (!this.endReached);
        if (!this.rc.isFinished()) throw new CorruptedInputException();
        if (this.lz.hasPending()) {
            throw new CorruptedInputException();
        }
        if (n3 != 0) return n3;
        return -1;
    }
}

