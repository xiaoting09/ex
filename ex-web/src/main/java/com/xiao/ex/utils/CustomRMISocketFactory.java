package com.xiao.ex.utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * @author 肖亭
 * @since 2017年10月13 16:58
 **/
public class CustomRMISocketFactory extends RMISocketFactory {
    private int p = 8886;

    public CustomRMISocketFactory(int port) {
        this.p = port;
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        if (port == 0) port = this.p;
        return new Socket(host, port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if (port == 0) port = this.p;
        return new ServerSocket(port);
    }

}
