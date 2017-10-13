package com.xiao.ex.rpc;

import com.xiao.ex.utils.PropertiesUtils;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

/**
 * @author 肖亭
 * @since 2017年10月07 16:33
 **/
public class RegistryService {
    private static Registry registry;
    private static Logger log = Logger.getLogger(RegistryService.class.toString());
    public static String host;
    public static Integer port;

    public static Registry getRegistry() {
        if (registry == null) {
            try {
                registry = LocateRegistry.getRegistry(getHost(), getPort());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return registry;
    }

    public static String getHost() {
        if (host == null) {
            log.warning("请检查填写rpc Host地址");
            return PropertiesUtils.getProperty("rpc.host");
        }
        return host;
    }

    public static Integer getPort() {
        if (port == null) {
            String port = PropertiesUtils.getProperty("rpc.port");
            log.warning("请检查填写rpc端口号");
            return port != null && port.trim().length() > 0 ? Integer.valueOf(port) : null;
        }
        return port;
    }

}
