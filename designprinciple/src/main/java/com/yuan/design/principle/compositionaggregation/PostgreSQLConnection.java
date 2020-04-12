package com.yuan.design.principle.compositionaggregation;

/**
 * @ClassName PostgreSQLConnection
 * @Author Administrator
 * @Date 2020/1/14 21:38
 */
public class PostgreSQLConnection extends DBConnecttion {
    public String getConnection() {
        return "PostgreSQL数据库连接！";
    }
}
