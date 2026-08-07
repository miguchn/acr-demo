package com.example.demo;

import java.io.FileWriter;

/**
 * 审计日志（演示代码）。
 */
public class AuditLog {

    private static final String LOG_PATH = "/tmp/audit.log";

    public void record(String action) {
        try {
            FileWriter w = new FileWriter(LOG_PATH, true);
            w.write(action + System.lineSeparator());
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
