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
import org.tukaani.xz.simple.SimpleFilter;
import org.tukaani.xz.simple.X86;

public class X86Options
extends BCJOptions {
    private static final int ALIGNMENT = 1;

    public X86Options() {
        super(1);
    }

    @Override
    FilterEncoder getFilterEncoder() {
        return new BCJEncoder(this, 4);
    }

    @Override
    public InputStream getInputStream(InputStream inputStream) {
        return new SimpleInputStream(inputStream, new X86(false, this.startOffset));
    }

    @Override
    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream) {
        return new SimpleOutputStream(finishableOutputStream, new X86(true, this.startOffset));
    }
}

