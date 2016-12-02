/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.RandomAccessFile
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Set
 *  java.util.TreeSet
 *  java.util.jar.Manifest
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package kellinwood.zipio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.zipio.CentralEnd;
import kellinwood.zipio.ZioEntry;
import kellinwood.zipio.ZipListingHelper;

public class ZipInput {
    static LoggerInterface log;
    CentralEnd centralEnd;
    long fileLength;
    RandomAccessFile in = null;
    public String inputFilename;
    Manifest manifest;
    int scanIterations = 0;
    Map<String, ZioEntry> zioEntries = new LinkedHashMap();

    public ZipInput(String string) throws IOException {
        this.inputFilename = string;
        this.in = new RandomAccessFile(new File(this.inputFilename), "r");
        this.fileLength = this.in.length();
    }

    /*
     * Enabled aggressive exception aggregation
     */
    private void doRead() {
        try {
            long l = this.scanForEOCDR(256);
            this.in.seek(l);
            this.centralEnd = CentralEnd.read(this);
            boolean bl = ZipInput.getLogger().isDebugEnabled();
            if (bl) {
                LoggerInterface loggerInterface = ZipInput.getLogger();
                Object[] arrobject = new Object[]{this.scanIterations};
                loggerInterface.debug(String.format((String)"EOCD found in %d iterations", (Object[])arrobject));
                LoggerInterface loggerInterface2 = ZipInput.getLogger();
                Object[] arrobject2 = new Object[]{this.centralEnd.totalCentralEntries, this.centralEnd.centralDirectorySize, this.centralEnd.centralStartOffset, this.centralEnd.centralStartOffset};
                loggerInterface2.debug(String.format((String)"Directory entries=%d, size=%d, offset=%d/0x%08x", (Object[])arrobject2));
                ZipListingHelper.listHeader(ZipInput.getLogger());
            }
            this.in.seek((long)this.centralEnd.centralStartOffset);
            for (int i = 0; i < this.centralEnd.totalCentralEntries; ++i) {
                ZioEntry zioEntry = ZioEntry.read(this);
                this.zioEntries.put((Object)zioEntry.getName(), (Object)zioEntry);
                if (!bl) continue;
                ZipListingHelper.listEntry(ZipInput.getLogger(), zioEntry);
            }
        }
        catch (Throwable var1_9) {
            var1_9.printStackTrace();
        }
        {
            continue;
            break;
        }
    }

    private static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZipInput.class.getName());
        }
        return log;
    }

    public static ZipInput read(String string) throws IOException {
        ZipInput zipInput = new ZipInput(string);
        zipInput.doRead();
        return zipInput;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void close() {
        if (this.in == null) return;
        try {
            this.in.close();
            return;
        }
        catch (Throwable var1_1) {
            return;
        }
    }

    public Map<String, ZioEntry> getEntries() {
        return this.zioEntries;
    }

    public ZioEntry getEntry(String string) {
        return (ZioEntry)this.zioEntries.get((Object)string);
    }

    public long getFileLength() {
        return this.fileLength;
    }

    public long getFilePointer() throws IOException {
        return this.in.getFilePointer();
    }

    public String getFilename() {
        return this.inputFilename;
    }

    public Manifest getManifest() throws IOException {
        ZioEntry zioEntry;
        if (this.manifest == null && (zioEntry = (ZioEntry)this.zioEntries.get((Object)"META-INF/MANIFEST.MF")) != null) {
            this.manifest = new Manifest(zioEntry.getInputStream());
        }
        return this.manifest;
    }

    public Collection<String> list(String string) {
        if (!string.endsWith("/")) {
            throw new IllegalArgumentException("Invalid path -- does not end with '/'");
        }
        if (string.startsWith("/")) {
            string = string.substring(1);
        }
        Pattern pattern = Pattern.compile((String)String.format((String)"^%s([^/]+/?).*", (Object[])new Object[]{string}));
        TreeSet treeSet = new TreeSet();
        Iterator iterator = this.zioEntries.keySet().iterator();
        while (iterator.hasNext()) {
            Matcher matcher = pattern.matcher((CharSequence)((String)iterator.next()));
            if (!matcher.matches()) continue;
            treeSet.add((Object)matcher.group(1));
        }
        return treeSet;
    }

    public int read(byte[] arrby, int n, int n2) throws IOException {
        return this.in.read(arrby, n, n2);
    }

    public byte readByte() throws IOException {
        return this.in.readByte();
    }

    public byte[] readBytes(int n) throws IOException {
        byte[] arrby = new byte[n];
        for (int i = 0; i < n; ++i) {
            arrby[i] = this.in.readByte();
        }
        return arrby;
    }

    public int readInt() throws IOException {
        int n = 0;
        for (int i = 0; i < 4; ++i) {
            n |= this.in.readUnsignedByte() << i * 8;
        }
        return n;
    }

    public short readShort() throws IOException {
        short s = 0;
        for (int i = 0; i < 2; ++i) {
            s = (short)(s | this.in.readUnsignedByte() << i * 8);
        }
        return s;
    }

    public String readString(int n) throws IOException {
        byte[] arrby = new byte[n];
        for (int i = 0; i < n; ++i) {
            arrby[i] = this.in.readByte();
        }
        return new String(arrby);
    }

    public long scanForEOCDR(int n) throws IOException {
        if ((long)n > this.fileLength || n > 65536) {
            throw new IllegalStateException("End of central directory not found in " + this.inputFilename);
        }
        int n2 = (int)Math.min((long)this.fileLength, (long)n);
        byte[] arrby = new byte[n2];
        this.in.seek(this.fileLength - (long)n2);
        this.in.readFully(arrby);
        for (int i = n2 - 22; i >= 0; --i) {
            this.scanIterations = 1 + this.scanIterations;
            if (arrby[i] != 80 || arrby[i + 1] != 75 || arrby[i + 2] != 5 || arrby[i + 3] != 6) continue;
            return this.fileLength - (long)n2 + (long)i;
        }
        return this.scanForEOCDR(n * 2);
    }

    public void seek(long l) throws IOException {
        this.in.seek(l);
    }
}

