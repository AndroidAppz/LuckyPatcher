package kellinwood.zipio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Date;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import net.lingala.zip4j.util.InternalZipConstants;

public class ZioEntry implements Cloneable {
    private static byte[] alignBytes = new byte[4];
    private static LoggerInterface log;
    private int compressedSize;
    private short compression;
    private int crc32;
    private byte[] data = null;
    private long dataPosition = -1;
    private short diskNumberStart;
    private ZioEntryOutputStream entryOut = null;
    private int externalAttributes;
    private byte[] extraData;
    private String fileComment;
    private String filename;
    private short generalPurposeBits;
    private short internalAttributes;
    private int localHeaderOffset;
    private short modificationDate;
    private short modificationTime;
    private short numAlignBytes = (short) 0;
    private int size;
    private short versionMadeBy;
    private short versionRequired;
    private ZipInput zipInput;

    public ZioEntry(ZipInput input) {
        this.zipInput = input;
    }

    public static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZioEntry.class.getName());
        }
        return log;
    }

    public ZioEntry(String name) {
        this.filename = name;
        this.fileComment = "";
        this.compression = (short) 8;
        this.extraData = new byte[0];
        setTime(System.currentTimeMillis());
    }

    public ZioEntry(String name, String sourceDataFile) throws IOException {
        this.zipInput = new ZipInput(sourceDataFile);
        this.filename = name;
        this.fileComment = "";
        this.compression = (short) 0;
        this.size = (int) this.zipInput.getFileLength();
        this.compressedSize = this.size;
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(String.format("Computing CRC for %s, size=%d", new Object[]{sourceDataFile, Integer.valueOf(this.size)}));
        }
        CRC32 crc = new CRC32();
        byte[] buffer = new byte[8096];
        int numRead = 0;
        while (numRead != this.size) {
            int count = this.zipInput.read(buffer, 0, Math.min(buffer.length, this.size - numRead));
            if (count > 0) {
                crc.update(buffer, 0, count);
                numRead += count;
            }
        }
        this.crc32 = (int) crc.getValue();
        this.zipInput.seek(0);
        this.dataPosition = 0;
        this.extraData = new byte[0];
        setTime(new File(sourceDataFile).lastModified());
    }

    public ZioEntry(String name, String sourceDataFile, short compression, int crc32, int compressedSize, int size) throws IOException {
        this.zipInput = new ZipInput(sourceDataFile);
        this.filename = name;
        this.fileComment = "";
        this.compression = compression;
        this.crc32 = crc32;
        this.compressedSize = compressedSize;
        this.size = size;
        this.dataPosition = 0;
        this.extraData = new byte[0];
        setTime(new File(sourceDataFile).lastModified());
    }

    public ZioEntry getClonedEntry(String newName) {
        try {
            ZioEntry clone = (ZioEntry) clone();
            clone.setName(newName);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("clone() failed!");
        }
    }

    public void readLocalHeader() throws IOException {
        ZipInput input = this.zipInput;
        boolean debug = getLogger().isDebugEnabled();
        input.seek((long) this.localHeaderOffset);
        if (debug) {
            getLogger().debug(String.format("FILE POSITION: 0x%08x", new Object[]{Long.valueOf(input.getFilePointer())}));
        }
        if (input.readInt() != 67324752) {
            throw new IllegalStateException(String.format("Local header not found at pos=0x%08x, file=%s", new Object[]{Long.valueOf(input.getFilePointer()), this.filename}));
        }
        short tmpShort = input.readShort();
        if (debug) {
            log.debug(String.format("Version required: 0x%04x", new Object[]{Short.valueOf(tmpShort)}));
        }
        tmpShort = input.readShort();
        if (debug) {
            log.debug(String.format("General purpose bits: 0x%04x", new Object[]{Short.valueOf(tmpShort)}));
        }
        tmpShort = input.readShort();
        if (debug) {
            log.debug(String.format("Compression: 0x%04x", new Object[]{Short.valueOf(tmpShort)}));
        }
        tmpShort = input.readShort();
        if (debug) {
            log.debug(String.format("Modification time: 0x%04x", new Object[]{Short.valueOf(tmpShort)}));
        }
        tmpShort = input.readShort();
        if (debug) {
            log.debug(String.format("Modification date: 0x%04x", new Object[]{Short.valueOf(tmpShort)}));
        }
        int tmpInt = input.readInt();
        if (debug) {
            log.debug(String.format("CRC-32: 0x%04x", new Object[]{Integer.valueOf(tmpInt)}));
        }
        tmpInt = input.readInt();
        if (debug) {
            log.debug(String.format("Compressed size: 0x%04x", new Object[]{Integer.valueOf(tmpInt)}));
        }
        tmpInt = input.readInt();
        if (debug) {
            log.debug(String.format("Size: 0x%04x", new Object[]{Integer.valueOf(tmpInt)}));
        }
        short fileNameLen = input.readShort();
        if (debug) {
            log.debug(String.format("File name length: 0x%04x", new Object[]{Short.valueOf(fileNameLen)}));
        }
        short extraLen = input.readShort();
        if (debug) {
            log.debug(String.format("Extra length: 0x%04x", new Object[]{Short.valueOf(extraLen)}));
        }
        String filename = input.readString(fileNameLen);
        if (debug) {
            log.debug("Filename: " + filename);
        }
        byte[] extra = input.readBytes(extraLen);
        this.dataPosition = input.getFilePointer();
        if (debug) {
            log.debug(String.format("Data position: 0x%08x", new Object[]{Long.valueOf(this.dataPosition)}));
        }
    }

    public void writeLocalEntry(ZipOutput output) throws IOException {
        if (this.data == null && this.dataPosition < 0 && this.zipInput != null) {
            readLocalHeader();
        }
        this.localHeaderOffset = output.getFilePointer();
        boolean debug = getLogger().isDebugEnabled();
        if (debug) {
            getLogger().debug(String.format("Writing local header at 0x%08x - %s", new Object[]{Integer.valueOf(this.localHeaderOffset), this.filename}));
        }
        if (this.entryOut != null) {
            this.entryOut.close();
            this.size = this.entryOut.getSize();
            this.data = ((ByteArrayOutputStream) this.entryOut.getWrappedStream()).toByteArray();
            this.compressedSize = this.data.length;
            this.crc32 = this.entryOut.getCRC();
        }
        output.writeInt(67324752);
        output.writeShort(this.versionRequired);
        output.writeShort(this.generalPurposeBits);
        output.writeShort(this.compression);
        output.writeShort(this.modificationTime);
        output.writeShort(this.modificationDate);
        output.writeInt(this.crc32);
        output.writeInt(this.compressedSize);
        output.writeInt(this.size);
        output.writeShort((short) this.filename.length());
        this.numAlignBytes = (short) 0;
        if (this.compression == (short) 0) {
            short dataPosMod4 = (short) ((int) (((long) (((output.getFilePointer() + 2) + this.filename.length()) + this.extraData.length)) % 4));
            if (dataPosMod4 > (short) 0) {
                this.numAlignBytes = (short) (4 - dataPosMod4);
            }
        }
        output.writeShort((short) (this.extraData.length + this.numAlignBytes));
        output.writeString(this.filename);
        output.writeBytes(this.extraData);
        if (this.numAlignBytes > (short) 0) {
            output.writeBytes(alignBytes, 0, this.numAlignBytes);
        }
        if (debug) {
            getLogger().debug(String.format("Data position 0x%08x", new Object[]{Integer.valueOf(output.getFilePointer())}));
        }
        if (this.data != null) {
            output.writeBytes(this.data);
            if (debug) {
                getLogger().debug(String.format("Wrote %d bytes", new Object[]{Integer.valueOf(this.data.length)}));
                return;
            }
            return;
        }
        if (debug) {
            getLogger().debug(String.format("Seeking to position 0x%08x", new Object[]{Long.valueOf(this.dataPosition)}));
        }
        this.zipInput.seek(this.dataPosition);
        int bufferSize = Math.min(this.compressedSize, 8096);
        byte[] buffer = new byte[bufferSize];
        long totalCount = 0;
        while (totalCount != ((long) this.compressedSize)) {
            int numRead = this.zipInput.in.read(buffer, 0, (int) Math.min(((long) this.compressedSize) - totalCount, (long) bufferSize));
            if (numRead > 0) {
                output.writeBytes(buffer, 0, numRead);
                if (debug) {
                    getLogger().debug(String.format("Wrote %d bytes", new Object[]{Integer.valueOf(numRead)}));
                }
                totalCount += (long) numRead;
            } else {
                throw new IllegalStateException(String.format("EOF reached while copying %s with %d bytes left to go", new Object[]{this.filename, Long.valueOf(((long) this.compressedSize) - totalCount)}));
            }
        }
    }

    public static ZioEntry read(ZipInput input) throws IOException {
        if (input.readInt() != 33639248) {
            input.seek(input.getFilePointer() - 4);
            return null;
        }
        ZioEntry entry = new ZioEntry(input);
        entry.doRead(input);
        return entry;
    }

    private void doRead(ZipInput input) throws IOException {
        boolean debug = getLogger().isDebugEnabled();
        this.versionMadeBy = input.readShort();
        if (debug) {
            log.debug(String.format("Version made by: 0x%04x", new Object[]{Short.valueOf(this.versionMadeBy)}));
        }
        this.versionRequired = input.readShort();
        if (debug) {
            log.debug(String.format("Version required: 0x%04x", new Object[]{Short.valueOf(this.versionRequired)}));
        }
        this.generalPurposeBits = input.readShort();
        if (debug) {
            log.debug(String.format("General purpose bits: 0x%04x", new Object[]{Short.valueOf(this.generalPurposeBits)}));
        }
        if ((this.generalPurposeBits & 63473) != 0) {
            throw new IllegalStateException("Can't handle general purpose bits == " + String.format("0x%04x", new Object[]{Short.valueOf(this.generalPurposeBits)}));
        }
        this.compression = input.readShort();
        if (debug) {
            log.debug(String.format("Compression: 0x%04x", new Object[]{Short.valueOf(this.compression)}));
        }
        this.modificationTime = input.readShort();
        if (debug) {
            log.debug(String.format("Modification time: 0x%04x", new Object[]{Short.valueOf(this.modificationTime)}));
        }
        this.modificationDate = input.readShort();
        if (debug) {
            log.debug(String.format("Modification date: 0x%04x", new Object[]{Short.valueOf(this.modificationDate)}));
        }
        this.crc32 = input.readInt();
        if (debug) {
            log.debug(String.format("CRC-32: 0x%04x", new Object[]{Integer.valueOf(this.crc32)}));
        }
        this.compressedSize = input.readInt();
        if (debug) {
            log.debug(String.format("Compressed size: 0x%04x", new Object[]{Integer.valueOf(this.compressedSize)}));
        }
        this.size = input.readInt();
        if (debug) {
            log.debug(String.format("Size: 0x%04x", new Object[]{Integer.valueOf(this.size)}));
        }
        short fileNameLen = input.readShort();
        if (debug) {
            log.debug(String.format("File name length: 0x%04x", new Object[]{Short.valueOf(fileNameLen)}));
        }
        short extraLen = input.readShort();
        if (debug) {
            log.debug(String.format("Extra length: 0x%04x", new Object[]{Short.valueOf(extraLen)}));
        }
        short fileCommentLen = input.readShort();
        if (debug) {
            log.debug(String.format("File comment length: 0x%04x", new Object[]{Short.valueOf(fileCommentLen)}));
        }
        this.diskNumberStart = input.readShort();
        if (debug) {
            log.debug(String.format("Disk number start: 0x%04x", new Object[]{Short.valueOf(this.diskNumberStart)}));
        }
        this.internalAttributes = input.readShort();
        if (debug) {
            log.debug(String.format("Internal attributes: 0x%04x", new Object[]{Short.valueOf(this.internalAttributes)}));
        }
        this.externalAttributes = input.readInt();
        if (debug) {
            log.debug(String.format("External attributes: 0x%08x", new Object[]{Integer.valueOf(this.externalAttributes)}));
        }
        this.localHeaderOffset = input.readInt();
        if (debug) {
            log.debug(String.format("Local header offset: 0x%08x", new Object[]{Integer.valueOf(this.localHeaderOffset)}));
        }
        this.filename = input.readString(fileNameLen);
        if (debug) {
            log.debug("Filename: " + this.filename);
        }
        this.extraData = input.readBytes(extraLen);
        this.fileComment = input.readString(fileCommentLen);
        if (debug) {
            log.debug("File comment: " + this.fileComment);
        }
        this.generalPurposeBits = (short) (this.generalPurposeBits & InternalZipConstants.UFT8_NAMES_FLAG);
        if (this.size == 0) {
            this.compressedSize = 0;
            this.compression = (short) 0;
            this.crc32 = 0;
        }
    }

    public byte[] getData() throws IOException {
        if (this.data != null) {
            return this.data;
        }
        byte[] tmpdata = new byte[this.size];
        InputStream din = getInputStream();
        int count = 0;
        while (count != this.size) {
            int numRead = din.read(tmpdata, count, this.size - count);
            if (numRead < 0) {
                throw new IllegalStateException(String.format("Read failed, expecting %d bytes, got %d instead", new Object[]{Integer.valueOf(this.size), Integer.valueOf(count)}));
            }
            count += numRead;
        }
        return tmpdata;
    }

    public InputStream getInputStream() throws IOException {
        return getInputStream(null);
    }

    public InputStream getInputStream(OutputStream monitorStream) throws IOException {
        if (this.entryOut != null) {
            this.entryOut.close();
            this.size = this.entryOut.getSize();
            this.data = ((ByteArrayOutputStream) this.entryOut.getWrappedStream()).toByteArray();
            this.compressedSize = this.data.length;
            this.crc32 = this.entryOut.getCRC();
            this.entryOut = null;
            InputStream rawis = new ByteArrayInputStream(this.data);
            if (this.compression == (short) 0) {
                return rawis;
            }
            return new InflaterInputStream(new SequenceInputStream(rawis, new ByteArrayInputStream(new byte[1])), new Inflater(true));
        }
        InputStream dataStream = new ZioEntryInputStream(this);
        if (monitorStream != null) {
            dataStream.setMonitorStream(monitorStream);
        }
        if (this.compression == (short) 0) {
            return dataStream;
        }
        dataStream.setReturnDummyByte(true);
        return new InflaterInputStream(dataStream, new Inflater(true));
    }

    public OutputStream getOutputStream() {
        this.entryOut = new ZioEntryOutputStream(this.compression, new ByteArrayOutputStream());
        return this.entryOut;
    }

    public void write(ZipOutput output) throws IOException {
        boolean debug = getLogger().isDebugEnabled();
        output.writeInt(33639248);
        output.writeShort(this.versionMadeBy);
        output.writeShort(this.versionRequired);
        output.writeShort(this.generalPurposeBits);
        output.writeShort(this.compression);
        output.writeShort(this.modificationTime);
        output.writeShort(this.modificationDate);
        output.writeInt(this.crc32);
        output.writeInt(this.compressedSize);
        output.writeInt(this.size);
        output.writeShort((short) this.filename.length());
        output.writeShort((short) (this.extraData.length + this.numAlignBytes));
        output.writeShort((short) this.fileComment.length());
        output.writeShort(this.diskNumberStart);
        output.writeShort(this.internalAttributes);
        output.writeInt(this.externalAttributes);
        output.writeInt(this.localHeaderOffset);
        output.writeString(this.filename);
        output.writeBytes(this.extraData);
        if (this.numAlignBytes > (short) 0) {
            output.writeBytes(alignBytes, 0, this.numAlignBytes);
        }
        output.writeString(this.fileComment);
    }

    public long getTime() {
        return new Date(((this.modificationDate >> 9) & 127) + 80, ((this.modificationDate >> 5) & 15) - 1, this.modificationDate & 31, (this.modificationTime >> 11) & 31, (this.modificationTime >> 5) & 63, (this.modificationTime << 1) & 62).getTime();
    }

    public void setTime(long time) {
        long dtime;
        Date d = new Date(time);
        int year = d.getYear() + 1900;
        if (year < 1980) {
            dtime = 2162688;
        } else {
            dtime = (long) (((((((year - 1980) << 25) | ((d.getMonth() + 1) << 21)) | (d.getDate() << 16)) | (d.getHours() << 11)) | (d.getMinutes() << 5)) | (d.getSeconds() >> 1));
        }
        this.modificationDate = (short) ((int) (dtime >> 16));
        this.modificationTime = (short) ((int) (65535 & dtime));
    }

    public boolean isDirectory() {
        return this.filename.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR);
    }

    public String getName() {
        return this.filename;
    }

    public void setName(String filename) {
        this.filename = filename;
    }

    public void setCompression(int compression) {
        this.compression = (short) compression;
    }

    public short getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public short getVersionRequired() {
        return this.versionRequired;
    }

    public short getGeneralPurposeBits() {
        return this.generalPurposeBits;
    }

    public short getCompression() {
        return this.compression;
    }

    public int getCrc32() {
        return this.crc32;
    }

    public int getCompressedSize() {
        return this.compressedSize;
    }

    public int getSize() {
        return this.size;
    }

    public byte[] getExtraData() {
        return this.extraData;
    }

    public String getFileComment() {
        return this.fileComment;
    }

    public short getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public short getInternalAttributes() {
        return this.internalAttributes;
    }

    public int getExternalAttributes() {
        return this.externalAttributes;
    }

    public int getLocalHeaderOffset() {
        return this.localHeaderOffset;
    }

    public long getDataPosition() {
        return this.dataPosition;
    }

    public ZioEntryOutputStream getEntryOut() {
        return this.entryOut;
    }

    public ZipInput getZipInput() {
        return this.zipInput;
    }
}
