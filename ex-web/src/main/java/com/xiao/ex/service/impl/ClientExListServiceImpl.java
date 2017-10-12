package com.xiao.ex.service.impl;

import com.xiao.ex.dao.ExClientListMapper;
import com.xiao.ex.entity.ExClientList;
import com.xiao.ex.entity.ExList;
import com.xiao.ex.service.ClientExListService;
import com.xiao.ex.service.ExListService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现
 *
 * @author 肖亭
 * @since 2017年09月11 20:56
 **/
@Service
public class ClientExListServiceImpl implements ClientExListService {
    @Autowired
    private ExListService exListService;
    @Autowired
    private ExClientListMapper exClientListMapper;

    @Override
    public void addClinetExList(Integer id) {
        List<ExList> exLists = exListService.findList(new ExList(Boolean.FALSE, Boolean.TRUE));
        if (CollectionUtils.isEmpty(exLists)) {
            return;
        }
        exLists.forEach(ex -> {
            ExClientList exClientList = new ExClientList();
            exClientList.setClientId(id);
            exClientList.setListId(ex.getId());
            exClientListMapper.insertUseGeneratedKeys(exClientList);
        });

    }
}
