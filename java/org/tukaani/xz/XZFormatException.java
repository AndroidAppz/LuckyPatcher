/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.tukaani.xz;

import org.tukaani.xz.XZIOException;

public class XZFormatException
extends XZIOException {
    private static final long serialVersionUID = 3;

    public XZFormatException() {
        super("Input is not in the XZ format");
    }
}

