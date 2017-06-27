package org.tukaani.xz.lzma;

import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.rangecoder.RangeEncoder;
import pxb.android.ResConst;

final class LZMAEncoderNormal extends LZMAEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = (!LZMAEncoderNormal.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static int EXTRA_SIZE_AFTER = OPTS;
    private static int EXTRA_SIZE_BEFORE = OPTS;
    private static final int OPTS = 4096;
    private Matches matches;
    private final State nextState = new State();
    private int optCur = 0;
    private int optEnd = 0;
    private final Optimum[] opts = new Optimum[OPTS];
    private final int[] repLens = new int[4];

    static int getMemoryUsage(int dictSize, int extraSizeBefore, int mf) {
        return LZEncoder.getMemoryUsage(dictSize, Math.max(extraSizeBefore, EXTRA_SIZE_BEFORE), EXTRA_SIZE_AFTER, LZMA2Options.NICE_LEN_MAX, mf) + ResConst.RES_XML_START_NAMESPACE_TYPE;
    }

    LZMAEncoderNormal(RangeEncoder rc, int lc, int lp, int pb, int dictSize, int extraSizeBefore, int niceLen, int mf, int depthLimit) {
        super(rc, LZEncoder.getInstance(dictSize, Math.max(extraSizeBefore, EXTRA_SIZE_BEFORE), EXTRA_SIZE_AFTER, niceLen, LZMA2Options.NICE_LEN_MAX, mf, depthLimit), lc, lp, pb, dictSize, niceLen);
        for (int i = 0; i < OPTS; i++) {
            this.opts[i] = new Optimum();
        }
    }

    public void reset() {
        this.optCur = 0;
        this.optEnd = 0;
        super.reset();
    }

    private int convertOpts() {
        this.optEnd = this.optCur;
        int optPrev = this.opts[this.optCur].optPrev;
        do {
            Optimum opt = this.opts[this.optCur];
            if (opt.prev1IsLiteral) {
                this.opts[optPrev].optPrev = this.optCur;
                this.opts[optPrev].backPrev = -1;
                int optPrev2 = optPrev - 1;
                this.optCur = optPrev;
                if (opt.hasPrev2) {
                    this.opts[optPrev2].optPrev = optPrev2 + 1;
                    this.opts[optPrev2].backPrev = opt.backPrev2;
                    this.optCur = optPrev2;
                    optPrev = opt.optPrev2;
                } else {
                    optPrev = optPrev2;
                }
            }
            int temp = this.opts[optPrev].optPrev;
            this.opts[optPrev].optPrev = this.optCur;
            this.optCur = optPrev;
            optPrev = temp;
        } while (this.optCur > 0);
        this.optCur = this.opts[0].optPrev;
        this.back = this.opts[this.optCur].backPrev;
        return this.optCur;
    }

    int getNextSymbol() {
        int len;
        if (this.optCur < this.optEnd) {
            len = this.opts[this.optCur].optPrev - this.optCur;
            this.optCur = this.opts[this.optCur].optPrev;
            this.back = this.opts[this.optCur].backPrev;
            return len;
        } else if ($assertionsDisabled || this.optCur == this.optEnd) {
            this.optCur = 0;
            this.optEnd = 0;
            this.back = -1;
            if (this.readAhead == -1) {
                this.matches = getMatches();
            }
            int avail = Math.min(this.lz.getAvail(), LZMA2Options.NICE_LEN_MAX);
            if (avail < 2) {
                return 1;
            }
            int rep;
            int repBest = 0;
            for (rep = 0; rep < 4; rep++) {
                this.repLens[rep] = this.lz.getMatchLen(this.reps[rep], avail);
                if (this.repLens[rep] < 2) {
                    this.repLens[rep] = 0;
                } else if (this.repLens[rep] > this.repLens[repBest]) {
                    repBest = rep;
                }
            }
            if (this.repLens[repBest] >= this.niceLen) {
                this.back = repBest;
                skip(this.repLens[repBest] - 1);
                return this.repLens[repBest];
            }
            int mainLen = 0;
            if (this.matches.count > 0) {
                mainLen = this.matches.len[this.matches.count - 1];
                int mainDist = this.matches.dist[this.matches.count - 1];
                if (mainLen >= this.niceLen) {
                    this.back = mainDist + 4;
                    skip(mainLen - 1);
                    return mainLen;
                }
            }
            int curByte = this.lz.getByte(0);
            int matchByte = this.lz.getByte(this.reps[0] + 1);
            if (mainLen < 2 && curByte != matchByte && this.repLens[repBest] < 2) {
                return 1;
            }
            int pos = this.lz.getPos();
            int posState = pos & this.posMask;
            this.opts[1].set1(this.literalEncoder.getPrice(curByte, matchByte, this.lz.getByte(1), pos, this.state), 0, -1);
            int anyMatchPrice = getAnyMatchPrice(this.state, posState);
            int anyRepPrice = getAnyRepPrice(anyMatchPrice, this.state);
            if (matchByte == curByte) {
                int shortRepPrice = getShortRepPrice(anyRepPrice, this.state, posState);
                if (shortRepPrice < this.opts[1].price) {
                    this.opts[1].set1(shortRepPrice, 0, 0);
                }
            }
            this.optEnd = Math.max(mainLen, this.repLens[repBest]);
            if (this.optEnd >= 2) {
                int i;
                int price;
                updatePrices();
                this.opts[0].state.set(this.state);
                System.arraycopy(this.reps, 0, this.opts[0].reps, 0, 4);
                for (i = this.optEnd; i >= 2; i--) {
                    this.opts[i].reset();
                }
                for (rep = 0; rep < 4; rep++) {
                    int repLen = this.repLens[rep];
                    if (repLen >= 2) {
                        int longRepPrice = getLongRepPrice(anyRepPrice, rep, this.state, posState);
                        do {
                            price = longRepPrice + this.repLenEncoder.getPrice(repLen, posState);
                            if (price < this.opts[repLen].price) {
                                this.opts[repLen].set1(price, 0, rep);
                            }
                            repLen--;
                        } while (repLen >= 2);
                    }
                }
                len = Math.max(this.repLens[0] + 1, 2);
                if (len <= mainLen) {
                    int normalMatchPrice = getNormalMatchPrice(anyMatchPrice, this.state);
                    i = 0;
                    while (len > this.matches.len[i]) {
                        i++;
                    }
                    while (true) {
                        int dist = this.matches.dist[i];
                        price = getMatchAndLenPrice(normalMatchPrice, dist, len, posState);
                        if (price < this.opts[len].price) {
                            this.opts[len].set1(price, 0, dist + 4);
                        }
                        if (len == this.matches.len[i]) {
                            i++;
                            if (i == this.matches.count) {
                                break;
                            }
                        }
                        len++;
                    }
                }
                avail = Math.min(this.lz.getAvail(), 4095);
                while (true) {
                    int i2 = this.optCur + 1;
                    this.optCur = i2;
                    if (i2 < this.optEnd) {
                        this.matches = getMatches();
                        if (this.matches.count > 0 && this.matches.len[this.matches.count - 1] >= this.niceLen) {
                            break;
                        }
                        avail--;
                        pos++;
                        posState = pos & this.posMask;
                        updateOptStateAndReps();
                        anyMatchPrice = this.opts[this.optCur].price + getAnyMatchPrice(this.opts[this.optCur].state, posState);
                        anyRepPrice = getAnyRepPrice(anyMatchPrice, this.opts[this.optCur].state);
                        calc1BytePrices(pos, posState, avail, anyRepPrice);
                        if (avail >= 2) {
                            int startLen = calcLongRepPrices(pos, posState, avail, anyRepPrice);
                            if (this.matches.count > 0) {
                                calcNormalMatchPrices(pos, posState, avail, anyMatchPrice, startLen);
                            }
                        }
                    } else {
                        break;
                    }
                }
                return convertOpts();
            } else if ($assertionsDisabled || this.optEnd == 0) {
                this.back = this.opts[1].backPrev;
                return 1;
            } else {
                throw new AssertionError(this.optEnd);
            }
        } else {
            throw new AssertionError();
        }
    }

    private void updateOptStateAndReps() {
        int optPrev = this.opts[this.optCur].optPrev;
        if ($assertionsDisabled || optPrev < this.optCur) {
            if (this.opts[this.optCur].prev1IsLiteral) {
                optPrev--;
                if (this.opts[this.optCur].hasPrev2) {
                    this.opts[this.optCur].state.set(this.opts[this.opts[this.optCur].optPrev2].state);
                    if (this.opts[this.optCur].backPrev2 < 4) {
                        this.opts[this.optCur].state.updateLongRep();
                    } else {
                        this.opts[this.optCur].state.updateMatch();
                    }
                } else {
                    this.opts[this.optCur].state.set(this.opts[optPrev].state);
                }
                this.opts[this.optCur].state.updateLiteral();
            } else {
                this.opts[this.optCur].state.set(this.opts[optPrev].state);
            }
            if (optPrev != this.optCur - 1) {
                int back;
                if (this.opts[this.optCur].prev1IsLiteral && this.opts[this.optCur].hasPrev2) {
                    optPrev = this.opts[this.optCur].optPrev2;
                    back = this.opts[this.optCur].backPrev2;
                    this.opts[this.optCur].state.updateLongRep();
                } else {
                    back = this.opts[this.optCur].backPrev;
                    if (back < 4) {
                        this.opts[this.optCur].state.updateLongRep();
                    } else {
                        this.opts[this.optCur].state.updateMatch();
                    }
                }
                if (back < 4) {
                    this.opts[this.optCur].reps[0] = this.opts[optPrev].reps[back];
                    int rep = 1;
                    while (rep <= back) {
                        this.opts[this.optCur].reps[rep] = this.opts[optPrev].reps[rep - 1];
                        rep++;
                    }
                    while (rep < 4) {
                        this.opts[this.optCur].reps[rep] = this.opts[optPrev].reps[rep];
                        rep++;
                    }
                    return;
                }
                this.opts[this.optCur].reps[0] = back - 4;
                System.arraycopy(this.opts[optPrev].reps, 0, this.opts[this.optCur].reps, 1, 3);
                return;
            } else if ($assertionsDisabled || this.opts[this.optCur].backPrev == 0 || this.opts[this.optCur].backPrev == -1) {
                if (this.opts[this.optCur].backPrev == 0) {
                    this.opts[this.optCur].state.updateShortRep();
                } else {
                    this.opts[this.optCur].state.updateLiteral();
                }
                System.arraycopy(this.opts[optPrev].reps, 0, this.opts[this.optCur].reps, 0, 4);
                return;
            } else {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }

    private void calc1BytePrices(int pos, int posState, int avail, int anyRepPrice) {
        boolean nextIsByte = $assertionsDisabled;
        int curByte = this.lz.getByte(0);
        int matchByte = this.lz.getByte(this.opts[this.optCur].reps[0] + 1);
        int literalPrice = this.opts[this.optCur].price + this.literalEncoder.getPrice(curByte, matchByte, this.lz.getByte(1), pos, this.opts[this.optCur].state);
        if (literalPrice < this.opts[this.optCur + 1].price) {
            this.opts[this.optCur + 1].set1(literalPrice, this.optCur, -1);
            nextIsByte = true;
        }
        if (matchByte == curByte && (this.opts[this.optCur + 1].optPrev == this.optCur || this.opts[this.optCur + 1].backPrev != 0)) {
            int shortRepPrice = getShortRepPrice(anyRepPrice, this.opts[this.optCur].state, posState);
            if (shortRepPrice <= this.opts[this.optCur + 1].price) {
                this.opts[this.optCur + 1].set1(shortRepPrice, this.optCur, 0);
                nextIsByte = true;
            }
        }
        if (!nextIsByte && matchByte != curByte && avail > 2) {
            int len = this.lz.getMatchLen(1, this.opts[this.optCur].reps[0], Math.min(this.niceLen, avail - 1));
            if (len >= 2) {
                this.nextState.set(this.opts[this.optCur].state);
                this.nextState.updateLiteral();
                int nextPosState = (pos + 1) & this.posMask;
                int price = literalPrice + getLongRepAndLenPrice(0, len, this.nextState, nextPosState);
                int i = (this.optCur + 1) + len;
                while (this.optEnd < i) {
                    Optimum[] optimumArr = this.opts;
                    int i2 = this.optEnd + 1;
                    this.optEnd = i2;
                    optimumArr[i2].reset();
                }
                if (price < this.opts[i].price) {
                    this.opts[i].set2(price, this.optCur, 0);
                }
            }
        }
    }

    private int calcLongRepPrices(int pos, int posState, int avail, int anyRepPrice) {
        int startLen = 2;
        int lenLimit = Math.min(avail, this.niceLen);
        for (int rep = 0; rep < 4; rep++) {
            int len = this.lz.getMatchLen(this.opts[this.optCur].reps[rep], lenLimit);
            if (len >= 2) {
                Optimum[] optimumArr;
                int i;
                int i2;
                int price;
                while (this.optEnd < this.optCur + len) {
                    optimumArr = this.opts;
                    i = this.optEnd + 1;
                    this.optEnd = i;
                    optimumArr[i].reset();
                }
                int longRepPrice = getLongRepPrice(anyRepPrice, rep, this.opts[this.optCur].state, posState);
                for (i2 = len; i2 >= 2; i2--) {
                    price = longRepPrice + this.repLenEncoder.getPrice(i2, posState);
                    if (price < this.opts[this.optCur + i2].price) {
                        this.opts[this.optCur + i2].set1(price, this.optCur, rep);
                    }
                }
                if (rep == 0) {
                    startLen = len + 1;
                }
                int len2 = this.lz.getMatchLen(len + 1, this.opts[this.optCur].reps[rep], Math.min(this.niceLen, (avail - len) - 1));
                if (len2 >= 2) {
                    int price2 = longRepPrice + this.repLenEncoder.getPrice(len, posState);
                    this.nextState.set(this.opts[this.optCur].state);
                    this.nextState.updateLongRep();
                    price = price2 + this.literalEncoder.getPrice(this.lz.getByte(len, 0), this.lz.getByte(0), this.lz.getByte(len, 1), pos + len, this.nextState);
                    this.nextState.updateLiteral();
                    int nextPosState = ((pos + len) + 1) & this.posMask;
                    price += getLongRepAndLenPrice(0, len2, this.nextState, nextPosState);
                    i2 = ((this.optCur + len) + 1) + len2;
                    while (this.optEnd < i2) {
                        optimumArr = this.opts;
                        i = this.optEnd + 1;
                        this.optEnd = i;
                        optimumArr[i].reset();
                    }
                    if (price < this.opts[i2].price) {
                        this.opts[i2].set3(price, this.optCur, rep, len, 0);
                    }
                }
            }
        }
        return startLen;
    }

    private void calcNormalMatchPrices(int pos, int posState, int avail, int anyMatchPrice, int startLen) {
        if (this.matches.len[this.matches.count - 1] > avail) {
            this.matches.count = 0;
            while (this.matches.len[this.matches.count] < avail) {
                Matches matches = this.matches;
                matches.count++;
            }
            int[] iArr = this.matches.len;
            Matches matches2 = this.matches;
            int i = matches2.count;
            matches2.count = i + 1;
            iArr[i] = avail;
        }
        if (this.matches.len[this.matches.count - 1] >= startLen) {
            Optimum[] optimumArr;
            int i2;
            while (this.optEnd < this.optCur + this.matches.len[this.matches.count - 1]) {
                optimumArr = this.opts;
                i2 = this.optEnd + 1;
                this.optEnd = i2;
                optimumArr[i2].reset();
            }
            int normalMatchPrice = getNormalMatchPrice(anyMatchPrice, this.opts[this.optCur].state);
            int match = 0;
            while (startLen > this.matches.len[match]) {
                match++;
            }
            int len = startLen;
            while (true) {
                int dist = this.matches.dist[match];
                int matchAndLenPrice = getMatchAndLenPrice(normalMatchPrice, dist, len, posState);
                if (matchAndLenPrice < this.opts[this.optCur + len].price) {
                    this.opts[this.optCur + len].set1(matchAndLenPrice, this.optCur, dist + 4);
                }
                if (len == this.matches.len[match]) {
                    int len2 = this.lz.getMatchLen(len + 1, dist, Math.min(this.niceLen, (avail - len) - 1));
                    if (len2 >= 2) {
                        this.nextState.set(this.opts[this.optCur].state);
                        this.nextState.updateMatch();
                        int price = matchAndLenPrice + this.literalEncoder.getPrice(this.lz.getByte(len, 0), this.lz.getByte(0), this.lz.getByte(len, 1), pos + len, this.nextState);
                        this.nextState.updateLiteral();
                        int nextPosState = ((pos + len) + 1) & this.posMask;
                        price += getLongRepAndLenPrice(0, len2, this.nextState, nextPosState);
                        int i3 = ((this.optCur + len) + 1) + len2;
                        while (this.optEnd < i3) {
                            optimumArr = this.opts;
                            i2 = this.optEnd + 1;
                            this.optEnd = i2;
                            optimumArr[i2].reset();
                        }
                        if (price < this.opts[i3].price) {
                            this.opts[i3].set3(price, this.optCur, dist + 4, len, 0);
                        }
                    }
                    match++;
                    if (match == this.matches.count) {
                        return;
                    }
                }
                len++;
            }
        }
    }
}
