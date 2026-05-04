package com.demo.mysqlredis;

import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try {
            // CONEXIÓN MYSQL
            Connection conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();

            // MEDIR MYSQL
            long startMysql = System.currentTimeMillis();

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM city");

            int total = 0;
            if (rs.next()) {
                total = rs.getInt(1);
            }

            long endMysql = System.currentTimeMillis();

            // CONEXIÓN REDIS
            Jedis jedis = RedisClient.getConnection();

            // GUARDAR EN REDIS
            jedis.set("total_ciudades", String.valueOf(total));

            // MEDIR REDIS
            long startRedis = System.currentTimeMillis();

            String value = jedis.get("total_ciudades");

            long endRedis = System.currentTimeMillis();

            // RESULTADOS
            System.out.println("Total ciudades (MySQL): " + total);
            System.out.println("Valor desde Redis: " + value);

            System.out.println("Tiempo MySQL: " + (endMysql - startMysql) + " ms");
            System.out.println("Tiempo Redis: " + (endRedis - startRedis) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}