package com.xiao.ex.core.vo.req;



import java.io.Serializable;

/**
 * 客户端VO
 *
 * @author 肖亭
 * @since 2017年09月13 11:30
 **/
public class ClientVo implements Serializable{
    /**
     * 客户端IP
     */
    private String ip;
    /**
     * 客户端启用状态 默认启用
     */
    private Boolean state=Boolean.TRUE;
    /**
     * 客户端注释
     */
    private String remarks;

    public ClientVo() {
    }

    public ClientVo(String ip) {
        this.ip = ip;
    }

    public ClientVo(String ip, Boolean state) {
        this.ip = ip;
        this.state = state;
    }

    public ClientVo(String ip, Boolean state, String remarks) {
        this.ip = ip;
        this.state = state;
        this.remarks = remarks;
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
}
