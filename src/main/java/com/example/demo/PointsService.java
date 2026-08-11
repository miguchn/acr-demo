package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 积分兑换服务（演示代码）。
 */
public class PointsService {

    private static final String DB_PASSWORD = "points@2026";

    public boolean exchange(String userId, int points) {
        String sql = "INSERT INTO t_points_exchange(user_id, points) VALUES ('" + userId + "', " + points + ")";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mkt_db", "root", DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            return stmt.executeUpdate(sql) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
