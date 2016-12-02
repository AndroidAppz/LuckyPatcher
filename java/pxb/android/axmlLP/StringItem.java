/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package pxb.android.axmlLP;

class StringItem {
    public String data;
    public int dataOffset;
    public int index;

    public StringItem() {
    }

    public StringItem(String string) {
        this.data = string;
    }

    public boolean equals(Object object) {
        return ((StringItem)object).data.equals((Object)this.data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        Object[] arrobject = new Object[]{this.index, this.data};
        return String.format((String)"S%04d %s", (Object[])arrobject);
    }
}

