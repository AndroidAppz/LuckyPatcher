/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.FilterEncoder;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.LZMA2Encoder;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.LZMA2OutputStream;
import org.tukaani.xz.UncompressedLZMA2OutputStream;
import org.tukaani.xz.UnsupportedOptionsException;

public class LZMA2Options
extends FilterOptions {
    static final /* synthetic */ boolean $assertionsDisabled = false;
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
    public static final int PRESET_MIN;
    private static final int[] presetToDepthLimit;
    private static final int[] presetToDictSize;
    private int depthLimit;
    private int dictSize;
    private int lc;
    private int lp;
    private int mf;
    private int mode;
    private int niceLen;
    private int pb;
    private byte[] presetDict;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !LZMA2Options.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
        presetToDictSize = new int[]{262144, 1048576, 2097152, 4194304, 4194304, 8388608, 8388608, 16777216, 33554432, 67108864};
        presetToDepthLimit = new int[]{4, 8, 24, 48};
    }

    public LZMA2Options() {
        this.presetDict = null;
        try {
            this.setPreset(6);
            return;
        }
        catch (UnsupportedOptionsException var1_1) {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
            throw new RuntimeException();
        }
    }

    public LZMA2Options(int n) throws UnsupportedOptionsException {
        this.presetDict = null;
        this.setPreset(n);
    }

    public LZMA2Options(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) throws UnsupportedOptionsException {
        this.presetDict = null;
        this.setDictSize(n);
        this.setLcLp(n2, n3);
        this.setPb(n4);
        this.setMode(n5);
        this.setNiceLen(n6);
        this.setMatchFinder(n7);
        this.setDepthLimit(n8);
    }

    public Object clone() {
        try {
            Object object = super.clone();
            return object;
        }
        catch (CloneNotSupportedException var1_2) {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
            throw new RuntimeException();
        }
    }

    @Override
    public int getDecoderMemoryUsage() {
        int n = -1 + this.dictSize;
        int n2 = n | n >>> 2;
        int n3 = n2 | n2 >>> 3;
        int n4 = n3 | n3 >>> 4;
        int n5 = n4 | n4 >>> 8;
        return LZMA2InputStream.getMemoryUsage(1 + (n5 | n5 >>> 16));
    }

    public int getDepthLimit() {
        return this.depthLimit;
    }

    public int getDictSize() {
        return this.dictSize;
    }

    @Override
    public int getEncoderMemoryUsage() {
        if (this.mode == 0) {
            return UncompressedLZMA2OutputStream.getMemoryUsage();
        }
        return LZMA2OutputStream.getMemoryUsage(this);
    }

    @Override
    FilterEncoder getFilterEncoder() {
        return new LZMA2Encoder(this);
    }

    @Override
    public InputStream getInputStream(InputStream inputStream) throws IOException {
        return new LZMA2InputStream(inputStream, this.dictSize);
    }

    public int getLc() {
        return this.lc;
    }

    public int getLp() {
        return this.lp;
    }

    public int getMatchFinder() {
        return this.mf;
    }

    public int getMode() {
        return this.mode;
    }

    public int getNiceLen() {
        return this.niceLen;
    }

    @Override
    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream) {
        if (this.mode == 0) {
            return new UncompressedLZMA2OutputStream(finishableOutputStream);
        }
        return new LZMA2OutputStream(finishableOutputStream, (LZMA2Options)this);
    }

    public int getPb() {
        return this.pb;
    }

    public byte[] getPresetDict() {
        return this.presetDict;
    }

    public void setDepthLimit(int n) throws UnsupportedOptionsException {
        if (n < 0) {
            throw new UnsupportedOptionsException("Depth limit cannot be negative: " + n);
        }
        this.depthLimit = n;
    }

    public void setDictSize(int n) throws UnsupportedOptionsException {
        if (n < 4096) {
            throw new UnsupportedOptionsException("LZMA2 dictionary size must be at least 4 KiB: " + n + " B");
        }
        if (n > 805306368) {
            throw new UnsupportedOptionsException("LZMA2 dictionary size must not exceed 768 MiB: " + n + " B");
        }
        this.dictSize = n;
    }

    public void setLc(int n) throws UnsupportedOptionsException {
        this.setLcLp(n, this.lp);
    }

    public void setLcLp(int n, int n2) throws UnsupportedOptionsException {
        if (n < 0 || n2 < 0 || n > 4 || n2 > 4 || n + n2 > 4) {
            throw new UnsupportedOptionsException("lc + lp must not exceed 4: " + n + " + " + n2);
        }
        this.lc = n;
        this.lp = n2;
    }

    public void setLp(int n) throws UnsupportedOptionsException {
        this.setLcLp(this.lc, n);
    }

    public void setMatchFinder(int n) throws UnsupportedOptionsException {
        if (n != 4 && n != 20) {
            throw new UnsupportedOptionsException("Unsupported match finder: " + n);
        }
        this.mf = n;
    }

    public void setMode(int n) throws UnsupportedOptionsException {
        if (n < 0 || n > 2) {
            throw new UnsupportedOptionsException("Unsupported compression mode: " + n);
        }
        this.mode = n;
    }

    public void setNiceLen(int n) throws UnsupportedOptionsException {
        if (n < 8) {
            throw new UnsupportedOptionsException("Minimum nice length of matches is 8 bytes: " + n);
        }
        if (n > 273) {
            throw new UnsupportedOptionsException("Maximum nice length of matches is 273: " + n);
        }
        this.niceLen = n;
    }

    public void setPb(int n) throws UnsupportedOptionsException {
        if (n < 0 || n > 4) {
            throw new UnsupportedOptionsException("pb must not exceed 4: " + n);
        }
        this.pb = n;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setPreset(int n) throws UnsupportedOptionsException {
        if (n < 0 || n > 9) {
            throw new UnsupportedOptionsException("Unsupported preset: " + n);
        }
        this.lc = 3;
        this.lp = 0;
        this.pb = 2;
        this.dictSize = presetToDictSize[n];
        if (n <= 3) {
            this.mode = 1;
            this.mf = 4;
            int n2 = n <= 1 ? 128 : 273;
            this.niceLen = n2;
            this.depthLimit = presetToDepthLimit[n];
            return;
        }
        this.mode = 2;
        this.mf = 20;
        int n3 = n == 4 ? 16 : (n == 5 ? 32 : 64);
        this.niceLen = n3;
        this.depthLimit = 0;
    }

    public void setPresetDict(byte[] arrby) {
        this.presetDict = arrby;
    }
}

