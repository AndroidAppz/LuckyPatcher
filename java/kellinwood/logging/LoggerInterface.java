package kellinwood.logging;

public interface LoggerInterface {
    public static final String DEBUG = "DEBUG";
    public static final String ERROR = "ERROR";
    public static final String INFO = "INFO";
    public static final String WARNING = "WARNING";

    void debug(String str);

    void debug(String str, Throwable th);

    void error(String str);

    void error(String str, Throwable th);

    void info(String str);

    void info(String str, Throwable th);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isWarningEnabled();

    void warning(String str);

    void warning(String str, Throwable th);
}
