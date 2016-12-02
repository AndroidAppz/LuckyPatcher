/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 */
package org.tukaani.xz.check;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.tukaani.xz.check.Check;

public class SHA256
extends Check {
    private final MessageDigest sha256;

    public SHA256() throws NoSuchAlgorithmException {
        this.size = 32;
        this.name = "SHA-256";
        this.sha256 = MessageDigest.getInstance((String)"SHA-256");
    }

    @Override
    public byte[] finish() {
        byte[] arrby = this.sha256.digest();
        this.sha256.reset();
        return arrby;
    }

    @Override
    public void update(byte[] arrby, int n, int n2) {
        this.sha256.update(arrby, n, n2);
    }
}

