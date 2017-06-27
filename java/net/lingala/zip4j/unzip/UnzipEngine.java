package net.lingala.zip4j.unzip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.CRC32;
import net.lingala.zip4j.core.HeaderReader;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.crypto.StandardDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.InflaterInputStream;
import net.lingala.zip4j.io.PartInputStream;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZ;
import pxb.android.axml.ValueWrapper;
import pxb.android.axmlLP.AxmlVisitor;

public class UnzipEngine {
    private CRC32 crc;
    private int currSplitFileCounter = 0;
    private IDecrypter decrypter;
    private FileHeader fileHeader;
    private LocalFileHeader localFileHeader;
    private ZipModel zipModel;

    public UnzipEngine(ZipModel zipModel, FileHeader fileHeader) throws ZipException {
        if (zipModel == null || fileHeader == null) {
            throw new ZipException("Invalid parameters passed to StoreUnzip. One or more of the parameters were null");
        }
        this.zipModel = zipModel;
        this.fileHeader = fileHeader;
        this.crc = new CRC32();
    }

    public void unzipFile(ProgressMonitor progressMonitor, String outPath, String newFileName, UnzipParameters unzipParameters) throws ZipException {
        if (this.zipModel == null || this.fileHeader == null || !Zip4jUtil.isStringNotNullAndNotEmpty(outPath)) {
            throw new ZipException("Invalid parameters passed during unzipping file. One or more of the parameters were null");
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            byte[] buff = new byte[LZMA2Options.DICT_SIZE_MIN];
            is = getInputStream();
            os = getOutputStream(outPath, newFileName);
            do {
                int readLength = is.read(buff);
                if (readLength == -1) {
                    closeStreams(is, os);
                    UnzipUtil.applyFileAttributes(this.fileHeader, new File(getOutputFileNameWithPath(outPath, newFileName)), unzipParameters);
                    closeStreams(is, os);
                    return;
                }
                os.write(buff, 0, readLength);
                progressMonitor.updateWorkCompleted((long) readLength);
            } while (!progressMonitor.isCancelAllTasks());
            progressMonitor.setResult(3);
            progressMonitor.setState(0);
            closeStreams(is, os);
        } catch (Throwable e) {
            throw new ZipException(e);
        } catch (Throwable e2) {
            throw new ZipException(e2);
        } catch (Throwable th) {
            closeStreams(is, os);
        }
    }

