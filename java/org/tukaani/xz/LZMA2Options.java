package org.tukaani.xz;

import com.chelpus.Common;
import java.io.IOException;
import java.io.InputStream;

public class LZMA2Options extends FilterOptions {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final int DICT_SIZE_DEFAULT = 8388608;
    public static final int DICT_SIZE_MAX = 805306368;
    public static final int DICT_SIZE_MIN = 4096;
    public static final int LC_DEFAULT = 3;
    public static final int LC_LP_MAX = 4;
    public static final int LP_DEFAULT = 0;
    public static final int MF_BT4 = 20;
    public static final int MF_HC4 = 4;
    public static final int MODE_FAST = 1;
    public static final int MODE_NORMAL = 2;
    public static final int MODE_UNCOMPRESSED = 0;
    public static final int NICE_LEN_MAX = 273;
    public static final int NICE_LEN_MIN = 8;
    public static final int PB_DEFAULT = 2;
    public static final int PB_MAX = 4;
    public static final int PRESET_DEFAULT = 6;
    public static final int PRESET_MAX = 9;
    public static final int PRESET_MIN = 0;
    private static final int[] presetToDepthLimit = new int[]{PB_MAX, NICE_LEN_MIN, 24, 48};
    private static final int[] presetToDictSize = new int[]{262144, 1048576, 2097152, 4194304, 4194304, DICT_SIZE_DEFAULT, DICT_SIZE_DEFAULT, 16777216, 33554432, 67108864};
    private int depthLimit;
    private int dictSize;
    private int lc;
    private int lp;
    private int mf;
    private int mode;
    private int niceLen;
    private int pb;
    private byte[] presetDict = null;

