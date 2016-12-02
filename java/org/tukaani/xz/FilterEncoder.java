package org.tukaani.xz;

interface FilterEncoder extends FilterCoder {
    long getFilterID();

    byte[] getFilterProps();

    FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream);

    boolean supportsFlushing();
}
