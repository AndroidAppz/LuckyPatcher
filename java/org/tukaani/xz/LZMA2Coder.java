/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz;

import org.tukaani.xz.FilterCoder;

abstract class LZMA2Coder
implements FilterCoder {
    public static final long FILTER_ID = 33;

    LZMA2Coder() {
    }

    @Override
    public boolean changesSize() {
        return true;
    }

    @Override
    public boolean lastOK() {
        return true;
    }

    @Override
    public boolean nonLastOK() {
        return false;
    }
}

