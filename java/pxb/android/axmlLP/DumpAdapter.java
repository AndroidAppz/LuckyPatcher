package pxb.android.axmlLP;

import java.util.HashMap;
import java.util.Map;
import pxb.android.axmlLP.AxmlVisitor.NodeVisitor;

public class DumpAdapter extends AxmlVisitor {
    private Map<String, String> nses = new HashMap();

    public static class DumpNodeAdapter extends NodeVisitor {
        protected int deep;
        protected Map<String, String> nses;

        public DumpNodeAdapter(NodeVisitor nv) {
            super(nv);
            this.deep = 0;
            this.nses = null;
        }

        public DumpNodeAdapter(NodeVisitor nv, int x, Map<String, String> nses) {
            super(nv);
            this.deep = x;
            this.nses = nses;
        }

        public void attr(String ns, String name, int resourceId, int type, Object obj) {
            for (int i = 0; i < this.deep; i++) {
                System.out.print("  ");
            }
            if (ns != null) {
                System.out.print(String.format("%s:", new Object[]{getPrefix(ns)}));
            }
            System.out.print(name);
            if (resourceId != -1) {
                System.out.print(String.format("(%08x)", new Object[]{Integer.valueOf(resourceId)}));
            }
            if (obj instanceof String) {
                System.out.print(String.format("=[%08x]\"%s\"", new Object[]{Integer.valueOf(type), obj}));
            } else if (obj instanceof Boolean) {
                System.out.print(String.format("=[%08x]\"%b\"", new Object[]{Integer.valueOf(type), obj}));
            } else {
                System.out.print(String.format("=[%08x]%08x", new Object[]{Integer.valueOf(type), obj}));
            }
            System.out.println();
            super.attr(ns, name, resourceId, type, obj);
        }

        public NodeVisitor child(String ns, String name) {
            for (int i = 0; i < this.deep; i++) {
                System.out.print("  ");
            }
            System.out.print("<");
            if (ns != null) {
                System.out.println(getPrefix(ns) + ":");
            }
            System.out.println(name);
            NodeVisitor nv = super.child(ns, name);
            if (nv != null) {
                return new DumpNodeAdapter(nv, this.deep + 1, this.nses);
            }
            return null;
        }

        protected String getPrefix(String uri) {
            if (this.nses != null) {
                String prefix = (String) this.nses.get(uri);
                if (prefix != null) {
                    return prefix;
                }
            }
            return uri;
        }

        public void text(int ln, String value) {
            for (int i = 0; i < this.deep + 1; i++) {
                System.out.print("  ");
            }
            System.out.println(value);
            super.text(ln, value);
        }
    }

    public DumpAdapter(AxmlVisitor av) {
        super(av);
    }

    public void end() {
        super.end();
    }

    public NodeVisitor first(String ns, String name) {
        System.out.print("<");
        if (ns != null) {
            System.out.println(((String) this.nses.get(ns)) + ":");
        }
        System.out.println(name);
        NodeVisitor nv = super.first(ns, name);
        if (nv != null) {
            return new DumpNodeAdapter(nv, 1, this.nses);
        }
        return null;
    }

    public void ns(String prefix, String uri, int ln) {
        System.out.println(prefix + "=" + uri);
        this.nses.put(uri, prefix);
        super.ns(prefix, uri, ln);
    }
}
