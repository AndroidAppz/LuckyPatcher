package pxb.android.arsc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class BagValue {
    public List<Entry<Integer, Value>> map = new ArrayList();
    public final int parent;

    public BagValue(int parent) {
        this.parent = parent;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BagValue)) {
            return false;
        }
        BagValue other = (BagValue) obj;
        if (this.map == null) {
            if (other.map != null) {
                return false;
            }
        } else if (!this.map.equals(other.map)) {
            return false;
        }
        if (this.parent != other.parent) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.map == null ? 0 : this.map.hashCode()) + 31) * 31) + this.parent;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("{bag%08x", new Object[]{Integer.valueOf(this.parent)}));
        for (Entry<Integer, Value> e : this.map) {
            sb.append(",").append(String.format("0x%08x", new Object[]{e.getKey()}));
            sb.append("=");
            sb.append(e.getValue());
        }
        return sb.append("}").toString();
    }
}
