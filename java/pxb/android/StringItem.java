/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package pxb.android;

public class StringItem {
    public String data;
    public int dataOffset;
    public int index;

    public StringItem() {
    }

    public StringItem(String string) {
        this.data = string;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        StringItem stringItem = (StringItem)object;
        if (this.data == null) {
            if (stringItem.data == null) return true;
            return false;
        }
        if (!this.data.equals((Object)stringItem.data)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int hashCode() {
        int n;
        if (this.data == null) {
            n = 0;
            do {
                return n + 31;
                break;
            } while (true);
        }
        n = this.data.hashCode();
        return n + 31;
    }

    public String toString() {
        Object[] arrobject = new Object[]{this.index, this.data};
        return String.format((String)"S%04d %s", (Object[])arrobject);
    }
}

