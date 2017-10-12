package com.xiao.ex.service.impl;

import com.xiao.ex.utils.DateUtils;
import com.xiao.ex.dao.ExClientMapper;
import com.xiao.ex.entity.ExClient;
import com.xiao.ex.service.ClientExListService;
import com.xiao.ex.service.ClientService;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.utils.PageUtil;
import com.xiao.ex.web.vo.ClinetRespVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户端处理服务
 *
 * @author 肖亭
 * @since 2017年09月11 20:41
 **/
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ExClientMapper exClientMapper;
    @Autowired
    private ClientExListService clientExListService;

    @Override
    public ExClient findClientByIp(String ip) {
        ExClient client = new ExClient(ip, Boolean.TRUE);
        List<ExClient> clientList = getExClients(client);
        if (CollectionUtils.isEmpty(clientList)) {
            client.setType(Boolean.TRUE);
            return insertExClient(client);
        }
        return clientList.get(0);
    }

    @Override
    public List<ExClient> getExClients(ExClient client) {
        return exClientMapper.select(client);
    }

    @Override
    public void updateExClient(ExClient exClient) {
        exClient.setUpdateTime(new Date());
        exClientMapper.updateByPrimaryKeySelective(exClient);
    }

    @Override
    public List<ClinetRespVo> getClinetList() {
        ExClient exClient = new ExClient();
        exClient.setIsEnabled(Boolean.TRUE);
        List<ExClient> select = exClientMapper.select(exClient);
        List<ClinetRespVo> vos = getClinetRespVos(select);
        return vos;
    }

    private List<ClinetRespVo> getClinetRespVos(List<ExClient> select) {
        if (CollectionUtils.isEmpty(select)) {
            return null;
        }
        List<ClinetRespVo> vos = new ArrayList<>();
        select.forEach(bean -> {
            ClinetRespVo vo = new ClinetRespVo();
            BeanUtils.copyProperties(bean, vo);
            vo.setCtime(DateUtils.formatDate(bean.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            vo.setUtime(DateUtils.formatDate(bean.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
            if (StringUtils.isBlank(vo.getRemarks())) {
                vo.setRemarks("暂无");
            }
            vos.add(vo);
        });
        return vos;
    }

    @Override
    public PageObj getClinetPageList(Integer page) {
        ExClient exClient = new ExClient();
        exClient.setIsEnabled(Boolean.TRUE);
        PageUtil.startPage(page);
        List<ExClient> select = exClientMapper.select(exClient);
        if (CollectionUtils.isEmpty(select)) {
            return PageUtil.getObj(select);
        }
        List<ClinetRespVo> vos = getClinetRespVos(select);
        PageObj obj = PageUtil.getObj(select);
        obj.setList(vos);
        return obj;
    }
    @Transactional
    public ExClient insertExClient(ExClient client) {
        if (client.getState() == null) {
            client.setState(Boolean.TRUE);
        }
        client.setCreateTime(new Date());
        client.setUpdateTime(new Date());
        client.setIsEnabled(Boolean.TRUE);
        exClientMapper.insertUseGeneratedKeys(client);
        return client;
    }

}
