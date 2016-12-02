package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.unzip.UnzipUtil;
import net.lingala.zip4j.util.InternalZipConstants;
import org.tukaani.xz.LZMA2Options;

public class restoredata {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        String pkg = paramArrayOfString[0];
        String datadir = paramArrayOfString[1];
        String backup_data_dir = paramArrayOfString[2];
        String uid = paramArrayOfString[3];
        String sddatadir = paramArrayOfString[4];
        File data = new File(backup_data_dir + "/data.lpbkp");
        System.out.println(data.getAbsolutePath());
        if (data.exists()) {
            File datadirs = new File(datadir);
            try {
                ZipFile zipFile = new ZipFile(data);
                System.out.println(datadirs.getAbsolutePath());
                ExtractAllFilesWithInputStreams(zipFile, datadirs.getAbsolutePath(), uid);
            } catch (ZipException e) {
                e.printStackTrace();
                System.out.println("error");
            }
        }
        try {
            File dbdata;
            if (new File("/dbdata/databases/" + pkg).exists()) {
                dbdata = new File(backup_data_dir + "/dbdata.lpbkp");
                if (dbdata.exists()) {
                    try {
                        ExtractAllFilesWithInputStreams(new ZipFile(dbdata), "/dbdata/databases/" + pkg, uid);
                    } catch (ZipException e2) {
                        e2.printStackTrace();
                        System.out.println("error");
                    }
                } else if (new File(datadir + "/shared_prefs").exists()) {
                    copyFolder(new File(datadir + "/shared_prefs"), new File("/dbdata/databases/" + pkg + "/shared_prefs"), uid);
                }
            } else {
                dbdata = new File(backup_data_dir + "/dbdata.lpbkp");
                if (dbdata.exists()) {
                    try {
                        ExtractAllFilesWithInputStreams(new ZipFile(dbdata), datadir, uid);
                    } catch (ZipException e22) {
                        e22.printStackTrace();
                        System.out.println("error");
                    }
                }
            }
            new File(sddatadir + InternalZipConstants.ZIP_FILE_SEPARATOR).mkdirs();
            File data3 = new File(backup_data_dir + "/sddata.lpbkp");
            System.out.println(data3.getAbsolutePath());
            if (data3.exists()) {
                File sddatadirs = new File(sddatadir);
                try {
                    zipFile = new ZipFile(data3);
                    System.out.println(sddatadirs.getAbsolutePath());
                    ExtractAllFilesWithInputStreams(zipFile, sddatadirs.getAbsolutePath(), uid);
                } catch (ZipException e222) {
                    e222.printStackTrace();
                    System.out.println("error");
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Exception e32) {
            e32.printStackTrace();
            System.out.println("Exception e" + e32.toString());
            System.out.println("error");
        }
        Utils.exitFromRootJava();
    }

    public static void ExtractAllFilesWithInputStreams(ZipFile zipFile, String path, String uid) {
        Throwable th;
        ZipInputStream is = null;
        OutputStream outputStream = null;
        String destinationPath = path;
        ZipException e;
        FileNotFoundException e2;
        IOException e3;
        Exception e4;
        try {
            if (zipFile.isEncrypted()) {
                zipFile.setPassword("password");
            }
            OutputStream os = null;
            for (FileHeader fileHeader : zipFile.getFileHeaders()) {
                try {
                    if (fileHeader != null) {
                        File outFile = new File(destinationPath + System.getProperty("file.separator") + fileHeader.getFileName());
                        if (fileHeader.isDirectory()) {
                            outFile.mkdirs();
                            ArrayList<File> dexFound = new ArrayList();
                            new Utils("").findFileEndText(outFile.getAbsoluteFile(), ".dex", dexFound);
                            if (dexFound.size() == 0) {
                                Utils.cmdParam("chmod", "771", outFile.getAbsolutePath());
                                Utils.cmdParam("chown", "0:" + uid, outFile.getAbsolutePath());
                                Utils.cmdParam("chown", "0." + uid, outFile.getAbsolutePath());
                            } else {
                                dexFound.clear();
                            }
                        } else {
                            File parentDir = outFile.getParentFile();
                            if (!parentDir.exists()) {
                                parentDir.mkdirs();
                                Utils.cmdParam("chmod", "771", parentDir.getAbsolutePath());
                                Utils.cmdParam("chown", "0:" + uid, parentDir.getAbsolutePath());
                                Utils.cmdParam("chown", "0." + uid, parentDir.getAbsolutePath());
                            }
                            is = zipFile.getInputStream(fileHeader);
                            outputStream = new FileOutputStream(outFile);
                            byte[] buff = new byte[LZMA2Options.DICT_SIZE_MIN];
                            while (true) {
                                int readLen = is.read(buff);
                                if (readLen == -1) {
                                    break;
                                }
                                outputStream.write(buff, 0, readLen);
                            }
                            closeFileHandlers(is, outputStream);
                            UnzipUtil.applyFileAttributes(fileHeader, outFile);
                            if (outFile.getAbsolutePath().endsWith(".dex")) {
                                Utils.cmdParam("chmod", "700", outFile.getAbsolutePath());
                                Utils.cmdParam("chown", uid + ":" + uid, outFile.getAbsolutePath());
                                Utils.cmdParam("chown", uid + "." + uid, outFile.getAbsolutePath());
                                Utils utils = new Utils("");
                                Utils.setPermissionDir(destinationPath, outFile.getAbsolutePath(), "700", false);
                                utils = new Utils("1");
                                Utils.setOwnerDir(destinationPath, outFile.getAbsolutePath(), uid + ":" + uid, false);
                            } else {
                                Utils.cmdParam("chmod", "771", outFile.getAbsolutePath());
                                Utils.cmdParam("chown", "0:" + uid, outFile.getAbsolutePath());
                                Utils.cmdParam("chown", "0." + uid, outFile.getAbsolutePath());
                            }
                            System.out.println("Done extracting: " + fileHeader.getFileName());
                        }
                    } else {
                        System.err.println("fileheader is null. Shouldn't be here");
                        outputStream = os;
                    }
                    os = outputStream;
                } catch (ZipException e5) {
                    e = e5;
                    outputStream = os;
                } catch (FileNotFoundException e6) {
                    e2 = e6;
                    outputStream = os;
                } catch (IOException e7) {
                    e3 = e7;
                    outputStream = os;
                } catch (Exception e8) {
                    e4 = e8;
                    outputStream = os;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = os;
                }
            }
            try {
                closeFileHandlers(is, os);
                outputStream = os;
                return;
            } catch (IOException e32) {
                e32.printStackTrace();
                System.out.println("error");
                outputStream = os;
                return;
            }
            e32.printStackTrace();
            System.out.println("error");
            try {
                closeFileHandlers(is, outputStream);
                return;
            } catch (IOException e322) {
                e322.printStackTrace();
                System.out.println("error");
                return;
            }
            e2.printStackTrace();
            System.out.println("error");
            try {
                closeFileHandlers(is, outputStream);
                return;
            } catch (IOException e3222) {
                e3222.printStackTrace();
                System.out.println("error");
                return;
            }
            e4.printStackTrace();
            System.out.println("error");
            try {
                closeFileHandlers(is, outputStream);
                return;
            } catch (IOException e32222) {
                e32222.printStackTrace();
                System.out.println("error");
                return;
            }
            try {
                e.printStackTrace();
                System.out.println("error");
                try {
                    closeFileHandlers(is, outputStream);
                } catch (IOException e322222) {
                    e322222.printStackTrace();
                    System.out.println("error");
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    closeFileHandlers(is, outputStream);
                } catch (IOException e3222222) {
                    e3222222.printStackTrace();
                    System.out.println("error");
                }
                throw th;
            }
        } catch (ZipException e9) {
            e = e9;
        } catch (FileNotFoundException e10) {
            e2 = e10;
        } catch (IOException e11) {
            e3222222 = e11;
        } catch (Exception e12) {
            e4 = e12;
        }
    }

    private static void closeFileHandlers(ZipInputStream is, OutputStream os) throws IOException {
        if (os != null) {
            os.close();
        }
        if (is != null) {
            is.close();
        }
    }

    public static void copyFolder(File src, File dest, String uid) throws Exception {
        int i = 0;
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
                Utils.cmdParam("chmod", "771", dest.getAbsolutePath());
                Utils.cmdParam("chown", "0:" + uid, dest.getAbsolutePath());
                Utils.cmdParam("chown", "0." + uid, dest.getAbsolutePath());
                System.out.println("Directory copied from " + src + "  to " + dest);
            }
            String[] files = src.list();
            if (files.length > 0) {
                int length = files.length;
                while (i < length) {
                    String file = files[i];
                    copyFolder(new File(src, file), new File(dest, file), uid);
                    i++;
                }
                return;
            }
            return;
        }
        Utils.copyFile(src, dest);
        Utils.cmdParam("chmod", "771", dest.getAbsolutePath());
        Utils.cmdParam("chown", "0:" + uid, dest.getAbsolutePath());
        Utils.cmdParam("chown", "0." + uid, dest.getAbsolutePath());
    }
}
