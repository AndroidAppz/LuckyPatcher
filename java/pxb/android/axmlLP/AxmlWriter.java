/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.Stack
 */
package pxb.android.axmlLP;

import com.googlecode.dex2jar.reader.io.DataOut;
import com.googlecode.dex2jar.reader.io.LeDataOut;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import pxb.android.axmlLP.AxmlVisitor;
import pxb.android.axmlLP.StringItem;
import pxb.android.axmlLP.StringItems;

public class AxmlWriter
extends AxmlVisitor {
    private List<NodeImpl> firsts = new ArrayList(3);
    private Map<String, Ns> nses = new HashMap();
    private List<StringItem> otherString = new ArrayList();
    private Map<Integer, StringItem> resourceId2Str = new HashMap();
    private List<Integer> resourceIds = new ArrayList();
    private List<StringItem> resourceString = new ArrayList();
    private StringItems stringItems = new StringItems();

    private int prepare() throws IOException {
        int n = 2 * (24 * this.nses.size());
        Iterator iterator = this.firsts.iterator();
        while (iterator.hasNext()) {
            n += ((NodeImpl)iterator.next()).prepare(this);
        }
        int n2 = 0;
        for (Map.Entry entry : this.nses.entrySet()) {
            Ns ns = (Ns)entry.getValue();
            if (ns == null) {
                Object[] arrobject = new Object[1];
                int n3 = n2 + 1;
                arrobject[0] = n2;
                ns = new Ns(new StringItem(String.format((String)"axml_auto_%02d", (Object[])arrobject)), new StringItem((String)entry.getKey()), 0);
                entry.setValue((Object)ns);
                n2 = n3;
            }
            ns.prefix = this.update(ns.prefix);
            ns.uri = this.update(ns.uri);
        }
        this.stringItems.addAll(this.resourceString);
        this.resourceString = null;
        this.stringItems.addAll(this.otherString);
        this.otherString = null;
        this.stringItems.prepare();
        int n4 = this.stringItems.getSize();
        if (n4 % 4 != 0) {
            n4 += 4 - n4 % 4;
        }
        return n + (n4 + 8) + (8 + 4 * this.resourceIds.size());
    }

    @Override
    public void end() {
    }

    @Override
    public AxmlVisitor.NodeVisitor first(String string, String string2) {
        NodeImpl nodeImpl = new NodeImpl(string, string2);
        this.firsts.add((Object)nodeImpl);
        return nodeImpl;
    }

    @Override
    public void ns(String string, String string2, int n) {
        this.nses.put((Object)string2, (Object)new Ns(new StringItem(string), new StringItem(string2), n));
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        LeDataOut leDataOut = new LeDataOut((OutputStream)byteArrayOutputStream);
        int n = this.prepare();
        leDataOut.writeInt(524291);
        leDataOut.writeInt(n + 8);
        int n2 = this.stringItems.getSize();
        int n3 = n2 % 4;
        int n4 = 0;
        if (n3 != 0) {
            n4 = 4 - n2 % 4;
        }
        leDataOut.writeInt(1835009);
        leDataOut.writeInt(8 + (n2 + n4));
        this.stringItems.write(leDataOut);
        leDataOut.writeBytes(new byte[n4]);
        leDataOut.writeInt(524672);
        leDataOut.writeInt(8 + 4 * this.resourceIds.size());
        Iterator iterator = this.resourceIds.iterator();
        while (iterator.hasNext()) {
            leDataOut.writeInt((Integer)iterator.next());
        }
        Stack stack = new Stack();
        Iterator iterator2 = this.nses.entrySet().iterator();
        while (iterator2.hasNext()) {
            Ns ns = (Ns)((Map.Entry)iterator2.next()).getValue();
            stack.push((Object)ns);
            leDataOut.writeInt(1048832);
            leDataOut.writeInt(24);
            leDataOut.writeInt(-1);
            leDataOut.writeInt(-1);
            leDataOut.writeInt(ns.prefix.index);
            leDataOut.writeInt(ns.uri.index);
        }
        Iterator iterator3 = this.firsts.iterator();
        while (iterator3.hasNext()) {
            ((NodeImpl)iterator3.next()).write(leDataOut);
        }
        while (stack.size() > 0) {
            Ns ns = (Ns)stack.pop();
            leDataOut.writeInt(1048833);
            leDataOut.writeInt(24);
            leDataOut.writeInt(ns.ln);
            leDataOut.writeInt(-1);
            leDataOut.writeInt(ns.prefix.index);
            leDataOut.writeInt(ns.uri.index);
        }
        return byteArrayOutputStream.toByteArray();
    }

    StringItem update(StringItem stringItem) {
        if (stringItem == null) {
            return null;
        }
        int n = this.otherString.indexOf((Object)stringItem);
        if (n < 0) {
            StringItem stringItem2 = new StringItem(stringItem.data);
            this.otherString.add((Object)stringItem2);
            return stringItem2;
        }
        return (StringItem)this.otherString.get(n);
    }

    StringItem updateNs(StringItem stringItem) {
        if (stringItem == null) {
            return null;
        }
        String string = stringItem.data;
        if (!this.nses.containsKey((Object)string)) {
            this.nses.put((Object)string, (Object)null);
        }
        return this.update(stringItem);
    }

    StringItem updateWithResourceId(StringItem stringItem, int n) {
        StringItem stringItem2 = (StringItem)this.resourceId2Str.get((Object)n);
        if (stringItem2 != null) {
            return stringItem2;
        }
        StringItem stringItem3 = new StringItem(stringItem.data);
        this.resourceIds.add((Object)n);
        this.resourceString.add((Object)stringItem3);
        this.resourceId2Str.put((Object)n, (Object)stringItem3);
        return stringItem3;
    }

    static class Attr {
        public StringItem name;
        public StringItem ns;
        public int resourceId;
        public int type;
        public Object value;

        public Attr(StringItem stringItem, StringItem stringItem2, int n, int n2, Object object) {
            this.ns = stringItem;
            this.name = stringItem2;
            this.resourceId = n;
            this.type = n2;
            this.value = object;
        }

        /*
         * Enabled aggressive block sorting
         */
        public void prepare(AxmlWriter axmlWriter) {
            this.ns = axmlWriter.updateNs(this.ns);
            if (this.name != null) {
                this.name = this.resourceId != -1 ? axmlWriter.updateWithResourceId(this.name, this.resourceId) : axmlWriter.update(this.name);
            }
            if (this.value instanceof StringItem) {
                this.value = axmlWriter.update((StringItem)this.value);
            }
        }
    }

    static class NodeImpl
    extends AxmlVisitor.NodeVisitor {
        private Map<String, Attr> attrs = new HashMap();
        private List<NodeImpl> children = new ArrayList();
        private int line;
        private StringItem name;
        private StringItem ns;
        private StringItem text;
        private int textLineNumber;

        /*
         * Enabled aggressive block sorting
         */
        public NodeImpl(String string, String string2) {
            super(null);
            StringItem stringItem = string == null ? null : new StringItem(string);
            this.ns = stringItem;
            StringItem stringItem2 = null;
            if (string2 != null) {
                stringItem2 = new StringItem(string2);
            }
            this.name = stringItem2;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void attr(String string, String string2, int n, int n2, Object object) {
            if (string2 == null) {
                throw new RuntimeException("name can't be null");
            }
            Map<String, Attr> map = this.attrs;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = string == null ? "zzz" : string;
            String string4 = stringBuilder.append(string3).append(".").append(string2).toString();
            StringItem stringItem = string == null ? null : new StringItem(string);
            StringItem stringItem2 = new StringItem(string2);
            StringItem stringItem3 = n2 == 3 ? new StringItem((String)object) : object;
            map.put((Object)string4, (Object)new Attr(stringItem, stringItem2, n, n2, stringItem3));
        }

        @Override
        public AxmlVisitor.NodeVisitor child(String string, String string2) {
            NodeImpl nodeImpl = new NodeImpl(string, string2);
            this.children.add((Object)nodeImpl);
            return nodeImpl;
        }

        @Override
        public void end() {
        }

        @Override
        public void line(int n) {
            this.line = n;
        }

        public int prepare(AxmlWriter axmlWriter) {
            this.ns = axmlWriter.updateNs(this.ns);
            this.name = axmlWriter.update(this.name);
            Iterator iterator = this.sortedAttrs().iterator();
            while (iterator.hasNext()) {
                ((Attr)iterator.next()).prepare(axmlWriter);
            }
            this.text = axmlWriter.update(this.text);
            int n = 60 + 20 * this.attrs.size();
            Iterator iterator2 = this.children.iterator();
            while (iterator2.hasNext()) {
                n += ((NodeImpl)iterator2.next()).prepare(axmlWriter);
            }
            if (this.text != null) {
                n += 28;
            }
            return n;
        }

        List<Attr> sortedAttrs() {
            ArrayList arrayList = new ArrayList(this.attrs.values());
            Collections.sort((List)arrayList, (Comparator)new Comparator<Attr>(){

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                public int compare(Attr attr2, Attr attr3) {
                    if (attr2.ns == null) {
                        if (attr3.ns != null) return 1;
                        return attr3.name.data.compareTo(attr2.name.data);
                    }
                    if (attr3.ns == null) {
                        return -1;
                    }
                    int n = attr2.ns.data.compareTo(attr3.ns.data);
                    if (n != 0) return n;
                    n = attr2.resourceId - attr3.resourceId;
                    if (n != 0) return n;
                    return attr2.name.data.compareTo(attr3.name.data);
                }
            });
            return arrayList;
        }

        @Override
        public void text(int n, String string) {
            this.text = new StringItem(string);
            this.textLineNumber = n;
        }

        /*
         * Enabled aggressive block sorting
         */
        void write(DataOut dataOut) throws IOException {
            int n = -1;
            dataOut.writeInt(1048834);
            dataOut.writeInt(36 + 20 * this.attrs.size());
            dataOut.writeInt(this.line);
            dataOut.writeInt(n);
            int n2 = this.ns != null ? this.ns.index : n;
            dataOut.writeInt(n2);
            dataOut.writeInt(this.name.index);
            dataOut.writeInt(1310740);
            dataOut.writeShort(this.attrs.size());
            dataOut.writeShort(0);
            dataOut.writeShort(0);
            dataOut.writeShort(0);
            for (Attr attr2 : this.sortedAttrs()) {
                int n3 = attr2.ns == null ? n : attr2.ns.index;
                dataOut.writeInt(n3);
                dataOut.writeInt(attr2.name.index);
                int n4 = attr2.value instanceof StringItem ? ((StringItem)attr2.value).index : n;
                dataOut.writeInt(n4);
                dataOut.writeInt(8 | attr2.type << 24);
                Object object = attr2.value;
                if (object instanceof StringItem) {
                    dataOut.writeInt(((StringItem)attr2.value).index);
                    continue;
                }
                if (object instanceof Boolean) {
                    int n5 = Boolean.TRUE.equals(object) ? n : 0;
                    dataOut.writeInt(n5);
                    continue;
                }
                dataOut.writeInt((Integer)attr2.value);
            }
            if (this.text != null) {
                dataOut.writeInt(1048836);
                dataOut.writeInt(28);
                dataOut.writeInt(this.textLineNumber);
                dataOut.writeInt(n);
                dataOut.writeInt(this.text.index);
                dataOut.writeInt(8);
                dataOut.writeInt(0);
            }
            Iterator iterator = this.children.iterator();
            while (iterator.hasNext()) {
                ((NodeImpl)iterator.next()).write(dataOut);
            }
            dataOut.writeInt(1048835);
            dataOut.writeInt(24);
            dataOut.writeInt(n);
            dataOut.writeInt(n);
            if (this.ns != null) {
                n = this.ns.index;
            }
            dataOut.writeInt(n);
            dataOut.writeInt(this.name.index);
        }

    }

    static class Ns {
        int ln;
        StringItem prefix;
        StringItem uri;

        public Ns(StringItem stringItem, StringItem stringItem2, int n) {
            this.prefix = stringItem;
            this.uri = stringItem2;
            this.ln = n;
        }
    }

}

