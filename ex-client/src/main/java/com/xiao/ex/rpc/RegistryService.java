package com.xiao.ex.rpc;

import com.xiao.ex.utils.PropertiesUtils;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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

    public static String getHost() {
        if (host == null) {

            host = PropertiesUtils.getProperty("host");
        }
        if (host == null) {
            log.warning("请检查填写rpc Host地址");
        }
        return host;
    }

    public static Integer getPort() {
        if (port == null) {
            String ports = PropertiesUtils.getProperty("port");
            port = ports != null && ports.trim().length() > 0 ? Integer.valueOf(ports) : null;
        }
        if (port == null) {
            log.warning("请检查填写rpc端口号");
        }
        return port;
    }
}
