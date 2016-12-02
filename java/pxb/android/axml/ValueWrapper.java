/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package pxb.android.axml;

public class ValueWrapper {
    public static final int CLASS = 3;
    public static final int ID = 1;
    public static final int STYLE = 2;
    public final String raw;
    public final int ref;
    public final int type;

    private ValueWrapper(int n, int n2, String string) {
        this.type = n;
        this.raw = string;
        this.ref = n2;
    }

    public static ValueWrapper wrapClass(int n, String string) {
        return new ValueWrapper(3, n, string);
    }

    public static ValueWrapper wrapId(int n, String string) {
        return new ValueWrapper(1, n, string);
    }

    public static ValueWrapper wrapStyle(int n, String string) {
        return new ValueWrapper(2, n, string);
    }

    public ValueWrapper replaceRaw(String string) {
        return new ValueWrapper(this.type, this.ref, string);
    }
}

