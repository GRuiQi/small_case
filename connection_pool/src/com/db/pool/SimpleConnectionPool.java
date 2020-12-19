package com.db.pool;
import com.db.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;;
import java.util.LinkedList;



public class SimpleConnectionPool  {

    //创建一个存放链接的池子，需要保证线程安全
    //Collection.synchronizedList 返回线程安全的list
    private static LinkedList<Connection> pool =
            (LinkedList<Connection>)Collections.synchronizedList(new LinkedList<Connection>());


    static{
        for (int i = 0; i <10 ; i++) {
            try {
                Connection connection = DBUtil.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ExceptionInInitializerError("初始化数据库连接池异常");
            }
        }
    }

    public static Connection getConnectionFromPool(){
        Connection conn = null;

        if(pool.size()>0){
            conn = pool.removeFirst();
            return conn;
        }else{
            throw new RuntimeException("服务器繁忙...");
        }
    }

    public static void release(Connection conn){
        pool.addLast(conn);
    }

}
