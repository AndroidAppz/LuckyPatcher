/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.TreeMap
 */
package kellinwood.logging;

import java.util.Map;
import java.util.TreeMap;
import kellinwood.logging.LoggerFactory;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.NullLoggerFactory;

public class LoggerManager {
    static LoggerFactory factory = new NullLoggerFactory();
    static Map<String, LoggerInterface> loggers = new TreeMap();

    public static LoggerInterface getLogger(String string) {
        LoggerInterface loggerInterface = (LoggerInterface)loggers.get((Object)string);
        if (loggerInterface == null) {
            loggerInterface = factory.getLogger(string);
            loggers.put((Object)string, (Object)loggerInterface);
        }
        return loggerInterface;
    }

    public static void setLoggerFactory(LoggerFactory loggerFactory) {
        factory = loggerFactory;
    }
}

