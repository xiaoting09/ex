package com.xiao.ex.service;

import javax.mail.MessagingException;

/**
 * 消息发送通知服务
 *
 * @author 肖亭
 * @since 2017年10月11 17:33
 **/
public interface MsgService {
    /**
     * 发送消息
     *
     * @param to      发送账户
     * @param content 发送内容
     */
    void sendMsg(String to, String content) ;
}
