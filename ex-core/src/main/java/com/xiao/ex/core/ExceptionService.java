package com.xiao.ex.core;


import com.xiao.ex.core.vo.req.ClientVo;
import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.core.vo.resp.Result;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 异常服务
 *
 * @author 肖亭
 * @since 2017年09月11 15:51
 **/
public interface ExceptionService  extends Remote {
    /**
     * 发送异常信息
     *
     * @param ex)
     */
    Result sendMsg(ExceptionVo ex) throws RemoteException;

    /**
     * 自动上报客户端信息
     *
     * @param client 客户端信息
     */
    Result addClient(ClientVo client) throws RemoteException ;
}
