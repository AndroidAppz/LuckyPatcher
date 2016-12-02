package pxb.android.axml;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Util {
    public static byte[] readFile(File in) throws IOException {
        InputStream is = new FileInputStream(in);
        byte[] xml = new byte[is.available()];
        is.read(xml);
        is.close();
        return xml;
    }

    public static byte[] readIs(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        copy(is, os);
        return os.toByteArray();
    }

    public static void writeFile(byte[] data, File out) throws IOException {
        FileOutputStream fos = new FileOutputStream(out);
        fos.write(data);
        fos.close();
    }

    public static Map<String, String> readProguardConfig(File config) throws IOException {
        Map<String, String> clzMap = new HashMap();
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(config), "utf8"));
        try {
            String ln = r.readLine();
            while (ln != null) {
                if (!(ln.startsWith("#") || ln.startsWith(" "))) {
                    int i = ln.indexOf("->");
                    if (i > 0) {
                        clzMap.put(ln.substring(0, i).trim(), ln.substring(i + 2, ln.length() - 1).trim());
                    }
                }
                ln = r.readLine();
            }
            return clzMap;
        } finally {
            r.close();
        }
    }

    public static void copy(InputStream is, OutputStream os) throws IOException {
        byte[] xml = new byte[10240];
        int c = is.read(xml);
        while (c > 0) {
            os.write(xml, 0, c);
            c = is.read(xml);
        }
    }
}
