package pxb.android.arsc;

public class Value {
    public final int data;
    public String raw;
    public final int type;

    public Value(int type, int data, String raw) {
        this.type = type;
        this.data = data;
        this.raw = raw;
    }

    public String toString() {
        if (this.type == 3) {
            return this.raw;
        }
        return String.format("{t=0x%02x d=0x%08x}", new Object[]{Integer.valueOf(this.type), Integer.valueOf(this.data)});
    }
}
