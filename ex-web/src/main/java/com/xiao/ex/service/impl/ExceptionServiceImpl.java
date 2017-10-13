package com.xiao.ex.service.impl;

import com.xiao.ex.common.thread.ServiceExThread;
import com.xiao.ex.core.ExceptionService;
import com.xiao.ex.core.vo.req.ClientVo;
import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.core.vo.resp.Result;
import com.xiao.ex.entity.ExClient;
import com.xiao.ex.entity.ExClientData;
import com.xiao.ex.service.ClientDataService;
import com.xiao.ex.service.ClientService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * 实现
 *
 * @author 肖亭
 * @since 2017年09月11 15:51
 **/

@Service(value = "exceptionService")
public class ExceptionServiceImpl  extends UnicastRemoteObject implements ExceptionService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientDataService clientDataService;

    public ExceptionServiceImpl() throws RemoteException {
        super();
    }


    @Override
    public Result sendMsg(ExceptionVo vo) throws RemoteException {
        ServiceExThread.addExceptionVo(vo);
        return new Result();
    }

    @Override
    @Transactional
    public Result addClient(ClientVo client) throws RemoteException {
        try {
            ExClient exClient = new ExClient();
            exClient.setIsEnabled(Boolean.TRUE);
            exClient.setIp(client.getIp());
            List<ExClient> exClients = clientService.getExClients(exClient);
            if (CollectionUtils.isNotEmpty(exClients)) {
                if (!exClients.get(0).getState()) {
                    exClient = exClients.get(0);
                    exClient.setState(Boolean.FALSE);
                    clientService.updateExClient(exClient);
                }
            } else {
                BeanUtils.copyProperties(client, exClient);
                exClient.setType(Boolean.TRUE);
                clientService.insertExClient(exClient);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result();
    }


}
