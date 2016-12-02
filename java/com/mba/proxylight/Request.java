package com.mba.proxylight;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Request {
    private static Pattern CONNECT_PATTERN = Pattern.compile("(.*):([\\d]+)");
    private static Pattern GETPOST_PATTERN = Pattern.compile("(https?)://([^:/]+)(:[\\d]+])?/.*");
    private Map<String, String> headers = new LinkedHashMap();
    private String host = null;
    private String method = null;
    private int port = -1;
    private String protocol = null;
    private String statusline = null;
    private String url = null;

    public String getStatusline() {
        return this.statusline;
    }

    public void setStatusline(String statusline) {
        this.statusline = statusline;
        int idx1 = statusline.indexOf(32);
        if (idx1 == -1 || idx1 < 3) {
            throw new IllegalArgumentException("statusline: " + statusline);
        }
        this.method = statusline.substring(0, idx1);
        do {
            idx1++;
        } while (statusline.charAt(idx1) == ' ');
        int idx2 = statusline.indexOf(32, idx1);
        if (idx2 == -1) {
            throw new IllegalArgumentException("statusline: " + statusline);
        }
        this.url = statusline.substring(idx1, idx2);
        do {
            idx2++;
        } while (statusline.charAt(idx2) == ' ');
        this.protocol = statusline.substring(idx2);
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHost() {
        if (this.host != null) {
            return this.host;
        }
        if (getUrl() != null) {
            Matcher m;
            if ("CONNECT".equals(this.method)) {
                m = CONNECT_PATTERN.matcher(getUrl());
                if (m.matches()) {
                    this.host = m.group(1);
                    this.port = Integer.parseInt(m.group(2));
                }
            } else {
                m = GETPOST_PATTERN.matcher(getUrl());
                if (m.matches()) {
                    this.host = m.group(2);
                    if (m.group(3) != null) {
                        Integer.parseInt(m.group(3).substring(1));
                    } else if ("http".equals(m.group(1))) {
                        this.port = 80;
                    } else {
                        this.port = 443;
                    }
                }
            }
            if (this.host == null) {
                this.host = (String) getHeaders().get("Host");
                int idx = this.host.indexOf(58);
                if (idx > -1) {
                    this.port = Integer.parseInt(this.host.substring(idx + 1));
                    this.host = this.host.substring(0, idx);
                } else {
                    this.port = 80;
                }
            }
        }
        return this.host;
    }

    public int getPort() {
        getHost();
        return this.port;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void addHeader(String h) {
        int idx1 = 1;
        while (h.charAt(idx1) != ':' && h.charAt(idx1) != ' ') {
            idx1++;
        }
        String name = h.substring(0, idx1);
        while (true) {
            idx1++;
            if (h.charAt(idx1) != ':' && h.charAt(idx1) != ' ') {
                this.headers.put(name, h.substring(idx1));
                return;
            }
        }
    }

    public void dump() {
    }
}
