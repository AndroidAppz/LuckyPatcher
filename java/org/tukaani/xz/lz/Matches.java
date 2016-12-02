package org.tukaani.xz.lz;

public final class Matches {
    public int count = 0;
    public final int[] dist;
    public final int[] len;

    Matches(int countMax) {
        this.len = new int[countMax];
        this.dist = new int[countMax];
    }
}
