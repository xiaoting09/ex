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
    public static Logger log = Logger.getLogger(RegistryService.class.toString());

    public static Registry getRegistry() {
        if (registry == null) {
            try {
                String port = PropertiesUtils.getProperty("rpc.port");
                if (port == null) {
                    log.warning("请检查填写rpc端口号");
                    return null;
                }
                registry = LocateRegistry.getRegistry(PropertiesUtils.getProperty("rpc.host"), Integer.valueOf(port));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return registry;
    }

}
