/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Set
 */
package kellinwood.zipio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.zipio.CentralEnd;
import kellinwood.zipio.ZioEntry;
import kellinwood.zipio.ZipListingHelper;

public class ZipOutput {
    static LoggerInterface log;
    List<ZioEntry> entriesWritten = new LinkedList();
    int filePointer = 0;
    Set<String> namesWritten = new HashSet();
    OutputStream out = null;
    String outputFilename;

    public ZipOutput(File file) throws IOException {
        this.outputFilename = file.getAbsolutePath();
        super.init(file);
    }

    public ZipOutput(OutputStream outputStream) throws IOException {
        this.out = outputStream;
    }

    public ZipOutput(String string) throws IOException {
        this.outputFilename = string;
        super.init(new File(this.outputFilename));
    }

    private static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZipOutput.class.getName());
        }
        return log;
    }

    private void init(File file) throws IOException {
        if (file.exists()) {
            file.delete();
        }
        this.out = new FileOutputStream(file);
        if (ZipOutput.getLogger().isDebugEnabled()) {
            ZipListingHelper.listHeader(ZipOutput.getLogger());
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void close() throws IOException {
        short s;
        CentralEnd centralEnd = new CentralEnd();
        centralEnd.centralStartOffset = this.getFilePointer();
        centralEnd.totalCentralEntries = s = (short)this.entriesWritten.size();
        centralEnd.numCentralEntries = s;
        Iterator iterator = this.entriesWritten.iterator();
        while (iterator.hasNext()) {
            ((ZioEntry)iterator.next()).write(this);
        }
        centralEnd.centralDirectorySize = this.getFilePointer() - centralEnd.centralStartOffset;
        centralEnd.fileComment = "";
        centralEnd.write(this);
        if (this.out == null) return;
        try {
            this.out.close();
            return;
        }
        catch (Throwable var4_4) {
            return;
        }
    }

    public int getFilePointer() throws IOException {
        return this.filePointer;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void write(ZioEntry zioEntry) throws IOException {
        String string = zioEntry.getName();
        if (this.namesWritten.contains((Object)string)) {
            ZipOutput.getLogger().warning("Skipping duplicate file in output: " + string);
            return;
        } else {
            zioEntry.writeLocalEntry((ZipOutput)this);
            this.entriesWritten.add((Object)zioEntry);
            this.namesWritten.add((Object)string);
            if (!ZipOutput.getLogger().isDebugEnabled()) return;
            {
                ZipListingHelper.listEntry(ZipOutput.getLogger(), zioEntry);
                return;
            }
        }
    }

    public void writeBytes(byte[] arrby) throws IOException {
        this.out.write(arrby);
        this.filePointer += arrby.length;
    }

    public void writeBytes(byte[] arrby, int n, int n2) throws IOException {
        this.out.write(arrby, n, n2);
        this.filePointer = n2 + this.filePointer;
    }

    public void writeInt(int n) throws IOException {
        byte[] arrby = new byte[4];
        for (int i = 0; i < 4; ++i) {
            arrby[i] = (byte)(n & 255);
            n >>= 8;
        }
        this.out.write(arrby);
        this.filePointer = 4 + this.filePointer;
    }

    public void writeShort(short s) throws IOException {
        byte[] arrby = new byte[2];
        for (int i = 0; i < 2; ++i) {
            arrby[i] = (byte)(s & 255);
            s = (short)(s >> 8);
        }
        this.out.write(arrby);
        this.filePointer = 2 + this.filePointer;
    }

    public void writeString(String string) throws IOException {
        byte[] arrby = string.getBytes();
        this.out.write(arrby);
        this.filePointer += arrby.length;
    }
}

