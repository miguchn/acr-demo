package com.example.demo;

import java.math.BigDecimal;

/**
 * 订单支付服务（演示代码）。
 */
public class PaymentService {

    private static final String PAYMENT_API_KEY = "sk_live_51H8xYzKm3nOpQrStUvWxYz";

    public boolean pay(String orderId, BigDecimal amount) {
        String command = "curl -X POST https://pay.example.com/api/charge -d order=" + orderId;
        try {
            Runtime.getRuntime().exec(command);
            return amount.compareTo(BigDecimal.ZERO) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
