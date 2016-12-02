package kellinwood.security.zipsigner.optional;

import com.chelpus.Common;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.security.zipsigner.Base64;

public class PasswordObfuscator {
    private static PasswordObfuscator instance = null;
    static final String x = "harold-and-maude";
    LoggerInterface logger = LoggerManager.getLogger(PasswordObfuscator.class.getName());
    SecretKeySpec skeySpec = new SecretKeySpec(x.getBytes(), "AES");

    private PasswordObfuscator() {
    }

    public static PasswordObfuscator getInstance() {
        if (instance == null) {
            instance = new PasswordObfuscator();
        }
        return instance;
    }

    public String encodeKeystorePassword(String keystorePath, String password) {
        return encode(keystorePath, password);
    }

    public String encodeKeystorePassword(String keystorePath, char[] password) {
        return encode(keystorePath, password);
    }

    public String encodeAliasPassword(String keystorePath, String aliasName, String password) {
        return encode(keystorePath + aliasName, password);
    }

    public String encodeAliasPassword(String keystorePath, String aliasName, char[] password) {
        return encode(keystorePath + aliasName, password);
    }

    public char[] decodeKeystorePassword(String keystorePath, String password) {
        return decode(keystorePath, password);
    }

    public char[] decodeAliasPassword(String keystorePath, String aliasName, String password) {
        return decode(keystorePath + aliasName, password);
    }

    public String encode(String junk, String password) {
        if (password == null) {
            return null;
        }
        char[] c = password.toCharArray();
        String result = encode(junk, c);
        flush(c);
        return result;
    }

    public String encode(String junk, char[] password) {
        String str = null;
        if (password != null) {
            try {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(1, this.skeySpec);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                Writer w = new OutputStreamWriter(baos);
                w.write(junk);
                w.write(password);
                w.flush();
                str = Base64.encode(cipher.doFinal(baos.toByteArray()));
            } catch (Exception x) {
                this.logger.error("Failed to obfuscate password", x);
            }
        }
        return str;
    }

    public char[] decode(String junk, String password) {
        if (password == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(x.getBytes(), "AES"));
            BufferedReader r = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(cipher.doFinal(Base64.decode(password.getBytes())))));
            char[] cb = new char[Common.INSTALL_ALLOW_DOWNGRADE];
            int length = 0;
            while (true) {
                int numRead = r.read(cb, length, 128 - length);
                if (numRead == -1) {
                    break;
                }
                length += numRead;
            }
            if (length <= junk.length()) {
                return null;
            }
            char[] result = new char[(length - junk.length())];
            int j = 0;
            for (int i = junk.length(); i < length; i++) {
                result[j] = cb[i];
                j++;
            }
            flush(cb);
            return result;
        } catch (Exception x) {
            this.logger.error("Failed to decode password", x);
            return null;
        }
    }

    public static void flush(char[] charArray) {
        if (charArray != null) {
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = '\u0000';
            }
        }
    }

    public static void flush(byte[] charArray) {
        if (charArray != null) {
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = (byte) 0;
            }
        }
    }
}
