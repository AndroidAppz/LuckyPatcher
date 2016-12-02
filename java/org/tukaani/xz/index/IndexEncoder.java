/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.zip.CRC32
 *  java.util.zip.CheckedOutputStream
 *  java.util.zip.Checksum
 */
package org.tukaani.xz.index;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.common.EncoderUtil;
import org.tukaani.xz.index.IndexBase;
import org.tukaani.xz.index.IndexRecord;

public class IndexEncoder
extends IndexBase {
    private final ArrayList records = new ArrayList();

    public IndexEncoder() {
        super(new XZIOException("XZ Stream or its Index has grown too big"));
    }

    @Override
    public void add(long l, long l2) throws XZIOException {
        super.add(l, l2);
        this.records.add((Object)new IndexRecord(l, l2));
    }

    public void encode(OutputStream outputStream) throws IOException {
        CRC32 cRC32 = new CRC32();
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, (Checksum)cRC32);
        checkedOutputStream.write(0);
        EncoderUtil.encodeVLI((OutputStream)checkedOutputStream, this.recordCount);
        for (IndexRecord indexRecord : this.records) {
            EncoderUtil.encodeVLI((OutputStream)checkedOutputStream, indexRecord.unpadded);
            EncoderUtil.encodeVLI((OutputStream)checkedOutputStream, indexRecord.uncompressed);
        }
        for (int i = this.getIndexPaddingSize(); i > 0; --i) {
            checkedOutputStream.write(0);
        }
        long l = cRC32.getValue();
        for (int j = 0; j < 4; ++j) {
            outputStream.write((int)((byte)(l >>> j * 8)));
        }
    }
}

