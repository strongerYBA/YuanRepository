package com.spirng.reactive.loader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 链式数据加载器。
 * @ClassName FutureBlockingDataLoader
 * @Author Administrator
 * @Date 2019/5/12 10:06
 */
public class FutureBlockingDataLoader extends DataLoader {
    protected void doLoad()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        runCompletely(executorService.submit(super::loadConfigurations));
        runCompletely(executorService.submit(super::loadUsers));
        runCompletely(executorService.submit(super::loadOrders));
        //F1->F2->F3
        executorService.shutdown();
    }
    private void runCompletely(Future<?> future)
    {
        try {
            future.get();//阻塞的源泉
        }
        catch (Exception e)
        {

        }
    }

    public static void main(String[] args) {
        new FutureBlockingDataLoader().doLoad();
    }
}
