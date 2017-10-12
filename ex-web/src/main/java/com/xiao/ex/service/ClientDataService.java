package com.xiao.ex.service;


import com.xiao.ex.entity.ExClientData;
import com.xiao.ex.web.vo.StatisticsReqVo;
import com.xiao.ex.web.vo.StatisticsRespVo;

import java.util.List;

/**
 * Created by xiaoting on 2017/9/13.
 */
public interface ClientDataService {
    /**
     * 添加异常消息
     *
     * @param data data
     */
    void addClientData(ExClientData data);

    /**
     * 查询饼图显示数据
     *
     * @param vo vo
     * @return
     */
    List<StatisticsRespVo> getDataList(StatisticsReqVo vo);

    /**
     * 查询折线图
     *
     * @param reqVo
     * @return
     */
    List<StatisticsRespVo> getLineData(StatisticsReqVo reqVo);
}
