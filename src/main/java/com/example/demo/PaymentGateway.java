package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 */
public class PaymentGateway {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pay_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "pay@2026";

    public boolean charge(String accountId, long amountFen) {
        String sql = "INSERT INTO t_payment(account_id, amount) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, accountId);
            ps.setLong(2, amountFen);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
