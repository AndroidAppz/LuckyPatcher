/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package net.lingala.zip4j.crypto;

import net.lingala.zip4j.exception.ZipException;

public interface IDecrypter {
    public int decryptData(byte[] var1) throws ZipException;

    public int decryptData(byte[] var1, int var2, int var3) throws ZipException;
}

