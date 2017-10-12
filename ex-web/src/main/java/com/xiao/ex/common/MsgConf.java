package com.xiao.ex.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 消息配置
 *
 * @author 肖亭
 * @since 2017年10月11 17:20
 **/
@Configuration
public class MsgConf {

    @Value("${java.sender.mail.host}")
    private String host;

    @Value("${java.sender.mail.port}")
    private Integer port;

    @Value("${java.sender.mail.username}")
    private String username;

    @Value("${java.sender.mail.password}")
    private String password;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        return javaMailSender;
    }
}
