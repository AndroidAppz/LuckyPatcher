/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz;

import org.tukaani.xz.DeltaCoder;
import org.tukaani.xz.DeltaOptions;
import org.tukaani.xz.FilterEncoder;
import org.tukaani.xz.FinishableOutputStream;

class DeltaEncoder
extends DeltaCoder
implements FilterEncoder {
    private final DeltaOptions options;
    private final byte[] props = new byte[1];

    DeltaEncoder(DeltaOptions deltaOptions) {
        this.props[0] = (byte)(-1 + deltaOptions.getDistance());
        this.options = (DeltaOptions)deltaOptions.clone();
    }

    @Override
    public long getFilterID() {
        return 3;
    }

    @Override
    public byte[] getFilterProps() {
        return this.props;
    }

    @Override
    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream) {
        return this.options.getOutputStream(finishableOutputStream);
    }

    @Override
    public boolean supportsFlushing() {
        return true;
    }
}

