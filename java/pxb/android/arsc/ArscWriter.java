package pxb.android.arsc;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import pxb.android.ResConst;
import pxb.android.StringItem;
import pxb.android.StringItems;
import pxb.android.axml.Util;

public class ArscWriter implements ResConst {
    private List<PkgCtx> ctxs = new ArrayList(5);
    private List<Pkg> pkgs;
    private Map<String, StringItem> strTable = new TreeMap();
    private StringItems strTable0 = new StringItems();

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

        public void addKeyName(String name) {
            if (!this.keyNames.containsKey(name)) {
                StringItem stringItem = new StringItem(name);
                this.keyNames.put(name, stringItem);
                this.keyNames0.add(stringItem);
            }
        }

        public void addTypeName(int id, String name) {
            while (this.typeNames.size() <= id) {
                this.typeNames.add(null);
            }
            if (((StringItem) this.typeNames.get(id)) == null) {
                this.typeNames.set(id, new StringItem(name));
                return;
            }
            throw new RuntimeException();
        }
    }

    private static void D(String fmt, Object... args) {
    }

    public ArscWriter(List<Pkg> pkgs) {
        this.pkgs = pkgs;
    }

    public static void main(String... args) throws IOException {
        if (args.length < 2) {
            System.err.println("asrc-write-test in.arsc out.arsc");
        } else {
            Util.writeFile(new ArscWriter(new ArscParser(Util.readFile(new File(args[0]))).parse()).toByteArray(), new File(args[1]));
        }
    }

    private void addString(String str) {
        if (!this.strTable.containsKey(str)) {
            StringItem stringItem = new StringItem(str);
            this.strTable.put(str, stringItem);
            this.strTable0.add(stringItem);
        }
    }

    private int count() {
        int size = 0 + 12;
        int stringSize = this.strTable0.getSize();
        if (stringSize % 4 != 0) {
            stringSize += 4 - (stringSize % 4);
        }
        size = (stringSize + 8) + 12;
        for (PkgCtx ctx : this.ctxs) {
            ctx.offset = size;
            ctx.typeStringOff = (0 + 268) + 16;
            stringSize = ctx.typeNames0.getSize();
            if (stringSize % 4 != 0) {
                stringSize += 4 - (stringSize % 4);
            }
            int pkgSize = (stringSize + 8) + 284;
            ctx.keyStringOff = pkgSize;
            stringSize = ctx.keyNames0.getSize();
            if (stringSize % 4 != 0) {
                stringSize += 4 - (stringSize % 4);
            }
            pkgSize += stringSize + 8;
            for (Type type : ctx.pkg.types.values()) {
                type.wPosition = size + pkgSize;
                pkgSize += (type.specs.length * 4) + 16;
                for (Config config : type.configs) {
                    config.wPosition = pkgSize + size;
                    int configBasePostion = pkgSize;
                    pkgSize += 20;
                    int size0 = config.id.length;
                    if (size0 % 4 != 0) {
                        size0 += 4 - (size0 % 4);
                    }
                    if ((pkgSize + size0) - configBasePostion > 56) {
                        throw new RuntimeException("config id  too big");
                    }
                    pkgSize = (configBasePostion + 56) + (config.entryCount * 4);
                    config.wEntryStart = pkgSize - configBasePostion;
                    int entryBase = pkgSize;
                    for (ResEntry e : config.resources.values()) {
                        e.wOffset = pkgSize - entryBase;
                        pkgSize += 8;
                        if (e.value instanceof BagValue) {
                            pkgSize += (e.value.map.size() * 12) + 8;
                        } else {
                            pkgSize += 8;
                        }
                    }
                    config.wChunkSize = pkgSize - configBasePostion;
                }
            }
            ctx.pkgSize = pkgSize;
            size += pkgSize;
        }
        return size;
    }

    private List<PkgCtx> prepare() throws IOException {
        for (Pkg pkg : this.pkgs) {
            PkgCtx ctx = new PkgCtx();
            ctx.pkg = pkg;
            this.ctxs.add(ctx);
            for (Type type : pkg.types.values()) {
                ctx.addTypeName(type.id - 1, type.name);
                for (ResSpec spec : type.specs) {
                    ctx.addKeyName(spec.name);
                }
                for (Config config : type.configs) {
                    for (ResEntry e : config.resources.values()) {
                        Object object = e.value;
                        if (object instanceof BagValue) {
                            travelBagValue((BagValue) object);
                        } else {
                            travelValue((Value) object);
                        }
                    }
                }
            }
            ctx.keyNames0.prepare();
            ctx.typeNames0.addAll(ctx.typeNames);
            ctx.typeNames0.prepare();
        }
        this.strTable0.prepare();
        return this.ctxs;
    }

    public byte[] toByteArray() throws IOException {
        prepare();
        int size = count();
        ByteBuffer out = ByteBuffer.allocate(size).order(ByteOrder.LITTLE_ENDIAN);
        write(out, size);
        return out.array();
    }

    private void travelBagValue(BagValue bag) {
        for (Entry<Integer, Value> e : bag.map) {
            travelValue((Value) e.getValue());
        }
    }

    private void travelValue(Value v) {
        if (v.raw != null) {
            addString(v.raw);
        }
    }

    private void write(ByteBuffer out, int size) throws IOException {
        out.putInt(786434);
        out.putInt(size);
        out.putInt(this.ctxs.size());
        int stringSize = this.strTable0.getSize();
        int padding = 0;
        if (stringSize % 4 != 0) {
            padding = 4 - (stringSize % 4);
        }
        out.putInt(1835009);
        out.putInt((stringSize + padding) + 8);
        this.strTable0.write(out);
        out.put(new byte[padding]);
        for (PkgCtx pctx : this.ctxs) {
            if (out.position() != pctx.offset) {
                throw new RuntimeException();
            }
            int basePosition = out.position();
            out.putInt(18612736);
            out.putInt(pctx.pkgSize);
            out.putInt(pctx.pkg.id);
            int p = out.position();
            out.put(pctx.pkg.name.getBytes("UTF-16LE"));
            out.position(p + ResConst.RES_XML_START_NAMESPACE_TYPE);
            out.putInt(pctx.typeStringOff);
            out.putInt(pctx.typeNames0.size());
            out.putInt(pctx.keyStringOff);
            out.putInt(pctx.keyNames0.size());
            if (out.position() - basePosition != pctx.typeStringOff) {
                throw new RuntimeException();
            }
            stringSize = pctx.typeNames0.getSize();
            padding = 0;
            if (stringSize % 4 != 0) {
                padding = 4 - (stringSize % 4);
            }
            out.putInt(1835009);
            out.putInt((stringSize + padding) + 8);
            pctx.typeNames0.write(out);
            out.put(new byte[padding]);
            if (out.position() - basePosition != pctx.keyStringOff) {
                throw new RuntimeException();
            }
            stringSize = pctx.keyNames0.getSize();
            padding = 0;
            if (stringSize % 4 != 0) {
                padding = 4 - (stringSize % 4);
            }
            out.putInt(1835009);
            out.putInt((stringSize + padding) + 8);
            pctx.keyNames0.write(out);
            out.put(new byte[padding]);
            for (Type t : pctx.pkg.types.values()) {
                D("[%08x]write spec", Integer.valueOf(out.position()), t.name);
                if (t.wPosition != out.position()) {
                    throw new RuntimeException();
                }
                out.putInt(1049090);
                out.putInt((t.specs.length * 4) + 16);
                out.putInt(t.id);
                out.putInt(t.specs.length);
                for (ResSpec spec : t.specs) {
                    out.putInt(spec.flags);
                }
                for (Config config : t.configs) {
                    D("[%08x]write config", Integer.valueOf(out.position()));
                    int typeConfigPosition = out.position();
                    if (config.wPosition != typeConfigPosition) {
                        throw new RuntimeException();
                    }
                    out.putInt(3670529);
                    out.putInt(config.wChunkSize);
                    out.putInt(t.id);
                    out.putInt(t.specs.length);
                    out.putInt(config.wEntryStart);
                    D("[%08x]write config ids", Integer.valueOf(out.position()));
                    out.put(config.id);
                    int size0 = config.id.length;
                    padding = 0;
                    if (size0 % 4 != 0) {
                        padding = 4 - (size0 % 4);
                    }
                    out.put(new byte[padding]);
                    out.position(typeConfigPosition + 56);
                    D("[%08x]write config entry offsets", Integer.valueOf(out.position()));
                    for (int i = 0; i < config.entryCount; i++) {
                        ResEntry entry = (ResEntry) config.resources.get(Integer.valueOf(i));
                        if (entry == null) {
                            out.putInt(-1);
                        } else {
                            out.putInt(entry.wOffset);
                        }
                    }
                    if (out.position() - typeConfigPosition != config.wEntryStart) {
                        throw new RuntimeException();
                    }
                    D("[%08x]write config entrys", Integer.valueOf(out.position()));
                    for (ResEntry e : config.resources.values()) {
                        D("[%08x]ResTable_entry", Integer.valueOf(out.position()));
                        boolean isBag = e.value instanceof BagValue;
                        out.putShort((short) (isBag ? 16 : 8));
                        int flag = e.flag;
                        if (isBag) {
                            flag |= 1;
                        } else {
                            flag &= -2;
                        }
                        out.putShort((short) flag);
                        out.putInt(((StringItem) pctx.keyNames.get(e.spec.name)).index);
                        if (isBag) {
                            BagValue bag = e.value;
                            out.putInt(bag.parent);
                            out.putInt(bag.map.size());
                            for (Entry<Integer, Value> entry2 : bag.map) {
                                out.putInt(((Integer) entry2.getKey()).intValue());
                                writeValue((Value) entry2.getValue(), out);
                            }
                        } else {
                            writeValue((Value) e.value, out);
                        }
                    }
                }
            }
        }
    }

    private void writeValue(Value value, ByteBuffer out) {
        out.putShort((short) 8);
        out.put((byte) 0);
        out.put((byte) value.type);
        if (value.type == 3) {
            out.putInt(((StringItem) this.strTable.get(value.raw)).index);
        } else {
            out.putInt(value.data);
        }
    }
}