    static {
        boolean z;
        if (LZMA2Options.class.desiredAssertionStatus()) {
            z = $assertionsDisabled;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
    }

    public LZMA2Options() {
        try {
            setPreset(PRESET_DEFAULT);
        } catch (UnsupportedOptionsException e) {
            if ($assertionsDisabled) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }

    public LZMA2Options(int preset) throws UnsupportedOptionsException {
        setPreset(preset);
    }

    public LZMA2Options(int dictSize, int lc, int lp, int pb, int mode, int niceLen, int mf, int depthLimit) throws UnsupportedOptionsException {
        setDictSize(dictSize);
        setLcLp(lc, lp);
        setPb(pb);
        setMode(mode);
        setNiceLen(niceLen);
        setMatchFinder(mf);
        setDepthLimit(depthLimit);
    }

    public void setPreset(int preset) throws UnsupportedOptionsException {
        if (preset < 0 || preset > PRESET_MAX) {
            throw new UnsupportedOptionsException("Unsupported preset: " + preset);
        }
        this.lc = LC_DEFAULT;
        this.lp = MODE_UNCOMPRESSED;
        this.pb = PB_DEFAULT;
        this.dictSize = presetToDictSize[preset];
        if (preset <= LC_DEFAULT) {
            this.mode = MODE_FAST;
            this.mf = PB_MAX;
            this.niceLen = preset <= MODE_FAST ? Common.INSTALL_ALLOW_DOWNGRADE : NICE_LEN_MAX;
            this.depthLimit = presetToDepthLimit[preset];
            return;
        }
        this.mode = PB_DEFAULT;
        this.mf = MF_BT4;
        int i = preset == PB_MAX ? 16 : preset == 5 ? 32 : 64;
        this.niceLen = i;
        this.depthLimit = MODE_UNCOMPRESSED;
    }

    public void setDictSize(int dictSize) throws UnsupportedOptionsException {
        if (dictSize < DICT_SIZE_MIN) {
            throw new UnsupportedOptionsException("LZMA2 dictionary size must be at least 4 KiB: " + dictSize + " B");
        } else if (dictSize > DICT_SIZE_MAX) {
            throw new UnsupportedOptionsException("LZMA2 dictionary size must not exceed 768 MiB: " + dictSize + " B");
        } else {
            this.dictSize = dictSize;
        }
    }

    public int getDictSize() {
        return this.dictSize;
    }

    public void setPresetDict(byte[] presetDict) {
        this.presetDict = presetDict;
    }

    public byte[] getPresetDict() {
        return this.presetDict;
    }

    public void setLcLp(int lc, int lp) throws UnsupportedOptionsException {
        if (lc < 0 || lp < 0 || lc > PB_MAX || lp > PB_MAX || lc + lp > PB_MAX) {
            throw new UnsupportedOptionsException("lc + lp must not exceed 4: " + lc + " + " + lp);
        }
        this.lc = lc;
        this.lp = lp;
    }

    public void setLc(int lc) throws UnsupportedOptionsException {
        setLcLp(lc, this.lp);
    }

    public void setLp(int lp) throws UnsupportedOptionsException {
        setLcLp(this.lc, lp);
    }

    public int getLc() {
        return this.lc;
    }

    public int getLp() {
        return this.lp;
    }

    public void setPb(int pb) throws UnsupportedOptionsException {
        if (pb < 0 || pb > PB_MAX) {
            throw new UnsupportedOptionsException("pb must not exceed 4: " + pb);
        }
        this.pb = pb;
    }

    public int getPb() {
        return this.pb;
    }

    public void setMode(int mode) throws UnsupportedOptionsException {
        if (mode < 0 || mode > PB_DEFAULT) {
            throw new UnsupportedOptionsException("Unsupported compression mode: " + mode);
        }
        this.mode = mode;
    }

    public int getMode() {
        return this.mode;
    }

    public void setNiceLen(int niceLen) throws UnsupportedOptionsException {
        if (niceLen < NICE_LEN_MIN) {
            throw new UnsupportedOptionsException("Minimum nice length of matches is 8 bytes: " + niceLen);
        } else if (niceLen > NICE_LEN_MAX) {
            throw new UnsupportedOptionsException("Maximum nice length of matches is 273: " + niceLen);
        } else {
            this.niceLen = niceLen;
        }
    }

    public int getNiceLen() {
        return this.niceLen;
    }

    public void setMatchFinder(int mf) throws UnsupportedOptionsException {
        if (mf == PB_MAX || mf == MF_BT4) {
            this.mf = mf;
            return;
        }
        throw new UnsupportedOptionsException("Unsupported match finder: " + mf);
    }

    public int getMatchFinder() {
        return this.mf;
    }

    public void setDepthLimit(int depthLimit) throws UnsupportedOptionsException {
        if (depthLimit < 0) {
            throw new UnsupportedOptionsException("Depth limit cannot be negative: " + depthLimit);
        }
        this.depthLimit = depthLimit;
    }

    public int getDepthLimit() {
        return this.depthLimit;
    }

    public int getEncoderMemoryUsage() {
        if (this.mode == 0) {
            return UncompressedLZMA2OutputStream.getMemoryUsage();
        }
        return LZMA2OutputStream.getMemoryUsage(this);
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream out) {
        if (this.mode == 0) {
            return new UncompressedLZMA2OutputStream(out);
        }
        return new LZMA2OutputStream(out, this);
    }

    public int getDecoderMemoryUsage() {
        int d = this.dictSize - 1;
        d |= d >>> PB_DEFAULT;
        d |= d >>> LC_DEFAULT;
        d |= d >>> PB_MAX;
        d |= d >>> NICE_LEN_MIN;
        return LZMA2InputStream.getMemoryUsage((d | (d >>> 16)) + MODE_FAST);
    }

    public InputStream getInputStream(InputStream in) throws IOException {
        return new LZMA2InputStream(in, this.dictSize);
    }

    FilterEncoder getFilterEncoder() {
        return new LZMA2Encoder(this);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if ($assertionsDisabled) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }
}
