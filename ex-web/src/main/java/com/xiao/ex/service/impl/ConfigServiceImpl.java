package com.xiao.ex.service.impl;

import com.xiao.ex.dao.ExConfigMapper;
import com.xiao.ex.entity.ExConfig;
import com.xiao.ex.service.ConfigService;
import com.xiao.ex.utils.DateUtils;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.utils.PageUtil;
import com.xiao.ex.web.vo.ConfigRespVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典服务
 *
 * @author 肖亭
 * @since 2017年10月11 11:26
 **/
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ExConfigMapper exConfigMapper;

    @Override
    public PageObj getConfgList(Integer page) {

        ExConfig config = new ExConfig();
        config.setIsEnabled(Boolean.TRUE);
        PageUtil.startPage(page);
        List<ExConfig> configs = exConfigMapper.select(config);
        if (CollectionUtils.isEmpty(configs)) {
            return PageUtil.getObj(configs);
        }
        List<ConfigRespVo> respVos = new ArrayList<>();
        configs.forEach(bean -> {
            ConfigRespVo vo = new ConfigRespVo();
            vo.setId(bean.getId().toString());
            vo.setValue(bean.getValue());
            vo.setName(bean.getName());
            vo.setDesc(bean.getDescription());
            vo.setCtime(DateUtils.formatDate(bean.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            vo.setUtime(DateUtils.formatDate(bean.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
            respVos.add(vo);
        });
        PageObj obj = PageUtil.getObj(configs);
        obj.setList(respVos);
        return obj;
    }

    @Override
    @Transactional
    public void addConfig(ExConfig config) {
        exConfigMapper.insertSelective(config);
    }

    @Override
    @Transactional
    public void delConfig(Integer id) {
        ExConfig config = new ExConfig();
        config.setIsEnabled(Boolean.FALSE);
        config.setId(id);
        exConfigMapper.updateByPrimaryKeySelective(config);
    }

    @Override
    public List<ExConfig> getConf(String name) {
        ExConfig config= new ExConfig();
        config.setIsEnabled(Boolean.TRUE);
        config.setName(name);
        return exConfigMapper.select(config);
    }
}
