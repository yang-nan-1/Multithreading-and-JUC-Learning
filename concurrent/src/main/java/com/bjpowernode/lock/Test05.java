package com.bjpowernode.lock;

import com.bjpowernode.util.ThreadUtils;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport.park();
 * LockSupport.unpark(t);
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test05 {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 开始执行......");

                LockSupport.park();

            System.out.println(Thread.currentThread().isInterrupted()); //中断状态

            System.out.println(Thread.currentThread().getName() + " 执行结束.....");
        }, "t线程");
        t.start();

        ThreadUtils.sleep(2);

        System.out.println("main：对t线程进行中断！");
        t.interrupt(); //对t线程做一个中断
        //LockSupport.unpark(t);
        System.out.println("main：执行结束！");
    }
}