package com.shop.servlet;

import com.shop.bean.Book;
import com.shop.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/showCart")
public class ShowCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.print("购物车有以下商品:<br>");

        HttpSession session = request.getSession();

        Map<String,Integer> books = (Map<String, Integer>) session.getAttribute("shoppingCart");

        if(books==null){
            out.print("购物车为空");
            response.setHeader("refresh",
                    "2;url="+request.getContextPath()+"/show");
            return;
        }

        for(Map.Entry<String,Integer> book : books.entrySet()){
            Book b = new Book();
            b = DBUtil.findBookById(book.getKey());
            out.print("名称："+b.getName()+"，数量："+book.getValue()+"<br>");
        }


    }
}
