package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;
import java.util.Map;

@WebListener
public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession currentSession = se.getSession();
        ServletContext sc = currentSession.getServletContext();
        Map<String, List<HttpSession>> ipMap = (Map<String, List<HttpSession>>) sc.getAttribute("imMap");

        //从session中取出ip地址
        String ip = (String)currentSession.getAttribute("ip");
        List<HttpSession> sessionList = ipMap.get(ip);
        //因为已经将听到session销毁，所以从list中移除掉当前的currentSession
        sessionList.remove(currentSession);

        //如果list的长度是0，则说明该ip发出的session对象全部失效，可以将ip从map中移除
        //如果list的长度不是是0，则说明该ip发出的session对象还在，将list的变化重新写到map
        if(sessionList.size()==0){
            ipMap.remove(ip);
        }else{
            ipMap.put(ip,sessionList);
        }

        sc.setAttribute("ipMap",ipMap);
    }
}
