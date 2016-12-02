/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package kellinwood.zipio;

import java.io.IOException;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.zipio.ZipInput;
import kellinwood.zipio.ZipOutput;

public class CentralEnd {
    private static LoggerInterface log;
    public int centralDirectorySize;
    public short centralStartDisk = 0;
    public int centralStartOffset;
    public String fileComment;
    public short numCentralEntries;
    public short numberThisDisk = 0;
    public int signature = 101010256;
    public short totalCentralEntries;

    private void doRead(ZipInput zipInput) throws IOException {
        boolean bl = CentralEnd.getLogger().isDebugEnabled();
        this.numberThisDisk = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.numberThisDisk};
            loggerInterface.debug(String.format((String)"This disk number: 0x%04x", (Object[])arrobject));
        }
        this.centralStartDisk = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.centralStartDisk};
            loggerInterface.debug(String.format((String)"Central dir start disk number: 0x%04x", (Object[])arrobject));
        }
        this.numCentralEntries = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.numCentralEntries};
            loggerInterface.debug(String.format((String)"Central entries on this disk: 0x%04x", (Object[])arrobject));
        }
        this.totalCentralEntries = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.totalCentralEntries};
            loggerInterface.debug(String.format((String)"Total number of central entries: 0x%04x", (Object[])arrobject));
        }
        this.centralDirectorySize = zipInput.readInt();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.centralDirectorySize};
            loggerInterface.debug(String.format((String)"Central directory size: 0x%08x", (Object[])arrobject));
        }
        this.centralStartOffset = zipInput.readInt();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.centralStartOffset};
            loggerInterface.debug(String.format((String)"Central directory offset: 0x%08x", (Object[])arrobject));
        }
        this.fileComment = zipInput.readString(zipInput.readShort());
        if (bl) {
            log.debug(".ZIP file comment: " + this.fileComment);
        }
    }

    public static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(CentralEnd.class.getName());
        }
        return log;
    }

    public static CentralEnd read(ZipInput zipInput) throws IOException {
        if (zipInput.readInt() != 101010256) {
            zipInput.seek(zipInput.getFilePointer() - 4);
            return null;
        }
        CentralEnd centralEnd = new CentralEnd();
        centralEnd.doRead(zipInput);
        return centralEnd;
    }

    public void write(ZipOutput zipOutput) throws IOException {
        CentralEnd.getLogger().isDebugEnabled();
        zipOutput.writeInt(this.signature);
        zipOutput.writeShort(this.numberThisDisk);
        zipOutput.writeShort(this.centralStartDisk);
        zipOutput.writeShort(this.numCentralEntries);
        zipOutput.writeShort(this.totalCentralEntries);
        zipOutput.writeInt(this.centralDirectorySize);
        zipOutput.writeInt(this.centralStartOffset);
        zipOutput.writeShort((short)this.fileComment.length());
        zipOutput.writeString(this.fileComment);
    }
}

