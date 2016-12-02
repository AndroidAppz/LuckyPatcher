/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package pxb.android.arsc;

public class Value {
    public final int data;
    public String raw;
    public final int type;

    public Value(int n, int n2, String string) {
        this.type = n;
        this.data = n2;
        this.raw = string;
    }

    public String toString() {
        if (this.type == 3) {
            return this.raw;
        }
        Object[] arrobject = new Object[]{this.type, this.data};
        return String.format((String)"{t=0x%02x d=0x%08x}", (Object[])arrobject);
    }
}

