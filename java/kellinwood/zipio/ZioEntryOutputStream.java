package kellinwood.zipio;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class ZioEntryOutputStream extends OutputStream {
    CRC32 crc = new CRC32();
    int crcValue = 0;
    OutputStream downstream;
    int size = 0;
    OutputStream wrapped;

    public ZioEntryOutputStream(int compression, OutputStream wrapped) {
        this.wrapped = wrapped;
        if (compression != 0) {
            this.downstream = new DeflaterOutputStream(wrapped, new Deflater(9, true));
        } else {
            this.downstream = wrapped;
        }
    }

    public void close() throws IOException {
        this.downstream.flush();
        this.downstream.close();
        this.crcValue = (int) this.crc.getValue();
    }

    public int getCRC() {
        return this.crcValue;
    }

    public void flush() throws IOException {
        this.downstream.flush();
    }

    public void write(byte[] b) throws IOException {
        this.downstream.write(b);
        this.crc.update(b);
        this.size += b.length;
    }

    public void write(byte[] b, int off, int len) throws IOException {
        this.downstream.write(b, off, len);
        this.crc.update(b, off, len);
        this.size += len;
    }

    public void write(int b) throws IOException {
        this.downstream.write(b);
        this.crc.update(b);
        this.size++;
    }

    public int getSize() {
        return this.size;
    }

    public OutputStream getWrappedStream() {
        return this.wrapped;
    }
}
