package com.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * filter就像大门前的守门人
 "*/
@WebFilter("/*")
public class TestFilter implements Filter {

    public TestFilter(){
        System.out.println("构造方法的执行");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化方法的执行");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        System.out.println("doFilter方法的执行");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法的执行");
    }


    /**
     * 生命周期：
     * 1.实例化
     * 2.初始化
     * 3.doFilter
     * 4.销毁
     *
     * 单实例，多线程
     * 定义成员变量并且尝试修改的时候会发生安全问题
     *
     * 假设配置了三个过滤器，他们的执行顺序?
     * xml可以设置执行顺序，而注解是根据类的字母顺序
     *
     * 案例：
     * 1.解决乱码问题
     * 2.控制访问权限
     * 3.过滤非法ip
     * 4.计算请求的耗时
     *
     * 启动Tomcat:
     * 构造方法的执行
     * 初始化方法的执行
     * [2020-12-19 09:40:49,233] Artifact web:war exploded: Artifact is deployed successfully
     * [2020-12-19 09:40:49,234] Artifact web:war exploded: Deploy took 545 milliseconds
     * doFilter方法的执行
     * doFilter方法的执行
     * doFilter方法的执行
     * doFilter方法的执行
     *
     * 停掉Tomcat:
     * 销毁方法的执行
     */
}
