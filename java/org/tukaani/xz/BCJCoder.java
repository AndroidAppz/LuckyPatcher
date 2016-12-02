/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz;

import org.tukaani.xz.FilterCoder;

abstract class BCJCoder
implements FilterCoder {
    public static final long ARMTHUMB_FILTER_ID = 8;
    public static final long ARM_FILTER_ID = 7;
    public static final long IA64_FILTER_ID = 6;
    public static final long POWERPC_FILTER_ID = 5;
    public static final long SPARC_FILTER_ID = 9;
    public static final long X86_FILTER_ID = 4;

    BCJCoder() {
    }

    public static boolean isBCJFilterID(long l) {
        if (l >= 4 && l <= 9) {
            return true;
        }
        return false;
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

