package pxb.android;

public class StringItem {
    public String data;
    public int dataOffset;
    public int index;

    public StringItem(String data) {
        this.data = data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        StringItem other = (StringItem) obj;
        if (this.data == null) {
            if (other.data != null) {
                return false;
            }
            return true;
        } else if (this.data.equals(other.data)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (this.data == null ? 0 : this.data.hashCode()) + 31;
    }

    public String toString() {
        return String.format("S%04d %s", new Object[]{Integer.valueOf(this.index), this.data});
    }
}
