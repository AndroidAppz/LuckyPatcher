/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.reflect.Array
 */
package org.tukaani.xz.lzma;

import java.lang.reflect.Array;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.lzma.LZMACoder;
import org.tukaani.xz.lzma.LZMAEncoderFast;
import org.tukaani.xz.lzma.LZMAEncoderNormal;
import org.tukaani.xz.lzma.State;
import org.tukaani.xz.rangecoder.RangeEncoder;

public abstract class LZMAEncoder
extends LZMACoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ALIGN_PRICE_UPDATE_INTERVAL = 16;
    private static final int DIST_PRICE_UPDATE_INTERVAL = 128;
    private static final int LZMA2_COMPRESSED_LIMIT = 65510;
    private static final int LZMA2_UNCOMPRESSED_LIMIT = 2096879;
    public static final int MODE_FAST = 1;
    public static final int MODE_NORMAL = 2;
    private int alignPriceCount = 0;
    private final int[] alignPrices;
    int back;
    private int distPriceCount = 0;
    private final int[][] distSlotPrices;
    private final int distSlotPricesSize;
    private final int[][] fullDistPrices;
    final LiteralEncoder literalEncoder;
    final LZEncoder lz;
    final LengthEncoder matchLenEncoder;
    final int niceLen;
    private final RangeEncoder rc;
    int readAhead;
    final LengthEncoder repLenEncoder;
    private int uncompressedSize;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !LZMAEncoder.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    LZMAEncoder(RangeEncoder rangeEncoder, LZEncoder lZEncoder, int n, int n2, int n3, int n4, int n5) {
        super(n3);
        int[] arrn = new int[]{4, 128};
        this.fullDistPrices = (int[][])Array.newInstance((Class)Integer.TYPE, (int[])arrn);
        this.alignPrices = new int[16];
        this.back = 0;
        this.readAhead = -1;
        this.uncompressedSize = 0;
        this.rc = rangeEncoder;
        this.lz = lZEncoder;
        this.niceLen = n5;
        this.literalEncoder = new LiteralEncoder(n, n2);
        this.matchLenEncoder = new LengthEncoder(n3, n5);
        this.repLenEncoder = new LengthEncoder(n3, n5);
        this.distSlotPricesSize = 1 + LZMAEncoder.getDistSlot(n4 - 1);
        int[] arrn2 = new int[]{4, this.distSlotPricesSize};
        this.distSlotPrices = (int[][])Array.newInstance((Class)Integer.TYPE, (int[])arrn2);
        this.reset();
    }

    private boolean encodeInit() {
        if (!$assertionsDisabled && this.readAhead != -1) {
            throw new AssertionError();
        }
        if (!this.lz.hasEnoughData(0)) {
            return false;
        }
        this.skip(1);
        this.rc.encodeBit(this.isMatch[this.state.get()], 0, 0);
        this.literalEncoder.encodeInit();
        this.readAhead = -1 + this.readAhead;
        if (!$assertionsDisabled && this.readAhead != -1) {
            throw new AssertionError();
        }
        this.uncompressedSize = 1 + this.uncompressedSize;
        if (!$assertionsDisabled && this.uncompressedSize != 1) {
            throw new AssertionError();
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void encodeMatch(int n, int n2, int n3) {
        this.state.updateMatch();
        this.matchLenEncoder.encode(n2, n3);
        int n4 = LZMAEncoder.getDistSlot(n);
        this.rc.encodeBitTree(this.distSlots[LZMAEncoder.getDistState(n2)], n4);
        if (n4 >= 4) {
            int n5 = -1 + (n4 >>> 1);
            int n6 = n - ((2 | n4 & 1) << n5);
            if (n4 < 14) {
                this.rc.encodeReverseBitTree(this.distSpecial[n4 - 4], n6);
            } else {
                this.rc.encodeDirectBits(n6 >>> 4, n5 - 4);
                this.rc.encodeReverseBitTree(this.distAlign, n6 & 15);
                this.alignPriceCount = -1 + this.alignPriceCount;
            }
        }
        this.reps[3] = this.reps[2];
        this.reps[2] = this.reps[1];
        this.reps[1] = this.reps[0];
        this.reps[0] = n;
        this.distPriceCount = -1 + this.distPriceCount;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void encodeRepMatch(int n, int n2, int n3) {
        if (n == 0) {
            this.rc.encodeBit(this.isRep0, this.state.get(), 0);
            RangeEncoder rangeEncoder = this.rc;
            short[] arrs = this.isRep0Long[this.state.get()];
            int n4 = 0;
            if (n2 != 1) {
                n4 = 1;
            }
            rangeEncoder.encodeBit(arrs, n3, n4);
        } else {
            int n5 = this.reps[n];
            this.rc.encodeBit(this.isRep0, this.state.get(), 1);
            if (n == 1) {
                this.rc.encodeBit(this.isRep1, this.state.get(), 0);
            } else {
                this.rc.encodeBit(this.isRep1, this.state.get(), 1);
                this.rc.encodeBit(this.isRep2, this.state.get(), n - 2);
                if (n == 3) {
                    this.reps[3] = this.reps[2];
                }
                this.reps[2] = this.reps[1];
            }
            this.reps[1] = this.reps[0];
            this.reps[0] = n5;
        }
        if (n2 == 1) {
            this.state.updateShortRep();
            return;
        }
        this.repLenEncoder.encode(n2, n3);
        this.state.updateLongRep();
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean encodeSymbol() {
        if (!this.lz.hasEnoughData(1 + this.readAhead)) {
            return false;
        }
        int n = this.getNextSymbol();
        if (!$assertionsDisabled && this.readAhead < 0) {
            throw new AssertionError();
        }
        int n2 = this.lz.getPos() - this.readAhead & this.posMask;
        if (this.back == -1) {
            if (!$assertionsDisabled && n != 1) {
                throw new AssertionError();
            }
            this.rc.encodeBit(this.isMatch[this.state.get()], n2, 0);
            this.literalEncoder.encode();
        } else {
            this.rc.encodeBit(this.isMatch[this.state.get()], n2, 1);
            if (this.back < 4) {
                if (!$assertionsDisabled && this.lz.getMatchLen(- this.readAhead, this.reps[this.back], n) != n) {
                    throw new AssertionError();
                }
                this.rc.encodeBit(this.isRep, this.state.get(), 1);
                this.encodeRepMatch(this.back, n, n2);
            } else {
                if (!$assertionsDisabled && this.lz.getMatchLen(- this.readAhead, -4 + this.back, n) != n) {
                    throw new AssertionError();
                }
                this.rc.encodeBit(this.isRep, this.state.get(), 0);
                this.encodeMatch(-4 + this.back, n, n2);
            }
        }
        this.readAhead -= n;
        this.uncompressedSize = n + this.uncompressedSize;
        return true;
    }

    public static int getDistSlot(int n) {
        if (n <= 4) {
            return n;
        }
        int n2 = n;
        int n3 = 31;
        if ((-65536 & n2) == 0) {
            n2 <<= 16;
            n3 = 15;
        }
        if ((-16777216 & n2) == 0) {
            n2 <<= 8;
            n3 -= 8;
        }
        if ((-268435456 & n2) == 0) {
            n2 <<= 4;
            n3 -= 4;
        }
        if ((-1073741824 & n2) == 0) {
            n2 <<= 2;
            n3 -= 2;
        }
        if ((Integer.MIN_VALUE & n2) == 0) {
            --n3;
        }
        return (n3 << 1) + (1 & n >>> n3 - 1);
    }

    public static LZMAEncoder getInstance(RangeEncoder rangeEncoder, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        switch (n4) {
            default: {
                throw new IllegalArgumentException();
            }
            case 1: {
                return new LZMAEncoderFast(rangeEncoder, n, n2, n3, n5, n6, n7, n8, n9);
            }
            case 2: 
        }
        return new LZMAEncoderNormal(rangeEncoder, n, n2, n3, n5, n6, n7, n8, n9);
    }

    public static int getMemoryUsage(int n, int n2, int n3, int n4) {
        switch (n) {
            default: {
                throw new IllegalArgumentException();
            }
            case 1: {
                return 80 + LZMAEncoderFast.getMemoryUsage(n2, n3, n4);
            }
            case 2: 
        }
        return 80 + LZMAEncoderNormal.getMemoryUsage(n2, n3, n4);
    }

    private void updateAlignPrices() {
        this.alignPriceCount = 16;
        for (int i = 0; i < 16; ++i) {
            this.alignPrices[i] = RangeEncoder.getReverseBitTreePrice(this.distAlign, i);
        }
    }

    private void updateDistPrices() {
        this.distPriceCount = 128;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < this.distSlotPricesSize; ++j) {
                this.distSlotPrices[i][j] = RangeEncoder.getBitTreePrice(this.distSlots[i], j);
            }
            for (int k = 14; k < this.distSlotPricesSize; ++k) {
                int n = -4 + (-1 + (k >>> 1));
                int[] arrn = this.distSlotPrices[i];
                arrn[k] = arrn[k] + RangeEncoder.getDirectBitsPrice(n);
            }
            for (int i2 = 0; i2 < 4; ++i2) {
                this.fullDistPrices[i][i2] = this.distSlotPrices[i][i2];
            }
        }
        int n = 4;
        for (int j = 4; j < 14; ++j) {
            int n2 = -1 + (j >>> 1);
            int n3 = (2 | j & 1) << n2;
            int n4 = this.distSpecial[j - 4].length;
            for (int k = 0; k < n4; ++k) {
                int n5 = n - n3;
                int n6 = RangeEncoder.getReverseBitTreePrice(this.distSpecial[j - 4], n5);
                for (int i3 = 0; i3 < 4; ++i3) {
                    this.fullDistPrices[i3][n] = n6 + this.distSlotPrices[i3][j];
                }
                ++n;
            }
        }
        if (!$assertionsDisabled && n != 128) {
            throw new AssertionError();
        }
    }

    public boolean encodeForLZMA2() {
        if (!this.lz.isStarted() && !this.encodeInit()) {
            return false;
        }
        while (this.uncompressedSize <= 2096879 && this.rc.getPendingSize() <= 65510) {
            if (this.encodeSymbol()) continue;
            return false;
        }
        return true;
    }

    int getAnyMatchPrice(State state, int n) {
        return RangeEncoder.getBitPrice(this.isMatch[state.get()][n], 1);
    }

    int getAnyRepPrice(int n, State state) {
        return n + RangeEncoder.getBitPrice(this.isRep[state.get()], 1);
    }

    public LZEncoder getLZEncoder() {
        return this.lz;
    }

    int getLongRepAndLenPrice(int n, int n2, State state, int n3) {
        return this.getLongRepPrice(this.getAnyRepPrice(this.getAnyMatchPrice(state, n3), state), n, state, n3) + this.repLenEncoder.getPrice(n2, n3);
    }

    int getLongRepPrice(int n, int n2, State state, int n3) {
        if (n2 == 0) {
            return n + (RangeEncoder.getBitPrice(this.isRep0[state.get()], 0) + RangeEncoder.getBitPrice(this.isRep0Long[state.get()][n3], 1));
        }
        int n4 = n + RangeEncoder.getBitPrice(this.isRep0[state.get()], 1);
        if (n2 == 1) {
            return n4 + RangeEncoder.getBitPrice(this.isRep1[state.get()], 0);
        }
        return n4 + (RangeEncoder.getBitPrice(this.isRep1[state.get()], 1) + RangeEncoder.getBitPrice(this.isRep2[state.get()], n2 - 2));
    }

    int getMatchAndLenPrice(int n, int n2, int n3, int n4) {
        int n5 = n + this.matchLenEncoder.getPrice(n3, n4);
        int n6 = LZMAEncoder.getDistState(n3);
        if (n2 < 128) {
            return n5 + this.fullDistPrices[n6][n2];
        }
        int n7 = LZMAEncoder.getDistSlot(n2);
        return n5 + (this.distSlotPrices[n6][n7] + this.alignPrices[n2 & 15]);
    }

    Matches getMatches() {
        this.readAhead = 1 + this.readAhead;
        Matches matches = this.lz.getMatches();
        if (!$assertionsDisabled && !this.lz.verifyMatches(matches)) {
            throw new AssertionError();
        }
        return matches;
    }

    abstract int getNextSymbol();

    int getNormalMatchPrice(int n, State state) {
        return n + RangeEncoder.getBitPrice(this.isRep[state.get()], 0);
    }

    int getShortRepPrice(int n, State state, int n2) {
        return n + RangeEncoder.getBitPrice(this.isRep0[state.get()], 0) + RangeEncoder.getBitPrice(this.isRep0Long[state.get()][n2], 0);
    }

    public int getUncompressedSize() {
        return this.uncompressedSize;
    }

    @Override
    public void reset() {
        super.reset();
        this.literalEncoder.reset();
        this.matchLenEncoder.reset();
        this.repLenEncoder.reset();
        this.distPriceCount = 0;
        this.alignPriceCount = 0;
        this.uncompressedSize += 1 + this.readAhead;
        this.readAhead = -1;
    }

    public void resetUncompressedSize() {
        this.uncompressedSize = 0;
    }

    void skip(int n) {
        this.readAhead = n + this.readAhead;
        this.lz.skip(n);
    }

    void updatePrices() {
        if (this.distPriceCount <= 0) {
            this.updateDistPrices();
        }
        if (this.alignPriceCount <= 0) {
            this.updateAlignPrices();
        }
        this.matchLenEncoder.updatePrices();
        this.repLenEncoder.updatePrices();
    }

    class LengthEncoder
    extends LZMACoder.LengthCoder {
        private static final int PRICE_UPDATE_INTERVAL = 32;
        private final int[] counters;
        private final int[][] prices;

        LengthEncoder(int n, int n2) {
            int n3 = 1 << n;
            this.counters = new int[n3];
            int[] arrn = new int[]{n3, Math.max((int)(1 + (n2 - 2)), (int)16)};
            this.prices = (int[][])Array.newInstance((Class)Integer.TYPE, (int[])arrn);
        }

        private void updatePrices(int n) {
            int n2;
            int n3 = RangeEncoder.getBitPrice(this.choice[0], 0);
            for (n2 = 0; n2 < 8; ++n2) {
                this.prices[n][n2] = n3 + RangeEncoder.getBitTreePrice(this.low[n], n2);
            }
            int n4 = RangeEncoder.getBitPrice(this.choice[0], 1);
            int n5 = RangeEncoder.getBitPrice(this.choice[1], 0);
            while (n2 < 16) {
                this.prices[n][n2] = n4 + n5 + RangeEncoder.getBitTreePrice(this.mid[n], n2 - 8);
                ++n2;
            }
            int n6 = RangeEncoder.getBitPrice(this.choice[1], 1);
            while (n2 < this.prices[n].length) {
                this.prices[n][n2] = n4 + n6 + RangeEncoder.getBitTreePrice(this.high, -8 + (n2 - 8));
                ++n2;
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        void encode(int n, int n2) {
            int n3 = n - 2;
            if (n3 < 8) {
                LZMAEncoder.this.rc.encodeBit(this.choice, 0, 0);
                LZMAEncoder.this.rc.encodeBitTree(this.low[n2], n3);
            } else {
                LZMAEncoder.this.rc.encodeBit(this.choice, 0, 1);
                int n4 = n3 - 8;
                if (n4 < 8) {
                    LZMAEncoder.this.rc.encodeBit(this.choice, 1, 0);
                    LZMAEncoder.this.rc.encodeBitTree(this.mid[n2], n4);
                } else {
                    LZMAEncoder.this.rc.encodeBit(this.choice, 1, 1);
                    LZMAEncoder.this.rc.encodeBitTree(this.high, n4 - 8);
                }
            }
            int[] arrn = this.counters;
            arrn[n2] = -1 + arrn[n2];
        }

        int getPrice(int n, int n2) {
            return this.prices[n2][n - 2];
        }

        @Override
        void reset() {
            super.reset();
            for (int i = 0; i < this.counters.length; ++i) {
                this.counters[i] = 0;
            }
        }

        void updatePrices() {
            for (int i = 0; i < this.counters.length; ++i) {
                if (this.counters[i] > 0) continue;
                this.counters[i] = 32;
                this.updatePrices(i);
            }
        }
    }

    class LiteralEncoder
    extends LZMACoder.LiteralCoder {
        static final /* synthetic */ boolean $assertionsDisabled;
        LiteralSubencoder[] subencoders;

        /*
         * Enabled aggressive block sorting
         */
        static {
            boolean bl = !LZMAEncoder.class.desiredAssertionStatus();
            $assertionsDisabled = bl;
        }

        LiteralEncoder(int n, int n2) {
            super(n, n2);
            this.subencoders = new LiteralSubencoder[1 << n + n2];
            for (int i = 0; i < this.subencoders.length; ++i) {
                this.subencoders[i] = new LiteralSubencoder((LiteralEncoder)this, null);
            }
        }

        void encode() {
            if (!$assertionsDisabled && LZMAEncoder.this.readAhead < 0) {
                throw new AssertionError();
            }
            int n = this.getSubcoderIndex(LZMAEncoder.this.lz.getByte(1 + LZMAEncoder.this.readAhead), LZMAEncoder.this.lz.getPos() - LZMAEncoder.this.readAhead);
            this.subencoders[n].encode();
        }

        void encodeInit() {
            if (!$assertionsDisabled && LZMAEncoder.this.readAhead < 0) {
                throw new AssertionError();
            }
            this.subencoders[0].encode();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        int getPrice(int n, int n2, int n3, int n4, State state) {
            int n5;
            int n6 = RangeEncoder.getBitPrice(LZMAEncoder.this.isMatch[state.get()][n4 & LZMAEncoder.this.posMask], 0);
            int n7 = this.getSubcoderIndex(n3, n4);
            if (state.isLiteral()) {
                n5 = this.subencoders[n7].getNormalPrice(n);
                do {
                    return n6 + n5;
                    break;
                } while (true);
            }
            n5 = this.subencoders[n7].getMatchedPrice(n, n2);
            return n6 + n5;
        }

        void reset() {
            for (int i = 0; i < this.subencoders.length; ++i) {
                this.subencoders[i].reset();
            }
        }

        private class LiteralSubencoder
        extends LZMACoder.LiteralCoder.LiteralSubcoder {
            final /* synthetic */ LiteralEncoder this$1;

            private LiteralSubencoder(LiteralEncoder literalEncoder) {
                this.this$1 = literalEncoder;
            }

            /* synthetic */ LiteralSubencoder(LiteralEncoder literalEncoder,  var2_2) {
                super(literalEncoder);
            }

            /*
             * Enabled aggressive block sorting
             */
            void encode() {
                int n = 256 | this.this$1.LZMAEncoder.this.lz.getByte(this.this$1.LZMAEncoder.this.readAhead);
                if (this.this$1.LZMAEncoder.this.state.isLiteral()) {
                    do {
                        int n2 = n >>> 8;
                        int n3 = 1 & n >>> 7;
                        this.this$1.LZMAEncoder.this.rc.encodeBit(this.probs, n2, n3);
                    } while ((n <<= 1) < 65536);
                } else {
                    int n4 = this.this$1.LZMAEncoder.this.lz.getByte(1 + this.this$1.LZMAEncoder.this.reps[0] + this.this$1.LZMAEncoder.this.readAhead);
                    int n5 = 256;
                    do {
                        int n6 = n5 + ((n4 <<= 1) & n5) + (n >>> 8);
                        int n7 = 1 & n >>> 7;
                        this.this$1.LZMAEncoder.this.rc.encodeBit(this.probs, n6, n7);
                        n5 &= -1 ^ (n4 ^ (n <<= 1));
                    } while (n < 65536);
                }
                this.this$1.LZMAEncoder.this.state.updateLiteral();
            }

            int getMatchedPrice(int n, int n2) {
                int n3 = 0;
                int n4 = 256;
                int n5 = n | 256;
                do {
                    int n6 = n4 + ((n2 <<= 1) & n4) + (n5 >>> 8);
                    int n7 = 1 & n5 >>> 7;
                    n3 += RangeEncoder.getBitPrice(this.probs[n6], n7);
                    n4 &= -1 ^ (n2 ^ (n5 <<= 1));
                } while (n5 < 65536);
                return n3;
            }

            int getNormalPrice(int n) {
                int n2 = 0;
                int n3 = n | 256;
                do {
                    int n4 = n3 >>> 8;
                    int n5 = 1 & n3 >>> 7;
                    n2 += RangeEncoder.getBitPrice(this.probs[n4], n5);
                } while ((n3 <<= 1) < 65536);
                return n2;
            }
        }

    }

}

