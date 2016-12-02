package pxb.android.arsc;

public class ResEntry {
    public final int flag;
    public final ResSpec spec;
    public Object value;
    int wOffset;

    public ResEntry(int flag, ResSpec spec) {
        this.flag = flag;
        this.spec = spec;
    }
}
