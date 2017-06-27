package pxb.android.axmlLP;

import com.chelpus.HttpRequest;
import com.googlecode.dex2jar.reader.io.DataIn;
import com.googlecode.dex2jar.reader.io.DataOut;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import pxb.android.ResConst;

class StringItems extends ArrayList<StringItem> {
    byte[] stringData;

    StringItems() {
    }

    public int getSize() {
        return (((size() * 4) + 20) + this.stringData.length) + 0;
    }

    public void prepare() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = 0;
        int offset = 0;
        baos.reset();
        Map<String, Integer> map = new HashMap();
        Iterator it = iterator();
        while (it.hasNext()) {
            StringItem item = (StringItem) it.next();
            int i2 = i + 1;
            item.index = i;
            String stringData = item.data;
            Integer of = (Integer) map.get(stringData);
            if (of != null) {
                item.dataOffset = of.intValue();
                i = i2;
            } else {
                item.dataOffset = offset;
                map.put(stringData, Integer.valueOf(offset));
                int length = stringData.length();
                byte[] data = stringData.getBytes("UTF-16LE");
                baos.write(length);
                baos.write(length >> 8);
                baos.write(data);
                baos.write(0);
                baos.write(0);
                offset += data.length + 4;
                i = i2;
            }
        }
        this.stringData = baos.toByteArray();
    }

    public void read(DataIn in, int size) throws IOException {
        int trunkOffset = in.getCurrentPosition() - 4;
        int stringCount = in.readIntx();
        int styleOffsetCount = in.readIntx();
        int flags = in.readIntx();
        int stringDataOffset = in.readIntx();
        int stylesOffset = in.readIntx();
        for (int i = 0; i < stringCount; i++) {
            StringItem stringItem = new StringItem();
            stringItem.index = i;
            stringItem.dataOffset = in.readIntx();
            add(stringItem);
        }
        Map<Integer, String> stringMap = new TreeMap();
        if (styleOffsetCount != 0) {
            throw new RuntimeException();
        }
        int endOfStringData;
        if (stylesOffset == 0) {
            endOfStringData = size;
        } else {
            endOfStringData = stylesOffset;
        }
        int base = in.getCurrentPosition();
        int p;
        if ((flags & ResConst.RES_XML_START_NAMESPACE_TYPE) != 0) {
            p = base;
            while (p < endOfStringData) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream(((int) in.readLeb128()) + 10);
                int r = in.readByte();
                while (r != 0) {
                    bos.write(r);
                    r = in.readByte();
                }
                stringMap.put(Integer.valueOf(p - base), new String(bos.toByteArray(), HttpRequest.CHARSET_UTF8));
                p = in.getCurrentPosition();
            }
        } else {
            p = base;
            while (p < endOfStringData) {
                byte[] data = in.readBytes(in.readShortx() * 2);
                in.skip(2);
                stringMap.put(Integer.valueOf(p - base), new String(data, "UTF-16LE"));
                p = in.getCurrentPosition();
            }
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            StringItem item = (StringItem) it.next();
            item.data = (String) stringMap.get(Integer.valueOf(item.dataOffset));
        }
    }

    public void write(DataOut out) throws IOException {
        out.writeInt(size());
        out.writeInt(0);
        out.writeInt(0);
        out.writeInt((size() * 4) + 28);
        out.writeInt(0);
        Iterator it = iterator();
        while (it.hasNext()) {
            out.writeInt(((StringItem) it.next()).dataOffset);
        }
        out.writeBytes(this.stringData);
    }
}
