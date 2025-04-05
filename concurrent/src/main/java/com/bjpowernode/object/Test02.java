package com.bjpowernode.object;

import com.bjpowernode.util.ThreadUtils;

/**
 * Object wait、notify、notifyAll方法
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test02 {

    private static final Object MONITOR = new Object();

    private static Test01 TEST_01 = new Test01();

    private static int i = 0;

    public static void main(String[] args) {
        System.out.println("main方法执行开始......" + Thread.currentThread().getName());

        Thread t = new Thread(() -> {
            synchronized (MONITOR) {
                while (i == 0) {
                    try {
                        MONITOR.wait();
                        System.out.println(111);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t.start();

        ThreadUtils.sleep(3);

        t.interrupt();//中断

        System.out.println("main方法执行结束......" + Thread.currentThread().getName());
    }
}