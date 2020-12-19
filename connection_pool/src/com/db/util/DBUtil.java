package com.db.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static{

            ResourceBundle rb = ResourceBundle.getBundle("db");
            driverClass = rb.getString("driverClass");
            url = rb.getString("url");
            username = rb.getString("username");
            password = rb.getString("password");

            try {
                /**
                 * Class.forName加载类是将类进了初始化
                 * 使用Class.forName("com.jdbc.mysql.Driver")加载类的时候，Driver类静态代码块
                 * 中的会执行，作用是将驱动注册到DriverManager里
                 */
                Class.forName(driverClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
