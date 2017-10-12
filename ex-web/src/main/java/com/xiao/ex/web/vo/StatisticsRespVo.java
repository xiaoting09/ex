package com.xiao.ex.web.vo;

/**
 * 数据返回实体
 *
 * @author 肖亭
 * @since 2017年10月10 15:14
 **/
public class StatisticsRespVo {
    /**
     * 单个异常发生次数
     */
    private String size;
    /**
     * 异常类型
     */
    private String exClass;
    /**
     * 发生时间
     */
    private String time;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getExClass() {
        return exClass;
    }

    public void setExClass(String exClass) {
        this.exClass = exClass;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
