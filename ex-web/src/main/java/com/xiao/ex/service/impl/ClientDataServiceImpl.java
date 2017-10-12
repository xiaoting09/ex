package com.xiao.ex.service.impl;

import com.xiao.ex.utils.DateUtils;
import com.xiao.ex.dao.ExClientDataMapper;
import com.xiao.ex.entity.ExClientData;
import com.xiao.ex.entity.ExClientList;
import com.xiao.ex.entity.ExList;
import com.xiao.ex.service.ClientDataService;
import com.xiao.ex.service.ExClientListService;
import com.xiao.ex.service.ExListService;
import com.xiao.ex.web.vo.StatisticsReqVo;
import com.xiao.ex.web.vo.StatisticsRespVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            respVo.setTime(DateUtils.formatDate(bean.getExTime(),"MM-dd"));
            respVos.add(respVo);
        });
        return respVos;
    }
}
