package org.tukaani.xz;

public class UnsupportedOptionsException extends XZIOException {
    private static final long serialVersionUID = 3;

    public UnsupportedOptionsException(String s) {
        super(s);
    }
}
