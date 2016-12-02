/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.DeltaCoder;
import org.tukaani.xz.DeltaInputStream;
import org.tukaani.xz.FilterDecoder;
import org.tukaani.xz.UnsupportedOptionsException;

class DeltaDecoder
extends DeltaCoder
implements FilterDecoder {
    private final int distance;

    DeltaDecoder(byte[] arrby) throws UnsupportedOptionsException {
        if (arrby.length != 1) {
            throw new UnsupportedOptionsException("Unsupported Delta filter properties");
        }
        this.distance = 1 + (255 & arrby[0]);
    }

    @Override
    public InputStream getInputStream(InputStream inputStream) {
        return new DeltaInputStream(inputStream, this.distance);
    }

    @Override
    public int getMemoryUsage() {
        return 1;
    }
}

