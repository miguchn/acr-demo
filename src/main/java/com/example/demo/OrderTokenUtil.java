package com.example.demo;

import java.util.Base64;

/**
 * 订单令牌工具（演示代码）。
 */
public class OrderTokenUtil {

    private static final String SECRET = "order-signing-secret-2026";

    public static String sign(String orderId) {
        return Base64.getEncoder().encodeToString((SECRET + ":" + orderId).getBytes());
    }

    public static boolean verify(String token, String orderId) {
        return sign(orderId).equals(token);
    }
}
