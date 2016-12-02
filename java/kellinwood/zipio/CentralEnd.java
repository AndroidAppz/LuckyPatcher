package kellinwood.zipio;

import java.io.IOException;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;

public class CentralEnd {
    private static LoggerInterface log;
    public int centralDirectorySize;
    public short centralStartDisk = (short) 0;
    public int centralStartOffset;
    public String fileComment;
    public short numCentralEntries;
    public short numberThisDisk = (short) 0;
    public int signature = 101010256;
    public short totalCentralEntries;

    public static CentralEnd read(ZipInput input) throws IOException {
        if (input.readInt() != 101010256) {
            input.seek(input.getFilePointer() - 4);
            return null;
        }
        CentralEnd entry = new CentralEnd();
        entry.doRead(input);
        return entry;
    }

    public static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(CentralEnd.class.getName());
        }
        return log;
    }

    private void doRead(ZipInput input) throws IOException {
        boolean debug = getLogger().isDebugEnabled();
        this.numberThisDisk = input.readShort();
        if (debug) {
            log.debug(String.format("This disk number: 0x%04x", new Object[]{Short.valueOf(this.numberThisDisk)}));
        }
        this.centralStartDisk = input.readShort();
        if (debug) {
            log.debug(String.format("Central dir start disk number: 0x%04x", new Object[]{Short.valueOf(this.centralStartDisk)}));
        }
        this.numCentralEntries = input.readShort();
        if (debug) {
            log.debug(String.format("Central entries on this disk: 0x%04x", new Object[]{Short.valueOf(this.numCentralEntries)}));
        }
        this.totalCentralEntries = input.readShort();
        if (debug) {
            log.debug(String.format("Total number of central entries: 0x%04x", new Object[]{Short.valueOf(this.totalCentralEntries)}));
        }
        this.centralDirectorySize = input.readInt();
        if (debug) {
            log.debug(String.format("Central directory size: 0x%08x", new Object[]{Integer.valueOf(this.centralDirectorySize)}));
        }
        this.centralStartOffset = input.readInt();
        if (debug) {
            log.debug(String.format("Central directory offset: 0x%08x", new Object[]{Integer.valueOf(this.centralStartOffset)}));
        }
        this.fileComment = input.readString(input.readShort());
        if (debug) {
            log.debug(".ZIP file comment: " + this.fileComment);
        }
    }

    public void write(ZipOutput output) throws IOException {
        boolean debug = getLogger().isDebugEnabled();
        output.writeInt(this.signature);
        output.writeShort(this.numberThisDisk);
        output.writeShort(this.centralStartDisk);
        output.writeShort(this.numCentralEntries);
        output.writeShort(this.totalCentralEntries);
        output.writeInt(this.centralDirectorySize);
        output.writeInt(this.centralStartOffset);
        output.writeShort((short) this.fileComment.length());
        output.writeString(this.fileComment);
    }
}
