package org.tukaani.xz;

interface FilterCoder {
    boolean changesSize();

    boolean lastOK();

    boolean nonLastOK();
}
