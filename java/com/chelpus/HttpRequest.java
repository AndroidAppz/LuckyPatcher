package com.chelpus;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.AccessController;
import java.security.GeneralSecurityException;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import pxb.android.axml.ValueWrapper;
import pxb.android.axmlLP.AxmlVisitor;

public class HttpRequest {
    private static final String BOUNDARY = "00content0boundary00";
    public static final String CHARSET_UTF8 = "UTF-8";
    private static ConnectionFactory CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_MULTIPART = "multipart/form-data; boundary=00content0boundary00";
    private static final String CRLF = "\r\n";
    private static final String[] EMPTY_STRINGS = new String[0];
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_DATE = "Date";
    public static final String HEADER_ETAG = "ETag";
    public static final String HEADER_EXPIRES = "Expires";
    public static final String HEADER_IF_NONE_MATCH = "If-None-Match";
    public static final String HEADER_LAST_MODIFIED = "Last-Modified";
    public static final String HEADER_LOCATION = "Location";
    public static final String HEADER_PROXY_AUTHORIZATION = "Proxy-Authorization";
    public static final String HEADER_REFERER = "Referer";
    public static final String HEADER_SERVER = "Server";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_TRACE = "TRACE";
    public static final String PARAM_CHARSET = "charset";
    private static SSLSocketFactory TRUSTED_FACTORY;
    private static HostnameVerifier TRUSTED_VERIFIER;
    private int bufferSize = 8192;
    private HttpURLConnection connection = null;
    private boolean form;
    private String httpProxyHost;
    private int httpProxyPort;
    private boolean ignoreCloseExceptions = true;
    private boolean multipart;
    private RequestOutputStream output;
    private UploadProgress progress = UploadProgress.DEFAULT;
    private final String requestMethod;
    private long totalSize = -1;
    private long totalWritten = 0;
    private boolean uncompress = false;
    private final URL url;

    protected static abstract class Operation<V> implements Callable<V> {
        protected abstract void done() throws IOException;

        protected abstract V run() throws HttpRequestException, IOException;

        protected Operation() {
        }

        public V call() throws HttpRequestException {
            boolean thrown;
            try {
                V run = run();
                try {
                    done();
                } catch (IOException e) {
                    if (!false) {
                        throw new HttpRequestException(e);
                    }
                }
                return run;
            } catch (HttpRequestException e2) {
                thrown = true;
                throw e2;
            } catch (IOException e3) {
                thrown = true;
                throw new HttpRequestException(e3);
            } catch (Throwable th) {
                try {
                    done();
                } catch (IOException e32) {
                    if (!thrown) {
                        throw new HttpRequestException(e32);
                    }
                }
            }
        }
    }

    protected static abstract class FlushOperation<V> extends Operation<V> {
        private final Flushable flushable;

        protected FlushOperation(Flushable flushable) {
            this.flushable = flushable;
        }

        protected void done() throws IOException {
            this.flushable.flush();
        }
    }

    protected static abstract class CloseOperation<V> extends Operation<V> {
        private final Closeable closeable;
        private final boolean ignoreCloseExceptions;

        protected CloseOperation(Closeable closeable, boolean ignoreCloseExceptions) {
            this.closeable = closeable;
            this.ignoreCloseExceptions = ignoreCloseExceptions;
        }

