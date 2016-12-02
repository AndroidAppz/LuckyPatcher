/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.InetAddress
 *  java.net.UnknownHostException
 *  java.nio.channels.Selector
 *  java.nio.channels.ServerSocketChannel
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Stack
 */
package com.mba.proxylight;

import com.mba.proxylight.RequestFilter;
import com.mba.proxylight.RequestProcessor;
import java.io.PrintStream;
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

    static /* synthetic */ Selector access$000(ProxyLight proxyLight) {
        return proxyLight.selector;
    }

    static /* synthetic */ Selector access$002(ProxyLight proxyLight, Selector selector) {
        proxyLight.selector = selector;
        return selector;
    }

    static /* synthetic */ Stack access$100(ProxyLight proxyLight) {
        return proxyLight.processors;
    }

    public void debug(String string) {
        if (string != null) {
            System.err.println(string);
        }
    }

    public void error(String string, Throwable throwable) {
        if (string != null) {
            System.err.println(string);
        }
        if (throwable != null) {
            // empty if block
        }
    }

    public int getPort() {
        return this.port;
    }

    public String getRemoteProxyHost() {
        return this.remoteProxyHost;
    }

    public int getRemoteProxyPort() {
        return this.remoteProxyPort;
    }

    public List<RequestFilter> getRequestFilters() {
        return this.filters;
    }

    public boolean isRunning() {
        return this.running;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void recycle(RequestProcessor requestProcessor) {
        Stack<RequestProcessor> stack;
        Stack<RequestProcessor> stack2 = stack = this.processors;
        synchronized (stack2) {
            this.processors.add((Object)requestProcessor);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected InetAddress resolve(String string) {
        InetAddress inetAddress = (InetAddress)this.ipCache.get((Object)string);
        if (inetAddress != null) return inetAddress;
        try {
            inetAddress = InetAddress.getByName((String)string);
            this.ipCache.put((Object)string, (Object)inetAddress);
            return inetAddress;
        }
        catch (UnknownHostException unknownHostException) {
            return null;
        }
        catch (Throwable throwable) {
            this.error("", throwable);
            return inetAddress;
        }
    }

    public void setPort(int n) {
        this.port = n;
    }

    public void setRemoteProxy(String string, int n) {
        this.remoteProxyHost = string;
        this.remoteProxyPort = n;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void start() throws Exception {
        ProxyLight proxyLight = this;
        synchronized (proxyLight) {
            boolean bl = this.running;
            if (!bl) {
                this.running = true;
                Thread thread = new Thread(new Runnable(){

                    /*
                     * Exception decompiling
                     */
                    public void run() {
                        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 21[DOLOOP]
                        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
                        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
                        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
                        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
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
                thread.setDaemon(false);
                thread.setName("ProxyLight server");
                thread.start();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stop() {
        if (!this.running) return;
        {
            try {
                this.server.close();
                this.server = null;
                this.selector.wakeup();
                this.selector = null;
                while (this.processors.size() > 0) {
                    ((RequestProcessor)this.processors.pop()).shutdown();
                }
                return;
            }
            catch (Exception var1_1) {
                this.error(null, (Throwable)var1_1);
                return;
            }
        }
    }

}

