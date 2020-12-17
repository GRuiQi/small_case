package com.servlet;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * json ajax jquery
 */
@WebServlet(urlPatterns = { "/colorBall"})
public class ColorBallServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        //获取双色球
        List<Integer> balls =  getBall(Integer.parseInt(num));

        String jsonStr= JSON.toJSONString(balls);

        response.getWriter().write(jsonStr);
        System.out.println(jsonStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    //生成双色球
    private List<Integer> getBall(int num){
        //红球是不能重复的，并且需要对生成的双色球进行排序。
        //所以使用TreeSet来存放生成的双色球
        Set<Integer> temp = new TreeSet<>();

        //每生成一注双色球之后，将数据存放在list中
        List<Integer> balls = new ArrayList<>();

        Random r = new Random();

        //根据用户的输入来判断生成多少注双色球
        for (int i = 0; i < num ; i++) {
            //思考：为什么不用for(int i=0;i<6;i++)
            while(temp.size()<6){

                //生成红球儿。nextInt生成一个随机的int值，该值介于[0,n)的区间
                temp.add(r.nextInt(33)+1);
            }

            balls.addAll(temp);

            //将set的数据清空
            temp.clear();

            //篮球：1-16
            balls.add(r.nextInt(16)+1);

        }


        return balls;
    }
}
