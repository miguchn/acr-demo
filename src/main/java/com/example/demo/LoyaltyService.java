package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 积分服务（演示代码）。
 */
public class LoyaltyService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/loyalty_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "loyalty@2026";

    public boolean addPoints(String memberId, int points) {
        String sql = "INSERT INTO t_points(member_id, points) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, memberId);
            ps.setInt(2, points);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
