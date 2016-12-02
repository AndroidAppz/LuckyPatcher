/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.IntBuffer
 */
package pxb.android.axml;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import pxb.android.ResConst;
import pxb.android.StringItems;
import pxb.android.axml.ValueWrapper;

public class AxmlParser
implements ResConst {
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

    public AxmlParser(ByteBuffer byteBuffer) {
        this.fileSize = -1;
        this.in = byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public AxmlParser(byte[] arrby) {
        super(ByteBuffer.wrap((byte[])arrby));
    }

    public int getAttrCount() {
        return this.attributeCount;
    }

    public String getAttrName(int n) {
        int n2 = this.attrs.get(1 + n * 5);
        return this.strings[n2];
    }

    public String getAttrNs(int n) {
        int n2 = this.attrs.get(0 + n * 5);
        if (n2 >= 0) {
            return this.strings[n2];
        }
        return null;
    }

    String getAttrRawString(int n) {
        int n2 = this.attrs.get(2 + n * 5);
        if (n2 >= 0) {
            return this.strings[n2];
        }
        return null;
    }

    public int getAttrResId(int n) {
        int n2;
        if (this.resourceIds != null && (n2 = this.attrs.get(1 + n * 5)) >= 0 && n2 < this.resourceIds.length) {
            return this.resourceIds[n2];
        }
        return -1;
    }

    public int getAttrType(int n) {
        return this.attrs.get(3 + n * 5) >> 24;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object getAttrValue(int n) {
        boolean bl;
        int n2 = this.attrs.get(4 + n * 5);
        if (n == this.idAttribute) {
            return ValueWrapper.wrapId(n2, this.getAttrRawString(n));
        }
        if (n == this.styleAttribute) {
            return ValueWrapper.wrapStyle(n2, this.getAttrRawString(n));
        }
        if (n == this.classAttribute) {
            return ValueWrapper.wrapClass(n2, this.getAttrRawString(n));
        }
        switch (this.getAttrType(n)) {
            default: {
                return n2;
            }
            case 3: {
                return this.strings[n2];
            }
            case 18: 
        }
        if (n2 != 0) {
            bl = true;
            do {
                return bl;
                break;
            } while (true);
        }
        bl = false;
        return bl;
    }

    public int getAttributeCount() {
        return this.attributeCount;
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
        if (this.nsIdx >= 0) {
            return this.strings[this.nsIdx];
        }
        return null;
    }

    public String getText() {
        return this.strings[this.textIdx];
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    public int next() throws IOException {
        if (this.fileSize < 0) {
            if ((65535 & this.in.getInt()) != 3) {
                throw new RuntimeException();
            }
            this.fileSize = this.in.getInt();
            return 1;
        }
        var1_1 = this.in.position();
        block9 : do {
            if (var1_1 >= this.fileSize) {
                return 7;
            }
            var2_4 = 65535 & this.in.getInt();
            var3_5 = this.in.getInt();
            switch (var2_4) {
                case 258: {
                    this.lineNumber = this.in.getInt();
                    this.in.getInt();
                    this.nsIdx = this.in.getInt();
                    this.nameIdx = this.in.getInt();
                    if (this.in.getInt() != 1310740) {
                        throw new RuntimeException();
                    }
                    this.attributeCount = 65535 & this.in.getShort();
                    this.idAttribute = -1 + (65535 & this.in.getShort());
                    this.classAttribute = -1 + (65535 & this.in.getShort());
                    this.styleAttribute = -1 + (65535 & this.in.getShort());
                    this.attrs = this.in.asIntBuffer();
                    var7_6 = 2;
                    ** GOTO lbl62
                }
                case 259: {
                    this.in.position(var1_1 + var3_5);
                    var7_6 = 3;
                    ** GOTO lbl62
                }
                case 256: {
                    this.lineNumber = this.in.getInt();
                    this.in.getInt();
                    this.prefixIdx = this.in.getInt();
                    this.nsIdx = this.in.getInt();
                    var7_6 = 4;
                    ** GOTO lbl62
                }
                case 257: {
                    this.in.position(var1_1 + var3_5);
                    var7_6 = 5;
                    ** GOTO lbl62
                }
                case 1: {
                    this.strings = StringItems.read(this.in);
                    this.in.position(var1_1 + var3_5);
                    ** GOTO lbl53
                }
                case 384: {
                    var9_3 = -2 + var3_5 / 4;
                    this.resourceIds = new int[var9_3];
                    for (var10_2 = 0; var10_2 < var9_3; ++var10_2) {
                        this.resourceIds[var10_2] = this.in.getInt();
                    }
                    this.in.position(var1_1 + var3_5);
lbl53: // 2 sources:
                    var1_1 = this.in.position();
                    continue block9;
                }
                case 260: {
                    this.lineNumber = this.in.getInt();
                    this.in.getInt();
                    this.textIdx = this.in.getInt();
                    this.in.getInt();
                    this.in.getInt();
                    var7_6 = 6;
lbl62: // 5 sources:
                    this.in.position(var1_1 + var3_5);
                    return var7_6;
                }
            }
            break;
        } while (true);
        throw new RuntimeException();
    }
}

