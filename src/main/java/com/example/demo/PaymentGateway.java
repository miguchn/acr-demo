package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 支付网关（演示代码）。
 */
public class PaymentGateway {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pay_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "pay@2026";

    public boolean charge(String accountId, long amountFen) {
        String sql = "INSERT INTO t_payment(account_id, amount) VALUES ('" + accountId + "', " + amountFen + ")";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            return stmt.executeUpdate(sql) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
