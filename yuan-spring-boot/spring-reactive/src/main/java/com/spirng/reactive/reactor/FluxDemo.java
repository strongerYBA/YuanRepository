package com.spirng.reactive.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Flux 示例.
 * @ClassName Fluex
 * @Author Administrator
 * @Date 2019/5/12 17:35
 */
public class FluxDemo {
    public static void main(String[] args)  {

        println("运行。。。。");
        Flux.just("A","B","C")//发布ABC
//                .publishOn(Schedulers.elastic())//线程池的切换。弹性线程。
                .map(value->"+"+value)//"A"->"+"转换。
//                .subscribe(FluxDemo::println,//消费数据 = onNext
//                        FluxDemo::println,//异常处理。=onError
//                        ()->{println("完成操作！！！！");},//完成回调。=onComplete()
//                        subscription->{ //背压操作。=onSubscribe()
//                            subscription.request(Integer.MAX_VALUE);//请求的元素数量。
//                            subscription.cancel();//取消上游传输数据到下游来。
//                        }
//                );//序列。依次执行。
        .subscribe(new Subscriber<String>() {
            private Subscription subscription;
            private int count = 0;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Integer.MAX_VALUE);

            }

            @Override
            public void onNext(String s) {
                if (count==2)
                {
                    throw new RuntimeException("故意抛异常！！！");
                }
                println(s);
                count++;
            }

            @Override
            public void onError(Throwable throwable) {
                println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                println("完成操作！！！！");
            }
        });

//    Thread.sleep(1000L);
    }
    private static  void  println(Object object)
    {
        String threadName = Thread.currentThread().getName();
        System.out.println("[线程："+threadName+"] "+object);
    }
}
