package pxb.android.axmlLP;

class StringItem {
    public String data;
    public int dataOffset;
    public int index;

    public StringItem(String data) {
        this.data = data;
    }

    public boolean equals(Object obj) {
        return ((StringItem) obj).data.equals(this.data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return String.format("S%04d %s", new Object[]{Integer.valueOf(this.index), this.data});
    }
}
