package com.xiao.ex.rpc;

import com.xiao.ex.utils.PropertiesUtils;
import com.xiao.ex.utils.RefreshServerFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.logging.Logger;

/**
 * @author 肖亭
 * @since 2017年10月07 16:33
 **/
public class RegistryService {
    private static Remote registry;
    private static Logger log = Logger.getLogger(RegistryService.class.toString());
    public static String host;
    public static Integer port;

    public static Remote getRegistry() {
        if (registry == null) {
            try {
                registry = Naming.lookup("rmi://" + getHost() + ":" + getPort() + "/exService");
            } catch (NotBoundException | MalformedURLException | RemoteException e) {
                e.printStackTrace();
            }
        }
        return registry;
    }

    /**
     * 重试
     */
    public static void refreshAndRetry() {
        try {
            registry = Naming.lookup("rmi://" + getHost() + ":" + getPort() + "/exService");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }

    public static String getHost() {
        host = RefreshServerFactory.rpcHost;
        if (host == null) {
            host = PropertiesUtils.getProperty("rmi.host");
        }
        if (host == null) {
            log.warning("请检查填写rpc Host地址");
        }
        return host;
    }

    public static Integer getPort() {
        if (RefreshServerFactory.rpcPort != null && RefreshServerFactory.rpcPort.trim().length() > 0) {
            port = Integer.valueOf(RefreshServerFactory.rpcPort);
        }
        if (port == null) {
            String ports = PropertiesUtils.getProperty("rmi.port");
            port = ports != null && ports.trim().length() > 0 ? Integer.valueOf(ports) : null;
        }
        if (port == null) {
            log.warning("请检查填写rpc端口号");
        }
        return port;
    }
}
