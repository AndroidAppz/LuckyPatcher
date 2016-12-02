/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.UnsupportedEncodingException
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Calendar
 *  java.util.Collection
 *  java.util.Date
 *  java.util.List
 *  java.util.TimeZone
 */
package net.lingala.zip4j.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.InternalZipConstants;

public class Zip4jUtil {
    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static boolean checkArrayListTypes(ArrayList arrayList, int n) throws ZipException {
        if (arrayList == null) {
            throw new ZipException("input arraylist is null, cannot check types");
        }
        if (arrayList.size() <= 0) {
            return true;
        }
        boolean bl = false;
        switch (n) {
            default: {
                if (!bl) return true;
                return false;
            }
            case 1: {
                int n2 = 0;
                do {
                    int n3 = arrayList.size();
                    bl = false;
                    if (n2 >= n3) return true;
                    if (!(arrayList.get(n2) instanceof File)) {
                        return false;
                    }
                    ++n2;
                } while (true);
            }
            case 2: 
        }
        int n4 = 0;
        do {
            int n5 = arrayList.size();
            bl = false;
            if (n4 >= n5) return true;
            if (!(arrayList.get(n4) instanceof String)) {
                return false;
            }
            ++n4;
        } while (true);
    }

    public static boolean checkFileExists(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("cannot check if file exists: input file is null");
        }
        return file.exists();
    }

    public static boolean checkFileExists(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("path is null");
        }
        return Zip4jUtil.checkFileExists(new File(string));
    }

    public static boolean checkFileReadAccess(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("path is null");
        }
        if (!Zip4jUtil.checkFileExists(string)) {
            throw new ZipException("file does not exist: " + string);
        }
        try {
            boolean bl = new File(string).canRead();
            return bl;
        }
        catch (Exception var1_2) {
            throw new ZipException("cannot read zip file");
        }
    }

    public static boolean checkFileWriteAccess(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("path is null");
        }
        if (!Zip4jUtil.checkFileExists(string)) {
            throw new ZipException("file does not exist: " + string);
        }
        try {
            boolean bl = new File(string).canWrite();
            return bl;
        }
        catch (Exception var1_2) {
            throw new ZipException("cannot read zip file");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean checkOutputFolder(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException((Throwable)new NullPointerException("output path is null"));
        }
        File file = new File(string);
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new ZipException("output folder is not valid");
            }
            if (file.canWrite()) return true;
            {
                throw new ZipException("no write access to output folder");
            }
        }
        try {
            file.mkdirs();
            if (!file.isDirectory()) {
                throw new ZipException("output folder is not valid");
            }
            if (file.canWrite()) return true;
            {
                throw new ZipException("no write access to destination folder");
            }
        }
        catch (Exception var2_2) {
            throw new ZipException("Cannot create destination folder");
        }
    }

    public static byte[] convertCharset(String string) throws ZipException {
        try {
            String string2 = Zip4jUtil.detectCharSet(string);
            if (string2.equals((Object)"Cp850")) {
                return string.getBytes("Cp850");
            }
            if (string2.equals((Object)"UTF8")) {
                return string.getBytes("UTF8");
            }
            byte[] arrby = string.getBytes();
            return arrby;
        }
        catch (UnsupportedEncodingException var2_3) {
            return string.getBytes();
        }
        catch (Exception var1_4) {
            throw new ZipException((Throwable)var1_4);
        }
    }

    public static String decodeFileName(byte[] arrby, boolean bl) {
        if (bl) {
            try {
                String string = new String(arrby, "UTF8");
                return string;
            }
            catch (UnsupportedEncodingException var3_3) {
                return new String(arrby);
            }
        }
        return Zip4jUtil.getCp850EncodedString(arrby);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String detectCharSet(String string) throws ZipException {
        if (string == null) {
            throw new ZipException("input string is null, cannot detect charset");
        }
        try {
            if (string.equals((Object)new String(string.getBytes("Cp850"), "Cp850"))) {
                return "Cp850";
            }
            if (!string.equals((Object)new String(string.getBytes("UTF8"), "UTF8"))) return InternalZipConstants.CHARSET_DEFAULT;
            return "UTF8";
        }
        catch (UnsupportedEncodingException var2_2) {
            return InternalZipConstants.CHARSET_DEFAULT;
        }
        catch (Exception var1_3) {
            return InternalZipConstants.CHARSET_DEFAULT;
        }
    }

    public static long dosToJavaTme(int n) {
        int n2 = 2 * (n & 31);
        int n3 = 63 & n >> 5;
        int n4 = 31 & n >> 11;
        int n5 = 31 & n >> 16;
        int n6 = -1 + (15 & n >> 21);
        int n7 = 1980 + (127 & n >> 25);
        Calendar calendar = Calendar.getInstance();
        calendar.set(n7, n6, n5, n4, n3, n2);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static String getAbsoluteFilePath(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("filePath is null or empty, cannot get absolute file path");
        }
        return new File(string).getAbsolutePath();
    }

    public static long[] getAllHeaderSignatures() {
        return new long[]{67324752, 134695760, 33639248, 101010256, 84233040, 134630224, 134695760, 117853008, 101075792, 1, 39169};
    }

    public static String getCp850EncodedString(byte[] arrby) {
        try {
            String string = new String(arrby, "Cp850");
            return string;
        }
        catch (UnsupportedEncodingException var2_2) {
            return new String(arrby);
        }
    }

    public static int getEncodedStringLength(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("input string is null, cannot calculate encoded String length");
        }
        return Zip4jUtil.getEncodedStringLength(string, Zip4jUtil.detectCharSet(string));
    }

    /*
     * Exception decompiling
     */
    public static int getEncodedStringLength(String var0_1, String var1) throws ZipException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public static FileHeader getFileHeader(ZipModel zipModel, String string) throws ZipException {
        String string2;
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot determine file header for fileName: " + string);
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("file name is null, cannot determine file header for fileName: " + string);
        }
        FileHeader fileHeader = Zip4jUtil.getFileHeaderWithExactMatch(zipModel, string);
        if (fileHeader == null && (fileHeader = Zip4jUtil.getFileHeaderWithExactMatch(zipModel, string2 = string.replaceAll("\\\\", "/"))) == null) {
            fileHeader = Zip4jUtil.getFileHeaderWithExactMatch(zipModel, string2.replaceAll("/", "\\\\"));
        }
        return fileHeader;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static FileHeader getFileHeaderWithExactMatch(ZipModel zipModel, String string) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot determine file header with exact match for fileName: " + string);
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("file name is null, cannot determine file header with exact match for fileName: " + string);
        }
        if (zipModel.getCentralDirectory() == null) {
            throw new ZipException("central directory is null, cannot determine file header with exact match for fileName: " + string);
        }
        if (zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("file Headers are null, cannot determine file header with exact match for fileName: " + string);
        }
        if (zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return null;
        }
        ArrayList arrayList = zipModel.getCentralDirectory().getFileHeaders();
        int n = 0;
        while (n < arrayList.size()) {
            FileHeader fileHeader = (FileHeader)arrayList.get(n);
            String string2 = fileHeader.getFileName();
            if (Zip4jUtil.isStringNotNullAndNotEmpty(string2) && string.equalsIgnoreCase(string2)) {
                return fileHeader;
            }
            ++n;
        }
        return null;
    }

    public static long getFileLengh(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null, cannot calculate file length");
        }
        if (file.isDirectory()) {
            return -1;
        }
        return file.length();
    }

    public static long getFileLengh(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("invalid file name");
        }
        return Zip4jUtil.getFileLengh(new File(string));
    }

    public static String getFileNameFromFilePath(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null, cannot get file name");
        }
        if (file.isDirectory()) {
            return null;
        }
        return file.getName();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static ArrayList getFilesInDirectoryRec(File file, boolean bl) throws ZipException {
        if (file == null) {
            throw new ZipException("input path is null, cannot read files in the directory");
        }
        ArrayList arrayList = new ArrayList();
        List list = Arrays.asList((Object[])file.listFiles());
        if (!file.canRead()) {
            return arrayList;
        }
        int n = 0;
        while (n < list.size()) {
            File file2 = (File)list.get(n);
            if (file2.isHidden()) {
                if (!bl) return arrayList;
            }
            arrayList.add((Object)file2);
            if (file2.isDirectory()) {
                arrayList.addAll((Collection)Zip4jUtil.getFilesInDirectoryRec(file2, bl));
            }
            ++n;
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int getIndexOfFileHeader(ZipModel zipModel, FileHeader fileHeader) throws ZipException {
        if (zipModel == null || fileHeader == null) {
            throw new ZipException("input parameters is null, cannot determine index of file header");
        }
        if (zipModel.getCentralDirectory() == null) {
            throw new ZipException("central directory is null, ccannot determine index of file header");
        }
        if (zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("file Headers are null, cannot determine index of file header");
        }
        if (zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return -1;
        }
        String string = fileHeader.getFileName();
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("file name in file header is empty or null, cannot determine index of file header");
        }
        ArrayList arrayList = zipModel.getCentralDirectory().getFileHeaders();
        int n = 0;
        while (n < arrayList.size()) {
            String string2 = ((FileHeader)arrayList.get(n)).getFileName();
            if (Zip4jUtil.isStringNotNullAndNotEmpty(string2) && string.equalsIgnoreCase(string2)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    public static long getLastModifiedFileTime(File file, TimeZone timeZone) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null, cannot read last modified file time");
        }
        if (!file.exists()) {
            throw new ZipException("input file does not exist, cannot read last modified file time");
        }
        return file.lastModified();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String getRelativeFileName(String string, String string2, String string3) throws ZipException {
        String string4;
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("input file path/name is empty, cannot calculate relative file name");
        }
        if (Zip4jUtil.isStringNotNullAndNotEmpty(string3)) {
            File file;
            String string5;
            String string6;
            String string7 = new File(string3).getPath();
            if (!string7.endsWith(InternalZipConstants.FILE_SEPARATOR)) {
                string7 = string7 + InternalZipConstants.FILE_SEPARATOR;
            }
            if ((string5 = string.substring(string7.length())).startsWith(System.getProperty((String)"file.separator"))) {
                string5 = string5.substring(1);
            }
            if ((file = new File(string)).isDirectory()) {
                String string8 = string5.replaceAll("\\\\", "/");
                string6 = string8 + "/";
            } else {
                String string9 = string5.substring(0, string5.lastIndexOf(file.getName())).replaceAll("\\\\", "/");
                string6 = string9 + file.getName();
            }
            string4 = string6;
        } else {
            File file = new File(string);
            string4 = file.isDirectory() ? file.getName() + "/" : Zip4jUtil.getFileNameFromFilePath(new File(string));
        }
        if (Zip4jUtil.isStringNotNullAndNotEmpty(string2)) {
            string4 = string2 + string4;
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string4)) {
            throw new ZipException("Error determining file name");
        }
        return string4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ArrayList getSplitZipFiles(ZipModel zipModel) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("cannot get split zip files: zipmodel is null");
        }
        if (zipModel.getEndCentralDirRecord() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String string = zipModel.getZipFile();
        String string2 = new File(string).getName();
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("cannot get split zip files: zipfile is null");
        }
        if (!zipModel.isSplitArchive()) {
            arrayList.add((Object)string);
            return arrayList;
        }
        int n = zipModel.getEndCentralDirRecord().getNoOfThisDisk();
        if (n == 0) {
            arrayList.add((Object)string);
            return arrayList;
        }
        int n2 = 0;
        while (n2 <= n) {
            if (n2 == n) {
                arrayList.add((Object)zipModel.getZipFile());
            } else {
                String string3 = ".z0";
                if (n2 > 9) {
                    string3 = ".z";
                }
                String string4 = string2.indexOf(".") >= 0 ? string.substring(0, string.lastIndexOf(".")) : string;
                arrayList.add((Object)(string4 + string3 + (n2 + 1)));
            }
            ++n2;
        }
        return arrayList;
    }

    public static String getZipFileNameWithoutExt(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("zip file name is empty or null, cannot determine zip file name");
        }
        String string2 = string;
        if (string.indexOf(System.getProperty((String)"file.separator")) >= 0) {
            string2 = string.substring(string.lastIndexOf(System.getProperty((String)"file.separator")));
        }
        if (string2.indexOf(".") > 0) {
            string2 = string2.substring(0, string2.lastIndexOf("."));
        }
        return string2;
    }

    public static boolean isStringNotNullAndNotEmpty(String string) {
        if (string == null || string.trim().length() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isSupportedCharset(String string) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(string)) {
            throw new ZipException("charset is null or empty, cannot check if it is supported");
        }
        try {
            new String("a".getBytes(), string);
            return true;
        }
        catch (UnsupportedEncodingException var3_1) {
            return false;
        }
        catch (Exception var2_2) {
            throw new ZipException((Throwable)var2_2);
        }
    }

    public static boolean isWindows() {
        if (System.getProperty((String)"os.name").toLowerCase().indexOf("win") >= 0) {
            return true;
        }
        return false;
    }

    public static long javaToDosTime(long l) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        int n = calendar.get(1);
        if (n < 1980) {
            return 2162688;
        }
        return n - 1980 << 25 | 1 + calendar.get(2) << 21 | calendar.get(5) << 16 | calendar.get(11) << 11 | calendar.get(12) << 5 | calendar.get(13) >> 1;
    }

    public static void setFileArchive(File file) throws ZipException {
    }

    public static void setFileHidden(File file) throws ZipException {
    }

    public static void setFileReadOnly(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null. cannot set read only file attribute");
        }
        if (file.exists()) {
            file.setReadOnly();
        }
    }

    public static void setFileSystemMode(File file) throws ZipException {
    }
}

