package com.mba.proxylight;

import com.chelpus.Common;
import com.chelpus.Utils;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class RequestProcessor {
    private static final byte[] CONNECT_OK = "HTTP/1.0 200 Connection established\r\nProxy-agent: ProxyLight\r\n\r\n".getBytes();
    private static final String CRLF = "\r\n";
    private static long SOCKET_TIMEOUT = 15000;
    private static int processorsCount = 0;
    private static int processorsCpt = 1;
    private boolean alive;
    private Socket currentOutSocket;
    private String inData;
    private Socket inSocket;
    private String outData;
    private Map<String, Socket> outSockets;
    private int processorIdx;
    private ByteBuffer readBuffer;
    private char[] read_buf;
    int read_offset;
    private Selector selector;
    private boolean shutdown;
    private Thread t;

    private enum REQUEST_STEP {
        STATUS_LINE,
        REQUEST_HEADERS,
        REQUEST_CONTENT,
        TRANSFER
    }

    public abstract void debug(String str);

    public abstract void error(String str, Throwable th);

    public abstract String getRemoteProxyHost();

    public abstract int getRemoteProxyPort();

    public abstract List<RequestFilter> getRequestFilters();

    public abstract void recycle();

    public abstract InetAddress resolve(String str);

    static /* synthetic */ int access$008() {
        int i = processorsCount;
        processorsCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$010() {
        int i = processorsCount;
        processorsCount = i - 1;
        return i;
    }

    public RequestProcessor() throws IOException {
        this.t = null;
        this.alive = false;
        this.shutdown = false;
        this.processorIdx = 1;
        this.selector = null;
        this.readBuffer = ByteBuffer.allocate(Common.INSTALL_ALLOW_DOWNGRADE);
        this.inSocket = null;
        this.inData = "";
        this.outData = "";
        this.outSockets = new HashMap();
        this.currentOutSocket = null;
        this.read_buf = new char[Common.INSTALL_ALLOW_DOWNGRADE];
        this.read_offset = 0;
        this.t = new Thread(new Runnable() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r40 = this;
                com.mba.proxylight.RequestProcessor.access$008();
            L_0x0003:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r37 = r0;
                monitor-enter(r37);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x019d }
                r36 = r0;
                r38 = 1;
                r0 = r36;
                r1 = r38;
                r0.alive = r1;	 Catch:{ all -> 0x019d }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x019d }
                r36 = r0;
                r36 = r36.selector;	 Catch:{ all -> 0x019d }
                if (r36 != 0) goto L_0x0040;
            L_0x0025:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x019d }
                r36 = r0;
                r36 = r36.shutdown;	 Catch:{ all -> 0x019d }
                if (r36 != 0) goto L_0x0040;
            L_0x0031:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ InterruptedException -> 0x0082 }
                r36 = r0;
                r38 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
                r0 = r36;
                r1 = r38;
                r0.wait(r1);	 Catch:{ InterruptedException -> 0x0082 }
            L_0x0040:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x019d }
                r36 = r0;
                r36 = r36.shutdown;	 Catch:{ all -> 0x019d }
                if (r36 == 0) goto L_0x00c8;
            L_0x004c:
                monitor-exit(r37);	 Catch:{ all -> 0x019d }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r36 = r0;
                r36.closeAll();
                com.mba.proxylight.RequestProcessor.access$010();
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r36 = r0;
                r37 = new java.lang.StringBuilder;
                r37.<init>();
                r38 = "Fin du processor ";
                r37 = r37.append(r38);
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r38 = r0;
                r38 = r38.processorIdx;
                r37 = r37.append(r38);
                r37 = r37.toString();
                r38 = 0;
                r36.error(r37, r38);
            L_0x0081:
                return;
            L_0x0082:
                r8 = move-exception;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x019d }
                r36 = r0;
                r38 = 0;
                r0 = r36;
                r1 = r38;
                r0.error(r1, r8);	 Catch:{ all -> 0x019d }
                monitor-exit(r37);	 Catch:{ all -> 0x019d }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r36 = r0;
                r36.closeAll();
                com.mba.proxylight.RequestProcessor.access$010();
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r36 = r0;
                r37 = new java.lang.StringBuilder;
                r37.<init>();
                r38 = "Fin du processor ";
                r37 = r37.append(r38);
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r38 = r0;
                r38 = r38.processorIdx;
                r37 = r37.append(r38);
                r37 = r37.toString();
                r38 = 0;
                r36.error(r37, r38);
                goto L_0x0081;
            L_0x00c8:
                monitor-exit(r37);	 Catch:{ all -> 0x019d }
                r26 = 0;
                r7 = 0;
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.STATUS_LINE;	 Catch:{ Exception -> 0x033c }
            L_0x00ce:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.selector;	 Catch:{ Exception -> 0x033c }
                if (r36 == 0) goto L_0x00f9;
            L_0x00da:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.selector;	 Catch:{ Exception -> 0x033c }
                r38 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
                r0 = r36;
                r1 = r38;
                r0.select(r1);	 Catch:{ Exception -> 0x033c }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.inSocket;	 Catch:{ Exception -> 0x033c }
                if (r36 != 0) goto L_0x01a0;
            L_0x00f9:
                r36 = java.lang.System.out;	 Catch:{ all -> 0x0167 }
                r37 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0167 }
                r37.<init>();	 Catch:{ all -> 0x0167 }
                r38 = "inData:";
                r37 = r37.append(r38);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r38 = r0;
                r38 = r38.inData;	 Catch:{ all -> 0x0167 }
                r37 = r37.append(r38);	 Catch:{ all -> 0x0167 }
                r37 = r37.toString();	 Catch:{ all -> 0x0167 }
                r36.println(r37);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r36 = r0;
                r37 = "";
                r36.inData = r37;	 Catch:{ all -> 0x0167 }
                r36 = java.lang.System.out;	 Catch:{ all -> 0x0167 }
                r37 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0167 }
                r37.<init>();	 Catch:{ all -> 0x0167 }
                r38 = "outData:";
                r37 = r37.append(r38);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r38 = r0;
                r38 = r38.outData;	 Catch:{ all -> 0x0167 }
                r37 = r37.append(r38);	 Catch:{ all -> 0x0167 }
                r37 = r37.toString();	 Catch:{ all -> 0x0167 }
                r36.println(r37);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r36 = r0;
                r37 = "";
                r36.outData = r37;	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r36 = r0;
                r36.closeAll();	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r36 = r0;
                r36.recycle();	 Catch:{ all -> 0x0167 }
                goto L_0x0003;
            L_0x0167:
                r36 = move-exception;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r37 = r0;
                r37.closeAll();
                com.mba.proxylight.RequestProcessor.access$010();
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r37 = r0;
                r38 = new java.lang.StringBuilder;
                r38.<init>();
                r39 = "Fin du processor ";
                r38 = r38.append(r39);
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r39 = r0;
                r39 = r39.processorIdx;
                r38 = r38.append(r39);
                r38 = r38.toString();
                r39 = 0;
                r37.error(r38, r39);
                throw r36;
            L_0x019d:
                r36 = move-exception;
                monitor-exit(r37);	 Catch:{ all -> 0x019d }
                throw r36;	 Catch:{ all -> 0x0167 }
            L_0x01a0:
                r22 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x033c }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.selector;	 Catch:{ Exception -> 0x033c }
                r36 = r36.selectedKeys();	 Catch:{ Exception -> 0x033c }
                r36 = r36.size();	 Catch:{ Exception -> 0x033c }
                if (r36 != 0) goto L_0x027c;
            L_0x01b8:
                r36 = com.mba.proxylight.RequestProcessor.SOCKET_TIMEOUT;	 Catch:{ Exception -> 0x033c }
                r20 = r22 - r36;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.outSockets;	 Catch:{ Exception -> 0x033c }
                r36 = r36.entrySet();	 Catch:{ Exception -> 0x033c }
                r12 = r36.iterator();	 Catch:{ Exception -> 0x033c }
            L_0x01d0:
                r36 = r12.hasNext();	 Catch:{ Exception -> 0x033c }
                if (r36 == 0) goto L_0x0257;
            L_0x01d6:
                r9 = r12.next();	 Catch:{ Exception -> 0x033c }
                r9 = (java.util.Map.Entry) r9;	 Catch:{ Exception -> 0x033c }
                r32 = r9.getValue();	 Catch:{ Exception -> 0x033c }
                r32 = (com.mba.proxylight.Socket) r32;	 Catch:{ Exception -> 0x033c }
                r0 = r32;
                r0 = r0.lastRead;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r0 = r32;
                r0 = r0.lastWrite;	 Catch:{ Exception -> 0x033c }
                r38 = r0;
                r18 = java.lang.Math.max(r36, r38);	 Catch:{ Exception -> 0x033c }
                r36 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1));
                if (r36 >= 0) goto L_0x01d0;
            L_0x01f6:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r37 = r0;
                r36 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x033c }
                r36.<init>();	 Catch:{ Exception -> 0x033c }
                r38 = "processeur ";
                r0 = r36;
                r1 = r38;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x033c }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r38 = r0;
                r38 = r38.processorIdx;	 Catch:{ Exception -> 0x033c }
                r0 = r36;
                r1 = r38;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x033c }
                r38 = " : Fermeture pour inactivite de la socket vers ";
                r0 = r36;
                r1 = r38;
                r38 = r0.append(r1);	 Catch:{ Exception -> 0x033c }
                r36 = r9.getKey();	 Catch:{ Exception -> 0x033c }
                r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x033c }
                r0 = r38;
                r1 = r36;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x033c }
                r36 = r36.toString();	 Catch:{ Exception -> 0x033c }
                r0 = r37;
                r1 = r36;
                r0.debug(r1);	 Catch:{ Exception -> 0x033c }
                if (r26 == 0) goto L_0x03ba;
            L_0x0242:
                r36 = "CONNECT";
                r37 = r26.getMethod();	 Catch:{ Exception -> 0x033c }
                r36 = r36.equals(r37);	 Catch:{ Exception -> 0x033c }
                if (r36 == 0) goto L_0x03ba;
            L_0x024e:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36.closeAll();	 Catch:{ Exception -> 0x033c }
            L_0x0257:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.outSockets;	 Catch:{ Exception -> 0x033c }
                r36 = r36.size();	 Catch:{ Exception -> 0x033c }
                if (r36 != 0) goto L_0x0270;
            L_0x0267:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36.closeAll();	 Catch:{ Exception -> 0x033c }
            L_0x0270:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.inSocket;	 Catch:{ Exception -> 0x033c }
                if (r36 == 0) goto L_0x00f9;
            L_0x027c:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.selector;	 Catch:{ Exception -> 0x033c }
                r36 = r36.selectedKeys();	 Catch:{ Exception -> 0x033c }
                r29 = r36.iterator();	 Catch:{ Exception -> 0x033c }
            L_0x028e:
                r36 = r29.hasNext();	 Catch:{ Exception -> 0x033c }
                if (r36 == 0) goto L_0x00ce;
            L_0x0294:
                r16 = r29.next();	 Catch:{ Exception -> 0x033c }
                r16 = (java.nio.channels.SelectionKey) r16;	 Catch:{ Exception -> 0x033c }
                r29.remove();	 Catch:{ Exception -> 0x033c }
                r36 = r16.isValid();	 Catch:{ Exception -> 0x033c }
                if (r36 == 0) goto L_0x028e;
            L_0x02a3:
                r36 = r16.isReadable();	 Catch:{ Exception -> 0x033c }
                if (r36 == 0) goto L_0x028e;
            L_0x02a9:
                r33 = r16.attachment();	 Catch:{ Exception -> 0x033c }
                r33 = (com.mba.proxylight.Socket) r33;	 Catch:{ Exception -> 0x033c }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.inSocket;	 Catch:{ Exception -> 0x033c }
                r0 = r33;
                r1 = r36;
                if (r0 != r1) goto L_0x07b1;
            L_0x02bf:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.readBuffer;	 Catch:{ Exception -> 0x033c }
                r36.clear();	 Catch:{ Exception -> 0x033c }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r37 = r0;
                r37 = r37.inSocket;	 Catch:{ Exception -> 0x033c }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r38 = r0;
                r38 = r38.readBuffer;	 Catch:{ Exception -> 0x033c }
                r0 = r36;
                r1 = r37;
                r2 = r38;
                r3 = r22;
                r17 = r0.read(r1, r2, r3);	 Catch:{ Exception -> 0x033c }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r37 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x033c }
                r37.<init>();	 Catch:{ Exception -> 0x033c }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r38 = r0;
                r38 = r38.inData;	 Catch:{ Exception -> 0x033c }
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x033c }
                r38 = new java.lang.String;	 Catch:{ Exception -> 0x033c }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r39 = r0;
                r39 = r39.readBuffer;	 Catch:{ Exception -> 0x033c }
                r39 = r39.array();	 Catch:{ Exception -> 0x033c }
                r38.<init>(r39);	 Catch:{ Exception -> 0x033c }
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x033c }
                r37 = r37.toString();	 Catch:{ Exception -> 0x033c }
                r36.inData = r37;	 Catch:{ Exception -> 0x033c }
                r36 = -1;
                r0 = r17;
                r1 = r36;
                if (r0 != r1) goto L_0x0463;
            L_0x0331:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36.closeAll();	 Catch:{ Exception -> 0x033c }
                goto L_0x00ce;
            L_0x033c:
                r8 = move-exception;
            L_0x033d:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x03e3 }
                r36 = r0;
                r37 = 0;
                r0 = r36;
                r1 = r37;
                r0.error(r1, r8);	 Catch:{ all -> 0x03e3 }
                r36 = java.lang.System.out;	 Catch:{ all -> 0x0167 }
                r37 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0167 }
                r37.<init>();	 Catch:{ all -> 0x0167 }
                r38 = "inData:";
                r37 = r37.append(r38);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r38 = r0;
                r38 = r38.inData;	 Catch:{ all -> 0x0167 }
                r37 = r37.append(r38);	 Catch:{ all -> 0x0167 }
                r37 = r37.toString();	 Catch:{ all -> 0x0167 }
                r36.println(r37);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r36 = r0;
                r37 = "";
                r36.inData = r37;	 Catch:{ all -> 0x0167 }
                r36 = java.lang.System.out;	 Catch:{ all -> 0x0167 }
                r37 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0167 }
                r37.<init>();	 Catch:{ all -> 0x0167 }
                r38 = "outData:";
                r37 = r37.append(r38);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r38 = r0;
                r38 = r38.outData;	 Catch:{ all -> 0x0167 }
                r37 = r37.append(r38);	 Catch:{ all -> 0x0167 }
                r37 = r37.toString();	 Catch:{ all -> 0x0167 }
                r36.println(r37);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r36 = r0;
                r37 = "";
                r36.outData = r37;	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r36 = r0;
                r36.closeAll();	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r36 = r0;
                r36.recycle();	 Catch:{ all -> 0x0167 }
                goto L_0x0003;
            L_0x03ba:
                r12.remove();	 Catch:{ Exception -> 0x033c }
                r0 = r32;
                r0 = r0.socket;	 Catch:{ Exception -> 0x0451 }
                r36 = r0;
                r36.close();	 Catch:{ Exception -> 0x0451 }
            L_0x03c6:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.currentOutSocket;	 Catch:{ Exception -> 0x033c }
                r0 = r32;
                r1 = r36;
                if (r0 != r1) goto L_0x01d0;
            L_0x03d6:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r37 = 0;
                r36.currentOutSocket = r37;	 Catch:{ Exception -> 0x033c }
                goto L_0x01d0;
            L_0x03e3:
                r36 = move-exception;
                r37 = java.lang.System.out;	 Catch:{ all -> 0x0167 }
                r38 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0167 }
                r38.<init>();	 Catch:{ all -> 0x0167 }
                r39 = "inData:";
                r38 = r38.append(r39);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r39 = r0;
                r39 = r39.inData;	 Catch:{ all -> 0x0167 }
                r38 = r38.append(r39);	 Catch:{ all -> 0x0167 }
                r38 = r38.toString();	 Catch:{ all -> 0x0167 }
                r37.println(r38);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r37 = r0;
                r38 = "";
                r37.inData = r38;	 Catch:{ all -> 0x0167 }
                r37 = java.lang.System.out;	 Catch:{ all -> 0x0167 }
                r38 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0167 }
                r38.<init>();	 Catch:{ all -> 0x0167 }
                r39 = "outData:";
                r38 = r38.append(r39);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r39 = r0;
                r39 = r39.outData;	 Catch:{ all -> 0x0167 }
                r38 = r38.append(r39);	 Catch:{ all -> 0x0167 }
                r38 = r38.toString();	 Catch:{ all -> 0x0167 }
                r37.println(r38);	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r37 = r0;
                r38 = "";
                r37.outData = r38;	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r37 = r0;
                r37.closeAll();	 Catch:{ all -> 0x0167 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0167 }
                r37 = r0;
                r37.recycle();	 Catch:{ all -> 0x0167 }
                throw r36;	 Catch:{ all -> 0x0167 }
            L_0x0451:
                r10 = move-exception;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r37 = "";
                r0 = r36;
                r1 = r37;
                r0.error(r1, r10);	 Catch:{ Exception -> 0x033c }
                goto L_0x03c6;
            L_0x0463:
                if (r17 <= 0) goto L_0x028e;
            L_0x0465:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.readBuffer;	 Catch:{ Exception -> 0x033c }
                r36.flip();	 Catch:{ Exception -> 0x033c }
                r27 = r26;
            L_0x0474:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r36 = r36.readBuffer;	 Catch:{ Exception -> 0x04ef }
                r36 = r36.remaining();	 Catch:{ Exception -> 0x04ef }
                if (r36 <= 0) goto L_0x0823;
            L_0x0484:
                r36 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.STATUS_LINE;	 Catch:{ Exception -> 0x04ef }
                r0 = r34;
                r1 = r36;
                if (r0 != r1) goto L_0x04b3;
            L_0x048c:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r37 = r0;
                r37 = r37.readBuffer;	 Catch:{ Exception -> 0x04ef }
                r28 = r36.readNext(r37);	 Catch:{ Exception -> 0x04ef }
                if (r28 == 0) goto L_0x081f;
            L_0x04a2:
                r26 = new com.mba.proxylight.Request;	 Catch:{ Exception -> 0x04ef }
                r26.<init>();	 Catch:{ Exception -> 0x04ef }
                r0 = r26;
                r1 = r28;
                r0.setStatusline(r1);	 Catch:{ Exception -> 0x033c }
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.REQUEST_HEADERS;	 Catch:{ Exception -> 0x033c }
            L_0x04b0:
                r27 = r26;
                goto L_0x0474;
            L_0x04b3:
                r36 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.REQUEST_HEADERS;	 Catch:{ Exception -> 0x04ef }
                r0 = r34;
                r1 = r36;
                if (r0 != r1) goto L_0x0747;
            L_0x04bb:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r37 = r0;
                r37 = r37.readBuffer;	 Catch:{ Exception -> 0x04ef }
                r28 = r36.readNext(r37);	 Catch:{ Exception -> 0x04ef }
                if (r28 == 0) goto L_0x0474;
            L_0x04d1:
                r36 = r28.length();	 Catch:{ Exception -> 0x04ef }
                if (r36 != 0) goto L_0x0742;
            L_0x04d7:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r0 = r36;
                r1 = r27;
                r36 = r0.filterRequest(r1);	 Catch:{ Exception -> 0x04ef }
                if (r36 == 0) goto L_0x04f4;
            L_0x04e7:
                r36 = new java.lang.Exception;	 Catch:{ Exception -> 0x04ef }
                r37 = "Requete interdite.";
                r36.<init>(r37);	 Catch:{ Exception -> 0x04ef }
                throw r36;	 Catch:{ Exception -> 0x04ef }
            L_0x04ef:
                r8 = move-exception;
                r26 = r27;
                goto L_0x033d;
            L_0x04f4:
                r36 = "GET";
                r37 = r27.getMethod();	 Catch:{ Exception -> 0x04ef }
                r14 = r36.equals(r37);	 Catch:{ Exception -> 0x04ef }
                if (r14 != 0) goto L_0x0541;
            L_0x0500:
                r36 = "POST";
                r37 = r27.getMethod();	 Catch:{ Exception -> 0x04ef }
                r36 = r36.equals(r37);	 Catch:{ Exception -> 0x04ef }
                if (r36 == 0) goto L_0x0541;
            L_0x050c:
                r15 = 1;
            L_0x050d:
                if (r14 != 0) goto L_0x0543;
            L_0x050f:
                if (r15 != 0) goto L_0x0543;
            L_0x0511:
                r36 = "CONNECT";
                r37 = r27.getMethod();	 Catch:{ Exception -> 0x04ef }
                r36 = r36.equals(r37);	 Catch:{ Exception -> 0x04ef }
                if (r36 == 0) goto L_0x0543;
            L_0x051d:
                r13 = 1;
            L_0x051e:
                if (r14 != 0) goto L_0x0545;
            L_0x0520:
                if (r15 != 0) goto L_0x0545;
            L_0x0522:
                if (r13 != 0) goto L_0x0545;
            L_0x0524:
                r36 = new java.lang.RuntimeException;	 Catch:{ Exception -> 0x04ef }
                r37 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ef }
                r37.<init>();	 Catch:{ Exception -> 0x04ef }
                r38 = "Unknown method : ";
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ef }
                r38 = r27.getMethod();	 Catch:{ Exception -> 0x04ef }
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ef }
                r37 = r37.toString();	 Catch:{ Exception -> 0x04ef }
                r36.<init>(r37);	 Catch:{ Exception -> 0x04ef }
                throw r36;	 Catch:{ Exception -> 0x04ef }
            L_0x0541:
                r15 = 0;
                goto L_0x050d;
            L_0x0543:
                r13 = 0;
                goto L_0x051e;
            L_0x0545:
                r36 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ef }
                r36.<init>();	 Catch:{ Exception -> 0x04ef }
                r37 = r27.getHost();	 Catch:{ Exception -> 0x04ef }
                r36 = r36.append(r37);	 Catch:{ Exception -> 0x04ef }
                r37 = ":";
                r36 = r36.append(r37);	 Catch:{ Exception -> 0x04ef }
                r37 = r27.getPort();	 Catch:{ Exception -> 0x04ef }
                r36 = r36.append(r37);	 Catch:{ Exception -> 0x04ef }
                r24 = r36.toString();	 Catch:{ Exception -> 0x04ef }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r36 = r36.outSockets;	 Catch:{ Exception -> 0x04ef }
                r0 = r36;
                r1 = r24;
                r25 = r0.get(r1);	 Catch:{ Exception -> 0x04ef }
                r25 = (com.mba.proxylight.Socket) r25;	 Catch:{ Exception -> 0x04ef }
                if (r25 != 0) goto L_0x0644;
            L_0x057a:
                r25 = new com.mba.proxylight.Socket;	 Catch:{ Exception -> 0x04ef }
                r25.<init>();	 Catch:{ Exception -> 0x04ef }
                r36 = java.nio.channels.SocketChannel.open();	 Catch:{ Exception -> 0x04ef }
                r0 = r36;
                r1 = r25;
                r1.socket = r0;	 Catch:{ Exception -> 0x04ef }
                r0 = r25;
                r0 = r0.socket;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r37 = 0;
                r36.configureBlocking(r37);	 Catch:{ Exception -> 0x04ef }
                r0 = r25;
                r0 = r0.socket;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r37 = new java.net.InetSocketAddress;	 Catch:{ Exception -> 0x04ef }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r38 = r0;
                r39 = r27.getHost();	 Catch:{ Exception -> 0x04ef }
                r38 = r38.resolve(r39);	 Catch:{ Exception -> 0x04ef }
                r39 = r27.getPort();	 Catch:{ Exception -> 0x04ef }
                r37.<init>(r38, r39);	 Catch:{ Exception -> 0x04ef }
                r36 = r36.connect(r37);	 Catch:{ Exception -> 0x04ef }
                if (r36 != 0) goto L_0x05c8;
            L_0x05b7:
                r36 = 50;
                java.lang.Thread.sleep(r36);	 Catch:{ Exception -> 0x04ef }
                r0 = r25;
                r0 = r0.socket;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r36 = r36.finishConnect();	 Catch:{ Exception -> 0x04ef }
                if (r36 == 0) goto L_0x05b7;
            L_0x05c8:
                r0 = r25;
                r0 = r0.socket;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r37 = r0;
                r37 = r37.selector;	 Catch:{ Exception -> 0x04ef }
                r38 = 1;
                r0 = r36;
                r1 = r37;
                r2 = r38;
                r3 = r25;
                r0.register(r1, r2, r3);	 Catch:{ Exception -> 0x04ef }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r36 = r36.outSockets;	 Catch:{ Exception -> 0x04ef }
                r0 = r36;
                r1 = r24;
                r2 = r25;
                r0.put(r1, r2);	 Catch:{ Exception -> 0x04ef }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r37 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ef }
                r37.<init>();	 Catch:{ Exception -> 0x04ef }
                r38 = "Ajout d'une socket vers ";
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ef }
                r0 = r37;
                r1 = r24;
                r37 = r0.append(r1);	 Catch:{ Exception -> 0x04ef }
                r38 = " sur le processeur ";
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ef }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r38 = r0;
                r38 = r38.processorIdx;	 Catch:{ Exception -> 0x04ef }
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ef }
                r38 = ". Socket count=";
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ef }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r38 = r0;
                r38 = r38.outSockets;	 Catch:{ Exception -> 0x04ef }
                r38 = r38.size();	 Catch:{ Exception -> 0x04ef }
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ef }
                r37 = r37.toString();	 Catch:{ Exception -> 0x04ef }
                r36.debug(r37);	 Catch:{ Exception -> 0x04ef }
            L_0x0644:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r0 = r36;
                r1 = r25;
                r0.currentOutSocket = r1;	 Catch:{ Exception -> 0x04ef }
                if (r13 == 0) goto L_0x0678;
            L_0x0653:
                r36 = com.mba.proxylight.RequestProcessor.CONNECT_OK;	 Catch:{ Exception -> 0x04ef }
                r6 = java.nio.ByteBuffer.wrap(r36);	 Catch:{ Exception -> 0x04ef }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r37 = r0;
                r37 = r37.inSocket;	 Catch:{ Exception -> 0x04ef }
                r0 = r36;
                r1 = r37;
                r2 = r22;
                r0.write(r1, r6, r2);	 Catch:{ Exception -> 0x04ef }
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.TRANSFER;	 Catch:{ Exception -> 0x04ef }
                goto L_0x0474;
            L_0x0678:
                r36 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x04ef }
                r37 = r27.getMethod();	 Catch:{ Exception -> 0x04ef }
                r36.<init>(r37);	 Catch:{ Exception -> 0x04ef }
                r37 = " ";
                r30 = r36.append(r37);	 Catch:{ Exception -> 0x04ef }
                r35 = r27.getUrl();	 Catch:{ Exception -> 0x04ef }
                r36 = "/";
                r36 = r35.startsWith(r36);	 Catch:{ Exception -> 0x04ef }
                if (r36 != 0) goto L_0x069f;
            L_0x0693:
                r36 = 47;
                r37 = 8;
                r36 = r35.indexOf(r36, r37);	 Catch:{ Exception -> 0x04ef }
                r35 = r35.substring(r36);	 Catch:{ Exception -> 0x04ef }
            L_0x069f:
                r0 = r30;
                r1 = r35;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x04ef }
                r37 = " ";
                r36 = r36.append(r37);	 Catch:{ Exception -> 0x04ef }
                r37 = r27.getProtocol();	 Catch:{ Exception -> 0x04ef }
                r36 = r36.append(r37);	 Catch:{ Exception -> 0x04ef }
                r37 = "\r\n";
                r36.append(r37);	 Catch:{ Exception -> 0x04ef }
                r36 = r27.getHeaders();	 Catch:{ Exception -> 0x04ef }
                r36 = r36.entrySet();	 Catch:{ Exception -> 0x04ef }
                r37 = r36.iterator();	 Catch:{ Exception -> 0x04ef }
            L_0x06c6:
                r36 = r37.hasNext();	 Catch:{ Exception -> 0x04ef }
                if (r36 == 0) goto L_0x0702;
            L_0x06cc:
                r11 = r37.next();	 Catch:{ Exception -> 0x04ef }
                r11 = (java.util.Map.Entry) r11;	 Catch:{ Exception -> 0x04ef }
                r36 = r11.getKey();	 Catch:{ Exception -> 0x04ef }
                r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x04ef }
                r0 = r30;
                r1 = r36;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x04ef }
                r38 = ": ";
                r0 = r36;
                r1 = r38;
                r38 = r0.append(r1);	 Catch:{ Exception -> 0x04ef }
                r36 = r11.getValue();	 Catch:{ Exception -> 0x04ef }
                r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x04ef }
                r0 = r38;
                r1 = r36;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x04ef }
                r38 = "\r\n";
                r0 = r36;
                r1 = r38;
                r0.append(r1);	 Catch:{ Exception -> 0x04ef }
                goto L_0x06c6;
            L_0x0702:
                r36 = "\r\n";
                r0 = r30;
                r1 = r36;
                r0.append(r1);	 Catch:{ Exception -> 0x04ef }
                r36 = r30.toString();	 Catch:{ Exception -> 0x04ef }
                r31 = r36.getBytes();	 Catch:{ Exception -> 0x04ef }
                r6 = java.nio.ByteBuffer.wrap(r31);	 Catch:{ Exception -> 0x04ef }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r0 = r36;
                r1 = r25;
                r2 = r22;
                r0.write(r1, r6, r2);	 Catch:{ Exception -> 0x04ef }
                r7 = 0;
                if (r15 == 0) goto L_0x0739;
            L_0x0729:
                r36 = r27.getHeaders();	 Catch:{ Exception -> 0x04ef }
                r37 = "Content-Length";
                r36 = r36.get(r37);	 Catch:{ Exception -> 0x04ef }
                r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x04ef }
                r7 = java.lang.Integer.parseInt(r36);	 Catch:{ Exception -> 0x04ef }
            L_0x0739:
                if (r7 != 0) goto L_0x073f;
            L_0x073b:
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.STATUS_LINE;	 Catch:{ Exception -> 0x04ef }
            L_0x073d:
                goto L_0x0474;
            L_0x073f:
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.REQUEST_CONTENT;	 Catch:{ Exception -> 0x04ef }
                goto L_0x073d;
            L_0x0742:
                r27.addHeader(r28);	 Catch:{ Exception -> 0x04ef }
                goto L_0x0474;
            L_0x0747:
                r36 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.REQUEST_CONTENT;	 Catch:{ Exception -> 0x04ef }
                r0 = r34;
                r1 = r36;
                if (r0 != r1) goto L_0x0782;
            L_0x074f:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r36 = r36.readBuffer;	 Catch:{ Exception -> 0x04ef }
                r36 = r36.remaining();	 Catch:{ Exception -> 0x04ef }
                r7 = r7 - r36;
                if (r7 > 0) goto L_0x0763;
            L_0x0761:
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.STATUS_LINE;	 Catch:{ Exception -> 0x04ef }
            L_0x0763:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r36 = r36.currentOutSocket;	 Catch:{ Exception -> 0x04ef }
                r0 = r36;
                r0 = r0.socket;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r37 = r0;
                r37 = r37.readBuffer;	 Catch:{ Exception -> 0x04ef }
                r36.write(r37);	 Catch:{ Exception -> 0x04ef }
                goto L_0x0474;
            L_0x0782:
                r36 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.TRANSFER;	 Catch:{ Exception -> 0x04ef }
                r0 = r34;
                r1 = r36;
                if (r0 != r1) goto L_0x0474;
            L_0x078a:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r37 = r0;
                r37 = r37.currentOutSocket;	 Catch:{ Exception -> 0x04ef }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ef }
                r38 = r0;
                r38 = r38.readBuffer;	 Catch:{ Exception -> 0x04ef }
                r0 = r36;
                r1 = r37;
                r2 = r38;
                r3 = r22;
                r0.write(r1, r2, r3);	 Catch:{ Exception -> 0x04ef }
                goto L_0x0474;
            L_0x07b1:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36 = r36.currentOutSocket;	 Catch:{ Exception -> 0x033c }
                r0 = r33;
                r1 = r36;
                if (r0 == r1) goto L_0x07d0;
            L_0x07c1:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r0 = r36;
                r1 = r33;
                r0.closeOutSocket(r1);	 Catch:{ Exception -> 0x033c }
                goto L_0x028e;
            L_0x07d0:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r37 = r0;
                r37 = r37.inSocket;	 Catch:{ Exception -> 0x033c }
                r0 = r36;
                r1 = r33;
                r2 = r37;
                r3 = r22;
                r36 = r0.transfer(r1, r2, r3);	 Catch:{ Exception -> 0x033c }
                if (r36 != 0) goto L_0x028e;
            L_0x07ee:
                r36 = "CONNECT";
                r37 = r26.getMethod();	 Catch:{ Exception -> 0x033c }
                r36 = r36.equals(r37);	 Catch:{ Exception -> 0x033c }
                if (r36 == 0) goto L_0x0805;
            L_0x07fa:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r36.closeAll();	 Catch:{ Exception -> 0x033c }
                goto L_0x00ce;
            L_0x0805:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r0 = r36;
                r1 = r33;
                r0.closeOutSocket(r1);	 Catch:{ Exception -> 0x033c }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x033c }
                r36 = r0;
                r37 = 0;
                r36.currentOutSocket = r37;	 Catch:{ Exception -> 0x033c }
                goto L_0x00ce;
            L_0x081f:
                r26 = r27;
                goto L_0x04b0;
            L_0x0823:
                r26 = r27;
                goto L_0x028e;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mba.proxylight.RequestProcessor.1.run():void");
            }
        });
        Thread thread = this.t;
        StringBuilder append = new StringBuilder().append("ProxyLight processor - ");
        int i = processorsCpt;
        processorsCpt = i + 1;
        this.processorIdx = i;
        thread.setName(append.append(i).toString());
        this.t.setDaemon(true);
        this.t.start();
        while (!isAlive()) {
            new Utils("w").waitLP(50);
        }
        debug("Processeur " + this.processorIdx + " demarre.");
    }

    private void write(Socket socket, ByteBuffer b, long when) throws IOException {
        socket.socket.write(b);
        socket.lastWrite = when;
    }

    private int read(Socket socket, ByteBuffer b, long when) throws IOException {
        int retour = socket.socket.read(b);
        if (retour > 0) {
            socket.lastWrite = when;
        }
        return retour;
    }

    private void closeOutSocket(Socket out) {
        try {
            for (Entry<String, Socket> e : this.outSockets.entrySet()) {
                if (e.getValue() == out) {
                    this.outSockets.remove(e.getKey());
                    debug("Fermeture de la socket vers " + ((String) e.getKey()));
                    break;
                }
            }
            if (out.socket.isOpen()) {
                out.socket.close();
            }
        } catch (Exception e2) {
            error("", e2);
        }
    }

    private void closeAll() {
        if (this.inSocket != null) {
            try {
                this.inSocket.socket.close();
            } catch (Exception e) {
                error(null, e);
            }
            this.inSocket = null;
        }
        for (Socket outSocket : this.outSockets.values()) {
            try {
                outSocket.socket.close();
            } catch (Exception e2) {
                error(null, e2);
            }
        }
        this.outSockets.clear();
        this.currentOutSocket = null;
        if (this.selector != null) {
            try {
                this.selector.wakeup();
            } catch (Exception e22) {
                error(null, e22);
            }
            this.selector = null;
        }
    }

    private boolean transfer(Socket inSocket, Socket outSocket, long when) throws IOException {
        this.readBuffer.clear();
        int numRead = read(inSocket, this.readBuffer, when);
        if (numRead == -1) {
            return false;
        }
        if (numRead > 0) {
            this.readBuffer.flip();
            write(outSocket, this.readBuffer, when);
        }
        return true;
    }

    public void process(SelectionKey key) throws IOException {
        synchronized (this) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            this.inSocket = new Socket();
            this.inSocket.socket = serverSocketChannel.accept();
            this.inSocket.socket.configureBlocking(false);
            this.selector = SelectorProvider.provider().openSelector();
            this.inSocket.socket.register(this.selector, 1, this.inSocket);
            notify();
        }
    }

    private String readNext(ByteBuffer buffer) throws IOException {
        boolean atCR = false;
        while (buffer.remaining() > 0) {
            int ch = buffer.get();
            if (ch == -1 || ch == 10) {
                atCR = true;
                break;
            } else if (ch != 13) {
                if (this.read_offset == this.read_buf.length) {
                    char[] tmpbuf = this.read_buf;
                    this.read_buf = new char[(tmpbuf.length * 2)];
                    System.arraycopy(tmpbuf, 0, this.read_buf, 0, this.read_offset);
                }
                char[] cArr = this.read_buf;
                int i = this.read_offset;
                this.read_offset = i + 1;
                cArr[i] = (char) ch;
            }
        }
        if (!atCR) {
            return null;
        }
        String s = String.copyValueOf(this.read_buf, 0, this.read_offset);
        this.read_offset = 0;
        return s;
    }

    public void shutdown() {
        closeAll();
        this.shutdown = true;
        synchronized (this) {
            notify();
        }
    }

    public boolean isAlive() {
        return this.alive;
    }

    private boolean filterRequest(Request request) {
        List<RequestFilter> filters = getRequestFilters();
        if (filters.size() > 0) {
            for (int i = 0; i < filters.size(); i++) {
                if (((RequestFilter) filters.get(i)).filter(request)) {
                    return true;
                }
            }
        }
        return false;
    }
}
