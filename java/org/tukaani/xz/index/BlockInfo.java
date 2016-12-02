/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz.index;

import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexDecoder;

public class BlockInfo {
    public int blockNumber = -1;
    public long compressedOffset = -1;
    IndexDecoder index;
    public long uncompressedOffset = -1;
    public long uncompressedSize = -1;
    public long unpaddedSize = -1;

    public BlockInfo(IndexDecoder indexDecoder) {
        this.index = indexDecoder;
    }

    public int getCheckType() {
        return this.index.getStreamFlags().checkType;
    }

    public boolean hasNext() {
        return this.index.hasRecord(1 + this.blockNumber);
    }

    public void setNext() {
        this.index.setBlockInfo(this, 1 + this.blockNumber);
    }
}

