package com.filter;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

/**
 * 计算请求和响应的时间
 */
@WebFilter("/*")
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        LocalTime begin = LocalTime.now();
        chain.doFilter(servletRequest,servletResponse);
        LocalTime end = LocalTime.now();
        //计算请求响应耗时 单位是毫秒
        Duration total = Duration.between(begin, end);
        System.out.println("请求 "+req.getRequestURI()+"耗时："+total.toMillis());
    }

    @Override
    public void destroy() {

    }
}
