package org.tukaani.xz.lzma;

import java.io.IOException;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.rangecoder.RangeDecoder;
import pxb.android.ResConst;

public final class LZMADecoder extends LZMACoder {
    private final LiteralDecoder literalDecoder;
    private final LZDecoder lz;
    private final LengthDecoder matchLenDecoder = new LengthDecoder();
    private final RangeDecoder rc;
    private final LengthDecoder repLenDecoder = new LengthDecoder();

    private class LengthDecoder extends LengthCoder {
        private LengthDecoder() {
            super();
        }

        int decode(int posState) throws IOException {
            if (LZMADecoder.this.rc.decodeBit(this.choice, 0) == 0) {
                return LZMADecoder.this.rc.decodeBitTree(this.low[posState]) + 2;
            }
            if (LZMADecoder.this.rc.decodeBit(this.choice, 1) == 0) {
                return (LZMADecoder.this.rc.decodeBitTree(this.mid[posState]) + 2) + 8;
            }
            return ((LZMADecoder.this.rc.decodeBitTree(this.high) + 2) + 8) + 8;
        }
    }

    private class LiteralDecoder extends LiteralCoder {
        LiteralSubdecoder[] subdecoders;

        private class LiteralSubdecoder extends LiteralSubcoder {
            private LiteralSubdecoder() {
                super();
            }

            void decode() throws IOException {
                int symbol = 1;
                if (LZMADecoder.this.state.isLiteral()) {
                    do {
                        symbol = (symbol << 1) | LZMADecoder.this.rc.decodeBit(this.probs, symbol);
                    } while (symbol < ResConst.RES_XML_START_NAMESPACE_TYPE);
                } else {
                    int matchByte = LZMADecoder.this.lz.getByte(LZMADecoder.this.reps[0]);
                    int offset = ResConst.RES_XML_START_NAMESPACE_TYPE;
                    do {
                        matchByte <<= 1;
                        int matchBit = matchByte & offset;
                        int bit = LZMADecoder.this.rc.decodeBit(this.probs, (offset + matchBit) + symbol);
                        symbol = (symbol << 1) | bit;
                        offset &= (0 - bit) ^ (matchBit ^ -1);
                    } while (symbol < ResConst.RES_XML_START_NAMESPACE_TYPE);
                }
                LZMADecoder.this.lz.putByte((byte) symbol);
                LZMADecoder.this.state.updateLiteral();
            }
        }

        LiteralDecoder(int lc, int lp) {
            super(lc, lp);
            this.subdecoders = new LiteralSubdecoder[(1 << (lc + lp))];
            for (int i = 0; i < this.subdecoders.length; i++) {
                this.subdecoders[i] = new LiteralSubdecoder();
            }
        }

        void reset() {
            for (LiteralSubdecoder reset : this.subdecoders) {
                reset.reset();
            }
        }

        void decode() throws IOException {
            this.subdecoders[getSubcoderIndex(LZMADecoder.this.lz.getByte(0), LZMADecoder.this.lz.getPos())].decode();
        }
    }

    public LZMADecoder(LZDecoder lz, RangeDecoder rc, int lc, int lp, int pb) {
        super(pb);
        this.lz = lz;
        this.rc = rc;
        this.literalDecoder = new LiteralDecoder(lc, lp);
        reset();
    }

    public void reset() {
        super.reset();
        this.literalDecoder.reset();
        this.matchLenDecoder.reset();
        this.repLenDecoder.reset();
    }

    public boolean endMarkerDetected() {
        return this.reps[0] == -1;
    }

    public void decode() throws IOException {
        this.lz.repeatPending();
        while (this.lz.hasSpace()) {
            int posState = this.lz.getPos() & this.posMask;
            if (this.rc.decodeBit(this.isMatch[this.state.get()], posState) == 0) {
                this.literalDecoder.decode();
            } else {
                int len;
                if (this.rc.decodeBit(this.isRep, this.state.get()) == 0) {
                    len = decodeMatch(posState);
                } else {
                    len = decodeRepMatch(posState);
                }
                this.lz.repeat(this.reps[0], len);
            }
        }
        this.rc.normalize();
    }

    private int decodeMatch(int posState) throws IOException {
        this.state.updateMatch();
        this.reps[3] = this.reps[2];
        this.reps[2] = this.reps[1];
        this.reps[1] = this.reps[0];
        int len = this.matchLenDecoder.decode(posState);
        int distSlot = this.rc.decodeBitTree(this.distSlots[LZMACoder.getDistState(len)]);
        if (distSlot < 4) {
            this.reps[0] = distSlot;
        } else {
            int limit = (distSlot >> 1) - 1;
            this.reps[0] = ((distSlot & 1) | 2) << limit;
            int[] iArr;
            if (distSlot < 14) {
                iArr = this.reps;
                iArr[0] = iArr[0] | this.rc.decodeReverseBitTree(this.distSpecial[distSlot - 4]);
            } else {
                iArr = this.reps;
                iArr[0] = iArr[0] | (this.rc.decodeDirectBits(limit - 4) << 4);
                iArr = this.reps;
                iArr[0] = iArr[0] | this.rc.decodeReverseBitTree(this.distAlign);
            }
        }
        return len;
    }

    private int decodeRepMatch(int posState) throws IOException {
        if (this.rc.decodeBit(this.isRep0, this.state.get()) != 0) {
            int tmp;
            if (this.rc.decodeBit(this.isRep1, this.state.get()) == 0) {
                tmp = this.reps[1];
            } else {
                if (this.rc.decodeBit(this.isRep2, this.state.get()) == 0) {
                    tmp = this.reps[2];
                } else {
                    tmp = this.reps[3];
                    this.reps[3] = this.reps[2];
                }
                this.reps[2] = this.reps[1];
            }
            this.reps[1] = this.reps[0];
            this.reps[0] = tmp;
        } else if (this.rc.decodeBit(this.isRep0Long[this.state.get()], posState) == 0) {
            this.state.updateShortRep();
            return 1;
        }
        this.state.updateLongRep();
        return this.repLenDecoder.decode(posState);
    }
}
