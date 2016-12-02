/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.RandomAccessFile
 *  java.io.SequenceInputStream
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Date
 *  java.util.zip.CRC32
 *  java.util.zip.Inflater
 *  java.util.zip.InflaterInputStream
 */
package kellinwood.zipio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.Date;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import kellinwood.zipio.ZioEntryInputStream;
import kellinwood.zipio.ZioEntryOutputStream;
import kellinwood.zipio.ZipInput;
import kellinwood.zipio.ZipOutput;

public class ZioEntry
implements Cloneable {
    private static byte[] alignBytes = new byte[4];
    private static LoggerInterface log;
    private int compressedSize;
    private short compression;
    private int crc32;
    private byte[] data;
    private long dataPosition;
    private short diskNumberStart;
    private ZioEntryOutputStream entryOut;
    private int externalAttributes;
    private byte[] extraData;
    private String fileComment;
    private String filename;
    private short generalPurposeBits;
    private short internalAttributes;
    private int localHeaderOffset;
    private short modificationDate;
    private short modificationTime;
    private short numAlignBytes;
    private int size;
    private short versionMadeBy;
    private short versionRequired;
    private ZipInput zipInput;

    public ZioEntry(String string) {
        this.numAlignBytes = 0;
        this.dataPosition = -1;
        this.data = null;
        this.entryOut = null;
        this.filename = string;
        this.fileComment = "";
        this.compression = 8;
        this.extraData = new byte[0];
        this.setTime(System.currentTimeMillis());
    }

    public ZioEntry(String string, String string2) throws IOException {
        this.numAlignBytes = 0;
        this.dataPosition = -1;
        this.data = null;
        this.entryOut = null;
        this.zipInput = new ZipInput(string2);
        this.filename = string;
        this.fileComment = "";
        this.compression = 0;
        this.compressedSize = this.size = (int)this.zipInput.getFileLength();
        if (ZioEntry.getLogger().isDebugEnabled()) {
            LoggerInterface loggerInterface = ZioEntry.getLogger();
            Object[] arrobject = new Object[]{string2, this.size};
            loggerInterface.debug(String.format((String)"Computing CRC for %s, size=%d", (Object[])arrobject));
        }
        CRC32 cRC32 = new CRC32();
        byte[] arrby = new byte[8096];
        int n = 0;
        while (n != this.size) {
            int n2 = this.zipInput.read(arrby, 0, Math.min((int)arrby.length, (int)(this.size - n)));
            if (n2 <= 0) continue;
            cRC32.update(arrby, 0, n2);
            n += n2;
        }
        this.crc32 = (int)cRC32.getValue();
        this.zipInput.seek(0);
        this.dataPosition = 0;
        this.extraData = new byte[0];
        this.setTime(new File(string2).lastModified());
    }

    public ZioEntry(String string, String string2, short s, int n, int n2, int n3) throws IOException {
        this.numAlignBytes = 0;
        this.dataPosition = -1;
        this.data = null;
        this.entryOut = null;
        this.zipInput = new ZipInput(string2);
        this.filename = string;
        this.fileComment = "";
        this.compression = s;
        this.crc32 = n;
        this.compressedSize = n2;
        this.size = n3;
        this.dataPosition = 0;
        this.extraData = new byte[0];
        this.setTime(new File(string2).lastModified());
    }

    public ZioEntry(ZipInput zipInput) {
        this.numAlignBytes = 0;
        this.dataPosition = -1;
        this.data = null;
        this.entryOut = null;
        this.zipInput = zipInput;
    }

    private void doRead(ZipInput zipInput) throws IOException {
        boolean bl = ZioEntry.getLogger().isDebugEnabled();
        this.versionMadeBy = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.versionMadeBy};
            loggerInterface.debug(String.format((String)"Version made by: 0x%04x", (Object[])arrobject));
        }
        this.versionRequired = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.versionRequired};
            loggerInterface.debug(String.format((String)"Version required: 0x%04x", (Object[])arrobject));
        }
        this.generalPurposeBits = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.generalPurposeBits};
            loggerInterface.debug(String.format((String)"General purpose bits: 0x%04x", (Object[])arrobject));
        }
        if ((63473 & this.generalPurposeBits) != 0) {
            StringBuilder stringBuilder = new StringBuilder().append("Can't handle general purpose bits == ");
            Object[] arrobject = new Object[]{this.generalPurposeBits};
            throw new IllegalStateException(stringBuilder.append(String.format((String)"0x%04x", (Object[])arrobject)).toString());
        }
        this.compression = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.compression};
            loggerInterface.debug(String.format((String)"Compression: 0x%04x", (Object[])arrobject));
        }
        this.modificationTime = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.modificationTime};
            loggerInterface.debug(String.format((String)"Modification time: 0x%04x", (Object[])arrobject));
        }
        this.modificationDate = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.modificationDate};
            loggerInterface.debug(String.format((String)"Modification date: 0x%04x", (Object[])arrobject));
        }
        this.crc32 = zipInput.readInt();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.crc32};
            loggerInterface.debug(String.format((String)"CRC-32: 0x%04x", (Object[])arrobject));
        }
        this.compressedSize = zipInput.readInt();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.compressedSize};
            loggerInterface.debug(String.format((String)"Compressed size: 0x%04x", (Object[])arrobject));
        }
        this.size = zipInput.readInt();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.size};
            loggerInterface.debug(String.format((String)"Size: 0x%04x", (Object[])arrobject));
        }
        short s = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{s};
            loggerInterface.debug(String.format((String)"File name length: 0x%04x", (Object[])arrobject));
        }
        short s2 = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{s2};
            loggerInterface.debug(String.format((String)"Extra length: 0x%04x", (Object[])arrobject));
        }
        short s3 = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{s3};
            loggerInterface.debug(String.format((String)"File comment length: 0x%04x", (Object[])arrobject));
        }
        this.diskNumberStart = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.diskNumberStart};
            loggerInterface.debug(String.format((String)"Disk number start: 0x%04x", (Object[])arrobject));
        }
        this.internalAttributes = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.internalAttributes};
            loggerInterface.debug(String.format((String)"Internal attributes: 0x%04x", (Object[])arrobject));
        }
        this.externalAttributes = zipInput.readInt();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.externalAttributes};
            loggerInterface.debug(String.format((String)"External attributes: 0x%08x", (Object[])arrobject));
        }
        this.localHeaderOffset = zipInput.readInt();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.localHeaderOffset};
            loggerInterface.debug(String.format((String)"Local header offset: 0x%08x", (Object[])arrobject));
        }
        this.filename = zipInput.readString(s);
        if (bl) {
            log.debug("Filename: " + this.filename);
        }
        this.extraData = zipInput.readBytes(s2);
        this.fileComment = zipInput.readString(s3);
        if (bl) {
            log.debug("File comment: " + this.fileComment);
        }
        this.generalPurposeBits = (short)(2048 & this.generalPurposeBits);
        if (this.size == 0) {
            this.compressedSize = 0;
            this.compression = 0;
            this.crc32 = 0;
        }
    }

    public static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZioEntry.class.getName());
        }
        return log;
    }

    public static ZioEntry read(ZipInput zipInput) throws IOException {
        if (zipInput.readInt() != 33639248) {
            zipInput.seek(zipInput.getFilePointer() - 4);
            return null;
        }
        ZioEntry zioEntry = new ZioEntry(zipInput);
        zioEntry.doRead(zipInput);
        return zioEntry;
    }

    public ZioEntry getClonedEntry(String string) {
        ZioEntry zioEntry;
        try {
            zioEntry = (ZioEntry)this.clone();
        }
        catch (CloneNotSupportedException var2_3) {
            throw new IllegalStateException("clone() failed!");
        }
        zioEntry.setName(string);
        return zioEntry;
    }

    public int getCompressedSize() {
        return this.compressedSize;
    }

    public short getCompression() {
        return this.compression;
    }

    public int getCrc32() {
        return this.crc32;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public byte[] getData() throws IOException {
        if (this.data != null) {
            return this.data;
        }
        byte[] arrby = new byte[this.size];
        InputStream inputStream = this.getInputStream();
        int n = 0;
        while (n != this.size) {
            int n2 = inputStream.read(arrby, n, this.size - n);
            if (n2 < 0) {
                Object[] arrobject = new Object[]{this.size, n};
                throw new IllegalStateException(String.format((String)"Read failed, expecting %d bytes, got %d instead", (Object[])arrobject));
            }
            n += n2;
        }
        return arrby;
    }

    public long getDataPosition() {
        return this.dataPosition;
    }

    public short getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public ZioEntryOutputStream getEntryOut() {
        return this.entryOut;
    }

    public int getExternalAttributes() {
        return this.externalAttributes;
    }

    public byte[] getExtraData() {
        return this.extraData;
    }

    public String getFileComment() {
        return this.fileComment;
    }

    public short getGeneralPurposeBits() {
        return this.generalPurposeBits;
    }

    public InputStream getInputStream() throws IOException {
        return this.getInputStream(null);
    }

    public InputStream getInputStream(OutputStream outputStream) throws IOException {
        if (this.entryOut != null) {
            this.entryOut.close();
            this.size = this.entryOut.getSize();
            this.data = ((ByteArrayOutputStream)this.entryOut.getWrappedStream()).toByteArray();
            this.compressedSize = this.data.length;
            this.crc32 = this.entryOut.getCRC();
            this.entryOut = null;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.data);
            if (this.compression == 0) {
                return byteArrayInputStream;
            }
            return new InflaterInputStream((InputStream)new SequenceInputStream((InputStream)byteArrayInputStream, (InputStream)new ByteArrayInputStream(new byte[1])), new Inflater(true));
        }
        ZioEntryInputStream zioEntryInputStream = new ZioEntryInputStream((ZioEntry)this);
        if (outputStream != null) {
            zioEntryInputStream.setMonitorStream(outputStream);
        }
        if (this.compression != 0) {
            zioEntryInputStream.setReturnDummyByte(true);
            return new InflaterInputStream((InputStream)zioEntryInputStream, new Inflater(true));
        }
        return zioEntryInputStream;
    }

    public short getInternalAttributes() {
        return this.internalAttributes;
    }

    public int getLocalHeaderOffset() {
        return this.localHeaderOffset;
    }

    public String getName() {
        return this.filename;
    }

    public OutputStream getOutputStream() {
        this.entryOut = new ZioEntryOutputStream(this.compression, (OutputStream)new ByteArrayOutputStream());
        return this.entryOut;
    }

    public int getSize() {
        return this.size;
    }

    public long getTime() {
        return new Date(80 + (127 & this.modificationDate >> 9), -1 + (15 & this.modificationDate >> 5), 31 & this.modificationDate, 31 & this.modificationTime >> 11, 63 & this.modificationTime >> 5, 62 & this.modificationTime << 1).getTime();
    }

    public short getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public short getVersionRequired() {
        return this.versionRequired;
    }

    public ZipInput getZipInput() {
        return this.zipInput;
    }

    public boolean isDirectory() {
        return this.filename.endsWith("/");
    }

    public void readLocalHeader() throws IOException {
        ZipInput zipInput = this.zipInput;
        boolean bl = ZioEntry.getLogger().isDebugEnabled();
        zipInput.seek(this.localHeaderOffset);
        if (bl) {
            LoggerInterface loggerInterface = ZioEntry.getLogger();
            Object[] arrobject = new Object[]{zipInput.getFilePointer()};
            loggerInterface.debug(String.format((String)"FILE POSITION: 0x%08x", (Object[])arrobject));
        }
        if (zipInput.readInt() != 67324752) {
            Object[] arrobject = new Object[]{zipInput.getFilePointer(), this.filename};
            throw new IllegalStateException(String.format((String)"Local header not found at pos=0x%08x, file=%s", (Object[])arrobject));
        }
        short s = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{s};
            loggerInterface.debug(String.format((String)"Version required: 0x%04x", (Object[])arrobject));
        }
        short s2 = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{s2};
            loggerInterface.debug(String.format((String)"General purpose bits: 0x%04x", (Object[])arrobject));
        }
        short s3 = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{s3};
            loggerInterface.debug(String.format((String)"Compression: 0x%04x", (Object[])arrobject));
        }
        short s4 = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{s4};
            loggerInterface.debug(String.format((String)"Modification time: 0x%04x", (Object[])arrobject));
        }
        short s5 = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{s5};
            loggerInterface.debug(String.format((String)"Modification date: 0x%04x", (Object[])arrobject));
        }
        int n = zipInput.readInt();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{n};
            loggerInterface.debug(String.format((String)"CRC-32: 0x%04x", (Object[])arrobject));
        }
        int n2 = zipInput.readInt();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{n2};
            loggerInterface.debug(String.format((String)"Compressed size: 0x%04x", (Object[])arrobject));
        }
        int n3 = zipInput.readInt();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{n3};
            loggerInterface.debug(String.format((String)"Size: 0x%04x", (Object[])arrobject));
        }
        short s6 = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{s6};
            loggerInterface.debug(String.format((String)"File name length: 0x%04x", (Object[])arrobject));
        }
        short s7 = zipInput.readShort();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{s7};
            loggerInterface.debug(String.format((String)"Extra length: 0x%04x", (Object[])arrobject));
        }
        String string = zipInput.readString(s6);
        if (bl) {
            log.debug("Filename: " + string);
        }
        zipInput.readBytes(s7);
        this.dataPosition = zipInput.getFilePointer();
        if (bl) {
            LoggerInterface loggerInterface = log;
            Object[] arrobject = new Object[]{this.dataPosition};
            loggerInterface.debug(String.format((String)"Data position: 0x%08x", (Object[])arrobject));
        }
    }

    public void setCompression(int n) {
        this.compression = (short)n;
    }

    public void setName(String string) {
        this.filename = string;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setTime(long l) {
        Date date = new Date(l);
        int n = 1900 + date.getYear();
        long l2 = n < 1980 ? 2162688 : (long)(n - 1980 << 25 | 1 + date.getMonth() << 21 | date.getDate() << 16 | date.getHours() << 11 | date.getMinutes() << 5 | date.getSeconds() >> 1);
        this.modificationDate = (short)(l2 >> 16);
        this.modificationTime = (short)(65535 & l2);
    }

    public void write(ZipOutput zipOutput) throws IOException {
        ZioEntry.getLogger().isDebugEnabled();
        zipOutput.writeInt(33639248);
        zipOutput.writeShort(this.versionMadeBy);
        zipOutput.writeShort(this.versionRequired);
        zipOutput.writeShort(this.generalPurposeBits);
        zipOutput.writeShort(this.compression);
        zipOutput.writeShort(this.modificationTime);
        zipOutput.writeShort(this.modificationDate);
        zipOutput.writeInt(this.crc32);
        zipOutput.writeInt(this.compressedSize);
        zipOutput.writeInt(this.size);
        zipOutput.writeShort((short)this.filename.length());
        zipOutput.writeShort((short)(this.extraData.length + this.numAlignBytes));
        zipOutput.writeShort((short)this.fileComment.length());
        zipOutput.writeShort(this.diskNumberStart);
        zipOutput.writeShort(this.internalAttributes);
        zipOutput.writeInt(this.externalAttributes);
        zipOutput.writeInt(this.localHeaderOffset);
        zipOutput.writeString(this.filename);
        zipOutput.writeBytes(this.extraData);
        if (this.numAlignBytes > 0) {
            zipOutput.writeBytes(alignBytes, 0, this.numAlignBytes);
        }
        zipOutput.writeString(this.fileComment);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void writeLocalEntry(ZipOutput zipOutput) throws IOException {
        short s;
        if (this.data == null && this.dataPosition < 0 && this.zipInput != null) {
            this.readLocalHeader();
        }
        this.localHeaderOffset = zipOutput.getFilePointer();
        boolean bl = ZioEntry.getLogger().isDebugEnabled();
        if (bl) {
            LoggerInterface loggerInterface = ZioEntry.getLogger();
            Object[] arrobject = new Object[]{this.localHeaderOffset, this.filename};
            loggerInterface.debug(String.format((String)"Writing local header at 0x%08x - %s", (Object[])arrobject));
        }
        if (this.entryOut != null) {
            this.entryOut.close();
            this.size = this.entryOut.getSize();
            this.data = ((ByteArrayOutputStream)this.entryOut.getWrappedStream()).toByteArray();
            this.compressedSize = this.data.length;
            this.crc32 = this.entryOut.getCRC();
        }
        zipOutput.writeInt(67324752);
        zipOutput.writeShort(this.versionRequired);
        zipOutput.writeShort(this.generalPurposeBits);
        zipOutput.writeShort(this.compression);
        zipOutput.writeShort(this.modificationTime);
        zipOutput.writeShort(this.modificationDate);
        zipOutput.writeInt(this.crc32);
        zipOutput.writeInt(this.compressedSize);
        zipOutput.writeInt(this.size);
        zipOutput.writeShort((short)this.filename.length());
        this.numAlignBytes = 0;
        if (this.compression == 0 && (s = (short)((long)(2 + zipOutput.getFilePointer() + this.filename.length() + this.extraData.length) % 4)) > 0) {
            this.numAlignBytes = (short)(4 - s);
        }
        zipOutput.writeShort((short)(this.extraData.length + this.numAlignBytes));
        zipOutput.writeString(this.filename);
        zipOutput.writeBytes(this.extraData);
        if (this.numAlignBytes > 0) {
            zipOutput.writeBytes(alignBytes, 0, this.numAlignBytes);
        }
        if (bl) {
            LoggerInterface loggerInterface = ZioEntry.getLogger();
            Object[] arrobject = new Object[]{zipOutput.getFilePointer()};
            loggerInterface.debug(String.format((String)"Data position 0x%08x", (Object[])arrobject));
        }
        if (this.data != null) {
            zipOutput.writeBytes(this.data);
            if (bl) {
                LoggerInterface loggerInterface = ZioEntry.getLogger();
                Object[] arrobject = new Object[]{this.data.length};
                loggerInterface.debug(String.format((String)"Wrote %d bytes", (Object[])arrobject));
            }
            return;
        }
        if (bl) {
            LoggerInterface loggerInterface = ZioEntry.getLogger();
            Object[] arrobject = new Object[]{this.dataPosition};
            loggerInterface.debug(String.format((String)"Seeking to position 0x%08x", (Object[])arrobject));
        }
        this.zipInput.seek(this.dataPosition);
        int n = Math.min((int)this.compressedSize, (int)8096);
        byte[] arrby = new byte[n];
        long l = 0;
        while (l != (long)this.compressedSize) {
            int n2 = this.zipInput.in.read(arrby, 0, (int)Math.min((long)((long)this.compressedSize - l), (long)n));
            if (n2 <= 0) {
                Object[] arrobject = new Object[]{this.filename, (long)this.compressedSize - l};
                throw new IllegalStateException(String.format((String)"EOF reached while copying %s with %d bytes left to go", (Object[])arrobject));
            }
            zipOutput.writeBytes(arrby, 0, n2);
            if (bl) {
                LoggerInterface loggerInterface = ZioEntry.getLogger();
                Object[] arrobject = new Object[]{n2};
                loggerInterface.debug(String.format((String)"Wrote %d bytes", (Object[])arrobject));
            }
            l += (long)n2;
        }
    }
}

