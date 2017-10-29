package com.xiao.ex.handler;

import org.springframework.context.annotation.Bean;

/**
 * @author 肖亭
 * @since 2017年10月29 14:03
 **/
public class MyExceptionHandlerTest {
    @Bean
    public MyExceptionHandler masterTransactionManager() {
        return new MyExceptionHandler();
    }
}
