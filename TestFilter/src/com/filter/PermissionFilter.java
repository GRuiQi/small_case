package com.filter;

import com.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class PermissionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //获取请求路径
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String path = request.getServletPath();
        //判断当前请求的路径是否包含success
        if(path.startsWith("/success")){
            //判断用户是否登陆
            HttpSession session =  request.getSession();

            if(session==null){
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }else{
                User user = (User)session.getAttribute("user");
                if(user==null){
                    response.sendRedirect(request.getContextPath()+"/login.jsp");

                }
            }

        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
