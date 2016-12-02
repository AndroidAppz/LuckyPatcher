package org.tukaani.xz;

public class CorruptedInputException extends XZIOException {
    private static final long serialVersionUID = 3;

    public CorruptedInputException() {
        super("Compressed data is corrupt");
    }

    public CorruptedInputException(String s) {
        super(s);
    }
}
