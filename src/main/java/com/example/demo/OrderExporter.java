package com.example.demo;

import java.io.FileWriter;

/**
 * 订单导出（演示代码）。
 */
public class OrderExporter {

    public void export(String orderId, String path) {
        try {
            FileWriter writer = new FileWriter(path + "/" + orderId + ".csv");
            writer.write("order," + orderId);
            writer.close();
        } catch (Exception e) {
            // ignore
        }
    }
}
