package com.xiao.ex.service.impl;

import com.sun.scenario.effect.Color4f;
import com.xiao.ex.dao.ExListMapper;
import com.xiao.ex.entity.ExList;
import com.xiao.ex.service.ExListService;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.utils.PageUtil;
import com.xiao.ex.web.vo.ExRespVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 异常集合处理类
 *
 * @author 肖亭
 * @since 2017年09月11 20:58
 **/
@Service
public class ExListServiceImpl implements ExListService {
    @Autowired
    private ExListMapper exListMapper;


    @Override
    public List<ExList> findList(ExList exList) {
        return exListMapper.select(exList);
    }

    @Override
    public ExList addEx(String exName) {
        ExList exList = new ExList(exName);
        exList.setType(!exName.contains("java.lang"));
        exList.setCreateTime(new Date());
        exList.setUpdateTime(new Date());
        exList.setIsEnabled(Boolean.TRUE);
        exListMapper.insertUseGeneratedKeys(exList);
        return exList;
    }

    @Override
    public ExList findExOrAdd(String exName) {
        List<ExList> list = findList(new ExList(exName));
        if (CollectionUtils.isEmpty(list)) {
            return addEx(exName);
        }
        return list.get(0);
    }

    @Override
    public List<String> getExList() {
        ExList exList = new ExList();
        exList.setIsEnabled(Boolean.TRUE);
        List<ExList> list = findList(exList);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.stream().map(ExList::getName).collect(Collectors.toList());
    }

    @Override
    public PageObj getExListPage(Integer page) {
        ExList exList = new ExList();
        exList.setIsEnabled(Boolean.TRUE);
        PageUtil.startPage(page);
        List<ExList> list = findList(exList);
        if (CollectionUtils.isEmpty(list)) {
            return PageUtil.getObj(list);
        }
        List<ExRespVo> vos = new ArrayList<>();
        list.forEach(bean -> {
            ExRespVo vo = new ExRespVo();
            BeanUtils.copyProperties(bean, vo);
            vos.add(vo);
        });
        PageObj obj = PageUtil.getObj(list);
        obj.setList(vos);
        return obj;
    }

    @Override
    @Transactional
    public void updateEx(ExList exList) {
        exListMapper.updateByPrimaryKeySelective(exList);
    }

    @Override
    @Transactional
    public void addEx(ExList exList) {
        exListMapper.insertSelective(exList);
    }
}
