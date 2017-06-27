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
                r36 = com.mba.proxylight.RequestProcessor.processorsCount;
                r36 = r36 + 1;
                com.mba.proxylight.RequestProcessor.processorsCount = r36;
            L_0x0009:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r37 = r0;
                monitor-enter(r37);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0182 }
                r36 = r0;
                r38 = 1;
                r0 = r36;
                r1 = r38;
                r0.alive = r1;	 Catch:{ all -> 0x0182 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0182 }
                r36 = r0;
                r36 = r36.selector;	 Catch:{ all -> 0x0182 }
                if (r36 != 0) goto L_0x0046;
            L_0x002b:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0182 }
                r36 = r0;
                r36 = r36.shutdown;	 Catch:{ all -> 0x0182 }
                if (r36 != 0) goto L_0x0046;
            L_0x0037:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ InterruptedException -> 0x008a }
                r36 = r0;
                r38 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
                r0 = r36;
                r1 = r38;
                r0.wait(r1);	 Catch:{ InterruptedException -> 0x008a }
            L_0x0046:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0182 }
                r36 = r0;
                r36 = r36.shutdown;	 Catch:{ all -> 0x0182 }
                if (r36 == 0) goto L_0x00d2;
            L_0x0052:
                monitor-exit(r37);	 Catch:{ all -> 0x0182 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r36 = r0;
                r36.closeAll();
                r36 = com.mba.proxylight.RequestProcessor.processorsCount;
                r36 = r36 + -1;
                com.mba.proxylight.RequestProcessor.processorsCount = r36;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r36 = r0;
                r37 = new java.lang.StringBuilder;
                r38 = "Fin du processor ";
                r37.<init>(r38);
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r38 = r0;
                r38 = r38.processorIdx;
                r37 = r37.append(r38);
                r37 = r37.toString();
                r38 = 0;
                r36.error(r37, r38);
            L_0x0089:
                return;
            L_0x008a:
                r8 = move-exception;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x0182 }
                r36 = r0;
                r38 = 0;
                r0 = r36;
                r1 = r38;
                r0.error(r1, r8);	 Catch:{ all -> 0x0182 }
                monitor-exit(r37);	 Catch:{ all -> 0x0182 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r36 = r0;
                r36.closeAll();
                r36 = com.mba.proxylight.RequestProcessor.processorsCount;
                r36 = r36 + -1;
                com.mba.proxylight.RequestProcessor.processorsCount = r36;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r36 = r0;
                r37 = new java.lang.StringBuilder;
                r38 = "Fin du processor ";
                r37.<init>(r38);
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r38 = r0;
                r38 = r38.processorIdx;
                r37 = r37.append(r38);
                r37 = r37.toString();
                r38 = 0;
                r36.error(r37, r38);
                goto L_0x0089;
            L_0x00d2:
                monitor-exit(r37);	 Catch:{ all -> 0x0182 }
                r26 = 0;
                r7 = 0;
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.STATUS_LINE;	 Catch:{ Exception -> 0x02c5 }
            L_0x00d8:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.selector;	 Catch:{ Exception -> 0x02c5 }
                if (r36 != 0) goto L_0x0185;
            L_0x00e4:
                r36 = java.lang.System.out;	 Catch:{ all -> 0x014a }
                r37 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014a }
                r38 = "inData:";
                r37.<init>(r38);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r38 = r0;
                r38 = r38.inData;	 Catch:{ all -> 0x014a }
                r37 = r37.append(r38);	 Catch:{ all -> 0x014a }
                r37 = r37.toString();	 Catch:{ all -> 0x014a }
                r36.println(r37);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r36 = r0;
                r37 = "";
                r36.inData = r37;	 Catch:{ all -> 0x014a }
                r36 = java.lang.System.out;	 Catch:{ all -> 0x014a }
                r37 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014a }
                r38 = "outData:";
                r37.<init>(r38);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r38 = r0;
                r38 = r38.outData;	 Catch:{ all -> 0x014a }
                r37 = r37.append(r38);	 Catch:{ all -> 0x014a }
                r37 = r37.toString();	 Catch:{ all -> 0x014a }
                r36.println(r37);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r36 = r0;
                r37 = "";
                r36.outData = r37;	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r36 = r0;
                r36.closeAll();	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r36 = r0;
                r36.recycle();	 Catch:{ all -> 0x014a }
                goto L_0x0009;
            L_0x014a:
                r36 = move-exception;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r37 = r0;
                r37.closeAll();
                r37 = com.mba.proxylight.RequestProcessor.processorsCount;
                r37 = r37 + -1;
                com.mba.proxylight.RequestProcessor.processorsCount = r37;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r37 = r0;
                r38 = new java.lang.StringBuilder;
                r39 = "Fin du processor ";
                r38.<init>(r39);
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;
                r39 = r0;
                r39 = r39.processorIdx;
                r38 = r38.append(r39);
                r38 = r38.toString();
                r39 = 0;
                r37.error(r38, r39);
                throw r36;
            L_0x0182:
                r36 = move-exception;
                monitor-exit(r37);	 Catch:{ all -> 0x0182 }
                throw r36;	 Catch:{ all -> 0x014a }
            L_0x0185:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.selector;	 Catch:{ Exception -> 0x02c5 }
                r38 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
                r0 = r36;
                r1 = r38;
                r0.select(r1);	 Catch:{ Exception -> 0x02c5 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.inSocket;	 Catch:{ Exception -> 0x02c5 }
                if (r36 == 0) goto L_0x00e4;
            L_0x01a4:
                r22 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x02c5 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.selector;	 Catch:{ Exception -> 0x02c5 }
                r36 = r36.selectedKeys();	 Catch:{ Exception -> 0x02c5 }
                r36 = r36.size();	 Catch:{ Exception -> 0x02c5 }
                if (r36 != 0) goto L_0x01ff;
            L_0x01bc:
                r36 = com.mba.proxylight.RequestProcessor.SOCKET_TIMEOUT;	 Catch:{ Exception -> 0x02c5 }
                r20 = r22 - r36;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.outSockets;	 Catch:{ Exception -> 0x02c5 }
                r36 = r36.entrySet();	 Catch:{ Exception -> 0x02c5 }
                r12 = r36.iterator();	 Catch:{ Exception -> 0x02c5 }
            L_0x01d4:
                r36 = r12.hasNext();	 Catch:{ Exception -> 0x02c5 }
                if (r36 != 0) goto L_0x033b;
            L_0x01da:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.outSockets;	 Catch:{ Exception -> 0x02c5 }
                r36 = r36.size();	 Catch:{ Exception -> 0x02c5 }
                if (r36 != 0) goto L_0x01f3;
            L_0x01ea:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36.closeAll();	 Catch:{ Exception -> 0x02c5 }
            L_0x01f3:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.inSocket;	 Catch:{ Exception -> 0x02c5 }
                if (r36 == 0) goto L_0x00e4;
            L_0x01ff:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.selector;	 Catch:{ Exception -> 0x02c5 }
                r36 = r36.selectedKeys();	 Catch:{ Exception -> 0x02c5 }
                r29 = r36.iterator();	 Catch:{ Exception -> 0x02c5 }
            L_0x0211:
                r36 = r29.hasNext();	 Catch:{ Exception -> 0x02c5 }
                if (r36 == 0) goto L_0x00d8;
            L_0x0217:
                r16 = r29.next();	 Catch:{ Exception -> 0x02c5 }
                r16 = (java.nio.channels.SelectionKey) r16;	 Catch:{ Exception -> 0x02c5 }
                r29.remove();	 Catch:{ Exception -> 0x02c5 }
                r36 = r16.isValid();	 Catch:{ Exception -> 0x02c5 }
                if (r36 == 0) goto L_0x0211;
            L_0x0226:
                r36 = r16.isReadable();	 Catch:{ Exception -> 0x02c5 }
                if (r36 == 0) goto L_0x0211;
            L_0x022c:
                r33 = r16.attachment();	 Catch:{ Exception -> 0x02c5 }
                r33 = (com.mba.proxylight.Socket) r33;	 Catch:{ Exception -> 0x02c5 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.inSocket;	 Catch:{ Exception -> 0x02c5 }
                r0 = r33;
                r1 = r36;
                if (r0 != r1) goto L_0x07a4;
            L_0x0242:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.readBuffer;	 Catch:{ Exception -> 0x02c5 }
                r36.clear();	 Catch:{ Exception -> 0x02c5 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r37 = r0;
                r37 = r37.inSocket;	 Catch:{ Exception -> 0x02c5 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r38 = r0;
                r38 = r38.readBuffer;	 Catch:{ Exception -> 0x02c5 }
                r0 = r36;
                r1 = r37;
                r2 = r38;
                r3 = r22;
                r17 = r0.read(r1, r2, r3);	 Catch:{ Exception -> 0x02c5 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r37 = r36.inData;	 Catch:{ Exception -> 0x02c5 }
                r38 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c5 }
                r37 = java.lang.String.valueOf(r37);	 Catch:{ Exception -> 0x02c5 }
                r0 = r38;
                r1 = r37;
                r0.<init>(r1);	 Catch:{ Exception -> 0x02c5 }
                r37 = new java.lang.String;	 Catch:{ Exception -> 0x02c5 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r39 = r0;
                r39 = r39.readBuffer;	 Catch:{ Exception -> 0x02c5 }
                r39 = r39.array();	 Catch:{ Exception -> 0x02c5 }
                r0 = r37;
                r1 = r39;
                r0.<init>(r1);	 Catch:{ Exception -> 0x02c5 }
                r0 = r38;
                r1 = r37;
                r37 = r0.append(r1);	 Catch:{ Exception -> 0x02c5 }
                r37 = r37.toString();	 Catch:{ Exception -> 0x02c5 }
                r36.inData = r37;	 Catch:{ Exception -> 0x02c5 }
                r36 = -1;
                r0 = r17;
                r1 = r36;
                if (r0 != r1) goto L_0x045a;
            L_0x02ba:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36.closeAll();	 Catch:{ Exception -> 0x02c5 }
                goto L_0x00d8;
            L_0x02c5:
                r8 = move-exception;
            L_0x02c6:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x03ba }
                r36 = r0;
                r37 = 0;
                r0 = r36;
                r1 = r37;
                r0.error(r1, r8);	 Catch:{ all -> 0x03ba }
                r36 = java.lang.System.out;	 Catch:{ all -> 0x014a }
                r37 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014a }
                r38 = "inData:";
                r37.<init>(r38);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r38 = r0;
                r38 = r38.inData;	 Catch:{ all -> 0x014a }
                r37 = r37.append(r38);	 Catch:{ all -> 0x014a }
                r37 = r37.toString();	 Catch:{ all -> 0x014a }
                r36.println(r37);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r36 = r0;
                r37 = "";
                r36.inData = r37;	 Catch:{ all -> 0x014a }
                r36 = java.lang.System.out;	 Catch:{ all -> 0x014a }
                r37 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014a }
                r38 = "outData:";
                r37.<init>(r38);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r38 = r0;
                r38 = r38.outData;	 Catch:{ all -> 0x014a }
                r37 = r37.append(r38);	 Catch:{ all -> 0x014a }
                r37 = r37.toString();	 Catch:{ all -> 0x014a }
                r36.println(r37);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r36 = r0;
                r37 = "";
                r36.outData = r37;	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r36 = r0;
                r36.closeAll();	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r36 = r0;
                r36.recycle();	 Catch:{ all -> 0x014a }
                goto L_0x0009;
            L_0x033b:
                r9 = r12.next();	 Catch:{ Exception -> 0x02c5 }
                r9 = (java.util.Map.Entry) r9;	 Catch:{ Exception -> 0x02c5 }
                r32 = r9.getValue();	 Catch:{ Exception -> 0x02c5 }
                r32 = (com.mba.proxylight.Socket) r32;	 Catch:{ Exception -> 0x02c5 }
                r0 = r32;
                r0 = r0.lastRead;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r0 = r32;
                r0 = r0.lastWrite;	 Catch:{ Exception -> 0x02c5 }
                r38 = r0;
                r18 = java.lang.Math.max(r36, r38);	 Catch:{ Exception -> 0x02c5 }
                r36 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1));
                if (r36 >= 0) goto L_0x01d4;
            L_0x035b:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r37 = r0;
                r36 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c5 }
                r38 = "processeur ";
                r0 = r36;
                r1 = r38;
                r0.<init>(r1);	 Catch:{ Exception -> 0x02c5 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r38 = r0;
                r38 = r38.processorIdx;	 Catch:{ Exception -> 0x02c5 }
                r0 = r36;
                r1 = r38;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x02c5 }
                r38 = " : Fermeture pour inactivite de la socket vers ";
                r0 = r36;
                r1 = r38;
                r38 = r0.append(r1);	 Catch:{ Exception -> 0x02c5 }
                r36 = r9.getKey();	 Catch:{ Exception -> 0x02c5 }
                r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x02c5 }
                r0 = r38;
                r1 = r36;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x02c5 }
                r36 = r36.toString();	 Catch:{ Exception -> 0x02c5 }
                r0 = r37;
                r1 = r36;
                r0.debug(r1);	 Catch:{ Exception -> 0x02c5 }
                if (r26 == 0) goto L_0x0420;
            L_0x03a3:
                r36 = "CONNECT";
                r37 = r26.getMethod();	 Catch:{ Exception -> 0x02c5 }
                r36 = r36.equals(r37);	 Catch:{ Exception -> 0x02c5 }
                if (r36 == 0) goto L_0x0420;
            L_0x03af:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36.closeAll();	 Catch:{ Exception -> 0x02c5 }
                goto L_0x01da;
            L_0x03ba:
                r36 = move-exception;
                r37 = java.lang.System.out;	 Catch:{ all -> 0x014a }
                r38 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014a }
                r39 = "inData:";
                r38.<init>(r39);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r39 = r0;
                r39 = r39.inData;	 Catch:{ all -> 0x014a }
                r38 = r38.append(r39);	 Catch:{ all -> 0x014a }
                r38 = r38.toString();	 Catch:{ all -> 0x014a }
                r37.println(r38);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r37 = r0;
                r38 = "";
                r37.inData = r38;	 Catch:{ all -> 0x014a }
                r37 = java.lang.System.out;	 Catch:{ all -> 0x014a }
                r38 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014a }
                r39 = "outData:";
                r38.<init>(r39);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r39 = r0;
                r39 = r39.outData;	 Catch:{ all -> 0x014a }
                r38 = r38.append(r39);	 Catch:{ all -> 0x014a }
                r38 = r38.toString();	 Catch:{ all -> 0x014a }
                r37.println(r38);	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r37 = r0;
                r38 = "";
                r37.outData = r38;	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r37 = r0;
                r37.closeAll();	 Catch:{ all -> 0x014a }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ all -> 0x014a }
                r37 = r0;
                r37.recycle();	 Catch:{ all -> 0x014a }
                throw r36;	 Catch:{ all -> 0x014a }
            L_0x0420:
                r12.remove();	 Catch:{ Exception -> 0x02c5 }
                r0 = r32;
                r0 = r0.socket;	 Catch:{ Exception -> 0x0449 }
                r36 = r0;
                r36.close();	 Catch:{ Exception -> 0x0449 }
            L_0x042c:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.currentOutSocket;	 Catch:{ Exception -> 0x02c5 }
                r0 = r32;
                r1 = r36;
                if (r0 != r1) goto L_0x01d4;
            L_0x043c:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r37 = 0;
                r36.currentOutSocket = r37;	 Catch:{ Exception -> 0x02c5 }
                goto L_0x01d4;
            L_0x0449:
                r10 = move-exception;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r37 = "";
                r0 = r36;
                r1 = r37;
                r0.error(r1, r10);	 Catch:{ Exception -> 0x02c5 }
                goto L_0x042c;
            L_0x045a:
                if (r17 <= 0) goto L_0x0211;
            L_0x045c:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.readBuffer;	 Catch:{ Exception -> 0x02c5 }
                r36.flip();	 Catch:{ Exception -> 0x02c5 }
                r27 = r26;
            L_0x046b:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r36 = r36.readBuffer;	 Catch:{ Exception -> 0x04ea }
                r36 = r36.remaining();	 Catch:{ Exception -> 0x04ea }
                if (r36 > 0) goto L_0x047f;
            L_0x047b:
                r26 = r27;
                goto L_0x0211;
            L_0x047f:
                r36 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.STATUS_LINE;	 Catch:{ Exception -> 0x04ea }
                r0 = r34;
                r1 = r36;
                if (r0 != r1) goto L_0x04ae;
            L_0x0487:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r37 = r0;
                r37 = r37.readBuffer;	 Catch:{ Exception -> 0x04ea }
                r28 = r36.readNext(r37);	 Catch:{ Exception -> 0x04ea }
                if (r28 == 0) goto L_0x046b;
            L_0x049d:
                r26 = new com.mba.proxylight.Request;	 Catch:{ Exception -> 0x04ea }
                r26.<init>();	 Catch:{ Exception -> 0x04ea }
                r0 = r26;
                r1 = r28;
                r0.setStatusline(r1);	 Catch:{ Exception -> 0x02c5 }
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.REQUEST_HEADERS;	 Catch:{ Exception -> 0x02c5 }
                r27 = r26;
                goto L_0x046b;
            L_0x04ae:
                r36 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.REQUEST_HEADERS;	 Catch:{ Exception -> 0x04ea }
                r0 = r34;
                r1 = r36;
                if (r0 != r1) goto L_0x073a;
            L_0x04b6:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r37 = r0;
                r37 = r37.readBuffer;	 Catch:{ Exception -> 0x04ea }
                r28 = r36.readNext(r37);	 Catch:{ Exception -> 0x04ea }
                if (r28 == 0) goto L_0x046b;
            L_0x04cc:
                r36 = r28.length();	 Catch:{ Exception -> 0x04ea }
                if (r36 != 0) goto L_0x0735;
            L_0x04d2:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r0 = r36;
                r1 = r27;
                r36 = r0.filterRequest(r1);	 Catch:{ Exception -> 0x04ea }
                if (r36 == 0) goto L_0x04ef;
            L_0x04e2:
                r36 = new java.lang.Exception;	 Catch:{ Exception -> 0x04ea }
                r37 = "Requete interdite.";
                r36.<init>(r37);	 Catch:{ Exception -> 0x04ea }
                throw r36;	 Catch:{ Exception -> 0x04ea }
            L_0x04ea:
                r8 = move-exception;
                r26 = r27;
                goto L_0x02c6;
            L_0x04ef:
                r36 = "GET";
                r37 = r27.getMethod();	 Catch:{ Exception -> 0x04ea }
                r14 = r36.equals(r37);	 Catch:{ Exception -> 0x04ea }
                if (r14 != 0) goto L_0x0538;
            L_0x04fb:
                r36 = "POST";
                r37 = r27.getMethod();	 Catch:{ Exception -> 0x04ea }
                r36 = r36.equals(r37);	 Catch:{ Exception -> 0x04ea }
                if (r36 == 0) goto L_0x0538;
            L_0x0507:
                r15 = 1;
            L_0x0508:
                if (r14 != 0) goto L_0x053a;
            L_0x050a:
                if (r15 != 0) goto L_0x053a;
            L_0x050c:
                r36 = "CONNECT";
                r37 = r27.getMethod();	 Catch:{ Exception -> 0x04ea }
                r36 = r36.equals(r37);	 Catch:{ Exception -> 0x04ea }
                if (r36 == 0) goto L_0x053a;
            L_0x0518:
                r13 = 1;
            L_0x0519:
                if (r14 != 0) goto L_0x053c;
            L_0x051b:
                if (r15 != 0) goto L_0x053c;
            L_0x051d:
                if (r13 != 0) goto L_0x053c;
            L_0x051f:
                r36 = new java.lang.RuntimeException;	 Catch:{ Exception -> 0x04ea }
                r37 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
                r38 = "Unknown method : ";
                r37.<init>(r38);	 Catch:{ Exception -> 0x04ea }
                r38 = r27.getMethod();	 Catch:{ Exception -> 0x04ea }
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ea }
                r37 = r37.toString();	 Catch:{ Exception -> 0x04ea }
                r36.<init>(r37);	 Catch:{ Exception -> 0x04ea }
                throw r36;	 Catch:{ Exception -> 0x04ea }
            L_0x0538:
                r15 = 0;
                goto L_0x0508;
            L_0x053a:
                r13 = 0;
                goto L_0x0519;
            L_0x053c:
                r36 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
                r37 = r27.getHost();	 Catch:{ Exception -> 0x04ea }
                r37 = java.lang.String.valueOf(r37);	 Catch:{ Exception -> 0x04ea }
                r36.<init>(r37);	 Catch:{ Exception -> 0x04ea }
                r37 = ":";
                r36 = r36.append(r37);	 Catch:{ Exception -> 0x04ea }
                r37 = r27.getPort();	 Catch:{ Exception -> 0x04ea }
                r36 = r36.append(r37);	 Catch:{ Exception -> 0x04ea }
                r24 = r36.toString();	 Catch:{ Exception -> 0x04ea }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r36 = r36.outSockets;	 Catch:{ Exception -> 0x04ea }
                r0 = r36;
                r1 = r24;
                r25 = r0.get(r1);	 Catch:{ Exception -> 0x04ea }
                r25 = (com.mba.proxylight.Socket) r25;	 Catch:{ Exception -> 0x04ea }
                if (r25 != 0) goto L_0x0637;
            L_0x0571:
                r25 = new com.mba.proxylight.Socket;	 Catch:{ Exception -> 0x04ea }
                r25.<init>();	 Catch:{ Exception -> 0x04ea }
                r36 = java.nio.channels.SocketChannel.open();	 Catch:{ Exception -> 0x04ea }
                r0 = r36;
                r1 = r25;
                r1.socket = r0;	 Catch:{ Exception -> 0x04ea }
                r0 = r25;
                r0 = r0.socket;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r37 = 0;
                r36.configureBlocking(r37);	 Catch:{ Exception -> 0x04ea }
                r0 = r25;
                r0 = r0.socket;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r37 = new java.net.InetSocketAddress;	 Catch:{ Exception -> 0x04ea }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r38 = r0;
                r39 = r27.getHost();	 Catch:{ Exception -> 0x04ea }
                r38 = r38.resolve(r39);	 Catch:{ Exception -> 0x04ea }
                r39 = r27.getPort();	 Catch:{ Exception -> 0x04ea }
                r37.<init>(r38, r39);	 Catch:{ Exception -> 0x04ea }
                r36 = r36.connect(r37);	 Catch:{ Exception -> 0x04ea }
                if (r36 != 0) goto L_0x05bf;
            L_0x05ae:
                r36 = 50;
                java.lang.Thread.sleep(r36);	 Catch:{ Exception -> 0x04ea }
                r0 = r25;
                r0 = r0.socket;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r36 = r36.finishConnect();	 Catch:{ Exception -> 0x04ea }
                if (r36 == 0) goto L_0x05ae;
            L_0x05bf:
                r0 = r25;
                r0 = r0.socket;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r37 = r0;
                r37 = r37.selector;	 Catch:{ Exception -> 0x04ea }
                r38 = 1;
                r0 = r36;
                r1 = r37;
                r2 = r38;
                r3 = r25;
                r0.register(r1, r2, r3);	 Catch:{ Exception -> 0x04ea }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r36 = r36.outSockets;	 Catch:{ Exception -> 0x04ea }
                r0 = r36;
                r1 = r24;
                r2 = r25;
                r0.put(r1, r2);	 Catch:{ Exception -> 0x04ea }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r37 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
                r38 = "Ajout d'une socket vers ";
                r37.<init>(r38);	 Catch:{ Exception -> 0x04ea }
                r0 = r37;
                r1 = r24;
                r37 = r0.append(r1);	 Catch:{ Exception -> 0x04ea }
                r38 = " sur le processeur ";
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ea }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r38 = r0;
                r38 = r38.processorIdx;	 Catch:{ Exception -> 0x04ea }
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ea }
                r38 = ". Socket count=";
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ea }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r38 = r0;
                r38 = r38.outSockets;	 Catch:{ Exception -> 0x04ea }
                r38 = r38.size();	 Catch:{ Exception -> 0x04ea }
                r37 = r37.append(r38);	 Catch:{ Exception -> 0x04ea }
                r37 = r37.toString();	 Catch:{ Exception -> 0x04ea }
                r36.debug(r37);	 Catch:{ Exception -> 0x04ea }
            L_0x0637:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r0 = r36;
                r1 = r25;
                r0.currentOutSocket = r1;	 Catch:{ Exception -> 0x04ea }
                if (r13 == 0) goto L_0x066b;
            L_0x0646:
                r36 = com.mba.proxylight.RequestProcessor.CONNECT_OK;	 Catch:{ Exception -> 0x04ea }
                r6 = java.nio.ByteBuffer.wrap(r36);	 Catch:{ Exception -> 0x04ea }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r37 = r0;
                r37 = r37.inSocket;	 Catch:{ Exception -> 0x04ea }
                r0 = r36;
                r1 = r37;
                r2 = r22;
                r0.write(r1, r6, r2);	 Catch:{ Exception -> 0x04ea }
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.TRANSFER;	 Catch:{ Exception -> 0x04ea }
                goto L_0x046b;
            L_0x066b:
                r36 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x04ea }
                r37 = r27.getMethod();	 Catch:{ Exception -> 0x04ea }
                r36.<init>(r37);	 Catch:{ Exception -> 0x04ea }
                r37 = " ";
                r30 = r36.append(r37);	 Catch:{ Exception -> 0x04ea }
                r35 = r27.getUrl();	 Catch:{ Exception -> 0x04ea }
                r36 = "/";
                r36 = r35.startsWith(r36);	 Catch:{ Exception -> 0x04ea }
                if (r36 != 0) goto L_0x0692;
            L_0x0686:
                r36 = 47;
                r37 = 8;
                r36 = r35.indexOf(r36, r37);	 Catch:{ Exception -> 0x04ea }
                r35 = r35.substring(r36);	 Catch:{ Exception -> 0x04ea }
            L_0x0692:
                r0 = r30;
                r1 = r35;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x04ea }
                r37 = " ";
                r36 = r36.append(r37);	 Catch:{ Exception -> 0x04ea }
                r37 = r27.getProtocol();	 Catch:{ Exception -> 0x04ea }
                r36 = r36.append(r37);	 Catch:{ Exception -> 0x04ea }
                r37 = "\r\n";
                r36.append(r37);	 Catch:{ Exception -> 0x04ea }
                r36 = r27.getHeaders();	 Catch:{ Exception -> 0x04ea }
                r36 = r36.entrySet();	 Catch:{ Exception -> 0x04ea }
                r37 = r36.iterator();	 Catch:{ Exception -> 0x04ea }
            L_0x06b9:
                r36 = r37.hasNext();	 Catch:{ Exception -> 0x04ea }
                if (r36 != 0) goto L_0x06fc;
            L_0x06bf:
                r36 = "\r\n";
                r0 = r30;
                r1 = r36;
                r0.append(r1);	 Catch:{ Exception -> 0x04ea }
                r36 = r30.toString();	 Catch:{ Exception -> 0x04ea }
                r31 = r36.getBytes();	 Catch:{ Exception -> 0x04ea }
                r6 = java.nio.ByteBuffer.wrap(r31);	 Catch:{ Exception -> 0x04ea }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r0 = r36;
                r1 = r25;
                r2 = r22;
                r0.write(r1, r6, r2);	 Catch:{ Exception -> 0x04ea }
                r7 = 0;
                if (r15 == 0) goto L_0x06f6;
            L_0x06e6:
                r36 = r27.getHeaders();	 Catch:{ Exception -> 0x04ea }
                r37 = "Content-Length";
                r36 = r36.get(r37);	 Catch:{ Exception -> 0x04ea }
                r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x04ea }
                r7 = java.lang.Integer.parseInt(r36);	 Catch:{ Exception -> 0x04ea }
            L_0x06f6:
                if (r7 != 0) goto L_0x0732;
            L_0x06f8:
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.STATUS_LINE;	 Catch:{ Exception -> 0x04ea }
            L_0x06fa:
                goto L_0x046b;
            L_0x06fc:
                r11 = r37.next();	 Catch:{ Exception -> 0x04ea }
                r11 = (java.util.Map.Entry) r11;	 Catch:{ Exception -> 0x04ea }
                r36 = r11.getKey();	 Catch:{ Exception -> 0x04ea }
                r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x04ea }
                r0 = r30;
                r1 = r36;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x04ea }
                r38 = ": ";
                r0 = r36;
                r1 = r38;
                r38 = r0.append(r1);	 Catch:{ Exception -> 0x04ea }
                r36 = r11.getValue();	 Catch:{ Exception -> 0x04ea }
                r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x04ea }
                r0 = r38;
                r1 = r36;
                r36 = r0.append(r1);	 Catch:{ Exception -> 0x04ea }
                r38 = "\r\n";
                r0 = r36;
                r1 = r38;
                r0.append(r1);	 Catch:{ Exception -> 0x04ea }
                goto L_0x06b9;
            L_0x0732:
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.REQUEST_CONTENT;	 Catch:{ Exception -> 0x04ea }
                goto L_0x06fa;
            L_0x0735:
                r27.addHeader(r28);	 Catch:{ Exception -> 0x04ea }
                goto L_0x046b;
            L_0x073a:
                r36 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.REQUEST_CONTENT;	 Catch:{ Exception -> 0x04ea }
                r0 = r34;
                r1 = r36;
                if (r0 != r1) goto L_0x0775;
            L_0x0742:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r36 = r36.readBuffer;	 Catch:{ Exception -> 0x04ea }
                r36 = r36.remaining();	 Catch:{ Exception -> 0x04ea }
                r7 = r7 - r36;
                if (r7 > 0) goto L_0x0756;
            L_0x0754:
                r34 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.STATUS_LINE;	 Catch:{ Exception -> 0x04ea }
            L_0x0756:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r36 = r36.currentOutSocket;	 Catch:{ Exception -> 0x04ea }
                r0 = r36;
                r0 = r0.socket;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r37 = r0;
                r37 = r37.readBuffer;	 Catch:{ Exception -> 0x04ea }
                r36.write(r37);	 Catch:{ Exception -> 0x04ea }
                goto L_0x046b;
            L_0x0775:
                r36 = com.mba.proxylight.RequestProcessor.REQUEST_STEP.TRANSFER;	 Catch:{ Exception -> 0x04ea }
                r0 = r34;
                r1 = r36;
                if (r0 != r1) goto L_0x046b;
            L_0x077d:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r37 = r0;
                r37 = r37.currentOutSocket;	 Catch:{ Exception -> 0x04ea }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x04ea }
                r38 = r0;
                r38 = r38.readBuffer;	 Catch:{ Exception -> 0x04ea }
                r0 = r36;
                r1 = r37;
                r2 = r38;
                r3 = r22;
                r0.write(r1, r2, r3);	 Catch:{ Exception -> 0x04ea }
                goto L_0x046b;
            L_0x07a4:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36 = r36.currentOutSocket;	 Catch:{ Exception -> 0x02c5 }
                r0 = r33;
                r1 = r36;
                if (r0 == r1) goto L_0x07c3;
            L_0x07b4:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r0 = r36;
                r1 = r33;
                r0.closeOutSocket(r1);	 Catch:{ Exception -> 0x02c5 }
                goto L_0x0211;
            L_0x07c3:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r37 = r0;
                r37 = r37.inSocket;	 Catch:{ Exception -> 0x02c5 }
                r0 = r36;
                r1 = r33;
                r2 = r37;
                r3 = r22;
                r36 = r0.transfer(r1, r2, r3);	 Catch:{ Exception -> 0x02c5 }
                if (r36 != 0) goto L_0x0211;
            L_0x07e1:
                r36 = "CONNECT";
                r37 = r26.getMethod();	 Catch:{ Exception -> 0x02c5 }
                r36 = r36.equals(r37);	 Catch:{ Exception -> 0x02c5 }
                if (r36 == 0) goto L_0x07f8;
            L_0x07ed:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r36.closeAll();	 Catch:{ Exception -> 0x02c5 }
                goto L_0x00d8;
            L_0x07f8:
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r0 = r36;
                r1 = r33;
                r0.closeOutSocket(r1);	 Catch:{ Exception -> 0x02c5 }
                r0 = r40;
                r0 = com.mba.proxylight.RequestProcessor.this;	 Catch:{ Exception -> 0x02c5 }
                r36 = r0;
                r37 = 0;
                r36.currentOutSocket = r37;	 Catch:{ Exception -> 0x02c5 }
                goto L_0x00d8;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mba.proxylight.RequestProcessor.1.run():void");
            }
        });
        Thread thread = this.t;
        StringBuilder stringBuilder = new StringBuilder("ProxyLight processor - ");
        int i = processorsCpt;
        processorsCpt = i + 1;
        this.processorIdx = i;
        thread.setName(stringBuilder.append(i).toString());
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
