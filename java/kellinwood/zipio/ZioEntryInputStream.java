/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.RandomAccessFile
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package kellinwood.zipio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.zipio.ZioEntry;
import kellinwood.zipio.ZipInput;

public class ZioEntryInputStream
extends InputStream {
    boolean debug;
    LoggerInterface log;
    OutputStream monitor = null;
    int offset;
    RandomAccessFile raf;
    boolean returnDummyByte = false;
    int size;

    public ZioEntryInputStream(ZioEntry zioEntry) throws IOException {
        this.log = LoggerManager.getLogger(this.getClass().getName());
        this.debug = this.log.isDebugEnabled();
        this.offset = 0;
        this.size = zioEntry.getCompressedSize();
        this.raf = zioEntry.getZipInput().in;
        if (zioEntry.getDataPosition() >= 0) {
            if (this.debug) {
                LoggerInterface loggerInterface = this.log;
                Object[] arrobject = new Object[]{zioEntry.getDataPosition()};
                loggerInterface.debug(String.format((String)"Seeking to %d", (Object[])arrobject));
            }
            this.raf.seek(zioEntry.getDataPosition());
            return;
        }
        zioEntry.readLocalHeader();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int readBytes(byte[] arrby, int n, int n2) throws IOException {
        if (this.size - this.offset == 0) {
            if (!this.returnDummyByte) return -1;
            this.returnDummyByte = false;
            arrby[n] = 0;
            return 1;
        }
        int n3 = Math.min((int)n2, (int)this.available());
        int n4 = this.raf.read(arrby, n, n3);
        if (n4 > 0) {
            if (this.monitor != null) {
                this.monitor.write(arrby, n, n4);
            }
            this.offset = n4 + this.offset;
        }
        if (!this.debug) return n4;
        LoggerInterface loggerInterface = this.log;
        Object[] arrobject = new Object[]{n4, n, n2};
        loggerInterface.debug(String.format((String)"Read %d bytes for read(b,%d,%d)", (Object[])arrobject));
        return n4;
    }

    public int available() throws IOException {
        int n = this.size - this.offset;
        if (this.debug) {
            LoggerInterface loggerInterface = this.log;
            Object[] arrobject = new Object[]{n};
            loggerInterface.debug(String.format((String)"Available = %d", (Object[])arrobject));
        }
        if (n == 0 && this.returnDummyByte) {
            n = 1;
        }
        return n;
    }

    public void close() throws IOException {
    }

    public boolean markSupported() {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int read() throws IOException {
        int n = 0;
        if (this.size - this.offset == 0) {
            if (!this.returnDummyByte) {
                return -1;
            }
            this.returnDummyByte = false;
            return n;
        } else {
            n = this.raf.read();
            if (n >= 0) {
                if (this.monitor != null) {
                    this.monitor.write(n);
                }
                if (this.debug) {
                    this.log.debug("Read 1 byte");
                }
                this.offset = 1 + this.offset;
                return n;
            }
            if (!this.debug) return n;
            {
                this.log.debug("Read 0 bytes");
                return n;
            }
        }
    }

    public int read(byte[] arrby) throws IOException {
        return super.readBytes(arrby, 0, arrby.length);
    }

    public int read(byte[] arrby, int n, int n2) throws IOException {
        return super.readBytes(arrby, n, n2);
    }

    public void setMonitorStream(OutputStream outputStream) {
        this.monitor = outputStream;
    }

    public void setReturnDummyByte(boolean bl) {
        this.returnDummyByte = bl;
    }

    public long skip(long l) throws IOException {
        long l2 = Math.min((long)l, (long)this.available());
        this.raf.seek(l2 + this.raf.getFilePointer());
        if (this.debug) {
            LoggerInterface loggerInterface = this.log;
            Object[] arrobject = new Object[]{l2};
            loggerInterface.debug(String.format((String)"Skipped %d bytes", (Object[])arrobject));
        }
        return l2;
    }
}

