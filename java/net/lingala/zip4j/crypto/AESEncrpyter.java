/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Random
 */
package net.lingala.zip4j.crypto;

import java.util.Random;
import net.lingala.zip4j.crypto.IEncrypter;
import net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Engine;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters;
import net.lingala.zip4j.crypto.engine.AESEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.Raw;

public class AESEncrpyter
implements IEncrypter {
    private int KEY_LENGTH;
    private int MAC_LENGTH;
    private final int PASSWORD_VERIFIER_LENGTH = 2;
    private int SALT_LENGTH;
    private AESEngine aesEngine;
    private byte[] aesKey;
    private byte[] counterBlock;
    private byte[] derivedPasswordVerifier;
    private boolean finished;
    private byte[] iv;
    private int keyStrength;
    private int loopCount = 0;
    private MacBasedPRF mac;
    private byte[] macKey;
    private int nonce = 1;
    private char[] password;
    private byte[] saltBytes;

    public AESEncrpyter(char[] arrc, int n) throws ZipException {
        if (arrc == null || arrc.length == 0) {
            throw new ZipException("input password is empty or null in AES encrypter constructor");
        }
        if (n != 1 && n != 3) {
            throw new ZipException("Invalid key strength in AES encrypter constructor");
        }
        this.password = arrc;
        this.keyStrength = n;
        this.finished = false;
        this.counterBlock = new byte[16];
        this.iv = new byte[16];
        super.init();
    }

    private byte[] deriveKey(byte[] arrby, char[] arrc) throws ZipException {
        try {
            byte[] arrby2 = new PBKDF2Engine(new PBKDF2Parameters("HmacSHA1", "ISO-8859-1", arrby, 1000)).deriveKey(arrc, 2 + (this.KEY_LENGTH + this.MAC_LENGTH));
            return arrby2;
        }
        catch (Exception var3_4) {
            throw new ZipException((Throwable)var3_4);
        }
    }

    private static byte[] generateSalt(int n) throws ZipException {
        if (n != 8 && n != 16) {
            throw new ZipException("invalid salt size, cannot generate salt");
        }
        int n2 = 0;
        if (n == 8) {
            n2 = 2;
        }
        if (n == 16) {
            n2 = 4;
        }
        byte[] arrby = new byte[n];
        for (int i = 0; i < n2; ++i) {
            int n3 = new Random().nextInt();
            arrby[0 + i * 4] = (byte)(n3 >> 24);
            arrby[1 + i * 4] = (byte)(n3 >> 16);
            arrby[2 + i * 4] = (byte)(n3 >> 8);
            arrby[3 + i * 4] = (byte)n3;
        }
        return arrby;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void init() throws ZipException {
        switch (this.keyStrength) {
            default: {
                throw new ZipException("invalid aes key strength, cannot determine key sizes");
            }
            case 1: {
                this.KEY_LENGTH = 16;
                this.MAC_LENGTH = 16;
                this.SALT_LENGTH = 8;
                break;
            }
            case 3: {
                this.KEY_LENGTH = 32;
                this.MAC_LENGTH = 32;
                this.SALT_LENGTH = 16;
            }
        }
        this.saltBytes = AESEncrpyter.generateSalt(this.SALT_LENGTH);
        byte[] arrby = this.deriveKey(this.saltBytes, this.password);
        if (arrby == null || arrby.length != 2 + (this.KEY_LENGTH + this.MAC_LENGTH)) {
            throw new ZipException("invalid key generated, cannot decrypt file");
        }
        this.aesKey = new byte[this.KEY_LENGTH];
        this.macKey = new byte[this.MAC_LENGTH];
        this.derivedPasswordVerifier = new byte[2];
        System.arraycopy((Object)arrby, (int)0, (Object)this.aesKey, (int)0, (int)this.KEY_LENGTH);
        System.arraycopy((Object)arrby, (int)this.KEY_LENGTH, (Object)this.macKey, (int)0, (int)this.MAC_LENGTH);
        System.arraycopy((Object)arrby, (int)(this.KEY_LENGTH + this.MAC_LENGTH), (Object)this.derivedPasswordVerifier, (int)0, (int)2);
        this.aesEngine = new AESEngine(this.aesKey);
        this.mac = new MacBasedPRF("HmacSHA1");
        this.mac.init(this.macKey);
    }

    @Override
    public int encryptData(byte[] arrby) throws ZipException {
        if (arrby == null) {
            throw new ZipException("input bytes are null, cannot perform AES encrpytion");
        }
        return this.encryptData(arrby, 0, arrby.length);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public int encryptData(byte[] arrby, int n, int n2) throws ZipException {
        if (this.finished) {
            throw new ZipException("AES Encrypter is in finished state (A non 16 byte block has already been passed to encrypter)");
        }
        if (n2 % 16 != 0) {
            this.finished = true;
        }
        int n3 = n;
        while (n3 < n + n2) {
            int n4 = n3 + 16 <= n + n2 ? 16 : n + n2 - n3;
            this.loopCount = n4;
            Raw.prepareBuffAESIVBytes(this.iv, this.nonce, 16);
            this.aesEngine.processBlock(this.iv, this.counterBlock);
            for (int i = 0; i < this.loopCount; ++i) {
                arrby[n3 + i] = (byte)(arrby[n3 + i] ^ this.counterBlock[i]);
            }
            this.mac.update(arrby, n3, this.loopCount);
            this.nonce = 1 + this.nonce;
            n3 += 16;
        }
        return n2;
    }

    public byte[] getDerivedPasswordVerifier() {
        return this.derivedPasswordVerifier;
    }

    public byte[] getFinalMac() {
        byte[] arrby = this.mac.doFinal();
        byte[] arrby2 = new byte[10];
        System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)10);
        return arrby2;
    }

    public int getPasswordVeriifierLength() {
        return 2;
    }

    public byte[] getSaltBytes() {
        return this.saltBytes;
    }

    public int getSaltLength() {
        return this.SALT_LENGTH;
    }

    public void setDerivedPasswordVerifier(byte[] arrby) {
        this.derivedPasswordVerifier = arrby;
    }

    public void setSaltBytes(byte[] arrby) {
        this.saltBytes = arrby;
    }
}

