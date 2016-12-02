/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.InputStream
 */
package org.tukaani.xz.rangecoder;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.rangecoder.RangeDecoder;

public final class RangeDecoderFromStream
extends RangeDecoder {
    private final DataInputStream inData;

    public RangeDecoderFromStream(InputStream inputStream) throws IOException {
        this.inData = new DataInputStream(inputStream);
        if (this.inData.readUnsignedByte() != 0) {
            throw new CorruptedInputException();
        }
        this.code = this.inData.readInt();
        this.range = -1;
    }

    public boolean isFinished() {
        if (this.code == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void normalize() throws IOException {
        if ((-16777216 & this.range) == 0) {
            this.code = this.code << 8 | this.inData.readUnsignedByte();
            this.range <<= 8;
        }
    }
}

