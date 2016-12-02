package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.SPARC;

public class SPARCOptions extends BCJOptions {
    private static final int ALIGNMENT = 4;

    public /* bridge */ /* synthetic */ Object clone() {
        return super.clone();
    }

    public /* bridge */ /* synthetic */ int getDecoderMemoryUsage() {
        return super.getDecoderMemoryUsage();
    }

    public /* bridge */ /* synthetic */ int getEncoderMemoryUsage() {
        return super.getEncoderMemoryUsage();
    }

    public /* bridge */ /* synthetic */ int getStartOffset() {
        return super.getStartOffset();
    }

    public /* bridge */ /* synthetic */ void setStartOffset(int i) throws UnsupportedOptionsException {
        super.setStartOffset(i);
    }

    public SPARCOptions() {
        super(ALIGNMENT);
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream out) {
        return new SimpleOutputStream(out, new SPARC(true, this.startOffset));
    }

    public InputStream getInputStream(InputStream in) {
        return new SimpleInputStream(in, new SPARC(false, this.startOffset));
    }

    FilterEncoder getFilterEncoder() {
        return new BCJEncoder(this, 9);
    }
}
