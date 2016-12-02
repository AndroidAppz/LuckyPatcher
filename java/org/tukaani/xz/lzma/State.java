/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
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

    State(State state) {
        this.state = state.state;
    }

    int get() {
        return this.state;
    }

    boolean isLiteral() {
        if (this.state < 7) {
            return true;
        }
        return false;
    }

    void reset() {
        this.state = 0;
    }

    void set(State state) {
        this.state = state.state;
    }

    void updateLiteral() {
        if (this.state <= 3) {
            this.state = 0;
            return;
        }
        if (this.state <= 9) {
            this.state = -3 + this.state;
            return;
        }
        this.state = -6 + this.state;
    }

    /*
     * Enabled aggressive block sorting
     */
    void updateLongRep() {
        int n = this.state < 7 ? 8 : 11;
        this.state = n;
    }

    /*
     * Enabled aggressive block sorting
     */
    void updateMatch() {
        int n = 7;
        if (this.state >= n) {
            n = 10;
        }
        this.state = n;
    }

    /*
     * Enabled aggressive block sorting
     */
    void updateShortRep() {
        int n = this.state < 7 ? 9 : 11;
        this.state = n;
    }
}

