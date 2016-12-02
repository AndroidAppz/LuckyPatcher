/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.apache.log4j.Logger
 */
package kellinwood.logging.log4j;

import kellinwood.logging.LoggerInterface;
import org.apache.log4j.Logger;

public class Log4jLogger
implements LoggerInterface {
    Logger log;

    public Log4jLogger(String string) {
        this.log = Logger.getLogger((String)string);
    }

    @Override
    public void debug(String string) {
        this.log.debug((Object)string);
    }

    @Override
    public void debug(String string, Throwable throwable) {
        this.log.debug((Object)string, throwable);
    }

    @Override
    public void error(String string) {
        this.log.error((Object)string);
    }

    @Override
    public void error(String string, Throwable throwable) {
        this.log.error((Object)string, throwable);
    }

    @Override
    public void info(String string) {
        this.log.info((Object)string);
    }

    @Override
    public void info(String string, Throwable throwable) {
        this.log.info((Object)string, throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return this.log.isDebugEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public boolean isInfoEnabled() {
        return this.log.isInfoEnabled();
    }

    @Override
    public boolean isWarningEnabled() {
        return true;
    }

    @Override
    public void warning(String string) {
        this.log.warn((Object)string);
    }

    @Override
    public void warning(String string, Throwable throwable) {
        this.log.warn((Object)string, throwable);
    }
}

