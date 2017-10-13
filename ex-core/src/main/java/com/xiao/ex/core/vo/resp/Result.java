package com.xiao.ex.core.vo.resp;

import java.io.Serializable;

/**
 * 接口返回类
 *
 * @author xiaoting
 * @create 2017-03-23 14:04
 **/
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    public Result(Object data) {
        this.data = data;
    }

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result() {
    }

    /**
     * 错误码
     */
    private int code = 1;
    /**
     * 数据节点
     */
    private Object data;
    /**
     * 错误信息
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
