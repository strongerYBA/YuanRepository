package com.tomcat.classloader;

/**
 * 后台启动一条线程，不断刷新重新加载实现了热加载的类。
 * @ClassName MsgHandler
 * @Author Administrator
 * @Date 2019/4/14 10:45
 */
public class MsgHandler implements Runnable {
    @Override
    public void run() {
        while (true)
        {
            BaseManager baseManager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            baseManager.logic();
            try
            {
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
