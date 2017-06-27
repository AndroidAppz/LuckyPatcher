package org.tukaani.xz.lzma;

import java.lang.reflect.Array;
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
    final short[] distAlign = new short[POS_STATES_MAX];
    final short[][] distSlots = ((short[][]) Array.newInstance(Short.TYPE, new int[]{REPS, DIST_SLOTS}));
    final short[][] distSpecial = new short[][]{new short[MATCH_LEN_MIN], new short[MATCH_LEN_MIN], new short[REPS], new short[REPS], new short[8], new short[8], new short[POS_STATES_MAX], new short[POS_STATES_MAX], new short[32], new short[32]};
    final short[][] isMatch = ((short[][]) Array.newInstance(Short.TYPE, new int[]{12, POS_STATES_MAX}));
    final short[] isRep = new short[12];
    final short[] isRep0 = new short[12];
    final short[][] isRep0Long = ((short[][]) Array.newInstance(Short.TYPE, new int[]{12, POS_STATES_MAX}));
    final short[] isRep1 = new short[12];
    final short[] isRep2 = new short[12];
    final int posMask;
    final int[] reps = new int[REPS];
    final State state = new State();

    abstract class LengthCoder {
        static final int HIGH_SYMBOLS = 256;
        static final int LOW_SYMBOLS = 8;
        static final int MID_SYMBOLS = 8;
        final short[] choice = new short[LZMACoder.MATCH_LEN_MIN];
        final short[] high = new short[HIGH_SYMBOLS];
        final short[][] low = ((short[][]) Array.newInstance(Short.TYPE, new int[]{LZMACoder.POS_STATES_MAX, MID_SYMBOLS}));
        final short[][] mid = ((short[][]) Array.newInstance(Short.TYPE, new int[]{LZMACoder.POS_STATES_MAX, MID_SYMBOLS}));

        LengthCoder() {
        }

        void reset() {
            int i;
            RangeCoder.initProbs(this.choice);
            for (short[] initProbs : this.low) {
                RangeCoder.initProbs(initProbs);
            }
            for (i = 0; i < this.low.length; i++) {
                RangeCoder.initProbs(this.mid[i]);
            }
            RangeCoder.initProbs(this.high);
        }
    }

    abstract class LiteralCoder {
        private final int lc;
        private final int literalPosMask;

        abstract class LiteralSubcoder {
            final short[] probs = new short[768];

            LiteralSubcoder() {
            }

            void reset() {
                RangeCoder.initProbs(this.probs);
            }
        }

        LiteralCoder(int lc, int lp) {
            this.lc = lc;
            this.literalPosMask = (1 << lp) - 1;
        }

        final int getSubcoderIndex(int prevByte, int pos) {
            return (prevByte >> (8 - this.lc)) + ((this.literalPosMask & pos) << this.lc);
        }
    }

    static final int getDistState(int len) {
        if (len < 6) {
            return len - 2;
        }
        return 3;
    }

    LZMACoder(int pb) {
        this.posMask = (1 << pb) - 1;
    }

    void reset() {
        this.reps[0] = 0;
        this.reps[1] = 0;
        this.reps[MATCH_LEN_MIN] = 0;
        this.reps[3] = 0;
        this.state.reset();
        for (short[] initProbs : this.isMatch) {
            RangeCoder.initProbs(initProbs);
        }
        RangeCoder.initProbs(this.isRep);
        RangeCoder.initProbs(this.isRep0);
        RangeCoder.initProbs(this.isRep1);
        RangeCoder.initProbs(this.isRep2);
        for (short[] initProbs2 : this.isRep0Long) {
            RangeCoder.initProbs(initProbs2);
        }
        for (short[] initProbs22 : this.distSlots) {
            RangeCoder.initProbs(initProbs22);
        }
        for (short[] initProbs222 : this.distSpecial) {
            RangeCoder.initProbs(initProbs222);
        }
        RangeCoder.initProbs(this.distAlign);
    }
}
