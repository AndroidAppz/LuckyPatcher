/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz;

import org.tukaani.xz.FilterCoder;

abstract class DeltaCoder
implements FilterCoder {
    public static final long FILTER_ID = 3;

    DeltaCoder() {
    }

    @Override
    public boolean changesSize() {
        return false;
    }

    @Override
    public boolean lastOK() {
        return false;
    }

    @Override
    public boolean nonLastOK() {
        return true;
    }
}

