/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.lzma;

import org.tukaani.xz.lzma.State;

final class Optimum {
    private static final int INFINITY_PRICE = 1073741824;
    int backPrev;
    int backPrev2;
    boolean hasPrev2;
    int optPrev;
    int optPrev2;
    boolean prev1IsLiteral;
    int price;
    final int[] reps = new int[4];
    final State state = new State();

    Optimum() {
    }

    void reset() {
        this.price = 1073741824;
    }

    void set1(int n, int n2, int n3) {
        this.price = n;
        this.optPrev = n2;
        this.backPrev = n3;
        this.prev1IsLiteral = false;
    }

    void set2(int n, int n2, int n3) {
        this.price = n;
        this.optPrev = n2 + 1;
        this.backPrev = n3;
        this.prev1IsLiteral = true;
        this.hasPrev2 = false;
    }

    void set3(int n, int n2, int n3, int n4, int n5) {
        this.price = n;
        this.optPrev = 1 + (n2 + n4);
        this.backPrev = n5;
        this.prev1IsLiteral = true;
        this.hasPrev2 = true;
        this.optPrev2 = n2;
        this.backPrev2 = n3;
    }
}

