/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZFormatException;
import org.tukaani.xz.XZIOException;

public class XZInputStream
extends InputStream {
    private boolean endReached;
    private IOException exception;
    private InputStream in;
    private final int memoryLimit;
    private final byte[] tempBuf;
    private SingleXZInputStream xzIn;

    public XZInputStream(InputStream inputStream) throws IOException {
        super(inputStream, -1);
    }

    public XZInputStream(InputStream inputStream, int n) throws IOException {
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        this.in = inputStream;
        this.memoryLimit = n;
        this.xzIn = new SingleXZInputStream(inputStream, n);
    }

    private void prepareNextStream() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(this.in);
        byte[] arrby = new byte[12];
        do {
            if (dataInputStream.read(arrby, 0, 1) == -1) {
                this.endReached = true;
                return;
            }
            dataInputStream.readFully(arrby, 1, 3);
        } while (arrby[0] == 0 && arrby[1] == 0 && arrby[2] == 0 && arrby[3] == 0);
        dataInputStream.readFully(arrby, 4, 8);
        try {
            this.xzIn = new SingleXZInputStream(this.in, this.memoryLimit, arrby);
            return;
        }
        catch (XZFormatException var3_3) {
            throw new CorruptedInputException("Garbage after a valid XZ Stream");
        }
    }

    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (this.exception != null) {
            throw this.exception;
        }
        if (this.xzIn == null) {
            return 0;
        }
        return this.xzIn.available();
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
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
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
        while (n2 > 0) {
            int n4;
            if (this.xzIn == null) {
                super.prepareNextStream();
                if (this.endReached) {
                    if (n3 != 0) return n3;
                    return -1;
                }
            }
            if ((n4 = this.xzIn.read(arrby, n, n2)) > 0) {
                n3 += n4;
                n += n4;
                n2 -= n4;
                continue;
            }
            if (n4 != -1) continue;
            this.xzIn = null;
            continue;
        }
        return n3;
        catch (IOException iOException) {
            this.exception = iOException;
            if (n3 != 0) return n3;
            throw iOException;
        }
    }
}

