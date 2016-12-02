package org.tukaani.xz;

import java.io.InputStream;

public class DeltaOptions extends FilterOptions {
    static final /* synthetic */ boolean $assertionsDisabled = (!DeltaOptions.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    public static final int DISTANCE_MAX = 256;
    public static final int DISTANCE_MIN = 1;
    private int distance = DISTANCE_MIN;

    public DeltaOptions(int distance) throws UnsupportedOptionsException {
        setDistance(distance);
    }

    public void setDistance(int distance) throws UnsupportedOptionsException {
        if (distance < DISTANCE_MIN || distance > DISTANCE_MAX) {
            throw new UnsupportedOptionsException("Delta distance must be in the range [1, 256]: " + distance);
        }
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getEncoderMemoryUsage() {
        return DeltaOutputStream.getMemoryUsage();
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream out) {
        return new DeltaOutputStream(out, this);
    }

    public int getDecoderMemoryUsage() {
        return DISTANCE_MIN;
    }

    public InputStream getInputStream(InputStream in) {
        return new DeltaInputStream(in, this.distance);
    }

    FilterEncoder getFilterEncoder() {
        return new DeltaEncoder(this);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if ($assertionsDisabled) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }
}
