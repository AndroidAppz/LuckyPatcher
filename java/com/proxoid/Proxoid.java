/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.IBinder
 *  android.os.RemoteException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.proxoid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.RemoteException;
import com.proxoid.IProxoidControl;
import com.proxoid.ProxoidService;

public class Proxoid
implements ServiceConnection {
    protected static final String KEY_ONOFF = "onoff";
    protected static final String KEY_PORT = "port";
    protected static final String KEY_PREFS = "proxoidv6";
    protected static final String KEY_USERAGENT = "useragent";
    private static final String TAG = "proxoid";
    protected static final String USERAGENT_ASIS = "asis";
    protected static final String USERAGENT_RANDOM = "random";
    protected static final String USERAGENT_REMOVE = "remove";
    protected static final String USERAGENT_REPLACE = "replace";
    public Context mContext = null;
    private IProxoidControl proxoidControl = null;

    public Proxoid(Context context) {
        this.mContext = context;
        context.bindService(new Intent(context, (Class)ProxoidService.class), (ServiceConnection)this, 1);
        super.getSharedPreferences().edit().putBoolean("onoff", true).commit();
    }

    private SharedPreferences getSharedPreferences() {
        return this.mContext.getSharedPreferences("proxoidv6", 4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.proxoidControl = (IProxoidControl)iBinder;
        if (this.proxoidControl == null) return;
        try {
            this.proxoidControl.update();
            return;
        }
        catch (RemoteException var3_3) {
            var3_3.printStackTrace();
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.proxoidControl = null;
    }
}

