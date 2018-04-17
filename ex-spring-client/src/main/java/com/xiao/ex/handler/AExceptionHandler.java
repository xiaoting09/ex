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
    private String rmiHost;
    @Value("${http.host:httpHost}")
    private String httpHost;
    @Value("${rmi.port:-1}")
    private String port;
    @Value("${rmi.time:60000}")
    private Long time;

    @PostConstruct
    private void init() {
        if (httpHost != null && !"httpHost".equals(httpHost)) {
            RefreshServerFactory.httpHost = httpHost;
        }
        if (port != null && !"-1".equals(port)) {
            RefreshServerFactory.rpcPort = port;
        }
        if (rmiHost != null && !"host".equals(rmiHost)) {
            RefreshServerFactory.rpcHost = rmiHost;
        }
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

    public String getRmiHost() {
        return rmiHost;
    }

    public void setRmiHost(String rmiHost) {
        this.rmiHost = rmiHost;
        RefreshServerFactory.rpcHost = rmiHost;
    }

    public String getHttpHost() {
        return httpHost;
    }

    public void setHttpHost(String httpHost) {
        this.httpHost = httpHost;
        RefreshServerFactory.httpHost = httpHost;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
        RefreshServerFactory.rpcPort = port;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
