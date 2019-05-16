package com.spirng.reactive.loader;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并行数据加载器。
 * @ClassName ParallelDataLoader
 * @Author Administrator
 * @Date 2019/5/11 12:15
 */
public class ParallelDataLoader extends DataLoader {

    protected  void  doLoad()//并行计算。
    {
        ExecutorService service = Executors.newFixedThreadPool(3);//创建线程池。
        CompletionService completionService = new ExecutorCompletionService(service);
        completionService.submit(super::loadConfigurations,null);//耗时>=1s
        completionService.submit(super::loadUsers,null);//耗时>=2s
        completionService.submit(super::loadOrders,null);//耗时>=3s
        int count = 0;
        while (count<3)//等待三个任务完成。
        {
            if (completionService.poll()!=null)
            {
                count++;
            }
        }
        service.shutdown();//总耗时>=3s。
    }

    public static void main(String[] args) {
        new ParallelDataLoader().doLoad();
    }
}
