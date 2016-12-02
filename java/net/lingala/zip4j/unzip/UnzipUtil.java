/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package net.lingala.zip4j.unzip;

import java.io.File;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.util.Zip4jUtil;

public class UnzipUtil {
    public static void applyFileAttributes(FileHeader fileHeader, File file) throws ZipException {
        UnzipUtil.applyFileAttributes(fileHeader, file, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void applyFileAttributes(FileHeader fileHeader, File file, UnzipParameters unzipParameters) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("cannot set file properties: file header is null");
        }
        if (file == null) {
            throw new ZipException("cannot set file properties: output file is null");
        }
        if (!Zip4jUtil.checkFileExists(file)) {
            throw new ZipException("cannot set file properties: file doesnot exist");
        }
        if (unzipParameters == null || !unzipParameters.isIgnoreDateTimeAttributes()) {
            UnzipUtil.setFileLastModifiedTime(fileHeader, file);
        }
        if (unzipParameters == null) {
            UnzipUtil.setFileAttributes(fileHeader, file, true, true, true, true);
            return;
        }
        if (unzipParameters.isIgnoreAllFileAttributes()) {
            UnzipUtil.setFileAttributes(fileHeader, file, false, false, false, false);
            return;
        }
        boolean bl = !unzipParameters.isIgnoreReadOnlyFileAttribute();
        boolean bl2 = !unzipParameters.isIgnoreHiddenFileAttribute();
        boolean bl3 = !unzipParameters.isIgnoreArchiveFileAttribute();
        boolean bl4 = !unzipParameters.isIgnoreSystemFileAttribute();
        UnzipUtil.setFileAttributes(fileHeader, file, bl, bl2, bl3, bl4);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void setFileAttributes(FileHeader fileHeader, File file, boolean bl, boolean bl2, boolean bl3, boolean bl4) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("invalid file header. cannot set file attributes");
        }
        byte[] arrby = fileHeader.getExternalFileAttr();
        if (arrby == null) {
            return;
        }
        switch (arrby[0]) {
            default: {
                return;
            }
            case 1: {
                if (!bl) return;
                Zip4jUtil.setFileReadOnly(file);
                return;
            }
            case 2: 
            case 18: {
                if (!bl2) return;
                Zip4jUtil.setFileHidden(file);
                return;
            }
            case 32: 
            case 48: {
                if (!bl3) return;
                Zip4jUtil.setFileArchive(file);
                return;
            }
            case 3: {
                if (bl) {
                    Zip4jUtil.setFileReadOnly(file);
                }
                if (!bl2) return;
                Zip4jUtil.setFileHidden(file);
                return;
            }
            case 33: {
                if (bl3) {
                    Zip4jUtil.setFileArchive(file);
                }
                if (!bl) return;
                Zip4jUtil.setFileReadOnly(file);
                return;
            }
            case 34: 
            case 50: {
                if (bl3) {
                    Zip4jUtil.setFileArchive(file);
                }
                if (!bl2) return;
                Zip4jUtil.setFileHidden(file);
                return;
            }
            case 35: {
                if (bl3) {
                    Zip4jUtil.setFileArchive(file);
                }
                if (bl) {
                    Zip4jUtil.setFileReadOnly(file);
                }
                if (!bl2) return;
                Zip4jUtil.setFileHidden(file);
                return;
            }
            case 38: 
        }
        if (bl) {
            Zip4jUtil.setFileReadOnly(file);
        }
        if (bl2) {
            Zip4jUtil.setFileHidden(file);
        }
        if (!bl4) return;
        Zip4jUtil.setFileSystemMode(file);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void setFileLastModifiedTime(FileHeader fileHeader, File file) throws ZipException {
        if (fileHeader.getLastModFileTime() <= 0 || !file.exists()) {
            return;
        }
        file.setLastModified(Zip4jUtil.dosToJavaTme(fileHeader.getLastModFileTime()));
    }
}

