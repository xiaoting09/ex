package com.xiao.ex.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiao.ex.core.vo.req.ExceptionVo;

import java.util.Date;

/**
 * @author 肖亭
 * @since 2018年04月17 14:07
 **/
public class ExceptionWevVo extends ExceptionVo {

    /**
     * 异常发生时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date exTime;

    @Override
    public Date getExTime() {
        return exTime;
    }

    @Override
    public void setExTime(Date exTime) {
        super.setExTime(exTime);
        this.exTime = exTime;
    }
}
