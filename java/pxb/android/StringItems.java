/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 */
package pxb.android;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import pxb.android.StringItem;

public class StringItems
extends ArrayList<StringItem> {
    static final int UTF8_FLAG = 256;
    byte[] stringData;
    private boolean useUTF8 = true;

    /*
     * Enabled aggressive block sorting
     */
    public static String[] read(ByteBuffer byteBuffer) throws IOException {
        int n = -8 + byteBuffer.position();
        int n2 = byteBuffer.getInt();
        byteBuffer.getInt();
        int n3 = byteBuffer.getInt();
        int n4 = byteBuffer.getInt();
        int n5 = byteBuffer.getInt();
        int[] arrn = new int[n2];
        String[] arrstring = new String[n2];
        for (int i = 0; i < n2; ++i) {
            arrn[i] = byteBuffer.getInt();
        }
        if (n5 != 0) {
            System.err.println("ignore style offset at 0x" + Integer.toHexString((int)n));
        }
        int n6 = n + n4;
        int n7 = 0;
        while (n7 < arrn.length) {
            String string;
            byteBuffer.position(n6 + arrn[n7]);
            if ((n3 & 256) != 0) {
                StringItems.u8length(byteBuffer);
                int n8 = StringItems.u8length(byteBuffer);
                int n9 = byteBuffer.position();
                int n10 = n8;
                while (byteBuffer.get(n9 + n10) != 0) {
                    ++n10;
                }
                string = new String(byteBuffer.array(), n9, n10, "UTF-8");
            } else {
                int n11 = StringItems.u16length(byteBuffer);
                string = new String(byteBuffer.array(), byteBuffer.position(), n11 * 2, "UTF-16LE");
            }
            arrstring[n7] = string;
            ++n7;
        }
        return arrstring;
    }

    static int u16length(ByteBuffer byteBuffer) {
        int n = 65535 & byteBuffer.getShort();
        if (n > 32767) {
            n = (n & 32767) << 8 | 65535 & byteBuffer.getShort();
        }
        return n;
    }

    static int u8length(ByteBuffer byteBuffer) {
        int n = 255 & byteBuffer.get();
        if ((n & 128) != 0) {
            n = (n & 127) << 8 | 255 & byteBuffer.get();
        }
        return n;
    }

    public int getSize() {
        return 0 + (20 + 4 * this.size() + this.stringData.length);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void prepare() throws IOException {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (((StringItem)iterator.next()).data.length() <= 32767) continue;
            this.useUTF8 = false;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 0;
        int n2 = 0;
        byteArrayOutputStream.reset();
        HashMap hashMap = new HashMap();
        Iterator iterator2 = this.iterator();
        do {
            if (!iterator2.hasNext()) {
                this.stringData = byteArrayOutputStream.toByteArray();
                return;
            }
            StringItem stringItem = (StringItem)iterator2.next();
            int n3 = n + 1;
            stringItem.index = n;
            String string = stringItem.data;
            Integer n4 = (Integer)hashMap.get((Object)string);
            if (n4 != null) {
                stringItem.dataOffset = n4;
            } else {
                stringItem.dataOffset = n2;
                hashMap.put((Object)string, (Object)n2);
                if (this.useUTF8) {
                    int n5 = string.length();
                    byte[] arrby = string.getBytes("UTF-8");
                    int n6 = arrby.length;
                    if (n5 > 127) {
                        ++n2;
                        byteArrayOutputStream.write(128 | n5 >> 8);
                    }
                    byteArrayOutputStream.write(n5);
                    if (n6 > 127) {
                        ++n2;
                        byteArrayOutputStream.write(128 | n6 >> 8);
                    }
                    byteArrayOutputStream.write(n6);
                    byteArrayOutputStream.write(arrby);
                    byteArrayOutputStream.write(0);
                    n2 += n6 + 3;
                } else {
                    int n7 = string.length();
                    byte[] arrby = string.getBytes("UTF-16LE");
                    if (n7 > 32767) {
                        int n8 = 32768 | n7 >> 16;
                        byteArrayOutputStream.write(n8);
                        byteArrayOutputStream.write(n8 >> 8);
                        n2 += 2;
                    }
                    byteArrayOutputStream.write(n7);
                    byteArrayOutputStream.write(n7 >> 8);
                    byteArrayOutputStream.write(arrby);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    n2 += 4 + arrby.length;
                }
            }
            n = n3;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void write(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.putInt(this.size());
        byteBuffer.putInt(0);
        int n = this.useUTF8 ? 256 : 0;
        byteBuffer.putInt(n);
        byteBuffer.putInt(28 + 4 * this.size());
        byteBuffer.putInt(0);
        Iterator iterator = this.iterator();
        do {
            if (!iterator.hasNext()) {
                byteBuffer.put(this.stringData);
                return;
            }
            byteBuffer.putInt(((StringItem)iterator.next()).dataOffset);
        } while (true);
    }
}

