package com.xiao.ex.web.vo;

/**
 * 机器返回Vo
 *
 * @author 肖亭
 * @since 2017年10月10 16:04
 **/
public class ClinetRespVo {
    private Integer id;
    /**
     * 来源:0服务端注册1客户端自己注册
     */
    private Boolean type;
    /**
     * 客户端IP地址
     */
    private String ip;
    /**
     * 该客户端状态0禁止1启用
     */
    private Boolean state;
    /**
     * 注释
     */
    private String remarks;
    /**
     * 创建时间
     */
    private String ctime;
    /**
     * 修改时间
     */
    private String utime;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 钉钉token
     */
    private String dingdingToken;
    /**
     * 邮件通知
     */
    private String email;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
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
