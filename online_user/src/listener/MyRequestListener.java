package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *   监听request对象的初始化
 *     - 获取客户端的ip
 *     - 获取session对象
 *     - 创建list对象，将session对象放到list中
 *     - 将ip和list放到Map中
 *     - 将Map放到ServletContext中
 */
@WebListener()
public class MyRequestListener implements ServletRequestListener{

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        //获取请求对象
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        //获取请求ip
        String ip = request.getRemoteAddr();

        System.out.println("ip is:"+ip);

        //拿ServletContext域
        ServletContext sc = sre.getServletContext();

        //从ServletContext中获取ipMap
        Map<String, List<HttpSession>> ipMap = (Map<String, List<HttpSession>>) sc.getAttribute("ipMap");

        //获取当前key为该ip的list对象
        List<HttpSession> list = ipMap.get(ip);
        if (list==null){
            list = new LinkedList<>();

        }
        //获取当前请求关联的session
        HttpSession currentSession = request.getSession();

        //遍历list,如果存在请求所关联的session，则说明是同一个请求对象
        for(HttpSession s:list){
            if(s==currentSession){
                return;
            }
        }

        //前面条件不满足时，则说明该ip产生了一个新的session对象，
        //需要将对象放到list中
        list.add(currentSession);

        //将list添加到map中
        ipMap.put(ip,list);

        sc.setAttribute("ipMap",ipMap);

        //把ip地址放到session里面
        currentSession.setAttribute("ip",ip);

    }
}
