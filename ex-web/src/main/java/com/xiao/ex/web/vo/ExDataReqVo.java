package com.xiao.ex.web.vo;

/**
 * @author 肖亭
 * @since 2017年10月13 9:39
 **/
public class ExDataReqVo {
    /**
     * 机器ID
     */
    private Integer clientId;
    /**
     * 分页查询
     */
    private Integer page;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
