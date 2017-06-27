package net.lingala.zip4j.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.SplitOutputStream;
import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.ArchiveMaintainer;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;
import org.tukaani.xz.LZMA2Options;

public class ZipEngine {
    private ZipModel zipModel;

    public ZipEngine(ZipModel zipModel) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null in ZipEngine constructor");
        }
        this.zipModel = zipModel;
    }

    public void addFiles(ArrayList fileList, ZipParameters parameters, ProgressMonitor progressMonitor, boolean runInThread) throws ZipException {
        if (fileList == null || parameters == null) {
            throw new ZipException("one of the input parameters is null when adding files");
        } else if (fileList.size() <= 0) {
            throw new ZipException("no files to add");
        } else {
            progressMonitor.setCurrentOperation(0);
            progressMonitor.setState(1);
            progressMonitor.setResult(1);
            if (runInThread) {
                progressMonitor.setTotalWork(calculateTotalWork(fileList, parameters));
                progressMonitor.setFileName(((File) fileList.get(0)).getAbsolutePath());
                final ArrayList arrayList = fileList;
                final ZipParameters zipParameters = parameters;
                final ProgressMonitor progressMonitor2 = progressMonitor;
                new Thread(InternalZipConstants.THREAD_NAME) {
                    public void run() {
                        try {
                            ZipEngine.this.initAddFiles(arrayList, zipParameters, progressMonitor2);
                        } catch (ZipException e) {
                        }
                    }
                }.start();
                return;
            }
            initAddFiles(fileList, parameters, progressMonitor);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initAddFiles(java.util.ArrayList r19, net.lingala.zip4j.model.ZipParameters r20, net.lingala.zip4j.progress.ProgressMonitor r21) throws net.lingala.zip4j.exception.ZipException {
        /*
        r18 = this;
        if (r19 == 0) goto L_0x0004;
    L_0x0002:
        if (r20 != 0) goto L_0x000c;
    L_0x0004:
        r14 = new net.lingala.zip4j.exception.ZipException;
        r15 = "one of the input parameters is null when adding files";
        r14.<init>(r15);
        throw r14;
    L_0x000c:
        r14 = r19.size();
        if (r14 > 0) goto L_0x001a;
    L_0x0012:
        r14 = new net.lingala.zip4j.exception.ZipException;
        r15 = "no files to add";
        r14.<init>(r15);
        throw r14;
    L_0x001a:
        r0 = r18;
        r14 = r0.zipModel;
        r14 = r14.getEndCentralDirRecord();
        if (r14 != 0) goto L_0x002f;
    L_0x0024:
        r0 = r18;
        r14 = r0.zipModel;
        r15 = r18.createEndOfCentralDirectoryRecord();
        r14.setEndCentralDirRecord(r15);
    L_0x002f:
        r9 = 0;
        r6 = 0;
        r0 = r18;
        r1 = r20;
        r0.checkParameters(r1);	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r18.removeFilesIfExists(r19, r20, r21);	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r0 = r18;
        r14 = r0.zipModel;	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r14 = r14.getZipFile();	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r8 = net.lingala.zip4j.util.Zip4jUtil.checkFileExists(r14);	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r13 = new net.lingala.zip4j.io.SplitOutputStream;	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r14 = new java.io.File;	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r0 = r18;
        r15 = r0.zipModel;	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r15 = r15.getZipFile();	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r14.<init>(r15);	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r0 = r18;
        r15 = r0.zipModel;	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r16 = r15.getSplitLength();	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r0 = r16;
        r13.<init>(r14, r0);	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r10 = new net.lingala.zip4j.io.ZipOutputStream;	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r0 = r18;
        r14 = r0.zipModel;	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        r10.<init>(r13, r14);	 Catch:{ ZipException -> 0x0230, Exception -> 0x022a }
        if (r8 == 0) goto L_0x00a3;
    L_0x006e:
        r0 = r18;
        r14 = r0.zipModel;	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        r14 = r14.getEndCentralDirRecord();	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        if (r14 != 0) goto L_0x0094;
    L_0x0078:
        r14 = new net.lingala.zip4j.exception.ZipException;	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        r15 = "invalid end of central directory record";
        r14.<init>(r15);	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        throw r14;	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
    L_0x0080:
        r2 = move-exception;
        r9 = r10;
    L_0x0082:
        r0 = r21;
        r0.endProgressMonitorError(r2);	 Catch:{ all -> 0x0088 }
        throw r2;	 Catch:{ all -> 0x0088 }
    L_0x0088:
        r14 = move-exception;
    L_0x0089:
        if (r6 == 0) goto L_0x008e;
    L_0x008b:
        r6.close();	 Catch:{ IOException -> 0x0219 }
    L_0x008e:
        if (r9 == 0) goto L_0x0093;
    L_0x0090:
        r9.close();	 Catch:{ IOException -> 0x021c }
    L_0x0093:
        throw r14;
    L_0x0094:
        r0 = r18;
        r14 = r0.zipModel;	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        r14 = r14.getEndCentralDirRecord();	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        r14 = r14.getOffsetOfStartOfCentralDir();	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        r13.seek(r14);	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
    L_0x00a3:
        r14 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r11 = new byte[r14];	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        r12 = -1;
        r5 = 0;
        r7 = r6;
    L_0x00aa:
        r14 = r19.size();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r5 < r14) goto L_0x00c2;
    L_0x00b0:
        r10.finish();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r21.endProgressMonitorSuccess();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r7 == 0) goto L_0x00bb;
    L_0x00b8:
        r7.close();	 Catch:{ IOException -> 0x021f }
    L_0x00bb:
        if (r10 == 0) goto L_0x00c0;
    L_0x00bd:
        r10.close();	 Catch:{ IOException -> 0x0222 }
    L_0x00c0:
        r6 = r7;
    L_0x00c1:
        return;
    L_0x00c2:
        r14 = r21.isCancelAllTasks();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r14 == 0) goto L_0x00e0;
    L_0x00c8:
        r14 = 3;
        r0 = r21;
        r0.setResult(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = 0;
        r0 = r21;
        r0.setState(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r7 == 0) goto L_0x00d9;
    L_0x00d6:
        r7.close();	 Catch:{ IOException -> 0x020b }
    L_0x00d9:
        if (r10 == 0) goto L_0x00de;
    L_0x00db:
        r10.close();	 Catch:{ IOException -> 0x020e }
    L_0x00de:
        r6 = r7;
        goto L_0x00c1;
    L_0x00e0:
        r4 = r20.clone();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r4 = (net.lingala.zip4j.model.ZipParameters) r4;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r0 = r19;
        r14 = r0.get(r5);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = (java.io.File) r14;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = r14.getAbsolutePath();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r0 = r21;
        r0.setFileName(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r0 = r19;
        r14 = r0.get(r5);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = (java.io.File) r14;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = r14.isDirectory();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r14 != 0) goto L_0x0168;
    L_0x0105:
        r14 = r4.isEncryptFiles();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r14 == 0) goto L_0x0152;
    L_0x010b:
        r14 = r4.getEncryptionMethod();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r14 != 0) goto L_0x0152;
    L_0x0111:
        r14 = 3;
        r0 = r21;
        r0.setCurrentOperation(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r0 = r19;
        r14 = r0.get(r5);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = (java.io.File) r14;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = r14.getAbsolutePath();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r0 = r21;
        r14 = net.lingala.zip4j.util.CRCUtil.computeFileCRC(r14, r0);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = (int) r14;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r4.setSourceFileCRC(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = 0;
        r0 = r21;
        r0.setCurrentOperation(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = r21.isCancelAllTasks();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r14 == 0) goto L_0x0152;
    L_0x0139:
        r14 = 3;
        r0 = r21;
        r0.setResult(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = 0;
        r0 = r21;
        r0.setState(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r7 == 0) goto L_0x014a;
    L_0x0147:
        r7.close();	 Catch:{ IOException -> 0x0211 }
    L_0x014a:
        if (r10 == 0) goto L_0x014f;
    L_0x014c:
        r10.close();	 Catch:{ IOException -> 0x0214 }
    L_0x014f:
        r6 = r7;
        goto L_0x00c1;
    L_0x0152:
        r0 = r19;
        r14 = r0.get(r5);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = (java.io.File) r14;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = net.lingala.zip4j.util.Zip4jUtil.getFileLengh(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r16 = 0;
        r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r14 != 0) goto L_0x0168;
    L_0x0164:
        r14 = 0;
        r4.setCompressionMethod(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
    L_0x0168:
        r0 = r19;
        r3 = r0.get(r5);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r3 = (java.io.File) r3;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = r3.isFile();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r14 != 0) goto L_0x0182;
    L_0x0176:
        r14 = r3.isDirectory();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r14 != 0) goto L_0x0182;
    L_0x017c:
        r6 = r7;
    L_0x017d:
        r5 = r5 + 1;
        r7 = r6;
        goto L_0x00aa;
    L_0x0182:
        r0 = r19;
        r14 = r0.get(r5);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = (java.io.File) r14;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r10.putNextEntry(r14, r4);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r0 = r19;
        r14 = r0.get(r5);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = (java.io.File) r14;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = r14.isDirectory();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        if (r14 == 0) goto L_0x01a0;
    L_0x019b:
        r10.closeEntry();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r6 = r7;
        goto L_0x017d;
    L_0x01a0:
        r15 = java.lang.System.out;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r0 = r19;
        r14 = r0.get(r5);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = (java.io.File) r14;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = r14.getAbsolutePath();	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r15.println(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r6 = new java.io.FileInputStream;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r0 = r19;
        r14 = r0.get(r5);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r14 = (java.io.File) r14;	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
        r6.<init>(r14);	 Catch:{ ZipException -> 0x0233, Exception -> 0x022c, all -> 0x0225 }
    L_0x01be:
        r12 = r6.read(r11);	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        r14 = -1;
        if (r12 != r14) goto L_0x01db;
    L_0x01c5:
        r10.closeEntry();	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        if (r6 == 0) goto L_0x017d;
    L_0x01ca:
        r6.close();	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        goto L_0x017d;
    L_0x01ce:
        r2 = move-exception;
        r9 = r10;
    L_0x01d0:
        r0 = r21;
        r0.endProgressMonitorError(r2);	 Catch:{ all -> 0x0088 }
        r14 = new net.lingala.zip4j.exception.ZipException;	 Catch:{ all -> 0x0088 }
        r14.<init>(r2);	 Catch:{ all -> 0x0088 }
        throw r14;	 Catch:{ all -> 0x0088 }
    L_0x01db:
        r14 = r21.isCancelAllTasks();	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        if (r14 == 0) goto L_0x01fc;
    L_0x01e1:
        r14 = 3;
        r0 = r21;
        r0.setResult(r14);	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        r14 = 0;
        r0 = r21;
        r0.setState(r14);	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        if (r6 == 0) goto L_0x01f2;
    L_0x01ef:
        r6.close();	 Catch:{ IOException -> 0x0217 }
    L_0x01f2:
        if (r10 == 0) goto L_0x00c1;
    L_0x01f4:
        r10.close();	 Catch:{ IOException -> 0x01f9 }
        goto L_0x00c1;
    L_0x01f9:
        r14 = move-exception;
        goto L_0x00c1;
    L_0x01fc:
        r14 = 0;
        r10.write(r11, r14, r12);	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        r14 = (long) r12;	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        r0 = r21;
        r0.updateWorkCompleted(r14);	 Catch:{ ZipException -> 0x0080, Exception -> 0x01ce, all -> 0x0207 }
        goto L_0x01be;
    L_0x0207:
        r14 = move-exception;
        r9 = r10;
        goto L_0x0089;
    L_0x020b:
        r14 = move-exception;
        goto L_0x00d9;
    L_0x020e:
        r14 = move-exception;
        goto L_0x00de;
    L_0x0211:
        r14 = move-exception;
        goto L_0x014a;
    L_0x0214:
        r14 = move-exception;
        goto L_0x014f;
    L_0x0217:
        r14 = move-exception;
        goto L_0x01f2;
    L_0x0219:
        r15 = move-exception;
        goto L_0x008e;
    L_0x021c:
        r15 = move-exception;
        goto L_0x0093;
    L_0x021f:
        r14 = move-exception;
        goto L_0x00bb;
    L_0x0222:
        r14 = move-exception;
        goto L_0x00c0;
    L_0x0225:
        r14 = move-exception;
        r6 = r7;
        r9 = r10;
        goto L_0x0089;
    L_0x022a:
        r2 = move-exception;
        goto L_0x01d0;
    L_0x022c:
        r2 = move-exception;
        r6 = r7;
        r9 = r10;
        goto L_0x01d0;
    L_0x0230:
        r2 = move-exception;
        goto L_0x0082;
    L_0x0233:
        r2 = move-exception;
        r6 = r7;
        r9 = r10;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.zip.ZipEngine.initAddFiles(java.util.ArrayList, net.lingala.zip4j.model.ZipParameters, net.lingala.zip4j.progress.ProgressMonitor):void");
    }

    public void addStreamToZip(InputStream inputStream, ZipParameters parameters) throws ZipException {
        ZipException e;
        Throwable e2;
        Throwable th;
        if (inputStream == null || parameters == null) {
            throw new ZipException("one of the input parameters is null, cannot add stream to zip");
        }
        ZipOutputStream zipOutputStream = null;
        try {
            checkParameters(parameters);
            boolean isZipFileAlreadExists = Zip4jUtil.checkFileExists(this.zipModel.getZipFile());
            SplitOutputStream splitOutputStream = new SplitOutputStream(new File(this.zipModel.getZipFile()), this.zipModel.getSplitLength());
            ZipOutputStream outputStream = new ZipOutputStream(splitOutputStream, this.zipModel);
            if (isZipFileAlreadExists) {
                try {
                    if (this.zipModel.getEndCentralDirRecord() == null) {
                        throw new ZipException("invalid end of central directory record");
                    }
                    splitOutputStream.seek(this.zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
                } catch (ZipException e3) {
                    e = e3;
                    zipOutputStream = outputStream;
                } catch (Exception e4) {
                    e2 = e4;
                    zipOutputStream = outputStream;
                } catch (Throwable th2) {
                    th = th2;
                    zipOutputStream = outputStream;
                }
            }
            byte[] readBuff = new byte[LZMA2Options.DICT_SIZE_MIN];
            outputStream.putNextEntry(null, parameters);
            if (!parameters.getFileNameInZip().endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) && !parameters.getFileNameInZip().endsWith("\\")) {
                while (true) {
                    int readLen = inputStream.read(readBuff);
                    if (readLen == -1) {
                        break;
                    }
                    outputStream.write(readBuff, 0, readLen);
                }
            }
            outputStream.closeEntry();
            outputStream.finish();
            if (outputStream != null) {
                try {
                    outputStream.close();
                    return;
                } catch (IOException e5) {
                    return;
                }
            }
            return;
        } catch (ZipException e6) {
            e = e6;
            try {
                throw e;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e7) {
            e2 = e7;
            throw new ZipException(e2);
        }
        throw th;
        if (zipOutputStream != null) {
            try {
                zipOutputStream.close();
            } catch (IOException e8) {
            }
        }
        throw th;
    }

    public void addFolderToZip(File file, ZipParameters parameters, ProgressMonitor progressMonitor, boolean runInThread) throws ZipException {
        if (file == null || parameters == null) {
            throw new ZipException("one of the input parameters is null, cannot add folder to zip");
        } else if (!Zip4jUtil.checkFileExists(file.getAbsolutePath())) {
            throw new ZipException("input folder does not exist");
        } else if (!file.isDirectory()) {
            throw new ZipException("input file is not a folder, user addFileToZip method to add files");
        } else if (Zip4jUtil.checkFileReadAccess(file.getAbsolutePath())) {
            String rootFolderPath = parameters.isIncludeRootFolder() ? file.getAbsolutePath() != null ? file.getAbsoluteFile().getParentFile() != null ? file.getAbsoluteFile().getParentFile().getAbsolutePath() : "" : file.getParentFile() != null ? file.getParentFile().getAbsolutePath() : "" : file.getAbsolutePath();
            parameters.setDefaultFolderPath(rootFolderPath);
            ArrayList fileList = Zip4jUtil.getFilesInDirectoryRec(file, parameters.isReadHiddenFiles());
            if (parameters.isIncludeRootFolder()) {
                if (fileList == null) {
                    fileList = new ArrayList();
                }
                fileList.add(file);
            }
            addFiles(fileList, parameters, progressMonitor, runInThread);
        } else {
            throw new ZipException("cannot read folder: " + file.getAbsolutePath());
        }
    }

    private void checkParameters(ZipParameters parameters) throws ZipException {
        if (parameters == null) {
            throw new ZipException("cannot validate zip parameters");
        } else if (parameters.getCompressionMethod() != 0 && parameters.getCompressionMethod() != 8) {
            throw new ZipException("unsupported compression type");
        } else if (parameters.getCompressionMethod() == 8 && parameters.getCompressionLevel() < 0 && parameters.getCompressionLevel() > 9) {
            throw new ZipException("invalid compression level. compression level dor deflate should be in the range of 0-9");
        } else if (!parameters.isEncryptFiles()) {
            parameters.setAesKeyStrength(-1);
            parameters.setEncryptionMethod(-1);
        } else if (parameters.getEncryptionMethod() != 0 && parameters.getEncryptionMethod() != 99) {
            throw new ZipException("unsupported encryption method");
        } else if (parameters.getPassword() == null || parameters.getPassword().length <= 0) {
            throw new ZipException("input password is empty or null");
        }
    }

    private void removeFilesIfExists(ArrayList fileList, ZipParameters parameters, ProgressMonitor progressMonitor) throws ZipException {
        if (this.zipModel != null && this.zipModel.getCentralDirectory() != null && this.zipModel.getCentralDirectory().getFileHeaders() != null && this.zipModel.getCentralDirectory().getFileHeaders().size() > 0) {
            RandomAccessFile outputStream = null;
            int i = 0;
            while (i < fileList.size()) {
                try {
                    FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, Zip4jUtil.getRelativeFileName(((File) fileList.get(i)).getAbsolutePath(), parameters.getRootFolderInZip(), parameters.getDefaultFolderPath()));
                    if (fileHeader != null) {
                        if (outputStream != null) {
                            outputStream.close();
                            outputStream = null;
                        }
                        ArchiveMaintainer archiveMaintainer = new ArchiveMaintainer();
                        progressMonitor.setCurrentOperation(2);
                        HashMap retMap = archiveMaintainer.initRemoveZipFile(this.zipModel, fileHeader, progressMonitor);
                        if (progressMonitor.isCancelAllTasks()) {
                            progressMonitor.setResult(3);
                            progressMonitor.setState(0);
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                    return;
                                } catch (IOException e) {
                                    return;
                                }
                            }
                            return;
                        }
                        progressMonitor.setCurrentOperation(0);
                        if (outputStream == null) {
                            outputStream = prepareFileOutputStream();
                            if (!(retMap == null || retMap.get(InternalZipConstants.OFFSET_CENTRAL_DIR) == null)) {
                                long offsetCentralDir = Long.parseLong((String) retMap.get(InternalZipConstants.OFFSET_CENTRAL_DIR));
                                if (offsetCentralDir >= 0) {
                                    outputStream.seek(offsetCentralDir);
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                } catch (NumberFormatException e2) {
                    throw new ZipException("NumberFormatException while parsing offset central directory. Cannot update already existing file header");
                } catch (Exception e3) {
                    throw new ZipException("Error while parsing offset central directory. Cannot update already existing file header");
                } catch (Throwable e4) {
                    try {
                        throw new ZipException(e4);
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                    }
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e6) {
                }
            }
        }
    }

    private RandomAccessFile prepareFileOutputStream() throws ZipException {
        String outPath = this.zipModel.getZipFile();
        if (Zip4jUtil.isStringNotNullAndNotEmpty(outPath)) {
            try {
                File outFile = new File(outPath);
                if (!outFile.getParentFile().exists()) {
                    outFile.getParentFile().mkdirs();
                }
                return new RandomAccessFile(outFile, InternalZipConstants.WRITE_MODE);
            } catch (Throwable e) {
                throw new ZipException(e);
            }
        }
        throw new ZipException("invalid output path");
    }

    private EndCentralDirRecord createEndOfCentralDirectoryRecord() {
        EndCentralDirRecord endCentralDirRecord = new EndCentralDirRecord();
        endCentralDirRecord.setSignature(InternalZipConstants.ENDSIG);
        endCentralDirRecord.setNoOfThisDisk(0);
        endCentralDirRecord.setTotNoOfEntriesInCentralDir(0);
        endCentralDirRecord.setTotNoOfEntriesInCentralDirOnThisDisk(0);
        endCentralDirRecord.setOffsetOfStartOfCentralDir(0);
        return endCentralDirRecord;
    }

    private long calculateTotalWork(ArrayList fileList, ZipParameters parameters) throws ZipException {
        if (fileList == null) {
            throw new ZipException("file list is null, cannot calculate total work");
        }
        long totalWork = 0;
        int i = 0;
        while (i < fileList.size()) {
            if ((fileList.get(i) instanceof File) && ((File) fileList.get(i)).exists()) {
                if (parameters.isEncryptFiles() && parameters.getEncryptionMethod() == 0) {
                    totalWork += Zip4jUtil.getFileLengh((File) fileList.get(i)) * 2;
                } else {
                    totalWork += Zip4jUtil.getFileLengh((File) fileList.get(i));
                }
                if (!(this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null || this.zipModel.getCentralDirectory().getFileHeaders().size() <= 0)) {
                    FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, Zip4jUtil.getRelativeFileName(((File) fileList.get(i)).getAbsolutePath(), parameters.getRootFolderInZip(), parameters.getDefaultFolderPath()));
                    if (fileHeader != null) {
                        totalWork += Zip4jUtil.getFileLengh(new File(this.zipModel.getZipFile())) - fileHeader.getCompressedSize();
                    }
                }
            }
            i++;
        }
        return totalWork;
    }
}
