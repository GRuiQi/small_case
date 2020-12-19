package com.db.pool;

import com.db.util.DBUtil;
import com.db.util.PoolClose;

import javax.sql.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * 遵循数据库连接池规范
 */
public class MyPool implements DataSource ,PoolClose {

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


    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = null;

        if(pool.size()>0){
            conn = pool.removeFirst();
            return conn;
        }else{
            throw new RuntimeException("服务器繁忙...");
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public void release(Connection conn) {
        pool.addLast(conn);
    }
}
