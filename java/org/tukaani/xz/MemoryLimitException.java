/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.tukaani.xz;

import org.tukaani.xz.XZIOException;

public class MemoryLimitException
extends XZIOException {
    private static final long serialVersionUID = 3;
    private final int memoryLimit;
    private final int memoryNeeded;

    public MemoryLimitException(int n, int n2) {
        super("" + n + " KiB of memory would be needed; limit was " + n2 + " KiB");
        this.memoryNeeded = n;
        this.memoryLimit = n2;
    }

    public int getMemoryLimit() {
        return this.memoryLimit;
    }

    public int getMemoryNeeded() {
        return this.memoryNeeded;
    }
}

