/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package org.tukaani.xz;

import org.tukaani.xz.FilterEncoder;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.LZMA2Coder;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.lzma.LZMAEncoder;

class LZMA2Encoder
extends LZMA2Coder
implements FilterEncoder {
    private final LZMA2Options options;
    private final byte[] props = new byte[1];

    /*
     * Enabled aggressive block sorting
     */
    LZMA2Encoder(LZMA2Options lZMA2Options) {
        if (lZMA2Options.getPresetDict() != null) {
            throw new IllegalArgumentException("XZ doesn't support a preset dictionary for now");
        }
        if (lZMA2Options.getMode() == 0) {
            this.props[0] = 0;
        } else {
            int n = Math.max((int)lZMA2Options.getDictSize(), (int)4096);
            this.props[0] = (byte)(-23 + LZMAEncoder.getDistSlot(n - 1));
        }
        this.options = (LZMA2Options)lZMA2Options.clone();
    }

    @Override
    public long getFilterID() {
        return 33;
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

