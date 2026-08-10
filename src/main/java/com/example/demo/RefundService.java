package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 退款服务（演示代码）。
 */
public class RefundService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/order_db";

    public boolean refund(String orderId, String operator) {
        String sql = "UPDATE t_order SET status = 'REFUNDED' WHERE order_id = '" + orderId
            + "' AND operator = '" + operator + "'";
        try (Connection conn = DriverManager.getConnection(DB_URL, "root", "root123");
             Statement stmt = conn.createStatement()) {
            return stmt.executeUpdate(sql) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
