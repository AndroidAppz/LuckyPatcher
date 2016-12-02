package pxb.android;

import com.chelpus.Common;
import com.chelpus.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;

public class StringItems extends ArrayList<StringItem> {
    static final int UTF8_FLAG = 256;
    byte[] stringData;
    private boolean useUTF8 = true;

    public static String[] read(ByteBuffer in) throws IOException {
        int i;
        int trunkOffset = in.position() - 8;
        int stringCount = in.getInt();
        int styleOffsetCount = in.getInt();
        int flags = in.getInt();
        int stringDataOffset = in.getInt();
        int stylesOffset = in.getInt();
        int[] offsets = new int[stringCount];
        String[] strings = new String[stringCount];
        for (i = 0; i < stringCount; i++) {
            offsets[i] = in.getInt();
        }
        if (stylesOffset != 0) {
            System.err.println("ignore style offset at 0x" + Integer.toHexString(trunkOffset));
        }
        int base = trunkOffset + stringDataOffset;
        for (i = 0; i < offsets.length; i++) {
            String s;
            in.position(offsets[i] + base);
            if ((flags & UTF8_FLAG) != 0) {
                u8length(in);
                int u8len = u8length(in);
                int start = in.position();
                int blength = u8len;
                while (in.get(start + blength) != (byte) 0) {
                    blength++;
                }
                s = new String(in.array(), start, blength, HttpRequest.CHARSET_UTF8);
            } else {
                int length = u16length(in);
                s = new String(in.array(), in.position(), length * 2, "UTF-16LE");
            }
            strings[i] = s;
        }
        return strings;
    }

    static int u16length(ByteBuffer in) {
        int length = in.getShort() & InternalZipConstants.MAX_ALLOWED_ZIP_COMMENT_LENGTH;
        if (length > 32767) {
            return ((length & 32767) << 8) | (in.getShort() & InternalZipConstants.MAX_ALLOWED_ZIP_COMMENT_LENGTH);
        }
        return length;
    }

    static int u8length(ByteBuffer in) {
        int len = in.get() & 255;
        if ((len & Common.INSTALL_ALLOW_DOWNGRADE) != 0) {
            return ((len & 127) << 8) | (in.get() & 255);
        }
        return len;
    }

    public int getSize() {
        return (((size() * 4) + 20) + this.stringData.length) + 0;
    }

    public void prepare() throws IOException {
        Iterator i$ = iterator();
        while (i$.hasNext()) {
            if (((StringItem) i$.next()).data.length() > 32767) {
                this.useUTF8 = false;
            }
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = 0;
        int offset = 0;
        baos.reset();
        Map<String, Integer> map = new HashMap();
        i$ = iterator();
        while (i$.hasNext()) {
            StringItem item = (StringItem) i$.next();
            int i2 = i + 1;
            item.index = i;
            String stringData = item.data;
            Integer of = (Integer) map.get(stringData);
            if (of != null) {
                item.dataOffset = of.intValue();
            } else {
                item.dataOffset = offset;
                map.put(stringData, Integer.valueOf(offset));
                int length;
                byte[] data;
                if (this.useUTF8) {
                    length = stringData.length();
                    data = stringData.getBytes(HttpRequest.CHARSET_UTF8);
                    int u8lenght = data.length;
                    if (length > 127) {
                        offset++;
                        baos.write((length >> 8) | Common.INSTALL_ALLOW_DOWNGRADE);
                    }
                    baos.write(length);
                    if (u8lenght > 127) {
                        offset++;
                        baos.write((u8lenght >> 8) | Common.INSTALL_ALLOW_DOWNGRADE);
                    }
                    baos.write(u8lenght);
                    baos.write(data);
                    baos.write(0);
                    offset += u8lenght + 3;
                } else {
                    length = stringData.length();
                    data = stringData.getBytes("UTF-16LE");
                    if (length > 32767) {
                        int x = (length >> 16) | 32768;
                        baos.write(x);
                        baos.write(x >> 8);
                        offset += 2;
                    }
                    baos.write(length);
                    baos.write(length >> 8);
                    baos.write(data);
                    baos.write(0);
                    baos.write(0);
                    offset += data.length + 4;
                }
            }
            i = i2;
        }
        this.stringData = baos.toByteArray();
    }

    public void write(ByteBuffer out) throws IOException {
        int i;
        out.putInt(size());
        out.putInt(0);
        if (this.useUTF8) {
            i = UTF8_FLAG;
        } else {
            i = 0;
        }
        out.putInt(i);
        out.putInt((size() * 4) + 28);
        out.putInt(0);
        Iterator i$ = iterator();
        while (i$.hasNext()) {
            out.putInt(((StringItem) i$.next()).dataOffset);
        }
        out.put(this.stringData);
    }
}
