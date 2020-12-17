package com.shop.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
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

        //获取图书id
        String id = request.getParameter("id");

        //获取Session对象
        HttpSession session = request.getSession();

        //先从session中取出map
        Map<String,Integer> map = (Map<String, Integer>) session.getAttribute("shoppingCart");

        if(map==null){
            //如果是null,说明还未向session添加过数据

            map = new HashMap<>();
        }

        if(map.get(id)==null) {
            //第一次添加
            //key图书编号，value为图书的数量
            map.put(id, 1);
        }else{
            //说明已经向购物车中添加过数据了
            map.put(id,map.get(id)+1);

        }

        //将map放回到session中
        session.setAttribute("shoppingCart",map);
        out.print("添加购物车成功！");
    }
}
