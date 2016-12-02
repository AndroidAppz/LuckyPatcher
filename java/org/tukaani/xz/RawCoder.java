/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package org.tukaani.xz;

import org.tukaani.xz.FilterCoder;
import org.tukaani.xz.UnsupportedOptionsException;

class RawCoder {
    RawCoder() {
    }

    static void validate(FilterCoder[] arrfilterCoder) throws UnsupportedOptionsException {
        for (int i = 0; i < -1 + arrfilterCoder.length; ++i) {
            if (arrfilterCoder[i].nonLastOK()) continue;
            throw new UnsupportedOptionsException("Unsupported XZ filter chain");
        }
        if (!arrfilterCoder[-1 + arrfilterCoder.length].lastOK()) {
            throw new UnsupportedOptionsException("Unsupported XZ filter chain");
        }
        int n = 0;
        for (int j = 0; j < arrfilterCoder.length; ++j) {
            if (!arrfilterCoder[j].changesSize()) continue;
            ++n;
        }
        if (n > 3) {
            throw new UnsupportedOptionsException("Unsupported XZ filter chain");
        }
    }
}

