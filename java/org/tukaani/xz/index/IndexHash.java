package org.tukaani.xz.index;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.CheckedInputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.check.CRC32;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.check.SHA256;
import org.tukaani.xz.common.DecoderUtil;

public class IndexHash extends IndexBase {
    private Check hash;

    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }

    public IndexHash() {
        super(new CorruptedInputException());
        try {
            this.hash = new SHA256();
        } catch (NoSuchAlgorithmException e) {
            this.hash = new CRC32();
        }
    }

    public void add(long unpaddedSize, long uncompressedSize) throws XZIOException {
        super.add(unpaddedSize, uncompressedSize);
        ByteBuffer buf = ByteBuffer.allocate(16);
        buf.putLong(unpaddedSize);
        buf.putLong(uncompressedSize);
        this.hash.update(buf.array());
    }

    public void validate(InputStream in) throws IOException {
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        crc32.update(0);
        CheckedInputStream inChecked = new CheckedInputStream(in, crc32);
        if (DecoderUtil.decodeVLI(inChecked) != this.recordCount) {
            throw new CorruptedInputException("XZ Index is corrupt");
        }
        IndexHash stored = new IndexHash();
        long i = 0;
        while (i < this.recordCount) {
            try {
                stored.add(DecoderUtil.decodeVLI(inChecked), DecoderUtil.decodeVLI(inChecked));
                if (stored.blocksSum > this.blocksSum || stored.uncompressedSum > this.uncompressedSum || stored.indexListSize > this.indexListSize) {
                    throw new CorruptedInputException("XZ Index is corrupt");
                }
                i++;
            } catch (XZIOException e) {
                throw new CorruptedInputException("XZ Index is corrupt");
            }
        }
        if (stored.blocksSum == this.blocksSum && stored.uncompressedSum == this.uncompressedSum && stored.indexListSize == this.indexListSize && Arrays.equals(stored.hash.finish(), this.hash.finish())) {
            int i2;
            DataInputStream inData = new DataInputStream(inChecked);
            for (i2 = getIndexPaddingSize(); i2 > 0; i2--) {
                if (inData.readUnsignedByte() != 0) {
                    throw new CorruptedInputException("XZ Index is corrupt");
                }
            }
            long value = crc32.getValue();
            for (i2 = 0; i2 < 4; i2++) {
                if (((value >>> (i2 * 8)) & 255) != ((long) inData.readUnsignedByte())) {
                    throw new CorruptedInputException("XZ Index is corrupt");
                }
            }
            return;
        }
        throw new CorruptedInputException("XZ Index is corrupt");
    }
}
