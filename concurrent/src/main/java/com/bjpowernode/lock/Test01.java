package com.bjpowernode.lock;

import com.bjpowernode.util.ThreadUtils;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport工具类
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test01 {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + "开始执行.......");

        Thread mainThread = Thread.currentThread();

        new Thread(() -> {
            ThreadUtils.sleep(3);
            LockSupport.unpark(mainThread); //3秒之后唤醒主线程
        }).start();

        LockSupport.park(); //当前线程阻塞（main线程） Object wait()

        System.out.println(Thread.currentThread().getName() + "结束执行.......");
    }
}