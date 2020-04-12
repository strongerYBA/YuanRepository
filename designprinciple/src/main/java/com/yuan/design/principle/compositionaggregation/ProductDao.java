package com.yuan.design.principle.compositionaggregation;

/**
 * @ClassName ProductDao
 * @Author Administrator
 * @Date 2020/1/14 21:32
 */
public class ProductDao {
    private DBConnecttion dbConnecttion;
    public void setDbConnecttion(DBConnecttion dbConnecttion) {
        this.dbConnecttion = dbConnecttion;
    }

    public void addProduct(){
        String conn = dbConnecttion.getConnection();
        System.out.println("使用："+conn+"增加产品！");
    }
}
