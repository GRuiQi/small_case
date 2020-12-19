package com.filter;

import com.util.IPUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class IpFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String ip = req.getRemoteAddr();
        List<String> ipList = IPUtil.getIpList();
        if(ipList.contains(ip)){
            System.out.println("非法ip:"+ip);
            resp.getWriter().print("您所在的ip段被禁止访问");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
