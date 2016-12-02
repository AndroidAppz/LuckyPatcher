/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package kellinwood.logging.android;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import kellinwood.logging.AbstractLogger;

public class AndroidLogger
extends AbstractLogger {
    boolean isDebugToastEnabled = false;
    boolean isErrorToastEnabled = true;
    boolean isInfoToastEnabled = false;
    boolean isWarningToastEnabled = true;
    Context toastContext;

    public AndroidLogger(String string) {
        super(string);
        int n = this.category.lastIndexOf(46);
        if (n > 0) {
            this.category = this.category.substring(n + 1);
        }
    }

    public void debugLO(String string, Throwable throwable) {
        boolean bl = this.isDebugToastEnabled;
        this.isDebugToastEnabled = false;
        this.writeFixNullMessage("DEBUG", string, throwable);
        this.isDebugToastEnabled = bl;
    }

    public void errorLO(String string, Throwable throwable) {
        boolean bl = this.isErrorToastEnabled;
        this.isErrorToastEnabled = false;
        this.writeFixNullMessage("ERROR", string, throwable);
        this.isErrorToastEnabled = bl;
    }

    public Context getToastContext() {
        return this.toastContext;
    }

    public void infoLO(String string, Throwable throwable) {
        boolean bl = this.isInfoToastEnabled;
        this.isInfoToastEnabled = false;
        this.writeFixNullMessage("INFO", string, throwable);
        this.isInfoToastEnabled = bl;
    }

    @Override
    public boolean isDebugEnabled() {
        return Log.isLoggable((String)this.category, (int)3);
    }

    public boolean isDebugToastEnabled() {
        return this.isDebugToastEnabled;
    }

    @Override
    public boolean isErrorEnabled() {
        return Log.isLoggable((String)this.category, (int)6);
    }

    public boolean isErrorToastEnabled() {
        return this.isErrorToastEnabled;
    }

    @Override
    public boolean isInfoEnabled() {
        return Log.isLoggable((String)this.category, (int)4);
    }

    public boolean isInfoToastEnabled() {
        return this.isInfoToastEnabled;
    }

    @Override
    public boolean isWarningEnabled() {
        return Log.isLoggable((String)this.category, (int)5);
    }

    public boolean isWarningToastEnabled() {
        return this.isWarningToastEnabled;
    }

    public void setDebugToastEnabled(boolean bl) {
        this.isDebugToastEnabled = bl;
    }

    public void setErrorToastEnabled(boolean bl) {
        this.isErrorToastEnabled = bl;
    }

    public void setInfoToastEnabled(boolean bl) {
        this.isInfoToastEnabled = bl;
    }

    public void setToastContext(Context context) {
        this.toastContext = context;
    }

    public void setWarningToastEnabled(boolean bl) {
        this.isWarningToastEnabled = bl;
    }

    protected void toast(String string) {
        try {
            if (this.toastContext != null) {
                Toast.makeText((Context)this.toastContext, (CharSequence)string, (int)1).show();
            }
            return;
        }
        catch (Throwable var2_2) {
            Log.e((String)this.category, (String)string, (Throwable)var2_2);
            return;
        }
    }

    public void warningLO(String string, Throwable throwable) {
        boolean bl = this.isWarningToastEnabled;
        this.isWarningToastEnabled = false;
        this.writeFixNullMessage("WARNING", string, throwable);
        this.isWarningToastEnabled = bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void write(String string, String string2, Throwable throwable) {
        if ("ERROR".equals((Object)string)) {
            if (throwable != null) {
                Log.e((String)this.category, (String)string2, (Throwable)throwable);
            } else {
                Log.e((String)this.category, (String)string2);
            }
            if (!this.isErrorToastEnabled) return;
            {
                this.toast(string2);
                return;
            }
        } else if ("DEBUG".equals((Object)string)) {
            if (throwable != null) {
                Log.d((String)this.category, (String)string2, (Throwable)throwable);
            } else {
                Log.d((String)this.category, (String)string2);
            }
            if (!this.isDebugToastEnabled) return;
            {
                this.toast(string2);
                return;
            }
        } else if ("WARNING".equals((Object)string)) {
            if (throwable != null) {
                Log.w((String)this.category, (String)string2, (Throwable)throwable);
            } else {
                Log.w((String)this.category, (String)string2);
            }
            if (!this.isWarningToastEnabled) return;
            {
                this.toast(string2);
                return;
            }
        } else {
            if (!"INFO".equals((Object)string)) return;
            {
                if (throwable != null) {
                    Log.i((String)this.category, (String)string2, (Throwable)throwable);
                } else {
                    Log.i((String)this.category, (String)string2);
                }
                if (!this.isInfoToastEnabled) return;
                {
                    this.toast(string2);
                    return;
                }
            }
        }
    }
}

