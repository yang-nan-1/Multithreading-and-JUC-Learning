package com.bjpowernode.threadpool.usage;

import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * BizPoolService1
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
@Service
public class BizPoolService1 {

    /**
     * 业务方法，处理任务
     */
    public void processTask() {
        //基于Executor框架实现线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                8,
                16,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);

        //允许核心线程也可以销毁
        //threadPoolExecutor.allowCoreThreadTimeOut(true);

        threadPoolExecutor.execute(() -> {
            //TODO 要执行的业务逻辑
            //System.out.println("BizPoolService1-->processTask()执行......");
        });

        //线程池关闭
        threadPoolExecutor.shutdown();
    }



    /**
     * 业务方法，处理任务
     */
    public void processTask2() {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();
        simpleThreadPool.getThreadPoolExecutor().execute(() -> {
            //TODO 要执行的业务逻辑
            //System.out.println("BizPoolService1-->processTask()执行......");
        });
    }
}