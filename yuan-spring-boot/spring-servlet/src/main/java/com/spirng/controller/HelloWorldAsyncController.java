package com.spirng.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

/**
 * HelloWorldAsyncController异步controller
 * @ClassName HelloWorldAsyncController
 * @Author Administrator
 * @Date 2019/5/6 22:08
 */
@RestController
@EnableScheduling
public class HelloWorldAsyncController {
    private BlockingQueue<DeferredResult<String>> queue=new ArrayBlockingQueue<>(5);
    //产生超时随机数。
    private Random random = new Random();
    @Scheduled(fixedRate = 5000)//固定时长5秒执行。
    public void  process()//定时操作。
    {
        try{
        DeferredResult<String> result=null;
        do {
            result = queue.take();
            //随机超时时间。
            long timeOut = random.nextInt(100);
            //模拟等待时间。
            Thread.sleep(timeOut);
            //计算结果。
            result.setResult("Hello,world");
           println("执行计算结果，消 耗："+timeOut+"毫秒（ms）");
        }while (result!=null);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @GetMapping("/completionStage-hello-world")
    public CompletionStage<String> completionStage()
    {
        final long startTime = System.currentTimeMillis();
        println("CompletionStage hello world ....");
        return CompletableFuture.supplyAsync(()->{
            long costTime = System.currentTimeMillis()-startTime;
            println("执行计算结果，消 耗："+costTime+"毫秒（ms）");
           return  "CompletionStage hello world ....!!!!!!!!!";
        });
    }
    @GetMapping("/callable-hello-world")
    public Callable<String> callableHelloWorld()
    {
        final long startTime = System.currentTimeMillis();
        return ()->{
            long costTime = System.currentTimeMillis()-startTime;
            println("执行计算结果，消 耗："+costTime+"毫秒（ms）");
          return "callableHelloWorld";
        };
    }
    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld()
    {
        DeferredResult<String> result = new DeferredResult<>(50L);//50毫秒。
//        result.setResult("hello,world");
        //入队操作。
        queue.offer(result);

        result.onCompletion(()->{//回调。
          println("执行结束");
        });
        result.onTimeout(()->{
            println("执行超时");
        });
        return null;
    }
    private static  void println(Object object)
    {
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController["+threadName+"]:"+object);
    }
}
