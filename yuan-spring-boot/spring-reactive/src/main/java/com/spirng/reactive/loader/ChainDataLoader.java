package com.spirng.reactive.loader;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName ChainDataLoader
 * @Author Administrator
 * @Date 2019/5/12 10:24
 */
public class ChainDataLoader extends DataLoader {
    protected  void doLoad()
    {
        CompletableFuture
                .runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete((result,throwable)->{//完成时回调。
                    System.out.println("[线程: "+Thread.currentThread().getName()+"]加载完成！！！");
                })
                .exceptionally(throwable -> {
                    System.out.println("[线程: "+Thread.currentThread().getName()+"]加载异常！！！");
                    return null;
                })
                .join();//等待完成。
    }

    public static void main(String[] args) {
        new ChainDataLoader().doLoad();
    }
}
