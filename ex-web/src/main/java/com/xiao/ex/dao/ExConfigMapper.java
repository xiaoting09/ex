package com.xiao.ex.dao;


import com.xiao.ex.common.MyMapper;
import com.xiao.ex.entity.ExConfig;

public interface ExConfigMapper extends MyMapper<ExConfig> {

    String findMysqlVersion();

}