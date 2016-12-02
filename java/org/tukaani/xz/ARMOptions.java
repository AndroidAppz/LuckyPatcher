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
import org.tukaani.xz.simple.ARM;
import org.tukaani.xz.simple.SimpleFilter;

public class ARMOptions
extends BCJOptions {
    private static final int ALIGNMENT = 4;

    public ARMOptions() {
        super(4);
    }

    @Override
    FilterEncoder getFilterEncoder() {
        return new BCJEncoder(this, 7);
    }

    @Override
    public InputStream getInputStream(InputStream inputStream) {
        return new SimpleInputStream(inputStream, new ARM(false, this.startOffset));
    }

    @Override
    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream) {
        return new SimpleOutputStream(finishableOutputStream, new ARM(true, this.startOffset));
    }
}

