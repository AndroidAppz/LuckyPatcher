package pxb.android.axml;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import pxb.android.ResConst;
import pxb.android.axmlLP.AxmlVisitor;

public class AxmlParser implements ResConst {
    public static final int END_FILE = 7;
    public static final int END_NS = 5;
    public static final int END_TAG = 3;
    public static final int START_FILE = 1;
    public static final int START_NS = 4;
    public static final int START_TAG = 2;
    public static final int TEXT = 6;
    private int attributeCount;
    private IntBuffer attrs;
    private int classAttribute;
    private int fileSize;
    private int idAttribute;
    private ByteBuffer in;
    private int lineNumber;
    private int nameIdx;
    private int nsIdx;
    private int prefixIdx;
    private int[] resourceIds;
    private String[] strings;
    private int styleAttribute;
    private int textIdx;

    public AxmlParser(byte[] data) {
        this(ByteBuffer.wrap(data));
    }

    public AxmlParser(ByteBuffer in) {
        this.fileSize = -1;
        this.in = in.order(ByteOrder.LITTLE_ENDIAN);
    }

    public int getAttrCount() {
        return this.attributeCount;
    }

    public int getAttributeCount() {
        return this.attributeCount;
    }

    public String getAttrName(int i) {
        return this.strings[this.attrs.get((i * END_NS) + START_FILE)];
    }

    public String getAttrNs(int i) {
        int idx = this.attrs.get((i * END_NS) + 0);
        return idx >= 0 ? this.strings[idx] : null;
    }

    String getAttrRawString(int i) {
        int idx = this.attrs.get((i * END_NS) + START_TAG);
        if (idx >= 0) {
            return this.strings[idx];
        }
        return null;
    }

    public int getAttrResId(int i) {
        if (this.resourceIds != null) {
            int idx = this.attrs.get((i * END_NS) + START_FILE);
            if (idx >= 0 && idx < this.resourceIds.length) {
                return this.resourceIds[idx];
            }
        }
        return -1;
    }

    public int getAttrType(int i) {
        return this.attrs.get((i * END_NS) + END_TAG) >> 24;
    }

