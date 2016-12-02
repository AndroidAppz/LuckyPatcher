package kellinwood.logging.android;

import kellinwood.logging.LoggerFactory;
import kellinwood.logging.LoggerInterface;

public class AndroidLoggerFactory implements LoggerFactory {
    public LoggerInterface getLogger(String category) {
        return new AndroidLogger(category);
    }
}
