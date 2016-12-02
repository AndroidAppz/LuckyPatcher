/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package pxb.android.axmlLP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pxb.android.axmlLP.AxmlVisitor;

public class Axml
extends AxmlVisitor {
    public List<Node> firsts = new ArrayList();
    public List<Ns> nses = new ArrayList();

    public void accept(final AxmlVisitor axmlVisitor) {
        Iterator iterator = this.nses.iterator();
        while (iterator.hasNext()) {
            ((Ns)iterator.next()).accept(axmlVisitor);
        }
        Iterator iterator2 = this.firsts.iterator();
        while (iterator2.hasNext()) {
            ((Node)iterator2.next()).accept(new AxmlVisitor.NodeVisitor(null){

                @Override
                public AxmlVisitor.NodeVisitor child(String string, String string2) {
                    return axmlVisitor.first(string, string2);
                }
            });
        }
    }

    @Override
    public AxmlVisitor.NodeVisitor first(String string, String string2) {
        Node node = new Node();
        node.name = string2;
        node.ns = string;
        this.firsts.add((Object)node);
        return node;
    }

    @Override
    public void ns(String string, String string2, int n) {
        Ns ns = new Ns();
        ns.prefix = string;
        ns.uri = string2;
        ns.ln = n;
        this.nses.add((Object)ns);
    }

    public static class Node
    extends AxmlVisitor.NodeVisitor {
        public List<Attr> attrs = new ArrayList();
        public List<Node> children = new ArrayList();
        public Integer ln;
        public String name;
        public String ns;
        public Text text;

        public void accept(AxmlVisitor.NodeVisitor nodeVisitor) {
            AxmlVisitor.NodeVisitor nodeVisitor2 = nodeVisitor.child(this.ns, this.name);
            this.acceptB(nodeVisitor2);
            nodeVisitor2.end();
        }

        public void acceptB(AxmlVisitor.NodeVisitor nodeVisitor) {
            if (this.text != null) {
                this.text.accept(nodeVisitor);
            }
            Iterator iterator = this.attrs.iterator();
            while (iterator.hasNext()) {
                ((Attr)iterator.next()).accept(nodeVisitor);
            }
            if (this.ln != null) {
                nodeVisitor.line(this.ln);
            }
            Iterator iterator2 = this.children.iterator();
            while (iterator2.hasNext()) {
                ((Node)iterator2.next()).accept(nodeVisitor);
            }
        }

        @Override
        public void attr(String string, String string2, int n, int n2, Object object) {
            Attr attr2 = new Attr();
            attr2.name = string2;
            attr2.ns = string;
            attr2.resourceId = n;
            attr2.type = n2;
            attr2.value = object;
            this.attrs.add((Object)attr2);
        }

        @Override
        public AxmlVisitor.NodeVisitor child(String string, String string2) {
            Node node = new Node();
            node.name = string2;
            node.ns = string;
            this.children.add((Object)node);
            return node;
        }

        @Override
        public void line(int n) {
            this.ln = n;
        }

        @Override
        public void text(int n, String string) {
            Text text = new Text();
            text.ln = n;
            text.text = string;
            this.text = text;
        }

        public static class Attr {
            public String name;
            public String ns;
            public int resourceId;
            public int type;
            public Object value;

            public void accept(AxmlVisitor.NodeVisitor nodeVisitor) {
                nodeVisitor.attr(this.ns, this.name, this.resourceId, this.type, this.value);
            }
        }

        public static class Text {
            public int ln;
            public String text;

            public void accept(AxmlVisitor.NodeVisitor nodeVisitor) {
                nodeVisitor.text(this.ln, this.text);
            }
        }

    }

    public static class Ns {
        public int ln;
        public String prefix;
        public String uri;

        public void accept(AxmlVisitor axmlVisitor) {
            axmlVisitor.ns(this.prefix, this.uri, this.ln);
        }
    }

}

