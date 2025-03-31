package com.bjpowernode.threadpool.usage;

import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * BizPoolService2
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
@Service
public class BizPoolService2 {

    //private ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(8);

    //基于Executor框架实现线程池
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            8,
            16,
            15,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(100),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public void processTask() {
        threadPoolExecutor.execute(() -> {
            //TODO 要执行的业务逻辑
            //System.out.println("BizPoolService2-->processTask()执行......");
        });
    }
}
