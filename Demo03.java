package com.bit.jdbc;

import java.sql.*;

/*
 * 测试preparedStatement基本用法，防止sql注入
 * 可以setObject()方法处理参数，不用管参数是什么类型
 * */
public class Demo03 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();
            /*
             * 建立连接（连接对象内部其实包含了Socket对象），是一个远程连接，比较耗时，这是Connection对象管理的一个要点
             * 真正的开发中，为了提高效率，都会使用连接池来管理连接对象
             * */
            //连接数据库
             connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/my_database", "root", "");
            long end = System.currentTimeMillis();
            System.out.println("建立连接耗时：" + (end - start) + "ms");
            String name="马建";
            String sql="insert into student values (?,?)";//?占位符
             preparedStatement=connection.prepareStatement(sql);
//            传参方式1：
            preparedStatement.setInt(1,203);//参数从1开始计算而不是0
            preparedStatement.setString(2,"杨柳柳");
//            传参方式2
//            preparedStatement.setObject(1,207);
//            preparedStatement.setObject(2,"马健家家爱");
            /*
            * 如果有时间参数那么：
            * ps.setDate(x,new java.sql,Date(System.currentTimeMillis()));
            * */
            System.out.println("插入一行记录");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
