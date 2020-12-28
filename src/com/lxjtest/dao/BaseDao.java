package com.lxjtest.dao;

import java.sql.*;

public class BaseDao {

    static String url = "jdbc:mysql://152.136.120.171:3306/TEST"; //数据库名
    static String username = "root";  //数据库用户名
    static String password = "lxj19990716";  //数据库用户密码

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("succeed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConn() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static int executeSql(String sql, Object[] paramas) {
        int count = 0;
        Connection connection = BaseDao.getConn();

        PreparedStatement preparedStatement =null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < paramas.length; i++) {
                preparedStatement.setObject(i + 1, paramas[i]);
            }
            count = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
    public static void closeAll (ResultSet rs, PreparedStatement ps, Connection conn) {

            try {
                if(rs!=null) {
                    rs.close();
                }
                if (ps!=null) {
                    ps.close();
                }
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

    }
}
