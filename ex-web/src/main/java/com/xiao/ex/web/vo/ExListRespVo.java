package com.xiao.ex.web.vo;

/**
 * @author 肖亭
 * @since 2017年10月11 18:26
 **/
public class ExListRespVo {
    /**
     * ID
     */
    private Integer id;
    /**
     * 异常名称
     */
    private String exName;
    /**
     * 客户端名称
     */
    private String clinetName;

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

    public String getClinetName() {
        return clinetName;
    }

    public void setClinetName(String clinetName) {
        this.clinetName = clinetName;
    }
}
