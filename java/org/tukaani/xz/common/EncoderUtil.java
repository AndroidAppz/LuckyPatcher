/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.util.zip.CRC32
 */
package org.tukaani.xz.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import org.tukaani.xz.common.Util;

public class EncoderUtil
extends Util {
    public static void encodeVLI(OutputStream outputStream, long l) throws IOException {
        while (l >= 128) {
            outputStream.write((int)((byte)(l | 128)));
            l >>>= 7;
        }
        outputStream.write((int)((byte)l));
    }

    public static void writeCRC32(OutputStream outputStream, byte[] arrby) throws IOException {
        CRC32 cRC32 = new CRC32();
        cRC32.update(arrby);
        long l = cRC32.getValue();
        for (int i = 0; i < 4; ++i) {
            outputStream.write((int)((byte)(l >>> i * 8)));
        }
    }
}

