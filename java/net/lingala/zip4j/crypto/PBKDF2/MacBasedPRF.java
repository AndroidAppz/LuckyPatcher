/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.InvalidKeyException
 *  java.security.Key
 *  java.security.NoSuchAlgorithmException
 *  java.security.NoSuchProviderException
 *  javax.crypto.Mac
 *  javax.crypto.spec.SecretKeySpec
 */
package net.lingala.zip4j.crypto.PBKDF2;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.lingala.zip4j.crypto.PBKDF2.PRF;

public class MacBasedPRF
implements PRF {
    protected int hLen;
    protected Mac mac;
    protected String macAlgorithm;

    public MacBasedPRF(String string) {
        this.macAlgorithm = string;
        try {
            this.mac = Mac.getInstance((String)string);
            this.hLen = this.mac.getMacLength();
            return;
        }
        catch (NoSuchAlgorithmException var2_2) {
            throw new RuntimeException((Throwable)var2_2);
        }
    }

    public MacBasedPRF(String string, String string2) {
        this.macAlgorithm = string;
        try {
            this.mac = Mac.getInstance((String)string, (String)string2);
            this.hLen = this.mac.getMacLength();
            return;
        }
        catch (NoSuchAlgorithmException var4_3) {
            throw new RuntimeException((Throwable)var4_3);
        }
        catch (NoSuchProviderException var3_4) {
            throw new RuntimeException((Throwable)var3_4);
        }
    }

    public byte[] doFinal() {
        return this.mac.doFinal();
    }

    @Override
    public byte[] doFinal(byte[] arrby) {
        return this.mac.doFinal(arrby);
    }

    @Override
    public int getHLen() {
        return this.hLen;
    }

    @Override
    public void init(byte[] arrby) {
        try {
            this.mac.init((Key)new SecretKeySpec(arrby, this.macAlgorithm));
            return;
        }
        catch (InvalidKeyException var2_2) {
            throw new RuntimeException((Throwable)var2_2);
        }
    }

    public void update(byte[] arrby) {
        try {
            this.mac.update(arrby);
            return;
        }
        catch (IllegalStateException var2_2) {
            throw new RuntimeException((Throwable)var2_2);
        }
    }

    public void update(byte[] arrby, int n, int n2) {
        try {
            this.mac.update(arrby, n, n2);
            return;
        }
        catch (IllegalStateException var4_4) {
            throw new RuntimeException((Throwable)var4_4);
        }
    }
}

