/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.mba.proxylight;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Request {
    private static Pattern CONNECT_PATTERN = Pattern.compile((String)"(.*):([\\d]+)");
    private static Pattern GETPOST_PATTERN = Pattern.compile((String)"(https?)://([^:/]+)(:[\\d]+])?/.*");
    private Map<String, String> headers = new LinkedHashMap();
    private String host = null;
    private String method = null;
    private int port = -1;
    private String protocol = null;
    private String statusline = null;
    private String url = null;

    public void addHeader(String string) {
        int n = 1;
        while (string.charAt(n) != ':' && string.charAt(n) != ' ') {
            ++n;
        }
        String string2 = string.substring(0, n);
        while (string.charAt(++n) == ':' || string.charAt(n) == ' ') {
        }
        String string3 = string.substring(n);
        this.headers.put((Object)string2, (Object)string3);
    }

    public void dump() {
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String getHost() {
        if (this.host != null) {
            return this.host;
        }
        if (this.getUrl() == null) return this.host;
        if ("CONNECT".equals((Object)this.method)) {
            Matcher matcher = CONNECT_PATTERN.matcher((CharSequence)this.getUrl());
            if (matcher.matches()) {
                this.host = matcher.group(1);
                this.port = Integer.parseInt((String)matcher.group(2));
            }
        } else {
            Matcher matcher = GETPOST_PATTERN.matcher((CharSequence)this.getUrl());
            if (matcher.matches()) {
                this.host = matcher.group(2);
                if (matcher.group(3) != null) {
                    Integer.parseInt((String)matcher.group(3).substring(1));
                } else {
                    this.port = "http".equals((Object)matcher.group(1)) ? 80 : 443;
                }
            }
        }
        if (this.host != null) return this.host;
        this.host = (String)this.getHeaders().get((Object)"Host");
        int n = this.host.indexOf(58);
        if (n > -1) {
            this.port = Integer.parseInt((String)this.host.substring(n + 1));
            this.host = this.host.substring(0, n);
            return this.host;
        }
        this.port = 80;
        return this.host;
    }

    public String getMethod() {
        return this.method;
    }

    public int getPort() {
        this.getHost();
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getStatusline() {
        return this.statusline;
    }

    public String getUrl() {
        return this.url;
    }

    public void setMethod(String string) {
        this.method = string;
    }

    public void setProtocol(String string) {
        this.protocol = string;
    }

    public void setStatusline(String string) {
        this.statusline = string;
        int n = string.indexOf(32);
        if (n == -1 || n < 3) {
            throw new IllegalArgumentException("statusline: " + string);
        }
        this.method = string.substring(0, n);
        while (string.charAt(++n) == ' ') {
        }
        int n2 = string.indexOf(32, n);
        if (n2 == -1) {
            throw new IllegalArgumentException("statusline: " + string);
        }
        this.url = string.substring(n, n2);
        while (string.charAt(++n2) == ' ') {
        }
        this.protocol = string.substring(n2);
    }

    public void setUrl(String string) {
        this.url = string;
    }
}

