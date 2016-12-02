/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.TimeZone
 */
package net.lingala.zip4j.model;

import java.util.TimeZone;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

public class ZipParameters
implements Cloneable {
    private int aesKeyStrength = -1;
    private int compressionLevel;
    private int compressionMethod = 8;
    private String defaultFolderPath;
    private boolean encryptFiles = false;
    private int encryptionMethod = -1;
    private String fileNameInZip;
    private boolean includeRootFolder = true;
    private boolean isSourceExternalStream;
    private char[] password;
    private boolean readHiddenFiles = true;
    private String rootFolderInZip;
    private int sourceFileCRC;
    private TimeZone timeZone = TimeZone.getDefault();

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getAesKeyStrength() {
        return this.aesKeyStrength;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public int getCompressionMethod() {
        return this.compressionMethod;
    }

    public String getDefaultFolderPath() {
        return this.defaultFolderPath;
    }

    public int getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public String getFileNameInZip() {
        return this.fileNameInZip;
    }

    public char[] getPassword() {
        return this.password;
    }

    public String getRootFolderInZip() {
        return this.rootFolderInZip;
    }

    public int getSourceFileCRC() {
        return this.sourceFileCRC;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public boolean isEncryptFiles() {
        return this.encryptFiles;
    }

    public boolean isIncludeRootFolder() {
        return this.includeRootFolder;
    }

    public boolean isReadHiddenFiles() {
        return this.readHiddenFiles;
    }

    public boolean isSourceExternalStream() {
        return this.isSourceExternalStream;
    }

    public void setAesKeyStrength(int n) {
        this.aesKeyStrength = n;
    }

    public void setCompressionLevel(int n) {
        this.compressionLevel = n;
    }

    public void setCompressionMethod(int n) {
        this.compressionMethod = n;
    }

    public void setDefaultFolderPath(String string) {
        this.defaultFolderPath = string;
    }

    public void setEncryptFiles(boolean bl) {
        this.encryptFiles = bl;
    }

    public void setEncryptionMethod(int n) {
        this.encryptionMethod = n;
    }

    public void setFileNameInZip(String string) {
        this.fileNameInZip = string;
    }

    public void setIncludeRootFolder(boolean bl) {
        this.includeRootFolder = bl;
    }

    public void setPassword(String string) {
        if (string == null) {
            return;
        }
        this.setPassword(string.toCharArray());
    }

    public void setPassword(char[] arrc) {
        this.password = arrc;
    }

    public void setReadHiddenFiles(boolean bl) {
        this.readHiddenFiles = bl;
    }

    public void setRootFolderInZip(String string) {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            if (!string.endsWith("\\") && !string.endsWith("/")) {
                string = string + InternalZipConstants.FILE_SEPARATOR;
            }
            string = string.replaceAll("\\\\", "/");
        }
        this.rootFolderInZip = string;
    }

    public void setSourceExternalStream(boolean bl) {
        this.isSourceExternalStream = bl;
    }

    public void setSourceFileCRC(int n) {
        this.sourceFileCRC = n;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}

