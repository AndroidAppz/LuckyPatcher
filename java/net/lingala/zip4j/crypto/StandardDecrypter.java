/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package net.lingala.zip4j.crypto;

import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public class StandardDecrypter
implements IDecrypter {
    private byte[] crc = new byte[4];
    private FileHeader fileHeader;
    private ZipCryptoEngine zipCryptoEngine;

    public StandardDecrypter(FileHeader fileHeader, byte[] arrby) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("one of more of the input parameters were null in StandardDecryptor");
        }
        this.fileHeader = fileHeader;
        this.zipCryptoEngine = new ZipCryptoEngine();
        this.init(arrby);
    }

    @Override
    public int decryptData(byte[] arrby) throws ZipException {
        return this.decryptData(arrby, 0, arrby.length);
    }

    @Override
    public int decryptData(byte[] arrby, int n, int n2) throws ZipException {
        if (n < 0 || n2 < 0) {
            throw new ZipException("one of the input parameters were null in standard decrpyt data");
        }
        for (int i = n; i < n + n2; ++i) {
            try {
                int n3 = 255 & (255 & arrby[i] ^ this.zipCryptoEngine.decryptByte());
                this.zipCryptoEngine.updateKeys((byte)n3);
                arrby[i] = (byte)n3;
            }
            catch (Exception var5_6) {
                throw new ZipException((Throwable)var5_6);
            }
        }
        return n2;
    }

    public void init(byte[] arrby) throws ZipException {
        byte[] arrby2 = this.fileHeader.getCrcBuff();
        this.crc[3] = (byte)(255 & arrby2[3]);
        this.crc[2] = (byte)(255 & arrby2[3] >> 8);
        this.crc[1] = (byte)(255 & arrby2[3] >> 16);
        this.crc[0] = (byte)(255 & arrby2[3] >> 24);
        if (this.crc[2] > 0 || this.crc[1] > 0 || this.crc[0] > 0) {
            throw new IllegalStateException("Invalid CRC in File Header");
        }
        if (this.fileHeader.getPassword() == null || this.fileHeader.getPassword().length <= 0) {
            throw new ZipException("Wrong password!", 5);
        }
        this.zipCryptoEngine.initKeys(this.fileHeader.getPassword());
        byte by = arrby[0];
        for (int i = 0; i < 12; ++i) {
            try {
                this.zipCryptoEngine.updateKeys((byte)(by ^ this.zipCryptoEngine.decryptByte()));
            }
            catch (Exception var3_5) {
                throw new ZipException((Throwable)var3_5);
            }
            if (i + 1 == 12) continue;
            by = arrby[i + 1];
        }
    }
}

