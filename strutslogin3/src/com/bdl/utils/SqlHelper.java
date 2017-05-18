package com.bdl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 * Created by bdl19 on 2017/5/17.
 */
public class SqlHelper{
    public Connection getConn() {
        Connection conn;
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/test";
            String username = "root";
            String pwd = "root";
            conn = DriverManager.getConnection(url, username, pwd);
            System.out.println("11111111111111111111111111111111111111111111111111111111111111");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}