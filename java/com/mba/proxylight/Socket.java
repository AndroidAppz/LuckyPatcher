package com.mba.proxylight;

import java.nio.channels.SocketChannel;

public class Socket {
    public long created = System.currentTimeMillis();
    public long lastRead = this.created;
    public long lastWrite = this.created;
    public SocketChannel socket = null;
}
