/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.String
 *  java.util.zip.CRC32
 */
package org.tukaani.xz.common;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZFormatException;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.common.Util;

public class DecoderUtil
extends Util {
    public static boolean areStreamFlagsEqual(StreamFlags streamFlags, StreamFlags streamFlags2) {
        if (streamFlags.checkType == streamFlags2.checkType) {
            return true;
        }
        return false;
    }

    private static StreamFlags decodeStreamFlags(byte[] arrby, int n) throws UnsupportedOptionsException {
        if (arrby[n] != 0 || (255 & arrby[n + 1]) >= 16) {
            throw new UnsupportedOptionsException();
        }
        StreamFlags streamFlags = new StreamFlags();
        streamFlags.checkType = arrby[n + 1];
        return streamFlags;
    }

    public static StreamFlags decodeStreamFooter(byte[] arrby) throws IOException {
        StreamFlags streamFlags;
        if (arrby[10] != XZ.FOOTER_MAGIC[0] || arrby[11] != XZ.FOOTER_MAGIC[1]) {
            throw new CorruptedInputException("XZ Stream Footer is corrupt");
        }
        if (!DecoderUtil.isCRC32Valid(arrby, 4, 6, 0)) {
            throw new CorruptedInputException("XZ Stream Footer is corrupt");
        }
        try {
            streamFlags = DecoderUtil.decodeStreamFlags(arrby, 8);
        }
        catch (UnsupportedOptionsException var1_3) {
            throw new UnsupportedOptionsException("Unsupported options in XZ Stream Footer");
        }
        streamFlags.backwardSize = 0;
        for (int i = 0; i < 4; ++i) {
            streamFlags.backwardSize |= (long)((255 & arrby[i + 4]) << i * 8);
        }
        streamFlags.backwardSize = 4 * (1 + streamFlags.backwardSize);
        return streamFlags;
    }

    public static StreamFlags decodeStreamHeader(byte[] arrby) throws IOException {
        for (int i = 0; i < XZ.HEADER_MAGIC.length; ++i) {
            if (arrby[i] == XZ.HEADER_MAGIC[i]) continue;
            throw new XZFormatException();
        }
        if (!DecoderUtil.isCRC32Valid(arrby, XZ.HEADER_MAGIC.length, 2, 2 + XZ.HEADER_MAGIC.length)) {
            throw new CorruptedInputException("XZ Stream Header is corrupt");
        }
        try {
            StreamFlags streamFlags = DecoderUtil.decodeStreamFlags(arrby, XZ.HEADER_MAGIC.length);
            return streamFlags;
        }
        catch (UnsupportedOptionsException var2_3) {
            throw new UnsupportedOptionsException("Unsupported options in XZ Stream Header");
        }
    }

    public static long decodeVLI(InputStream inputStream) throws IOException {
        int n = inputStream.read();
        if (n == -1) {
            throw new EOFException();
        }
        long l = n & 127;
        int n2 = 0;
        while ((n & 128) != 0) {
            if (++n2 >= 9) {
                throw new CorruptedInputException();
            }
            n = inputStream.read();
            if (n == -1) {
                throw new EOFException();
            }
            if (n == 0) {
                throw new CorruptedInputException();
            }
            l |= (long)(n & 127) << n2 * 7;
        }
        return l;
    }

    public static boolean isCRC32Valid(byte[] arrby, int n, int n2, int n3) {
        CRC32 cRC32 = new CRC32();
        cRC32.update(arrby, n, n2);
        long l = cRC32.getValue();
        for (int i = 0; i < 4; ++i) {
            if ((byte)(l >>> i * 8) == arrby[n3 + i]) continue;
            return false;
        }
        return true;
    }
}

