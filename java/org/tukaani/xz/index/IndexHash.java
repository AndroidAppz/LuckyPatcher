/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.security.NoSuchAlgorithmException
 *  java.util.Arrays
 *  java.util.zip.CRC32
 *  java.util.zip.CheckedInputStream
 *  java.util.zip.Checksum
 */
package org.tukaani.xz.index;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.check.SHA256;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.index.IndexBase;

public class IndexHash
extends IndexBase {
    private Check hash;

    public IndexHash() {
        super(new CorruptedInputException());
        try {
            this.hash = new SHA256();
            return;
        }
        catch (NoSuchAlgorithmException var1_1) {
            this.hash = new org.tukaani.xz.check.CRC32();
            return;
        }
    }

    @Override
    public void add(long l, long l2) throws XZIOException {
        super.add(l, l2);
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)16);
        byteBuffer.putLong(l);
        byteBuffer.putLong(l2);
        this.hash.update(byteBuffer.array());
    }

    public void validate(InputStream inputStream) throws IOException {
        CRC32 cRC32 = new CRC32();
        cRC32.update(0);
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, (Checksum)cRC32);
        if (DecoderUtil.decodeVLI((InputStream)checkedInputStream) != this.recordCount) {
            throw new CorruptedInputException("XZ Index is corrupt");
        }
        IndexHash indexHash = new IndexHash();
        for (long i = 0; i < this.recordCount; ++i) {
            long l = DecoderUtil.decodeVLI((InputStream)checkedInputStream);
            long l2 = DecoderUtil.decodeVLI((InputStream)checkedInputStream);
            try {
                indexHash.add(l, l2);
                if (indexHash.blocksSum <= this.blocksSum && indexHash.uncompressedSum <= this.uncompressedSum && indexHash.indexListSize <= this.indexListSize) continue;
            }
            catch (XZIOException var16_8) {
                throw new CorruptedInputException("XZ Index is corrupt");
            }
            throw new CorruptedInputException("XZ Index is corrupt");
        }
        if (indexHash.blocksSum != this.blocksSum || indexHash.uncompressedSum != this.uncompressedSum || indexHash.indexListSize != this.indexListSize || !Arrays.equals((byte[])indexHash.hash.finish(), (byte[])this.hash.finish())) {
            throw new CorruptedInputException("XZ Index is corrupt");
        }
        DataInputStream dataInputStream = new DataInputStream((InputStream)checkedInputStream);
        for (int j = this.getIndexPaddingSize(); j > 0; --j) {
            if (dataInputStream.readUnsignedByte() == 0) continue;
            throw new CorruptedInputException("XZ Index is corrupt");
        }
        long l = cRC32.getValue();
        for (int k = 0; k < 4; ++k) {
            if ((255 & l >>> k * 8) == (long)dataInputStream.readUnsignedByte()) continue;
            throw new CorruptedInputException("XZ Index is corrupt");
        }
    }
}

