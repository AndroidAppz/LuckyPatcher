package org.tukaani.xz.common;

import com.chelpus.Common;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZFormatException;

public class DecoderUtil extends Util {
    public static boolean isCRC32Valid(byte[] buf, int off, int len, int ref_off) {
        CRC32 crc32 = new CRC32();
        crc32.update(buf, off, len);
        long value = crc32.getValue();
        for (int i = 0; i < 4; i++) {
            if (((byte) ((int) (value >>> (i * 8)))) != buf[ref_off + i]) {
                return false;
            }
        }
        return true;
    }

    public static StreamFlags decodeStreamHeader(byte[] buf) throws IOException {
        for (int i = 0; i < XZ.HEADER_MAGIC.length; i++) {
            if (buf[i] != XZ.HEADER_MAGIC[i]) {
                throw new XZFormatException();
            }
        }
        if (isCRC32Valid(buf, XZ.HEADER_MAGIC.length, 2, XZ.HEADER_MAGIC.length + 2)) {
            try {
                return decodeStreamFlags(buf, XZ.HEADER_MAGIC.length);
            } catch (UnsupportedOptionsException e) {
                throw new UnsupportedOptionsException("Unsupported options in XZ Stream Header");
            }
        }
        throw new CorruptedInputException("XZ Stream Header is corrupt");
    }

    public static StreamFlags decodeStreamFooter(byte[] buf) throws IOException {
        if (buf[10] != XZ.FOOTER_MAGIC[0] || buf[11] != XZ.FOOTER_MAGIC[1]) {
            throw new CorruptedInputException("XZ Stream Footer is corrupt");
        } else if (isCRC32Valid(buf, 4, 6, 0)) {
            try {
                StreamFlags streamFlags = decodeStreamFlags(buf, 8);
                streamFlags.backwardSize = 0;
                for (int i = 0; i < 4; i++) {
                    streamFlags.backwardSize |= (long) ((buf[i + 4] & 255) << (i * 8));
                }
                streamFlags.backwardSize = (streamFlags.backwardSize + 1) * 4;
                return streamFlags;
            } catch (UnsupportedOptionsException e) {
                throw new UnsupportedOptionsException("Unsupported options in XZ Stream Footer");
            }
        } else {
            throw new CorruptedInputException("XZ Stream Footer is corrupt");
        }
    }

    private static StreamFlags decodeStreamFlags(byte[] buf, int off) throws UnsupportedOptionsException {
        if (buf[off] != (byte) 0 || (buf[off + 1] & 255) >= 16) {
            throw new UnsupportedOptionsException();
        }
        StreamFlags streamFlags = new StreamFlags();
        streamFlags.checkType = buf[off + 1];
        return streamFlags;
    }

    public static boolean areStreamFlagsEqual(StreamFlags a, StreamFlags b) {
        return a.checkType == b.checkType;
    }

    public static long decodeVLI(InputStream in) throws IOException {
        int b = in.read();
        if (b == -1) {
            throw new EOFException();
        }
        long num = (long) (b & 127);
        int i = 0;
        while ((b & Common.INSTALL_ALLOW_DOWNGRADE) != 0) {
            i++;
            if (i >= 9) {
                throw new CorruptedInputException();
            }
            b = in.read();
            if (b == -1) {
                throw new EOFException();
            } else if (b == 0) {
                throw new CorruptedInputException();
            } else {
                num |= ((long) (b & 127)) << (i * 7);
            }
        }
        return num;
    }
}
