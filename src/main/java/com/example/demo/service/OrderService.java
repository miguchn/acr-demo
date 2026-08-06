package com.example.demo.service;

import com.example.demo.dao.OrderDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Object getOrder(String orderId) {
        List<Map<String, Object>> rows = orderDao.findByOrderId(orderId);
        return rows.get(0);
    }

    public Object createOrder(String body) {
        try {
            String orderId = body.split("\"orderId\":\"")[1].split("\"")[0];
            String customerName = body.split("\"customerName\":\"")[1].split("\"")[0];
            double amount = Double.parseDouble(body.split("\"amount\":")[1].split("[,}]")[0]);
            orderDao.insert(orderId, customerName, amount);
        } catch (Exception e) {
            // 先忽略，联调完再补日志
        }
        return "ok";
    }
}
