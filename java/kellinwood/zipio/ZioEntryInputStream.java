package kellinwood.zipio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;

public class ZioEntryInputStream extends InputStream {
    boolean debug = this.log.isDebugEnabled();
    LoggerInterface log = LoggerManager.getLogger(getClass().getName());
    OutputStream monitor = null;
    int offset = 0;
    RandomAccessFile raf;
    boolean returnDummyByte = false;
    int size;

    public ZioEntryInputStream(ZioEntry entry) throws IOException {
        this.size = entry.getCompressedSize();
        this.raf = entry.getZipInput().in;
        if (entry.getDataPosition() >= 0) {
            if (this.debug) {
                this.log.debug(String.format("Seeking to %d", new Object[]{Long.valueOf(entry.getDataPosition())}));
            }
            this.raf.seek(entry.getDataPosition());
            return;
        }
        entry.readLocalHeader();
    }

    public void setReturnDummyByte(boolean returnExtraByte) {
        this.returnDummyByte = returnExtraByte;
    }

    public void setMonitorStream(OutputStream monitorStream) {
        this.monitor = monitorStream;
    }

    public void close() throws IOException {
    }

    public boolean markSupported() {
        return false;
    }

    public int available() throws IOException {
        int available = this.size - this.offset;
        if (this.debug) {
            this.log.debug(String.format("Available = %d", new Object[]{Integer.valueOf(available)}));
        }
        if (available == 0 && this.returnDummyByte) {
            return 1;
        }
        return available;
    }

    public int read() throws IOException {
        if (this.size - this.offset != 0) {
            int b = this.raf.read();
            if (b >= 0) {
                if (this.monitor != null) {
                    this.monitor.write(b);
                }
                if (this.debug) {
                    this.log.debug("Read 1 byte");
                }
                this.offset++;
                return b;
            } else if (!this.debug) {
                return b;
            } else {
                this.log.debug("Read 0 bytes");
                return b;
            }
        } else if (!this.returnDummyByte) {
            return -1;
        } else {
            this.returnDummyByte = false;
            return 0;
        }
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return readBytes(b, off, len);
    }

    private int readBytes(byte[] b, int off, int len) throws IOException {
        if (this.size - this.offset != 0) {
            int numRead = this.raf.read(b, off, Math.min(len, available()));
            if (numRead > 0) {
                if (this.monitor != null) {
                    this.monitor.write(b, off, numRead);
                }
                this.offset += numRead;
            }
            if (!this.debug) {
                return numRead;
            }
            this.log.debug(String.format("Read %d bytes for read(b,%d,%d)", new Object[]{Integer.valueOf(numRead), Integer.valueOf(off), Integer.valueOf(len)}));
            return numRead;
        } else if (!this.returnDummyByte) {
            return -1;
        } else {
            this.returnDummyByte = false;
            b[off] = (byte) 0;
            return 1;
        }
    }

    public int read(byte[] b) throws IOException {
        return readBytes(b, 0, b.length);
    }

    public long skip(long n) throws IOException {
        long numToSkip = Math.min(n, (long) available());
        this.raf.seek(this.raf.getFilePointer() + numToSkip);
        if (this.debug) {
            this.log.debug(String.format("Skipped %d bytes", new Object[]{Long.valueOf(numToSkip)}));
        }
        return numToSkip;
    }
}
