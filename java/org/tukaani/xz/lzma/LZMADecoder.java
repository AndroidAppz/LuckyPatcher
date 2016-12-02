/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package org.tukaani.xz.lzma;

import java.io.IOException;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMACoder;
import org.tukaani.xz.lzma.State;
import org.tukaani.xz.rangecoder.RangeDecoder;

public final class LZMADecoder
extends LZMACoder {
    private final LiteralDecoder literalDecoder;
    private final LZDecoder lz;
    private final LengthDecoder matchLenDecoder;
    private final RangeDecoder rc;
    private final LengthDecoder repLenDecoder;

    public LZMADecoder(LZDecoder lZDecoder, RangeDecoder rangeDecoder, int n, int n2, int n3) {
        super(n3);
        this.matchLenDecoder = new LengthDecoder(this, null);
        this.repLenDecoder = new LengthDecoder(this, null);
        this.lz = lZDecoder;
        this.rc = rangeDecoder;
        this.literalDecoder = new LiteralDecoder(n, n2);
        this.reset();
    }

    private int decodeMatch(int n) throws IOException {
        this.state.updateMatch();
        this.reps[3] = this.reps[2];
        this.reps[2] = this.reps[1];
        this.reps[1] = this.reps[0];
        int n2 = this.matchLenDecoder.decode(n);
        int n3 = this.rc.decodeBitTree(this.distSlots[LZMADecoder.getDistState(n2)]);
        if (n3 < 4) {
            this.reps[0] = n3;
            return n2;
        }
        int n4 = -1 + (n3 >> 1);
        this.reps[0] = (2 | n3 & 1) << n4;
        if (n3 < 14) {
            int[] arrn = this.reps;
            arrn[0] = arrn[0] | this.rc.decodeReverseBitTree(this.distSpecial[n3 - 4]);
            return n2;
        }
        int[] arrn = this.reps;
        arrn[0] = arrn[0] | this.rc.decodeDirectBits(n4 - 4) << 4;
        int[] arrn2 = this.reps;
        arrn2[0] = arrn2[0] | this.rc.decodeReverseBitTree(this.distAlign);
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int decodeRepMatch(int n) throws IOException {
        if (this.rc.decodeBit(this.isRep0, this.state.get()) == 0) {
            if (this.rc.decodeBit(this.isRep0Long[this.state.get()], n) == 0) {
                this.state.updateShortRep();
                return 1;
            }
        } else {
            int n2;
            if (this.rc.decodeBit(this.isRep1, this.state.get()) == 0) {
                n2 = this.reps[1];
            } else {
                if (this.rc.decodeBit(this.isRep2, this.state.get()) == 0) {
                    n2 = this.reps[2];
                } else {
                    n2 = this.reps[3];
                    this.reps[3] = this.reps[2];
                }
                this.reps[2] = this.reps[1];
            }
            this.reps[1] = this.reps[0];
            this.reps[0] = n2;
        }
        this.state.updateLongRep();
        return this.repLenDecoder.decode(n);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void decode() throws IOException {
        this.lz.repeatPending();
        do {
            if (!this.lz.hasSpace()) {
                this.rc.normalize();
                return;
            }
            int n = this.lz.getPos() & this.posMask;
            if (this.rc.decodeBit(this.isMatch[this.state.get()], n) == 0) {
                this.literalDecoder.decode();
                continue;
            }
            int n2 = this.rc.decodeBit(this.isRep, this.state.get()) == 0 ? this.decodeMatch(n) : this.decodeRepMatch(n);
            this.lz.repeat(this.reps[0], n2);
        } while (true);
    }

    public boolean endMarkerDetected() {
        int n = this.reps[0];
        boolean bl = false;
        if (n == -1) {
            bl = true;
        }
        return bl;
    }

    @Override
    public void reset() {
        super.reset();
        this.literalDecoder.reset();
        this.matchLenDecoder.reset();
        this.repLenDecoder.reset();
    }

    private class LengthDecoder
    extends LZMACoder.LengthCoder {
        final /* synthetic */ LZMADecoder this$0;

        private LengthDecoder(LZMADecoder lZMADecoder) {
            this.this$0 = lZMADecoder;
        }

        /* synthetic */ LengthDecoder(LZMADecoder lZMADecoder,  var2_2) {
            super(lZMADecoder);
        }

        int decode(int n) throws IOException {
            if (this.this$0.rc.decodeBit(this.choice, 0) == 0) {
                return 2 + this.this$0.rc.decodeBitTree(this.low[n]);
            }
            if (this.this$0.rc.decodeBit(this.choice, 1) == 0) {
                return 8 + (2 + this.this$0.rc.decodeBitTree(this.mid[n]));
            }
            return 8 + (8 + (2 + this.this$0.rc.decodeBitTree(this.high)));
        }
    }

    private class LiteralDecoder
    extends LZMACoder.LiteralCoder {
        LiteralSubdecoder[] subdecoders;

        LiteralDecoder(int n, int n2) {
            super(n, n2);
            this.subdecoders = new LiteralSubdecoder[1 << n + n2];
            for (int i = 0; i < this.subdecoders.length; ++i) {
                this.subdecoders[i] = new LiteralSubdecoder((LiteralDecoder)this, null);
            }
        }

        void decode() throws IOException {
            int n = this.getSubcoderIndex(LZMADecoder.this.lz.getByte(0), LZMADecoder.this.lz.getPos());
            this.subdecoders[n].decode();
        }

        void reset() {
            for (int i = 0; i < this.subdecoders.length; ++i) {
                this.subdecoders[i].reset();
            }
        }

        private class LiteralSubdecoder
        extends LZMACoder.LiteralCoder.LiteralSubcoder {
            final /* synthetic */ LiteralDecoder this$1;

            private LiteralSubdecoder(LiteralDecoder literalDecoder) {
                this.this$1 = literalDecoder;
            }

            /* synthetic */ LiteralSubdecoder(LiteralDecoder literalDecoder,  var2_2) {
                super(literalDecoder);
            }

            /*
             * Enabled aggressive block sorting
             */
            void decode() throws IOException {
                int n = 1;
                if (this.this$1.LZMADecoder.this.state.isLiteral()) {
                    while ((n = n << 1 | this.this$1.LZMADecoder.this.rc.decodeBit(this.probs, n)) < 256) {
                    }
                } else {
                    int n2 = this.this$1.LZMADecoder.this.lz.getByte(this.this$1.LZMADecoder.this.reps[0]);
                    int n3 = 256;
                    do {
                        int n4 = (n2 <<= 1) & n3;
                        int n5 = this.this$1.LZMADecoder.this.rc.decodeBit(this.probs, n + (n3 + n4));
                        n = n5 | n << 1;
                        n3 &= 0 - n5 ^ ~ n4;
                    } while (n < 256);
                }
                this.this$1.LZMADecoder.this.lz.putByte((byte)n);
                this.this$1.LZMADecoder.this.state.updateLiteral();
            }
        }

    }

}

