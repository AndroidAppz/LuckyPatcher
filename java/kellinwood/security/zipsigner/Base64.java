package kellinwood.security.zipsigner;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;

public class Base64 {
    static Method aDecodeMethod;
    static Method aEncodeMethod;
    static Method bDecodeMethod;
    static Object bDecoder = null;
    static Method bEncodeMethod;
    static Object bEncoder;
    static LoggerInterface logger;

    static {
        aEncodeMethod = null;
        aDecodeMethod = null;
        bEncoder = null;
        bEncodeMethod = null;
        bDecodeMethod = null;
        logger = null;
        logger = LoggerManager.getLogger(Base64.class.getName());
        try {
            Class<Object> clazz = Class.forName("android.util.Base64");
            aEncodeMethod = clazz.getMethod("encode", new Class[]{byte[].class, Integer.TYPE});
            aDecodeMethod = clazz.getMethod("decode", new Class[]{byte[].class, Integer.TYPE});
            logger.info(clazz.getName() + " is available.");
        } catch (ClassNotFoundException e) {
        } catch (Exception x) {
            logger.error("Failed to initialize use of android.util.Base64", x);
        }
        try {
            clazz = Class.forName("org.bouncycastle.util.encoders.Base64Encoder");
            bEncoder = clazz.newInstance();
            bEncodeMethod = clazz.getMethod("encode", new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, OutputStream.class});
            logger.info(clazz.getName() + " is available.");
            bDecodeMethod = clazz.getMethod("decode", new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, OutputStream.class});
        } catch (ClassNotFoundException e2) {
        } catch (Exception x2) {
            logger.error("Failed to initialize use of org.bouncycastle.util.encoders.Base64Encoder", x2);
        }
        if (aEncodeMethod == null && bEncodeMethod == null) {
            throw new IllegalStateException("No base64 encoder implementation is available.");
        }
    }

    public static String encode(byte[] data) {
        try {
            if (aEncodeMethod != null) {
                return new String((byte[]) aEncodeMethod.invoke(null, new Object[]{data, Integer.valueOf(2)}));
            } else if (bEncodeMethod != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bEncodeMethod.invoke(bEncoder, new Object[]{data, Integer.valueOf(0), Integer.valueOf(data.length), baos});
                return new String(baos.toByteArray());
            } else {
                throw new IllegalStateException("No base64 encoder implementation is available.");
            }
        } catch (Exception x) {
            throw new IllegalStateException(x.getClass().getName() + ": " + x.getMessage());
        }
    }

    public static byte[] decode(byte[] data) {
        try {
            if (aDecodeMethod != null) {
                return (byte[]) aDecodeMethod.invoke(null, new Object[]{data, Integer.valueOf(2)});
            } else if (bDecodeMethod != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bDecodeMethod.invoke(bEncoder, new Object[]{data, Integer.valueOf(0), Integer.valueOf(data.length), baos});
                return baos.toByteArray();
            } else {
                throw new IllegalStateException("No base64 encoder implementation is available.");
            }
        } catch (Exception x) {
            throw new IllegalStateException(x.getClass().getName() + ": " + x.getMessage());
        }
    }
}
