package filter;

import bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 权限过滤器
 */
@WebFilter("/*")
public class PermissionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //获取用户的请求路径
        String path = request.getServletPath();

        //排除掉css样式，不拦截静态资源
        if (!path.contains("/login")&&!path.startsWith("/plugins")){
            //判断当前请求的用户是否已经登陆成功
            HttpSession session = request.getSession();
            if(session==null){
                //跳转到登陆界面
                response.sendRedirect(request.getContextPath()+"/login.jsp");
                return;
            }else{
                User user = (User)session.getAttribute("user");
                if(user==null){
                    //用户还未登陆或已经被踢出
                    response.sendRedirect(request.getContextPath()+"/login.jsp");
                    return;
                }
            }

        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
