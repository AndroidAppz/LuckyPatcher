/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package org.tukaani.xz;

import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.SimpleInputStream;
import org.tukaani.xz.SimpleOutputStream;
import org.tukaani.xz.UnsupportedOptionsException;

abstract class BCJOptions
extends FilterOptions {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final int alignment;
    int startOffset = 0;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !BCJOptions.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    BCJOptions(int n) {
        this.alignment = n;
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
        return SimpleInputStream.getMemoryUsage();
    }

    @Override
    public int getEncoderMemoryUsage() {
        return SimpleOutputStream.getMemoryUsage();
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    public void setStartOffset(int n) throws UnsupportedOptionsException {
        if ((n & -1 + this.alignment) != 0) {
            throw new UnsupportedOptionsException("Start offset must be a multiple of " + this.alignment);
        }
        this.startOffset = n;
    }
}

