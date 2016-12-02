/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.String
 */
package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.FilterDecoder;
import org.tukaani.xz.LZMA2Coder;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.UnsupportedOptionsException;

class LZMA2Decoder
extends LZMA2Coder
implements FilterDecoder {
    private int dictSize;

    LZMA2Decoder(byte[] arrby) throws UnsupportedOptionsException {
        if (arrby.length != 1 || (255 & arrby[0]) > 37) {
            throw new UnsupportedOptionsException("Unsupported LZMA2 properties");
        }
        this.dictSize = 2 | 1 & arrby[0];
        this.dictSize <<= 11 + (arrby[0] >>> 1);
    }

    @Override
    public InputStream getInputStream(InputStream inputStream) {
        return new LZMA2InputStream(inputStream, this.dictSize);
    }

    @Override
    public int getMemoryUsage() {
        return LZMA2InputStream.getMemoryUsage(this.dictSize);
    }
}

