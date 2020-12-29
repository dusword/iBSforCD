package com.lxjtest.dao;

import com.lxjtest.entity.User;

import javax.crypto.spec.PSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class UserDao {
    public static int insert(User user){
        String sql="insert into test_user values(null,?,?)";
        Object[] params={
                user.getUSER_NAME(),
                user.getUSER_PASSWORD()
        };
        return BaseDao.executeSql(sql,params);
    }

    public static ArrayList<User> selectAll() {
        ArrayList<User> list=new ArrayList<User>();
        ResultSet resultSet=null;
        Connection connection=BaseDao.getConn();
        PreparedStatement preparedStatement=null;
        try {
            String sql="select * from test_user";
            preparedStatement=connection.prepareStatement(sql);

            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                User user=new User(
//                        resultSet.getInt("USER_ID"),
                        resultSet.getString("USER_NAME"),
                        resultSet.getString("USER_PASSWORD")
                );
                user.setUSER_ID(resultSet.getInt("USER_ID"));
                list.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,preparedStatement,connection);
        }

        return list;
    }


    public static int verify(String username, String password) {
        int count=0;
        Connection connection = BaseDao.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql="select count(*) from test_user where USER_NAME=? and USER_PASSWORD=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,preparedStatement,connection);
        }
            return count;
        }

}
