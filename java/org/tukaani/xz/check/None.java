package org.tukaani.xz.check;

public class None extends Check {
    public None() {
        this.size = 0;
        this.name = "None";
    }

    public void update(byte[] buf, int off, int len) {
    }

    public byte[] finish() {
        return new byte[0];
    }
}