    public Object getAttrValue(int i) {
        int v = this.attrs.get((i * END_NS) + START_NS);
        if (i == this.idAttribute) {
            return ValueWrapper.wrapId(v, getAttrRawString(i));
        }
        if (i == this.styleAttribute) {
            return ValueWrapper.wrapStyle(v, getAttrRawString(i));
        }
        if (i == this.classAttribute) {
            return ValueWrapper.wrapClass(v, getAttrRawString(i));
        }
        switch (getAttrType(i)) {
            case END_TAG /*3*/:
                return this.strings[v];
            case AxmlVisitor.TYPE_INT_BOOLEAN /*18*/:
                return Boolean.valueOf(v != 0);
            default:
                return Integer.valueOf(v);
        }
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getName() {
        return this.strings[this.nameIdx];
    }

    public String getNamespacePrefix() {
        return this.strings[this.prefixIdx];
    }

    public String getNamespaceUri() {
        return this.nsIdx >= 0 ? this.strings[this.nsIdx] : null;
    }

    public String getText() {
        return this.strings[this.textIdx];
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int next() throws java.io.IOException {
        /*
        r10 = this;
        r9 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r7 = r10.fileSize;
        if (r7 >= 0) goto L_0x0022;
    L_0x0007:
        r7 = r10.in;
        r7 = r7.getInt();
        r6 = r7 & r9;
        r7 = 3;
        if (r6 == r7) goto L_0x0018;
    L_0x0012:
        r7 = new java.lang.RuntimeException;
        r7.<init>();
        throw r7;
    L_0x0018:
        r7 = r10.in;
        r7 = r7.getInt();
        r10.fileSize = r7;
        r1 = 1;
    L_0x0021:
        return r1;
    L_0x0022:
        r1 = -1;
        r7 = r10.in;
        r4 = r7.position();
    L_0x0029:
        r7 = r10.fileSize;
        if (r4 >= r7) goto L_0x0138;
    L_0x002d:
        r7 = r10.in;
        r7 = r7.getInt();
        r6 = r7 & r9;
        r7 = r10.in;
        r5 = r7.getInt();
        switch(r6) {
            case 1: goto L_0x00df;
            case 256: goto L_0x00b7;
            case 257: goto L_0x00d6;
            case 258: goto L_0x0044;
            case 259: goto L_0x00ae;
            case 260: goto L_0x0116;
            case 384: goto L_0x00f6;
            default: goto L_0x003e;
        };
    L_0x003e:
        r7 = new java.lang.RuntimeException;
        r7.<init>();
        throw r7;
    L_0x0044:
        r7 = r10.in;
        r7 = r7.getInt();
        r10.lineNumber = r7;
        r7 = r10.in;
        r7.getInt();
        r7 = r10.in;
        r7 = r7.getInt();
        r10.nsIdx = r7;
        r7 = r10.in;
        r7 = r7.getInt();
        r10.nameIdx = r7;
        r7 = r10.in;
        r2 = r7.getInt();
        r7 = 1310740; // 0x140014 float:1.836738E-39 double:6.475916E-318;
        if (r2 == r7) goto L_0x0072;
    L_0x006c:
        r7 = new java.lang.RuntimeException;
        r7.<init>();
        throw r7;
    L_0x0072:
        r7 = r10.in;
        r7 = r7.getShort();
        r7 = r7 & r9;
        r10.attributeCount = r7;
        r7 = r10.in;
        r7 = r7.getShort();
        r7 = r7 & r9;
        r7 = r7 + -1;
        r10.idAttribute = r7;
        r7 = r10.in;
        r7 = r7.getShort();
        r7 = r7 & r9;
        r7 = r7 + -1;
        r10.classAttribute = r7;
        r7 = r10.in;
        r7 = r7.getShort();
        r7 = r7 & r9;
        r7 = r7 + -1;
        r10.styleAttribute = r7;
        r7 = r10.in;
        r7 = r7.asIntBuffer();
        r10.attrs = r7;
        r1 = 2;
    L_0x00a5:
        r7 = r10.in;
        r8 = r4 + r5;
        r7.position(r8);
        goto L_0x0021;
    L_0x00ae:
        r7 = r10.in;
        r8 = r4 + r5;
        r7.position(r8);
        r1 = 3;
        goto L_0x00a5;
    L_0x00b7:
        r7 = r10.in;
        r7 = r7.getInt();
        r10.lineNumber = r7;
        r7 = r10.in;
        r7.getInt();
        r7 = r10.in;
        r7 = r7.getInt();
        r10.prefixIdx = r7;
        r7 = r10.in;
        r7 = r7.getInt();
        r10.nsIdx = r7;
        r1 = 4;
        goto L_0x00a5;
    L_0x00d6:
        r7 = r10.in;
        r8 = r4 + r5;
        r7.position(r8);
        r1 = 5;
        goto L_0x00a5;
    L_0x00df:
        r7 = r10.in;
        r7 = pxb.android.StringItems.read(r7);
        r10.strings = r7;
        r7 = r10.in;
        r8 = r4 + r5;
        r7.position(r8);
    L_0x00ee:
        r7 = r10.in;
        r4 = r7.position();
        goto L_0x0029;
    L_0x00f6:
        r7 = r5 / 4;
        r0 = r7 + -2;
        r7 = new int[r0];
        r10.resourceIds = r7;
        r3 = 0;
    L_0x00ff:
        if (r3 >= r0) goto L_0x010e;
    L_0x0101:
        r7 = r10.resourceIds;
        r8 = r10.in;
        r8 = r8.getInt();
        r7[r3] = r8;
        r3 = r3 + 1;
        goto L_0x00ff;
    L_0x010e:
        r7 = r10.in;
        r8 = r4 + r5;
        r7.position(r8);
        goto L_0x00ee;
    L_0x0116:
        r7 = r10.in;
        r7 = r7.getInt();
        r10.lineNumber = r7;
        r7 = r10.in;
        r7.getInt();
        r7 = r10.in;
        r7 = r7.getInt();
        r10.textIdx = r7;
        r7 = r10.in;
        r7.getInt();
        r7 = r10.in;
        r7.getInt();
        r1 = 6;
        goto L_0x00a5;
    L_0x0138:
        r1 = 7;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: pxb.android.axml.AxmlParser.next():int");
    }
}
