package com.yuan.design.pattern.creational.singleton;

public enum EnumInstance {
    INSTANCE{
        protected void printTest(){
            System.out.println(" yuan printTest()");
        }
    };
    //只要添加这个protected abstract 的printest方法才可以访问：INSTANCE内部的printTest方法。
    protected abstract void printTest();
    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static EnumInstance getInstance(){
        return INSTANCE;
    }
}
