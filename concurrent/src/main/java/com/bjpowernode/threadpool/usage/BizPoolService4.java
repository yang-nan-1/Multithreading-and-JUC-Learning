package com.bjpowernode.threadpool.usage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * BizPoolService4
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class BizPoolService4 {

    //基于Executor框架实现线程池：下单
    private ThreadPoolExecutor orderThreadPoolExecutor = new ThreadPoolExecutor(
            8,
            16,
            15,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(100),
            new MyThreadFactory("order-"), //线程池给一个名字，区分是不同业务的线程池
            new ThreadPoolExecutor.CallerRunsPolicy());

    //基于Executor框架实现线程池：发短信
    private ThreadPoolExecutor smsThreadPoolExecutor = new ThreadPoolExecutor(
            8,
            16,
            15,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(100),
            new MyThreadFactory("sms-"),
            new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 下订单 业务方法
     */
    public void doOrderTask() {
        orderThreadPoolExecutor.execute(() -> {
            //TODO 要执行的业务逻辑
            //System.out.println("BizPoolService2-->processTask()执行......");
        });
    }

    /**
     * 发短信 业务方法
     */
    public void doSMSTask() {
        smsThreadPoolExecutor.execute(() -> {
            //TODO 要执行的业务逻辑
            //System.out.println("BizPoolService2-->processTask()执行......");
        });
    }

    /**
     * 自定义线程工厂
     */
    static class MyThreadFactory implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyThreadFactory(String bizName) {
            namePrefix = bizName + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, namePrefix + threadNumber.getAndIncrement());
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    /**
     * main方法测试
     *
     * @param args
     */
    public static void main(String[] args) {
        BizPoolService4 bizPoolService4 = new BizPoolService4();
        bizPoolService4.doOrderTask();
        bizPoolService4.doSMSTask();
    }
}