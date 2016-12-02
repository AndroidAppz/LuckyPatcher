package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

public class backupdata {
    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        String pkg = paramArrayOfString[0];
        String datadir = paramArrayOfString[1];
        String backup_data_dir = paramArrayOfString[2];
        String sd_data_dir = paramArrayOfString[3];
        boolean error = false;
        File data = new File(backup_data_dir + "/data.lpbkp");
        File data2 = new File(backup_data_dir + "/data.lpbkp.tmp");
        File dbdata = new File(backup_data_dir + "/dbdata.lpbkp");
        File dbdata2 = new File(backup_data_dir + "/dbdata.lpbkp.tmp");
        File file = new File(backup_data_dir + "/sddata.lpbkp");
        file = new File(backup_data_dir + "/sddata.lpbkp.tmp");
        if (data.exists()) {
            data.renameTo(data2);
        }
        ZipFile zipFile = new ZipFile(data);
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(8);
        parameters.setCompressionLevel(1);
        System.out.println(datadir);
        File datadirs = new File(datadir);
        System.out.println(datadirs);
        File[] folders = datadirs.listFiles();
        if (!(folders == null || folders.length == 0)) {
            for (File file2 : folders) {
                if (!file2.isDirectory() || file2.getName().equals("lib")) {
                    try {
                        if (file2.isFile()) {
                            try {
                                zipFile.addFile(file2, parameters);
                            } catch (ZipException e) {
                                e.printStackTrace();
                                error = true;
                                System.out.println("error");
                            }
                        } else {
                            continue;
                        }
                    } catch (ZipException e2) {
                        try {
                            e2.printStackTrace();
                            error = true;
                            System.out.println("error");
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            System.out.println("Exception e" + e3.toString());
                            error = true;
                            System.out.println("error");
                        }
                    }
                } else {
                    try {
                        System.out.println(file2.getAbsolutePath());
                        zipFile.addFolder(file2, parameters);
                    } catch (ZipException e22) {
                        e22.printStackTrace();
                        error = true;
                        System.out.println("error");
                    }
                }
            }
        }
        if (new File("/dbdata/databases/" + pkg).exists()) {
            if (dbdata.exists()) {
                dbdata.renameTo(dbdata2);
            }
            zipFile = new ZipFile(dbdata);
            File[] files = new File("/dbdata/databases/" + pkg).listFiles();
            if (!(folders == null || folders.length == 0)) {
                for (File file22 : files) {
                    if (file22.isDirectory()) {
                        try {
                            zipFile.addFolder(file22, parameters);
                        } catch (ZipException e222) {
                            e222.printStackTrace();
                            error = true;
                            System.out.println("error");
                        }
                    } else {
                        try {
                            zipFile.addFile(file22, parameters);
                        } catch (ZipException e2222) {
                            e2222.printStackTrace();
                            error = true;
                            System.out.println("error");
                        }
                    }
                }
            }
        }
        if (new File(sd_data_dir).exists()) {
            if (file.exists()) {
                file.renameTo(file);
            }
            zipFile = new ZipFile(file);
            files = new File(sd_data_dir).listFiles();
            if (!(folders == null || folders.length == 0)) {
                for (File file222 : files) {
                    if (file222.isDirectory()) {
                        try {
                            zipFile.addFolder(file222, parameters);
                        } catch (ZipException e22222) {
                            e22222.printStackTrace();
                            error = true;
                            System.out.println("error");
                        }
                    } else {
                        try {
                            zipFile.addFile(file222, parameters);
                        } catch (ZipException e222222) {
                            e222222.printStackTrace();
                            error = true;
                            System.out.println("error");
                        }
                    }
                }
            }
        }
        if (!(error || data.exists() || dbdata.exists())) {
            System.out.println("empty data...");
        }
        if (error || data.exists()) {
            data2.delete();
        } else {
            data2.renameTo(data);
        }
        if (error || dbdata.exists()) {
            dbdata2.delete();
        } else {
            dbdata2.renameTo(dbdata);
        }
        if (error || file.exists()) {
            file.delete();
        } else {
            file.renameTo(dbdata);
        }
        Utils.exitFromRootJava();
    }
}
