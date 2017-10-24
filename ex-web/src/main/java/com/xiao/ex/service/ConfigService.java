package com.xiao.ex.service;

import com.xiao.ex.entity.ExConfig;
import com.xiao.ex.utils.PageObj;

import java.util.List;

/**
 * Created by xiaoting on 2017/10/11.
 */
public interface ConfigService {
    /**
     * 获取配置列表
     *
     * @param page
     * @return
     */
    PageObj getConfgList(Integer page);

    /**
     * 新增配置
     *
     * @param config
     */
    void addConfig(ExConfig config);

    /**
     * 删除配置
     *
     * @param id
     */
    void delConfig(Integer id);

    /**
     * 根据name获取所有的值
     *
     * @param name
     */
    List<ExConfig> getConf(String name);

    /**
     * 判断MySql是否大于5.7
     *
     * @return
     */
    Boolean isVersion();

}
