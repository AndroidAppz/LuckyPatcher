package kellinwood.logging;

public class NullLoggerFactory implements LoggerFactory {
    static LoggerInterface logger = new LoggerInterface() {
        public void debug(String message) {
        }

        public void debug(String message, Throwable t) {
        }

        public void error(String message) {
        }

        public void error(String message, Throwable t) {
        }

        public void info(String message) {
        }

        public void info(String message, Throwable t) {
        }

        public boolean isDebugEnabled() {
            return false;
        }

        public boolean isErrorEnabled() {
            return false;
        }

        public boolean isInfoEnabled() {
            return false;
        }

        public boolean isWarningEnabled() {
            return false;
        }

        public void warning(String message) {
        }

        public void warning(String message, Throwable t) {
        }
    };

    public LoggerInterface getLogger(String category) {
        return logger;
    }
}
