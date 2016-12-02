/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 *  java.nio.channels.SocketChannel
 */
package com.mba.proxylight;

import java.nio.channels.SocketChannel;

public class Socket {
    public long created;
    public long lastRead;
    public long lastWrite;
    public SocketChannel socket = null;

    public Socket() {
        this.lastWrite = this.created = System.currentTimeMillis();
        this.lastRead = this.created;
    }
}

