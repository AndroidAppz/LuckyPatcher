package org.tukaani.xz.check;

public class CRC32 extends Check {
    private final java.util.zip.CRC32 state;

    public CRC32() {
        this.state = new java.util.zip.CRC32();
        this.size = 4;
        this.name = "CRC32";
    }

    public void update(byte[] buf, int off, int len) {
        this.state.update(buf, off, len);
    }

    public byte[] finish() {
        long value = this.state.getValue();
        byte[] buf = new byte[]{(byte) ((int) value), (byte) ((int) (value >>> 8)), (byte) ((int) (value >>> 16)), (byte) ((int) (value >>> 24))};
        this.state.reset();
        return buf;
    }
}
