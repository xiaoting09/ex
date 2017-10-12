package com.xiao.ex.web.vo;

/**
 * @author 肖亭
 * @since 2017年10月11 11:50
 **/
public class ConfigReqVo {
    /**
     * ID
     */
    private Integer id;
    /**
     * 字典值
     */
    private String value;
    /**
     * 字典名
     */
    private String name;
    /**
     * 备注
     */
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
