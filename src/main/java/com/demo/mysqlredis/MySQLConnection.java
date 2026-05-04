package com.demo.mysqlredis;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/world";
            String user = "root";
            String password = "root";

            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}