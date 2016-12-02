/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.text.SimpleDateFormat
 *  java.util.Date
 */
package kellinwood.logging;

import java.text.SimpleDateFormat;
import java.util.Date;
import kellinwood.logging.LoggerInterface;

public abstract class AbstractLogger
implements LoggerInterface {
    protected String category;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public AbstractLogger(String string) {
        this.category = string;
    }

    @Override
    public void debug(String string) {
        this.writeFixNullMessage("DEBUG", string, null);
    }

    @Override
    public void debug(String string, Throwable throwable) {
        this.writeFixNullMessage("DEBUG", string, throwable);
    }

    @Override
    public void error(String string) {
        this.writeFixNullMessage("ERROR", string, null);
    }

    @Override
    public void error(String string, Throwable throwable) {
        this.writeFixNullMessage("ERROR", string, throwable);
    }

    protected String format(String string, String string2) {
        Object[] arrobject = new Object[]{this.dateFormat.format(new Date()), string, this.category, string2};
        return String.format((String)"%s %s %s: %s\n", (Object[])arrobject);
    }

    @Override
    public void info(String string) {
        this.writeFixNullMessage("INFO", string, null);
    }

    @Override
    public void info(String string, Throwable throwable) {
        this.writeFixNullMessage("INFO", string, throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public boolean isWarningEnabled() {
        return true;
    }

    @Override
    public void warning(String string) {
        this.writeFixNullMessage("WARNING", string, null);
    }

    @Override
    public void warning(String string, Throwable throwable) {
        this.writeFixNullMessage("WARNING", string, throwable);
    }

    protected abstract void write(String var1, String var2, Throwable var3);

    /*
     * Enabled aggressive block sorting
     */
    protected void writeFixNullMessage(String string, String string2, Throwable throwable) {
        if (string2 == null) {
            string2 = throwable != null ? throwable.getClass().getName() : "null";
        }
        this.write(string, string2, throwable);
    }
}

