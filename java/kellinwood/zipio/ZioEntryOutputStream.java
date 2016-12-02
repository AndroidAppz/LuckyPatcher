/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.util.zip.CRC32
 *  java.util.zip.Deflater
 *  java.util.zip.DeflaterOutputStream
 */
package kellinwood.zipio;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class ZioEntryOutputStream
extends OutputStream {
    CRC32 crc = new CRC32();
    int crcValue = 0;
    OutputStream downstream;
    int size = 0;
    OutputStream wrapped;

    public ZioEntryOutputStream(int n, OutputStream outputStream) {
        this.wrapped = outputStream;
        if (n != 0) {
            this.downstream = new DeflaterOutputStream(outputStream, new Deflater(9, true));
            return;
        }
        this.downstream = outputStream;
    }

    public void close() throws IOException {
        this.downstream.flush();
        this.downstream.close();
        this.crcValue = (int)this.crc.getValue();
    }

    public void flush() throws IOException {
        this.downstream.flush();
    }

    public int getCRC() {
        return this.crcValue;
    }

    public int getSize() {
        return this.size;
    }

    public OutputStream getWrappedStream() {
        return this.wrapped;
    }

    public void write(int n) throws IOException {
        this.downstream.write(n);
        this.crc.update(n);
        this.size = 1 + this.size;
    }

    public void write(byte[] arrby) throws IOException {
        this.downstream.write(arrby);
        this.crc.update(arrby);
        this.size += arrby.length;
    }

    public void write(byte[] arrby, int n, int n2) throws IOException {
        this.downstream.write(arrby, n, n2);
        this.crc.update(arrby, n, n2);
        this.size = n2 + this.size;
    }
}

