package org.tukaani.xz.rangecoder;

import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.CorruptedInputException;

public final class RangeDecoderFromBuffer extends RangeDecoder {
    private static final int INIT_SIZE = 5;
    private final byte[] buf;
    private int end = 0;
    private int pos = 0;

    public RangeDecoderFromBuffer(int inputSizeMax) {
        this.buf = new byte[(inputSizeMax - 5)];
    }

    public void prepareInputBuffer(DataInputStream in, int len) throws IOException {
        if (len < INIT_SIZE) {
            throw new CorruptedInputException();
        } else if (in.readUnsignedByte() != 0) {
            throw new CorruptedInputException();
        } else {
            this.code = in.readInt();
            this.range = -1;
            this.pos = 0;
            this.end = len - 5;
            in.readFully(this.buf, 0, this.end);
        }
    }

    public boolean isInBufferOK() {
        return this.pos <= this.end;
    }

    public boolean isFinished() {
        return this.pos == this.end && this.code == 0;
    }

    public void normalize() throws IOException {
        if ((this.range & -16777216) == 0) {
            try {
                int i = this.code << 8;
                byte[] bArr = this.buf;
                int i2 = this.pos;
                this.pos = i2 + 1;
                this.code = i | (bArr[i2] & 255);
                this.range <<= 8;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new CorruptedInputException();
            }
        }
    }
}
