package com.xiao.ex.service;

/**
 * 异常客户端管理
 *
 * @author 肖亭
 * @since 2017年09月11 20:55
 **/
public interface ClientExListService {
    /**
     * 根据客户端ID关联客户端的异常
     *
     * @param id 客户端ID
     */
    void addClinetExList(Integer id);
}
