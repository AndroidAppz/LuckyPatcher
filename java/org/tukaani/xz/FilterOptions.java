/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Cloneable
 *  java.lang.Object
 */
package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.FilterEncoder;
import org.tukaani.xz.FinishableOutputStream;

public abstract class FilterOptions
implements Cloneable {
    FilterOptions() {
    }

    public static int getDecoderMemoryUsage(FilterOptions[] arrfilterOptions) {
        int n = 0;
        for (int i = 0; i < arrfilterOptions.length; ++i) {
            n += arrfilterOptions[i].getDecoderMemoryUsage();
        }
        return n;
    }

    public static int getEncoderMemoryUsage(FilterOptions[] arrfilterOptions) {
        int n = 0;
        for (int i = 0; i < arrfilterOptions.length; ++i) {
            n += arrfilterOptions[i].getEncoderMemoryUsage();
        }
        return n;
    }

    public abstract int getDecoderMemoryUsage();

    public abstract int getEncoderMemoryUsage();

    abstract FilterEncoder getFilterEncoder();

    public abstract InputStream getInputStream(InputStream var1) throws IOException;

    public abstract FinishableOutputStream getOutputStream(FinishableOutputStream var1);
}

