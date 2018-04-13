package com.xiao.ex.handler;

import com.xiao.ex.thread.ClinetExThread;
import com.xiao.ex.utils.ExcetionToThread;
import com.xiao.ex.utils.RefreshServerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常捕获类
 *
 * @author 肖亭
 * @since 2017年10月25 13:24
 **/
public class AExceptionHandler extends ExcetionToThread implements HandlerExceptionResolver, Ordered {
    @Value("${rmi.host:host}")
    private String host;
    @Value("${http.host:httpHost}")
    private String httpHost;
    @Value("${rmi.port:-1}")
    private String port;
    @Value("${rmi.time:60000}")
    private Long time;

    @PostConstruct
    private void init() {
        RefreshServerFactory.httpHost = httpHost;
        RefreshServerFactory.rpcPort = port;
        RefreshServerFactory.rpcHost = host;
        ClinetExThread.getInstance(time);
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        packageVo(ex, request, null);
        return null;
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }


}