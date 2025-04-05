package com.bjpowernode.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport工具类
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test02 {

    public static void main(String[] args) {

        System.out.println(TimeUnit.SECONDS.toNanos(1));

        Thread t1 = new Thread(() -> {
            System.out.println("线程" + Thread.currentThread().getName() + "进来了");
            //LockSupport.park(); // 等待
            //LockSupport.parkNanos(1_000_000_000); // 等待1秒
            //LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(3));  //Thread.sleep(3000L)

            //注意这里的时间需要使用系统时间加上需要等待的时间
            LockSupport.parkUntil(System.currentTimeMillis() + 3000);

            System.out.println("线程" + Thread.currentThread().getName() + "被唤醒");
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("线程" + Thread.currentThread().getName() + "执行唤醒");
            LockSupport.unpark(t1); // 唤醒t1线程
        }, "t2");
        t2.start();
    }
}
