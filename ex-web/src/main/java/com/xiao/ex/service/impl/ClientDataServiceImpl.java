package com.xiao.ex.service.impl;

import com.xiao.ex.entity.ExClient;
import com.xiao.ex.service.ClientService;
import com.xiao.ex.utils.DateUtils;
import com.xiao.ex.dao.ExClientDataMapper;
import com.xiao.ex.entity.ExClientData;
import com.xiao.ex.entity.ExClientList;
import com.xiao.ex.entity.ExList;
import com.xiao.ex.service.ClientDataService;
import com.xiao.ex.service.ExClientListService;
import com.xiao.ex.service.ExListService;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.utils.PageUtil;
import com.xiao.ex.web.vo.ExDataReqVo;
import com.xiao.ex.web.vo.ExDataRespVo;
import com.xiao.ex.web.vo.StatisticsReqVo;
import com.xiao.ex.web.vo.StatisticsRespVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 异常详情
 *
 * @author 肖亭
 * @since 2017年09月13 11:04
 **/
@Service
public class ClientDataServiceImpl implements ClientDataService {
    @Autowired
    private ExListService exListService;
    @Autowired
    private ExClientDataMapper exClientDataMapper;
    @Autowired
    private ExClientListService exClientListService;
    @Autowired
    private ClientService clientService;


    @Override
    @Transactional
    public void addClientData(ExClientData data) {
        ExList ex = exListService.findExOrAdd(data.getExClass());
        ExClientList clientList = new ExClientList();
        clientList.setListId(ex.getId());
        clientList.setClientId(data.getClientId());
        clientList.setIsEnabled(true);
        List<ExClientList> exClinetList = exClientListService.findExClinetList(clientList);
        if (CollectionUtils.isNotEmpty(exClinetList)) {
            return;
        }
        data.setCreateTime(new Date());
        data.setUpdateTime(new Date());
        data.setIsEnabled(Boolean.TRUE);
        exClientDataMapper.insertUseGeneratedKeys(data);
    }

    @Override
    public List<StatisticsRespVo> getDataList(StatisticsReqVo vo) {
        ExClientData data = getExClientData(vo);
        List<ExClientData> rList = exClientDataMapper.getDataList(data);
        if (CollectionUtils.isEmpty(rList)) {
            return null;
        }
        List<StatisticsRespVo> respVos = new ArrayList<>();
        rList.forEach(bean -> {
            StatisticsRespVo respVo = new StatisticsRespVo();
            respVo.setExClass(bean.getExClass());
            respVo.setSize(bean.getSize().toString());
            respVos.add(respVo);
        });
        return respVos;
    }

    private ExClientData getExClientData(StatisticsReqVo vo) {
        ExClientData data = new ExClientData();
        if (StringUtils.isNotBlank(vo.getClinet())) {
            data.setClientId(Integer.valueOf(vo.getClinet()));
        }
        if (StringUtils.isNotBlank(vo.getExName())) {
            data.setExClass(vo.getExName());
        }
        if (StringUtils.isNotBlank(vo.getDay())) {
            data.setDay(Integer.valueOf(vo.getDay()));
        }
        return data;
    }

    @Override
    public List<StatisticsRespVo> getLineData(StatisticsReqVo reqVo) {
        ExClientData data = getExClientData(reqVo);
        List<ExClientData> rList = exClientDataMapper.getLineData(data);
        if (CollectionUtils.isEmpty(rList)) {
            return null;
        }
        List<StatisticsRespVo> respVos = new ArrayList<>();
        rList.forEach(bean -> {
            StatisticsRespVo respVo = new StatisticsRespVo();
            respVo.setSize(bean.getSize().toString());
            respVo.setTime(DateUtils.formatDate(bean.getExTime(), "MM-dd"));
            respVos.add(respVo);
        });
        return respVos;
    }

    @Override
    public PageObj getExList(ExDataReqVo vo) {
        Example example = new Example(ExClientData.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("isEnabled", true);
        if (vo.getClientId() != null) {
            criteria.andEqualTo("clientId", vo.getClientId());
        }
        example.setOrderByClause("create_time desc");
        PageUtil.startPage(vo.getPage());
        List<ExClientData> datalist = exClientDataMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(datalist)) {
            return PageUtil.getObj(datalist);
        }
        List<ExDataRespVo> respVos = new ArrayList<>();
        datalist.forEach(bean -> {
            ExDataRespVo respVo = getExDataRespVo(bean);
            respVos.add(respVo);
        });
        PageObj obj = PageUtil.getObj(datalist);
        obj.setList(respVos);
        return obj;
    }

    private ExDataRespVo getExDataRespVo(ExClientData bean) {
        ExDataRespVo respVo = new ExDataRespVo();
        BeanUtils.copyProperties(bean, respVo);
        ExClient client = clientService.getClientById(bean.getClientId());
        String time = DateUtils.formatDate(bean.getExTime(), "yyyy-MM-dd HH:mm:ss");
        respVo.setExTime(time);
        respVo.setClientIp(client.getIp());
        return respVo;
    }

    @Override
    public ExDataRespVo getData(Long id) {
        ExClientData data = exClientDataMapper.selectByPrimaryKey(id);
        if (data == null) {
            return null;
        }
        return getExDataRespVo(data);
    }
}
