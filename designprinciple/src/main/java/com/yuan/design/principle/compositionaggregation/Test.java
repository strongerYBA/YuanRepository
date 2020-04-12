package com.yuan.design.principle.compositionaggregation;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2020/1/14 21:33
 */
public class Test {
    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        dao.setDbConnecttion(new PostgreSQLConnection());
        dao.addProduct();
    }
}
