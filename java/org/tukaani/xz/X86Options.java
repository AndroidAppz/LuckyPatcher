package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.X86;

public class X86Options extends BCJOptions {
    private static final int ALIGNMENT = 1;

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

    public X86Options() {
        super(ALIGNMENT);
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream out) {
        return new SimpleOutputStream(out, new X86(true, this.startOffset));
    }

    public InputStream getInputStream(InputStream in) {
        return new SimpleInputStream(in, new X86(false, this.startOffset));
    }

    FilterEncoder getFilterEncoder() {
        return new BCJEncoder(this, 4);
    }
}
