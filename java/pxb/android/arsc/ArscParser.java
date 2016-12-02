package pxb.android.arsc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import pxb.android.ResConst;
import pxb.android.StringItems;
import pxb.android.axmlLP.AxmlVisitor;

public class ArscParser implements ResConst {
    private static final boolean DEBUG = false;
    static final int ENGRY_FLAG_PUBLIC = 2;
    static final short ENTRY_FLAG_COMPLEX = (short) 1;
    public static final int TYPE_STRING = 3;
    private int fileSize = -1;
    private ByteBuffer in;
    private String[] keyNamesX;
    private Pkg pkg;
    private List<Pkg> pkgs = new ArrayList();
    private String[] strings;
    private String[] typeNamesX;

    class Chunk {
        public final int headSize;
        public final int location;
        public final int size;
        public final int type;

        public Chunk() {
            this.location = ArscParser.this.in.position();
            this.type = ArscParser.this.in.getShort() & InternalZipConstants.MAX_ALLOWED_ZIP_COMMENT_LENGTH;
            this.headSize = ArscParser.this.in.getShort() & InternalZipConstants.MAX_ALLOWED_ZIP_COMMENT_LENGTH;
            this.size = ArscParser.this.in.getInt();
            ArscParser.D("[%08x]type: %04x, headsize: %04x, size:%08x", Integer.valueOf(this.location), Integer.valueOf(this.type), Integer.valueOf(this.headSize), Integer.valueOf(this.size));
        }
    }

    private static void D(String fmt, Object... args) {
    }

    public ArscParser(byte[] b) {
        this.in = ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN);
    }

    public List<Pkg> parse() throws IOException {
        if (this.fileSize < 0) {
            Chunk head = new Chunk();
            if (head.type != ENGRY_FLAG_PUBLIC) {
                throw new RuntimeException();
            }
            this.fileSize = head.size;
            this.in.getInt();
        }
        while (this.in.hasRemaining()) {
            Chunk chunk = new Chunk();
            switch (chunk.type) {
                case AxmlVisitor.TYPE_REFERENCE /*1*/:
                    this.strings = StringItems.read(this.in);
                    break;
                case ResConst.RES_TABLE_PACKAGE_TYPE /*512*/:
                    readPackage(this.in);
                    break;
                default:
                    break;
            }
            this.in.position(chunk.location + chunk.size);
        }
        return this.pkgs;
    }

    private void readEntry(Config config, ResSpec spec) {
        D("[%08x]read ResTable_entry", Integer.valueOf(this.in.position()));
        int size = this.in.getShort();
        D("ResTable_entry %d", Integer.valueOf(size));
        int flags = this.in.getShort();
        spec.updateName(this.keyNamesX[this.in.getInt()]);
        ResEntry resEntry = new ResEntry(flags, spec);
        if ((flags & 1) != 0) {
            int parent = this.in.getInt();
            int count = this.in.getInt();
            BagValue bag = new BagValue(parent);
            for (int i = 0; i < count; i++) {
                bag.map.add(new SimpleEntry(Integer.valueOf(this.in.getInt()), readValue()));
            }
            resEntry.value = bag;
        } else {
            resEntry.value = readValue();
        }
        config.resources.put(Integer.valueOf(spec.id), resEntry);
    }

    private void readPackage(ByteBuffer in) throws IOException {
        int i;
        int pid = in.getInt() % 255;
        int nextPisition = in.position() + ResConst.RES_XML_START_NAMESPACE_TYPE;
        StringBuilder stringBuilder = new StringBuilder(32);
        for (i = 0; i < 128; i++) {
            int s = in.getShort();
            if (s == 0) {
                break;
            }
            stringBuilder.append((char) s);
        }
        String name = stringBuilder.toString();
        in.position(nextPisition);
        this.pkg = new Pkg(pid, name);
        this.pkgs.add(this.pkg);
        int typeStringOff = in.getInt();
        int typeNameCount = in.getInt();
        int keyStringOff = in.getInt();
        int specNameCount = in.getInt();
        Chunk chunk = new Chunk();
        if (chunk.type != 1) {
            throw new RuntimeException();
        }
        this.typeNamesX = StringItems.read(in);
        in.position(chunk.location + chunk.size);
        chunk = new Chunk();
        if (chunk.type != 1) {
            throw new RuntimeException();
        }
        this.keyNamesX = StringItems.read(in);
        in.position(chunk.location + chunk.size);
        while (in.hasRemaining()) {
            chunk = new Chunk();
            int tid;
            int entryCount;
            Type t;
            switch (chunk.type) {
                case ResConst.RES_TABLE_TYPE_TYPE /*513*/:
                    D("[%08x]read config", Integer.valueOf(in.position() - 8));
                    tid = in.get() & 255;
                    in.get();
                    in.getShort();
                    entryCount = in.getInt();
                    t = this.pkg.getType(tid, this.typeNamesX[tid - 1], entryCount);
                    int entriesStart = in.getInt();
                    D("[%08x]read config id", Integer.valueOf(in.position()));
                    byte[] data = new byte[in.getInt()];
                    in.position(in.position());
                    in.get(data);
                    Config config = new Config(data, entryCount);
                    in.position(chunk.location + chunk.headSize);
                    D("[%08x]read config entry offset", Integer.valueOf(in.position()));
                    int[] entrys = new int[entryCount];
                    for (i = 0; i < entryCount; i++) {
                        entrys[i] = in.getInt();
                    }
                    D("[%08x]read config entrys", Integer.valueOf(in.position()));
                    for (i = 0; i < entrys.length; i++) {
                        if (entrys[i] != -1) {
                            in.position((chunk.location + entriesStart) + entrys[i]);
                            readEntry(config, t.getSpec(i));
                        }
                    }
                    t.addConfig(config);
                    break;
                case ResConst.RES_TABLE_TYPE_SPEC_TYPE /*514*/:
                    D("[%08x]read spec", Integer.valueOf(in.position() - 8));
                    tid = in.get() & 255;
                    in.get();
                    in.getShort();
                    entryCount = in.getInt();
                    t = this.pkg.getType(tid, this.typeNamesX[tid - 1], entryCount);
                    for (i = 0; i < entryCount; i++) {
                        t.getSpec(i).flags = in.getInt();
                    }
                    break;
                default:
                    return;
            }
            in.position(chunk.location + chunk.size);
        }
    }

    private Object readValue() {
        int size1 = this.in.getShort();
        int zero = this.in.get();
        int type = this.in.get() & 255;
        int data = this.in.getInt();
        String raw = null;
        if (type == TYPE_STRING) {
            raw = this.strings[data];
        }
        return new Value(type, data, raw);
    }
}
