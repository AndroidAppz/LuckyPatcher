package org.tukaani.xz.index;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.common.EncoderUtil;

public class IndexEncoder extends IndexBase {
    private final ArrayList records = new ArrayList();

    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }

    public IndexEncoder() {
        super(new XZIOException("XZ Stream or its Index has grown too big"));
    }

    public void add(long unpaddedSize, long uncompressedSize) throws XZIOException {
        super.add(unpaddedSize, uncompressedSize);
        this.records.add(new IndexRecord(unpaddedSize, uncompressedSize));
    }

    public void encode(OutputStream out) throws IOException {
        CRC32 crc32 = new CRC32();
        CheckedOutputStream outChecked = new CheckedOutputStream(out, crc32);
        outChecked.write(0);
        EncoderUtil.encodeVLI(outChecked, this.recordCount);
        int i = this.records.iterator();
        while (i.hasNext()) {
            IndexRecord record = (IndexRecord) i.next();
            EncoderUtil.encodeVLI(outChecked, record.unpadded);
            EncoderUtil.encodeVLI(outChecked, record.uncompressed);
        }
        for (i = getIndexPaddingSize(); i > 0; i--) {
            outChecked.write(0);
        }
        long value = crc32.getValue();
        for (i = 0; i < 4; i++) {
            out.write((byte) ((int) (value >>> (i * 8))));
        }
    }
}
