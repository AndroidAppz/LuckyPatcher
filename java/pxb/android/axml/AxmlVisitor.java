package pxb.android.axml;

public class AxmlVisitor extends NodeVisitor {
    public AxmlVisitor(NodeVisitor av) {
        super(av);
    }

    public void ns(String prefix, String uri, int ln) {
        if (this.nv != null && (this.nv instanceof AxmlVisitor)) {
            ((AxmlVisitor) this.nv).ns(prefix, uri, ln);
        }
    }
}
