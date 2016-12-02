/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.tukaani.xz;

import org.tukaani.xz.XZIOException;

public class UnsupportedOptionsException
extends XZIOException {
    private static final long serialVersionUID = 3;

    public UnsupportedOptionsException() {
    }

    public UnsupportedOptionsException(String string) {
        super(string);
    }
}