    public ZipInputStream getInputStream() throws ZipException {
        if (this.fileHeader == null) {
            throw new ZipException("file header is null, cannot get inputstream");
        }
        RandomAccessFile raf = null;
        try {
            raf = createFileHandler(InternalZipConstants.READ_MODE);
            String errMsg = "local header and file header do not match";
            if (checkLocalHeader()) {
                init(raf);
                long comprSize = this.localFileHeader.getCompressedSize();
                long offsetStartOfData = this.localFileHeader.getOffsetStartOfData();
                if (this.localFileHeader.isEncrypted()) {
                    if (this.localFileHeader.getEncryptionMethod() == 99) {
                        if (this.decrypter instanceof AESDecrypter) {
                            comprSize -= (long) ((((AESDecrypter) this.decrypter).getPasswordVerifierLength() + ((AESDecrypter) this.decrypter).getSaltLength()) + 10);
                            offsetStartOfData += (long) (((AESDecrypter) this.decrypter).getPasswordVerifierLength() + ((AESDecrypter) this.decrypter).getSaltLength());
                        } else {
                            throw new ZipException("invalid decryptor when trying to calculate compressed size for AES encrypted file: " + this.fileHeader.getFileName());
                        }
                    } else if (this.localFileHeader.getEncryptionMethod() == 0) {
                        comprSize -= 12;
                        offsetStartOfData += 12;
                    }
                }
                int compressionMethod = this.fileHeader.getCompressionMethod();
                if (this.fileHeader.getEncryptionMethod() == 99) {
                    if (this.fileHeader.getAesExtraDataRecord() != null) {
                        compressionMethod = this.fileHeader.getAesExtraDataRecord().getCompressionMethod();
                    } else {
                        throw new ZipException("AESExtraDataRecord does not exist for AES encrypted file: " + this.fileHeader.getFileName());
                    }
                }
                raf.seek(offsetStartOfData);
                switch (compressionMethod) {
                    case XZ.CHECK_NONE /*0*/:
                        return new ZipInputStream(new PartInputStream(raf, offsetStartOfData, comprSize, this));
                    case LZMA2Options.NICE_LEN_MIN /*8*/:
                        return new ZipInputStream(new InflaterInputStream(raf, offsetStartOfData, comprSize, this));
                    default:
                        throw new ZipException("compression type not supported");
                }
            }
            throw new ZipException(errMsg);
        } catch (ZipException e) {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e2) {
                }
            }
            throw e;
        } catch (Throwable e3) {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e4) {
                }
            }
            throw new ZipException(e3);
        }
    }

    private void init(RandomAccessFile raf) throws ZipException {
        if (this.localFileHeader == null) {
            throw new ZipException("local file header is null, cannot initialize input stream");
        }
        try {
            initDecrypter(raf);
        } catch (ZipException e) {
            throw e;
        } catch (Throwable e2) {
            throw new ZipException(e2);
        }
    }

    private void initDecrypter(RandomAccessFile raf) throws ZipException {
        if (this.localFileHeader == null) {
            throw new ZipException("local file header is null, cannot init decrypter");
        } else if (!this.localFileHeader.isEncrypted()) {
        } else {
            if (this.localFileHeader.getEncryptionMethod() == 0) {
                this.decrypter = new StandardDecrypter(this.fileHeader, getStandardDecrypterHeaderBytes(raf));
            } else if (this.localFileHeader.getEncryptionMethod() == 99) {
                this.decrypter = new AESDecrypter(this.localFileHeader, getAESSalt(raf), getAESPasswordVerifier(raf));
            } else {
                throw new ZipException("unsupported encryption method");
            }
        }
    }

    private byte[] getStandardDecrypterHeaderBytes(RandomAccessFile raf) throws ZipException {
        try {
            byte[] headerBytes = new byte[12];
            raf.seek(this.localFileHeader.getOffsetStartOfData());
            raf.read(headerBytes, 0, 12);
            return headerBytes;
        } catch (Throwable e) {
            throw new ZipException(e);
        } catch (Throwable e2) {
            throw new ZipException(e2);
        }
    }

    private byte[] getAESSalt(RandomAccessFile raf) throws ZipException {
        if (this.localFileHeader.getAesExtraDataRecord() == null) {
            return null;
        }
        try {
            byte[] saltBytes = new byte[calculateAESSaltLength(this.localFileHeader.getAesExtraDataRecord())];
            raf.seek(this.localFileHeader.getOffsetStartOfData());
            raf.read(saltBytes);
            return saltBytes;
        } catch (Throwable e) {
            throw new ZipException(e);
        }
    }

    private byte[] getAESPasswordVerifier(RandomAccessFile raf) throws ZipException {
        try {
            byte[] pvBytes = new byte[2];
            raf.read(pvBytes);
            return pvBytes;
        } catch (Throwable e) {
            throw new ZipException(e);
        }
    }

    private int calculateAESSaltLength(AESExtraDataRecord aesExtraDataRecord) throws ZipException {
        if (aesExtraDataRecord == null) {
            throw new ZipException("unable to determine salt length: AESExtraDataRecord is null");
        }
        switch (aesExtraDataRecord.getAesStrength()) {
            case AxmlVisitor.TYPE_REFERENCE /*1*/:
                return 8;
            case ValueWrapper.STYLE /*2*/:
                return 12;
            case AxmlVisitor.TYPE_STRING /*3*/:
                return 16;
            default:
                throw new ZipException("unable to determine salt length: invalid aes key strength");
        }
    }

    public void checkCRC() throws ZipException {
        if (this.fileHeader == null) {
            return;
        }
        if (this.fileHeader.getEncryptionMethod() == 99) {
            if (this.decrypter != null && (this.decrypter instanceof AESDecrypter)) {
                byte[] tmpMacBytes = ((AESDecrypter) this.decrypter).getCalculatedAuthenticationBytes();
                byte[] storedMac = ((AESDecrypter) this.decrypter).getStoredMac();
                byte[] calculatedMac = new byte[10];
                if (calculatedMac == null || storedMac == null) {
                    throw new ZipException("CRC (MAC) check failed for " + this.fileHeader.getFileName());
                }
                System.arraycopy(tmpMacBytes, 0, calculatedMac, 0, 10);
                if (!Arrays.equals(calculatedMac, storedMac)) {
                    throw new ZipException("invalid CRC (MAC) for file: " + this.fileHeader.getFileName());
                }
            }
        } else if ((this.crc.getValue() & InternalZipConstants.ZIP_64_LIMIT) != this.fileHeader.getCrc32()) {
            String errMsg = "invalid CRC for file: " + this.fileHeader.getFileName();
            if (this.localFileHeader.isEncrypted() && this.localFileHeader.getEncryptionMethod() == 0) {
                errMsg = new StringBuilder(String.valueOf(errMsg)).append(" - Wrong Password?").toString();
            }
            throw new ZipException(errMsg);
        }
    }

    private boolean checkLocalHeader() throws ZipException {
        RandomAccessFile rafForLH = null;
        try {
            rafForLH = checkSplitFile();
            if (rafForLH == null) {
                rafForLH = new RandomAccessFile(new File(this.zipModel.getZipFile()), InternalZipConstants.READ_MODE);
            }
            this.localFileHeader = new HeaderReader(rafForLH).readLocalFileHeader(this.fileHeader);
            if (this.localFileHeader == null) {
                throw new ZipException("error reading local file header. Is this a valid zip file?");
            } else if (this.localFileHeader.getCompressionMethod() != this.fileHeader.getCompressionMethod()) {
                if (rafForLH != null) {
                    try {
                        rafForLH.close();
                    } catch (IOException e) {
                    } catch (Exception e2) {
                    }
                }
                return false;
            } else {
                if (rafForLH != null) {
                    try {
                        rafForLH.close();
                    } catch (IOException e3) {
                    } catch (Exception e4) {
                    }
                }
                return true;
            }
        } catch (Throwable e5) {
            throw new ZipException(e5);
        } catch (Throwable th) {
            if (rafForLH != null) {
                try {
                    rafForLH.close();
                } catch (IOException e6) {
                } catch (Exception e7) {
                }
            }
        }
    }

    private RandomAccessFile checkSplitFile() throws ZipException {
        if (!this.zipModel.isSplitArchive()) {
            return null;
        }
        String partFile;
        int diskNumberStartOfFile = this.fileHeader.getDiskNumberStart();
        this.currSplitFileCounter = diskNumberStartOfFile + 1;
        String curZipFile = this.zipModel.getZipFile();
        if (diskNumberStartOfFile == this.zipModel.getEndCentralDirRecord().getNoOfThisDisk()) {
            partFile = this.zipModel.getZipFile();
        } else if (diskNumberStartOfFile >= 9) {
            partFile = curZipFile.substring(0, curZipFile.lastIndexOf(".")) + ".z" + (diskNumberStartOfFile + 1);
        } else {
            partFile = curZipFile.substring(0, curZipFile.lastIndexOf(".")) + ".z0" + (diskNumberStartOfFile + 1);
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(partFile, InternalZipConstants.READ_MODE);
            if (this.currSplitFileCounter != 1) {
                return randomAccessFile;
            }
            byte[] splitSig = new byte[4];
            randomAccessFile.read(splitSig);
            if (((long) Raw.readIntLittleEndian(splitSig, 0)) == InternalZipConstants.SPLITSIG) {
                return randomAccessFile;
            }
            throw new ZipException("invalid first part split file signature");
        } catch (Throwable e) {
            throw new ZipException(e);
        } catch (Throwable e2) {
            throw new ZipException(e2);
        }
    }

    private RandomAccessFile createFileHandler(String mode) throws ZipException {
        if (this.zipModel == null || !Zip4jUtil.isStringNotNullAndNotEmpty(this.zipModel.getZipFile())) {
            throw new ZipException("input parameter is null in getFilePointer");
        }
        try {
            if (this.zipModel.isSplitArchive()) {
                return checkSplitFile();
            }
            return new RandomAccessFile(new File(this.zipModel.getZipFile()), mode);
        } catch (Throwable e) {
            throw new ZipException(e);
        } catch (Throwable e2) {
            throw new ZipException(e2);
        }
    }

    private FileOutputStream getOutputStream(String outPath, String newFileName) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(outPath)) {
            try {
                File file = new File(getOutputFileNameWithPath(outPath, newFileName));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                return new FileOutputStream(file);
            } catch (Throwable e) {
                throw new ZipException(e);
            }
        }
        throw new ZipException("invalid output path");
    }

    private String getOutputFileNameWithPath(String outPath, String newFileName) throws ZipException {
        String fileName;
        if (Zip4jUtil.isStringNotNullAndNotEmpty(newFileName)) {
            fileName = newFileName;
        } else {
            fileName = this.fileHeader.getFileName();
        }
        return new StringBuilder(String.valueOf(outPath)).append(System.getProperty("file.separator")).append(fileName).toString();
    }

    public RandomAccessFile startNextSplitFile() throws IOException, FileNotFoundException {
        String partFile;
        String currZipFile = this.zipModel.getZipFile();
        if (this.currSplitFileCounter == this.zipModel.getEndCentralDirRecord().getNoOfThisDisk()) {
            partFile = this.zipModel.getZipFile();
        } else if (this.currSplitFileCounter >= 9) {
            partFile = currZipFile.substring(0, currZipFile.lastIndexOf(".")) + ".z" + (this.currSplitFileCounter + 1);
        } else {
            partFile = currZipFile.substring(0, currZipFile.lastIndexOf(".")) + ".z0" + (this.currSplitFileCounter + 1);
        }
        this.currSplitFileCounter++;
        try {
            if (Zip4jUtil.checkFileExists(partFile)) {
                return new RandomAccessFile(partFile, InternalZipConstants.READ_MODE);
            }
            throw new IOException("zip split file does not exist: " + partFile);
        } catch (ZipException e) {
            throw new IOException(e.getMessage());
        }
    }

    private void closeStreams(InputStream is, OutputStream os) throws ZipException {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                if (e != null) {
                    if (Zip4jUtil.isStringNotNullAndNotEmpty(e.getMessage()) && e.getMessage().indexOf(" - Wrong Password?") >= 0) {
                        throw new ZipException(e.getMessage());
                    }
                }
                if (os != null) {
                    try {
                        os.close();
                        return;
                    } catch (IOException e2) {
                        return;
                    }
                }
                return;
            } catch (Throwable th) {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e3) {
                    }
                }
            }
        }
        if (os != null) {
            try {
                os.close();
            } catch (IOException e4) {
            }
        }
    }

    public void updateCRC(int b) {
        this.crc.update(b);
    }

    public void updateCRC(byte[] buff, int offset, int len) {
        if (buff != null) {
            this.crc.update(buff, offset, len);
        }
    }

    public FileHeader getFileHeader() {
        return this.fileHeader;
    }

    public IDecrypter getDecrypter() {
        return this.decrypter;
    }

    public ZipModel getZipModel() {
        return this.zipModel;
    }

    public LocalFileHeader getLocalFileHeader() {
        return this.localFileHeader;
    }
}
