package com.bjpowernode.object;

import com.bjpowernode.util.ThreadUtils;

/**
 * Object wait、notify、notifyAll方法
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test01 {

    private static Object MONITOR = new Object();

    private static Test01 TEST_01 = new Test01();

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main方法start......" + Thread.currentThread().getName());

        new Thread(() -> {
            ThreadUtils.sleep(2);
            System.out.println("开始通知");

            synchronized (TEST_01) {
                TEST_01.notify();
                i = 1;

                System.out.println("通知结束了");

                ThreadUtils.sleep(5);
            }

        }).start();

        //想让main线程在此处等待
        synchronized (TEST_01) {
            while (i == 0) {
                TEST_01.wait(); //等待并释放MONITOR的锁
            }
        }

        System.out.println("main方法end......" + Thread.currentThread().getName());
    }
}