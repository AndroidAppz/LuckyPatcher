package org.tukaani.xz.lzma;

import com.chelpus.Common;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.rangecoder.RangeEncoder;
import pxb.android.ResConst;

final class LZMAEncoderFast extends LZMAEncoder {
    private static int EXTRA_SIZE_AFTER = 272;
    private static int EXTRA_SIZE_BEFORE = 1;
    private Matches matches = null;

    static int getMemoryUsage(int dictSize, int extraSizeBefore, int mf) {
        return LZEncoder.getMemoryUsage(dictSize, Math.max(extraSizeBefore, EXTRA_SIZE_BEFORE), EXTRA_SIZE_AFTER, LZMA2Options.NICE_LEN_MAX, mf);
    }

    LZMAEncoderFast(RangeEncoder rc, int lc, int lp, int pb, int dictSize, int extraSizeBefore, int niceLen, int mf, int depthLimit) {
        super(rc, LZEncoder.getInstance(dictSize, Math.max(extraSizeBefore, EXTRA_SIZE_BEFORE), EXTRA_SIZE_AFTER, niceLen, LZMA2Options.NICE_LEN_MAX, mf, depthLimit), lc, lp, pb, dictSize, niceLen);
    }

    private boolean changePair(int smallDist, int bigDist) {
        return smallDist < (bigDist >>> 7);
    }

    int getNextSymbol() {
        if (this.readAhead == -1) {
            this.matches = getMatches();
        }
        this.back = -1;
        int avail = Math.min(this.lz.getAvail(), LZMA2Options.NICE_LEN_MAX);
        if (avail < 2) {
            return 1;
        }
        int rep;
        int bestRepLen = 0;
        int bestRepIndex = 0;
        for (rep = 0; rep < 4; rep++) {
            int len = this.lz.getMatchLen(this.reps[rep], avail);
            if (len >= 2) {
                if (len >= this.niceLen) {
                    this.back = rep;
                    skip(len - 1);
                    return len;
                } else if (len > bestRepLen) {
                    bestRepIndex = rep;
                    bestRepLen = len;
                }
            }
        }
        int mainLen = 0;
        int mainDist = 0;
        if (this.matches.count > 0) {
            mainLen = this.matches.len[this.matches.count - 1];
            mainDist = this.matches.dist[this.matches.count - 1];
            if (mainLen >= this.niceLen) {
                this.back = mainDist + 4;
                skip(mainLen - 1);
                return mainLen;
            }
            while (this.matches.count > 1 && mainLen == this.matches.len[this.matches.count - 2] + 1 && changePair(this.matches.dist[this.matches.count - 2], mainDist)) {
                Matches matches = this.matches;
                matches.count--;
                mainLen = this.matches.len[this.matches.count - 1];
                mainDist = this.matches.dist[this.matches.count - 1];
            }
            if (mainLen == 2 && mainDist >= Common.INSTALL_ALLOW_DOWNGRADE) {
                mainLen = 1;
            }
        }
        if (bestRepLen >= 2 && (bestRepLen + 1 >= mainLen || ((bestRepLen + 2 >= mainLen && mainDist >= ResConst.RES_TABLE_PACKAGE_TYPE) || (bestRepLen + 3 >= mainLen && mainDist >= 32768)))) {
            this.back = bestRepIndex;
            skip(bestRepLen - 1);
            return bestRepLen;
        } else if (mainLen < 2 || avail <= 2) {
            return 1;
        } else {
            this.matches = getMatches();
            if (this.matches.count > 0) {
                int newLen = this.matches.len[this.matches.count - 1];
                int newDist = this.matches.dist[this.matches.count - 1];
                if ((newLen >= mainLen && newDist < mainDist) || ((newLen == mainLen + 1 && !changePair(mainDist, newDist)) || newLen > mainLen + 1 || (newLen + 1 >= mainLen && mainLen >= 3 && changePair(newDist, mainDist)))) {
                    return 1;
                }
            }
            int limit = Math.max(mainLen - 1, 2);
            for (rep = 0; rep < 4; rep++) {
                if (this.lz.getMatchLen(this.reps[rep], limit) == limit) {
                    return 1;
                }
            }
            this.back = mainDist + 4;
            skip(mainLen - 2);
            return mainLen;
        }
    }
}
