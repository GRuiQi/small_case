package com.db.test;

import com.db.pool.MyPool;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        DataSource ds = new MyPool();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //这个地方不能关闭，需要重新放回连接池中
            //conn.close();

            //添加一个接口，接口里有relese(Connection conn)方法
            //让MyPool实现该接口，重写release方法即可
            ((MyPool) ds).release(conn);
        }
    }
}
