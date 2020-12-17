package bean;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Map;

public class User implements HttpSessionBindingListener {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 把该对象放到Session域中就会触发该方法
     * @param event
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        ServletContext sc = event.getSession().getServletContext();
        //获取ServletContext域中的map对象
        Map<String,HttpSession> map = (Map<String,HttpSession>)sc.getAttribute("map");
        //将用户信息放到map中
        map.put(username,event.getSession());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
