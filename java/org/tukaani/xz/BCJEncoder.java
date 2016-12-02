/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Object
 */
package org.tukaani.xz;

import org.tukaani.xz.BCJCoder;
import org.tukaani.xz.BCJOptions;
import org.tukaani.xz.FilterEncoder;
import org.tukaani.xz.FinishableOutputStream;

class BCJEncoder
extends BCJCoder
implements FilterEncoder {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final long filterID;
    private final BCJOptions options;
    private final byte[] props;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !BCJEncoder.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    BCJEncoder(BCJOptions bCJOptions, long l) {
        if (!$assertionsDisabled && !BCJEncoder.isBCJFilterID(l)) {
            throw new AssertionError();
        }
        int n = bCJOptions.getStartOffset();
        if (n == 0) {
            this.props = new byte[0];
        } else {
            this.props = new byte[4];
            for (int i = 0; i < 4; ++i) {
                this.props[i] = (byte)(n >>> i * 8);
            }
        }
        this.filterID = l;
        this.options = (BCJOptions)bCJOptions.clone();
    }

    @Override
    public long getFilterID() {
        return this.filterID;
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
        return false;
    }
}

