package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;


    static{
        try{
          //.properties要放在src路径下
          InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
          Properties properties = new Properties();
          properties.load(in);
          driver = properties.getProperty("driver");
          url = properties.getProperty("url");
          username = properties.getProperty("username");
          password = properties.getProperty("password");
          //驱动只能加载一次
            Class.forName(driver);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {

         Connection connection =  DriverManager.getConnection(url,username,password);
         return connection;
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
