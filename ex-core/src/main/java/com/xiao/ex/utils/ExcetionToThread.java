package com.xiao.ex.utils;

import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.thread.ClientExThread;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * 异常上报
 *
 * @author 肖亭
 * @since 2017年10月25 13:28
 **/
public class ExcetionToThread {
    /**
     * 组装数据
     *
     * @param ex
     * @param request
     * @param body
     */
    public void packageVo(Exception ex, HttpServletRequest request, String body) {
        ExceptionVo vo = new ExceptionVo();
        vo.setContentType(request.getContentType());
        StringWriter sw = new StringWriter();
        Throwable cause = ex.getCause();
        if (cause == null) {
            vo.setClassName(ex.getClass().getName());
            ex.printStackTrace(new PrintWriter(sw, true));
        } else {
            vo.setClassName(cause.getClass().getName());
            cause.printStackTrace(new PrintWriter(sw, true));
        }
        vo.setException(sw.toString());
        vo.setExTime(new Date());
        vo.setIp(IpUtils.getLocalIP() + (request.getLocalPort() != 0 ? ":" + request.getLocalPort() : ""));
        String values = ValueToStr.parameters2String(request.getParameterMap());
        StringBuilder sbf = new StringBuilder();
        if (values != null) {
            sbf.append("get:请求参数\n");
            sbf.append(values);
        }
        if (body != null) {
            sbf.append("\npost请求参数\n");
            sbf.append(body);
        }
        sbf.append("");
        vo.setParameters(sbf.toString());
        vo.setType(request.getMethod());
        ClientExThread.getInstance(null).addExceptionVo(vo);
    }
}
