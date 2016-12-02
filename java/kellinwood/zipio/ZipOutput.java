package kellinwood.zipio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;

public class ZipOutput {
    static LoggerInterface log;
    List<ZioEntry> entriesWritten = new LinkedList();
    int filePointer = 0;
    Set<String> namesWritten = new HashSet();
    OutputStream out = null;
    String outputFilename;

    public ZipOutput(String filename) throws IOException {
        this.outputFilename = filename;
        init(new File(this.outputFilename));
    }

    public ZipOutput(File outputFile) throws IOException {
        this.outputFilename = outputFile.getAbsolutePath();
        init(outputFile);
    }

    private void init(File ofile) throws IOException {
        if (ofile.exists()) {
            ofile.delete();
        }
        this.out = new FileOutputStream(ofile);
        if (getLogger().isDebugEnabled()) {
            ZipListingHelper.listHeader(getLogger());
        }
    }

    public ZipOutput(OutputStream os) throws IOException {
        this.out = os;
    }

    private static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZipOutput.class.getName());
        }
        return log;
    }

    public void write(ZioEntry entry) throws IOException {
        String entryName = entry.getName();
        if (this.namesWritten.contains(entryName)) {
            getLogger().warning("Skipping duplicate file in output: " + entryName);
            return;
        }
        entry.writeLocalEntry(this);
        this.entriesWritten.add(entry);
        this.namesWritten.add(entryName);
        if (getLogger().isDebugEnabled()) {
            ZipListingHelper.listEntry(getLogger(), entry);
        }
    }

    public void close() throws IOException {
        CentralEnd centralEnd = new CentralEnd();
        centralEnd.centralStartOffset = getFilePointer();
        short size = (short) this.entriesWritten.size();
        centralEnd.totalCentralEntries = size;
        centralEnd.numCentralEntries = size;
        for (ZioEntry entry : this.entriesWritten) {
            entry.write(this);
        }
        centralEnd.centralDirectorySize = getFilePointer() - centralEnd.centralStartOffset;
        centralEnd.fileComment = "";
        centralEnd.write(this);
        if (this.out != null) {
            try {
                this.out.close();
            } catch (Throwable th) {
            }
        }
    }

    public int getFilePointer() throws IOException {
        return this.filePointer;
    }

    public void writeInt(int value) throws IOException {
        byte[] data = new byte[4];
        for (int i = 0; i < 4; i++) {
            data[i] = (byte) (value & 255);
            value >>= 8;
        }
        this.out.write(data);
        this.filePointer += 4;
    }

    public void writeShort(short value) throws IOException {
        byte[] data = new byte[2];
        for (int i = 0; i < 2; i++) {
            data[i] = (byte) (value & 255);
            value = (short) (value >> 8);
        }
        this.out.write(data);
        this.filePointer += 2;
    }

    public void writeString(String value) throws IOException {
        byte[] data = value.getBytes();
        this.out.write(data);
        this.filePointer += data.length;
    }

    public void writeBytes(byte[] value) throws IOException {
        this.out.write(value);
        this.filePointer += value.length;
    }

    public void writeBytes(byte[] value, int offset, int length) throws IOException {
        this.out.write(value, offset, length);
        this.filePointer += length;
    }
}
