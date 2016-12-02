package com.mba.proxylight;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ProxyLight {
    private List<RequestFilter> filters = new ArrayList();
    private Map<String, InetAddress> ipCache = new HashMap();
    private int port = 8080;
    private Stack<RequestProcessor> processors = new Stack();
    private String remoteProxyHost = null;
    private int remoteProxyPort = 8080;
    boolean running = false;
    private Selector selector = null;
    ServerSocketChannel server = null;

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public synchronized void start() throws Exception {
        if (!this.running) {
            this.running = true;
            Thread t = new Thread(new Runnable() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    r10 = this;
                    r9 = 0;
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r7 = java.nio.channels.ServerSocketChannel.open();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6.server = r7;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.server;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r7 = 0;
                    r6.configureBlocking(r7);	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.server;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.socket();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r7 = 1;
                    r6.setReuseAddress(r7);	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.server;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.socket();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r7 = new java.net.InetSocketAddress;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r8 = 8080; // 0x1f90 float:1.1322E-41 double:3.992E-320;
                    r7.<init>(r8);	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6.bind(r7);	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r7 = java.nio.channels.Selector.open();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6.selector = r7;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.server;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r7 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r7 = r7.selector;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r8 = 16;
                    r6.register(r7, r8);	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                L_0x0047:
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.selector;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6.select();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.server;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    if (r6 != 0) goto L_0x005b;
                L_0x0056:
                    r6 = com.mba.proxylight.ProxyLight.this;
                    r6.running = r9;
                L_0x005a:
                    return;
                L_0x005b:
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.selector;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.selectedKeys();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r1 = r6.iterator();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                L_0x0069:
                    r6 = r1.hasNext();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    if (r6 == 0) goto L_0x0047;
                L_0x006f:
                    r2 = r1.next();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r2 = (java.nio.channels.SelectionKey) r2;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r1.remove();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r2.isValid();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    if (r6 == 0) goto L_0x0069;
                L_0x007e:
                    r6 = r2.isAcceptable();	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    if (r6 == 0) goto L_0x0069;
                L_0x0084:
                    r3 = 0;
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ Throwable -> 0x00bf, ClosedSelectorException -> 0x00ce }
                    r7 = r6.processors;	 Catch:{ Throwable -> 0x00bf, ClosedSelectorException -> 0x00ce }
                    monitor-enter(r7);	 Catch:{ Throwable -> 0x00bf, ClosedSelectorException -> 0x00ce }
                L_0x008c:
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ all -> 0x00cb }
                    r6 = r6.processors;	 Catch:{ all -> 0x00cb }
                    r6 = r6.size();	 Catch:{ all -> 0x00cb }
                    if (r6 <= 0) goto L_0x00ac;
                L_0x0098:
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ all -> 0x00cb }
                    r6 = r6.processors;	 Catch:{ all -> 0x00cb }
                    r6 = r6.pop();	 Catch:{ all -> 0x00cb }
                    r0 = r6;
                    r0 = (com.mba.proxylight.RequestProcessor) r0;	 Catch:{ all -> 0x00cb }
                    r3 = r0;
                    r6 = r3.isAlive();	 Catch:{ all -> 0x00cb }
                    if (r6 == 0) goto L_0x008c;
                L_0x00ac:
                    r4 = r3;
                    monitor-exit(r7);	 Catch:{ all -> 0x00f1 }
                    if (r4 == 0) goto L_0x00b6;
                L_0x00b0:
                    r6 = r4.isAlive();	 Catch:{ Throwable -> 0x00ee, ClosedSelectorException -> 0x00ce }
                    if (r6 != 0) goto L_0x00f4;
                L_0x00b6:
                    r3 = new com.mba.proxylight.ProxyLight$1$1;	 Catch:{ Throwable -> 0x00ee, ClosedSelectorException -> 0x00ce }
                    r3.<init>();	 Catch:{ Throwable -> 0x00ee, ClosedSelectorException -> 0x00ce }
                L_0x00bb:
                    r3.process(r2);	 Catch:{ Throwable -> 0x00bf, ClosedSelectorException -> 0x00ce }
                    goto L_0x0069;
                L_0x00bf:
                    r5 = move-exception;
                L_0x00c0:
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r6 = r6.server;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    if (r6 != 0) goto L_0x00d4;
                L_0x00c6:
                    r6 = com.mba.proxylight.ProxyLight.this;
                    r6.running = r9;
                    goto L_0x005a;
                L_0x00cb:
                    r6 = move-exception;
                L_0x00cc:
                    monitor-exit(r7);	 Catch:{ all -> 0x00cb }
                    throw r6;	 Catch:{ Throwable -> 0x00bf, ClosedSelectorException -> 0x00ce }
                L_0x00ce:
                    r6 = move-exception;
                    r6 = com.mba.proxylight.ProxyLight.this;
                    r6.running = r9;
                    goto L_0x005a;
                L_0x00d4:
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    r7 = 0;
                    r6.error(r7, r5);	 Catch:{ ClosedSelectorException -> 0x00ce, Throwable -> 0x00db }
                    goto L_0x0069;
                L_0x00db:
                    r5 = move-exception;
                    r6 = com.mba.proxylight.ProxyLight.this;	 Catch:{ all -> 0x00e8 }
                    r7 = 0;
                    r6.error(r7, r5);	 Catch:{ all -> 0x00e8 }
                    r6 = com.mba.proxylight.ProxyLight.this;
                    r6.running = r9;
                    goto L_0x005a;
                L_0x00e8:
                    r6 = move-exception;
                    r7 = com.mba.proxylight.ProxyLight.this;
                    r7.running = r9;
                    throw r6;
                L_0x00ee:
                    r5 = move-exception;
                    r3 = r4;
                    goto L_0x00c0;
                L_0x00f1:
                    r6 = move-exception;
                    r3 = r4;
                    goto L_0x00cc;
                L_0x00f4:
                    r3 = r4;
                    goto L_0x00bb;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mba.proxylight.ProxyLight.1.run():void");
                }
            });
            t.setDaemon(false);
            t.setName("ProxyLight server");
            t.start();
        }
    }

    protected InetAddress resolve(String host) {
        InetAddress retour = (InetAddress) this.ipCache.get(host);
        if (retour == null) {
            try {
                retour = InetAddress.getByName(host);
                this.ipCache.put(host, retour);
            } catch (UnknownHostException e) {
                return null;
            } catch (Throwable t) {
                error("", t);
            }
        }
        return retour;
    }

    public void stop() {
        if (this.running) {
            try {
                this.server.close();
                this.server = null;
                this.selector.wakeup();
                this.selector = null;
                while (this.processors.size() > 0) {
                    ((RequestProcessor) this.processors.pop()).shutdown();
                }
            } catch (Exception e) {
                error(null, e);
            }
        }
    }

    public void error(String message, Throwable t) {
        if (message != null) {
            System.err.println(message);
        }
        if (t == null) {
        }
    }

    public void debug(String message) {
        if (message != null) {
            System.err.println(message);
        }
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRemoteProxy(String host, int port) {
        this.remoteProxyHost = host;
        this.remoteProxyPort = port;
    }

    public String getRemoteProxyHost() {
        return this.remoteProxyHost;
    }

    public int getRemoteProxyPort() {
        return this.remoteProxyPort;
    }

    public void recycle(RequestProcessor processor) {
        synchronized (this.processors) {
            this.processors.add(processor);
        }
    }

    public List<RequestFilter> getRequestFilters() {
        return this.filters;
    }
}
