/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Reader
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.Key
 *  javax.crypto.Cipher
 *  javax.crypto.spec.SecretKeySpec
 */
package kellinwood.security.zipsigner.optional;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.security.zipsigner.Base64;

public class PasswordObfuscator {
    private static PasswordObfuscator instance = null;
    static final String x = "harold-and-maude";
    LoggerInterface logger = LoggerManager.getLogger(PasswordObfuscator.class.getName());
    SecretKeySpec skeySpec = new SecretKeySpec("harold-and-maude".getBytes(), "AES");

    private PasswordObfuscator() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void flush(byte[] arrby) {
        if (arrby == null) {
            return;
        }
        int n = 0;
        while (n < arrby.length) {
            arrby[n] = 0;
            ++n;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void flush(char[] arrc) {
        if (arrc == null) {
            return;
        }
        int n = 0;
        while (n < arrc.length) {
            arrc[n] = '\u0000';
            ++n;
        }
    }

    public static PasswordObfuscator getInstance() {
        if (instance == null) {
            instance = new PasswordObfuscator();
        }
        return instance;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public char[] decode(String string, String string2) {
        char[] arrc;
        char[] arrc2;
        if (string2 == null) {
            return null;
        }
        try {
            int n;
            Cipher cipher = Cipher.getInstance((String)"AES/ECB/PKCS5Padding");
            cipher.init(2, (Key)new SecretKeySpec("harold-and-maude".getBytes(), "AES"));
            BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)new ByteArrayInputStream(cipher.doFinal(Base64.decode(string2.getBytes())))));
            arrc2 = new char[128];
            int n2 = 0;
            while ((n = bufferedReader.read(arrc2, n2, 128 - n2)) != -1) {
                n2 += n;
            }
            if (n2 <= string.length()) {
                return null;
            }
            arrc = new char[n2 - string.length()];
            int n3 = 0;
            for (int i = string.length(); i < n2; ++n3, ++i) {
                arrc[n3] = arrc2[i];
            }
        }
        catch (Exception var3_11) {
            this.logger.error("Failed to decode password", (Throwable)var3_11);
            return null;
        }
        PasswordObfuscator.flush(arrc2);
        return arrc;
    }

    public char[] decodeAliasPassword(String string, String string2, String string3) {
        return this.decode(string + string2, string3);
    }

    public char[] decodeKeystorePassword(String string, String string2) {
        return this.decode(string, string2);
    }

    public String encode(String string, String string2) {
        if (string2 == null) {
            return null;
        }
        char[] arrc = string2.toCharArray();
        String string3 = this.encode(string, arrc);
        PasswordObfuscator.flush(arrc);
        return string3;
    }

    public String encode(String string, char[] arrc) {
        if (arrc == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance((String)"AES/ECB/PKCS5Padding");
            cipher.init(1, (Key)this.skeySpec);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)byteArrayOutputStream);
            outputStreamWriter.write(string);
            outputStreamWriter.write(arrc);
            outputStreamWriter.flush();
            String string2 = Base64.encode(cipher.doFinal(byteArrayOutputStream.toByteArray()));
            return string2;
        }
        catch (Exception var3_7) {
            this.logger.error("Failed to obfuscate password", (Throwable)var3_7);
            return null;
        }
    }

    public String encodeAliasPassword(String string, String string2, String string3) {
        return this.encode(string + string2, string3);
    }

    public String encodeAliasPassword(String string, String string2, char[] arrc) {
        return this.encode(string + string2, arrc);
    }

    public String encodeKeystorePassword(String string, String string2) {
        return this.encode(string, string2);
    }

    public String encodeKeystorePassword(String string, char[] arrc) {
        return this.encode(string, arrc);
    }
}

