package com.xiao.ex.entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;


@Table(name = "ex_client_data")
public class ExClientData {
    @Id
    private Long id;
    /**
     * 客户端ID
     */
    @Column(name = "client_id")
    private Integer clientId;
    /**
     * 错误异常类
     */
    @Column(name = "ex_class")
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
     * 请求格式
     */
    @Column(name = "content_type")
    private String contentType;
    /**
     * 创建地址
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;
    /**
     * 是否可用
     */
    @Column(name = "is_enabled")
    private Boolean isEnabled;
    /**
     * 异常发生时间
     */
    @Column(name = "ex_time")
    private Date exTime;
    /**
     * 请求参数集合json
     */
    private String parameters;
    /**
     * 天数
     */
    @Transient
    private Integer day;
    /**
     * 总数
     */
    @Transient
    private Integer size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Date getExTime() {
        return exTime;
    }

    public void setExTime(Date exTime) {
        this.exTime = exTime;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}