/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteOpenHelper
 *  com.android.vending.billing.InAppBillingService.LOCK.PkgListItem
 *  com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.List
 */
package com.google.android.finsky.billing.iab;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.vending.billing.InAppBillingService.LOCK.PkgListItem;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import com.google.android.finsky.billing.iab.ItemsListItem;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class DbHelper
extends SQLiteOpenHelper {
    static final String autobuy = "autobuy";
    public static Context contextdb;
    static final String dbName = "BillingRestoreTransactions";
    public static boolean getPackage = false;
    static final String itemID = "itemID";
    static final String pData = "Data";
    static final String pSignature = "Signature";
    static String packageTable;
    public static boolean savePackage = false;
    static final String save_purschase = "savePurchase";

    static {
        packageTable = "Packages";
        contextdb = null;
        getPackage = false;
        savePackage = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DbHelper(Context context) {
        super(context, "BillingRestoreTransactions", null, 48);
        contextdb = context;
        try {
            if (listAppsFragment.billing_db == null) {
                listAppsFragment.billing_db = this.getWritableDatabase();
            } else {
                listAppsFragment.billing_db.close();
                listAppsFragment.billing_db = this.getWritableDatabase();
            }
            this.onCreate(listAppsFragment.billing_db);
            return;
        }
        catch (SQLiteException var2_2) {
            var2_2.printStackTrace();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DbHelper(Context context, String string) {
        super(context, "BillingRestoreTransactions", null, 48);
        contextdb = context;
        packageTable = string;
        try {
            if (listAppsFragment.billing_db == null) {
                listAppsFragment.billing_db = this.getWritableDatabase();
            } else {
                listAppsFragment.billing_db.close();
                listAppsFragment.billing_db = this.getWritableDatabase();
            }
            this.onCreate(listAppsFragment.billing_db);
            return;
        }
        catch (SQLiteException var3_3) {
            var3_3.printStackTrace();
            if ((var3_3.toString().contains((CharSequence)"Could not open the database") || var3_3.toString().contains((CharSequence)"readonly")) && listAppsFragment.su) {
                System.out.println("LP: Delete bad database.");
                Utils utils = new Utils("");
                String[] arrstring = new String[]{"rm -r /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases/" + this.getDatabaseName()};
                utils.cmdRoot(arrstring);
                Utils utils2 = new Utils("");
                String[] arrstring2 = new String[]{"rm /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases/" + this.getDatabaseName()};
                utils2.cmdRoot(arrstring2);
            }
            return;
        }
    }

    public void deleteAll() {
    }

    public void deleteItem(ItemsListItem itemsListItem) {
        try {
            listAppsFragment.billing_db.delete("'" + packageTable + "'", "itemID = '" + itemsListItem.itemID + "'", null);
            return;
        }
        catch (Exception var2_2) {
            System.out.println("LuckyPatcher-Error: deletePackage " + (Object)var2_2);
            return;
        }
    }

    public void deleteItem(String string) {
        try {
            listAppsFragment.billing_db.delete("'" + packageTable + "'", "itemID = '" + string + "'", null);
            return;
        }
        catch (Exception var2_2) {
            System.out.println("LuckyPatcher-Error: deletePackage " + (Object)var2_2);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public ArrayList<ItemsListItem> getItems() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [9[DOLOOP]], but top level block is 3[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
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

    public boolean isOpen() {
        if (listAppsFragment.billing_db.isOpen()) {
            return true;
        }
        return false;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS '" + packageTable + "' (" + "itemID" + " TEXT PRIMARY KEY, " + "Data" + " TEXT, " + "Signature" + " TEXT, " + "savePurchase" + " INTEGER, " + "autobuy" + " INTEGER" + ");");
    }

    /*
     * Exception decompiling
     */
    public void onDowngrade(SQLiteDatabase var1, int var2_3, int var3_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 6[WHILELOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
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

    /*
     * Exception decompiling
     */
    public void onUpgrade(SQLiteDatabase var1, int var2_3, int var3_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
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

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void saveItem(ItemsListItem var1_1) throws SQLiteException {
        try {
            DbHelper.savePackage = true;
            var3_2 = new ContentValues();
            var3_2.put("itemID", var1_1.itemID);
            var3_2.put("Data", var1_1.pData);
            var3_2.put("Signature", var1_1.pSignature);
            var3_2.put("savePurchase", Integer.valueOf((int)var1_1.savePurchase));
            var3_2.put("autobuy", Integer.valueOf((int)var1_1.autobuy));
        }
lbl9: // 2 sources:
        catch (Exception var2_4) {
            DbHelper.savePackage = false;
            System.out.println("LuckyPatcher-Error: savePackage " + (Object)var2_4);
            return;
        }
        listAppsFragment.billing_db.insertOrThrow("'" + DbHelper.packageTable + "'", "itemID", var3_2);
        ** try [egrp 2[TRYBLOCK] [2 : 104->153)] { 
lbl16: // 1 sources:
        ** GOTO lbl19
        {
            catch (Exception var4_3) {
                listAppsFragment.billing_db.replace("'" + DbHelper.packageTable + "'", null, var3_2);
            }
lbl19: // 2 sources:
            DbHelper.savePackage = false;
            DbHelper.savePackage = false;
            return;
        }
    }

    public void updatePackage(List<PkgListItem> list) {
    }
}

