package pxb.android.axmlLP;

import com.googlecode.dex2jar.reader.io.DataOut;
import com.googlecode.dex2jar.reader.io.LeDataOut;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import pxb.android.axmlLP.AxmlVisitor.NodeVisitor;

public class AxmlWriter extends AxmlVisitor {
    private List<NodeImpl> firsts = new ArrayList(3);
    private Map<String, Ns> nses = new HashMap();
    private List<StringItem> otherString = new ArrayList();
    private Map<Integer, StringItem> resourceId2Str = new HashMap();
    private List<Integer> resourceIds = new ArrayList();
    private List<StringItem> resourceString = new ArrayList();
    private StringItems stringItems = new StringItems();

    static class Attr {
        public StringItem name;
        public StringItem ns;
        public int resourceId;
        public int type;
        public Object value;

        public Attr(StringItem ns, StringItem name, int resourceId, int type, Object value) {
            this.ns = ns;
            this.name = name;
            this.resourceId = resourceId;
            this.type = type;
            this.value = value;
        }

        public void prepare(AxmlWriter axmlWriter) {
            this.ns = axmlWriter.updateNs(this.ns);
            if (this.name != null) {
                if (this.resourceId != -1) {
                    this.name = axmlWriter.updateWithResourceId(this.name, this.resourceId);
                } else {
                    this.name = axmlWriter.update(this.name);
                }
            }
            if (this.value instanceof StringItem) {
                this.value = axmlWriter.update((StringItem) this.value);
            }
        }
    }

    static class NodeImpl extends NodeVisitor {
        private Map<String, Attr> attrs = new HashMap();
        private List<NodeImpl> children = new ArrayList();
        private int line;
        private StringItem name;
        private StringItem ns;
        private StringItem text;
        private int textLineNumber;

        public NodeImpl(String ns, String name) {
            StringItem stringItem = null;
            super(null);
            this.ns = ns == null ? null : new StringItem(ns);
            if (name != null) {
                stringItem = new StringItem(name);
            }
            this.name = stringItem;
        }

        public void attr(String ns, String name, int resourceId, int type, Object value) {
            if (name == null) {
                throw new RuntimeException("name can't be null");
            }
            Object obj;
            Object stringItem;
            Map map = this.attrs;
            if (ns == null) {
                obj = "zzz";
            } else {
                String str = ns;
            }
            String stringBuilder = new StringBuilder(String.valueOf(obj)).append(".").append(name).toString();
            StringItem stringItem2 = ns == null ? null : new StringItem(ns);
            StringItem stringItem3 = new StringItem(name);
            if (type == 3) {
                stringItem = new StringItem((String) value);
            } else {
                stringItem = value;
            }
            map.put(stringBuilder, new Attr(stringItem2, stringItem3, resourceId, type, stringItem));
        }

        public NodeVisitor child(String ns, String name) {
            NodeImpl child = new NodeImpl(ns, name);
            this.children.add(child);
            return child;
        }

        public void end() {
        }

        public void line(int ln) {
            this.line = ln;
        }

        public int prepare(AxmlWriter axmlWriter) {
            this.ns = axmlWriter.updateNs(this.ns);
            this.name = axmlWriter.update(this.name);
            for (Attr attr : sortedAttrs()) {
                attr.prepare(axmlWriter);
            }
            this.text = axmlWriter.update(this.text);
            int size = (this.attrs.size() * 20) + 60;
            for (NodeImpl child : this.children) {
                size += child.prepare(axmlWriter);
            }
            if (this.text != null) {
                return size + 28;
            }
            return size;
        }

        List<Attr> sortedAttrs() {
            List<Attr> lAttrs = new ArrayList(this.attrs.values());
            Collections.sort(lAttrs, new Comparator<Attr>() {
                public int compare(Attr a, Attr b) {
                    if (a.ns == null) {
                        if (b.ns == null) {
                            return b.name.data.compareTo(a.name.data);
                        }
                        return 1;
                    } else if (b.ns == null) {
                        return -1;
                    } else {
                        int x = a.ns.data.compareTo(b.ns.data);
                        if (x != 0) {
                            return x;
                        }
                        x = a.resourceId - b.resourceId;
                        if (x == 0) {
                            return a.name.data.compareTo(b.name.data);
                        }
                        return x;
                    }
                }
            });
            return lAttrs;
        }

        public void text(int ln, String value) {
            this.text = new StringItem(value);
            this.textLineNumber = ln;
        }

