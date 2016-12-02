/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.FileOutputStream
 *  java.lang.Object
 */
package net.lingala.zip4j.model;

import java.io.FileOutputStream;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.unzip.UnzipEngine;

public class UnzipEngineParameters {
    private FileHeader fileHeader;
    private IDecrypter iDecryptor;
    private LocalFileHeader localFileHeader;
    private FileOutputStream outputStream;
    private UnzipEngine unzipEngine;
    private ZipModel zipModel;

    public FileHeader getFileHeader() {
        return this.fileHeader;
    }

    public IDecrypter getIDecryptor() {
        return this.iDecryptor;
    }

    public LocalFileHeader getLocalFileHeader() {
        return this.localFileHeader;
    }

    public FileOutputStream getOutputStream() {
        return this.outputStream;
    }

    public UnzipEngine getUnzipEngine() {
        return this.unzipEngine;
    }

    public ZipModel getZipModel() {
        return this.zipModel;
    }

    public void setFileHeader(FileHeader fileHeader) {
        this.fileHeader = fileHeader;
    }

    public void setIDecryptor(IDecrypter iDecrypter) {
        this.iDecryptor = iDecrypter;
    }

    public void setLocalFileHeader(LocalFileHeader localFileHeader) {
        this.localFileHeader = localFileHeader;
    }

    public void setOutputStream(FileOutputStream fileOutputStream) {
        this.outputStream = fileOutputStream;
    }

    public void setUnzipEngine(UnzipEngine unzipEngine) {
        this.unzipEngine = unzipEngine;
    }

    public void setZipModel(ZipModel zipModel) {
        this.zipModel = zipModel;
    }
}

