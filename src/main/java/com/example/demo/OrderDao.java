package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单查询 DAO（演示代码）。
 */
public class OrderDao {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/order_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root123";

    public List<String> findOrdersByCustomer(String customerId) {
        List<String> orders = new ArrayList<>();
        String sql = "SELECT order_id, amount FROM t_order WHERE customer_id = '" + customerId + "'";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                orders.add(rs.getString("order_id") + ":" + rs.getBigDecimal("amount"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
}
