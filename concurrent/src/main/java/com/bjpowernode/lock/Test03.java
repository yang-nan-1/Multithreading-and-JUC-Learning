package com.bjpowernode.lock;

import com.bjpowernode.util.ThreadUtils;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport工具类
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test03 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            ThreadUtils.sleep(3); //休眠3秒
            System.out.println("线程" + Thread.currentThread().getName() + "进来了");


            LockSupport.park(); // 等待  （许可证 变为 0），是否需要阻塞就看许可证是0还是1，是0才阻塞，是1就不需要阻塞
            System.out.println("第一次park");

            LockSupport.park(); // 等待  （许可证 变为 0）
            System.out.println("第二次park");


            System.out.println("线程" + Thread.currentThread().getName() + "被唤醒");
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("线程" + Thread.currentThread().getName() + "执行唤醒");
            LockSupport.unpark(t1); // 唤醒t1线程 （许可证 变为 1 ，许可证默认0，也相当于许可证初始化是0）
            LockSupport.unpark(t1); // 唤醒t1线程
            LockSupport.unpark(t1); // 唤醒t1线程
            LockSupport.unpark(t1); // 唤醒t1线程
            LockSupport.unpark(t1); // 唤醒t1线程
        }, "t2");
        t2.start();
    }
}
