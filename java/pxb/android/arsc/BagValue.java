/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 */
package pxb.android.arsc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pxb.android.arsc.Value;

public class BagValue {
    public List<Map.Entry<Integer, Value>> map = new ArrayList();
    public final int parent;

    public BagValue(int n) {
        this.parent = n;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof BagValue)) {
            return false;
        }
        BagValue bagValue = (BagValue)object;
        if (this.map == null ? bagValue.map != null : !this.map.equals(bagValue.map)) {
            return false;
        }
        if (this.parent == bagValue.parent) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int hashCode() {
        int n;
        if (this.map == null) {
            n = 0;
            do {
                return 31 * (n + 31) + this.parent;
                break;
            } while (true);
        }
        n = this.map.hashCode();
        return 31 * (n + 31) + this.parent;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] arrobject = new Object[]{this.parent};
        stringBuilder.append(String.format((String)"{bag%08x", (Object[])arrobject));
        for (Map.Entry entry : this.map) {
            StringBuilder stringBuilder2 = stringBuilder.append(",");
            Object[] arrobject2 = new Object[]{entry.getKey()};
            stringBuilder2.append(String.format((String)"0x%08x", (Object[])arrobject2));
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
        }
        return stringBuilder.append("}").toString();
    }
}

