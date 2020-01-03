package com.bit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) {
        Connection connection=null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            long start=System.currentTimeMillis();
            /*
            * 建立连接（连接对象内部其实包含了Socket对象），是一个远程连接，比较耗时，这是Connection对象管理的一个要点
            * 真正的开发中，为了提高效率，都会使用连接池来管理连接对象
            * */
            //连接数据库
             connection=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/my_database","root","");
            long end=System.currentTimeMillis();
            System.out.println("建立连接耗时："+(end-start)+"ms");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
