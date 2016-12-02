/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Arrays
 */
package net.lingala.zip4j.crypto;

import java.util.Arrays;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Engine;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters;
import net.lingala.zip4j.crypto.engine.AESEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.util.Raw;

public class AESDecrypter
implements IDecrypter {
    private int KEY_LENGTH;
    private int MAC_LENGTH;
    private final int PASSWORD_VERIFIER_LENGTH = 2;
    private int SALT_LENGTH;
    private AESEngine aesEngine;
    private byte[] aesKey;
    private byte[] counterBlock;
    private byte[] derivedPasswordVerifier;
    private byte[] iv;
    private LocalFileHeader localFileHeader;
    private int loopCount = 0;
    private MacBasedPRF mac;
    private byte[] macKey;
    private int nonce = 1;
    private byte[] storedMac;

    public AESDecrypter(LocalFileHeader localFileHeader, byte[] arrby, byte[] arrby2) throws ZipException {
        if (localFileHeader == null) {
            throw new ZipException("one of the input parameters is null in AESDecryptor Constructor");
        }
        this.localFileHeader = localFileHeader;
        this.storedMac = null;
        this.iv = new byte[16];
        this.counterBlock = new byte[16];
        super.init(arrby, arrby2);
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

    /*
     * Enabled aggressive block sorting
     */
    private void init(byte[] arrby, byte[] arrby2) throws ZipException {
        if (this.localFileHeader == null) {
            throw new ZipException("invalid file header in init method of AESDecryptor");
        }
        AESExtraDataRecord aESExtraDataRecord = this.localFileHeader.getAesExtraDataRecord();
        if (aESExtraDataRecord == null) {
            throw new ZipException("invalid aes extra data record - in init method of AESDecryptor");
        }
        switch (aESExtraDataRecord.getAesStrength()) {
            default: {
                throw new ZipException("invalid aes key strength for file: " + this.localFileHeader.getFileName());
            }
            case 1: {
                this.KEY_LENGTH = 16;
                this.MAC_LENGTH = 16;
                this.SALT_LENGTH = 8;
                break;
            }
            case 2: {
                this.KEY_LENGTH = 24;
                this.MAC_LENGTH = 24;
                this.SALT_LENGTH = 12;
                break;
            }
            case 3: {
                this.KEY_LENGTH = 32;
                this.MAC_LENGTH = 32;
                this.SALT_LENGTH = 16;
            }
        }
        if (this.localFileHeader.getPassword() == null || this.localFileHeader.getPassword().length <= 0) {
            throw new ZipException("empty or null password provided for AES Decryptor");
        }
        byte[] arrby3 = super.deriveKey(arrby, this.localFileHeader.getPassword());
        if (arrby3 == null || arrby3.length != 2 + (this.KEY_LENGTH + this.MAC_LENGTH)) {
            throw new ZipException("invalid derived key");
        }
        this.aesKey = new byte[this.KEY_LENGTH];
        this.macKey = new byte[this.MAC_LENGTH];
        this.derivedPasswordVerifier = new byte[2];
        System.arraycopy((Object)arrby3, (int)0, (Object)this.aesKey, (int)0, (int)this.KEY_LENGTH);
        System.arraycopy((Object)arrby3, (int)this.KEY_LENGTH, (Object)this.macKey, (int)0, (int)this.MAC_LENGTH);
        System.arraycopy((Object)arrby3, (int)(this.KEY_LENGTH + this.MAC_LENGTH), (Object)this.derivedPasswordVerifier, (int)0, (int)2);
        if (this.derivedPasswordVerifier == null) {
            throw new ZipException("invalid derived password verifier for AES");
        }
        if (!Arrays.equals((byte[])arrby2, (byte[])this.derivedPasswordVerifier)) {
            throw new ZipException("Wrong Password for file: " + this.localFileHeader.getFileName(), 5);
        }
        this.aesEngine = new AESEngine(this.aesKey);
        this.mac = new MacBasedPRF("HmacSHA1");
        this.mac.init(this.macKey);
    }

    @Override
    public int decryptData(byte[] arrby) throws ZipException {
        return this.decryptData(arrby, 0, arrby.length);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public int decryptData(byte[] arrby, int n, int n2) throws ZipException {
        if (this.aesEngine == null) {
            throw new ZipException("AES not initialized properly");
        }
        int n3 = n;
        while (n3 < n + n2) {
            int n4 = n3 + 16 <= n + n2 ? 16 : n + n2 - n3;
            this.loopCount = n4;
            this.mac.update(arrby, n3, this.loopCount);
            Raw.prepareBuffAESIVBytes(this.iv, this.nonce, 16);
            this.aesEngine.processBlock(this.iv, this.counterBlock);
            for (int i = 0; i < this.loopCount; ++i) {
                arrby[n3 + i] = (byte)(arrby[n3 + i] ^ this.counterBlock[i]);
            }
            this.nonce = 1 + this.nonce;
            n3 += 16;
            continue;
        }
        return n2;
        catch (ZipException zipException) {
            throw zipException;
        }
        catch (Exception exception) {
            throw new ZipException((Throwable)exception);
        }
    }

    public byte[] getCalculatedAuthenticationBytes() {
        return this.mac.doFinal();
    }

    public int getPasswordVerifierLength() {
        return 2;
    }

    public int getSaltLength() {
        return this.SALT_LENGTH;
    }

    public byte[] getStoredMac() {
        return this.storedMac;
    }

    public void setStoredMac(byte[] arrby) {
        this.storedMac = arrby;
    }
}

