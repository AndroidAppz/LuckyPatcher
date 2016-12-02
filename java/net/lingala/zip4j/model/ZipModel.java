/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package net.lingala.zip4j.model;

import java.util.List;
import net.lingala.zip4j.model.ArchiveExtraDataRecord;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.Zip64EndCentralDirLocator;
import net.lingala.zip4j.model.Zip64EndCentralDirRecord;

public class ZipModel
implements Cloneable {
    private ArchiveExtraDataRecord archiveExtraDataRecord;
    private CentralDirectory centralDirectory;
    private List dataDescriptorList;
    private long end;
    private EndCentralDirRecord endCentralDirRecord;
    private String fileNameCharset;
    private boolean isNestedZipFile;
    private boolean isZip64Format;
    private List localFileHeaderList;
    private boolean splitArchive;
    private long splitLength = -1;
    private long start;
    private Zip64EndCentralDirLocator zip64EndCentralDirLocator;
    private Zip64EndCentralDirRecord zip64EndCentralDirRecord;
    private String zipFile;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public ArchiveExtraDataRecord getArchiveExtraDataRecord() {
        return this.archiveExtraDataRecord;
    }

    public CentralDirectory getCentralDirectory() {
        return this.centralDirectory;
    }

    public List getDataDescriptorList() {
        return this.dataDescriptorList;
    }

    public long getEnd() {
        return this.end;
    }

    public EndCentralDirRecord getEndCentralDirRecord() {
        return this.endCentralDirRecord;
    }

    public String getFileNameCharset() {
        return this.fileNameCharset;
    }

    public List getLocalFileHeaderList() {
        return this.localFileHeaderList;
    }

    public long getSplitLength() {
        return this.splitLength;
    }

    public long getStart() {
        return this.start;
    }

    public Zip64EndCentralDirLocator getZip64EndCentralDirLocator() {
        return this.zip64EndCentralDirLocator;
    }

    public Zip64EndCentralDirRecord getZip64EndCentralDirRecord() {
        return this.zip64EndCentralDirRecord;
    }

    public String getZipFile() {
        return this.zipFile;
    }

    public boolean isNestedZipFile() {
        return this.isNestedZipFile;
    }

    public boolean isSplitArchive() {
        return this.splitArchive;
    }

    public boolean isZip64Format() {
        return this.isZip64Format;
    }

    public void setArchiveExtraDataRecord(ArchiveExtraDataRecord archiveExtraDataRecord) {
        this.archiveExtraDataRecord = archiveExtraDataRecord;
    }

    public void setCentralDirectory(CentralDirectory centralDirectory) {
        this.centralDirectory = centralDirectory;
    }

    public void setDataDescriptorList(List list) {
        this.dataDescriptorList = list;
    }

    public void setEnd(long l) {
        this.end = l;
    }

    public void setEndCentralDirRecord(EndCentralDirRecord endCentralDirRecord) {
        this.endCentralDirRecord = endCentralDirRecord;
    }

    public void setFileNameCharset(String string) {
        this.fileNameCharset = string;
    }

    public void setLocalFileHeaderList(List list) {
        this.localFileHeaderList = list;
    }

    public void setNestedZipFile(boolean bl) {
        this.isNestedZipFile = bl;
    }

    public void setSplitArchive(boolean bl) {
        this.splitArchive = bl;
    }

    public void setSplitLength(long l) {
        this.splitLength = l;
    }

    public void setStart(long l) {
        this.start = l;
    }

    public void setZip64EndCentralDirLocator(Zip64EndCentralDirLocator zip64EndCentralDirLocator) {
        this.zip64EndCentralDirLocator = zip64EndCentralDirLocator;
    }

    public void setZip64EndCentralDirRecord(Zip64EndCentralDirRecord zip64EndCentralDirRecord) {
        this.zip64EndCentralDirRecord = zip64EndCentralDirRecord;
    }

    public void setZip64Format(boolean bl) {
        this.isZip64Format = bl;
    }

    public void setZipFile(String string) {
        this.zipFile = string;
    }
}

