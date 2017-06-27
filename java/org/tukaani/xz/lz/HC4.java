package org.tukaani.xz.lz;

import pxb.android.ResConst;

final class HC4 extends LZEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = (!HC4.class.desiredAssertionStatus());
    private final int[] chain;
    private int cyclicPos = -1;
    private final int cyclicSize;
    private final int depthLimit;
    private final Hash234 hash;
    private int lzPos;
    private final Matches matches;

    static int getMemoryUsage(int dictSize) {
        return (Hash234.getMemoryUsage(dictSize) + (dictSize / ResConst.RES_XML_START_NAMESPACE_TYPE)) + 10;
    }

    HC4(int dictSize, int beforeSizeMin, int readAheadMax, int niceLen, int matchLenMax, int depthLimit) {
        super(dictSize, beforeSizeMin, readAheadMax, niceLen, matchLenMax);
        this.hash = new Hash234(dictSize);
        this.cyclicSize = dictSize + 1;
        this.chain = new int[this.cyclicSize];
        this.lzPos = this.cyclicSize;
        this.matches = new Matches(niceLen - 1);
        if (depthLimit <= 0) {
            depthLimit = (niceLen / 4) + 4;
        }
        this.depthLimit = depthLimit;
    }

    private int movePos() {
        int avail = movePos(4, 4);
        if (avail != 0) {
            int i = this.lzPos + 1;
            this.lzPos = i;
            if (i == Integer.MAX_VALUE) {
                int normalizationOffset = Integer.MAX_VALUE - this.cyclicSize;
                this.hash.normalize(normalizationOffset);
                LZEncoder.normalize(this.chain, normalizationOffset);
                this.lzPos -= normalizationOffset;
            }
            i = this.cyclicPos + 1;
            this.cyclicPos = i;
            if (i == this.cyclicSize) {
                this.cyclicPos = 0;
            }
        }
        return avail;
    }

    public Matches getMatches() {
        this.matches.count = 0;
        int matchLenLimit = this.matchLenMax;
        int niceLenLimit = this.niceLen;
        int avail = movePos();
        if (avail < matchLenLimit) {
            if (avail == 0) {
                return this.matches;
            }
            matchLenLimit = avail;
            if (niceLenLimit > avail) {
                niceLenLimit = avail;
            }
        }
        this.hash.calcHashes(this.buf, this.readPos);
        int delta2 = this.lzPos - this.hash.getHash2Pos();
        int delta3 = this.lzPos - this.hash.getHash3Pos();
        int currentMatch = this.hash.getHash4Pos();
        this.hash.updateTables(this.lzPos);
        this.chain[this.cyclicPos] = currentMatch;
        int lenBest = 0;
        if (delta2 < this.cyclicSize && this.buf[this.readPos - delta2] == this.buf[this.readPos]) {
            lenBest = 2;
            this.matches.len[0] = 2;
            this.matches.dist[0] = delta2 - 1;
            this.matches.count = 1;
        }
        if (delta2 != delta3 && delta3 < this.cyclicSize && this.buf[this.readPos - delta3] == this.buf[this.readPos]) {
            lenBest = 3;
            int[] iArr = this.matches.dist;
            Matches matches = this.matches;
            int i = matches.count;
            matches.count = i + 1;
            iArr[i] = delta3 - 1;
            delta2 = delta3;
        }
        if (this.matches.count > 0) {
            while (lenBest < matchLenLimit && this.buf[(this.readPos + lenBest) - delta2] == this.buf[this.readPos + lenBest]) {
                lenBest++;
            }
            this.matches.len[this.matches.count - 1] = lenBest;
            if (lenBest >= niceLenLimit) {
                return this.matches;
            }
        }
        if (lenBest < 3) {
            lenBest = 3;
        }
        int depth = this.depthLimit;
        while (true) {
            int delta = this.lzPos - currentMatch;
            int depth2 = depth - 1;
            if (depth != 0 && delta < this.cyclicSize) {
                currentMatch = this.chain[(delta > this.cyclicPos ? this.cyclicSize : 0) + (this.cyclicPos - delta)];
                if (this.buf[(this.readPos + lenBest) - delta] == this.buf[this.readPos + lenBest] && this.buf[this.readPos - delta] == this.buf[this.readPos]) {
                    int len = 0;
                    do {
                        len++;
                        if (len >= matchLenLimit) {
                            break;
                        }
                    } while (this.buf[(this.readPos + len) - delta] == this.buf[this.readPos + len]);
                    if (len > lenBest) {
                        lenBest = len;
                        this.matches.len[this.matches.count] = len;
                        this.matches.dist[this.matches.count] = delta - 1;
                        Matches matches2 = this.matches;
                        matches2.count++;
                        if (len >= niceLenLimit) {
                            return this.matches;
                        }
                    } else {
                        continue;
                    }
                }
                depth = depth2;
            }
        }
        return this.matches;
    }

    public void skip(int len) {
        if ($assertionsDisabled || len >= 0) {
            while (true) {
                int len2 = len;
                len = len2 - 1;
                if (len2 > 0) {
                    if (movePos() != 0) {
                        this.hash.calcHashes(this.buf, this.readPos);
                        this.chain[this.cyclicPos] = this.hash.getHash4Pos();
                        this.hash.updateTables(this.lzPos);
                    }
                } else {
                    return;
                }
            }
        }
        throw new AssertionError();
    }
}
