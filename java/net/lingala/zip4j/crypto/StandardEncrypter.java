/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Random
 */
package net.lingala.zip4j.crypto;

import java.util.Random;
import net.lingala.zip4j.crypto.IEncrypter;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

public class StandardEncrypter
implements IEncrypter {
    private byte[] headerBytes;
    private ZipCryptoEngine zipCryptoEngine;

    public StandardEncrypter(char[] arrc, int n) throws ZipException {
        if (arrc == null || arrc.length <= 0) {
            throw new ZipException("input password is null or empty in standard encrpyter constructor");
        }
        this.zipCryptoEngine = new ZipCryptoEngine();
        this.headerBytes = new byte[12];
        super.init(arrc, n);
    }

    private void init(char[] arrc, int n) throws ZipException {
        if (arrc == null || arrc.length <= 0) {
            throw new ZipException("input password is null or empty, cannot initialize standard encrypter");
        }
        this.zipCryptoEngine.initKeys(arrc);
        this.headerBytes = this.generateRandomBytes(12);
        this.zipCryptoEngine.initKeys(arrc);
        this.headerBytes[11] = (byte)(n >>> 24);
        this.headerBytes[10] = (byte)(n >>> 16);
        if (this.headerBytes.length < 12) {
            throw new ZipException("invalid header bytes generated, cannot perform standard encryption");
        }
        this.encryptData(this.headerBytes);
    }

    protected byte encryptByte(byte by) {
        byte by2 = (byte)(by ^ 255 & this.zipCryptoEngine.decryptByte());
        this.zipCryptoEngine.updateKeys(by);
        return by2;
    }

    @Override
    public int encryptData(byte[] arrby) throws ZipException {
        if (arrby == null) {
            throw new NullPointerException();
        }
        return this.encryptData(arrby, 0, arrby.length);
    }

    @Override
    public int encryptData(byte[] arrby, int n, int n2) throws ZipException {
        if (n2 < 0) {
            throw new ZipException("invalid length specified to decrpyt data");
        }
        for (int i = n; i < n + n2; ++i) {
            try {
                arrby[i] = this.encryptByte(arrby[i]);
            }
            catch (Exception var5_5) {
                throw new ZipException((Throwable)var5_5);
            }
        }
        return n2;
    }

    protected byte[] generateRandomBytes(int n) throws ZipException {
        if (n <= 0) {
            throw new ZipException("size is either 0 or less than 0, cannot generate header for standard encryptor");
        }
        byte[] arrby = new byte[n];
        Random random = new Random();
        for (int i = 0; i < arrby.length; ++i) {
            arrby[i] = this.encryptByte((byte)random.nextInt(256));
        }
        return arrby;
    }

    public byte[] getHeaderBytes() {
        return this.headerBytes;
    }
}

