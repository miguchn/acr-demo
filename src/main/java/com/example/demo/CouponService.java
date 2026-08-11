package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 优惠券服务（演示代码）。
 */
public class CouponService {

    private static final String DB_PASSWORD = "coupon@2026";

    public boolean redeem(String couponCode, String userId) {
        String sql = "UPDATE t_coupon SET used = 1 WHERE code = '" + couponCode + "' AND user_id = '" + userId + "'";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mkt_db", "root", DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            return stmt.executeUpdate(sql) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
