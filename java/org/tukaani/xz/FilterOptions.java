package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;

public abstract class FilterOptions implements Cloneable {
    public abstract int getDecoderMemoryUsage();

    public abstract int getEncoderMemoryUsage();

    abstract FilterEncoder getFilterEncoder();

    public abstract InputStream getInputStream(InputStream inputStream) throws IOException;

    public abstract FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream);

    public static int getEncoderMemoryUsage(FilterOptions[] options) {
        int m = 0;
        for (FilterOptions encoderMemoryUsage : options) {
            m += encoderMemoryUsage.getEncoderMemoryUsage();
        }
        return m;
    }

    public static int getDecoderMemoryUsage(FilterOptions[] options) {
        int m = 0;
        for (FilterOptions decoderMemoryUsage : options) {
            m += decoderMemoryUsage.getDecoderMemoryUsage();
        }
        return m;
    }

    FilterOptions() {
    }
}
