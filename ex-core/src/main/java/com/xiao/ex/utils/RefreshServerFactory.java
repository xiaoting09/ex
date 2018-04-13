package com.xiao.ex.utils;

import java.util.Objects;

/**
 * 刷新上报创建
 *
 * @author 肖亭
 * @since 2018年04月13 9:39
 **/
public class RefreshServerFactory {
    /**
     * RPC服务
     */
    public static String rpcHost;
    /**
     * RPC端口
     */
    public static String rpcPort;
    /**
     * http上报地址
     */
    public static String httpHost;

    public static Boolean isHttp() {
        return httpHost != null && httpHost.trim().length() > 0 && !Objects.equals(httpHost, "http.host");
    }


}
