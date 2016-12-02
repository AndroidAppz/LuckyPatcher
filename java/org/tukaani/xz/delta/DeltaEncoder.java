package org.tukaani.xz.delta;

public class DeltaEncoder extends DeltaCoder {
    public DeltaEncoder(int distance) {
        super(distance);
    }

    public void encode(byte[] in, int in_off, int len, byte[] out) {
        for (int i = 0; i < len; i++) {
            byte tmp = this.history[(this.distance + this.pos) & 255];
            byte[] bArr = this.history;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2 & 255] = in[in_off + i];
            out[i] = (byte) (in[in_off + i] - tmp);
        }
    }
}
