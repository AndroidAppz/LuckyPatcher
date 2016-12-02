package org.tukaani.xz;

abstract class BCJOptions extends FilterOptions {
    static final /* synthetic */ boolean $assertionsDisabled = (!BCJOptions.class.desiredAssertionStatus());
    private final int alignment;
    int startOffset = 0;

    BCJOptions(int alignment) {
        this.alignment = alignment;
    }

    public void setStartOffset(int startOffset) throws UnsupportedOptionsException {
        if (((this.alignment - 1) & startOffset) != 0) {
            throw new UnsupportedOptionsException("Start offset must be a multiple of " + this.alignment);
        }
        this.startOffset = startOffset;
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    public int getEncoderMemoryUsage() {
        return SimpleOutputStream.getMemoryUsage();
    }

    public int getDecoderMemoryUsage() {
        return SimpleInputStream.getMemoryUsage();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if ($assertionsDisabled) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }
}