        protected void done() throws IOException {
            if (this.closeable instanceof Flushable) {
                ((Flushable) this.closeable).flush();
            }
            if (this.ignoreCloseExceptions) {
                try {
                    this.closeable.close();
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            this.closeable.close();
        }
    }

    public static class Base64 {
        private static final byte EQUALS_SIGN = (byte) 61;
        private static final String PREFERRED_ENCODING = "US-ASCII";
        private static final byte[] _STANDARD_ALPHABET = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};

        private Base64() {
        }

        private static byte[] encode3to4(byte[] source, int srcOffset, int numSigBytes, byte[] destination, int destOffset) {
            int i;
            int i2 = 0;
            byte[] ALPHABET = _STANDARD_ALPHABET;
            if (numSigBytes > 0) {
                i = (source[srcOffset] << 24) >>> 8;
            } else {
                i = 0;
            }
            int i3 = (numSigBytes > 1 ? (source[srcOffset + 1] << 24) >>> 16 : 0) | i;
            if (numSigBytes > 2) {
                i2 = (source[srcOffset + 2] << 24) >>> 24;
            }
            int inBuff = i3 | i2;
            switch (numSigBytes) {
                case AxmlVisitor.TYPE_REFERENCE /*1*/:
                    destination[destOffset] = ALPHABET[inBuff >>> 18];
                    destination[destOffset + 1] = ALPHABET[(inBuff >>> 12) & 63];
                    destination[destOffset + 2] = EQUALS_SIGN;
                    destination[destOffset + 3] = EQUALS_SIGN;
                    break;
                case ValueWrapper.STYLE /*2*/:
                    destination[destOffset] = ALPHABET[inBuff >>> 18];
                    destination[destOffset + 1] = ALPHABET[(inBuff >>> 12) & 63];
                    destination[destOffset + 2] = ALPHABET[(inBuff >>> 6) & 63];
                    destination[destOffset + 3] = EQUALS_SIGN;
                    break;
                case AxmlVisitor.TYPE_STRING /*3*/:
                    destination[destOffset] = ALPHABET[inBuff >>> 18];
                    destination[destOffset + 1] = ALPHABET[(inBuff >>> 12) & 63];
                    destination[destOffset + 2] = ALPHABET[(inBuff >>> 6) & 63];
                    destination[destOffset + 3] = ALPHABET[inBuff & 63];
                    break;
            }
            return destination;
        }

        public static String encode(String string) {
            byte[] bytes;
            try {
                bytes = string.getBytes(PREFERRED_ENCODING);
            } catch (UnsupportedEncodingException e) {
                bytes = string.getBytes();
            }
            return encodeBytes(bytes);
        }

        public static String encodeBytes(byte[] source) {
            return encodeBytes(source, 0, source.length);
        }

        public static String encodeBytes(byte[] source, int off, int len) {
            byte[] encoded = encodeBytesToBytes(source, off, len);
            try {
                return new String(encoded, PREFERRED_ENCODING);
            } catch (UnsupportedEncodingException e) {
                return new String(encoded);
            }
        }

        public static byte[] encodeBytesToBytes(byte[] source, int off, int len) {
            if (source == null) {
                throw new NullPointerException("Cannot serialize a null array.");
            } else if (off < 0) {
                throw new IllegalArgumentException("Cannot have negative offset: " + off);
            } else if (len < 0) {
                throw new IllegalArgumentException("Cannot have length offset: " + len);
            } else if (off + len > source.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{Integer.valueOf(off), Integer.valueOf(len), Integer.valueOf(source.length)}));
            } else {
                int i;
                int i2 = (len / 3) * 4;
                if (len % 3 > 0) {
                    i = 4;
                } else {
                    i = 0;
                }
                byte[] outBuff = new byte[(i2 + i)];
                int d = 0;
                int e = 0;
                int len2 = len - 2;
                while (d < len2) {
                    encode3to4(source, d + off, 3, outBuff, e);
                    d += 3;
                    e += 4;
                }
                if (d < len) {
                    encode3to4(source, d + off, len - d, outBuff, e);
                    e += 4;
                }
                if (e > outBuff.length - 1) {
                    return outBuff;
                }
                byte[] finalOut = new byte[e];
                System.arraycopy(outBuff, 0, finalOut, 0, e);
                return finalOut;
            }
        }
    }

    public interface ConnectionFactory {
        public static final ConnectionFactory DEFAULT = new ConnectionFactory() {
            public HttpURLConnection create(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }

            public HttpURLConnection create(URL url, Proxy proxy) throws IOException {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        };

        HttpURLConnection create(URL url) throws IOException;

        HttpURLConnection create(URL url, Proxy proxy) throws IOException;
    }

    public static class HttpRequestException extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        public HttpRequestException(IOException cause) {
            super(cause);
        }

        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    public static class RequestOutputStream extends BufferedOutputStream {
        private final CharsetEncoder encoder;

        public RequestOutputStream(OutputStream stream, String charset, int bufferSize) {
            super(stream, bufferSize);
            this.encoder = Charset.forName(HttpRequest.getValidCharset(charset)).newEncoder();
        }

        public RequestOutputStream write(String value) throws IOException {
            ByteBuffer bytes = this.encoder.encode(CharBuffer.wrap(value));
            super.write(bytes.array(), 0, bytes.limit());
            return this;
        }
    }

    public interface UploadProgress {
        public static final UploadProgress DEFAULT = new UploadProgress() {
            public void onUpload(long uploaded, long total) {
            }
        };

        void onUpload(long j, long j2);
    }

    private static String getValidCharset(String charset) {
        return (charset == null || charset.length() <= 0) ? CHARSET_UTF8 : charset;
    }

    private static SSLSocketFactory getTrustedFactory() throws HttpRequestException {
        if (TRUSTED_FACTORY == null) {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }
            }};
            try {
                SSLContext context = SSLContext.getInstance("TLS");
                context.init(null, trustAllCerts, new SecureRandom());
                TRUSTED_FACTORY = context.getSocketFactory();
            } catch (GeneralSecurityException e) {
                IOException ioException = new IOException("Security exception configuring SSL context");
                ioException.initCause(e);
                throw new HttpRequestException(ioException);
            }
        }
        return TRUSTED_FACTORY;
    }

    private static HostnameVerifier getTrustedVerifier() {
        if (TRUSTED_VERIFIER == null) {
            TRUSTED_VERIFIER = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
        }
        return TRUSTED_VERIFIER;
    }

    private static StringBuilder addPathSeparator(String baseUrl, StringBuilder result) {
        if (baseUrl.indexOf(58) + 2 == baseUrl.lastIndexOf(47)) {
            result.append('/');
        }
        return result;
    }

    private static StringBuilder addParamPrefix(String baseUrl, StringBuilder result) {
        int queryStart = baseUrl.indexOf(63);
        int lastChar = result.length() - 1;
        if (queryStart == -1) {
            result.append('?');
        } else if (queryStart < lastChar && baseUrl.charAt(lastChar) != '&') {
            result.append('&');
        }
        return result;
    }

    private static StringBuilder addParam(Object key, Object value, StringBuilder result) {
        if (value != null && value.getClass().isArray()) {
            value = arrayToList(value);
        }
        if (value instanceof Iterable) {
            Iterator<?> iterator = ((Iterable) value).iterator();
            while (iterator.hasNext()) {
                result.append(key);
                result.append("[]=");
                Object element = iterator.next();
                if (element != null) {
                    result.append(element);
                }
                if (iterator.hasNext()) {
                    result.append("&");
                }
            }
        } else {
            result.append(key);
            result.append("=");
            if (value != null) {
                result.append(value);
            }
        }
        return result;
    }

    public static void setConnectionFactory(ConnectionFactory connectionFactory) {
        if (connectionFactory == null) {
            CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
        } else {
            CONNECTION_FACTORY = connectionFactory;
        }
    }

    private static List<Object> arrayToList(Object array) {
        int i = 0;
        if (array instanceof Object[]) {
            return Arrays.asList((Object[]) array);
        }
        List<Object> result = new ArrayList();
        int length;
        if (array instanceof int[]) {
            int[] iArr = (int[]) array;
            length = iArr.length;
            while (i < length) {
                result.add(Integer.valueOf(iArr[i]));
                i++;
            }
            return result;
        } else if (array instanceof boolean[]) {
            boolean[] zArr = (boolean[]) array;
            length = zArr.length;
            while (i < length) {
                result.add(Boolean.valueOf(zArr[i]));
                i++;
            }
            return result;
        } else if (array instanceof long[]) {
            long[] jArr = (long[]) array;
            length = jArr.length;
            while (i < length) {
                result.add(Long.valueOf(jArr[i]));
                i++;
            }
            return result;
        } else if (array instanceof float[]) {
            float[] fArr = (float[]) array;
            length = fArr.length;
            while (i < length) {
                result.add(Float.valueOf(fArr[i]));
                i++;
            }
            return result;
        } else if (array instanceof double[]) {
            double[] dArr = (double[]) array;
            length = dArr.length;
            while (i < length) {
                result.add(Double.valueOf(dArr[i]));
                i++;
            }
            return result;
        } else if (array instanceof short[]) {
            short[] sArr = (short[]) array;
            length = sArr.length;
            while (i < length) {
                result.add(Short.valueOf(sArr[i]));
                i++;
            }
            return result;
        } else if (array instanceof byte[]) {
            byte[] bArr = (byte[]) array;
            length = bArr.length;
            while (i < length) {
                result.add(Byte.valueOf(bArr[i]));
                i++;
            }
            return result;
        } else if (!(array instanceof char[])) {
            return result;
        } else {
            char[] cArr = (char[]) array;
            length = cArr.length;
            while (i < length) {
                result.add(Character.valueOf(cArr[i]));
                i++;
            }
            return result;
        }
    }

    public static String encode(CharSequence url) throws HttpRequestException {
        try {
            URL parsed = new URL(url.toString());
            String host = parsed.getHost();
            int port = parsed.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String encoded = new URI(parsed.getProtocol(), host, parsed.getPath(), parsed.getQuery(), null).toASCIIString();
                int paramsStart = encoded.indexOf(63);
                if (paramsStart > 0 && paramsStart + 1 < encoded.length()) {
                    encoded = encoded.substring(0, paramsStart + 1) + encoded.substring(paramsStart + 1).replace("+", "%2B");
                }
                return encoded;
            } catch (URISyntaxException e) {
                IOException io = new IOException("Parsing URI failed");
                io.initCause(e);
                throw new HttpRequestException(io);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static String append(CharSequence url, Map<?, ?> params) {
        String baseUrl = url.toString();
        if (params == null || params.isEmpty()) {
            return baseUrl;
        }
        StringBuilder result = new StringBuilder(baseUrl);
        addPathSeparator(baseUrl, result);
        addParamPrefix(baseUrl, result);
        Iterator<?> iterator = params.entrySet().iterator();
        Entry<?, ?> entry = (Entry) iterator.next();
        addParam(entry.getKey().toString(), entry.getValue(), result);
        while (iterator.hasNext()) {
            result.append('&');
            entry = (Entry) iterator.next();
            addParam(entry.getKey().toString(), entry.getValue(), result);
        }
        return result.toString();
    }

    public static String append(CharSequence url, Object... params) {
        String baseUrl = url.toString();
        if (params == null || params.length == 0) {
            return baseUrl;
        }
        if (params.length % 2 != 0) {
            throw new IllegalArgumentException("Must specify an even number of parameter names/values");
        }
        StringBuilder result = new StringBuilder(baseUrl);
        addPathSeparator(baseUrl, result);
        addParamPrefix(baseUrl, result);
        addParam(params[0], params[1], result);
        for (int i = 2; i < params.length; i += 2) {
            result.append('&');
            addParam(params[i], params[i + 1], result);
        }
        return result.toString();
    }

    public static HttpRequest get(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_GET);
    }

    public static HttpRequest get(URL url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_GET);
    }

    public static HttpRequest get(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
        CharSequence url = append(baseUrl, (Map) params);
        if (encode) {
            url = encode(url);
        }
        return get(url);
    }

    public static HttpRequest get(CharSequence baseUrl, boolean encode, Object... params) {
        CharSequence url = append(baseUrl, params);
        if (encode) {
            url = encode(url);
        }
        return get(url);
    }

    public static HttpRequest post(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_POST);
    }

    public static HttpRequest post(URL url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_POST);
    }

    public static HttpRequest post(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
        CharSequence url = append(baseUrl, (Map) params);
        if (encode) {
            url = encode(url);
        }
        return post(url);
    }

    public static HttpRequest post(CharSequence baseUrl, boolean encode, Object... params) {
        CharSequence url = append(baseUrl, params);
        if (encode) {
            url = encode(url);
        }
        return post(url);
    }

    public static HttpRequest put(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_PUT);
    }

    public static HttpRequest put(URL url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_PUT);
    }

    public static HttpRequest put(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
        CharSequence url = append(baseUrl, (Map) params);
        if (encode) {
            url = encode(url);
        }
        return put(url);
    }

    public static HttpRequest put(CharSequence baseUrl, boolean encode, Object... params) {
        CharSequence url = append(baseUrl, params);
        if (encode) {
            url = encode(url);
        }
        return put(url);
    }

    public static HttpRequest delete(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_DELETE);
    }

    public static HttpRequest delete(URL url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_DELETE);
    }

    public static HttpRequest delete(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
        CharSequence url = append(baseUrl, (Map) params);
        if (encode) {
            url = encode(url);
        }
        return delete(url);
    }

    public static HttpRequest delete(CharSequence baseUrl, boolean encode, Object... params) {
        CharSequence url = append(baseUrl, params);
        if (encode) {
            url = encode(url);
        }
        return delete(url);
    }

    public static HttpRequest head(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_HEAD);
    }

    public static HttpRequest head(URL url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_HEAD);
    }

    public static HttpRequest head(CharSequence baseUrl, Map<?, ?> params, boolean encode) {
        CharSequence url = append(baseUrl, (Map) params);
        if (encode) {
            url = encode(url);
        }
        return head(url);
    }

    public static HttpRequest head(CharSequence baseUrl, boolean encode, Object... params) {
        CharSequence url = append(baseUrl, params);
        if (encode) {
            url = encode(url);
        }
        return head(url);
    }

    public static HttpRequest options(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_OPTIONS);
    }

    public static HttpRequest options(URL url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_OPTIONS);
    }

    public static HttpRequest trace(CharSequence url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_TRACE);
    }

    public static HttpRequest trace(URL url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_TRACE);
    }

    public static void keepAlive(boolean keepAlive) {
        setProperty("http.keepAlive", Boolean.toString(keepAlive));
    }

    public static void maxConnections(int maxConnections) {
        setProperty("http.maxConnections", Integer.toString(maxConnections));
    }

    public static void proxyHost(String host) {
        setProperty("http.proxyHost", host);
        setProperty("https.proxyHost", host);
    }

    public static void proxyPort(int port) {
        String portValue = Integer.toString(port);
        setProperty("http.proxyPort", portValue);
        setProperty("https.proxyPort", portValue);
    }

    public static void nonProxyHosts(String... hosts) {
        if (hosts == null || hosts.length <= 0) {
            setProperty("http.nonProxyHosts", null);
            return;
        }
        StringBuilder separated = new StringBuilder();
        int last = hosts.length - 1;
        for (int i = 0; i < last; i++) {
            separated.append(hosts[i]).append('|');
        }
        separated.append(hosts[last]);
        setProperty("http.nonProxyHosts", separated.toString());
    }

    private static String setProperty(final String name, final String value) {
        PrivilegedAction<String> action;
        if (value != null) {
            action = new PrivilegedAction<String>() {
                public String run() {
                    return System.setProperty(name, value);
                }
            };
        } else {
            action = new PrivilegedAction<String>() {
                public String run() {
                    return System.clearProperty(name);
                }
            };
        }
        return (String) AccessController.doPrivileged(action);
    }

    public HttpRequest(CharSequence url, String method) throws HttpRequestException {
        try {
            this.url = new URL(url.toString());
            this.requestMethod = method;
        } catch (MalformedURLException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest(URL url, String method) throws HttpRequestException {
        this.url = url;
        this.requestMethod = method;
    }

    private Proxy createProxy() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.httpProxyHost, this.httpProxyPort));
    }

    private HttpURLConnection createConnection() {
        try {
            HttpURLConnection connection;
            if (this.httpProxyHost != null) {
                connection = CONNECTION_FACTORY.create(this.url, createProxy());
            } else {
                connection = CONNECTION_FACTORY.create(this.url);
            }
            connection.setRequestMethod(this.requestMethod);
            return connection;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String toString() {
        return method() + ' ' + url();
    }

    public HttpURLConnection getConnection() {
        if (this.connection == null) {
            this.connection = createConnection();
        }
        return this.connection;
    }

    public HttpRequest ignoreCloseExceptions(boolean ignore) {
        this.ignoreCloseExceptions = ignore;
        return this;
    }

    public boolean ignoreCloseExceptions() {
        return this.ignoreCloseExceptions;
    }

    public int code() throws HttpRequestException {
        try {
            closeOutput();
            return getConnection().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest code(AtomicInteger output) throws HttpRequestException {
        output.set(code());
        return this;
    }

    public boolean ok() throws HttpRequestException {
        return 200 == code();
    }

    public boolean created() throws HttpRequestException {
        return 201 == code();
    }

    public boolean noContent() throws HttpRequestException {
        return 204 == code();
    }

    public boolean serverError() throws HttpRequestException {
        return 500 == code();
    }

    public boolean badRequest() throws HttpRequestException {
        return 400 == code();
    }

    public boolean notFound() throws HttpRequestException {
        return 404 == code();
    }

    public boolean notModified() throws HttpRequestException {
        return 304 == code();
    }

    public String message() throws HttpRequestException {
        try {
            closeOutput();
            return getConnection().getResponseMessage();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest disconnect() {
        getConnection().disconnect();
        return this;
    }

    public HttpRequest chunk(int size) {
        getConnection().setChunkedStreamingMode(size);
        return this;
    }

    public HttpRequest bufferSize(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be greater than zero");
        }
        this.bufferSize = size;
        return this;
    }

    public int bufferSize() {
        return this.bufferSize;
    }

    public HttpRequest uncompress(boolean uncompress) {
        this.uncompress = uncompress;
        return this;
    }

    protected ByteArrayOutputStream byteStream() {
        int size = contentLength();
        if (size > 0) {
            return new ByteArrayOutputStream(size);
        }
        return new ByteArrayOutputStream();
    }

    public String body(String charset) throws HttpRequestException {
        OutputStream output = byteStream();
        try {
            copy(buffer(), output);
            return output.toString(getValidCharset(charset));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String body() throws HttpRequestException {
        return body(charset());
    }

    public HttpRequest body(AtomicReference<String> output) throws HttpRequestException {
        output.set(body());
        return this;
    }

    public HttpRequest body(AtomicReference<String> output, String charset) throws HttpRequestException {
        output.set(body(charset));
        return this;
    }

    public boolean isBodyEmpty() throws HttpRequestException {
        return contentLength() == 0;
    }

    public byte[] bytes() throws HttpRequestException {
        OutputStream output = byteStream();
        try {
            copy(buffer(), output);
            return output.toByteArray();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public BufferedInputStream buffer() throws HttpRequestException {
        return new BufferedInputStream(stream(), this.bufferSize);
    }

    public InputStream stream() throws HttpRequestException {
        if (code() < 400) {
            try {
                InputStream stream = getConnection().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        }
        stream = getConnection().getErrorStream();
        if (stream == null) {
            try {
                stream = getConnection().getInputStream();
            } catch (IOException e2) {
                if (contentLength() > 0) {
                    throw new HttpRequestException(e2);
                }
                stream = new ByteArrayInputStream(new byte[0]);
            }
        }
        if (!this.uncompress || !ENCODING_GZIP.equals(contentEncoding())) {
            return stream;
        }
        try {
            return new GZIPInputStream(stream);
        } catch (IOException e22) {
            throw new HttpRequestException(e22);
        }
    }

    public InputStreamReader reader(String charset) throws HttpRequestException {
        try {
            return new InputStreamReader(stream(), getValidCharset(charset));
        } catch (UnsupportedEncodingException e) {
            throw new HttpRequestException(e);
        }
    }

    public InputStreamReader reader() throws HttpRequestException {
        return reader(charset());
    }

    public BufferedReader bufferedReader(String charset) throws HttpRequestException {
        return new BufferedReader(reader(charset), this.bufferSize);
    }

    public BufferedReader bufferedReader() throws HttpRequestException {
        return bufferedReader(charset());
    }

    public HttpRequest receive(File file) throws HttpRequestException {
        try {
            final OutputStream output = new BufferedOutputStream(new FileOutputStream(file), this.bufferSize);
            return (HttpRequest) new CloseOperation<HttpRequest>(this.ignoreCloseExceptions, output) {
                protected HttpRequest run() throws HttpRequestException, IOException {
                    return HttpRequest.this.receive(output);
                }
            }.call();
        } catch (FileNotFoundException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest receive(OutputStream output) throws HttpRequestException {
        try {
            return copy(buffer(), output);
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest receive(PrintStream output) throws HttpRequestException {
        return receive((OutputStream) output);
    }

    public HttpRequest receive(Appendable appendable) throws HttpRequestException {
        BufferedReader reader = bufferedReader();
        final BufferedReader bufferedReader = reader;
        final Appendable appendable2 = appendable;
        return (HttpRequest) new CloseOperation<HttpRequest>(reader, this.ignoreCloseExceptions) {
            public HttpRequest run() throws IOException {
                CharBuffer buffer = CharBuffer.allocate(HttpRequest.this.bufferSize);
                while (true) {
                    int read = bufferedReader.read(buffer);
                    if (read == -1) {
                        return HttpRequest.this;
                    }
                    buffer.rewind();
                    appendable2.append(buffer, 0, read);
                    buffer.rewind();
                }
            }
        }.call();
    }

    public HttpRequest receive(Writer writer) throws HttpRequestException {
        BufferedReader reader = bufferedReader();
        final BufferedReader bufferedReader = reader;
        final Writer writer2 = writer;
        return (HttpRequest) new CloseOperation<HttpRequest>(reader, this.ignoreCloseExceptions) {
            public HttpRequest run() throws IOException {
                return HttpRequest.this.copy(bufferedReader, writer2);
            }
        }.call();
    }

    public HttpRequest readTimeout(int timeout) {
        getConnection().setReadTimeout(timeout);
        return this;
    }

    public HttpRequest connectTimeout(int timeout) {
        getConnection().setConnectTimeout(timeout);
        return this;
    }

    public HttpRequest header(String name, String value) {
        getConnection().setRequestProperty(name, value);
        return this;
    }

    public HttpRequest header(String name, Number value) {
        return header(name, value != null ? value.toString() : null);
    }

    public HttpRequest headers(Map<String, String> headers) {
        if (!headers.isEmpty()) {
            for (Entry header : headers.entrySet()) {
                header(header);
            }
        }
        return this;
    }

    public HttpRequest header(Entry<String, String> header) {
        return header((String) header.getKey(), (String) header.getValue());
    }

    public String header(String name) throws HttpRequestException {
        closeOutputQuietly();
        return getConnection().getHeaderField(name);
    }

    public Map<String, List<String>> headers() throws HttpRequestException {
        closeOutputQuietly();
        return getConnection().getHeaderFields();
    }

    public long dateHeader(String name) throws HttpRequestException {
        return dateHeader(name, -1);
    }

    public long dateHeader(String name, long defaultValue) throws HttpRequestException {
        closeOutputQuietly();
        return getConnection().getHeaderFieldDate(name, defaultValue);
    }

    public int intHeader(String name) throws HttpRequestException {
        return intHeader(name, -1);
    }

    public int intHeader(String name, int defaultValue) throws HttpRequestException {
        closeOutputQuietly();
        return getConnection().getHeaderFieldInt(name, defaultValue);
    }

    public String[] headers(String name) {
        Map<String, List<String>> headers = headers();
        if (headers == null || headers.isEmpty()) {
            return EMPTY_STRINGS;
        }
        List<String> values = (List) headers.get(name);
        if (values == null || values.isEmpty()) {
            return EMPTY_STRINGS;
        }
        return (String[]) values.toArray(new String[values.size()]);
    }

    public String parameter(String headerName, String paramName) {
        return getParam(header(headerName), paramName);
    }

    public Map<String, String> parameters(String headerName) {
        return getParams(header(headerName));
    }

    protected Map<String, String> getParams(String header) {
        if (header == null || header.length() == 0) {
            return Collections.emptyMap();
        }
        int headerLength = header.length();
        int start = header.indexOf(59) + 1;
        if (start == 0 || start == headerLength) {
            return Collections.emptyMap();
        }
        int end = header.indexOf(59, start);
        if (end == -1) {
            end = headerLength;
        }
        Map<String, String> params = new LinkedHashMap();
        while (start < end) {
            int nameEnd = header.indexOf(61, start);
            if (nameEnd != -1 && nameEnd < end) {
                String name = header.substring(start, nameEnd).trim();
                if (name.length() > 0) {
                    String value = header.substring(nameEnd + 1, end).trim();
                    int length = value.length();
                    if (length != 0) {
                        if (length > 2 && '\"' == value.charAt(0) && '\"' == value.charAt(length - 1)) {
                            params.put(name, value.substring(1, length - 1));
                        } else {
                            params.put(name, value);
                        }
                    }
                }
            }
            start = end + 1;
            end = header.indexOf(59, start);
            if (end == -1) {
                end = headerLength;
            }
        }
        return params;
    }

    protected String getParam(String value, String paramName) {
        if (value == null || value.length() == 0) {
            return null;
        }
        int length = value.length();
        int start = value.indexOf(59) + 1;
        if (start == 0 || start == length) {
            return null;
        }
        int end = value.indexOf(59, start);
        if (end == -1) {
            end = length;
        }
        while (start < end) {
            int nameEnd = value.indexOf(61, start);
            if (nameEnd != -1 && nameEnd < end && paramName.equals(value.substring(start, nameEnd).trim())) {
                String paramValue = value.substring(nameEnd + 1, end).trim();
                int valueLength = paramValue.length();
                if (valueLength != 0) {
                    if (valueLength > 2 && '\"' == paramValue.charAt(0) && '\"' == paramValue.charAt(valueLength - 1)) {
                        return paramValue.substring(1, valueLength - 1);
                    }
                    return paramValue;
                }
            }
            start = end + 1;
            end = value.indexOf(59, start);
            if (end == -1) {
                end = length;
            }
        }
        return null;
    }

    public String charset() {
        return parameter(HEADER_CONTENT_TYPE, PARAM_CHARSET);
    }

    public HttpRequest userAgent(String userAgent) {
        return header(HEADER_USER_AGENT, userAgent);
    }

    public HttpRequest referer(String referer) {
        return header(HEADER_REFERER, referer);
    }

    public HttpRequest useCaches(boolean useCaches) {
        getConnection().setUseCaches(useCaches);
        return this;
    }

    public HttpRequest acceptEncoding(String acceptEncoding) {
        return header(HEADER_ACCEPT_ENCODING, acceptEncoding);
    }

    public HttpRequest acceptGzipEncoding() {
        return acceptEncoding(ENCODING_GZIP);
    }

    public HttpRequest acceptCharset(String acceptCharset) {
        return header(HEADER_ACCEPT_CHARSET, acceptCharset);
    }

    public String contentEncoding() {
        return header(HEADER_CONTENT_ENCODING);
    }

    public String server() {
        return header(HEADER_SERVER);
    }

    public long date() {
        return dateHeader(HEADER_DATE);
    }

    public String cacheControl() {
        return header(HEADER_CACHE_CONTROL);
    }

    public String eTag() {
        return header(HEADER_ETAG);
    }

    public long expires() {
        return dateHeader(HEADER_EXPIRES);
    }

    public long lastModified() {
        return dateHeader(HEADER_LAST_MODIFIED);
    }

    public String location() {
        return header(HEADER_LOCATION);
    }

    public HttpRequest authorization(String authorization) {
        return header(HEADER_AUTHORIZATION, authorization);
    }

    public HttpRequest proxyAuthorization(String proxyAuthorization) {
        return header(HEADER_PROXY_AUTHORIZATION, proxyAuthorization);
    }

    public HttpRequest basic(String name, String password) {
        return authorization("Basic " + Base64.encode(name + ':' + password));
    }

    public HttpRequest proxyBasic(String name, String password) {
        return proxyAuthorization("Basic " + Base64.encode(name + ':' + password));
    }

    public HttpRequest ifModifiedSince(long ifModifiedSince) {
        getConnection().setIfModifiedSince(ifModifiedSince);
        return this;
    }

    public HttpRequest ifNoneMatch(String ifNoneMatch) {
        return header(HEADER_IF_NONE_MATCH, ifNoneMatch);
    }

    public HttpRequest contentType(String contentType) {
        return contentType(contentType, null);
    }

    public HttpRequest contentType(String contentType, String charset) {
        if (charset == null || charset.length() <= 0) {
            return header(HEADER_CONTENT_TYPE, contentType);
        }
        String separator = "; charset=";
        return header(HEADER_CONTENT_TYPE, contentType + "; charset=" + charset);
    }

    public String contentType() {
        return header(HEADER_CONTENT_TYPE);
    }

    public int contentLength() {
        return intHeader(HEADER_CONTENT_LENGTH);
    }

    public HttpRequest contentLength(String contentLength) {
        return contentLength(Integer.parseInt(contentLength));
    }

    public HttpRequest contentLength(int contentLength) {
        getConnection().setFixedLengthStreamingMode(contentLength);
        return this;
    }

    public HttpRequest accept(String accept) {
        return header(HEADER_ACCEPT, accept);
    }

    public HttpRequest acceptJson() {
        return accept(CONTENT_TYPE_JSON);
    }

    protected HttpRequest copy(InputStream input, OutputStream output) throws IOException {
        final InputStream inputStream = input;
        final OutputStream outputStream = output;
        return (HttpRequest) new CloseOperation<HttpRequest>(input, this.ignoreCloseExceptions) {
            public HttpRequest run() throws IOException {
                byte[] buffer = new byte[HttpRequest.this.bufferSize];
                while (true) {
                    int read = inputStream.read(buffer);
                    if (read == -1) {
                        return HttpRequest.this;
                    }
                    outputStream.write(buffer, 0, read);
                    HttpRequest.this.totalWritten = HttpRequest.this.totalWritten + ((long) read);
                    HttpRequest.this.progress.onUpload(HttpRequest.this.totalWritten, HttpRequest.this.totalSize);
                }
            }
        }.call();
    }

    protected HttpRequest copy(Reader input, Writer output) throws IOException {
        final Reader reader = input;
        final Writer writer = output;
        return (HttpRequest) new CloseOperation<HttpRequest>(input, this.ignoreCloseExceptions) {
            public HttpRequest run() throws IOException {
                char[] buffer = new char[HttpRequest.this.bufferSize];
                while (true) {
                    int read = reader.read(buffer);
                    if (read == -1) {
                        return HttpRequest.this;
                    }
                    writer.write(buffer, 0, read);
                    HttpRequest.this.totalWritten = HttpRequest.this.totalWritten + ((long) read);
                    HttpRequest.this.progress.onUpload(HttpRequest.this.totalWritten, -1);
                }
            }
        }.call();
    }

    public HttpRequest progress(UploadProgress callback) {
        if (callback == null) {
            this.progress = UploadProgress.DEFAULT;
        } else {
            this.progress = callback;
        }
        return this;
    }

    private HttpRequest incrementTotalSize(long size) {
        if (this.totalSize == -1) {
            this.totalSize = 0;
        }
        this.totalSize += size;
        return this;
    }

    protected HttpRequest closeOutput() throws IOException {
        progress(null);
        if (this.output != null) {
            if (this.multipart) {
                this.output.write("\r\n--00content0boundary00--\r\n");
            }
            if (this.ignoreCloseExceptions) {
                try {
                    this.output.close();
                } catch (IOException e) {
                }
            } else {
                this.output.close();
            }
            this.output = null;
        }
        return this;
    }

    protected HttpRequest closeOutputQuietly() throws HttpRequestException {
        try {
            return closeOutput();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest openOutput() throws IOException {
        if (this.output == null) {
            getConnection().setDoOutput(true);
            this.output = new RequestOutputStream(getConnection().getOutputStream(), getParam(getConnection().getRequestProperty(HEADER_CONTENT_TYPE), PARAM_CHARSET), this.bufferSize);
        }
        return this;
    }

    protected HttpRequest startPart() throws IOException {
        if (this.multipart) {
            this.output.write("\r\n--00content0boundary00\r\n");
        } else {
            this.multipart = true;
            contentType(CONTENT_TYPE_MULTIPART).openOutput();
            this.output.write("--00content0boundary00\r\n");
        }
        return this;
    }

    protected HttpRequest writePartHeader(String name, String filename) throws IOException {
        return writePartHeader(name, filename, null);
    }

    protected HttpRequest writePartHeader(String name, String filename, String contentType) throws IOException {
        StringBuilder partBuffer = new StringBuilder();
        partBuffer.append("form-data; name=\"").append(name);
        if (filename != null) {
            partBuffer.append("\"; filename=\"").append(filename);
        }
        partBuffer.append('\"');
        partHeader("Content-Disposition", partBuffer.toString());
        if (contentType != null) {
            partHeader(HEADER_CONTENT_TYPE, contentType);
        }
        return send(CRLF);
    }

    public HttpRequest part(String name, String part) {
        return part(name, null, part);
    }

    public HttpRequest part(String name, String filename, String part) throws HttpRequestException {
        return part(name, filename, null, part);
    }

    public HttpRequest part(String name, String filename, String contentType, String part) throws HttpRequestException {
        try {
            startPart();
            writePartHeader(name, filename, contentType);
            this.output.write(part);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest part(String name, Number part) throws HttpRequestException {
        return part(name, null, part);
    }

    public HttpRequest part(String name, String filename, Number part) throws HttpRequestException {
        return part(name, filename, part != null ? part.toString() : null);
    }

    public HttpRequest part(String name, File part) throws HttpRequestException {
        return part(name, null, part);
    }

    public HttpRequest part(String name, String filename, File part) throws HttpRequestException {
        return part(name, filename, null, part);
    }

    public HttpRequest part(String name, String filename, String contentType, File part) throws HttpRequestException {
        try {
            InputStream stream = new BufferedInputStream(new FileInputStream(part));
            incrementTotalSize(part.length());
            return part(name, filename, contentType, stream);
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest part(String name, InputStream part) throws HttpRequestException {
        return part(name, null, null, part);
    }

    public HttpRequest part(String name, String filename, String contentType, InputStream part) throws HttpRequestException {
        try {
            startPart();
            writePartHeader(name, filename, contentType);
            copy(part, this.output);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest partHeader(String name, String value) throws HttpRequestException {
        return send((CharSequence) name).send((CharSequence) ": ").send((CharSequence) value).send(CRLF);
    }

    public HttpRequest send(File input) throws HttpRequestException {
        try {
            InputStream stream = new BufferedInputStream(new FileInputStream(input));
            incrementTotalSize(input.length());
            return send(stream);
        } catch (FileNotFoundException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest send(byte[] input) throws HttpRequestException {
        if (input != null) {
            incrementTotalSize((long) input.length);
        }
        return send(new ByteArrayInputStream(input));
    }

    public HttpRequest send(InputStream input) throws HttpRequestException {
        try {
            openOutput();
            copy(input, this.output);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest send(final Reader input) throws HttpRequestException {
        try {
            openOutput();
            final Writer writer = new OutputStreamWriter(this.output, this.output.encoder.charset());
            return (HttpRequest) new FlushOperation<HttpRequest>(writer) {
                protected HttpRequest run() throws IOException {
                    return HttpRequest.this.copy(input, writer);
                }
            }.call();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest send(CharSequence value) throws HttpRequestException {
        try {
            openOutput();
            this.output.write(value.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public OutputStreamWriter writer() throws HttpRequestException {
        try {
            openOutput();
            return new OutputStreamWriter(this.output, this.output.encoder.charset());
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest form(Map<?, ?> values) throws HttpRequestException {
        return form((Map) values, CHARSET_UTF8);
    }

    public HttpRequest form(Entry<?, ?> entry) throws HttpRequestException {
        return form((Entry) entry, CHARSET_UTF8);
    }

    public HttpRequest form(Entry<?, ?> entry, String charset) throws HttpRequestException {
        return form(entry.getKey(), entry.getValue(), charset);
    }

    public HttpRequest form(Object name, Object value) throws HttpRequestException {
        return form(name, value, CHARSET_UTF8);
    }

    public HttpRequest form(Object name, Object value, String charset) throws HttpRequestException {
        boolean first = !this.form;
        if (first) {
            contentType(CONTENT_TYPE_FORM, charset);
            this.form = true;
        }
        charset = getValidCharset(charset);
        try {
            openOutput();
            if (!first) {
                this.output.write(38);
            }
            this.output.write(URLEncoder.encode(name.toString(), charset));
            this.output.write(61);
            if (value != null) {
                this.output.write(URLEncoder.encode(value.toString(), charset));
            }
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest form(Map<?, ?> values, String charset) throws HttpRequestException {
        if (!values.isEmpty()) {
            for (Entry entry : values.entrySet()) {
                form(entry, charset);
            }
        }
        return this;
    }

    public HttpRequest trustAllCerts() throws HttpRequestException {
        HttpURLConnection connection = getConnection();
        if (connection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) connection).setSSLSocketFactory(getTrustedFactory());
        }
        return this;
    }

    public HttpRequest trustAllHosts() {
        HttpURLConnection connection = getConnection();
        if (connection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) connection).setHostnameVerifier(getTrustedVerifier());
        }
        return this;
    }

    public URL url() {
        return getConnection().getURL();
    }

    public String method() {
        return getConnection().getRequestMethod();
    }

    public HttpRequest useProxy(String proxyHost, int proxyPort) {
        if (this.connection != null) {
            throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
        }
        this.httpProxyHost = proxyHost;
        this.httpProxyPort = proxyPort;
        return this;
    }

    public HttpRequest followRedirects(boolean followRedirects) {
        getConnection().setInstanceFollowRedirects(followRedirects);
        return this;
    }
}
