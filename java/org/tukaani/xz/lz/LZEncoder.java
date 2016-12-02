package org.tukaani.xz.lz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.common.Util;

public abstract class LZEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = (!LZEncoder.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    public static final int MF_BT4 = 20;
    public static final int MF_HC4 = 4;
    final byte[] buf;
    private boolean finishing = $assertionsDisabled;
    private final int keepSizeAfter;
    private final int keepSizeBefore;
    final int matchLenMax;
    final int niceLen;
    private int pendingSize = 0;
    private int readLimit = -1;
    int readPos = -1;
    private int writePos = 0;

    public abstract Matches getMatches();

    public abstract void skip(int i);

    static void normalize(int[] positions, int normalizationOffset) {
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] <= normalizationOffset) {
                positions[i] = 0;
            } else {
                positions[i] = positions[i] - normalizationOffset;
            }
        }
    }

    private static int getBufSize(int dictSize, int extraSizeBefore, int extraSizeAfter, int matchLenMax) {
        int keepSizeBefore = extraSizeBefore + dictSize;
        int keepSizeAfter = extraSizeAfter + matchLenMax;
        return (keepSizeBefore + keepSizeAfter) + Math.min((dictSize / 2) + 262144, 536870912);
    }

    public static int getMemoryUsage(int dictSize, int extraSizeBefore, int extraSizeAfter, int matchLenMax, int mf) {
        int m = (getBufSize(dictSize, extraSizeBefore, extraSizeAfter, matchLenMax) / Util.BLOCK_HEADER_SIZE_MAX) + 10;
        switch (mf) {
            case MF_HC4 /*4*/:
                return m + HC4.getMemoryUsage(dictSize);
            case MF_BT4 /*20*/:
                return m + BT4.getMemoryUsage(dictSize);
            default:
                throw new IllegalArgumentException();
        }
    }

    public static LZEncoder getInstance(int dictSize, int extraSizeBefore, int extraSizeAfter, int niceLen, int matchLenMax, int mf, int depthLimit) {
        switch (mf) {
            case MF_HC4 /*4*/:
                return new HC4(dictSize, extraSizeBefore, extraSizeAfter, niceLen, matchLenMax, depthLimit);
            case MF_BT4 /*20*/:
                return new BT4(dictSize, extraSizeBefore, extraSizeAfter, niceLen, matchLenMax, depthLimit);
            default:
                throw new IllegalArgumentException();
        }
    }

    LZEncoder(int dictSize, int extraSizeBefore, int extraSizeAfter, int niceLen, int matchLenMax) {
        this.buf = new byte[getBufSize(dictSize, extraSizeBefore, extraSizeAfter, matchLenMax)];
        this.keepSizeBefore = extraSizeBefore + dictSize;
        this.keepSizeAfter = extraSizeAfter + matchLenMax;
        this.matchLenMax = matchLenMax;
        this.niceLen = niceLen;
    }

    public void setPresetDict(int dictSize, byte[] presetDict) {
        if (!$assertionsDisabled && isStarted()) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && this.writePos != 0) {
            throw new AssertionError();
        } else if (presetDict != null) {
            int copySize = Math.min(presetDict.length, dictSize);
            System.arraycopy(presetDict, presetDict.length - copySize, this.buf, 0, copySize);
            this.writePos += copySize;
            skip(copySize);
        }
    }

    private void moveWindow() {
        int moveOffset = ((this.readPos + 1) - this.keepSizeBefore) & -16;
        System.arraycopy(this.buf, moveOffset, this.buf, 0, this.writePos - moveOffset);
        this.readPos -= moveOffset;
        this.readLimit -= moveOffset;
        this.writePos -= moveOffset;
    }

    public int fillWindow(byte[] in, int off, int len) {
        if ($assertionsDisabled || !this.finishing) {
            if (this.readPos >= this.buf.length - this.keepSizeAfter) {
                moveWindow();
            }
            if (len > this.buf.length - this.writePos) {
                len = this.buf.length - this.writePos;
            }
            System.arraycopy(in, off, this.buf, this.writePos, len);
            this.writePos += len;
            if (this.writePos >= this.keepSizeAfter) {
                this.readLimit = this.writePos - this.keepSizeAfter;
            }
            processPendingBytes();
            return len;
        }
        throw new AssertionError();
    }

    private void processPendingBytes() {
        if (this.pendingSize > 0 && this.readPos < this.readLimit) {
            this.readPos -= this.pendingSize;
            int oldPendingSize = this.pendingSize;
            this.pendingSize = 0;
            skip(oldPendingSize);
            if (!$assertionsDisabled && this.pendingSize >= oldPendingSize) {
                throw new AssertionError();
            }
        }
    }

    public boolean isStarted() {
        return this.readPos != -1 ? true : $assertionsDisabled;
    }

    public void setFlushing() {
        this.readLimit = this.writePos - 1;
        processPendingBytes();
    }

    public void setFinishing() {
        this.readLimit = this.writePos - 1;
        this.finishing = true;
        processPendingBytes();
    }

    public boolean hasEnoughData(int alreadyReadLen) {
        return this.readPos - alreadyReadLen < this.readLimit ? true : $assertionsDisabled;
    }

    public void copyUncompressed(OutputStream out, int backward, int len) throws IOException {
        out.write(this.buf, (this.readPos + 1) - backward, len);
    }

    public int getAvail() {
        if ($assertionsDisabled || isStarted()) {
            return this.writePos - this.readPos;
        }
        throw new AssertionError();
    }

    public int getPos() {
        return this.readPos;
    }

    public int getByte(int backward) {
        return this.buf[this.readPos - backward] & 255;
    }

    public int getByte(int forward, int backward) {
        return this.buf[(this.readPos + forward) - backward] & 255;
    }

    public int getMatchLen(int dist, int lenLimit) {
        int backPos = (this.readPos - dist) - 1;
        int len = 0;
        while (len < lenLimit && this.buf[this.readPos + len] == this.buf[backPos + len]) {
            len++;
        }
        return len;
    }

    public int getMatchLen(int forward, int dist, int lenLimit) {
        int curPos = this.readPos + forward;
        int backPos = (curPos - dist) - 1;
        int len = 0;
        while (len < lenLimit && this.buf[curPos + len] == this.buf[backPos + len]) {
            len++;
        }
        return len;
    }

    public boolean verifyMatches(Matches matches) {
        int lenLimit = Math.min(getAvail(), this.matchLenMax);
        for (int i = 0; i < matches.count; i++) {
            if (getMatchLen(matches.dist[i], lenLimit) != matches.len[i]) {
                return $assertionsDisabled;
            }
        }
        return true;
    }

    int movePos(int requiredForFlushing, int requiredForFinishing) {
        if ($assertionsDisabled || requiredForFlushing >= requiredForFinishing) {
            this.readPos++;
            int avail = this.writePos - this.readPos;
            if (avail >= requiredForFlushing) {
                return avail;
            }
            if (avail >= requiredForFinishing && this.finishing) {
                return avail;
            }
            this.pendingSize++;
            return 0;
        }
        throw new AssertionError();
    }
}
