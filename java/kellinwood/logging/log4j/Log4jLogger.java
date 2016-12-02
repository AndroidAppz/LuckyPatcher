package kellinwood.logging.log4j;

import kellinwood.logging.LoggerInterface;
import org.apache.log4j.Logger;

public class Log4jLogger implements LoggerInterface {
    Logger log;

    public Log4jLogger(String category) {
        this.log = Logger.getLogger(category);
    }

    public void debug(String message, Throwable t) {
        this.log.debug(message, t);
    }

    public void debug(String message) {
        this.log.debug(message);
    }

    public void error(String message, Throwable t) {
        this.log.error(message, t);
    }

    public void error(String message) {
        this.log.error(message);
    }

    public void info(String message, Throwable t) {
        this.log.info(message, t);
    }

    public void info(String message) {
        this.log.info(message);
    }

    public boolean isDebugEnabled() {
        return this.log.isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return true;
    }

    public boolean isInfoEnabled() {
        return this.log.isInfoEnabled();
    }

    public boolean isWarningEnabled() {
        return true;
    }

    public void warning(String message, Throwable t) {
        this.log.warn(message, t);
    }

    public void warning(String message) {
        this.log.warn(message);
    }
}
