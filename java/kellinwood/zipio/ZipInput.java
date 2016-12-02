package kellinwood.zipio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import net.lingala.zip4j.util.InternalZipConstants;
import pxb.android.ResConst;

public class ZipInput {
    static LoggerInterface log;
    CentralEnd centralEnd;
    long fileLength;
    RandomAccessFile in = null;
    public String inputFilename;
    Manifest manifest;
    int scanIterations = 0;
    Map<String, ZioEntry> zioEntries = new LinkedHashMap();

    public ZipInput(String filename) throws IOException {
        this.inputFilename = filename;
        this.in = new RandomAccessFile(new File(this.inputFilename), InternalZipConstants.READ_MODE);
        this.fileLength = this.in.length();
    }

    private static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZipInput.class.getName());
        }
        return log;
    }

    public String getFilename() {
        return this.inputFilename;
    }

    public long getFileLength() {
        return this.fileLength;
    }

    public static ZipInput read(String filename) throws IOException {
        ZipInput zipInput = new ZipInput(filename);
        zipInput.doRead();
        return zipInput;
    }

    public ZioEntry getEntry(String filename) {
        return (ZioEntry) this.zioEntries.get(filename);
    }

    public Map<String, ZioEntry> getEntries() {
        return this.zioEntries;
    }

    public Collection<String> list(String path) {
        if (path.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            if (path.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                path = path.substring(1);
            }
            Pattern p = Pattern.compile(String.format("^%s([^/]+/?).*", new Object[]{path}));
            Set<String> names = new TreeSet();
            for (String name : this.zioEntries.keySet()) {
                Matcher m = p.matcher(name);
                if (m.matches()) {
                    names.add(m.group(1));
                }
            }
            return names;
        }
        throw new IllegalArgumentException("Invalid path -- does not end with '/'");
    }

    public Manifest getManifest() throws IOException {
        if (this.manifest == null) {
            ZioEntry e = (ZioEntry) this.zioEntries.get("META-INF/MANIFEST.MF");
            if (e != null) {
                this.manifest = new Manifest(e.getInputStream());
            }
        }
        return this.manifest;
    }

    public long scanForEOCDR(int size) throws IOException {
        if (((long) size) > this.fileLength || size > InternalZipConstants.MIN_SPLIT_LENGTH) {
            throw new IllegalStateException("End of central directory not found in " + this.inputFilename);
        }
        int scanSize = (int) Math.min(this.fileLength, (long) size);
        byte[] scanBuf = new byte[scanSize];
        this.in.seek(this.fileLength - ((long) scanSize));
        this.in.readFully(scanBuf);
        int i = scanSize - 22;
        while (i >= 0) {
            this.scanIterations++;
            if (scanBuf[i] == (byte) 80 && scanBuf[i + 1] == (byte) 75 && scanBuf[i + 2] == (byte) 5 && scanBuf[i + 3] == (byte) 6) {
                return (this.fileLength - ((long) scanSize)) + ((long) i);
            }
            i--;
        }
        return scanForEOCDR(size * 2);
    }

    private void doRead() {
        try {
            this.in.seek(scanForEOCDR(ResConst.RES_XML_START_NAMESPACE_TYPE));
            this.centralEnd = CentralEnd.read(this);
            boolean debug = getLogger().isDebugEnabled();
            if (debug) {
                getLogger().debug(String.format("EOCD found in %d iterations", new Object[]{Integer.valueOf(this.scanIterations)}));
                getLogger().debug(String.format("Directory entries=%d, size=%d, offset=%d/0x%08x", new Object[]{Short.valueOf(this.centralEnd.totalCentralEntries), Integer.valueOf(this.centralEnd.centralDirectorySize), Integer.valueOf(this.centralEnd.centralStartOffset), Integer.valueOf(this.centralEnd.centralStartOffset)}));
                ZipListingHelper.listHeader(getLogger());
            }
            this.in.seek((long) this.centralEnd.centralStartOffset);
            for (short i = (short) 0; i < this.centralEnd.totalCentralEntries; i++) {
                ZioEntry entry = ZioEntry.read(this);
                this.zioEntries.put(entry.getName(), entry);
                if (debug) {
                    ZipListingHelper.listEntry(getLogger(), entry);
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void close() {
        if (this.in != null) {
            try {
                this.in.close();
            } catch (Throwable th) {
            }
        }
    }

    public long getFilePointer() throws IOException {
        return this.in.getFilePointer();
    }

    public void seek(long position) throws IOException {
        this.in.seek(position);
    }

    public byte readByte() throws IOException {
        return this.in.readByte();
    }

    public int readInt() throws IOException {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result |= this.in.readUnsignedByte() << (i * 8);
        }
        return result;
    }

    public short readShort() throws IOException {
        short result = (short) 0;
        for (int i = 0; i < 2; i++) {
            result = (short) ((this.in.readUnsignedByte() << (i * 8)) | result);
        }
        return result;
    }

    public String readString(int length) throws IOException {
        byte[] buffer = new byte[length];
        for (int i = 0; i < length; i++) {
            buffer[i] = this.in.readByte();
        }
        return new String(buffer);
    }

    public byte[] readBytes(int length) throws IOException {
        byte[] buffer = new byte[length];
        for (int i = 0; i < length; i++) {
            buffer[i] = this.in.readByte();
        }
        return buffer;
    }

    public int read(byte[] b, int offset, int length) throws IOException {
        return this.in.read(b, offset, length);
    }
}
