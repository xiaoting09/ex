package com.xiao.ex.service.impl;


import com.xiao.ex.common.SpringContextUtil;
import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.dao.ExClientListMapper;
import com.xiao.ex.entity.ExClient;
import com.xiao.ex.entity.ExClientData;
import com.xiao.ex.entity.ExClientList;
import com.xiao.ex.entity.ExList;
import com.xiao.ex.service.*;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.utils.PageUtil;
import com.xiao.ex.web.vo.ExListRespVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖亭
 * @since 2017年09月13 11:25
 **/
@Service(value = "exClientListService")
public class ExClientListServiceImpl implements ExClientListService {
    @Autowired
    private ExClientListMapper exClientListMapper;
    @Autowired
    private ClientDataService clientDataService;
    @Autowired
    private ClientService clientService;
    @Resource(name = "emailMsgService")
    private MsgService msgService;
    @Autowired
    private ExListService exListService;

    @Override
    public List<ExClientList> findExClinetList(ExClientList clientList) {
        return exClientListMapper.select(clientList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addExClinet(ExceptionVo vo) {
        try {
            ExClient client = clientService.findClientByIp(vo.getIp());
            ExClientData data = new ExClientData();
            data.setClientId(client.getId());
            data.setExClass(vo.getClassName());
            data.setParameters(vo.getParameters());
            data.setMsg(vo.getException());
            data.setType(vo.getType());
            data.setContentType(vo.getContentType());
            data.setExTime(vo.getExTime());
            clientDataService.addClientData(data);
            if (data.getId() != null) {
                sendMsg(client, data.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PageObj getPageList(Integer page) {
        ExClientList clientList = new ExClientList();
        clientList.setIsEnabled(true);
        PageUtil.startPage(page);
        List<ExClientList> exClinetList = findExClinetList(clientList);
        if (CollectionUtils.isEmpty(exClinetList)) {
            return PageUtil.getObj(exClinetList);
        }
        List<ExListRespVo> vos = new ArrayList<>();
        exClinetList.forEach(bean -> {
            ExListRespVo vo = new ExListRespVo();
            vo.setId(bean.getId());
            ExClient exClient = new ExClient();
            exClient.setId(bean.getClientId());
            List<ExClient> exClients = clientService.getExClients(exClient);
            if (CollectionUtils.isNotEmpty(exClients)) {
                vo.setClinetName(exClients.get(0).getIp());
            }
            ExList exList = new ExList();
            exList.setId(bean.getListId());
            List<ExList> list = exListService.findList(exList);
            if (CollectionUtils.isNotEmpty(list)) {
                vo.setExName(list.get(0).getName());
            }
            vos.add(vo);
        });
        PageObj obj = PageUtil.getObj(exClinetList);
        obj.setList(vos);
        return obj;
    }

    @Override
    public void addExClinetList(ExClientList exClientList) {
        exClientListMapper.insertSelective(exClientList);
    }

    @Override
    public void updateById(Integer id) {
        ExClientList exClien = new ExClientList();
        exClien.setId(id);
        exClien.setIsEnabled(false);
        exClientListMapper.updateByPrimaryKeySelective(exClien);
    }

    /**
     * TODO:如需扩展手机发送则在此扩展
     *
     * @param client
     * @param msg
     */
    private void sendMsg(ExClient client, String msg) {
        if (StringUtils.isNotBlank(client.getEmail().trim())) {
            msgService.sendMsg(client.getEmail(), msg);
        }
    }

}
