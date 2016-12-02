/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz;

interface FilterCoder {
    public boolean changesSize();

    public boolean lastOK();

    public boolean nonLastOK();
}

