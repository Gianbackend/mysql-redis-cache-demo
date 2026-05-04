package com.demo.mysqlredis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import redis.clients.jedis.Jedis;

public class Main {

    public static void main(String[] args) {

        try {
            // MySQL
            Connection conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM city");

            if (rs.next()) {
                int total = rs.getInt(1);
                System.out.println("Total ciudades: " + total);

                // Redis
                Jedis jedis = RedisClient.getConnection();
                jedis.set("total_ciudades", String.valueOf(total));

                System.out.println("Guardado en Redis!");
                System.out.println("Valor en Redis: " + jedis.get("total_ciudades"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}