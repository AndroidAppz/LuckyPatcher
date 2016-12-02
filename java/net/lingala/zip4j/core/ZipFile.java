/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.RandomAccessFile
 *  java.io.UnsupportedEncodingException
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 */
package net.lingala.zip4j.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.lingala.zip4j.core.HeaderReader;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.unzip.Unzip;
import net.lingala.zip4j.util.ArchiveMaintainer;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;
import net.lingala.zip4j.zip.ZipEngine;

public class ZipFile {
    private String file;
    private String fileNameCharset;
    private boolean isEncrypted;
    private int mode;
    private ProgressMonitor progressMonitor;
    private boolean runInThread;
    private ZipModel zipModel;

    public ZipFile(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("Input zip file parameter is not null", 1);
        }
        this.file = file.getPath();
        this.mode = 2;
        this.progressMonitor = new ProgressMonitor();
        this.runInThread = false;
    }

    public ZipFile(String string) throws ZipException {
        super(new File(string));
    }

    private void addFolder(File file, ZipParameters zipParameters, boolean bl) throws ZipException {
        super.checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("internal error: zip model is null");
        }
        if (bl && this.zipModel.isSplitArchive()) {
            throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
        new ZipEngine(this.zipModel).addFolderToZip(file, zipParameters, this.progressMonitor, this.runInThread);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void checkZipModel() throws ZipException {
        if (this.zipModel != null) return;
        if (Zip4jUtil.checkFileExists(this.file)) {
            this.readZipInfo();
            return;
        }
        this.createNewZipModel();
    }

    private void createNewZipModel() {
        this.zipModel = new ZipModel();
        this.zipModel.setZipFile(this.file);
        this.zipModel.setFileNameCharset(this.fileNameCharset);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void readZipInfo() throws ZipException {
        if (!Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file does not exist");
        }
        if (!Zip4jUtil.checkFileReadAccess(this.file)) {
            throw new ZipException("no read access for the input zip file");
        }
        if (this.mode != 2) {
            throw new ZipException("Invalid mode");
        }
        var1_1 = null;
        var2_2 = new RandomAccessFile(new File(this.file), "r");
        if (this.zipModel == null) {
            this.zipModel = new HeaderReader(var2_2).readAllHeaders(this.fileNameCharset);
            if (this.zipModel != null) {
                this.zipModel.setZipFile(this.file);
            }
        }
        if (var2_2 == null) return;
        try {
            var2_2.close();
            return;
        }
        catch (IOException var6_9) {
            return;
        }
        catch (FileNotFoundException var3_3) {}
        ** GOTO lbl-1000
        catch (Throwable var4_8) {
            var1_1 = var2_2;
            ** GOTO lbl-1000
        }
        catch (FileNotFoundException var3_5) {
            var1_1 = var2_2;
        }
lbl-1000: // 2 sources:
        {
            try {
                throw new ZipException((Throwable)var3_4);
            }
            catch (Throwable var4_6) lbl-1000: // 2 sources:
            {
                if (var1_1 == null) throw var4_7;
                try {
                    var1_1.close();
                }
                catch (IOException var5_10) {
                    throw var4_7;
                }
                throw var4_7;
            }
        }
    }

    public void addFile(File file, ZipParameters zipParameters) throws ZipException {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)file);
        this.addFiles(arrayList, zipParameters);
    }

    public void addFiles(ArrayList arrayList, ZipParameters zipParameters) throws ZipException {
        super.checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("internal error: zip model is null");
        }
        if (arrayList == null) {
            throw new ZipException("input file ArrayList is null, cannot add files");
        }
        if (!Zip4jUtil.checkArrayListTypes(arrayList, 1)) {
            throw new ZipException("One or more elements in the input ArrayList is not of type File");
        }
        if (zipParameters == null) {
            throw new ZipException("input parameters are null, cannot add files to zip");
        }
        if (this.progressMonitor.getState() == 1) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        if (Zip4jUtil.checkFileExists(this.file) && this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new ZipEngine(this.zipModel).addFiles(arrayList, zipParameters, this.progressMonitor, this.runInThread);
    }

    public void addFolder(File file, ZipParameters zipParameters) throws ZipException {
        if (file == null) {
            throw new ZipException("input path is null, cannot add folder to zip file");
        }
        if (zipParameters == null) {
            throw new ZipException("input parameters are null, cannot add folder to zip file");
        }
        super.addFolder(file, zipParameters, true);
    }

    public void addFolder(String string, ZipParameters zipParameters) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("input path is null or empty, cannot add folder to zip file");
        }
        this.addFolder(new File(string), zipParameters);
    }

    public void addStream(InputStream inputStream, ZipParameters zipParameters) throws ZipException {
        if (inputStream == null) {
            throw new ZipException("inputstream is null, cannot add file to zip");
        }
        if (zipParameters == null) {
            throw new ZipException("zip parameters are null");
        }
        this.setRunInThread(false);
        super.checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("internal error: zip model is null");
        }
        if (Zip4jUtil.checkFileExists(this.file) && this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new ZipEngine(this.zipModel).addStreamToZip(inputStream, zipParameters);
    }

    public void createZipFile(File file, ZipParameters zipParameters) throws ZipException {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)file);
        this.createZipFile(arrayList, zipParameters, false, -1);
    }

    public void createZipFile(File file, ZipParameters zipParameters, boolean bl, long l) throws ZipException {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)file);
        this.createZipFile(arrayList, zipParameters, bl, l);
    }

    public void createZipFile(ArrayList arrayList, ZipParameters zipParameters) throws ZipException {
        this.createZipFile(arrayList, zipParameters, false, -1);
    }

    public void createZipFile(ArrayList arrayList, ZipParameters zipParameters, boolean bl, long l) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(this.file)) {
            throw new ZipException("zip file path is empty");
        }
        if (Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file: " + this.file + " already exists. To add files to existing zip file use addFile method");
        }
        if (arrayList == null) {
            throw new ZipException("input file ArrayList is null, cannot create zip file");
        }
        if (!Zip4jUtil.checkArrayListTypes(arrayList, 1)) {
            throw new ZipException("One or more elements in the input ArrayList is not of type File");
        }
        super.createNewZipModel();
        this.zipModel.setSplitArchive(bl);
        this.zipModel.setSplitLength(l);
        this.addFiles(arrayList, zipParameters);
    }

    public void createZipFileFromFolder(File file, ZipParameters zipParameters, boolean bl, long l) throws ZipException {
        if (file == null) {
            throw new ZipException("folderToAdd is null, cannot create zip file from folder");
        }
        if (zipParameters == null) {
            throw new ZipException("input parameters are null, cannot create zip file from folder");
        }
        if (Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file: " + this.file + " already exists. To add files to existing zip file use addFolder method");
        }
        super.createNewZipModel();
        this.zipModel.setSplitArchive(bl);
        if (bl) {
            this.zipModel.setSplitLength(l);
        }
        super.addFolder(file, zipParameters, false);
    }

    public void createZipFileFromFolder(String string, ZipParameters zipParameters, boolean bl, long l) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("folderToAdd is empty or null, cannot create Zip File from folder");
        }
        this.createZipFileFromFolder(new File(string), zipParameters, bl, l);
    }

    public void extractAll(String string) throws ZipException {
        this.extractAll(string, null);
    }

    public void extractAll(String string, UnzipParameters unzipParameters) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("output path is null or invalid");
        }
        if (!Zip4jUtil.checkOutputFolder(string)) {
            throw new ZipException("invalid output path");
        }
        if (this.zipModel == null) {
            super.readZipInfo();
        }
        if (this.zipModel == null) {
            throw new ZipException("Internal error occurred when extracting zip file");
        }
        if (this.progressMonitor.getState() == 1) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        new Unzip(this.zipModel).extractAll(unzipParameters, string, this.progressMonitor, this.runInThread);
    }

    public void extractFile(String string, String string2) throws ZipException {
        this.extractFile(string, string2, null);
    }

    public void extractFile(String string, String string2, UnzipParameters unzipParameters) throws ZipException {
        this.extractFile(string, string2, unzipParameters, null);
    }

    public void extractFile(String string, String string2, UnzipParameters unzipParameters, String string3) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("file to extract is null or empty, cannot extract file");
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string2)) {
            throw new ZipException("destination string path is empty or null, cannot extract file");
        }
        super.readZipInfo();
        FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, string);
        if (fileHeader == null) {
            throw new ZipException("file header not found for given file name, cannot extract file");
        }
        if (this.progressMonitor.getState() == 1) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        fileHeader.extractFile(this.zipModel, string2, unzipParameters, string3, this.progressMonitor, this.runInThread);
    }

    public void extractFile(FileHeader fileHeader, String string) throws ZipException {
        this.extractFile(fileHeader, string, null);
    }

    public void extractFile(FileHeader fileHeader, String string, UnzipParameters unzipParameters) throws ZipException {
        this.extractFile(fileHeader, string, unzipParameters, null);
    }

    public void extractFile(FileHeader fileHeader, String string, UnzipParameters unzipParameters, String string2) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("input file header is null, cannot extract file");
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("destination path is empty or null, cannot extract file");
        }
        super.readZipInfo();
        if (this.progressMonitor.getState() == 1) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        fileHeader.extractFile(this.zipModel, string, unzipParameters, string2, this.progressMonitor, this.runInThread);
    }

    public String getComment() throws ZipException {
        return this.getComment(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String getComment(String string) throws ZipException {
        if (string == null) {
            string = Zip4jUtil.isSupportedCharset("windows-1254") ? "windows-1254" : InternalZipConstants.CHARSET_DEFAULT;
        }
        if (!Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file does not exist, cannot read comment");
        }
        super.checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("zip model is null, cannot read comment");
        }
        if (this.zipModel.getEndCentralDirRecord() == null) {
            throw new ZipException("end of central directory record is null, cannot read comment");
        }
        if (this.zipModel.getEndCentralDirRecord().getCommentBytes() == null) return null;
        if (this.zipModel.getEndCentralDirRecord().getCommentBytes().length <= 0) {
            return null;
        }
        try {
            return new String(this.zipModel.getEndCentralDirRecord().getCommentBytes(), string);
        }
        catch (UnsupportedEncodingException var3_3) {
            throw new ZipException((Throwable)var3_3);
        }
    }

    public File getFile() {
        return new File(this.file);
    }

    public FileHeader getFileHeader(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("input file name is emtpy or null, cannot get FileHeader");
        }
        super.readZipInfo();
        if (this.zipModel == null || this.zipModel.getCentralDirectory() == null) {
            return null;
        }
        return Zip4jUtil.getFileHeader(this.zipModel, string);
    }

    public List getFileHeaders() throws ZipException {
        this.readZipInfo();
        if (this.zipModel == null || this.zipModel.getCentralDirectory() == null) {
            return null;
        }
        return this.zipModel.getCentralDirectory().getFileHeaders();
    }

    public ZipInputStream getInputStream(FileHeader fileHeader) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("FileHeader is null, cannot get InputStream");
        }
        super.checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("zip model is null, cannot get inputstream");
        }
        return new Unzip(this.zipModel).getInputStream(fileHeader);
    }

    public ProgressMonitor getProgressMonitor() {
        return this.progressMonitor;
    }

    public ArrayList getSplitZipFiles() throws ZipException {
        this.checkZipModel();
        return Zip4jUtil.getSplitZipFiles(this.zipModel);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isEncrypted() throws ZipException {
        if (this.zipModel == null) {
            this.readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("invalid zip file");
        }
        ArrayList arrayList = this.zipModel.getCentralDirectory().getFileHeaders();
        int n = 0;
        while (n < arrayList.size()) {
            FileHeader fileHeader = (FileHeader)arrayList.get(n);
            if (fileHeader != null && fileHeader.isEncrypted()) {
                this.isEncrypted = true;
                return this.isEncrypted;
            }
            ++n;
        }
        return this.isEncrypted;
    }

    public boolean isRunInThread() {
        return this.runInThread;
    }

    public boolean isSplitArchive() throws ZipException {
        if (this.zipModel == null) {
            this.readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        return this.zipModel.isSplitArchive();
    }

    public boolean isValidZipFile() {
        try {
            this.readZipInfo();
            return true;
        }
        catch (Exception var1_1) {
            return false;
        }
    }

    public void mergeSplitFiles(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("outputZipFile is null, cannot merge split files");
        }
        if (file.exists()) {
            throw new ZipException("output Zip File already exists");
        }
        super.checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("zip model is null, corrupt zip file?");
        }
        ArchiveMaintainer archiveMaintainer = new ArchiveMaintainer();
        archiveMaintainer.initProgressMonitorForMergeOp(this.zipModel, this.progressMonitor);
        archiveMaintainer.mergeSplitZipFiles(this.zipModel, file, this.progressMonitor, this.runInThread);
    }

    public void removeFile(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("file name is empty or null, cannot remove file");
        }
        if (this.zipModel == null && Zip4jUtil.checkFileExists(this.file)) {
            super.readZipInfo();
        }
        if (this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
        FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, string);
        if (fileHeader == null) {
            throw new ZipException("could not find file header for file: " + string);
        }
        this.removeFile(fileHeader);
    }

    public void removeFile(FileHeader fileHeader) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("file header is null, cannot remove file");
        }
        if (this.zipModel == null && Zip4jUtil.checkFileExists(this.file)) {
            super.readZipInfo();
        }
        if (this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
        ArchiveMaintainer archiveMaintainer = new ArchiveMaintainer();
        archiveMaintainer.initProgressMonitorForRemoveOp(this.zipModel, fileHeader, this.progressMonitor);
        archiveMaintainer.removeZipFile(this.zipModel, fileHeader, this.progressMonitor, this.runInThread);
    }

    public void setComment(String string) throws ZipException {
        if (string == null) {
            throw new ZipException("input comment is null, cannot update zip file");
        }
        if (!Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file does not exist, cannot set comment for zip file");
        }
        super.readZipInfo();
        if (this.zipModel == null) {
            throw new ZipException("zipModel is null, cannot update zip file");
        }
        if (this.zipModel.getEndCentralDirRecord() == null) {
            throw new ZipException("end of central directory is null, cannot set comment");
        }
        new ArchiveMaintainer().setComment(this.zipModel, string);
    }

    public void setFileNameCharset(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("null or empty charset name");
        }
        if (!Zip4jUtil.isSupportedCharset(string)) {
            throw new ZipException("unsupported charset: " + string);
        }
        this.fileNameCharset = string;
    }

    public void setPassword(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new NullPointerException();
        }
        this.setPassword(string.toCharArray());
    }

    public void setPassword(char[] arrc) throws ZipException {
        if (this.zipModel == null) {
            super.readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("invalid zip file");
        }
        for (int i = 0; i < this.zipModel.getCentralDirectory().getFileHeaders().size(); ++i) {
            if (this.zipModel.getCentralDirectory().getFileHeaders().get(i) == null || !((FileHeader)this.zipModel.getCentralDirectory().getFileHeaders().get(i)).isEncrypted()) continue;
            ((FileHeader)this.zipModel.getCentralDirectory().getFileHeaders().get(i)).setPassword(arrc);
        }
    }

    public void setRunInThread(boolean bl) {
        this.runInThread = bl;
    }
}

