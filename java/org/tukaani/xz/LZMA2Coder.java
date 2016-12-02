package org.tukaani.xz;

abstract class LZMA2Coder implements FilterCoder {
    public static final long FILTER_ID = 33;

    LZMA2Coder() {
    }

    public boolean changesSize() {
        return true;
    }

    public boolean nonLastOK() {
        return false;
    }

    public boolean lastOK() {
        return true;
    }
}
