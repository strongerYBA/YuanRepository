package com.spirng.reactive.loader;

import java.util.concurrent.TimeUnit;

/**
 * 阻塞（串行 ）数据加载。
 * @ClassName DataLoader
 * @Author Administrator
 * @Date 2019/5/11 11:57
 */
public class DataLoader {
    public final void  load()
    {
        long startTime = System.currentTimeMillis();//开始时间。
        doLoad();//具体执行。
        long costTime = System.currentTimeMillis()-startTime;//消耗时间。
        System.out.println("load() 总耗时："+costTime+" 毫秒");
    }
    protected void doLoad()//串行计算。
    {
        loadConfigurations();//耗时1秒。
        loadUsers();//耗时2秒。
        loadOrders();//耗时3秒。
        //总耗时6秒。
    }
    protected final void loadConfigurations()
    {
        loadMock("loadConfigurations",1);
    }
    protected final void loadUsers()
    {
        loadMock("loadUsers",2);
    }
    protected final void loadOrders()
    {
        loadMock("loadOrders",3);
    }
    private void loadMock(String source,int seconds)
    {
        try
        {
            long startTime =  System.currentTimeMillis();
            long milliseconds = TimeUnit.SECONDS.toMillis(startTime);
            Thread.sleep(1000);
            long costTime = System.currentTimeMillis()-startTime;
            System.out.printf("[线程：%s]%s耗时：%d 毫秒\n",
                    Thread.currentThread().getName(),source,costTime);

        }
        catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new DataLoader().load();
    }
}
