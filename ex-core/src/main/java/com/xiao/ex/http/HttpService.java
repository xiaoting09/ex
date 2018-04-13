package com.xiao.ex.http;

import com.xiao.ex.utils.PropertiesUtils;

import java.util.logging.Logger;

/**
 * HTTP上报注册服务
 *
 * @author 肖亭
 * @since 2018年04月13 9:25
 **/
public class HttpService {
    private static Logger log = Logger.getLogger(HttpService.class.toString());
    /**
     * HTTP上报地址
     */
    private static String host;

    public static String getHost() {
        if (host == null) {
            host = PropertiesUtils.getProperty("http.host");
        }
        return host;
    }

    public static void setHost(String host) {
        if (host != null && host.trim().length() > 0 && !"http.host".equals(host)) {
            HttpService.host = host;
        }
    }
}
