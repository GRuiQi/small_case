package com.shop.servlet;

import com.shop.bean.Book;
import com.shop.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/show")
public class ShowBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 解决乱码
         */
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.print("全部java书籍:<br/>");

        //获取全部书籍
        Map<String, Book> books = DBUtil.findAllBook();

        //生成html
        /**
         *  entrySet()是将map里的每一个键值对取出来
         *  封装成一个Entry对象在存到一个Set里面。
         *  Map.Entry是Map里的一个节点
         */
        for(Map.Entry<String,Book> book : books.entrySet()){
            String url1 = request.getContextPath()+"/addCart?id="+book.getKey();
            out.print("<a href='"+url1+"'>"+book.getValue().getName()+"</a><br>");

        }
        out.print("<br>");
        out.print("<a href='"+request.getContextPath()+"/showCart'>查看购物车</a><br>");
        out.print("<a href='"+request.getContextPath()+"/clearCart"+"'>清空购物车</a><br>");

    }
}
