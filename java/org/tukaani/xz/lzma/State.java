package org.tukaani.xz.lzma;

final class State {
    private static final int LIT_LIT = 0;
    private static final int LIT_LONGREP = 8;
    private static final int LIT_MATCH = 7;
    private static final int LIT_SHORTREP = 9;
    private static final int LIT_STATES = 7;
    private static final int MATCH_LIT = 4;
    private static final int MATCH_LIT_LIT = 1;
    private static final int NONLIT_MATCH = 10;
    private static final int NONLIT_REP = 11;
    private static final int REP_LIT = 5;
    private static final int REP_LIT_LIT = 2;
    private static final int SHORTREP_LIT = 6;
    private static final int SHORTREP_LIT_LIT = 3;
    static final int STATES = 12;
    private int state;

    State() {
    }

    State(State other) {
        this.state = other.state;
    }

    void reset() {
        this.state = LIT_LIT;
    }

    int get() {
        return this.state;
    }

    void set(State other) {
        this.state = other.state;
    }

    void updateLiteral() {
        if (this.state <= SHORTREP_LIT_LIT) {
            this.state = LIT_LIT;
        } else if (this.state <= LIT_SHORTREP) {
            this.state -= 3;
        } else {
            this.state -= 6;
        }
    }

    void updateMatch() {
        int i = LIT_STATES;
        if (this.state >= LIT_STATES) {
            i = NONLIT_MATCH;
        }
        this.state = i;
    }

    void updateLongRep() {
        this.state = this.state < LIT_STATES ? LIT_LONGREP : NONLIT_REP;
    }

    void updateShortRep() {
        this.state = this.state < LIT_STATES ? LIT_SHORTREP : NONLIT_REP;
    }

    boolean isLiteral() {
        return this.state < LIT_STATES;
    }
}
