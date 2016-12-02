package org.tukaani.xz;

abstract class DeltaCoder implements FilterCoder {
    public static final long FILTER_ID = 3;

    DeltaCoder() {
    }

    public boolean changesSize() {
        return false;
    }

    public boolean nonLastOK() {
        return true;
    }

    public boolean lastOK() {
        return false;
    }
}
