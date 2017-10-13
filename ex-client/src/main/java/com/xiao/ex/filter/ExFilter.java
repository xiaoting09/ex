package com.xiao.ex.filter;


import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.rpc.RegistryService;
import com.xiao.ex.thread.ClinetExThread;
import com.xiao.ex.utils.IpUtils;
import com.xiao.ex.utils.PostServletRequest;
import com.xiao.ex.utils.ValueToStr;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Objects;

/**
 * 异常拦截器
 *
 * @author 肖亭
 * @since 2017年09月14 16:13
 **/
public class ExFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String host = filterConfig.getInitParameter("host");
        String port = filterConfig.getInitParameter("port");
        String time = filterConfig.getInitParameter("time");
        if (host != null && host.trim().length() > 0) {
            RegistryService.host = host;
        }
        if (port != null && port.trim().length() > 0) {
            RegistryService.port = Integer.valueOf(port);
        }
        if (host != null && host.trim().length() > 0) {
            RegistryService.host = host;
        }
        ClinetExThread thread = new ClinetExThread();
        if (time != null && time.length() > 0) {
            thread.setTime(Long.valueOf(time));
        }
        new Thread(thread).start();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String enctype = httpRequest.getContentType();
        String body = null;
        String method = httpRequest.getMethod();
        if (Objects.equals(method.toLowerCase(), "post")
                && enctype != null && enctype.equals("application/json")) {
            body = getBody((HttpServletRequest) request);
            request = getRequest(request, body);
        }
        try {
            chain.doFilter(request, response);
        } catch (Exception ex) {
            packageVo(ex, httpRequest, body);
            throw ex;
        }

    }

    private String getBody(HttpServletRequest request) throws IOException {
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (null != bufferedReader) {
                bufferedReader.close();
            }
        }
        body = stringBuilder.toString();
        return body;
    }

    /**
     * 将post解析过后的request进行封装改写
     *
     * @param request
     * @param body
     * @return
     */
    private ServletRequest getRequest(ServletRequest request, String body) {
        String enctype = request.getContentType();
        if (enctype != null && enctype.contains("application/json")) {
            return new PostServletRequest((HttpServletRequest) request, body);
        }
        return request;
    }

    @Override
    public void destroy() {

    }

    /**
     * 组装数据
     *
     * @param ex
     * @param request
     * @param body
     */
    private void packageVo(Exception ex, HttpServletRequest request, String body) {
        ExceptionVo vo = new ExceptionVo();
        vo.setContentType(request.getContentType());
        vo.setException(ex);
        vo.setExTime(new Date());
        vo.setIp(IpUtils.getLocalIP() + (request.getLocalPort() != 0 ? ":" + request.getLocalPort() : ""));
        String values = ValueToStr.parameters2String(request.getParameterMap());
        vo.setParameters("get:请求参数" + values + "\n post请求参数:" + (body != null ? body : ""));
        vo.setType(request.getMethod());
        ClinetExThread.addExceptionVo(vo);
    }
}
