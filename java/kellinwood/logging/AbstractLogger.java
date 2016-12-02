package kellinwood.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractLogger implements LoggerInterface {
    protected String category;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    protected abstract void write(String str, String str2, Throwable th);

    public AbstractLogger(String category) {
        this.category = category;
    }

    protected String format(String level, String message) {
        return String.format("%s %s %s: %s\n", new Object[]{this.dateFormat.format(new Date()), level, this.category, message});
    }

    protected void writeFixNullMessage(String level, String message, Throwable t) {
        if (message == null) {
            if (t != null) {
                message = t.getClass().getName();
            } else {
                message = "null";
            }
        }
        write(level, message, t);
    }

    public void debug(String message, Throwable t) {
        writeFixNullMessage(LoggerInterface.DEBUG, message, t);
    }

    public void debug(String message) {
        writeFixNullMessage(LoggerInterface.DEBUG, message, null);
    }

    public void error(String message, Throwable t) {
        writeFixNullMessage(LoggerInterface.ERROR, message, t);
    }

    public void error(String message) {
        writeFixNullMessage(LoggerInterface.ERROR, message, null);
    }

    public void info(String message, Throwable t) {
        writeFixNullMessage(LoggerInterface.INFO, message, t);
    }

    public void info(String message) {
        writeFixNullMessage(LoggerInterface.INFO, message, null);
    }

    public void warning(String message, Throwable t) {
        writeFixNullMessage(LoggerInterface.WARNING, message, t);
    }

    public void warning(String message) {
        writeFixNullMessage(LoggerInterface.WARNING, message, null);
    }

    public boolean isDebugEnabled() {
        return true;
    }

    public boolean isErrorEnabled() {
        return true;
    }

    public boolean isInfoEnabled() {
        return true;
    }

    public boolean isWarningEnabled() {
        return true;
    }
}
