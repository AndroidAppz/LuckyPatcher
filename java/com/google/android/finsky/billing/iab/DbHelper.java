package com.google.android.finsky.billing.iab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.vending.billing.InAppBillingService.LOCK.PkgListItem;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;
import com.chelpus.Utils;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    static final String autobuy = "autobuy";
    public static Context contextdb = null;
    static final String dbName = "BillingRestoreTransactions";
    public static boolean getPackage = false;
    static final String itemID = "itemID";
    static final String pData = "Data";
    static final String pSignature = "Signature";
    static String packageTable = "Packages";
    public static boolean savePackage = false;
    static final String save_purschase = "savePurchase";

    public DbHelper(Context context, String packageTable) {
        super(context, dbName, null, 48);
        contextdb = context;
        packageTable = packageTable;
        try {
            if (listAppsFragment.billing_db == null) {
                listAppsFragment.billing_db = getWritableDatabase();
            } else {
                listAppsFragment.billing_db.close();
                listAppsFragment.billing_db = getWritableDatabase();
            }
            listAppsFragment.billing_db = listAppsFragment.billing_db;
            onCreate(listAppsFragment.billing_db);
        } catch (SQLiteException e) {
            e.printStackTrace();
            if ((e.toString().contains("Could not open the database") || e.toString().contains("readonly")) && listAppsFragment.su) {
                System.out.println("LP: Delete bad database.");
                new Utils("").cmdRoot("rm -r /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases/" + getDatabaseName());
                new Utils("").cmdRoot("rm /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases/" + getDatabaseName());
            }
        }
    }

    public DbHelper(Context context) {
        super(context, dbName, null, 48);
        contextdb = context;
        packageTable = packageTable;
        try {
            if (listAppsFragment.billing_db == null) {
                listAppsFragment.billing_db = getWritableDatabase();
            } else {
                listAppsFragment.billing_db.close();
                listAppsFragment.billing_db = getWritableDatabase();
            }
            onCreate(listAppsFragment.billing_db);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS '" + packageTable + "' (" + itemID + " TEXT PRIMARY KEY, " + pData + " TEXT, " + pSignature + " TEXT, " + save_purschase + " INTEGER, " + autobuy + " INTEGER" + ");");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("SQLite onUpgrade " + oldVersion + " " + newVersion);
        try {
            System.out.println("SQLite base version is " + db.getVersion());
            Cursor c;
            if (newVersion > oldVersion) {
                c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
                if (c.moveToFirst()) {
                    while (!c.isAfterLast()) {
                        System.out.println("SQL add new column for version 48.");
                        try {
                            db.execSQL("ALTER TABLE '" + c.getString(0) + "' ADD COLUMN " + save_purschase + " INTEGER;");
                            db.execSQL("UPDATE '" + c.getString(0) + "' SET " + save_purschase + "= 1;");
                        } catch (SQLiteException e) {
                            e.printStackTrace();
                        }
                        try {
                            db.execSQL("ALTER TABLE '" + c.getString(0) + "' ADD COLUMN " + autobuy + " INTEGER;");
                            db.execSQL("UPDATE '" + c.getString(0) + "' SET " + autobuy + "= 0;");
                        } catch (SQLiteException e2) {
                            e2.printStackTrace();
                        }
                        c.moveToNext();
                    }
                }
                onCreate(db);
            } else {
                c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
                if (c.moveToFirst()) {
                    while (!c.isAfterLast()) {
                        System.out.println("SQL recreate table for version 48.");
                        try {
                            db.execSQL("DROP TABLE IF EXISTS '" + c.getString(0) + "';");
                        } catch (SQLiteException e22) {
                            e22.printStackTrace();
                        }
                        c.moveToNext();
                    }
                }
            }
            onCreate(db);
        } catch (SQLiteException e222) {
            e222.printStackTrace();
            if (e222.toString().contains("Could not open the database") && listAppsFragment.su) {
                System.out.println("LP: Delete bad database.");
                new Utils("").cmdRoot("rm -r /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases/" + getDatabaseName());
                new Utils("").cmdRoot("rm /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases/" + getDatabaseName());
            }
        }
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("SQLite onUpgrade " + oldVersion + " " + newVersion);
        System.out.println("SQLite base version is " + db.getVersion());
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                System.out.println("SQL recreate table for version 48.");
                try {
                    db.execSQL("DROP TABLE IF EXISTS '" + c.getString(0) + "';");
                } catch (SQLiteException e) {
                    try {
                        e.printStackTrace();
                    } catch (SQLiteException e2) {
                        e2.printStackTrace();
                        if (e2.toString().contains("Could not open the database") && listAppsFragment.su) {
                            System.out.println("LP: Delete bad database.");
                            new Utils("").cmdRoot("rm -r /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases/" + getDatabaseName());
                            new Utils("").cmdRoot("rm /data/data/" + listAppsFragment.getInstance().getPackageName() + "/databases/" + getDatabaseName());
                            return;
                        }
                        return;
                    }
                }
                c.moveToNext();
            }
        }
        onCreate(db);
    }

    public ArrayList<ItemsListItem> getItems() {
        ArrayList<ItemsListItem> pat = new ArrayList();
        pat.clear();
        try {
            Cursor c = listAppsFragment.billing_db.query("'" + packageTable + "'", new String[]{itemID, pData, pSignature, save_purschase, autobuy}, null, null, null, null, null);
            c.moveToFirst();
            do {
                try {
                    try {
                        pat.add(new ItemsListItem(c.getString(c.getColumnIndexOrThrow(itemID)), c.getString(c.getColumnIndex(pData)), c.getString(c.getColumnIndex(pSignature)), c.getInt(c.getColumnIndex(save_purschase)), c.getInt(c.getColumnIndex(autobuy))));
                    } catch (IllegalArgumentException e) {
                    }
                } catch (Exception e2) {
                }
                try {
                } catch (Exception e3) {
                    c.close();
                }
            } while (c.moveToNext());
            c.close();
            getPackage = false;
        } catch (Exception e4) {
            getPackage = false;
            System.out.println("LuckyPatcher-Error: getPackage " + e4);
        }
        return pat;
    }

    public void saveItem(ItemsListItem savedObject) throws SQLiteException {
        try {
            savePackage = true;
            ContentValues cv = new ContentValues();
            cv.put(itemID, savedObject.itemID);
            cv.put(pData, savedObject.pData);
            cv.put(pSignature, savedObject.pSignature);
            cv.put(save_purschase, Integer.valueOf(savedObject.savePurchase));
            cv.put(autobuy, Integer.valueOf(savedObject.autobuy));
            try {
                listAppsFragment.billing_db.insertOrThrow("'" + packageTable + "'", itemID, cv);
            } catch (Exception e) {
                listAppsFragment.billing_db.replace("'" + packageTable + "'", null, cv);
            }
            savePackage = false;
            savePackage = false;
        } catch (Exception e2) {
            savePackage = false;
            System.out.println("LuckyPatcher-Error: savePackage " + e2);
        }
    }

    public void deleteItem(ItemsListItem deleteObject) {
        try {
            listAppsFragment.billing_db.delete("'" + packageTable + "'", "itemID = '" + deleteObject.itemID + "'", null);
        } catch (Exception e) {
            System.out.println("LuckyPatcher-Error: deletePackage " + e);
        }
    }

    public void deleteItem(String itemId) {
        try {
            listAppsFragment.billing_db.delete("'" + packageTable + "'", "itemID = '" + itemId + "'", null);
        } catch (Exception e) {
            System.out.println("LuckyPatcher-Error: deletePackage " + e);
        }
    }

    public void deleteAll() {
    }

    public void updatePackage(List<PkgListItem> list) {
    }

    public boolean isOpen() {
        if (listAppsFragment.billing_db.isOpen()) {
            return true;
        }
        return false;
    }
}
