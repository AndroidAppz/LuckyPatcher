package com.chelpus.root.utils;

import com.chelpus.Utils;
import java.io.File;
import java.io.FileNotFoundException;

public class odex {
    private static String dalvikDexIn = "/data/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
    private static String dalvikDexIn2 = "/cache/dalvik-cache/data@app@zamenitetodelo-1.apk@classes.dex";
    public static String dirapp = "/data/app/";
    public static boolean odexpatch = false;
    public static boolean system = false;
    public static String toolsfiledir = "";
    public static String uid = "";

    public static void main(String[] paramArrayOfString) {
        Utils.startRootJava(new Object() {
        });
        dirapp = paramArrayOfString[1];
        if (paramArrayOfString[2].equals("not_system")) {
            system = false;
        }
        if (paramArrayOfString[2].equals("system")) {
            system = true;
        }
        if (paramArrayOfString[3] != null) {
            toolsfiledir = paramArrayOfString[3];
        }
        if (paramArrayOfString[4] != null) {
            uid = paramArrayOfString[4];
        }
        Utils.kill(paramArrayOfString[0]);
        Utils.remount(dirapp, "RW");
        File appapk = new File(dirapp);
        File appodex = new File(Utils.getOdexForCreate(dirapp, uid));
        if (system && appapk.exists() && appodex.exists() && !Utils.classes_test(appapk)) {
            odexpatch = true;
            File localFile2 = appodex;
            System.out.println("\nOdex Application.\nOnly ODEX patch is enabled.\n");
        }
        if (!odexpatch) {
            String dalvikDex = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]);
            try {
                File localFile1 = new File(dalvikDex);
                if (!localFile1.exists()) {
                    localFile1 = new File(dalvikDex.replace("-1", "-2"));
                }
                localFile2 = new File(dalvikDex.replace("-1", ""));
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                String dalvikDexTemp = dalvikDex.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
                localFile1 = new File(dalvikDexTemp);
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                localFile1 = new File(dalvikDexTemp.replace("-1", "-2"));
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                localFile1 = new File(dalvikDexTemp.replace("-1", ""));
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                dalvikDex = dalvikDexIn2.replace("zamenitetodelo", paramArrayOfString[0]);
                localFile1 = new File(dalvikDex);
                if (!localFile1.exists()) {
                    localFile1 = new File(dalvikDex.replace("-1", "-2"));
                }
                if (!localFile1.exists()) {
                    localFile1 = new File(dalvikDex.replace("-1", ""));
                }
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                dalvikDexTemp = dalvikDex.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
                localFile1 = new File(dalvikDexTemp);
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                localFile1 = new File(dalvikDexTemp.replace("-1", "-2"));
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                localFile1 = new File(dalvikDexTemp.replace("-1", ""));
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                dalvikDex = dalvikDexIn.replace("zamenitetodelo", paramArrayOfString[0]).replace("/data/", "/sd-ext/data/");
                localFile1 = new File(dalvikDex);
                if (!localFile1.exists()) {
                    localFile1 = new File(dalvikDex.replace("-1", "-2"));
                }
                if (!localFile1.exists()) {
                    localFile1 = new File(dalvikDex.replace("-1", ""));
                }
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                dalvikDexTemp = dalvikDex.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
                localFile1 = new File(dalvikDexTemp);
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                localFile1 = new File(dalvikDexTemp.replace("-1", "-2"));
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                localFile1 = new File(dalvikDexTemp.replace("-1", ""));
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                dalvikDex = dalvikDexIn2.replace("zamenitetodelo", paramArrayOfString[0]).replace("/cache/", "/sd-ext/data/cache/");
                localFile1 = new File(dalvikDex);
                if (!localFile1.exists()) {
                    localFile1 = new File(dalvikDex.replace("-1", "-2"));
                }
                if (!localFile1.exists()) {
                    localFile1 = new File(dalvikDex.replace("-1", ""));
                }
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                dalvikDexTemp = dalvikDex.replace("data@app", "mnt@asec").replace(".apk@classes.dex", "@pkg.apk@classes.dex");
                localFile1 = new File(dalvikDexTemp);
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                localFile1 = new File(dalvikDexTemp.replace("-1", "-2"));
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                localFile1 = new File(dalvikDexTemp.replace("-1", ""));
                if (localFile1.exists()) {
                    localFile2 = localFile1;
                }
                if (system) {
                    dalvikDexTemp = dalvikDexIn.replace("zamenitetodelo-1.apk", new File(dirapp).getName()).replace("data@app", "system@app");
                    localFile1 = new File(dalvikDexTemp);
                    if (localFile1.exists()) {
                        localFile2 = localFile1;
                    }
                    localFile1 = new File(dalvikDexTemp.replace("/data/dalvik-cache/", "/sd-ext/data/dalvik-cache/"));
                    if (localFile1.exists()) {
                        localFile2 = localFile1;
                    }
                    localFile1 = new File(dalvikDexTemp.replace("/data/dalvik-cache/", "/sd-ext/data/cache/dalvik-cache/"));
                    if (localFile1.exists()) {
                        localFile2 = localFile1;
                    }
                    localFile1 = new File(dalvikDexTemp.replace("/data/dalvik-cache/", "/cache/dalvik-cache/"));
                    if (localFile1.exists()) {
                        localFile2 = localFile1;
                    }
                    localFile1 = new File(dalvikDexTemp.replace("/data/dalvik-cache/", "/data/dalvik-cache/arm/"));
                    if (localFile1.exists()) {
                        localFile2 = localFile1;
                    }
                }
                if (localFile2.exists()) {
                    String backTemp = Utils.getOdexForCreate(paramArrayOfString[1], uid);
                    File backFile = new File(backTemp);
                    if (backFile.exists()) {
                        backFile.delete();
                    }
                    backFile = new File(backTemp.replace("-2", "-1"));
                    if (backFile.exists()) {
                        backFile.delete();
                    }
                    backFile = new File(backTemp.replace("-1", "-2"));
                    if (backFile.exists()) {
                        backFile.delete();
                    }
                    backFile = new File(backTemp.replace("-2", ""));
                    if (backFile.exists()) {
                        backFile.delete();
                    }
                    backFile = new File(backTemp.replace("-1", ""));
                    if (backFile.exists()) {
                        backFile.delete();
                    }
                    backFile = new File(backTemp);
                    Utils.copyFile(localFile2, backFile);
                    if (backFile.exists()) {
                        System.out.println("Changes Fix to: " + backFile);
                        if (system) {
                            Utils.run_all_no_root("chmod", "644" + backFile.getAbsolutePath());
                            Utils.run_all_no_root("chown", "0.0", backFile.getAbsolutePath());
                            Utils.run_all_no_root("chown", "0:0", backFile.getAbsolutePath());
                        } else {
                            Utils.run_all_no_root("chmod", "644" + backFile.getAbsolutePath());
                            Utils.run_all_no_root("chown", "1000." + uid, backFile.getAbsolutePath());
                            Utils.run_all_no_root("chown", "1000:" + uid, backFile.getAbsolutePath());
                        }
                    }
                    System.out.println("Dalvik-cache fixing!");
                } else {
                    throw new FileNotFoundException();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: Program files are not found!\n\nCheck the location dalvik-cache to solve problems!\n\nDefault: /data/dalvik-cache/*");
            } catch (Exception e2) {
                System.out.println("Error: Exception e" + e2.toString());
            }
        }
        Utils.exitFromRootJava();
    }
}
