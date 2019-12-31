package com.bitedu.mysql;

import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HelloWorld {
    private static String HELLO = "nihao";
    private static long length = 1024;
    static
    {
        length = 33;
        int i = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Connection connection = null;
        Statement stmt = null;
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/",
                            "root",
                            "");

            stmt = connection.createStatement();

            stmt.execute("create database my_jdbc_db");
     } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
