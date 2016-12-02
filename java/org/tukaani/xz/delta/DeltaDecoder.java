/*
 * Decompiled with CFR 0_110.
 */
package org.tukaani.xz.delta;

import org.tukaani.xz.delta.DeltaCoder;

public class DeltaDecoder
extends DeltaCoder {
    public DeltaDecoder(int n) {
        super(n);
    }

    public void decode(byte[] arrby, int n, int n2) {
        int n3 = n + n2;
        for (int i = n; i < n3; ++i) {
            arrby[i] = (byte)(arrby[i] + this.history[255 & this.distance + this.pos]);
            byte[] arrby2 = this.history;
            int n4 = this.pos;
            this.pos = n4 - 1;
            arrby2[n4 & 255] = arrby[i];
        }
    }
}

