/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.DeltaEncoder;
import org.tukaani.xz.DeltaInputStream;
import org.tukaani.xz.DeltaOutputStream;
import org.tukaani.xz.FilterEncoder;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.UnsupportedOptionsException;

public class DeltaOptions
extends FilterOptions {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DISTANCE_MAX = 256;
    public static final int DISTANCE_MIN = 1;
    private int distance;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !DeltaOptions.class.desiredAssertionStatus();
        $assertionsDisabled = bl;
    }

    public DeltaOptions() {
        this.distance = 1;
    }

    public DeltaOptions(int n) throws UnsupportedOptionsException {
        this.distance = 1;
        this.setDistance(n);
    }

    public Object clone() {
        try {
            Object object = super.clone();
            return object;
        }
        catch (CloneNotSupportedException var1_2) {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
            throw new RuntimeException();
        }
    }

    @Override
    public int getDecoderMemoryUsage() {
        return 1;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int getEncoderMemoryUsage() {
        return DeltaOutputStream.getMemoryUsage();
    }

    @Override
    FilterEncoder getFilterEncoder() {
        return new DeltaEncoder(this);
    }

    @Override
    public InputStream getInputStream(InputStream inputStream) {
        return new DeltaInputStream(inputStream, this.distance);
    }

    @Override
    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream) {
        return new DeltaOutputStream(finishableOutputStream, (DeltaOptions)this);
    }

    public void setDistance(int n) throws UnsupportedOptionsException {
        if (n < 1 || n > 256) {
            throw new UnsupportedOptionsException("Delta distance must be in the range [1, 256]: " + n);
        }
        this.distance = n;
    }
}

