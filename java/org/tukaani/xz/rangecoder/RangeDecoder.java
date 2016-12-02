package org.tukaani.xz.rangecoder;

import java.io.IOException;

public abstract class RangeDecoder extends RangeCoder {
    int code = 0;
    int range = 0;

    public abstract void normalize() throws IOException;

    public int decodeBit(short[] probs, int index) throws IOException {
        normalize();
        int prob = probs[index];
        int bound = (this.range >>> 11) * prob;
        if ((this.code ^ Integer.MIN_VALUE) < (Integer.MIN_VALUE ^ bound)) {
            this.range = bound;
            probs[index] = (short) (((2048 - prob) >>> 5) + prob);
            return 0;
        }
        this.range -= bound;
        this.code -= bound;
        probs[index] = (short) (prob - (prob >>> 5));
        return 1;
    }

    public int decodeBitTree(short[] probs) throws IOException {
        int symbol = 1;
        do {
            symbol = (symbol << 1) | decodeBit(probs, symbol);
        } while (symbol < probs.length);
        return symbol - probs.length;
    }

    public int decodeReverseBitTree(short[] probs) throws IOException {
        int symbol = 1;
        int i = 0;
        int result = 0;
        while (true) {
            int bit = decodeBit(probs, symbol);
            symbol = (symbol << 1) | bit;
            int i2 = i + 1;
            result |= bit << i;
            if (symbol >= probs.length) {
                return result;
            }
            i = i2;
        }
    }

    public int decodeDirectBits(int count) throws IOException {
        int result = 0;
        do {
            normalize();
            this.range >>>= 1;
            int t = (this.code - this.range) >>> 31;
            this.code -= this.range & (t - 1);
            result = (result << 1) | (1 - t);
            count--;
        } while (count != 0);
        return result;
    }
}
