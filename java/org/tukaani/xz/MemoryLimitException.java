package org.tukaani.xz;

public class MemoryLimitException extends XZIOException {
    private static final long serialVersionUID = 3;
    private final int memoryLimit;
    private final int memoryNeeded;

    public MemoryLimitException(int memoryNeeded, int memoryLimit) {
        super("" + memoryNeeded + " KiB of memory would be needed; limit was " + memoryLimit + " KiB");
        this.memoryNeeded = memoryNeeded;
        this.memoryLimit = memoryLimit;
    }

    public int getMemoryNeeded() {
        return this.memoryNeeded;
    }

    public int getMemoryLimit() {
        return this.memoryLimit;
    }
}
