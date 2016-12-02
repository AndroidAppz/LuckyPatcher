/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.Reader
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
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
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Util {
    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] arrby = new byte[10240];
        int n = inputStream.read(arrby);
        while (n > 0) {
            outputStream.write(arrby, 0, n);
            n = inputStream.read(arrby);
        }
    }

    public static byte[] readFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] arrby = new byte[fileInputStream.available()];
        fileInputStream.read(arrby);
        fileInputStream.close();
        return arrby;
    }

    public static byte[] readIs(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Util.copy(inputStream, (OutputStream)byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Map<String, String> readProguardConfig(File file) throws IOException {
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(file), "utf8"));
        try {
            String string = bufferedReader.readLine();
            while (string != null) {
                int n;
                if (!string.startsWith("#") && !string.startsWith(" ") && (n = string.indexOf("->")) > 0) {
                    hashMap.put((Object)string.substring(0, n).trim(), (Object)string.substring(n + 2, -1 + string.length()).trim());
                }
                string = bufferedReader.readLine();
            }
            return hashMap;
        }
        finally {
            bufferedReader.close();
        }
    }

    public static void writeFile(byte[] arrby, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(arrby);
        fileOutputStream.close();
    }
}

