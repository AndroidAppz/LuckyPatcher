package pxb.android.axml;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import pxb.android.StringItem;
import pxb.android.StringItems;
import pxb.android.axmlLP.AxmlVisitor;

public class AxmlWriter extends AxmlVisitor {
    static final Comparator<Attr> ATTR_CMP = new Comparator<Attr>() {
        public int compare(Attr a, Attr b) {
            int x = a.resourceId - b.resourceId;
            if (x != 0) {
                return x;
            }
            x = a.name.data.compareTo(b.name.data);
            if (x != 0) {
                return x;
            }
            boolean bNsIsnull;
            boolean aNsIsnull = a.ns == null;
            if (b.ns == null) {
                bNsIsnull = true;
            } else {
                bNsIsnull = false;
            }
            if (aNsIsnull) {
                if (bNsIsnull) {
                    return 0;
                }
                return -1;
            } else if (bNsIsnull) {
                return 1;
            } else {
                return a.ns.data.compareTo(b.ns.data);
            }
        }
    };
    private List<NodeImpl> firsts = new ArrayList(3);
    private Map<String, Ns> nses = new HashMap();
    private List<StringItem> otherString = new ArrayList();
    private Map<String, StringItem> resourceId2Str = new HashMap();
    private List<Integer> resourceIds = new ArrayList();
    private List<StringItem> resourceString = new ArrayList();
    private StringItems stringItems = new StringItems();

    static class Attr {
        public int index;
        public StringItem name;
        public StringItem ns;
        public StringItem raw;
        public int resourceId;
        public int type;
        public Object value;

        public Attr(StringItem ns, StringItem name, int resourceId) {
            this.ns = ns;
            this.name = name;
            this.resourceId = resourceId;
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
            if (this.raw != null) {
                this.raw = axmlWriter.update(this.raw);
            }
        }
    }

