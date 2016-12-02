/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package kellinwood.logging;

public interface LoggerInterface {
    public static final String DEBUG = "DEBUG";
    public static final String ERROR = "ERROR";
    public static final String INFO = "INFO";
    public static final String WARNING = "WARNING";

    public void debug(String var1);

    public void debug(String var1, Throwable var2);

    public void error(String var1);

    public void error(String var1, Throwable var2);

    public void info(String var1);

    public void info(String var1, Throwable var2);

    public boolean isDebugEnabled();

    public boolean isErrorEnabled();

    public boolean isInfoEnabled();

    public boolean isWarningEnabled();

    public void warning(String var1);

    public void warning(String var1, Throwable var2);
}

