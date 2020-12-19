package dao.impl;

import bean.User;
import dao.UserDao;
import util.DBUtil;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public User findUserByName(String name) {

//       User u = test1(name);
       User u = test2(name);
       return u;
    }

    public static User test2(String name){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        System.out.println("UserDaoImpl.findUserByName: "+name);
        //声明对象的引用
        User u = null;

        String sql = "SELECT tname,email FROM t_user WHERE tname= ?";

        try{
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();
            while(rs.next()){
                    u = new User();
                    u.setName(rs.getString("tname"));
                    u.setEmail(rs.getString("email"));
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn,pstmt,rs);
        }
        System.out.println(u);

        return u;



    }

   /* public static User test1(String name){
        System.out.println("UserDaoImpl.findUserByName: "+name);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User u = null;
        try{
            connection =JdbcUtils.getConnection();

            String sql = "select * from t_user where tname= ?";

            statement = connection.prepareStatement(sql);//预编译sql
            statement.setString(1,name);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                System.out.println(   resultSet.getString("tname"));
                u = new User();
                u.setName(resultSet.getString("tname"));
                u.setEmail(resultSet.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtils.release(connection,statement,resultSet);
        }

        System.out.println(u);
        return u;

    }*/
}
