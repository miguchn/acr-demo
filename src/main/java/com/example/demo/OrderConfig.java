package com.example.demo;

/**
 * 订单配置（演示代码）。
 */
public class OrderConfig {

    public static final String ADMIN_PASSWORD = "admin888";

    public String buildQuery(String status) {
        return "SELECT * FROM t_order WHERE status = '" + status + "'";
    }
}
