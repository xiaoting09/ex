package com.xiao.ex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class ExWebApplication {
    @Value("${rmi.port}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(ExWebApplication.class, args);
      //  buid();
    }
/*
    public static void buid() {
        //注册通讯端口，该端口默认就是1099
        try {
            //创建一个远程对象
            ExceptionService rhello = new ExceptionServiceImpl();
            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上
            LocateRegistry.createRegistry(8888);
            //把远程对象注册到RMI注册服务器上，并命名为RHello
            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的）
            Naming.bind("rmi://10.5.120.67:8888/exService", rhello);

        } catch (AlreadyBoundException | IOException e) {
            e.printStackTrace();
        }
    }*/

}
