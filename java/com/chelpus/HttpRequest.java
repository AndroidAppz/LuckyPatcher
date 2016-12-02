/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.BufferedOutputStream
 *  java.io.BufferedReader
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.PrintStream
 *  java.io.Reader
 *  java.io.UnsupportedEncodingException
 *  java.io.Writer
 *  java.lang.Appendable
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.InetSocketAddress
 *  java.net.MalformedURLException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.SocketAddress
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.net.URLConnection
 *  java.net.URLEncoder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.CharBuffer
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetEncoder
 *  java.security.AccessController
 *  java.security.GeneralSecurityException
 *  java.security.PrivilegedAction
 *  java.security.SecureRandom
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.Callable
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicReference
 *  java.util.zip.GZIPInputStream
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.HttpsURLConnection
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSession
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.X509TrustManager
 */
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
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.Buffer;
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
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpRequest {
    private static final String BOUNDARY = "00content0boundary00";
    public static final String CHARSET_UTF8 = "UTF-8";
    private static ConnectionFactory CONNECTION_FACTORY;
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_MULTIPART = "multipart/form-data; boundary=00content0boundary00";
    private static final String CRLF = "\r\n";
    private static final String[] EMPTY_STRINGS;
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

    static {
        EMPTY_STRINGS = new String[0];
        CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
    }

    public HttpRequest(CharSequence charSequence, String string) throws HttpRequestException {
        try {
            this.url = new URL(charSequence.toString());
        }
        catch (MalformedURLException var3_3) {
            throw new HttpRequestException((IOException)var3_3);
        }
        this.requestMethod = string;
    }

    public HttpRequest(URL uRL, String string) throws HttpRequestException {
        this.url = uRL;
        this.requestMethod = string;
    }

    private static StringBuilder addParam(Object object, Object list, StringBuilder stringBuilder) {
        if (list != null && list.getClass().isArray()) {
            list = HttpRequest.arrayToList(list);
        }
        if (list instanceof Iterable) {
            Iterator iterator = ((Iterable)list).iterator();
            while (iterator.hasNext()) {
                stringBuilder.append(object);
                stringBuilder.append("[]=");
                Object object2 = iterator.next();
                if (object2 != null) {
                    stringBuilder.append(object2);
                }
                if (!iterator.hasNext()) continue;
                stringBuilder.append("&");
            }
        } else {
            stringBuilder.append(object);
            stringBuilder.append("=");
            if (list != null) {
                stringBuilder.append(list);
            }
        }
        return stringBuilder;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static StringBuilder addParamPrefix(String string, StringBuilder stringBuilder) {
        int n = string.indexOf(63);
        int n2 = -1 + stringBuilder.length();
        if (n == -1) {
            stringBuilder.append('?');
            return stringBuilder;
        } else {
            if (n >= n2 || string.charAt(n2) == '&') return stringBuilder;
            {
                stringBuilder.append('&');
                return stringBuilder;
            }
        }
    }

    private static StringBuilder addPathSeparator(String string, StringBuilder stringBuilder) {
        if (2 + string.indexOf(58) == string.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    public static String append(CharSequence charSequence, Map<?, ?> map) {
        String string = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        HttpRequest.addPathSeparator(string, stringBuilder);
        HttpRequest.addParamPrefix(string, stringBuilder);
        Iterator iterator = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry)iterator.next();
        HttpRequest.addParam(entry.getKey().toString(), entry.getValue(), stringBuilder);
        while (iterator.hasNext()) {
            stringBuilder.append('&');
            Map.Entry entry2 = (Map.Entry)iterator.next();
            HttpRequest.addParam(entry2.getKey().toString(), entry2.getValue(), stringBuilder);
        }
        return stringBuilder.toString();
    }

    public static /* varargs */ String append(CharSequence charSequence, Object ... arrobject) {
        String string = charSequence.toString();
        if (arrobject == null || arrobject.length == 0) {
            return string;
        }
        if (arrobject.length % 2 != 0) {
            throw new IllegalArgumentException("Must specify an even number of parameter names/values");
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        HttpRequest.addPathSeparator(string, stringBuilder);
        HttpRequest.addParamPrefix(string, stringBuilder);
        HttpRequest.addParam(arrobject[0], arrobject[1], stringBuilder);
        for (int i = 2; i < arrobject.length; i += 2) {
            stringBuilder.append('&');
            HttpRequest.addParam(arrobject[i], arrobject[i + 1], stringBuilder);
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static List<Object> arrayToList(Object object) {
        int n = 0;
        if (object instanceof Object[]) {
            return Arrays.asList((Object[])((Object[])object));
        }
        ArrayList arrayList = new ArrayList();
        if (object instanceof int[]) {
            int[] arrn = (int[])object;
            int n2 = arrn.length;
            while (n < n2) {
                arrayList.add((Object)arrn[n]);
                ++n;
            }
            return arrayList;
        }
        if (object instanceof boolean[]) {
            boolean[] arrbl = (boolean[])object;
            int n3 = arrbl.length;
            while (n < n3) {
                arrayList.add((Object)arrbl[n]);
                ++n;
            }
            return arrayList;
        }
        if (object instanceof long[]) {
            long[] arrl = (long[])object;
            int n4 = arrl.length;
            while (n < n4) {
                arrayList.add((Object)arrl[n]);
                ++n;
            }
            return arrayList;
        }
        if (object instanceof float[]) {
            float[] arrf = (float[])object;
            int n5 = arrf.length;
            while (n < n5) {
                arrayList.add((Object)Float.valueOf((float)arrf[n]));
                ++n;
            }
            return arrayList;
        }
        if (object instanceof double[]) {
            double[] arrd = (double[])object;
            int n6 = arrd.length;
            while (n < n6) {
                arrayList.add((Object)arrd[n]);
                ++n;
            }
            return arrayList;
        }
        if (object instanceof short[]) {
            short[] arrs = (short[])object;
            int n7 = arrs.length;
            while (n < n7) {
                arrayList.add((Object)arrs[n]);
                ++n;
            }
            return arrayList;
        }
        if (object instanceof byte[]) {
            byte[] arrby = (byte[])object;
            int n8 = arrby.length;
            while (n < n8) {
                arrayList.add((Object)Byte.valueOf((byte)arrby[n]));
                ++n;
            }
            return arrayList;
        }
        if (!(object instanceof char[])) return arrayList;
        char[] arrc = (char[])object;
        int n9 = arrc.length;
        while (n < n9) {
            arrayList.add((Object)Character.valueOf((char)arrc[n]));
            ++n;
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private HttpURLConnection createConnection() {
        try {
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2 = this.httpProxyHost != null ? CONNECTION_FACTORY.create(this.url, this.createProxy()) : (httpURLConnection = CONNECTION_FACTORY.create(this.url));
            httpURLConnection2.setRequestMethod(this.requestMethod);
            return httpURLConnection2;
        }
        catch (IOException var1_3) {
            throw new HttpRequestException(var1_3);
        }
    }

    private Proxy createProxy() {
        return new Proxy(Proxy.Type.HTTP, (SocketAddress)new InetSocketAddress(this.httpProxyHost, this.httpProxyPort));
    }

    public static HttpRequest delete(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "DELETE");
    }

    public static HttpRequest delete(CharSequence charSequence, Map<?, ?> map, boolean bl) {
        String string = HttpRequest.append(charSequence, map);
        if (bl) {
            string = HttpRequest.encode(string);
        }
        return HttpRequest.delete(string);
    }

    public static /* varargs */ HttpRequest delete(CharSequence charSequence, boolean bl, Object ... arrobject) {
        String string = HttpRequest.append(charSequence, arrobject);
        if (bl) {
            string = HttpRequest.encode(string);
        }
        return HttpRequest.delete(string);
    }

    public static HttpRequest delete(URL uRL) throws HttpRequestException {
        return new HttpRequest(uRL, "DELETE");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String encode(CharSequence charSequence) throws HttpRequestException {
        URL uRL;
        try {
            uRL = new URL(charSequence.toString());
        }
        catch (IOException iOException) {
            throw new HttpRequestException(iOException);
        }
        String string2 = uRL.getHost();
        int n2 = uRL.getPort();
        if (n2 != -1) {
            string2 = string2 + ':' + Integer.toString((int)n2);
        }
        try {
            String string = new URI(uRL.getProtocol(), string2, uRL.getPath(), uRL.getQuery(), null).toASCIIString();
            int n = string.indexOf(63);
            if (n <= 0) return string;
            if (n + 1 >= string.length()) return string;
            String string3 = string.substring(0, n + 1) + string.substring(n + 1).replace((CharSequence)"+", (CharSequence)"%2B");
            return string3;
        }
        catch (URISyntaxException var4_8) {
            IOException iOException = new IOException("Parsing URI failed");
            iOException.initCause((Throwable)var4_8);
            throw new HttpRequestException(iOException);
        }
    }

    public static HttpRequest get(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "GET");
    }

    public static HttpRequest get(CharSequence charSequence, Map<?, ?> map, boolean bl) {
        String string = HttpRequest.append(charSequence, map);
        if (bl) {
            string = HttpRequest.encode(string);
        }
        return HttpRequest.get(string);
    }

    public static /* varargs */ HttpRequest get(CharSequence charSequence, boolean bl, Object ... arrobject) {
        String string = HttpRequest.append(charSequence, arrobject);
        if (bl) {
            string = HttpRequest.encode(string);
        }
        return HttpRequest.get(string);
    }

    public static HttpRequest get(URL uRL) throws HttpRequestException {
        return new HttpRequest(uRL, "GET");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static SSLSocketFactory getTrustedFactory() throws HttpRequestException {
        if (TRUSTED_FACTORY != null) return TRUSTED_FACTORY;
        TrustManager[] arrtrustManager = new TrustManager[]{new X509TrustManager(){

            public void checkClientTrusted(X509Certificate[] arrx509Certificate, String string) {
            }

            public void checkServerTrusted(X509Certificate[] arrx509Certificate, String string) {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        try {
            SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
            sSLContext.init(null, arrtrustManager, new SecureRandom());
            TRUSTED_FACTORY = sSLContext.getSocketFactory();
        }
        catch (GeneralSecurityException generalSecurityException) {
            IOException iOException = new IOException("Security exception configuring SSL context");
            iOException.initCause((Throwable)generalSecurityException);
            throw new HttpRequestException(iOException);
        }
        return TRUSTED_FACTORY;
    }

    private static HostnameVerifier getTrustedVerifier() {
        if (TRUSTED_VERIFIER == null) {
            TRUSTED_VERIFIER = new HostnameVerifier(){

                public boolean verify(String string, SSLSession sSLSession) {
                    return true;
                }
            };
        }
        return TRUSTED_VERIFIER;
    }

    private static String getValidCharset(String string) {
        if (string != null && string.length() > 0) {
            return string;
        }
        return "UTF-8";
    }

    public static HttpRequest head(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "HEAD");
    }

    public static HttpRequest head(CharSequence charSequence, Map<?, ?> map, boolean bl) {
        String string = HttpRequest.append(charSequence, map);
        if (bl) {
            string = HttpRequest.encode(string);
        }
        return HttpRequest.head(string);
    }

    public static /* varargs */ HttpRequest head(CharSequence charSequence, boolean bl, Object ... arrobject) {
        String string = HttpRequest.append(charSequence, arrobject);
        if (bl) {
            string = HttpRequest.encode(string);
        }
        return HttpRequest.head(string);
    }

    public static HttpRequest head(URL uRL) throws HttpRequestException {
        return new HttpRequest(uRL, "HEAD");
    }

    private HttpRequest incrementTotalSize(long l) {
        if (this.totalSize == -1) {
            this.totalSize = 0;
        }
        this.totalSize = l + this.totalSize;
        return this;
    }

    public static void keepAlive(boolean bl) {
        HttpRequest.setProperty("http.keepAlive", Boolean.toString((boolean)bl));
    }

    public static void maxConnections(int n) {
        HttpRequest.setProperty("http.maxConnections", Integer.toString((int)n));
    }

    public static /* varargs */ void nonProxyHosts(String ... arrstring) {
        if (arrstring != null && arrstring.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            int n = -1 + arrstring.length;
            for (int i = 0; i < n; ++i) {
                stringBuilder.append(arrstring[i]).append('|');
            }
            stringBuilder.append(arrstring[n]);
            HttpRequest.setProperty("http.nonProxyHosts", stringBuilder.toString());
            return;
        }
        HttpRequest.setProperty("http.nonProxyHosts", null);
    }

    public static HttpRequest options(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "OPTIONS");
    }

    public static HttpRequest options(URL uRL) throws HttpRequestException {
        return new HttpRequest(uRL, "OPTIONS");
    }

    public static HttpRequest post(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "POST");
    }

    public static HttpRequest post(CharSequence charSequence, Map<?, ?> map, boolean bl) {
        String string = HttpRequest.append(charSequence, map);
        if (bl) {
            string = HttpRequest.encode(string);
        }
        return HttpRequest.post(string);
    }

    public static /* varargs */ HttpRequest post(CharSequence charSequence, boolean bl, Object ... arrobject) {
        String string = HttpRequest.append(charSequence, arrobject);
        if (bl) {
            string = HttpRequest.encode(string);
        }
        return HttpRequest.post(string);
    }

    public static HttpRequest post(URL uRL) throws HttpRequestException {
        return new HttpRequest(uRL, "POST");
    }

    public static void proxyHost(String string) {
        HttpRequest.setProperty("http.proxyHost", string);
        HttpRequest.setProperty("https.proxyHost", string);
    }

    public static void proxyPort(int n) {
        String string = Integer.toString((int)n);
        HttpRequest.setProperty("http.proxyPort", string);
        HttpRequest.setProperty("https.proxyPort", string);
    }

    public static HttpRequest put(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "PUT");
    }

    public static HttpRequest put(CharSequence charSequence, Map<?, ?> map, boolean bl) {
        String string = HttpRequest.append(charSequence, map);
        if (bl) {
            string = HttpRequest.encode(string);
        }
        return HttpRequest.put(string);
    }

    public static /* varargs */ HttpRequest put(CharSequence charSequence, boolean bl, Object ... arrobject) {
        String string = HttpRequest.append(charSequence, arrobject);
        if (bl) {
            string = HttpRequest.encode(string);
        }
        return HttpRequest.put(string);
    }

    public static HttpRequest put(URL uRL) throws HttpRequestException {
        return new HttpRequest(uRL, "PUT");
    }

    public static void setConnectionFactory(ConnectionFactory connectionFactory) {
        if (connectionFactory == null) {
            CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
            return;
        }
        CONNECTION_FACTORY = connectionFactory;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String setProperty(final String string, final String string2) {
        void var2_3;
        if (string2 != null) {
            PrivilegedAction<String> privilegedAction = new PrivilegedAction<String>(){

                public String run() {
                    return System.setProperty((String)string, (String)string2);
                }
            };
            do {
                return (String)AccessController.doPrivileged((PrivilegedAction)var2_3);
                break;
            } while (true);
        }
        PrivilegedAction<String> privilegedAction = new PrivilegedAction<String>(){

            public String run() {
                return System.clearProperty((String)string);
            }
        };
        return (String)AccessController.doPrivileged((PrivilegedAction)var2_3);
    }

    public static HttpRequest trace(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "TRACE");
    }

    public static HttpRequest trace(URL uRL) throws HttpRequestException {
        return new HttpRequest(uRL, "TRACE");
    }

    public HttpRequest accept(String string) {
        return this.header("Accept", string);
    }

    public HttpRequest acceptCharset(String string) {
        return this.header("Accept-Charset", string);
    }

    public HttpRequest acceptEncoding(String string) {
        return this.header("Accept-Encoding", string);
    }

    public HttpRequest acceptGzipEncoding() {
        return this.acceptEncoding("gzip");
    }

    public HttpRequest acceptJson() {
        return this.accept("application/json");
    }

    public HttpRequest authorization(String string) {
        return this.header("Authorization", string);
    }

    public boolean badRequest() throws HttpRequestException {
        if (400 == this.code()) {
            return true;
        }
        return false;
    }

    public HttpRequest basic(String string, String string2) {
        return this.authorization("Basic " + Base64.encode(new StringBuilder().append(string).append(':').append(string2).toString()));
    }

    public HttpRequest body(AtomicReference<String> atomicReference) throws HttpRequestException {
        atomicReference.set((Object)this.body());
        return this;
    }

    public HttpRequest body(AtomicReference<String> atomicReference, String string) throws HttpRequestException {
        atomicReference.set((Object)this.body(string));
        return this;
    }

    public String body() throws HttpRequestException {
        return this.body(this.charset());
    }

    public String body(String string) throws HttpRequestException {
        ByteArrayOutputStream byteArrayOutputStream = this.byteStream();
        try {
            this.copy((InputStream)this.buffer(), (OutputStream)byteArrayOutputStream);
            String string2 = byteArrayOutputStream.toString(HttpRequest.getValidCharset(string));
            return string2;
        }
        catch (IOException var3_4) {
            throw new HttpRequestException(var3_4);
        }
    }

    public BufferedInputStream buffer() throws HttpRequestException {
        return new BufferedInputStream(this.stream(), this.bufferSize);
    }

    public int bufferSize() {
        return this.bufferSize;
    }

    public HttpRequest bufferSize(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Size must be greater than zero");
        }
        this.bufferSize = n;
        return this;
    }

    public BufferedReader bufferedReader() throws HttpRequestException {
        return this.bufferedReader(this.charset());
    }

    public BufferedReader bufferedReader(String string) throws HttpRequestException {
        return new BufferedReader((Reader)this.reader(string), this.bufferSize);
    }

    protected ByteArrayOutputStream byteStream() {
        int n = this.contentLength();
        if (n > 0) {
            return new ByteArrayOutputStream(n);
        }
        return new ByteArrayOutputStream();
    }

    public byte[] bytes() throws HttpRequestException {
        ByteArrayOutputStream byteArrayOutputStream = this.byteStream();
        try {
            this.copy((InputStream)this.buffer(), (OutputStream)byteArrayOutputStream);
        }
        catch (IOException var2_2) {
            throw new HttpRequestException(var2_2);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String cacheControl() {
        return this.header("Cache-Control");
    }

    public String charset() {
        return this.parameter("Content-Type", "charset");
    }

    public HttpRequest chunk(int n) {
        this.getConnection().setChunkedStreamingMode(n);
        return this;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected HttpRequest closeOutput() throws IOException {
        this.progress(null);
        if (this.output == null) {
            return this;
        }
        if (this.multipart) {
            this.output.write("\r\n--00content0boundary00--\r\n");
        }
        if (this.ignoreCloseExceptions) {
            this.output.close();
            ** GOTO lbl13
        } else {
            this.output.close();
        }
        ** GOTO lbl13
        catch (IOException var2_1) {}
lbl13: // 3 sources:
        this.output = null;
        return this;
    }

    protected HttpRequest closeOutputQuietly() throws HttpRequestException {
        try {
            HttpRequest httpRequest = this.closeOutput();
            return httpRequest;
        }
        catch (IOException var1_2) {
            throw new HttpRequestException(var1_2);
        }
    }

    public int code() throws HttpRequestException {
        try {
            this.closeOutput();
            int n = this.getConnection().getResponseCode();
            return n;
        }
        catch (IOException var1_2) {
            throw new HttpRequestException(var1_2);
        }
    }

    public HttpRequest code(AtomicInteger atomicInteger) throws HttpRequestException {
        atomicInteger.set(this.code());
        return this;
    }

    public HttpRequest connectTimeout(int n) {
        this.getConnection().setConnectTimeout(n);
        return this;
    }

    public String contentEncoding() {
        return this.header("Content-Encoding");
    }

    public int contentLength() {
        return this.intHeader("Content-Length");
    }

    public HttpRequest contentLength(int n) {
        this.getConnection().setFixedLengthStreamingMode(n);
        return this;
    }

    public HttpRequest contentLength(String string) {
        return this.contentLength(Integer.parseInt((String)string));
    }

    public HttpRequest contentType(String string) {
        return this.contentType(string, null);
    }

    public HttpRequest contentType(String string, String string2) {
        if (string2 != null && string2.length() > 0) {
            return this.header("Content-Type", string + "; charset=" + string2);
        }
        return this.header("Content-Type", string);
    }

    public String contentType() {
        return this.header("Content-Type");
    }

    protected HttpRequest copy(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        return (HttpRequest)new CloseOperation<HttpRequest>((Closeable)inputStream, this.ignoreCloseExceptions){

            @Override
            public HttpRequest run() throws IOException {
                int n;
                byte[] arrby = new byte[HttpRequest.this.bufferSize];
                while ((n = inputStream.read(arrby)) != -1) {
                    outputStream.write(arrby, 0, n);
                    HttpRequest.this.totalWritten = HttpRequest.this.totalWritten + (long)n;
                    HttpRequest.this.progress.onUpload(HttpRequest.this.totalWritten, HttpRequest.this.totalSize);
                }
                return HttpRequest.this;
            }
        }.call();
    }

    protected HttpRequest copy(final Reader reader, final Writer writer) throws IOException {
        return (HttpRequest)new CloseOperation<HttpRequest>((Closeable)reader, this.ignoreCloseExceptions){

            @Override
            public HttpRequest run() throws IOException {
                int n;
                char[] arrc = new char[HttpRequest.this.bufferSize];
                while ((n = reader.read(arrc)) != -1) {
                    writer.write(arrc, 0, n);
                    HttpRequest.this.totalWritten = HttpRequest.this.totalWritten + (long)n;
                    HttpRequest.this.progress.onUpload(HttpRequest.this.totalWritten, -1);
                }
                return HttpRequest.this;
            }
        }.call();
    }

    public boolean created() throws HttpRequestException {
        if (201 == this.code()) {
            return true;
        }
        return false;
    }

    public long date() {
        return this.dateHeader("Date");
    }

    public long dateHeader(String string) throws HttpRequestException {
        return this.dateHeader(string, -1);
    }

    public long dateHeader(String string, long l) throws HttpRequestException {
        this.closeOutputQuietly();
        return this.getConnection().getHeaderFieldDate(string, l);
    }

    public HttpRequest disconnect() {
        this.getConnection().disconnect();
        return this;
    }

    public String eTag() {
        return this.header("ETag");
    }

    public long expires() {
        return this.dateHeader("Expires");
    }

    public HttpRequest followRedirects(boolean bl) {
        this.getConnection().setInstanceFollowRedirects(bl);
        return this;
    }

    public HttpRequest form(Object object, Object object2) throws HttpRequestException {
        return this.form(object, object2, "UTF-8");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HttpRequest form(Object object, Object object2, String string) throws HttpRequestException {
        boolean bl = !this.form;
        if (bl) {
            this.contentType("application/x-www-form-urlencoded", string);
            this.form = true;
        }
        String string2 = HttpRequest.getValidCharset(string);
        try {
            this.openOutput();
            if (!bl) {
                this.output.write(38);
            }
            this.output.write(URLEncoder.encode((String)object.toString(), (String)string2));
            this.output.write(61);
            if (object2 != null) {
                this.output.write(URLEncoder.encode((String)object2.toString(), (String)string2));
            }
            return this;
        }
        catch (IOException var6_6) {
            throw new HttpRequestException(var6_6);
        }
    }

    public HttpRequest form(Map.Entry<?, ?> entry) throws HttpRequestException {
        return this.form(entry, "UTF-8");
    }

    public HttpRequest form(Map.Entry<?, ?> entry, String string) throws HttpRequestException {
        return this.form(entry.getKey(), entry.getValue(), string);
    }

    public HttpRequest form(Map<?, ?> map) throws HttpRequestException {
        return this.form(map, "UTF-8");
    }

    public HttpRequest form(Map<?, ?> map, String string) throws HttpRequestException {
        if (!map.isEmpty()) {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                this.form((Map.Entry)iterator.next(), string);
            }
        }
        return this;
    }

    public HttpURLConnection getConnection() {
        if (this.connection == null) {
            this.connection = this.createConnection();
        }
        return this.connection;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected String getParam(String string, String string2) {
        if (string == null) return null;
        if (string.length() == 0) {
            return null;
        }
        int n = string.length();
        int n2 = 1 + string.indexOf(59);
        if (n2 == 0) return null;
        if (n2 == n) {
            return null;
        }
        int n3 = string.indexOf(59, n2);
        if (n3 == -1) {
            n3 = n;
        }
        while (n2 < n3) {
            int n4;
            String string3;
            int n5 = string.indexOf(61, n2);
            if (n5 != -1 && n5 < n3 && string2.equals((Object)string.substring(n2, n5).trim()) && (n4 = (string3 = string.substring(n5 + 1, n3).trim()).length()) != 0) {
                if (n4 <= 2) return string3;
                if ('\"' != string3.charAt(0)) return string3;
                if ('\"' != string3.charAt(n4 - 1)) return string3;
                return string3.substring(1, n4 - 1);
            }
            n2 = n3 + 1;
            n3 = string.indexOf(59, n2);
            if (n3 != -1) continue;
            n3 = n;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected Map<String, String> getParams(String string) {
        if (string == null) return Collections.emptyMap();
        if (string.length() == 0) {
            return Collections.emptyMap();
        }
        int n = string.length();
        int n2 = 1 + string.indexOf(59);
        if (n2 == 0) return Collections.emptyMap();
        if (n2 == n) {
            return Collections.emptyMap();
        }
        int n3 = string.indexOf(59, n2);
        if (n3 == -1) {
            n3 = n;
        }
        Map map = new LinkedHashMap();
        while (n2 < n3) {
            String string2;
            String string3;
            int n4;
            int n5 = string.indexOf(61, n2);
            if (n5 != -1 && n5 < n3 && (string3 = string.substring(n2, n5).trim()).length() > 0 && (n4 = (string2 = string.substring(n5 + 1, n3).trim()).length()) != 0) {
                if (n4 > 2 && '\"' == string2.charAt(0) && '\"' == string2.charAt(n4 - 1)) {
                    map.put((Object)string3, (Object)string2.substring(1, n4 - 1));
                } else {
                    map.put((Object)string3, (Object)string2);
                }
            }
            n2 = n3 + 1;
            n3 = string.indexOf(59, n2);
            if (n3 != -1) continue;
            n3 = n;
        }
        return map;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public HttpRequest header(String string, Number number) {
        String string2;
        if (number != null) {
            string2 = number.toString();
            do {
                return this.header(string, string2);
                break;
            } while (true);
        }
        string2 = null;
        return this.header(string, string2);
    }

    public HttpRequest header(String string, String string2) {
        this.getConnection().setRequestProperty(string, string2);
        return this;
    }

    public HttpRequest header(Map.Entry<String, String> entry) {
        return this.header((String)entry.getKey(), (String)entry.getValue());
    }

    public String header(String string) throws HttpRequestException {
        this.closeOutputQuietly();
        return this.getConnection().getHeaderField(string);
    }

    public HttpRequest headers(Map<String, String> map) {
        if (!map.isEmpty()) {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                this.header((Map.Entry)iterator.next());
            }
        }
        return this;
    }

    public Map<String, List<String>> headers() throws HttpRequestException {
        this.closeOutputQuietly();
        return this.getConnection().getHeaderFields();
    }

    public String[] headers(String string) {
        Map<String, List<String>> map = this.headers();
        if (map == null || map.isEmpty()) {
            return EMPTY_STRINGS;
        }
        List list = (List)map.get((Object)string);
        if (list != null && !list.isEmpty()) {
            return (String[])list.toArray((Object[])new String[list.size()]);
        }
        return EMPTY_STRINGS;
    }

    public HttpRequest ifModifiedSince(long l) {
        this.getConnection().setIfModifiedSince(l);
        return this;
    }

    public HttpRequest ifNoneMatch(String string) {
        return this.header("If-None-Match", string);
    }

    public HttpRequest ignoreCloseExceptions(boolean bl) {
        this.ignoreCloseExceptions = bl;
        return this;
    }

    public boolean ignoreCloseExceptions() {
        return this.ignoreCloseExceptions;
    }

    public int intHeader(String string) throws HttpRequestException {
        return this.intHeader(string, -1);
    }

    public int intHeader(String string, int n) throws HttpRequestException {
        this.closeOutputQuietly();
        return this.getConnection().getHeaderFieldInt(string, n);
    }

    public boolean isBodyEmpty() throws HttpRequestException {
        if (this.contentLength() == 0) {
            return true;
        }
        return false;
    }

    public long lastModified() {
        return this.dateHeader("Last-Modified");
    }

    public String location() {
        return this.header("Location");
    }

    public String message() throws HttpRequestException {
        try {
            this.closeOutput();
            String string = this.getConnection().getResponseMessage();
            return string;
        }
        catch (IOException var1_2) {
            throw new HttpRequestException(var1_2);
        }
    }

    public String method() {
        return this.getConnection().getRequestMethod();
    }

    public boolean noContent() throws HttpRequestException {
        if (204 == this.code()) {
            return true;
        }
        return false;
    }

    public boolean notFound() throws HttpRequestException {
        if (404 == this.code()) {
            return true;
        }
        return false;
    }

    public boolean notModified() throws HttpRequestException {
        if (304 == this.code()) {
            return true;
        }
        return false;
    }

    public boolean ok() throws HttpRequestException {
        if (200 == this.code()) {
            return true;
        }
        return false;
    }

    protected HttpRequest openOutput() throws IOException {
        if (this.output != null) {
            return this;
        }
        this.getConnection().setDoOutput(true);
        String string = this.getParam(this.getConnection().getRequestProperty("Content-Type"), "charset");
        this.output = new RequestOutputStream(this.getConnection().getOutputStream(), string, this.bufferSize);
        return this;
    }

    public String parameter(String string, String string2) {
        return this.getParam(this.header(string), string2);
    }

    public Map<String, String> parameters(String string) {
        return this.getParams(this.header(string));
    }

    public HttpRequest part(String string, File file) throws HttpRequestException {
        return this.part(string, null, file);
    }

    public HttpRequest part(String string, InputStream inputStream) throws HttpRequestException {
        return this.part(string, null, null, inputStream);
    }

    public HttpRequest part(String string, Number number) throws HttpRequestException {
        return this.part(string, null, number);
    }

    public HttpRequest part(String string, String string2) {
        return this.part(string, null, string2);
    }

    public HttpRequest part(String string, String string2, File file) throws HttpRequestException {
        return this.part(string, string2, null, file);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public HttpRequest part(String string, String string2, Number number) throws HttpRequestException {
        String string3;
        if (number != null) {
            string3 = number.toString();
            do {
                return this.part(string, string2, string3);
                break;
            } while (true);
        }
        string3 = null;
        return this.part(string, string2, string3);
    }

    public HttpRequest part(String string, String string2, String string3) throws HttpRequestException {
        return this.part(string, string2, null, string3);
    }

    public HttpRequest part(String string, String string2, String string3, File file) throws HttpRequestException {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream((InputStream)new FileInputStream(file));
            super.incrementTotalSize(file.length());
        }
        catch (IOException var6_6) {
            throw new HttpRequestException(var6_6);
        }
        return this.part(string, string2, string3, (InputStream)bufferedInputStream);
    }

    public HttpRequest part(String string, String string2, String string3, InputStream inputStream) throws HttpRequestException {
        try {
            this.startPart();
            this.writePartHeader(string, string2, string3);
            this.copy(inputStream, (OutputStream)this.output);
            return this;
        }
        catch (IOException var5_5) {
            throw new HttpRequestException(var5_5);
        }
    }

    public HttpRequest part(String string, String string2, String string3, String string4) throws HttpRequestException {
        try {
            this.startPart();
            this.writePartHeader(string, string2, string3);
            this.output.write(string4);
            return this;
        }
        catch (IOException var5_5) {
            throw new HttpRequestException(var5_5);
        }
    }

    public HttpRequest partHeader(String string, String string2) throws HttpRequestException {
        return this.send(string).send(": ").send(string2).send("\r\n");
    }

    public HttpRequest progress(UploadProgress uploadProgress) {
        if (uploadProgress == null) {
            this.progress = UploadProgress.DEFAULT;
            return this;
        }
        this.progress = uploadProgress;
        return this;
    }

    public HttpRequest proxyAuthorization(String string) {
        return this.header("Proxy-Authorization", string);
    }

    public HttpRequest proxyBasic(String string, String string2) {
        return this.proxyAuthorization("Basic " + Base64.encode(new StringBuilder().append(string).append(':').append(string2).toString()));
    }

    public HttpRequest readTimeout(int n) {
        this.getConnection().setReadTimeout(n);
        return this;
    }

    public InputStreamReader reader() throws HttpRequestException {
        return this.reader(this.charset());
    }

    public InputStreamReader reader(String string) throws HttpRequestException {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(this.stream(), HttpRequest.getValidCharset(string));
            return inputStreamReader;
        }
        catch (UnsupportedEncodingException var3_3) {
            throw new HttpRequestException((IOException)var3_3);
        }
    }

    public HttpRequest receive(File file) throws HttpRequestException {
        BufferedOutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream((OutputStream)new FileOutputStream(file), this.bufferSize);
        }
        catch (FileNotFoundException var3_3) {
            throw new HttpRequestException((IOException)var3_3);
        }
        return (HttpRequest)new CloseOperation<HttpRequest>((Closeable)bufferedOutputStream, this.ignoreCloseExceptions, (OutputStream)bufferedOutputStream){
            final /* synthetic */ OutputStream val$output;

            @Override
            protected HttpRequest run() throws HttpRequestException, IOException {
                return HttpRequest.this.receive(this.val$output);
            }
        }.call();
    }

    public HttpRequest receive(OutputStream outputStream) throws HttpRequestException {
        try {
            HttpRequest httpRequest = this.copy((InputStream)this.buffer(), outputStream);
            return httpRequest;
        }
        catch (IOException var2_3) {
            throw new HttpRequestException(var2_3);
        }
    }

    public HttpRequest receive(PrintStream printStream) throws HttpRequestException {
        return this.receive((OutputStream)printStream);
    }

    public HttpRequest receive(final Writer writer) throws HttpRequestException {
        final BufferedReader bufferedReader = this.bufferedReader();
        return (HttpRequest)new CloseOperation<HttpRequest>((Closeable)bufferedReader, this.ignoreCloseExceptions){

            @Override
            public HttpRequest run() throws IOException {
                return HttpRequest.this.copy((Reader)bufferedReader, writer);
            }
        }.call();
    }

    public HttpRequest receive(final Appendable appendable) throws HttpRequestException {
        final BufferedReader bufferedReader = this.bufferedReader();
        return (HttpRequest)new CloseOperation<HttpRequest>((Closeable)bufferedReader, this.ignoreCloseExceptions){

            @Override
            public HttpRequest run() throws IOException {
                int n;
                CharBuffer charBuffer = CharBuffer.allocate((int)HttpRequest.this.bufferSize);
                while ((n = bufferedReader.read(charBuffer)) != -1) {
                    charBuffer.rewind();
                    appendable.append((CharSequence)charBuffer, 0, n);
                    charBuffer.rewind();
                }
                return HttpRequest.this;
            }
        }.call();
    }

    public HttpRequest referer(String string) {
        return this.header("Referer", string);
    }

    public HttpRequest send(File file) throws HttpRequestException {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream((InputStream)new FileInputStream(file));
            super.incrementTotalSize(file.length());
        }
        catch (FileNotFoundException var3_3) {
            throw new HttpRequestException((IOException)var3_3);
        }
        return this.send((InputStream)bufferedInputStream);
    }

    public HttpRequest send(InputStream inputStream) throws HttpRequestException {
        try {
            this.openOutput();
            this.copy(inputStream, (OutputStream)this.output);
            return this;
        }
        catch (IOException var2_2) {
            throw new HttpRequestException(var2_2);
        }
    }

    public HttpRequest send(final Reader reader) throws HttpRequestException {
        try {
            this.openOutput();
        }
        catch (IOException var2_3) {
            throw new HttpRequestException(var2_3);
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)this.output, this.output.encoder.charset());
        return (HttpRequest)new FlushOperation<HttpRequest>((Flushable)outputStreamWriter, (Writer)outputStreamWriter){
            final /* synthetic */ Writer val$writer;

            @Override
            protected HttpRequest run() throws IOException {
                return HttpRequest.this.copy(reader, this.val$writer);
            }
        }.call();
    }

    public HttpRequest send(CharSequence charSequence) throws HttpRequestException {
        try {
            this.openOutput();
            this.output.write(charSequence.toString());
            return this;
        }
        catch (IOException var2_2) {
            throw new HttpRequestException(var2_2);
        }
    }

    public HttpRequest send(byte[] arrby) throws HttpRequestException {
        if (arrby != null) {
            super.incrementTotalSize(arrby.length);
        }
        return this.send((InputStream)new ByteArrayInputStream(arrby));
    }

    public String server() {
        return this.header("Server");
    }

    public boolean serverError() throws HttpRequestException {
        if (500 == this.code()) {
            return true;
        }
        return false;
    }

    protected HttpRequest startPart() throws IOException {
        if (!this.multipart) {
            this.multipart = true;
            this.contentType("multipart/form-data; boundary=00content0boundary00").openOutput();
            this.output.write("--00content0boundary00\r\n");
            return this;
        }
        this.output.write("\r\n--00content0boundary00\r\n");
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public InputStream stream() throws HttpRequestException {
        InputStream inputStream;
        if (this.code() < 400) {
            try {
                InputStream inputStream2;
                inputStream = inputStream2 = this.getConnection().getInputStream();
            }
            catch (IOException var6_3) {
                throw new HttpRequestException(var6_3);
            }
        } else {
            inputStream = this.getConnection().getErrorStream();
            if (inputStream == null) {
                try {
                    InputStream inputStream3;
                    inputStream = inputStream3 = this.getConnection().getInputStream();
                }
                catch (IOException var2_5) {
                    if (this.contentLength() > 0) {
                        throw new HttpRequestException(var2_5);
                    }
                    inputStream = new ByteArrayInputStream(new byte[0]);
                }
            }
        }
        if (!this.uncompress) return inputStream;
        if (!"gzip".equals((Object)this.contentEncoding())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        }
        catch (IOException var4_7) {
            throw new HttpRequestException(var4_7);
        }
    }

    public String toString() {
        return this.method() + ' ' + (Object)this.url();
    }

    public HttpRequest trustAllCerts() throws HttpRequestException {
        HttpURLConnection httpURLConnection = this.getConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection)httpURLConnection).setSSLSocketFactory(HttpRequest.getTrustedFactory());
        }
        return this;
    }

    public HttpRequest trustAllHosts() {
        HttpURLConnection httpURLConnection = this.getConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection)httpURLConnection).setHostnameVerifier(HttpRequest.getTrustedVerifier());
        }
        return this;
    }

    public HttpRequest uncompress(boolean bl) {
        this.uncompress = bl;
        return this;
    }

    public URL url() {
        return this.getConnection().getURL();
    }

    public HttpRequest useCaches(boolean bl) {
        this.getConnection().setUseCaches(bl);
        return this;
    }

    public HttpRequest useProxy(String string, int n) {
        if (this.connection != null) {
            throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
        }
        this.httpProxyHost = string;
        this.httpProxyPort = n;
        return this;
    }

    public HttpRequest userAgent(String string) {
        return this.header("User-Agent", string);
    }

    protected HttpRequest writePartHeader(String string, String string2) throws IOException {
        return this.writePartHeader(string, string2, null);
    }

    protected HttpRequest writePartHeader(String string, String string2, String string3) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(string);
        if (string2 != null) {
            stringBuilder.append("\"; filename=\"").append(string2);
        }
        stringBuilder.append('\"');
        this.partHeader("Content-Disposition", stringBuilder.toString());
        if (string3 != null) {
            this.partHeader("Content-Type", string3);
        }
        return this.send("\r\n");
    }

    public OutputStreamWriter writer() throws HttpRequestException {
        try {
            this.openOutput();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)this.output, this.output.encoder.charset());
            return outputStreamWriter;
        }
        catch (IOException var1_2) {
            throw new HttpRequestException(var1_2);
        }
    }

    public static class Base64 {
        private static final byte EQUALS_SIGN = 61;
        private static final String PREFERRED_ENCODING = "US-ASCII";
        private static final byte[] _STANDARD_ALPHABET = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        private Base64() {
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public static String encode(String string) {
            byte[] arrby;
            try {
                byte[] arrby2;
                arrby = arrby2 = string.getBytes("US-ASCII");
            }
            catch (UnsupportedEncodingException var1_3) {
                arrby = string.getBytes();
                return Base64.encodeBytes(arrby);
            }
            do {
                return Base64.encodeBytes(arrby);
                break;
            } while (true);
        }

        /*
         * Enabled aggressive block sorting
         */
        private static byte[] encode3to4(byte[] arrby, int n, int n2, byte[] arrby2, int n3) {
            byte[] arrby3 = _STANDARD_ALPHABET;
            int n4 = n2 > 0 ? arrby[n] << 24 >>> 8 : 0;
            int n5 = n2 > 1 ? arrby[n + 1] << 24 >>> 16 : 0;
            int n6 = n5 | n4;
            int n7 = 0;
            if (n2 > 2) {
                n7 = arrby[n + 2] << 24 >>> 24;
            }
            int n8 = n6 | n7;
            switch (n2) {
                default: {
                    return arrby2;
                }
                case 3: {
                    arrby2[n3] = arrby3[n8 >>> 18];
                    arrby2[n3 + 1] = arrby3[63 & n8 >>> 12];
                    arrby2[n3 + 2] = arrby3[63 & n8 >>> 6];
                    arrby2[n3 + 3] = arrby3[n8 & 63];
                    return arrby2;
                }
                case 2: {
                    arrby2[n3] = arrby3[n8 >>> 18];
                    arrby2[n3 + 1] = arrby3[63 & n8 >>> 12];
                    arrby2[n3 + 2] = arrby3[63 & n8 >>> 6];
                    arrby2[n3 + 3] = 61;
                    return arrby2;
                }
                case 1: 
            }
            arrby2[n3] = arrby3[n8 >>> 18];
            arrby2[n3 + 1] = arrby3[63 & n8 >>> 12];
            arrby2[n3 + 2] = 61;
            arrby2[n3 + 3] = 61;
            return arrby2;
        }

        public static String encodeBytes(byte[] arrby) {
            return Base64.encodeBytes(arrby, 0, arrby.length);
        }

        public static String encodeBytes(byte[] arrby, int n, int n2) {
            byte[] arrby2 = Base64.encodeBytesToBytes(arrby, n, n2);
            try {
                String string = new String(arrby2, "US-ASCII");
                return string;
            }
            catch (UnsupportedEncodingException var5_5) {
                return new String(arrby2);
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        public static byte[] encodeBytesToBytes(byte[] arrby, int n, int n2) {
            int n3;
            if (arrby == null) {
                throw new NullPointerException("Cannot serialize a null array.");
            }
            if (n < 0) {
                throw new IllegalArgumentException("Cannot have negative offset: " + n);
            }
            if (n2 < 0) {
                throw new IllegalArgumentException("Cannot have length offset: " + n2);
            }
            if (n + n2 > arrby.length) {
                Object[] arrobject = new Object[]{n, n2, arrby.length};
                throw new IllegalArgumentException(String.format((String)"Cannot have offset of %d and length of %d with array of length %d", (Object[])arrobject));
            }
            int n4 = 4 * (n2 / 3);
            int n5 = n2 % 3 > 0 ? 4 : 0;
            byte[] arrby2 = new byte[n4 + n5];
            int n6 = 0;
            int n7 = n2 - 2;
            for (n3 = 0; n3 < n7; n3 += 3, n6 += 4) {
                Base64.encode3to4(arrby, n3 + n, 3, arrby2, n6);
            }
            if (n3 < n2) {
                Base64.encode3to4(arrby, n3 + n, n2 - n3, arrby2, n6);
                n6 += 4;
            }
            if (n6 <= -1 + arrby2.length) {
                byte[] arrby3 = new byte[n6];
                System.arraycopy((Object)arrby2, (int)0, (Object)arrby3, (int)0, (int)n6);
                return arrby3;
            }
            return arrby2;
        }
    }

    protected static abstract class CloseOperation<V>
    extends Operation<V> {
        private final Closeable closeable;
        private final boolean ignoreCloseExceptions;

        protected CloseOperation(Closeable closeable, boolean bl) {
            this.closeable = closeable;
            this.ignoreCloseExceptions = bl;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        protected void done() throws IOException {
            if (this.closeable instanceof Flushable) {
                ((Flushable)this.closeable).flush();
            }
            if (!this.ignoreCloseExceptions) {
                this.closeable.close();
                return;
            }
            try {
                this.closeable.close();
                return;
            }
            catch (IOException iOException) {
                return;
            }
        }
    }

    public static interface ConnectionFactory {
        public static final ConnectionFactory DEFAULT = new ConnectionFactory(){

            @Override
            public HttpURLConnection create(URL uRL) throws IOException {
                return (HttpURLConnection)uRL.openConnection();
            }

            @Override
            public HttpURLConnection create(URL uRL, Proxy proxy) throws IOException {
                return (HttpURLConnection)uRL.openConnection(proxy);
            }
        };

        public HttpURLConnection create(URL var1) throws IOException;

        public HttpURLConnection create(URL var1, Proxy var2) throws IOException;

    }

    protected static abstract class FlushOperation<V>
    extends Operation<V> {
        private final Flushable flushable;

        protected FlushOperation(Flushable flushable) {
            this.flushable = flushable;
        }

        @Override
        protected void done() throws IOException {
            this.flushable.flush();
        }
    }

    public static class HttpRequestException
    extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        public HttpRequestException(IOException iOException) {
            super((Throwable)iOException);
        }

        public IOException getCause() {
            return (IOException)super.getCause();
        }
    }

    protected static abstract class Operation<V>
    implements Callable<V> {
        protected Operation() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public V call() throws HttpRequestException {
            V v;
            boolean bl = false;
            try {
                v = this.run();
            }
            catch (HttpRequestException var5_4) {
                bl = true;
                throw var5_4;
            }
            catch (IOException var2_6) {
                bl = true;
                throw new HttpRequestException(var2_6);
            }
            finally {
                this.done();
            }
            return v;
        }

        protected abstract void done() throws IOException;

        protected abstract V run() throws HttpRequestException, IOException;
    }

    public static class RequestOutputStream
    extends BufferedOutputStream {
        private final CharsetEncoder encoder;

        public RequestOutputStream(OutputStream outputStream, String string, int n) {
            super(outputStream, n);
            this.encoder = Charset.forName((String)HttpRequest.getValidCharset(string)).newEncoder();
        }

        public RequestOutputStream write(String string) throws IOException {
            ByteBuffer byteBuffer = this.encoder.encode(CharBuffer.wrap((CharSequence)string));
            super.write(byteBuffer.array(), 0, byteBuffer.limit());
            return this;
        }
    }

    public static interface UploadProgress {
        public static final UploadProgress DEFAULT = new UploadProgress(){

            @Override
            public void onUpload(long l, long l2) {
            }
        };

        public void onUpload(long var1, long var3);

    }

}

