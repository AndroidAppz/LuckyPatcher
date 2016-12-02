package org.tukaani.xz.delta;

public class DeltaDecoder extends DeltaCoder {
    public DeltaDecoder(int distance) {
        super(distance);
    }

    public void decode(byte[] buf, int off, int len) {
        int end = off + len;
        for (int i = off; i < end; i++) {
            buf[i] = (byte) (buf[i] + this.history[(this.distance + this.pos) & 255]);
            byte[] bArr = this.history;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2 & 255] = buf[i];
        }
    }
}
