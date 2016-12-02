package pxb.android.axmlLP;

public class AxmlVisitor {
    public static final int TYPE_FIRST_INT = 16;
    public static final int TYPE_INT_BOOLEAN = 18;
    public static final int TYPE_INT_HEX = 17;
    public static final int TYPE_REFERENCE = 1;
    public static final int TYPE_STRING = 3;
    protected AxmlVisitor av;

    public static abstract class NodeVisitor {
        protected NodeVisitor nv;

        public NodeVisitor(NodeVisitor nv) {
            this.nv = nv;
        }

        public void attr(String ns, String name, int resourceId, int type, Object obj) {
            if (this.nv != null) {
                this.nv.attr(ns, name, resourceId, type, obj);
            }
        }

        public NodeVisitor child(String ns, String name) {
            if (this.nv != null) {
                return this.nv.child(ns, name);
            }
            return null;
        }

        public void end() {
            if (this.nv != null) {
                this.nv.end();
            }
        }

        public void line(int ln) {
            if (this.nv != null) {
                this.nv.line(ln);
            }
        }

        public void text(int lineNumber, String value) {
            if (this.nv != null) {
                this.nv.text(lineNumber, value);
            }
        }
    }

    public AxmlVisitor(AxmlVisitor av) {
        this.av = av;
    }

    public void end() {
        if (this.av != null) {
            this.av.end();
        }
    }

    public NodeVisitor first(String ns, String name) {
        if (this.av != null) {
            return this.av.first(ns, name);
        }
        return null;
    }

    public void ns(String prefix, String uri, int ln) {
        if (this.av != null) {
            this.av.ns(prefix, uri, ln);
        }
    }
}
