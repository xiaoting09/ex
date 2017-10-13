package com.xiao.ex.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 返回
 *
 * @author 肖亭
 * @since 2017年10月13 10:13
 **/
public class ExDataRespVo {
    /**
     * ID
     */
    private Long id;
    /**
     * 客户端ip
     */
    private String clientIp;
    /**
     * 错误异常类
     */
    private String exClass;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 请求方式GET还是POST
     */
    private String type;
    /**
     * 数据格式
     */
    private String contentType;
    /**
     * 异常发生时间
     */
    private String exTime;
    /**
     * 请求参数集合json
     */
    private String parameters;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getExClass() {
        return exClass;
    }

    public void setExClass(String exClass) {
        this.exClass = exClass;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public String getExTime() {
        return exTime;
    }

    public void setExTime(String exTime) {
        this.exTime = exTime;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}
