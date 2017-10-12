package com.xiao.ex.dao;


import com.xiao.ex.common.MyMapper;
import com.xiao.ex.entity.ExClientData;

import java.util.List;

public interface ExClientDataMapper extends MyMapper<ExClientData> {

    List<ExClientData> getDataList(ExClientData data);

    List<ExClientData> getLineData(ExClientData data);
}