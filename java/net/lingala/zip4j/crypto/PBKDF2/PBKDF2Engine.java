/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package net.lingala.zip4j.crypto.PBKDF2;

import net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters;
import net.lingala.zip4j.crypto.PBKDF2.PRF;
import net.lingala.zip4j.util.Raw;

public class PBKDF2Engine {
    protected PBKDF2Parameters parameters;
    protected PRF prf;

    public PBKDF2Engine() {
        this.parameters = null;
        this.prf = null;
    }

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters) {
        this.parameters = pBKDF2Parameters;
        this.prf = null;
    }

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters, PRF pRF) {
        this.parameters = pBKDF2Parameters;
        this.prf = pRF;
    }

    protected void INT(byte[] arrby, int n, int n2) {
        arrby[n + 0] = (byte)(n2 / 16777216);
        arrby[n + 1] = (byte)(n2 / 65536);
        arrby[n + 2] = (byte)(n2 / 256);
        arrby[n + 3] = (byte)n2;
    }

    protected byte[] PBKDF2(PRF pRF, byte[] arrby, int n, int n2) {
        if (arrby == null) {
            arrby = new byte[]{};
        }
        int n3 = pRF.getHLen();
        int n4 = this.ceil(n2, n3);
        int n5 = n2 - n3 * (n4 - 1);
        byte[] arrby2 = new byte[n4 * n3];
        int n6 = 0;
        for (int i = 1; i <= n4; ++i) {
            this._F(arrby2, n6, pRF, arrby, n, i);
            n6 += n3;
        }
        if (n5 < n3) {
            byte[] arrby3 = new byte[n2];
            System.arraycopy((Object)arrby2, (int)0, (Object)arrby3, (int)0, (int)n2);
            return arrby3;
        }
        return arrby2;
    }

    protected void _F(byte[] arrby, int n, PRF pRF, byte[] arrby2, int n2, int n3) {
        int n4 = pRF.getHLen();
        byte[] arrby3 = new byte[n4];
        byte[] arrby4 = new byte[4 + arrby2.length];
        System.arraycopy((Object)arrby2, (int)0, (Object)arrby4, (int)0, (int)arrby2.length);
        this.INT(arrby4, arrby2.length, n3);
        for (int i = 0; i < n2; ++i) {
            arrby4 = pRF.doFinal(arrby4);
            this.xor(arrby3, arrby4);
        }
        System.arraycopy((Object)arrby3, (int)0, (Object)arrby, (int)n, (int)n4);
    }

    protected void assertPRF(byte[] arrby) {
        if (this.prf == null) {
            this.prf = new MacBasedPRF(this.parameters.getHashAlgorithm());
        }
        this.prf.init(arrby);
    }

    protected int ceil(int n, int n2) {
        int n3 = n % n2;
        int n4 = 0;
        if (n3 > 0) {
            n4 = 1;
        }
        return n4 + n / n2;
    }

    public byte[] deriveKey(char[] arrc) {
        return this.deriveKey(arrc, 0);
    }

    public byte[] deriveKey(char[] arrc, int n) {
        if (arrc == null) {
            throw new NullPointerException();
        }
        this.assertPRF(Raw.convertCharArrayToByteArray(arrc));
        if (n == 0) {
            n = this.prf.getHLen();
        }
        return this.PBKDF2(this.prf, this.parameters.getSalt(), this.parameters.getIterationCount(), n);
    }

    public PBKDF2Parameters getParameters() {
        return this.parameters;
    }

    public PRF getPseudoRandomFunction() {
        return this.prf;
    }

    public void setParameters(PBKDF2Parameters pBKDF2Parameters) {
        this.parameters = pBKDF2Parameters;
    }

    public void setPseudoRandomFunction(PRF pRF) {
        this.prf = pRF;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean verifyKey(char[] arrc) {
        byte[] arrby = this.getParameters().getDerivedKey();
        if (arrby == null) return false;
        if (arrby.length == 0) {
            return false;
        }
        byte[] arrby2 = this.deriveKey(arrc, arrby.length);
        if (arrby2 == null) return false;
        if (arrby2.length != arrby.length) return false;
        int n = 0;
        while (n < arrby2.length) {
            if (arrby2[n] != arrby[n]) return false;
            ++n;
        }
        return true;
    }

    protected void xor(byte[] arrby, byte[] arrby2) {
        for (int i = 0; i < arrby.length; ++i) {
            arrby[i] = (byte)(arrby[i] ^ arrby2[i]);
        }
    }
}

