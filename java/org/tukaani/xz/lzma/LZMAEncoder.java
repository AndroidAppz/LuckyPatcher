package org.tukaani.xz.lzma;

import java.lang.reflect.Array;
import net.lingala.zip4j.util.InternalZipConstants;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.rangecoder.RangeEncoder;
import pxb.android.ResConst;

public abstract class LZMAEncoder extends LZMACoder {
    static final /* synthetic */ boolean $assertionsDisabled = (!LZMAEncoder.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final int ALIGN_PRICE_UPDATE_INTERVAL = 16;
    private static final int DIST_PRICE_UPDATE_INTERVAL = 128;
    private static final int LZMA2_COMPRESSED_LIMIT = 65510;
    private static final int LZMA2_UNCOMPRESSED_LIMIT = 2096879;
    public static final int MODE_FAST = 1;
    public static final int MODE_NORMAL = 2;
    private int alignPriceCount = 0;
    private final int[] alignPrices = new int[ALIGN_PRICE_UPDATE_INTERVAL];
    int back = 0;
    private int distPriceCount = 0;
    private final int[][] distSlotPrices;
    private final int distSlotPricesSize;
    private final int[][] fullDistPrices = ((int[][]) Array.newInstance(Integer.TYPE, new int[]{4, DIST_PRICE_UPDATE_INTERVAL}));
    final LiteralEncoder literalEncoder;
    final LZEncoder lz;
    final LengthEncoder matchLenEncoder;
    final int niceLen;
    private final RangeEncoder rc;
    int readAhead = -1;
    final LengthEncoder repLenEncoder;
    private int uncompressedSize = 0;

    class LengthEncoder extends LengthCoder {
        private static final int PRICE_UPDATE_INTERVAL = 32;
        private final int[] counters;
        private final int[][] prices;

        LengthEncoder(int pb, int niceLen) {
            super();
            int posStates = LZMAEncoder.MODE_FAST << pb;
            this.counters = new int[posStates];
            this.prices = (int[][]) Array.newInstance(Integer.TYPE, new int[]{posStates, Math.max((niceLen - 2) + LZMAEncoder.MODE_FAST, LZMAEncoder.ALIGN_PRICE_UPDATE_INTERVAL)});
        }

        void reset() {
            super.reset();
            for (int i = 0; i < this.counters.length; i += LZMAEncoder.MODE_FAST) {
                this.counters[i] = 0;
            }
        }

        void encode(int len, int posState) {
            len -= 2;
            if (len < 8) {
                LZMAEncoder.this.rc.encodeBit(this.choice, 0, 0);
                LZMAEncoder.this.rc.encodeBitTree(this.low[posState], len);
            } else {
                LZMAEncoder.this.rc.encodeBit(this.choice, 0, LZMAEncoder.MODE_FAST);
                len -= 8;
                if (len < 8) {
                    LZMAEncoder.this.rc.encodeBit(this.choice, LZMAEncoder.MODE_FAST, 0);
                    LZMAEncoder.this.rc.encodeBitTree(this.mid[posState], len);
                } else {
                    LZMAEncoder.this.rc.encodeBit(this.choice, LZMAEncoder.MODE_FAST, LZMAEncoder.MODE_FAST);
                    LZMAEncoder.this.rc.encodeBitTree(this.high, len - 8);
                }
            }
            int[] iArr = this.counters;
            iArr[posState] = iArr[posState] - 1;
        }

        int getPrice(int len, int posState) {
            return this.prices[posState][len - 2];
        }

        void updatePrices() {
            for (int posState = 0; posState < this.counters.length; posState += LZMAEncoder.MODE_FAST) {
                if (this.counters[posState] <= 0) {
                    this.counters[posState] = PRICE_UPDATE_INTERVAL;
                    updatePrices(posState);
                }
            }
        }

        private void updatePrices(int posState) {
            int choice0Price = RangeEncoder.getBitPrice(this.choice[0], 0);
            int i = 0;
            while (i < 8) {
                this.prices[posState][i] = RangeEncoder.getBitTreePrice(this.low[posState], i) + choice0Price;
                i += LZMAEncoder.MODE_FAST;
            }
            choice0Price = RangeEncoder.getBitPrice(this.choice[0], LZMAEncoder.MODE_FAST);
            int choice1Price = RangeEncoder.getBitPrice(this.choice[LZMAEncoder.MODE_FAST], 0);
            while (i < LZMAEncoder.ALIGN_PRICE_UPDATE_INTERVAL) {
                this.prices[posState][i] = (choice0Price + choice1Price) + RangeEncoder.getBitTreePrice(this.mid[posState], i - 8);
                i += LZMAEncoder.MODE_FAST;
            }
            choice1Price = RangeEncoder.getBitPrice(this.choice[LZMAEncoder.MODE_FAST], LZMAEncoder.MODE_FAST);
            while (i < this.prices[posState].length) {
                this.prices[posState][i] = (choice0Price + choice1Price) + RangeEncoder.getBitTreePrice(this.high, (i - 8) - 8);
                i += LZMAEncoder.MODE_FAST;
            }
        }
    }

    class LiteralEncoder extends LiteralCoder {
        static final /* synthetic */ boolean $assertionsDisabled = (!LZMAEncoder.class.desiredAssertionStatus() ? true : LZMAEncoder.$assertionsDisabled);
        LiteralSubencoder[] subencoders;

        private class LiteralSubencoder extends LiteralSubcoder {
            private LiteralSubencoder() {
                super();
            }

            void encode() {
                int symbol = LZMAEncoder.this.lz.getByte(LZMAEncoder.this.readAhead) | ResConst.RES_XML_START_NAMESPACE_TYPE;
                if (LZMAEncoder.this.state.isLiteral()) {
                    do {
                        LZMAEncoder.this.rc.encodeBit(this.probs, symbol >>> 8, (symbol >>> 7) & LZMAEncoder.MODE_FAST);
                        symbol <<= LZMAEncoder.MODE_FAST;
                    } while (symbol < InternalZipConstants.MIN_SPLIT_LENGTH);
                } else {
                    int matchByte = LZMAEncoder.this.lz.getByte((LZMAEncoder.this.reps[0] + LZMAEncoder.MODE_FAST) + LZMAEncoder.this.readAhead);
                    int offset = ResConst.RES_XML_START_NAMESPACE_TYPE;
                    do {
                        matchByte <<= LZMAEncoder.MODE_FAST;
                        LZMAEncoder.this.rc.encodeBit(this.probs, (offset + (matchByte & offset)) + (symbol >>> 8), (symbol >>> 7) & LZMAEncoder.MODE_FAST);
                        symbol <<= LZMAEncoder.MODE_FAST;
                        offset &= (matchByte ^ symbol) ^ -1;
                    } while (symbol < InternalZipConstants.MIN_SPLIT_LENGTH);
                }
                LZMAEncoder.this.state.updateLiteral();
            }

            int getNormalPrice(int symbol) {
                int price = 0;
                symbol |= ResConst.RES_XML_START_NAMESPACE_TYPE;
                do {
                    int bit = (symbol >>> 7) & LZMAEncoder.MODE_FAST;
                    price += RangeEncoder.getBitPrice(this.probs[symbol >>> 8], bit);
                    symbol <<= LZMAEncoder.MODE_FAST;
                } while (symbol < InternalZipConstants.MIN_SPLIT_LENGTH);
                return price;
            }

            int getMatchedPrice(int symbol, int matchByte) {
                int price = 0;
                int offset = ResConst.RES_XML_START_NAMESPACE_TYPE;
                symbol |= ResConst.RES_XML_START_NAMESPACE_TYPE;
                do {
                    matchByte <<= LZMAEncoder.MODE_FAST;
                    int bit = (symbol >>> 7) & LZMAEncoder.MODE_FAST;
                    price += RangeEncoder.getBitPrice(this.probs[(offset + (matchByte & offset)) + (symbol >>> 8)], bit);
                    symbol <<= LZMAEncoder.MODE_FAST;
                    offset &= (matchByte ^ symbol) ^ -1;
                } while (symbol < InternalZipConstants.MIN_SPLIT_LENGTH);
                return price;
            }
        }

        LiteralEncoder(int lc, int lp) {
            super(lc, lp);
            this.subencoders = new LiteralSubencoder[(LZMAEncoder.MODE_FAST << (lc + lp))];
            for (int i = 0; i < this.subencoders.length; i += LZMAEncoder.MODE_FAST) {
                this.subencoders[i] = new LiteralSubencoder();
            }
        }

        void reset() {
            for (int i = 0; i < this.subencoders.length; i += LZMAEncoder.MODE_FAST) {
                this.subencoders[i].reset();
            }
        }

        void encodeInit() {
            if ($assertionsDisabled || LZMAEncoder.this.readAhead >= 0) {
                this.subencoders[0].encode();
                return;
            }
            throw new AssertionError();
        }

        void encode() {
            if ($assertionsDisabled || LZMAEncoder.this.readAhead >= 0) {
                this.subencoders[getSubcoderIndex(LZMAEncoder.this.lz.getByte(LZMAEncoder.this.readAhead + LZMAEncoder.MODE_FAST), LZMAEncoder.this.lz.getPos() - LZMAEncoder.this.readAhead)].encode();
                return;
            }
            throw new AssertionError();
        }

        int getPrice(int curByte, int matchByte, int prevByte, int pos, State state) {
            int normalPrice;
            int price = RangeEncoder.getBitPrice(LZMAEncoder.this.isMatch[state.get()][LZMAEncoder.this.posMask & pos], 0);
            int i = getSubcoderIndex(prevByte, pos);
            if (state.isLiteral()) {
                normalPrice = this.subencoders[i].getNormalPrice(curByte);
            } else {
                normalPrice = this.subencoders[i].getMatchedPrice(curByte, matchByte);
            }
            return price + normalPrice;
        }
    }

    abstract int getNextSymbol();

    public static int getMemoryUsage(int mode, int dictSize, int extraSizeBefore, int mf) {
        switch (mode) {
            case MODE_FAST /*1*/:
                return 80 + LZMAEncoderFast.getMemoryUsage(dictSize, extraSizeBefore, mf);
            case MODE_NORMAL /*2*/:
                return 80 + LZMAEncoderNormal.getMemoryUsage(dictSize, extraSizeBefore, mf);
            default:
                throw new IllegalArgumentException();
        }
    }

    public static LZMAEncoder getInstance(RangeEncoder rc, int lc, int lp, int pb, int mode, int dictSize, int extraSizeBefore, int niceLen, int mf, int depthLimit) {
        switch (mode) {
            case MODE_FAST /*1*/:
                return new LZMAEncoderFast(rc, lc, lp, pb, dictSize, extraSizeBefore, niceLen, mf, depthLimit);
            case MODE_NORMAL /*2*/:
                return new LZMAEncoderNormal(rc, lc, lp, pb, dictSize, extraSizeBefore, niceLen, mf, depthLimit);
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int getDistSlot(int dist) {
        if (dist <= 4) {
            return dist;
        }
        int n = dist;
        int i = 31;
        if ((-65536 & n) == 0) {
            n <<= ALIGN_PRICE_UPDATE_INTERVAL;
            i = 15;
        }
        if ((-16777216 & n) == 0) {
            n <<= 8;
            i -= 8;
        }
        if ((-268435456 & n) == 0) {
            n <<= 4;
            i -= 4;
        }
        if ((-1073741824 & n) == 0) {
            n <<= MODE_NORMAL;
            i -= 2;
        }
        if ((Integer.MIN_VALUE & n) == 0) {
            i--;
        }
        return (i << MODE_FAST) + ((dist >>> (i - 1)) & MODE_FAST);
    }

    LZMAEncoder(RangeEncoder rc, LZEncoder lz, int lc, int lp, int pb, int dictSize, int niceLen) {
        super(pb);
        this.rc = rc;
        this.lz = lz;
        this.niceLen = niceLen;
        this.literalEncoder = new LiteralEncoder(lc, lp);
        this.matchLenEncoder = new LengthEncoder(pb, niceLen);
        this.repLenEncoder = new LengthEncoder(pb, niceLen);
        this.distSlotPricesSize = getDistSlot(dictSize - 1) + MODE_FAST;
        this.distSlotPrices = (int[][]) Array.newInstance(Integer.TYPE, new int[]{4, this.distSlotPricesSize});
        reset();
    }

    public LZEncoder getLZEncoder() {
        return this.lz;
    }

    public void reset() {
        super.reset();
        this.literalEncoder.reset();
        this.matchLenEncoder.reset();
        this.repLenEncoder.reset();
        this.distPriceCount = 0;
        this.alignPriceCount = 0;
        this.uncompressedSize += this.readAhead + MODE_FAST;
        this.readAhead = -1;
    }

    public int getUncompressedSize() {
        return this.uncompressedSize;
    }

    public void resetUncompressedSize() {
        this.uncompressedSize = 0;
    }

    public boolean encodeForLZMA2() {
        if (!this.lz.isStarted() && !encodeInit()) {
            return $assertionsDisabled;
        }
        while (this.uncompressedSize <= LZMA2_UNCOMPRESSED_LIMIT && this.rc.getPendingSize() <= LZMA2_COMPRESSED_LIMIT) {
            if (!encodeSymbol()) {
                return $assertionsDisabled;
            }
        }
        return true;
    }

    private boolean encodeInit() {
        if (!$assertionsDisabled && this.readAhead != -1) {
            throw new AssertionError();
        } else if (!this.lz.hasEnoughData(0)) {
            return $assertionsDisabled;
        } else {
            skip(MODE_FAST);
            this.rc.encodeBit(this.isMatch[this.state.get()], 0, 0);
            this.literalEncoder.encodeInit();
            this.readAhead--;
            if ($assertionsDisabled || this.readAhead == -1) {
                this.uncompressedSize += MODE_FAST;
                if ($assertionsDisabled || this.uncompressedSize == MODE_FAST) {
                    return true;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
    }

    private boolean encodeSymbol() {
        if (!this.lz.hasEnoughData(this.readAhead + MODE_FAST)) {
            return $assertionsDisabled;
        }
        int len = getNextSymbol();
        if ($assertionsDisabled || this.readAhead >= 0) {
            int posState = (this.lz.getPos() - this.readAhead) & this.posMask;
            if (this.back != -1) {
                this.rc.encodeBit(this.isMatch[this.state.get()], posState, MODE_FAST);
                if (this.back < 4) {
                    if ($assertionsDisabled || this.lz.getMatchLen(-this.readAhead, this.reps[this.back], len) == len) {
                        this.rc.encodeBit(this.isRep, this.state.get(), MODE_FAST);
                        encodeRepMatch(this.back, len, posState);
                    } else {
                        throw new AssertionError();
                    }
                } else if ($assertionsDisabled || this.lz.getMatchLen(-this.readAhead, this.back - 4, len) == len) {
                    this.rc.encodeBit(this.isRep, this.state.get(), 0);
                    encodeMatch(this.back - 4, len, posState);
                } else {
                    throw new AssertionError();
                }
            } else if ($assertionsDisabled || len == MODE_FAST) {
                this.rc.encodeBit(this.isMatch[this.state.get()], posState, 0);
                this.literalEncoder.encode();
            } else {
                throw new AssertionError();
            }
            this.readAhead -= len;
            this.uncompressedSize += len;
            return true;
        }
        throw new AssertionError();
    }

    private void encodeMatch(int dist, int len, int posState) {
        this.state.updateMatch();
        this.matchLenEncoder.encode(len, posState);
        int distSlot = getDistSlot(dist);
        this.rc.encodeBitTree(this.distSlots[LZMACoder.getDistState(len)], distSlot);
        if (distSlot >= 4) {
            int footerBits = (distSlot >>> MODE_FAST) - 1;
            int distReduced = dist - (((distSlot & MODE_FAST) | MODE_NORMAL) << footerBits);
            if (distSlot < 14) {
                this.rc.encodeReverseBitTree(this.distSpecial[distSlot - 4], distReduced);
            } else {
                this.rc.encodeDirectBits(distReduced >>> 4, footerBits - 4);
                this.rc.encodeReverseBitTree(this.distAlign, distReduced & 15);
                this.alignPriceCount--;
            }
        }
        this.reps[3] = this.reps[MODE_NORMAL];
        this.reps[MODE_NORMAL] = this.reps[MODE_FAST];
        this.reps[MODE_FAST] = this.reps[0];
        this.reps[0] = dist;
        this.distPriceCount--;
    }

    private void encodeRepMatch(int rep, int len, int posState) {
        int i = 0;
        if (rep == 0) {
            this.rc.encodeBit(this.isRep0, this.state.get(), 0);
            RangeEncoder rangeEncoder = this.rc;
            short[] sArr = this.isRep0Long[this.state.get()];
            if (len != MODE_FAST) {
                i = MODE_FAST;
            }
            rangeEncoder.encodeBit(sArr, posState, i);
        } else {
            int dist = this.reps[rep];
            this.rc.encodeBit(this.isRep0, this.state.get(), MODE_FAST);
            if (rep == MODE_FAST) {
                this.rc.encodeBit(this.isRep1, this.state.get(), 0);
            } else {
                this.rc.encodeBit(this.isRep1, this.state.get(), MODE_FAST);
                this.rc.encodeBit(this.isRep2, this.state.get(), rep - 2);
                if (rep == 3) {
                    this.reps[3] = this.reps[MODE_NORMAL];
                }
                this.reps[MODE_NORMAL] = this.reps[MODE_FAST];
            }
            this.reps[MODE_FAST] = this.reps[0];
            this.reps[0] = dist;
        }
        if (len == MODE_FAST) {
            this.state.updateShortRep();
            return;
        }
        this.repLenEncoder.encode(len, posState);
        this.state.updateLongRep();
    }

    Matches getMatches() {
        this.readAhead += MODE_FAST;
        Matches matches = this.lz.getMatches();
        if ($assertionsDisabled || this.lz.verifyMatches(matches)) {
            return matches;
        }
        throw new AssertionError();
    }

    void skip(int len) {
        this.readAhead += len;
        this.lz.skip(len);
    }

    int getAnyMatchPrice(State state, int posState) {
        return RangeEncoder.getBitPrice(this.isMatch[state.get()][posState], MODE_FAST);
    }

    int getNormalMatchPrice(int anyMatchPrice, State state) {
        return RangeEncoder.getBitPrice(this.isRep[state.get()], 0) + anyMatchPrice;
    }

    int getAnyRepPrice(int anyMatchPrice, State state) {
        return RangeEncoder.getBitPrice(this.isRep[state.get()], MODE_FAST) + anyMatchPrice;
    }

    int getShortRepPrice(int anyRepPrice, State state, int posState) {
        return (RangeEncoder.getBitPrice(this.isRep0[state.get()], 0) + anyRepPrice) + RangeEncoder.getBitPrice(this.isRep0Long[state.get()][posState], 0);
    }

    int getLongRepPrice(int anyRepPrice, int rep, State state, int posState) {
        int price = anyRepPrice;
        if (rep == 0) {
            return price + (RangeEncoder.getBitPrice(this.isRep0[state.get()], 0) + RangeEncoder.getBitPrice(this.isRep0Long[state.get()][posState], MODE_FAST));
        }
        price += RangeEncoder.getBitPrice(this.isRep0[state.get()], MODE_FAST);
        if (rep == MODE_FAST) {
            return price + RangeEncoder.getBitPrice(this.isRep1[state.get()], 0);
        }
        return price + (RangeEncoder.getBitPrice(this.isRep1[state.get()], MODE_FAST) + RangeEncoder.getBitPrice(this.isRep2[state.get()], rep - 2));
    }

    int getLongRepAndLenPrice(int rep, int len, State state, int posState) {
        return this.repLenEncoder.getPrice(len, posState) + getLongRepPrice(getAnyRepPrice(getAnyMatchPrice(state, posState), state), rep, state, posState);
    }

    int getMatchAndLenPrice(int normalMatchPrice, int dist, int len, int posState) {
        int price = normalMatchPrice + this.matchLenEncoder.getPrice(len, posState);
        int distState = LZMACoder.getDistState(len);
        if (dist < DIST_PRICE_UPDATE_INTERVAL) {
            return price + this.fullDistPrices[distState][dist];
        }
        return price + (this.distSlotPrices[distState][getDistSlot(dist)] + this.alignPrices[dist & 15]);
    }

    private void updateDistPrices() {
        int distState;
        int distSlot;
        int dist;
        this.distPriceCount = DIST_PRICE_UPDATE_INTERVAL;
        for (distState = 0; distState < 4; distState += MODE_FAST) {
            for (distSlot = 0; distSlot < this.distSlotPricesSize; distSlot += MODE_FAST) {
                this.distSlotPrices[distState][distSlot] = RangeEncoder.getBitTreePrice(this.distSlots[distState], distSlot);
            }
            for (distSlot = 14; distSlot < this.distSlotPricesSize; distSlot += MODE_FAST) {
                int count = ((distSlot >>> MODE_FAST) - 1) - 4;
                int[] iArr = this.distSlotPrices[distState];
                iArr[distSlot] = iArr[distSlot] + RangeEncoder.getDirectBitsPrice(count);
            }
            for (dist = 0; dist < 4; dist += MODE_FAST) {
                this.fullDistPrices[distState][dist] = this.distSlotPrices[distState][dist];
            }
        }
        dist = 4;
        for (distSlot = 4; distSlot < 14; distSlot += MODE_FAST) {
            int base = ((distSlot & MODE_FAST) | MODE_NORMAL) << ((distSlot >>> MODE_FAST) - 1);
            int limit = this.distSpecial[distSlot - 4].length;
            for (int i = 0; i < limit; i += MODE_FAST) {
                int price = RangeEncoder.getReverseBitTreePrice(this.distSpecial[distSlot - 4], dist - base);
                for (distState = 0; distState < 4; distState += MODE_FAST) {
                    this.fullDistPrices[distState][dist] = this.distSlotPrices[distState][distSlot] + price;
                }
                dist += MODE_FAST;
            }
        }
        if (!$assertionsDisabled && dist != DIST_PRICE_UPDATE_INTERVAL) {
            throw new AssertionError();
        }
    }

    private void updateAlignPrices() {
        this.alignPriceCount = ALIGN_PRICE_UPDATE_INTERVAL;
        for (int i = 0; i < ALIGN_PRICE_UPDATE_INTERVAL; i += MODE_FAST) {
            this.alignPrices[i] = RangeEncoder.getReverseBitTreePrice(this.distAlign, i);
        }
    }

    void updatePrices() {
        if (this.distPriceCount <= 0) {
            updateDistPrices();
        }
        if (this.alignPriceCount <= 0) {
            updateAlignPrices();
        }
        this.matchLenEncoder.updatePrices();
        this.repLenEncoder.updatePrices();
    }
}
