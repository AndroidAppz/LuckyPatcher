/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.lang.ArrayIndexOutOfBoundsException
 */
package org.tukaani.xz.rangecoder;

import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.rangecoder.RangeDecoder;

public final class RangeDecoderFromBuffer
extends RangeDecoder {
    private static final int INIT_SIZE = 5;
    private final byte[] buf;
    private int end = 0;
    private int pos = 0;

    public RangeDecoderFromBuffer(int n) {
        this.buf = new byte[n - 5];
    }

    public boolean isFinished() {
        if (this.pos == this.end && this.code == 0) {
            return true;
        }
        return false;
    }

    public boolean isInBufferOK() {
        if (this.pos <= this.end) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void normalize() throws IOException {
        if ((-16777216 & this.range) != 0) return;
        try {
            int n = this.code << 8;
            byte[] arrby = this.buf;
            int n2 = this.pos;
            this.pos = n2 + 1;
            this.code = n | 255 & arrby[n2];
            this.range <<= 8;
            return;
        }
        catch (ArrayIndexOutOfBoundsException var1_4) {
            throw new CorruptedInputException();
        }
    }

    public void prepareInputBuffer(DataInputStream dataInputStream, int n) throws IOException {
        if (n < 5) {
            throw new CorruptedInputException();
        }
        if (dataInputStream.readUnsignedByte() != 0) {
            throw new CorruptedInputException();
        }
        this.code = dataInputStream.readInt();
        this.range = -1;
        this.pos = 0;
        this.end = n - 5;
        dataInputStream.readFully(this.buf, 0, this.end);
    }
}

