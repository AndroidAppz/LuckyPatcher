package org.tukaani.xz.check;

import java.security.NoSuchAlgorithmException;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZ;
import pxb.android.axml.AxmlParser;
import pxb.android.axmlLP.AxmlVisitor;

public abstract class Check {
    String name;
    int size;

    public abstract byte[] finish();

    public abstract void update(byte[] bArr, int i, int i2);

    public void update(byte[] buf) {
        update(buf, 0, buf.length);
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public static Check getInstance(int checkType) throws UnsupportedOptionsException {
        switch (checkType) {
            case XZ.CHECK_NONE /*0*/:
                return new None();
            case AxmlVisitor.TYPE_REFERENCE /*1*/:
                return new CRC32();
            case AxmlParser.START_NS /*4*/:
                return new CRC64();
            case XZ.CHECK_SHA256 /*10*/:
                try {
                    return new SHA256();
                } catch (NoSuchAlgorithmException e) {
                    break;
                }
        }
        throw new UnsupportedOptionsException("Unsupported Check ID " + checkType);
    }
}
