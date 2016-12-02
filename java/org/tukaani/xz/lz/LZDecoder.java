package org.tukaani.xz.lz;

import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.CorruptedInputException;

public final class LZDecoder {
    private final byte[] buf;
    private int full = 0;
    private int limit = 0;
    private int pendingDist = 0;
    private int pendingLen = 0;
    private int pos = 0;
    private int start = 0;

    public LZDecoder(int dictSize, byte[] presetDict) {
        this.buf = new byte[dictSize];
        if (presetDict != null) {
            this.pos = Math.min(presetDict.length, dictSize);
            this.full = this.pos;
            this.start = this.pos;
            System.arraycopy(presetDict, presetDict.length - this.pos, this.buf, 0, this.pos);
        }
    }

    public void reset() {
        this.start = 0;
        this.pos = 0;
        this.full = 0;
        this.limit = 0;
        this.buf[this.buf.length - 1] = (byte) 0;
    }

    public void setLimit(int outMax) {
        if (this.buf.length - this.pos <= outMax) {
            this.limit = this.buf.length;
        } else {
            this.limit = this.pos + outMax;
        }
    }

    public boolean hasSpace() {
        return this.pos < this.limit;
    }

    public boolean hasPending() {
        return this.pendingLen > 0;
    }

    public int getPos() {
        return this.pos;
    }

    public int getByte(int dist) {
        int offset = (this.pos - dist) - 1;
        if (dist >= this.pos) {
            offset += this.buf.length;
        }
        return this.buf[offset] & 255;
    }

    public void putByte(byte b) {
        byte[] bArr = this.buf;
        int i = this.pos;
        this.pos = i + 1;
        bArr[i] = b;
        if (this.full < this.pos) {
            this.full = this.pos;
        }
    }

    public void repeat(int dist, int len) throws IOException {
        if (dist < 0 || dist >= this.full) {
            throw new CorruptedInputException();
        }
        int left = Math.min(this.limit - this.pos, len);
        this.pendingLen = len - left;
        this.pendingDist = dist;
        int back = (this.pos - dist) - 1;
        if (dist >= this.pos) {
            back += this.buf.length;
        }
        do {
            byte[] bArr = this.buf;
            int i = this.pos;
            this.pos = i + 1;
            int back2 = back + 1;
            bArr[i] = this.buf[back];
            if (back2 == this.buf.length) {
                back = 0;
            } else {
                back = back2;
            }
            left--;
        } while (left > 0);
        if (this.full < this.pos) {
            this.full = this.pos;
        }
    }

    public void repeatPending() throws IOException {
        if (this.pendingLen > 0) {
            repeat(this.pendingDist, this.pendingLen);
        }
    }

    public void copyUncompressed(DataInputStream inData, int len) throws IOException {
        int copySize = Math.min(this.buf.length - this.pos, len);
        inData.readFully(this.buf, this.pos, copySize);
        this.pos += copySize;
        if (this.full < this.pos) {
            this.full = this.pos;
        }
    }

    public int flush(byte[] out, int outOff) {
        int copySize = this.pos - this.start;
        if (this.pos == this.buf.length) {
            this.pos = 0;
        }
        System.arraycopy(this.buf, this.start, out, outOff, copySize);
        this.start = this.pos;
        return copySize;
    }
}
