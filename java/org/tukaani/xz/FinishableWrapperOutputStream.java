package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;

public class FinishableWrapperOutputStream extends FinishableOutputStream {
    protected OutputStream out;

    public FinishableWrapperOutputStream(OutputStream out) {
        this.out = out;
    }

    public void write(int b) throws IOException {
        this.out.write(b);
    }

    public void write(byte[] buf) throws IOException {
        this.out.write(buf);
    }

    public void write(byte[] buf, int off, int len) throws IOException {
        this.out.write(buf, off, len);
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void close() throws IOException {
        this.out.close();
    }
}
