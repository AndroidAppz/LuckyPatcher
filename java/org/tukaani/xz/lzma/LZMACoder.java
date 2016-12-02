/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.reflect.Array
 */
package org.tukaani.xz.lzma;

import java.lang.reflect.Array;
import org.tukaani.xz.lzma.State;
import org.tukaani.xz.rangecoder.RangeCoder;

abstract class LZMACoder {
    static final int ALIGN_BITS = 4;
    static final int ALIGN_MASK = 15;
    static final int ALIGN_SIZE = 16;
    static final int DIST_MODEL_END = 14;
    static final int DIST_MODEL_START = 4;
    static final int DIST_SLOTS = 64;
    static final int DIST_STATES = 4;
    static final int FULL_DISTANCES = 128;
    static final int MATCH_LEN_MAX = 273;
    static final int MATCH_LEN_MIN = 2;
    static final int POS_STATES_MAX = 16;
    static final int REPS = 4;
    final short[] distAlign;
    final short[][] distSlots;
    final short[][] distSpecial;
    final short[][] isMatch;
    final short[] isRep;
    final short[] isRep0;
    final short[][] isRep0Long;
    final short[] isRep1;
    final short[] isRep2;
    final int posMask;
    final int[] reps = new int[4];
    final State state = new State();

    LZMACoder(int n) {
        int[] arrn = new int[]{12, 16};
        this.isMatch = (short[][])Array.newInstance((Class)Short.TYPE, (int[])arrn);
        this.isRep = new short[12];
        this.isRep0 = new short[12];
        this.isRep1 = new short[12];
        this.isRep2 = new short[12];
        int[] arrn2 = new int[]{12, 16};
        this.isRep0Long = (short[][])Array.newInstance((Class)Short.TYPE, (int[])arrn2);
        int[] arrn3 = new int[]{4, 64};
        this.distSlots = (short[][])Array.newInstance((Class)Short.TYPE, (int[])arrn3);
        short[][] arrs = new short[][]{new short[2], new short[2], new short[4], new short[4], new short[8], new short[8], new short[16], new short[16], new short[32], new short[32]};
        this.distSpecial = arrs;
        this.distAlign = new short[16];
        this.posMask = -1 + (1 << n);
    }

    static final int getDistState(int n) {
        if (n < 6) {
            return n - 2;
        }
        return 3;
    }

    void reset() {
        this.reps[0] = 0;
        this.reps[1] = 0;
        this.reps[2] = 0;
        this.reps[3] = 0;
        this.state.reset();
        for (int i = 0; i < this.isMatch.length; ++i) {
            RangeCoder.initProbs(this.isMatch[i]);
        }
        RangeCoder.initProbs(this.isRep);
        RangeCoder.initProbs(this.isRep0);
        RangeCoder.initProbs(this.isRep1);
        RangeCoder.initProbs(this.isRep2);
        for (int j = 0; j < this.isRep0Long.length; ++j) {
            RangeCoder.initProbs(this.isRep0Long[j]);
        }
        for (int k = 0; k < this.distSlots.length; ++k) {
            RangeCoder.initProbs(this.distSlots[k]);
        }
        for (int i2 = 0; i2 < this.distSpecial.length; ++i2) {
            RangeCoder.initProbs(this.distSpecial[i2]);
        }
        RangeCoder.initProbs(this.distAlign);
    }

    abstract class LengthCoder {
        static final int HIGH_SYMBOLS = 256;
        static final int LOW_SYMBOLS = 8;
        static final int MID_SYMBOLS = 8;
        final short[] choice;
        final short[] high;
        final short[][] low;
        final short[][] mid;

        LengthCoder() {
            this.choice = new short[2];
            int[] arrn = new int[]{16, 8};
            this.low = (short[][])Array.newInstance((Class)Short.TYPE, (int[])arrn);
            int[] arrn2 = new int[]{16, 8};
            this.mid = (short[][])Array.newInstance((Class)Short.TYPE, (int[])arrn2);
            this.high = new short[256];
        }

        void reset() {
            RangeCoder.initProbs(this.choice);
            for (int i = 0; i < this.low.length; ++i) {
                RangeCoder.initProbs(this.low[i]);
            }
            for (int j = 0; j < this.low.length; ++j) {
                RangeCoder.initProbs(this.mid[j]);
            }
            RangeCoder.initProbs(this.high);
        }
    }

    abstract class LiteralCoder {
        private final int lc;
        private final int literalPosMask;

        LiteralCoder(int n, int n2) {
            this.lc = n;
            this.literalPosMask = -1 + (1 << n2);
        }

        final int getSubcoderIndex(int n, int n2) {
            return (n >> 8 - this.lc) + ((n2 & this.literalPosMask) << this.lc);
        }

        abstract class LiteralSubcoder {
            final short[] probs;

            LiteralSubcoder() {
                this.probs = new short[768];
            }

            void reset() {
                RangeCoder.initProbs(this.probs);
            }
        }

    }

}

