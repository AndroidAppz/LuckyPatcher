/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.index;

import org.tukaani.xz.XZIOException;
import org.tukaani.xz.common.Util;

abstract class IndexBase {
    long blocksSum = 0;
    long indexListSize = 0;
    private final XZIOException invalidIndexException;
    long recordCount = 0;
    long uncompressedSum = 0;

    IndexBase(XZIOException xZIOException) {
        this.invalidIndexException = xZIOException;
    }

    private long getUnpaddedIndexSize() {
        return 4 + ((long)(1 + Util.getVLISize(this.recordCount)) + this.indexListSize);
    }

    void add(long l, long l2) throws XZIOException {
        this.blocksSum += -4 & 3 + l;
        this.uncompressedSum = l2 + this.uncompressedSum;
        this.indexListSize += (long)(Util.getVLISize(l) + Util.getVLISize(l2));
        this.recordCount = 1 + this.recordCount;
        if (this.blocksSum < 0 || this.uncompressedSum < 0 || this.getIndexSize() > 0x400000000L || this.getStreamSize() < 0) {
            throw this.invalidIndexException;
        }
    }

    int getIndexPaddingSize() {
        return (int)(3 & 4 - this.getUnpaddedIndexSize());
    }

    public long getIndexSize() {
        return -4 & 3 + this.getUnpaddedIndexSize();
    }

    public long getStreamSize() {
        return 12 + (12 + this.blocksSum + this.getIndexSize());
    }
}

