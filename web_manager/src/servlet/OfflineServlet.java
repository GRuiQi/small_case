package servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/offlineUser")
public class OfflineServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要踢出的用户名
        String  username = req.getParameter("username");

        //将用户名所对应的session对象清除
        HttpSession currentSession = req.getSession();
        ServletContext sc = currentSession.getServletContext();
        //去ServletContext域中获取map对象
        Map<String,HttpSession> map = ( Map<String,HttpSession>) sc.getAttribute("map");
        //获取要踢出用户的session对象
        HttpSession session = map.get(username);
        //将session对象失效，并从map中删除
        if(session!=null){
            session.invalidate();
            map.remove(username);
        }

        resp.sendRedirect(req.getContextPath()+"/users.jsp");



    }
}
