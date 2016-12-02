/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.util.zip.CRC32
 */
package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import net.lingala.zip4j.io.DeflaterOutputStream;
import net.lingala.zip4j.model.ZipModel;

public class ZipOutputStream
extends DeflaterOutputStream {
    public ZipOutputStream(OutputStream outputStream) {
        super(outputStream, null);
    }

    public ZipOutputStream(OutputStream outputStream, ZipModel zipModel) {
        super(outputStream, zipModel);
    }

    @Override
    public void write(int n) throws IOException {
        byte[] arrby = new byte[]{(byte)n};
        this.write(arrby, 0, 1);
    }

    @Override
    public void write(byte[] arrby) throws IOException {
        this.write(arrby, 0, arrby.length);
    }

    @Override
    public void write(byte[] arrby, int n, int n2) throws IOException {
        this.crc.update(arrby, n, n2);
        this.updateTotalBytesRead(n2);
        super.write(arrby, n, n2);
    }
}

