package kellinwood.logging.android;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import kellinwood.logging.AbstractLogger;
import kellinwood.logging.LoggerInterface;

public class AndroidLogger extends AbstractLogger {
    boolean isDebugToastEnabled = false;
    boolean isErrorToastEnabled = true;
    boolean isInfoToastEnabled = false;
    boolean isWarningToastEnabled = true;
    Context toastContext;

    public AndroidLogger(String c) {
        super(c);
        int pos = this.category.lastIndexOf(46);
        if (pos > 0) {
            this.category = this.category.substring(pos + 1);
        }
    }

    public Context getToastContext() {
        return this.toastContext;
    }

    public void setToastContext(Context toastContext) {
        this.toastContext = toastContext;
    }

    public boolean isErrorToastEnabled() {
        return this.isErrorToastEnabled;
    }

    public void setErrorToastEnabled(boolean isErrorToastEnabled) {
        this.isErrorToastEnabled = isErrorToastEnabled;
    }

    public boolean isWarningToastEnabled() {
        return this.isWarningToastEnabled;
    }

    public void setWarningToastEnabled(boolean isWarningToastEnabled) {
        this.isWarningToastEnabled = isWarningToastEnabled;
    }

    public boolean isInfoToastEnabled() {
        return this.isInfoToastEnabled;
    }

    public void setInfoToastEnabled(boolean isInfoToastEnabled) {
        this.isInfoToastEnabled = isInfoToastEnabled;
    }

    public boolean isDebugToastEnabled() {
        return this.isDebugToastEnabled;
    }

    public void setDebugToastEnabled(boolean isDebugToastEnabled) {
        this.isDebugToastEnabled = isDebugToastEnabled;
    }

    public void errorLO(String message, Throwable t) {
        boolean toastState = this.isErrorToastEnabled;
        this.isErrorToastEnabled = false;
        writeFixNullMessage(LoggerInterface.ERROR, message, t);
        this.isErrorToastEnabled = toastState;
    }

    public void warningLO(String message, Throwable t) {
        boolean toastState = this.isWarningToastEnabled;
        this.isWarningToastEnabled = false;
        writeFixNullMessage(LoggerInterface.WARNING, message, t);
        this.isWarningToastEnabled = toastState;
    }

    public void infoLO(String message, Throwable t) {
        boolean toastState = this.isInfoToastEnabled;
        this.isInfoToastEnabled = false;
        writeFixNullMessage(LoggerInterface.INFO, message, t);
        this.isInfoToastEnabled = toastState;
    }

    public void debugLO(String message, Throwable t) {
        boolean toastState = this.isDebugToastEnabled;
        this.isDebugToastEnabled = false;
        writeFixNullMessage(LoggerInterface.DEBUG, message, t);
        this.isDebugToastEnabled = toastState;
    }

    protected void toast(String message) {
        try {
            if (this.toastContext != null) {
                Toast.makeText(this.toastContext, message, 1).show();
            }
        } catch (Throwable t) {
            Log.e(this.category, message, t);
        }
    }

    public void write(String level, String message, Throwable t) {
        if (LoggerInterface.ERROR.equals(level)) {
            if (t != null) {
                Log.e(this.category, message, t);
            } else {
                Log.e(this.category, message);
            }
            if (this.isErrorToastEnabled) {
                toast(message);
            }
        } else if (LoggerInterface.DEBUG.equals(level)) {
            if (t != null) {
                Log.d(this.category, message, t);
            } else {
                Log.d(this.category, message);
            }
            if (this.isDebugToastEnabled) {
                toast(message);
            }
        } else if (LoggerInterface.WARNING.equals(level)) {
            if (t != null) {
                Log.w(this.category, message, t);
            } else {
                Log.w(this.category, message);
            }
            if (this.isWarningToastEnabled) {
                toast(message);
            }
        } else if (LoggerInterface.INFO.equals(level)) {
            if (t != null) {
                Log.i(this.category, message, t);
            } else {
                Log.i(this.category, message);
            }
            if (this.isInfoToastEnabled) {
                toast(message);
            }
        }
    }

    public boolean isDebugEnabled() {
        return Log.isLoggable(this.category, 3);
    }

    public boolean isErrorEnabled() {
        return Log.isLoggable(this.category, 6);
    }

    public boolean isInfoEnabled() {
        return Log.isLoggable(this.category, 4);
    }

    public boolean isWarningEnabled() {
        return Log.isLoggable(this.category, 5);
    }
}
