package org.tukaani.xz.index;

import org.tukaani.xz.XZIOException;
import org.tukaani.xz.common.Util;

abstract class IndexBase {
    long blocksSum = 0;
    long indexListSize = 0;
    private final XZIOException invalidIndexException;
    long recordCount = 0;
    long uncompressedSum = 0;

    IndexBase(XZIOException invalidIndexException) {
        this.invalidIndexException = invalidIndexException;
    }

    private long getUnpaddedIndexSize() {
        return (((long) (Util.getVLISize(this.recordCount) + 1)) + this.indexListSize) + 4;
    }

    public long getIndexSize() {
        return (getUnpaddedIndexSize() + 3) & -4;
    }

    public long getStreamSize() {
        return ((this.blocksSum + 12) + getIndexSize()) + 12;
    }

    int getIndexPaddingSize() {
        return (int) ((4 - getUnpaddedIndexSize()) & 3);
    }

    void add(long unpaddedSize, long uncompressedSize) throws XZIOException {
        this.blocksSum += (3 + unpaddedSize) & -4;
        this.uncompressedSum += uncompressedSize;
        this.indexListSize += (long) (Util.getVLISize(unpaddedSize) + Util.getVLISize(uncompressedSize));
        this.recordCount++;
        if (this.blocksSum < 0 || this.uncompressedSum < 0 || getIndexSize() > Util.BACKWARD_SIZE_MAX || getStreamSize() < 0) {
            throw this.invalidIndexException;
        }
    }
}
