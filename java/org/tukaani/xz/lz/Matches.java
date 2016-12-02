/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.lz;

public final class Matches {
    public int count = 0;
    public final int[] dist;
    public final int[] len;

    Matches(int n) {
        this.len = new int[n];
        this.dist = new int[n];
    }
}

