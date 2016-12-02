package com.proxoid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.RemoteException;

public class Proxoid implements ServiceConnection {
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
        context.bindService(new Intent(context, ProxoidService.class), this, 1);
        getSharedPreferences().edit().putBoolean(KEY_ONOFF, true).commit();
    }

    private SharedPreferences getSharedPreferences() {
        return this.mContext.getSharedPreferences(KEY_PREFS, 4);
    }

    public void onServiceConnected(ComponentName cn, IBinder binder) {
        this.proxoidControl = (IProxoidControl) binder;
        if (this.proxoidControl != null) {
            try {
                this.proxoidControl.update();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void onServiceDisconnected(ComponentName cn) {
        this.proxoidControl = null;
    }
}
