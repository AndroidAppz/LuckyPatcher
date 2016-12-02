package com.proxoid;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;
import com.mba.proxylight.ProxyLight;
import com.mba.proxylight.Request;
import com.mba.proxylight.RequestFilter;
import com.proxoid.IProxoidControl.Stub;

public class ProxoidService extends Service {
    private static int ID = 2130837544;
    private static final String TAG = "ProxoidService";
    private ProxyLight proxy = null;
    private String randomUserAgent = Long.toString(System.currentTimeMillis(), 20);
    private String useragent = null;

    private class UserAgentRequestFilter implements RequestFilter {
        private UserAgentRequestFilter() {
        }

        public boolean filter(Request request) {
            return false;
        }
    }

    private SharedPreferences getSharedPreferences() {
        return super.getSharedPreferences("proxoidv6", 4);
    }

    public IBinder onBind(Intent binder) {
        return new Stub() {
            public boolean update() throws RemoteException {
                boolean start = ProxoidService.this.getSharedPreferences().getBoolean("onoff", false);
                int port = Integer.parseInt("8080");
                ProxoidService.this.useragent = "Don\\'t change";
                if (start) {
                    if (ProxoidService.this.proxy == null) {
                        ProxoidService.this.proxy = new ProxyLight() {
                            public void debug(String message) {
                                if (Log.isLoggable(ProxoidService.TAG, 3)) {
                                    Log.d(ProxoidService.TAG, message);
                                }
                                Log.e(ProxoidService.TAG, message);
                            }

                            public void error(String message, Throwable t) {
                                Log.e(ProxoidService.TAG, message, t);
                            }
                        };
                        ProxoidService.this.proxy.getRequestFilters().add(new UserAgentRequestFilter());
                        ProxoidService.this.proxy.setPort(port);
                    }
                    if (ProxoidService.this.proxy.getPort() != port) {
                        ProxoidService.this.proxy.setPort(port);
                        ProxoidService.this.proxy.stop();
                        try {
                            ProxoidService.this.proxy.start();
                            Toast.makeText(ProxoidService.this, "Service proxy restarted", 0).show();
                        } catch (Exception e) {
                            Log.e(ProxoidService.TAG, "", e);
                            ProxoidService.this.proxy.stop();
                            ProxoidService.this.proxy = null;
                            return false;
                        }
                    }
                    if (!ProxoidService.this.proxy.isRunning()) {
                        try {
                            ProxoidService.this.proxy.start();
                            NotificationManager mNotificationManager = (NotificationManager) ProxoidService.this.getSystemService("notification");
                            Notification notification = new Notification(2130837545, "Lucky Patcher proxy running.", System.currentTimeMillis());
                            notification.setLatestEventInfo(ProxoidService.this.getApplicationContext(), "Lucky Proxoid", "proxy running", PendingIntent.getActivity(ProxoidService.this, 0, new Intent(ProxoidService.this, Proxoid.class), 0));
                            notification.flags |= 2;
                            mNotificationManager.notify(ProxoidService.ID, notification);
                            Toast.makeText(ProxoidService.this, "Proxy running.", 0).show();
                        } catch (Exception e2) {
                            Log.e(ProxoidService.TAG, "", e2);
                            ProxoidService.this.proxy.stop();
                            ProxoidService.this.proxy = null;
                            return false;
                        }
                    }
                }
                ProxoidService.this.doStop();
                return true;
            }
        };
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        doStop();
        super.onDestroy();
    }

    private void doStop() {
        if (this.proxy != null && this.proxy.isRunning()) {
            Log.d(TAG, "stopping");
            this.proxy.stop();
            ((NotificationManager) getSystemService("notification")).cancel(ID);
            Toast.makeText(this, "Proxy stopped.", 0).show();
            Editor e = getSharedPreferences().edit();
            e.putBoolean("onoff", false);
            e.commit();
        }
    }
}
