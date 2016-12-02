package pxb.android.axmlLP;

import java.util.ArrayList;
import java.util.List;
import pxb.android.axmlLP.AxmlVisitor.NodeVisitor;

public class Axml extends AxmlVisitor {
    public List<Node> firsts = new ArrayList();
    public List<Ns> nses = new ArrayList();

    public static class Node extends NodeVisitor {
        public List<Attr> attrs = new ArrayList();
        public List<Node> children = new ArrayList();
        public Integer ln;
        public String name;
        public String ns;
        public Text text;

        public static class Attr {
            public String name;
            public String ns;
            public int resourceId;
            public int type;
            public Object value;

            public void accept(NodeVisitor nodeVisitor) {
                nodeVisitor.attr(this.ns, this.name, this.resourceId, this.type, this.value);
            }
        }

        public static class Text {
            public int ln;
            public String text;

            public void accept(NodeVisitor nodeVisitor) {
                nodeVisitor.text(this.ln, this.text);
            }
        }

        public void accept(NodeVisitor nodeVisitor) {
            NodeVisitor nodeVisitor2 = nodeVisitor.child(this.ns, this.name);
            acceptB(nodeVisitor2);
            nodeVisitor2.end();
        }

        public void acceptB(NodeVisitor nodeVisitor) {
            if (this.text != null) {
                this.text.accept(nodeVisitor);
            }
            for (Attr a : this.attrs) {
                a.accept(nodeVisitor);
            }
            if (this.ln != null) {
                nodeVisitor.line(this.ln.intValue());
            }
            for (Node c : this.children) {
                c.accept(nodeVisitor);
            }
        }

        public void attr(String ns, String name, int resourceId, int type, Object obj) {
            Attr attr = new Attr();
            attr.name = name;
            attr.ns = ns;
            attr.resourceId = resourceId;
            attr.type = type;
            attr.value = obj;
            this.attrs.add(attr);
        }

        public NodeVisitor child(String ns, String name) {
            Node node = new Node();
            node.name = name;
            node.ns = ns;
            this.children.add(node);
            return node;
        }

        public void line(int ln) {
            this.ln = Integer.valueOf(ln);
        }

        public void text(int lineNumber, String value) {
            Text text = new Text();
            text.ln = lineNumber;
            text.text = value;
            this.text = text;
        }
    }

    public static class Ns {
        public int ln;
        public String prefix;
        public String uri;

        public void accept(AxmlVisitor visitor) {
            visitor.ns(this.prefix, this.uri, this.ln);
        }
    }

    public void accept(final AxmlVisitor visitor) {
        for (Ns ns : this.nses) {
            ns.accept(visitor);
        }
        for (Node first : this.firsts) {
            first.accept(new NodeVisitor(null) {
                public NodeVisitor child(String ns, String name) {
                    return visitor.first(ns, name);
                }
            });
        }
    }

    public NodeVisitor first(String ns, String name) {
        Node node = new Node();
        node.name = name;
        node.ns = ns;
        this.firsts.add(node);
        return node;
    }

    public void ns(String prefix, String uri, int ln) {
        Ns ns = new Ns();
        ns.prefix = prefix;
        ns.uri = uri;
        ns.ln = ln;
        this.nses.add(ns);
    }
}
