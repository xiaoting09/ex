package com.xiao.ex.web.vo;

import java.util.Date;

/**
 * 机器列表返回
 *
 * @author 肖亭
 * @since 2017年10月10 16:18
 **/
public class ClinetReqVo {
    /**
     * ID
     */
    private Integer id;
    /**
     * 状态
     */
    private Integer state;

    /**
     * 备注
     */
    private String remarks;
    /**
     * IP
     */
    private String ip;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮件通知
     */
    private String email;
    /**
     * 钉钉token
     */
    private String dingdingToken;

    /**
     * 删除
     */
    private Boolean isEnabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDingdingToken() {
        return dingdingToken;
    }

    public void setDingdingToken(String dingdingToken) {
        this.dingdingToken = dingdingToken;
    }
}
