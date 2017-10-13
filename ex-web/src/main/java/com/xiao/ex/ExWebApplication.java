package com.xiao.ex;


import com.xiao.ex.common.SpringContextUtil;
import com.xiao.ex.common.thread.ServiceExThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class ExWebApplication {

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(ExWebApplication.class, args);
        SpringContextUtil.setApplicationContext(run);
        ServiceExThread thread = new ServiceExThread();
        new Thread(thread).start();
    }

}