    static class NodeImpl extends NodeVisitor {
        private Set<Attr> attrs = new TreeSet(AxmlWriter.ATTR_CMP);
        private List<NodeImpl> children = new ArrayList();
        Attr clz;
        Attr id;
        private int line;
        private StringItem name;
        private StringItem ns;
        Attr style;
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
            StringItem stringItem;
            if (ns == null) {
                stringItem = null;
            } else {
                stringItem = new StringItem(ns);
            }
            Attr a = new Attr(stringItem, new StringItem(name), resourceId);
            a.type = type;
            if (value instanceof ValueWrapper) {
                ValueWrapper valueWrapper = (ValueWrapper) value;
                if (valueWrapper.raw != null) {
                    a.raw = new StringItem(valueWrapper.raw);
                }
                a.value = Integer.valueOf(valueWrapper.ref);
                switch (valueWrapper.type) {
                    case AxmlVisitor.TYPE_REFERENCE /*1*/:
                        this.id = a;
                        break;
                    case ValueWrapper.STYLE /*2*/:
                        this.style = a;
                        break;
                    case AxmlVisitor.TYPE_STRING /*3*/:
                        this.clz = a;
                        break;
                }
            } else if (type == 3) {
                StringItem raw = new StringItem((String) value);
                a.raw = raw;
                a.value = raw;
            } else {
                a.raw = null;
                a.value = value;
            }
            this.attrs.add(a);
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
            int attrIndex = 0;
            for (Attr attr : this.attrs) {
                int attrIndex2 = attrIndex + 1;
                attr.index = attrIndex;
                attr.prepare(axmlWriter);
                attrIndex = attrIndex2;
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

        public void text(int ln, String value) {
            this.text = new StringItem(value);
            this.textLineNumber = ln;
        }

        void write(ByteBuffer out) throws IOException {
            int i;
            int i2 = -1;
            out.putInt(1048834);
            out.putInt((this.attrs.size() * 20) + 36);
            out.putInt(this.line);
            out.putInt(-1);
            if (this.ns != null) {
                i = this.ns.index;
            } else {
                i = -1;
            }
            out.putInt(i);
            out.putInt(this.name.index);
            out.putInt(1310740);
            out.putShort((short) this.attrs.size());
            out.putShort((short) (this.id == null ? 0 : this.id.index + 1));
            out.putShort((short) (this.clz == null ? 0 : this.clz.index + 1));
            out.putShort((short) (this.style == null ? 0 : this.style.index + 1));
            for (Attr attr : this.attrs) {
                out.putInt(attr.ns == null ? -1 : attr.ns.index);
                out.putInt(attr.name.index);
                if (attr.raw != null) {
                    i = attr.raw.index;
                } else {
                    i = -1;
                }
                out.putInt(i);
                out.putInt((attr.type << 24) | 8);
                Object v = attr.value;
                if (v instanceof StringItem) {
                    out.putInt(((StringItem) attr.value).index);
                } else if (v instanceof Boolean) {
                    out.putInt(Boolean.TRUE.equals(v) ? -1 : 0);
                } else {
                    out.putInt(((Integer) attr.value).intValue());
                }
            }
            if (this.text != null) {
                out.putInt(1048836);
                out.putInt(28);
                out.putInt(this.textLineNumber);
                out.putInt(-1);
                out.putInt(this.text.index);
                out.putInt(8);
                out.putInt(0);
            }
            for (NodeImpl child : this.children) {
                child.write(out);
            }
            out.putInt(1048835);
            out.putInt(24);
            out.putInt(-1);
            out.putInt(-1);
            if (this.ns != null) {
                i2 = this.ns.index;
            }
            out.putInt(i2);
            out.putInt(this.name.index);
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

    public NodeVisitor child(String ns, String name) {
        NodeImpl first = new NodeImpl(ns, name);
        this.firsts.add(first);
        return first;
    }

    public void end() {
    }

    public void ns(String prefix, String uri, int ln) {
        this.nses.put(uri, new Ns(prefix == null ? null : new StringItem(prefix), new StringItem(uri), ln));
    }

    private int prepare() throws IOException {
        int size = 0;
        for (NodeImpl first : this.firsts) {
            size += first.prepare(this);
        }
        int a = 0;
        for (Entry<String, Ns> e : this.nses.entrySet()) {
            Ns ns = (Ns) e.getValue();
            if (ns == null) {
                ns = new Ns(null, new StringItem((String) e.getKey()), 0);
                e.setValue(ns);
            }
            if (ns.prefix == null) {
                Object[] objArr = new Object[1];
                int a2 = a + 1;
                objArr[0] = Integer.valueOf(a);
                ns.prefix = new StringItem(String.format("axml_auto_%02d", objArr));
                a = a2;
            }
            ns.prefix = update(ns.prefix);
            ns.uri = update(ns.uri);
        }
        size += (this.nses.size() * 24) * 2;
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
        int size = prepare() + 8;
        ByteBuffer out = ByteBuffer.allocate(size).order(ByteOrder.LITTLE_ENDIAN);
        out.putInt(524291);
        out.putInt(size);
        int stringSize = this.stringItems.getSize();
        int padding = 0;
        if (stringSize % 4 != 0) {
            padding = 4 - (stringSize % 4);
        }
        out.putInt(1835009);
        out.putInt((stringSize + padding) + 8);
        this.stringItems.write(out);
        out.put(new byte[padding]);
        out.putInt(524672);
        out.putInt((this.resourceIds.size() * 4) + 8);
        for (Integer i : this.resourceIds) {
            out.putInt(i.intValue());
        }
        Stack<Ns> stack = new Stack();
        for (Entry<String, Ns> e : this.nses.entrySet()) {
            Ns ns = (Ns) e.getValue();
            stack.push(ns);
            out.putInt(1048832);
            out.putInt(24);
            out.putInt(-1);
            out.putInt(-1);
            out.putInt(ns.prefix.index);
            out.putInt(ns.uri.index);
        }
        for (NodeImpl first : this.firsts) {
            first.write(out);
        }
        while (stack.size() > 0) {
            ns = (Ns) stack.pop();
            out.putInt(1048833);
            out.putInt(24);
            out.putInt(ns.ln);
            out.putInt(-1);
            out.putInt(ns.prefix.index);
            out.putInt(ns.uri.index);
        }
        return out.array();
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
        String key = name.data + resourceId;
        StringItem item = (StringItem) this.resourceId2Str.get(key);
        if (item != null) {
            return item;
        }
        StringItem copy = new StringItem(name.data);
        this.resourceIds.add(Integer.valueOf(resourceId));
        this.resourceString.add(copy);
        this.resourceId2Str.put(key, copy);
        return copy;
    }
}
