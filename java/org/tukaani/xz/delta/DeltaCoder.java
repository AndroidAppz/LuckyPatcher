/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package org.tukaani.xz.delta;

abstract class DeltaCoder {
    static final int DISTANCE_MASK = 255;
    static final int DISTANCE_MAX = 256;
    static final int DISTANCE_MIN = 1;
    final int distance;
    final byte[] history = new byte[256];
    int pos = 0;

    DeltaCoder(int n) {
        if (n < 1 || n > 256) {
            throw new IllegalArgumentException();
        }
        this.distance = n;
    }
}

