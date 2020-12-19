package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //设置post请求的字符编码，控制台打印就不会出现乱码
        req.setCharacterEncoding("utf-8");//只对post请求有效

        /**
         * get请求乱码怎么办？
         * E:\apache-tomcat-8.5.54\conf\server.xml
         * 找到端口号的地方 添加URIEncoding="UTF-8"
         *
         * 即：<Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
         *
         */

        //设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