        void write(DataOut out) throws IOException {
            int i = -1;
            out.writeInt(1048834);
            out.writeInt((this.attrs.size() * 20) + 36);
            out.writeInt(this.line);
            out.writeInt(-1);
            out.writeInt(this.ns != null ? this.ns.index : -1);
            out.writeInt(this.name.index);
            out.writeInt(1310740);
            out.writeShort(this.attrs.size());
            out.writeShort(0);
            out.writeShort(0);
            out.writeShort(0);
            for (Attr attr : sortedAttrs()) {
                int i2;
                out.writeInt(attr.ns == null ? -1 : attr.ns.index);
                out.writeInt(attr.name.index);
                if (attr.value instanceof StringItem) {
                    i2 = ((StringItem) attr.value).index;
                } else {
                    i2 = -1;
                }
                out.writeInt(i2);
                out.writeInt((attr.type << 24) | 8);
                Object v = attr.value;
                if (v instanceof StringItem) {
                    out.writeInt(((StringItem) attr.value).index);
                } else if (v instanceof Boolean) {
                    out.writeInt(Boolean.TRUE.equals(v) ? -1 : 0);
                } else {
                    out.writeInt(((Integer) attr.value).intValue());
                }
            }
            if (this.text != null) {
                out.writeInt(1048836);
                out.writeInt(28);
                out.writeInt(this.textLineNumber);
                out.writeInt(-1);
                out.writeInt(this.text.index);
                out.writeInt(8);
                out.writeInt(0);
            }
            for (NodeImpl child : this.children) {
                child.write(out);
            }
            out.writeInt(1048835);
            out.writeInt(24);
            out.writeInt(-1);
            out.writeInt(-1);
            if (this.ns != null) {
                i = this.ns.index;
            }
            out.writeInt(i);
            out.writeInt(this.name.index);
        }
    }

    static class Ns {
        int ln;
        StringItem prefix;
        StringItem uri;

        public Ns(StringItem prefix, StringItem uri, int ln) {
            this.prefix = prefix;
            this.uri = uri;
            this.ln = ln;
        }
    }

    public void end() {
    }

    public NodeVisitor first(String ns, String name) {
        NodeImpl first = new NodeImpl(ns, name);
        this.firsts.add(first);
        return first;
    }

    public void ns(String prefix, String uri, int ln) {
        this.nses.put(uri, new Ns(new StringItem(prefix), new StringItem(uri), ln));
    }

    private int prepare() throws IOException {
        int size = (this.nses.size() * 24) * 2;
        for (NodeImpl first : this.firsts) {
            size += first.prepare(this);
        }
        int a = 0;
        for (Entry<String, Ns> e : this.nses.entrySet()) {
            int a2;
            Ns ns = (Ns) e.getValue();
            if (ns == null) {
                Object[] objArr = new Object[1];
                a2 = a + 1;
                objArr[0] = Integer.valueOf(a);
                ns = new Ns(new StringItem(String.format("axml_auto_%02d", objArr)), new StringItem((String) e.getKey()), 0);
                e.setValue(ns);
            } else {
                a2 = a;
            }
            ns.prefix = update(ns.prefix);
            ns.uri = update(ns.uri);
            a = a2;
        }
        this.stringItems.addAll(this.resourceString);
        this.resourceString = null;
        this.stringItems.addAll(this.otherString);
        this.otherString = null;
        this.stringItems.prepare();
        int stringSize = this.stringItems.getSize();
        if (stringSize % 4 != 0) {
            stringSize += 4 - (stringSize % 4);
        }
        return (size + (stringSize + 8)) + ((this.resourceIds.size() * 4) + 8);
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        DataOut out = new LeDataOut(os);
        int size = prepare();
        out.writeInt(524291);
        out.writeInt(size + 8);
        int stringSize = this.stringItems.getSize();
        int padding = 0;
        if (stringSize % 4 != 0) {
            padding = 4 - (stringSize % 4);
        }
        out.writeInt(1835009);
        out.writeInt((stringSize + padding) + 8);
        this.stringItems.write(out);
        out.writeBytes(new byte[padding]);
        out.writeInt(524672);
        out.writeInt((this.resourceIds.size() * 4) + 8);
        for (Integer i : this.resourceIds) {
            out.writeInt(i.intValue());
        }
        Stack<Ns> stack = new Stack();
        for (Entry<String, Ns> e : this.nses.entrySet()) {
            Ns ns = (Ns) e.getValue();
            stack.push(ns);
            out.writeInt(1048832);
            out.writeInt(24);
            out.writeInt(-1);
            out.writeInt(-1);
            out.writeInt(ns.prefix.index);
            out.writeInt(ns.uri.index);
        }
        for (NodeImpl first : this.firsts) {
            first.write(out);
        }
        while (stack.size() > 0) {
            ns = (Ns) stack.pop();
            out.writeInt(1048833);
            out.writeInt(24);
            out.writeInt(ns.ln);
            out.writeInt(-1);
            out.writeInt(ns.prefix.index);
            out.writeInt(ns.uri.index);
        }
        return os.toByteArray();
    }

    StringItem update(StringItem item) {
        if (item == null) {
            return null;
        }
        int i = this.otherString.indexOf(item);
        if (i >= 0) {
            return (StringItem) this.otherString.get(i);
        }
        StringItem copy = new StringItem(item.data);
        this.otherString.add(copy);
        return copy;
    }

    StringItem updateNs(StringItem item) {
        if (item == null) {
            return null;
        }
        String ns = item.data;
        if (!this.nses.containsKey(ns)) {
            this.nses.put(ns, null);
        }
        return update(item);
    }

    StringItem updateWithResourceId(StringItem name, int resourceId) {
        StringItem item = (StringItem) this.resourceId2Str.get(Integer.valueOf(resourceId));
        if (item != null) {
            return item;
        }
        StringItem copy = new StringItem(name.data);
        this.resourceIds.add(Integer.valueOf(resourceId));
        this.resourceString.add(copy);
        this.resourceId2Str.put(Integer.valueOf(resourceId), copy);
        return copy;
    }
}
