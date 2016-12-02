/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 */
package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.BCJEncoder;
import org.tukaani.xz.BCJOptions;
import org.tukaani.xz.FilterEncoder;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.SimpleInputStream;
import org.tukaani.xz.SimpleOutputStream;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.simple.ARMThumb;
import org.tukaani.xz.simple.SimpleFilter;

public class ARMThumbOptions
extends BCJOptions {
    private static final int ALIGNMENT = 2;

    public ARMThumbOptions() {
        super(2);
    }

    @Override
    FilterEncoder getFilterEncoder() {
        return new BCJEncoder(this, 8);
    }

    @Override
    public InputStream getInputStream(InputStream inputStream) {
        return new SimpleInputStream(inputStream, new ARMThumb(false, this.startOffset));
    }

    @Override
    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream) {
        return new SimpleOutputStream(finishableOutputStream, new ARMThumb(true, this.startOffset));
    }
}

