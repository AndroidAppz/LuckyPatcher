package kellinwood.logging;

import java.util.Map;
import java.util.TreeMap;

public class LoggerManager {
    static LoggerFactory factory = new NullLoggerFactory();
    static Map<String, LoggerInterface> loggers = new TreeMap();

    public static void setLoggerFactory(LoggerFactory f) {
        factory = f;
    }

    public static LoggerInterface getLogger(String category) {
        LoggerInterface logger = (LoggerInterface) loggers.get(category);
        if (logger != null) {
            return logger;
        }
        logger = factory.getLogger(category);
        loggers.put(category, logger);
        return logger;
    }
}
