package com.shop.util;

import com.shop.bean.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * 初始化图书的数据
 */
public class DBUtil {

    private static Map<String,Book> books = new HashMap<>();

    /**
     * 静态代码块：类加载到虚拟机里面，就把数据初始化好
     */
    static{
        books.put("1",new Book("1","Java基础入门","Alice"));
        books.put("2",new Book("2","Java进阶之路","Mike"));
        books.put("3",new Book("3","Java高阶知识","Joe"));
        books.put("4",new Book("4","Java编程案例","pink"));
        books.put("5",new Book("4","颈椎病康复指南","无名氏"));

    }

    //获取全部图书
    public static Map<String,Book> findAllBook(){
        return books;
    }

    //根据id查找查找指定图书
    public static Book findBookById(String id){
        return books.get(id);
    }
}
