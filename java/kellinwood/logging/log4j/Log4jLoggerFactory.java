package kellinwood.logging.log4j;

import kellinwood.logging.LoggerFactory;
import kellinwood.logging.LoggerInterface;

public class Log4jLoggerFactory implements LoggerFactory {
    public LoggerInterface getLogger(String category) {
        return new Log4jLogger(category);
    }
}
