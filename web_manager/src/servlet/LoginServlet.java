package servlet;

import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户登录
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //默认登录成功
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);

        //把当前用户的对象放到session域中。会调用User valueBound方法
        HttpSession session = request.getSession();
        session.setAttribute("user",u);

        //跳转到登陆成功页面
        response.sendRedirect(request.getContextPath()+"/users.jsp");

        int a = 1;
    }
}
