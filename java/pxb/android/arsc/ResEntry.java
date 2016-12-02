/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package pxb.android.arsc;

import pxb.android.arsc.ResSpec;

public class ResEntry {
    public final int flag;
    public final ResSpec spec;
    public Object value;
    int wOffset;

    public ResEntry(int n, ResSpec resSpec) {
        this.flag = n;
        this.spec = resSpec;
    }
}

