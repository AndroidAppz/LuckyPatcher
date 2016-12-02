package org.tukaani.xz.rangecoder;

import com.chelpus.Common;
import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.util.InternalZipConstants;

public final class RangeEncoder extends RangeCoder {
    static final /* synthetic */ boolean $assertionsDisabled = (!RangeEncoder.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final int BIT_PRICE_SHIFT_BITS = 4;
    private static final int MOVE_REDUCING_BITS = 4;
    private static final int[] prices = new int[Common.INSTALL_ALLOW_DOWNGRADE];
    private final byte[] buf;
    private int bufPos;
    private byte cache;
    private int cacheSize;
    private long low;
    private int range;

    static {
        for (int i = 8; i < InternalZipConstants.UFT8_NAMES_FLAG; i += 16) {
            int w = i;
            int bitCount = 0;
            for (int j = 0; j < MOVE_REDUCING_BITS; j++) {
                w *= w;
                bitCount <<= 1;
                while ((-65536 & w) != 0) {
                    w >>>= 1;
                    bitCount++;
                }
            }
            prices[i >> MOVE_REDUCING_BITS] = 161 - bitCount;
        }
    }

    public RangeEncoder(int bufSize) {
        this.buf = new byte[bufSize];
        reset();
    }

    public void reset() {
        this.low = 0;
        this.range = -1;
        this.cache = (byte) 0;
        this.cacheSize = 1;
        this.bufPos = 0;
    }

    public int getPendingSize() {
        return ((this.bufPos + this.cacheSize) + 5) - 1;
    }

    public int finish() {
        for (int i = 0; i < 5; i++) {
            shiftLow();
        }
        return this.bufPos;
    }

    public void write(OutputStream out) throws IOException {
        out.write(this.buf, 0, this.bufPos);
    }

    private void shiftLow() {
        int lowHi = (int) (this.low >>> 32);
        if (lowHi != 0 || this.low < 4278190080L) {
            int temp = this.cache;
            int i;
            do {
                byte[] bArr = this.buf;
                int i2 = this.bufPos;
                this.bufPos = i2 + 1;
                bArr[i2] = (byte) (temp + lowHi);
                temp = 255;
                i = this.cacheSize - 1;
                this.cacheSize = i;
            } while (i != 0);
            this.cache = (byte) ((int) (this.low >>> 24));
        }
        this.cacheSize++;
        this.low = (this.low & 16777215) << 8;
    }

    public void encodeBit(short[] probs, int index, int bit) {
        int prob = probs[index];
        int bound = (this.range >>> 11) * prob;
        if (bit == 0) {
            this.range = bound;
            probs[index] = (short) (((2048 - prob) >>> 5) + prob);
        } else {
            this.low += ((long) bound) & InternalZipConstants.ZIP_64_LIMIT;
            this.range -= bound;
            probs[index] = (short) (prob - (prob >>> 5));
        }
        if ((this.range & -16777216) == 0) {
            this.range <<= 8;
            shiftLow();
        }
    }

    public static int getBitPrice(int prob, int bit) {
        if ($assertionsDisabled || bit == 0 || bit == 1) {
            return prices[(((-bit) & 2047) ^ prob) >>> MOVE_REDUCING_BITS];
        }
        throw new AssertionError();
    }

    public void encodeBitTree(short[] probs, int symbol) {
        int index = 1;
        int mask = probs.length;
        do {
            mask >>>= 1;
            int bit = symbol & mask;
            encodeBit(probs, index, bit);
            index <<= 1;
            if (bit != 0) {
                index |= 1;
            }
        } while (mask != 1);
    }

    public static int getBitTreePrice(short[] probs, int symbol) {
        int price = 0;
        symbol |= probs.length;
        do {
            int bit = symbol & 1;
            symbol >>>= 1;
            price += getBitPrice(probs[symbol], bit);
        } while (symbol != 1);
        return price;
    }

    public void encodeReverseBitTree(short[] probs, int symbol) {
        int index = 1;
        symbol |= probs.length;
        do {
            int bit = symbol & 1;
            symbol >>>= 1;
            encodeBit(probs, index, bit);
            index = (index << 1) | bit;
        } while (symbol != 1);
    }

    public static int getReverseBitTreePrice(short[] probs, int symbol) {
        int price = 0;
        int index = 1;
        symbol |= probs.length;
        do {
            int bit = symbol & 1;
            symbol >>>= 1;
            price += getBitPrice(probs[index], bit);
            index = (index << 1) | bit;
        } while (symbol != 1);
        return price;
    }

    public void encodeDirectBits(int value, int count) {
        do {
            this.range >>>= 1;
            count--;
            this.low += (long) (this.range & (0 - ((value >>> count) & 1)));
            if ((this.range & -16777216) == 0) {
                this.range <<= 8;
                shiftLow();
                continue;
            }
        } while (count != 0);
    }

    public static int getDirectBitsPrice(int count) {
        return count << MOVE_REDUCING_BITS;
    }
}
