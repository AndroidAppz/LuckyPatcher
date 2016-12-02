/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.Stack
 *  java.util.TreeSet
 */
package pxb.android.axml;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import pxb.android.StringItem;
import pxb.android.StringItems;
import pxb.android.axml.AxmlVisitor;
import pxb.android.axml.NodeVisitor;

public class AxmlWriter
extends AxmlVisitor {
    static final Comparator<Attr> ATTR_CMP = new Comparator<Attr>(){

        /*
         * Enabled aggressive block sorting
         */
        public int compare(Attr attr2, Attr attr3) {
            int n = attr2.resourceId - attr3.resourceId;
            if (n != 0) return n;
            n = attr2.name.data.compareTo(attr3.name.data);
            if (n != 0) return n;
            boolean bl = attr2.ns == null;
            if (attr3.ns != null) return -1;
            boolean bl2 = true;
            if (!bl) return 1;
            if (bl2) return 0;
            return -1;
        }
    };
    private List<NodeImpl> firsts = new ArrayList(3);
    private Map<String, Ns> nses = new HashMap();
    private List<StringItem> otherString = new ArrayList();
    private Map<String, StringItem> resourceId2Str = new HashMap();
    private List<Integer> resourceIds = new ArrayList();
    private List<StringItem> resourceString = new ArrayList();
    private StringItems stringItems = new StringItems();

    private int prepare() throws IOException {
        int n = 0;
        Iterator iterator = this.firsts.iterator();
        while (iterator.hasNext()) {
            n += ((NodeImpl)iterator.next()).prepare(this);
        }
        int n2 = 0;
        for (Map.Entry entry : this.nses.entrySet()) {
            Ns ns = (Ns)entry.getValue();
            if (ns == null) {
                ns = new Ns(null, new StringItem((String)entry.getKey()), 0);
                entry.setValue((Object)ns);
            }
            if (ns.prefix == null) {
                Object[] arrobject = new Object[1];
                int n3 = n2 + 1;
                arrobject[0] = n2;
                ns.prefix = new StringItem(String.format((String)"axml_auto_%02d", (Object[])arrobject));
                n2 = n3;
            }
            ns.prefix = this.update(ns.prefix);
            ns.uri = this.update(ns.uri);
        }
        int n4 = n + 2 * (24 * this.nses.size());
        this.stringItems.addAll(this.resourceString);
        this.resourceString = null;
        this.stringItems.addAll(this.otherString);
        this.otherString = null;
        this.stringItems.prepare();
        int n5 = this.stringItems.getSize();
        if (n5 % 4 != 0) {
            n5 += 4 - n5 % 4;
        }
        return n4 + (n5 + 8) + (8 + 4 * this.resourceIds.size());
    }

    @Override
    public NodeVisitor child(String string, String string2) {
        NodeImpl nodeImpl = new NodeImpl(string, string2);
        this.firsts.add((Object)nodeImpl);
        return nodeImpl;
    }

    @Override
    public void end() {
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void ns(String string, String string2, int n) {
        Map<String, Ns> map = this.nses;
        StringItem stringItem = string == null ? null : new StringItem(string);
        map.put((Object)string2, (Object)new Ns(stringItem, new StringItem(string2), n));
    }

    public byte[] toByteArray() throws IOException {
        int n = 8 + this.prepare();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)n).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putInt(524291);
        byteBuffer.putInt(n);
        int n2 = this.stringItems.getSize();
        int n3 = n2 % 4;
        int n4 = 0;
        if (n3 != 0) {
            n4 = 4 - n2 % 4;
        }
        byteBuffer.putInt(1835009);
        byteBuffer.putInt(8 + (n2 + n4));
        this.stringItems.write(byteBuffer);
        byteBuffer.put(new byte[n4]);
        byteBuffer.putInt(524672);
        byteBuffer.putInt(8 + 4 * this.resourceIds.size());
        Iterator iterator = this.resourceIds.iterator();
        while (iterator.hasNext()) {
            byteBuffer.putInt(((Integer)iterator.next()).intValue());
        }
        Stack stack = new Stack();
        Iterator iterator2 = this.nses.entrySet().iterator();
        while (iterator2.hasNext()) {
            Ns ns = (Ns)((Map.Entry)iterator2.next()).getValue();
            stack.push((Object)ns);
            byteBuffer.putInt(1048832);
            byteBuffer.putInt(24);
            byteBuffer.putInt(-1);
            byteBuffer.putInt(-1);
            byteBuffer.putInt(ns.prefix.index);
            byteBuffer.putInt(ns.uri.index);
        }
        Iterator iterator3 = this.firsts.iterator();
        while (iterator3.hasNext()) {
            ((NodeImpl)iterator3.next()).write(byteBuffer);
        }
        while (stack.size() > 0) {
            Ns ns = (Ns)stack.pop();
            byteBuffer.putInt(1048833);
            byteBuffer.putInt(24);
            byteBuffer.putInt(ns.ln);
            byteBuffer.putInt(-1);
            byteBuffer.putInt(ns.prefix.index);
            byteBuffer.putInt(ns.uri.index);
        }
        return byteBuffer.array();
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
        String string = stringItem.data + n;
        StringItem stringItem2 = (StringItem)this.resourceId2Str.get((Object)string);
        if (stringItem2 != null) {
            return stringItem2;
        }
        StringItem stringItem3 = new StringItem(stringItem.data);
        this.resourceIds.add((Object)n);
        this.resourceString.add((Object)stringItem3);
        this.resourceId2Str.put((Object)string, (Object)stringItem3);
        return stringItem3;
    }

    static class Attr {
        public int index;
        public StringItem name;
        public StringItem ns;
        public StringItem raw;
        public int resourceId;
        public int type;
        public Object value;

        public Attr(StringItem stringItem, StringItem stringItem2, int n) {
            this.ns = stringItem;
            this.name = stringItem2;
            this.resourceId = n;
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
            if (this.raw != null) {
                this.raw = axmlWriter.update(this.raw);
            }
        }
    }

    static class NodeImpl
    extends NodeVisitor {
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
         * Exception decompiling
         */
        @Override
        public void attr(String var1_4, String var2_5, int var3_2, int var4_3, Object var5_1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
            // org.benf.cfr.reader.Main.doJar(Main.java:128)
            // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
            // java.lang.Thread.run(Thread.java:818)
            throw new IllegalStateException("Decompilation failed");
        }

        @Override
        public NodeVisitor child(String string, String string2) {
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
            int n = 0;
            for (Attr attr2 : this.attrs) {
                int n2 = n + 1;
                attr2.index = n;
                attr2.prepare(axmlWriter);
                n = n2;
            }
            this.text = axmlWriter.update(this.text);
            int n3 = 60 + 20 * this.attrs.size();
            Iterator iterator = this.children.iterator();
            while (iterator.hasNext()) {
                n3 += ((NodeImpl)iterator.next()).prepare(axmlWriter);
            }
            if (this.text != null) {
                n3 += 28;
            }
            return n3;
        }

        @Override
        public void text(int n, String string) {
            this.text = new StringItem(string);
            this.textLineNumber = n;
        }

        /*
         * Enabled aggressive block sorting
         */
        void write(ByteBuffer byteBuffer) throws IOException {
            int n = -1;
            byteBuffer.putInt(1048834);
            byteBuffer.putInt(36 + 20 * this.attrs.size());
            byteBuffer.putInt(this.line);
            byteBuffer.putInt(n);
            int n2 = this.ns != null ? this.ns.index : n;
            byteBuffer.putInt(n2);
            byteBuffer.putInt(this.name.index);
            byteBuffer.putInt(1310740);
            byteBuffer.putShort((short)this.attrs.size());
            int n3 = this.id == null ? 0 : 1 + this.id.index;
            byteBuffer.putShort((short)n3);
            int n4 = this.clz == null ? 0 : 1 + this.clz.index;
            byteBuffer.putShort((short)n4);
            int n5 = this.style == null ? 0 : 1 + this.style.index;
            byteBuffer.putShort((short)n5);
            for (Attr attr2 : this.attrs) {
                int n6 = attr2.ns == null ? n : attr2.ns.index;
                byteBuffer.putInt(n6);
                byteBuffer.putInt(attr2.name.index);
                int n7 = attr2.raw != null ? attr2.raw.index : n;
                byteBuffer.putInt(n7);
                byteBuffer.putInt(8 | attr2.type << 24);
                Object object = attr2.value;
                if (object instanceof StringItem) {
                    byteBuffer.putInt(((StringItem)attr2.value).index);
                    continue;
                }
                if (object instanceof Boolean) {
                    int n8 = Boolean.TRUE.equals(object) ? n : 0;
                    byteBuffer.putInt(n8);
                    continue;
                }
                byteBuffer.putInt(((Integer)attr2.value).intValue());
            }
            if (this.text != null) {
                byteBuffer.putInt(1048836);
                byteBuffer.putInt(28);
                byteBuffer.putInt(this.textLineNumber);
                byteBuffer.putInt(n);
                byteBuffer.putInt(this.text.index);
                byteBuffer.putInt(8);
                byteBuffer.putInt(0);
            }
            Iterator iterator = this.children.iterator();
            while (iterator.hasNext()) {
                ((NodeImpl)iterator.next()).write(byteBuffer);
            }
            byteBuffer.putInt(1048835);
            byteBuffer.putInt(24);
            byteBuffer.putInt(n);
            byteBuffer.putInt(n);
            if (this.ns != null) {
                n = this.ns.index;
            }
            byteBuffer.putInt(n);
            byteBuffer.putInt(this.name.index);
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

