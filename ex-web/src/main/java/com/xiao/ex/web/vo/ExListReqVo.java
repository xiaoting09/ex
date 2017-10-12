package com.xiao.ex.web.vo;

/**
 * @author 肖亭
 * @since 2017年10月11 18:47
 **/
public class ExListReqVo {
    /**
     * ID
     */
    private Integer id;
    /**
     * 异常名称
     */
    private String exName;
    /**
     * 客户端ID
     */
    private Integer clinetId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public Integer getClinetId() {
        return clinetId;
    }

    public void setClinetId(Integer clinetId) {
        this.clinetId = clinetId;
    }
}
