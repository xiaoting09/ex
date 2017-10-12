package com.xiao.ex.web.vo;

/**
 * 数据统计请求实体
 *
 * @author 肖亭
 * @since 2017年10月10 15:12
 **/
public class StatisticsReqVo {
    /**
     * 查询天数
     */
    private String day;
    /**
     * 查询客户单IP
     */
    private String clinet;
    /**
     * 查询异常名称
     */
    private String exName;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getClinet() {
        return clinet;
    }

    public void setClinet(String clinet) {
        this.clinet = clinet;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }
}
