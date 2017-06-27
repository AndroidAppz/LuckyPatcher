package org.tukaani.xz.lz;

import com.chelpus.Common;

final class BT4 extends LZEncoder {
    private int cyclicPos = -1;
    private final int cyclicSize;
    private final int depthLimit;
    private final Hash234 hash;
    private int lzPos;
    private final Matches matches;
    private final int[] tree;

    static int getMemoryUsage(int dictSize) {
        return (Hash234.getMemoryUsage(dictSize) + (dictSize / Common.INSTALL_ALLOW_DOWNGRADE)) + 10;
    }

    BT4(int dictSize, int beforeSizeMin, int readAheadMax, int niceLen, int matchLenMax, int depthLimit) {
        super(dictSize, beforeSizeMin, readAheadMax, niceLen, matchLenMax);
        this.cyclicSize = dictSize + 1;
        this.lzPos = this.cyclicSize;
        this.hash = new Hash234(dictSize);
        this.tree = new int[(this.cyclicSize * 2)];
        this.matches = new Matches(niceLen - 1);
        if (depthLimit <= 0) {
            depthLimit = (niceLen / 2) + 16;
        }
        this.depthLimit = depthLimit;
    }

    private int movePos() {
        int avail = movePos(this.niceLen, 4);
        if (avail != 0) {
            int i = this.lzPos + 1;
            this.lzPos = i;
            if (i == Integer.MAX_VALUE) {
                int normalizationOffset = Integer.MAX_VALUE - this.cyclicSize;
                this.hash.normalize(normalizationOffset);
                LZEncoder.normalize(this.tree, normalizationOffset);
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
                skip(niceLenLimit, currentMatch);
                return this.matches;
            }
        }
        if (lenBest < 3) {
            lenBest = 3;
        }
        int depth = this.depthLimit;
        int ptr0 = (this.cyclicPos << 1) + 1;
        int ptr1 = this.cyclicPos << 1;
        int len0 = 0;
        int len1 = 0;
        while (true) {
            int delta = this.lzPos - currentMatch;
            int depth2 = depth - 1;
            if (depth == 0 || delta >= this.cyclicSize) {
                this.tree[ptr0] = 0;
                this.tree[ptr1] = 0;
            } else {
                int pair = ((delta > this.cyclicPos ? this.cyclicSize : 0) + (this.cyclicPos - delta)) << 1;
                int len = Math.min(len0, len1);
                if (this.buf[(this.readPos + len) - delta] == this.buf[this.readPos + len]) {
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
                            this.tree[ptr1] = this.tree[pair];
                            this.tree[ptr0] = this.tree[pair + 1];
                            return this.matches;
                        }
                    }
                }
                if ((this.buf[(this.readPos + len) - delta] & 255) < (this.buf[this.readPos + len] & 255)) {
                    this.tree[ptr1] = currentMatch;
                    ptr1 = pair + 1;
                    currentMatch = this.tree[ptr1];
                    len1 = len;
                    depth = depth2;
                } else {
                    this.tree[ptr0] = currentMatch;
                    ptr0 = pair;
                    currentMatch = this.tree[ptr0];
                    len0 = len;
                    depth = depth2;
                }
            }
        }
        this.tree[ptr0] = 0;
        this.tree[ptr1] = 0;
        return this.matches;
    }

    private void skip(int niceLenLimit, int currentMatch) {
        int depth = this.depthLimit;
        int ptr0 = (this.cyclicPos << 1) + 1;
        int ptr1 = this.cyclicPos << 1;
        int len0 = 0;
        int len1 = 0;
        while (true) {
            int delta = this.lzPos - currentMatch;
            int depth2 = depth - 1;
            if (depth == 0 || delta >= this.cyclicSize) {
                this.tree[ptr0] = 0;
                this.tree[ptr1] = 0;
            } else {
                int i;
                int i2 = this.cyclicPos - delta;
                if (delta > this.cyclicPos) {
                    i = this.cyclicSize;
                } else {
                    i = 0;
                }
                int pair = (i + i2) << 1;
                int len = Math.min(len0, len1);
                if (this.buf[(this.readPos + len) - delta] == this.buf[this.readPos + len]) {
                    do {
                        len++;
                        if (len == niceLenLimit) {
                            this.tree[ptr1] = this.tree[pair];
                            this.tree[ptr0] = this.tree[pair + 1];
                            return;
                        }
                    } while (this.buf[(this.readPos + len) - delta] == this.buf[this.readPos + len]);
                }
                if ((this.buf[(this.readPos + len) - delta] & 255) < (this.buf[this.readPos + len] & 255)) {
                    this.tree[ptr1] = currentMatch;
                    ptr1 = pair + 1;
                    currentMatch = this.tree[ptr1];
                    len1 = len;
                    depth = depth2;
                } else {
                    this.tree[ptr0] = currentMatch;
                    ptr0 = pair;
                    currentMatch = this.tree[ptr0];
                    len0 = len;
                    depth = depth2;
                }
            }
        }
        this.tree[ptr0] = 0;
        this.tree[ptr1] = 0;
    }

    public void skip(int len) {
        int len2 = len;
        while (true) {
            len = len2 - 1;
            if (len2 > 0) {
                int niceLenLimit = this.niceLen;
                int avail = movePos();
                if (avail < niceLenLimit) {
                    if (avail == 0) {
                        len2 = len;
                    } else {
                        niceLenLimit = avail;
                    }
                }
                this.hash.calcHashes(this.buf, this.readPos);
                int currentMatch = this.hash.getHash4Pos();
                this.hash.updateTables(this.lzPos);
                skip(niceLenLimit, currentMatch);
                len2 = len;
            } else {
                return;
            }
        }
    }
}
