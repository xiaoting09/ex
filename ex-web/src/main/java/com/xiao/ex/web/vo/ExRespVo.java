package com.xiao.ex.web.vo;

/**
 * 异常列表返回实体
 *
 * @author 肖亭
 * @since 2017年10月11 16:22
 **/
public class ExRespVo {
    /**
     * ID
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 别名
     */
    private String nickName;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 异常类型
     */
    private Boolean type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}
