/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 */
package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.FilterCoder;

interface FilterDecoder
extends FilterCoder {
    public InputStream getInputStream(InputStream var1);

    public int getMemoryUsage();
}

