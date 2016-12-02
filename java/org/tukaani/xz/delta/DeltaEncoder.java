/*
 * Decompiled with CFR 0_110.
 */
package org.tukaani.xz.delta;

import org.tukaani.xz.delta.DeltaCoder;

public class DeltaEncoder
extends DeltaCoder {
    public DeltaEncoder(int n) {
        super(n);
    }

    public void encode(byte[] arrby, int n, int n2, byte[] arrby2) {
        for (int i = 0; i < n2; ++i) {
            byte by = this.history[255 & this.distance + this.pos];
            byte[] arrby3 = this.history;
            int n3 = this.pos;
            this.pos = n3 - 1;
            arrby3[n3 & 255] = arrby[n + i];
            arrby2[i] = (byte)(arrby[n + i] - by);
        }
    }
}

