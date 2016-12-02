/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.tukaani.xz.check;

import org.tukaani.xz.check.Check;

public class None
extends Check {
    public None() {
        this.size = 0;
        this.name = "None";
    }

    @Override
    public byte[] finish() {
        return new byte[0];
    }

    @Override
    public void update(byte[] arrby, int n, int n2) {
    }
}

