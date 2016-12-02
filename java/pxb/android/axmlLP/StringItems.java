/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.TreeMap
 */
package pxb.android.axmlLP;

import com.googlecode.dex2jar.reader.io.DataIn;
import com.googlecode.dex2jar.reader.io.DataOut;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import pxb.android.axmlLP.StringItem;

class StringItems
extends ArrayList<StringItem> {
    byte[] stringData;

    StringItems() {
    }

    public int getSize() {
        return 0 + (20 + 4 * this.size() + this.stringData.length);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void prepare() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 0;
        int n2 = 0;
        byteArrayOutputStream.reset();
        HashMap hashMap = new HashMap();
        Iterator iterator = this.iterator();
        do {
            if (!iterator.hasNext()) {
                this.stringData = byteArrayOutputStream.toByteArray();
                return;
            }
            StringItem stringItem = (StringItem)iterator.next();
            int n3 = n + 1;
            stringItem.index = n;
            String string = stringItem.data;
            Integer n4 = (Integer)hashMap.get((Object)string);
            if (n4 != null) {
                stringItem.dataOffset = n4;
            } else {
                stringItem.dataOffset = n2;
                hashMap.put((Object)string, (Object)n2);
                int n5 = string.length();
                byte[] arrby = string.getBytes("UTF-16LE");
                byteArrayOutputStream.write(n5);
                byteArrayOutputStream.write(n5 >> 8);
                byteArrayOutputStream.write(arrby);
                byteArrayOutputStream.write(0);
                byteArrayOutputStream.write(0);
                n2 += 4 + arrby.length;
            }
            n = n3;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void read(DataIn dataIn, int n) throws IOException {
        -4 + dataIn.getCurrentPosition();
        int n2 = dataIn.readIntx();
        int n3 = dataIn.readIntx();
        int n4 = dataIn.readIntx();
        dataIn.readIntx();
        int n5 = dataIn.readIntx();
        int n6 = 0;
        while (n6 < n2) {
            StringItem stringItem = new StringItem();
            stringItem.index = n6++;
            stringItem.dataOffset = dataIn.readIntx();
            this.add((Object)stringItem);
        }
        TreeMap treeMap = new TreeMap();
        if (n3 != 0) {
            throw new RuntimeException();
        }
        int n7 = n5 == 0 ? n : n5;
        int n8 = dataIn.getCurrentPosition();
        if ((n4 & 256) == 0) {
            int n9 = n8;
            while (n9 < n7) {
                byte[] arrby = dataIn.readBytes(2 * dataIn.readShortx());
                dataIn.skip(2);
                String string = new String(arrby, "UTF-16LE");
                treeMap.put((Object)(n9 - n8), (Object)string);
                n9 = dataIn.getCurrentPosition();
            }
        } else {
            int n10 = n8;
            while (n10 < n7) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10 + (int)dataIn.readLeb128());
                int n11 = dataIn.readByte();
                while (n11 != 0) {
                    byteArrayOutputStream.write(n11);
                    n11 = dataIn.readByte();
                }
                String string = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                treeMap.put((Object)(n10 - n8), (Object)string);
                n10 = dataIn.getCurrentPosition();
            }
        }
        if (n5 != 0) {
            // empty if block
        }
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            StringItem stringItem = (StringItem)iterator.next();
            stringItem.data = (String)treeMap.get((Object)stringItem.dataOffset);
        }
        return;
    }

    public void write(DataOut dataOut) throws IOException {
        dataOut.writeInt(this.size());
        dataOut.writeInt(0);
        dataOut.writeInt(0);
        dataOut.writeInt(28 + 4 * this.size());
        dataOut.writeInt(0);
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            dataOut.writeInt(((StringItem)iterator.next()).dataOffset);
        }
        dataOut.writeBytes(this.stringData);
    }
}

