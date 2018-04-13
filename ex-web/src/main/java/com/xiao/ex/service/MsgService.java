package com.xiao.ex.service;


import com.xiao.ex.entity.ExClient;
import com.xiao.ex.entity.ExClientData;

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
     * @param client      发送账户
     * @param data    发送内容
     */
    void sendMsg(ExClient client, ExClientData data) ;
}
