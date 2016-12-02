/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.util.Log
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.List
 */
package com.proxoid;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;
import com.mba.proxylight.ProxyLight;
import com.mba.proxylight.Request;
import com.mba.proxylight.RequestFilter;
import com.proxoid.IProxoidControl;
import com.proxoid.Proxoid;
import java.util.List;

public class ProxoidService
extends Service {
    private static int ID = 0;
    private static final String TAG = "ProxoidService";
    private ProxyLight proxy = null;
    private String randomUserAgent = Long.toString((long)System.currentTimeMillis(), (int)20);
    private String useragent = null;

    static {
        ID = 2130837544;
    }

    private void doStop() {
        if (this.proxy != null && this.proxy.isRunning()) {
            Log.d((String)"ProxoidService", (String)"stopping");
            this.proxy.stop();
            ((NotificationManager)this.getSystemService("notification")).cancel(ID);
            Toast.makeText((Context)this, (CharSequence)"Proxy stopped.", (int)0).show();
            SharedPreferences.Editor editor = this.getSharedPreferences().edit();
            editor.putBoolean("onoff", false);
            editor.commit();
        }
    }

    private SharedPreferences getSharedPreferences() {
        return super.getSharedPreferences("proxoidv6", 4);
    }

    public IBinder onBind(Intent intent) {
        return new IProxoidControl.Stub(){

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public boolean update() throws RemoteException {
                boolean bl = ProxoidService.this.getSharedPreferences().getBoolean("onoff", false);
                int n = Integer.parseInt((String)"8080");
                ProxoidService.this.useragent = "Don\\'t change";
                if (!bl) {
                    ProxoidService.this.doStop();
                    return true;
                }
                if (ProxoidService.this.proxy == null) {
                    ProxoidService.this.proxy = new ProxyLight(){

                        @Override
                        public void debug(String string) {
                            if (Log.isLoggable((String)"ProxoidService", (int)3)) {
                                Log.d((String)"ProxoidService", (String)string);
                            }
                            Log.e((String)"ProxoidService", (String)string);
                        }

                        @Override
                        public void error(String string, Throwable throwable) {
                            Log.e((String)"ProxoidService", (String)string, (Throwable)throwable);
                        }
                    };
                    ProxoidService.this.proxy.getRequestFilters().add((Object)new UserAgentRequestFilter(ProxoidService.this, null));
                    ProxoidService.this.proxy.setPort(n);
                }
                if (ProxoidService.this.proxy.getPort() != n) {
                    ProxoidService.this.proxy.setPort(n);
                    ProxoidService.this.proxy.stop();
                    ProxoidService.this.proxy.start();
                    Toast.makeText((Context)ProxoidService.this, (CharSequence)"Service proxy restarted", (int)0).show();
                }
                if (ProxoidService.this.proxy.isRunning()) return true;
                try {
                    ProxoidService.this.proxy.start();
                }
                catch (Exception var4_8) {
                    Log.e((String)"ProxoidService", (String)"", (Throwable)var4_8);
                    ProxoidService.this.proxy.stop();
                    ProxoidService.this.proxy = null;
                    return false;
                }
                NotificationManager notificationManager = (NotificationManager)ProxoidService.this.getSystemService("notification");
                Notification notification = new Notification(2130837545, (CharSequence)"Lucky Patcher proxy running.", System.currentTimeMillis());
                Context context = ProxoidService.this.getApplicationContext();
                Intent intent = new Intent((Context)ProxoidService.this, (Class)Proxoid.class);
                notification.setLatestEventInfo(context, (CharSequence)"Lucky Proxoid", (CharSequence)"proxy running", PendingIntent.getActivity((Context)ProxoidService.this, (int)0, (Intent)intent, (int)0));
                notification.flags = 2 | notification.flags;
                notificationManager.notify(ID, notification);
                Toast.makeText((Context)ProxoidService.this, (CharSequence)"Proxy running.", (int)0).show();
                return true;
                catch (Exception exception) {
                    Log.e((String)"ProxoidService", (String)"", (Throwable)exception);
                    ProxoidService.this.proxy.stop();
                    ProxoidService.this.proxy = null;
                    return false;
                }
            }

        };
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        this.doStop();
        super.onDestroy();
    }

    private class UserAgentRequestFilter
    implements RequestFilter {
        final /* synthetic */ ProxoidService this$0;

        private UserAgentRequestFilter(ProxoidService proxoidService) {
            this.this$0 = proxoidService;
        }

        /* synthetic */ UserAgentRequestFilter(ProxoidService proxoidService,  var2_2) {
            super(proxoidService);
        }

        @Override
        public boolean filter(Request request) {
            return false;
        }
    }

}

