package com.bjpowernode.object;

import com.bjpowernode.util.ThreadUtils;

/**
 * Object wait、notify、notifyAll方法
 *
 */
public class Test04 {

    private static final Object MONITOR = new Object();

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (Test04.class) {
                while (i == 0) {
                    try {
                        System.out.println("等待开始......");
                        Test04.class.wait();
                        System.out.println("等待结束......");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        ThreadUtils.sleep(2);

        //main线程
        synchronized (Test04.class) {
            System.out.println("唤醒它start......");
            Test04.class.notify();
            i = 1;
            System.out.println("唤醒它finished......");
        }
    }
}