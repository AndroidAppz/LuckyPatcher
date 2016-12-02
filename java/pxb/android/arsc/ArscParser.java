/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.AbstractMap
 *  java.util.AbstractMap$SimpleEntry
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 */
package pxb.android.arsc;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pxb.android.ResConst;
import pxb.android.StringItems;
import pxb.android.arsc.BagValue;
import pxb.android.arsc.Config;
import pxb.android.arsc.Pkg;
import pxb.android.arsc.ResEntry;
import pxb.android.arsc.ResSpec;
import pxb.android.arsc.Type;
import pxb.android.arsc.Value;

public class ArscParser
implements ResConst {
    private static final boolean DEBUG = false;
    static final int ENGRY_FLAG_PUBLIC = 2;
    static final short ENTRY_FLAG_COMPLEX = 1;
    public static final int TYPE_STRING = 3;
    private int fileSize = -1;
    private ByteBuffer in;
    private String[] keyNamesX;
    private Pkg pkg;
    private List<Pkg> pkgs = new ArrayList();
    private String[] strings;
    private String[] typeNamesX;

    public ArscParser(byte[] arrby) {
        this.in = ByteBuffer.wrap((byte[])arrby).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static /* varargs */ void D(String string, Object ... arrobject) {
    }

    /*
     * Enabled aggressive block sorting
     */
    private void readEntry(Config config, ResSpec resSpec) {
        Object[] arrobject = new Object[]{this.in.position()};
        ArscParser.D("[%08x]read ResTable_entry", arrobject);
        short s = this.in.getShort();
        Object[] arrobject2 = new Object[]{s};
        ArscParser.D("ResTable_entry %d", arrobject2);
        short s2 = this.in.getShort();
        int n = this.in.getInt();
        resSpec.updateName(this.keyNamesX[n]);
        ResEntry resEntry = new ResEntry(s2, resSpec);
        if ((s2 & 1) != 0) {
            int n2 = this.in.getInt();
            int n3 = this.in.getInt();
            BagValue bagValue = new BagValue(n2);
            for (int i = 0; i < n3; ++i) {
                AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry((Object)this.in.getInt(), super.readValue());
                bagValue.map.add((Object)simpleEntry);
            }
            resEntry.value = bagValue;
        } else {
            resEntry.value = super.readValue();
        }
        config.resources.put((Object)resSpec.id, (Object)resEntry);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void readPackage(ByteBuffer byteBuffer) throws IOException {
        int n = byteBuffer.getInt() % 255;
        int n2 = 256 + byteBuffer.position();
        StringBuilder stringBuilder = new StringBuilder(32);
        int n3 = 0;
        do {
            short s;
            if (n3 >= 128 || (s = byteBuffer.getShort()) == 0) {
                Pkg pkg;
                String string = stringBuilder.toString();
                byteBuffer.position(n2);
                this.pkg = pkg = new Pkg(n, string);
                this.pkgs.add((Object)this.pkg);
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                byteBuffer.getInt();
                Chunk chunk = (ArscParser)this.new Chunk();
                if (chunk.type == 1) break;
                throw new RuntimeException();
            }
            stringBuilder.append((char)s);
            ++n3;
        } while (true);
        this.typeNamesX = StringItems.read(byteBuffer);
        byteBuffer.position(chunk.location + chunk.size);
        Chunk chunk = (ArscParser)this.new Chunk();
        if (chunk.type != 1) {
            throw new RuntimeException();
        }
        this.keyNamesX = StringItems.read(byteBuffer);
        byteBuffer.position(chunk.location + chunk.size);
        while (byteBuffer.hasRemaining()) {
            Chunk chunk2 = (ArscParser)this.new Chunk();
            switch (chunk2.type) {
                default: {
                    return;
                }
                case 514: {
                    Object[] arrobject = new Object[]{-8 + byteBuffer.position()};
                    ArscParser.D("[%08x]read spec", arrobject);
                    int n4 = 255 & byteBuffer.get();
                    byteBuffer.get();
                    byteBuffer.getShort();
                    int n5 = byteBuffer.getInt();
                    Type type = this.pkg.getType(n4, this.typeNamesX[n4 - 1], n5);
                    for (int i = 0; i < n5; ++i) {
                        type.getSpec((int)i).flags = byteBuffer.getInt();
                    }
                    break;
                }
                case 513: {
                    Object[] arrobject = new Object[]{-8 + byteBuffer.position()};
                    ArscParser.D("[%08x]read config", arrobject);
                    int n6 = 255 & byteBuffer.get();
                    byteBuffer.get();
                    byteBuffer.getShort();
                    int n7 = byteBuffer.getInt();
                    Type type = this.pkg.getType(n6, this.typeNamesX[n6 - 1], n7);
                    int n8 = byteBuffer.getInt();
                    Object[] arrobject2 = new Object[]{byteBuffer.position()};
                    ArscParser.D("[%08x]read config id", arrobject2);
                    int n9 = byteBuffer.position();
                    byte[] arrby = new byte[byteBuffer.getInt()];
                    byteBuffer.position(n9);
                    byteBuffer.get(arrby);
                    Config config = new Config(arrby, n7);
                    byteBuffer.position(chunk2.location + chunk2.headSize);
                    Object[] arrobject3 = new Object[]{byteBuffer.position()};
                    ArscParser.D("[%08x]read config entry offset", arrobject3);
                    int[] arrn = new int[n7];
                    for (int i = 0; i < n7; ++i) {
                        arrn[i] = byteBuffer.getInt();
                    }
                    Object[] arrobject4 = new Object[]{byteBuffer.position()};
                    ArscParser.D("[%08x]read config entrys", arrobject4);
                    for (int j = 0; j < arrn.length; ++j) {
                        if (arrn[j] == -1) continue;
                        byteBuffer.position(n8 + chunk2.location + arrn[j]);
                        super.readEntry(config, type.getSpec(j));
                    }
                    type.addConfig(config);
                }
            }
            byteBuffer.position(chunk2.location + chunk2.size);
        }
    }

    private Object readValue() {
        this.in.getShort();
        this.in.get();
        int n = 255 & this.in.get();
        int n2 = this.in.getInt();
        String string = null;
        if (n == 3) {
            string = this.strings[n2];
        }
        return new Value(n, n2, string);
    }

    /*
     * Enabled aggressive block sorting
     */
    public List<Pkg> parse() throws IOException {
        if (this.fileSize < 0) {
            Chunk chunk = new Chunk();
            if (chunk.type != 2) {
                throw new RuntimeException();
            }
            this.fileSize = chunk.size;
            this.in.getInt();
        }
        while (this.in.hasRemaining()) {
            Chunk chunk = new Chunk();
            switch (chunk.type) {
                case 1: {
                    this.strings = StringItems.read(this.in);
                }
                default: {
                    break;
                }
                case 512: {
                    this.readPackage(this.in);
                }
            }
            this.in.position(chunk.location + chunk.size);
        }
        return this.pkgs;
    }

    class Chunk {
        public final int headSize;
        public final int location;
        public final int size;
        public final int type;

        public Chunk() {
            this.location = ArscParser.this.in.position();
            this.type = 65535 & ArscParser.this.in.getShort();
            this.headSize = 65535 & ArscParser.this.in.getShort();
            this.size = ArscParser.this.in.getInt();
            Object[] arrobject = new Object[]{this.location, this.type, this.headSize, this.size};
            ArscParser.D("[%08x]type: %04x, headsize: %04x, size:%08x", arrobject);
        }
    }

}

