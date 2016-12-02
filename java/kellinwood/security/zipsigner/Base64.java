/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
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
    static Object bDecoder;
    static Method bEncodeMethod;
    static Object bEncoder;
    static LoggerInterface logger;

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    static {
        Base64.aEncodeMethod = null;
        Base64.aDecodeMethod = null;
        Base64.bEncoder = null;
        Base64.bEncodeMethod = null;
        Base64.bDecoder = null;
        Base64.bDecodeMethod = null;
        Base64.logger = null;
        Base64.logger = LoggerManager.getLogger(Base64.class.getName());
        var7 = Class.forName((String)"android.util.Base64");
        var8_1 = new Class[]{byte[].class, Integer.TYPE};
        Base64.aEncodeMethod = var7.getMethod("encode", var8_1);
        var9_2 = new Class[]{byte[].class, Integer.TYPE};
        Base64.aDecodeMethod = var7.getMethod("decode", var9_2);
        Base64.logger.info(var7.getName() + " is available.");
lbl16: // 3 sources:
        try {
            var3_3 = Class.forName((String)"org.bouncycastle.util.encoders.Base64Encoder");
            Base64.bEncoder = var3_3.newInstance();
            var4_4 = new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, OutputStream.class};
            Base64.bEncodeMethod = var3_3.getMethod("encode", var4_4);
            Base64.logger.info(var3_3.getName() + " is available.");
            var5_5 = new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, OutputStream.class};
            Base64.bDecodeMethod = var3_3.getMethod("decode", var5_5);
lbl24: // 3 sources:
            ** if (Base64.aEncodeMethod != null || Base64.bEncodeMethod != null) goto lbl-1000
        }
        catch (Exception var2_7) {
            Base64.logger.error("Failed to initialize use of org.bouncycastle.util.encoders.Base64Encoder", (Throwable)var2_7);
            ** GOTO lbl24
        }
lbl-1000: // 1 sources:
        {
            throw new IllegalStateException("No base64 encoder implementation is available.");
        }
lbl-1000: // 1 sources:
        {
        }
        catch (Exception var6_6) {
            Base64.logger.error("Failed to initialize use of android.util.Base64", (Throwable)var6_6);
            ** GOTO lbl16
        }
        return;
        catch (ClassNotFoundException var1_8) {
            ** GOTO lbl24
        }
        catch (ClassNotFoundException var0_9) {
            ** GOTO lbl16
        }
    }

    public static byte[] decode(byte[] arrby) {
        try {
            if (aDecodeMethod != null) {
                Method method = aDecodeMethod;
                Object[] arrobject = new Object[]{arrby, 2};
                return (byte[])method.invoke((Object)null, arrobject);
            }
            if (bDecodeMethod != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Method method = bDecodeMethod;
                Object object = bEncoder;
                Object[] arrobject = new Object[]{arrby, 0, arrby.length, byteArrayOutputStream};
                method.invoke(object, arrobject);
                byte[] arrby2 = byteArrayOutputStream.toByteArray();
                return arrby2;
            }
        }
        catch (Exception var1_8) {
            throw new IllegalStateException(var1_8.getClass().getName() + ": " + var1_8.getMessage());
        }
        throw new IllegalStateException("No base64 encoder implementation is available.");
    }

    public static String encode(byte[] arrby) {
        try {
            if (aEncodeMethod != null) {
                Method method = aEncodeMethod;
                Object[] arrobject = new Object[]{arrby, 2};
                return new String((byte[])method.invoke((Object)null, arrobject));
            }
            if (bEncodeMethod != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Method method = bEncodeMethod;
                Object object = bEncoder;
                Object[] arrobject = new Object[]{arrby, 0, arrby.length, byteArrayOutputStream};
                method.invoke(object, arrobject);
                String string = new String(byteArrayOutputStream.toByteArray());
                return string;
            }
        }
        catch (Exception var1_8) {
            throw new IllegalStateException(var1_8.getClass().getName() + ": " + var1_8.getMessage());
        }
        throw new IllegalStateException("No base64 encoder implementation is available.");
    }
}

