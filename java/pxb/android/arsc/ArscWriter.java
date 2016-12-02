/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.TreeMap
 */
package pxb.android.arsc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import pxb.android.ResConst;
import pxb.android.StringItem;
import pxb.android.StringItems;
import pxb.android.arsc.ArscParser;
import pxb.android.arsc.BagValue;
import pxb.android.arsc.Config;
import pxb.android.arsc.Pkg;
import pxb.android.arsc.ResEntry;
import pxb.android.arsc.ResSpec;
import pxb.android.arsc.Type;
import pxb.android.arsc.Value;
import pxb.android.axml.Util;

public class ArscWriter
implements ResConst {
    private List<PkgCtx> ctxs = new ArrayList(5);
    private List<Pkg> pkgs;
    private Map<String, StringItem> strTable = new TreeMap();
    private StringItems strTable0 = new StringItems();

    public ArscWriter(List<Pkg> list) {
        this.pkgs = list;
    }

    private static /* varargs */ void D(String string, Object ... arrobject) {
    }

    private void addString(String string) {
        if (this.strTable.containsKey((Object)string)) {
            return;
        }
        StringItem stringItem = new StringItem(string);
        this.strTable.put((Object)string, (Object)stringItem);
        this.strTable0.add((Object)stringItem);
    }

    private int count() {
        0 + 12;
        int n = this.strTable0.getSize();
        if (n % 4 != 0) {
            n += 4 - n % 4;
        }
        int n2 = 12 + (n + 8);
        for (PkgCtx pkgCtx : this.ctxs) {
            int n3;
            pkgCtx.offset = n2;
            pkgCtx.typeStringOff = 16 + (0 + 268);
            int n4 = pkgCtx.typeNames0.getSize();
            if (n4 % 4 != 0) {
                n4 += 4 - n4 % 4;
            }
            pkgCtx.keyStringOff = n3 = 284 + (n4 + 8);
            int n5 = pkgCtx.keyNames0.getSize();
            if (n5 % 4 != 0) {
                n5 += 4 - n5 % 4;
            }
            int n6 = n3 + (n5 + 8);
            for (Type type : pkgCtx.pkg.types.values()) {
                type.wPosition = n2 + n6;
                n6 += 16 + 4 * type.specs.length;
                for (Config config : type.configs) {
                    config.wPosition = n6 + n2;
                    int n7 = n6;
                    int n8 = n6 + 20;
                    int n9 = config.id.length;
                    if (n9 % 4 != 0) {
                        n9 += 4 - n9 % 4;
                    }
                    if (n8 + n9 - n7 > 56) {
                        throw new RuntimeException("config id  too big");
                    }
                    n6 = n7 + 56 + 4 * config.entryCount;
                    config.wEntryStart = n6 - n7;
                    int n10 = n6;
                    for (ResEntry resEntry : config.resources.values()) {
                        resEntry.wOffset = n6 - n10;
                        int n11 = n6 + 8;
                        if (resEntry.value instanceof BagValue) {
                            n6 = n11 + (8 + 12 * ((BagValue)resEntry.value).map.size());
                            continue;
                        }
                        n6 = n11 + 8;
                    }
                    config.wChunkSize = n6 - n7;
                }
            }
            pkgCtx.pkgSize = n6;
            n2 += n6;
        }
        return n2;
    }

    public static /* varargs */ void main(String ... arrstring) throws IOException {
        if (arrstring.length < 2) {
            System.err.println("asrc-write-test in.arsc out.arsc");
            return;
        }
        Util.writeFile(new ArscWriter(new ArscParser(Util.readFile(new File(arrstring[0]))).parse()).toByteArray(), new File(arrstring[1]));
    }

    private List<PkgCtx> prepare() throws IOException {
        for (Pkg pkg : this.pkgs) {
            PkgCtx pkgCtx = new PkgCtx(null);
            pkgCtx.pkg = pkg;
            this.ctxs.add((Object)pkgCtx);
            for (Type type : pkg.types.values()) {
                pkgCtx.addTypeName(-1 + type.id, type.name);
                ResSpec[] arrresSpec = type.specs;
                int n = arrresSpec.length;
                for (int i = 0; i < n; ++i) {
                    pkgCtx.addKeyName(arrresSpec[i].name);
                }
                Iterator iterator = type.configs.iterator();
                while (iterator.hasNext()) {
                    Iterator iterator2 = ((Config)iterator.next()).resources.values().iterator();
                    while (iterator2.hasNext()) {
                        Object object = ((ResEntry)iterator2.next()).value;
                        if (object instanceof BagValue) {
                            this.travelBagValue((BagValue)object);
                            continue;
                        }
                        this.travelValue((Value)object);
                    }
                }
            }
            pkgCtx.keyNames0.prepare();
            pkgCtx.typeNames0.addAll(pkgCtx.typeNames);
            pkgCtx.typeNames0.prepare();
        }
        this.strTable0.prepare();
        return this.ctxs;
    }

    private void travelBagValue(BagValue bagValue) {
        Iterator iterator = bagValue.map.iterator();
        while (iterator.hasNext()) {
            super.travelValue((Value)((Map.Entry)iterator.next()).getValue());
        }
    }

    private void travelValue(Value value) {
        if (value.raw != null) {
            super.addString(value.raw);
        }
    }

    /*
     * Exception decompiling
     */
    private void write(ByteBuffer var1, int var2_2) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[DOLOOP]], but top level block is 3[DOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    private void writeValue(Value value, ByteBuffer byteBuffer) {
        byteBuffer.putShort(8);
        byteBuffer.put(0);
        byteBuffer.put((byte)value.type);
        if (value.type == 3) {
            byteBuffer.putInt(((StringItem)this.strTable.get((Object)value.raw)).index);
            return;
        }
        byteBuffer.putInt(value.data);
    }

    public byte[] toByteArray() throws IOException {
        this.prepare();
        int n = this.count();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)n).order(ByteOrder.LITTLE_ENDIAN);
        this.write(byteBuffer, n);
        return byteBuffer.array();
    }

    private static class PkgCtx {
        Map<String, StringItem> keyNames;
        StringItems keyNames0;
        public int keyStringOff;
        int offset;
        Pkg pkg;
        int pkgSize;
        List<StringItem> typeNames;
        StringItems typeNames0;
        int typeStringOff;

        private PkgCtx() {
            this.keyNames = new HashMap();
            this.keyNames0 = new StringItems();
            this.typeNames = new ArrayList();
            this.typeNames0 = new StringItems();
        }

        /* synthetic */ PkgCtx( var1) {
        }

        public void addKeyName(String string) {
            if (this.keyNames.containsKey((Object)string)) {
                return;
            }
            StringItem stringItem = new StringItem(string);
            this.keyNames.put((Object)string, (Object)stringItem);
            this.keyNames0.add((Object)stringItem);
        }

        public void addTypeName(int n, String string) {
            while (this.typeNames.size() <= n) {
                this.typeNames.add((Object)null);
            }
            if ((StringItem)this.typeNames.get(n) == null) {
                this.typeNames.set(n, (Object)new StringItem(string));
                return;
            }
            throw new RuntimeException();
        }
    }

}

