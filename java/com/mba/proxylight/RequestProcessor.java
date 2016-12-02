/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.InetAddress
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.SelectableChannel
 *  java.nio.channels.SelectionKey
 *  java.nio.channels.Selector
 *  java.nio.channels.ServerSocketChannel
 *  java.nio.channels.SocketChannel
 *  java.nio.channels.spi.AbstractSelector
 *  java.nio.channels.spi.SelectorProvider
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.mba.proxylight;

import com.chelpus.Utils;
import com.mba.proxylight.Request;
import com.mba.proxylight.RequestFilter;
import com.mba.proxylight.Socket;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class RequestProcessor {
    private static final byte[] CONNECT_OK;
    private static final String CRLF = "\r\n";
    private static long SOCKET_TIMEOUT;
    private static int processorsCount;
    private static int processorsCpt;
    private boolean alive = false;
    private Socket currentOutSocket = null;
    private String inData = "";
    private Socket inSocket = null;
    private String outData = "";
    private Map<String, Socket> outSockets = new HashMap();
    private int processorIdx = 1;
    private ByteBuffer readBuffer = ByteBuffer.allocate((int)128);
    private char[] read_buf = new char[128];
    int read_offset = 0;
    private Selector selector = null;
    private boolean shutdown = false;
    private Thread t = null;

    static {
        processorsCpt = 1;
        processorsCount = 0;
        SOCKET_TIMEOUT = 15000;
        CONNECT_OK = "HTTP/1.0 200 Connection established\r\nProxy-agent: ProxyLight\r\n\r\n".getBytes();
    }

    public RequestProcessor() throws IOException {
        Thread thread = this.t = new Thread(new Runnable(){

            /*
             * Exception decompiling
             */
            public void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl114 : TryStatement: try { 20[TRYBLOCK]

                // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
                // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.RemoveDeterministicJumps.apply(RemoveDeterministicJumps.java:35)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:507)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
                // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
                // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
                // org.benf.cfr.reader.Main.doJar(Main.java:128)
                // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
                // java.lang.Thread.run(Thread.java:818)
                throw new IllegalStateException("Decompilation failed");
            }
        });
        StringBuilder stringBuilder = new StringBuilder().append("ProxyLight processor - ");
        int n = processorsCpt;
        processorsCpt = n + 1;
        this.processorIdx = n;
        thread.setName(stringBuilder.append(n).toString());
        this.t.setDaemon(true);
        this.t.start();
        while (!this.isAlive()) {
            new Utils("w").waitLP(50);
        }
        this.debug("Processeur " + this.processorIdx + " demarre.");
    }

    static /* synthetic */ int access$008() {
        int n = processorsCount;
        processorsCount = n + 1;
        return n;
    }

    static /* synthetic */ int access$010() {
        int n = processorsCount;
        processorsCount = n - 1;
        return n;
    }

    static /* synthetic */ ByteBuffer access$1000(RequestProcessor requestProcessor) {
        return requestProcessor.readBuffer;
    }

    static /* synthetic */ boolean access$102(RequestProcessor requestProcessor, boolean bl) {
        requestProcessor.alive = bl;
        return bl;
    }

    static /* synthetic */ int access$1100(RequestProcessor requestProcessor, Socket socket, ByteBuffer byteBuffer, long l) throws IOException {
        return requestProcessor.read(socket, byteBuffer, l);
    }

    static /* synthetic */ String access$1200(RequestProcessor requestProcessor) {
        return requestProcessor.inData;
    }

    static /* synthetic */ String access$1202(RequestProcessor requestProcessor, String string) {
        requestProcessor.inData = string;
        return string;
    }

    static /* synthetic */ String access$1300(RequestProcessor requestProcessor, ByteBuffer byteBuffer) throws IOException {
        return requestProcessor.readNext(byteBuffer);
    }

    static /* synthetic */ boolean access$1400(RequestProcessor requestProcessor, Request request) {
        return requestProcessor.filterRequest(request);
    }

    static /* synthetic */ byte[] access$1500() {
        return CONNECT_OK;
    }

    static /* synthetic */ void access$1600(RequestProcessor requestProcessor, Socket socket, ByteBuffer byteBuffer, long l) throws IOException {
        requestProcessor.write(socket, byteBuffer, l);
    }

    static /* synthetic */ void access$1700(RequestProcessor requestProcessor, Socket socket) {
        requestProcessor.closeOutSocket(socket);
    }

    static /* synthetic */ boolean access$1800(RequestProcessor requestProcessor, Socket socket, Socket socket2, long l) throws IOException {
        return requestProcessor.transfer(socket, socket2, l);
    }

    static /* synthetic */ String access$1900(RequestProcessor requestProcessor) {
        return requestProcessor.outData;
    }

    static /* synthetic */ String access$1902(RequestProcessor requestProcessor, String string) {
        requestProcessor.outData = string;
        return string;
    }

    static /* synthetic */ Selector access$200(RequestProcessor requestProcessor) {
        return requestProcessor.selector;
    }

    static /* synthetic */ boolean access$300(RequestProcessor requestProcessor) {
        return requestProcessor.shutdown;
    }

    static /* synthetic */ Socket access$400(RequestProcessor requestProcessor) {
        return requestProcessor.inSocket;
    }

    static /* synthetic */ long access$500() {
        return SOCKET_TIMEOUT;
    }

    static /* synthetic */ Map access$600(RequestProcessor requestProcessor) {
        return requestProcessor.outSockets;
    }

    static /* synthetic */ int access$700(RequestProcessor requestProcessor) {
        return requestProcessor.processorIdx;
    }

    static /* synthetic */ void access$800(RequestProcessor requestProcessor) {
        requestProcessor.closeAll();
    }

    static /* synthetic */ Socket access$900(RequestProcessor requestProcessor) {
        return requestProcessor.currentOutSocket;
    }

    static /* synthetic */ Socket access$902(RequestProcessor requestProcessor, Socket socket) {
        requestProcessor.currentOutSocket = socket;
        return socket;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void closeAll() {
        if (this.inSocket != null) {
            try {
                this.inSocket.socket.close();
            }
            catch (Exception var6_1) {
                this.error(null, (Throwable)var6_1);
            }
            this.inSocket = null;
        }
        for (Socket socket : this.outSockets.values()) {
            try {
                socket.socket.close();
            }
            catch (Exception var5_4) {
                this.error(null, (Throwable)var5_4);
            }
        }
        this.outSockets.clear();
        this.currentOutSocket = null;
        if (this.selector != null) {
            try {
                this.selector.wakeup();
            }
            catch (Exception var2_5) {
                this.error(null, (Throwable)var2_5);
            }
            this.selector = null;
        }
    }

    private void closeOutSocket(Socket socket) {
        try {
            for (Map.Entry entry : this.outSockets.entrySet()) {
                if (entry.getValue() != socket) continue;
                this.outSockets.remove(entry.getKey());
                this.debug("Fermeture de la socket vers " + (String)entry.getKey());
                break;
            }
            if (socket.socket.isOpen()) {
                socket.socket.close();
            }
            return;
        }
        catch (Exception var2_4) {
            this.error("", (Throwable)var2_4);
            return;
        }
    }

    private boolean filterRequest(Request request) {
        List<RequestFilter> list = this.getRequestFilters();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); ++i) {
                if (!((RequestFilter)list.get(i)).filter(request)) continue;
                return true;
            }
        }
        return false;
    }

    private int read(Socket socket, ByteBuffer byteBuffer, long l) throws IOException {
        int n = socket.socket.read(byteBuffer);
        if (n > 0) {
            socket.lastWrite = l;
        }
        return n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String readNext(ByteBuffer byteBuffer) throws IOException {
        do {
            int n = byteBuffer.remaining();
            boolean bl = false;
            if (n <= 0) return null;
            byte by = byteBuffer.get();
            if (by == -1 || by == 10) {
                bl = true;
                if (bl) break;
                return null;
            }
            if (by == 13) continue;
            if (this.read_offset == this.read_buf.length) {
                char[] arrc = this.read_buf;
                this.read_buf = new char[2 * arrc.length];
                System.arraycopy((Object)arrc, (int)0, (Object)this.read_buf, (int)0, (int)this.read_offset);
            }
            char[] arrc = this.read_buf;
            int n2 = this.read_offset;
            this.read_offset = n2 + 1;
            arrc[n2] = (char)by;
        } while (true);
        String string = String.copyValueOf((char[])this.read_buf, (int)0, (int)this.read_offset);
        this.read_offset = 0;
        return string;
    }

    private boolean transfer(Socket socket, Socket socket2, long l) throws IOException {
        this.readBuffer.clear();
        int n = super.read(socket, this.readBuffer, l);
        if (n == -1) {
            return false;
        }
        if (n > 0) {
            this.readBuffer.flip();
            super.write(socket2, this.readBuffer, l);
        }
        return true;
    }

    private void write(Socket socket, ByteBuffer byteBuffer, long l) throws IOException {
        socket.socket.write(byteBuffer);
        socket.lastWrite = l;
    }

    public abstract void debug(String var1);

    public abstract void error(String var1, Throwable var2);

    public abstract String getRemoteProxyHost();

    public abstract int getRemoteProxyPort();

    public abstract List<RequestFilter> getRequestFilters();

    public boolean isAlive() {
        return this.alive;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void process(SelectionKey selectionKey) throws IOException {
        void var6_2 = this;
        synchronized (var6_2) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
            this.inSocket = new Socket();
            this.inSocket.socket = serverSocketChannel.accept();
            this.inSocket.socket.configureBlocking(false);
            this.selector = SelectorProvider.provider().openSelector();
            this.inSocket.socket.register(this.selector, 1, (Object)this.inSocket);
            this.notify();
            return;
        }
    }

    public abstract void recycle();

    public abstract InetAddress resolve(String var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void shutdown() {
        this.closeAll();
        this.shutdown = true;
        RequestProcessor requestProcessor = this;
        synchronized (requestProcessor) {
            this.notify();
            return;
        }
    }

    private static final class REQUEST_STEP
    extends Enum<REQUEST_STEP> {
        private static final /* synthetic */ REQUEST_STEP[] $VALUES;
        public static final /* enum */ REQUEST_STEP REQUEST_CONTENT;
        public static final /* enum */ REQUEST_STEP REQUEST_HEADERS;
        public static final /* enum */ REQUEST_STEP STATUS_LINE;
        public static final /* enum */ REQUEST_STEP TRANSFER;

        static {
            STATUS_LINE = new REQUEST_STEP();
            REQUEST_HEADERS = new REQUEST_STEP();
            REQUEST_CONTENT = new REQUEST_STEP();
            TRANSFER = new REQUEST_STEP();
            REQUEST_STEP[] arrrEQUEST_STEP = new REQUEST_STEP[]{STATUS_LINE, REQUEST_HEADERS, REQUEST_CONTENT, TRANSFER};
            $VALUES = arrrEQUEST_STEP;
        }

        private REQUEST_STEP() {
            super(string, n);
        }

        public static REQUEST_STEP valueOf(String string) {
            return (REQUEST_STEP)Enum.valueOf((Class)REQUEST_STEP.class, (String)string);
        }

        public static REQUEST_STEP[] values() {
            return (REQUEST_STEP[])$VALUES.clone();
        }
    }

}

