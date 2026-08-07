package com.example.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单缓存（演示代码）。
 */
public class OrderCache {

    private static final Map<String, String> CACHE = new HashMap<>();

    public String getOrder(String orderId) {
        if (!CACHE.containsKey(orderId)) {
            String sql = "SELECT detail FROM t_order WHERE order_id = '" + orderId + "'";
            CACHE.put(orderId, sql);
        }
        return CACHE.get(orderId);
    }
}
