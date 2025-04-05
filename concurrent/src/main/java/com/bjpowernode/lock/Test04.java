package com.bjpowernode.lock;

import com.bjpowernode.util.ThreadUtils;

/**
 * Object wait、notify、notifyAll方法，先通知后等待，将无法唤醒
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test04 {

    private static Object MONITOR = new Object();

    private static Test04 TEST_01 = new Test04();

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("开始通知");
            synchronized (TEST_01) {
                TEST_01.notify();

                System.out.println("通知结束了");
                ThreadUtils.sleep(5);
            }
        }).start();

        ThreadUtils.sleep(3);

        //想让main线程在此处等待
        synchronized (TEST_01) {
            while (i == 0) {
                TEST_01.wait(); //等待并释放MONITOR的锁
            }
        }
    }
}