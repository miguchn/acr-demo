package com.example.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderDao {

    private final JdbcTemplate jdbcTemplate;

    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findByOrderId(String orderId) {
        String sql = "select * from t_order where order_id = '" + orderId + "'";
        return jdbcTemplate.queryForList(sql);
    }

    public int insert(String orderId, String customerName, double amount) {
        String sql = "insert into t_order(order_id, customer_name, amount) values ('"
                + orderId + "', '" + customerName + "', " + amount + ")";
        return jdbcTemplate.update(sql);
    }
}
