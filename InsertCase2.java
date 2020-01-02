package com.bitedu.mysql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class InsertCase {

    public static  DataSource getDataSource()
    {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL("jdbc:mysql://localhost/my_jdbc_db");
        ds.setUser("root");
        ds.setPassword("");

        return ds;
    }
    public static void createTable(){
        Connection connection = null;
        Statement stmt = null;
        DataSource dataSource = null;

        try {
            dataSource = getDataSource();
            connection = dataSource.getConnection();
            //3. 创建语句对象
            stmt = connection.createStatement();
            //4. 执行
            String sql = "create table " +
                    "jdbctable(col1 int, col2 varchar(20))";
            stmt.execute(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            try {
                if (stmt != null){
                    stmt.close();
                }

                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void insertIntoTable(){
        Connection connection = null;
        Statement stmt = null;

        try {
            connection = getDataSource().getConnection();
            connection = DriverManager.getConnection(
                    "jdbc:sqlite:my_jdbc_db"
            );
            //3. 创建语句对象
            stmt = connection.createStatement();
            //4. 执行
            String sql = "insert into jdbctable(col1, col2)" +
                    "values (1, 'hello')";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            try {
                if (stmt != null){
                    stmt.close();
                }

                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void selectTable(){
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = getDataSource().getConnection();
            //3. 创建语句对象
            stmt = connection.createStatement();
            //4. 执行
            String sql = "select * from jdbctable";
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Integer col1 =
                        rs.getInt("col1");
                String col2 = rs.getString("col2");

                System.out.println("col1 = " + col1
                        + " col2" + col2);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            try {
                if (stmt != null){
                    stmt.close();
                }

                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
       //createTable();
        insertIntoTable();
        selectTable();
    }
}
