package com.bit.jdbc;

import java.sql.*;

/*
* 测试resultSet()
* */
public class Demo04 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        PreparedStatement preparedStatement2=null;

        //加载驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
             connection=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/my_database", "root", "");
            String sql="select id from student where id>?";
             preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setObject(1,203);
             resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id"));
            }
            String sql2="create table classes(cno int primary key not null ,cname varchar (20) not null );";
            preparedStatement2=connection.prepareStatement(sql2);
            preparedStatement2.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭顺序遵循后开先关
            try {
                if (preparedStatement2!=null){
                    preparedStatement2.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (resultSet!=null){
                        resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement!=null){
                        preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection!=null){
                        connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
