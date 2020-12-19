package util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 数据库操作工具类
 */
public class DBUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        //读取配置文件
         ResourceBundle rb = ResourceBundle.getBundle("db");
         driver = rb.getString("driver");
         url = rb.getString("url");
         username = rb.getString("username");
         password = rb.getString("password");

         //注册数据库驱动

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    //释放连接资源
    public static void release(Connection conn, Statement st, ResultSet res){
        if(conn!=null){
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(st!=null){
            try{
                st.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(res!=null){
            try{
                res.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
