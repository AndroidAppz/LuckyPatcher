/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.tukaani.xz;

import org.tukaani.xz.FilterCoder;
import org.tukaani.xz.FinishableOutputStream;

interface FilterEncoder
extends FilterCoder {
    public long getFilterID();

    public byte[] getFilterProps();

    public FinishableOutputStream getOutputStream(FinishableOutputStream var1);

    public boolean supportsFlushing();
}

