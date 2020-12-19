package com.servlet;

import com.bean.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
/*
        //设置post请求的字符编码，控制台打印就不会出现乱码
        req.setCharacterEncoding("utf-8");//只对post请求有效

        *//**
         * get请求乱码怎么办？
         * E:\apache-tomcat-8.5.54\conf\server.xml
         * 找到端口号的地方 添加URIEncoding="UTF-8"
         *
         * 即：<Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
         *
         *//*

        //设置响应编码
        resp.setContentType("text/html;charset=utf-8");
    */

       /* String username =req.getParameter("username");
        System.out.println(username);
        resp.getWriter().print("username:"+username);*/

        String username =req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username,password);

        req.getSession().setAttribute("user",user);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
