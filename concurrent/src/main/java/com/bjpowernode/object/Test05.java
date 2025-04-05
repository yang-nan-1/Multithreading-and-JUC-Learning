package com.bjpowernode.object;

import com.bjpowernode.util.ThreadUtils;

/**
 * Object wait、notify、notifyAll方法
 *
 */
public class Test05 {

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        Test05 test05 = new Test05();

        new Thread(() -> {
            test05.toWait();
        }).start();

        ThreadUtils.sleep(2);

        //main线程
        synchronized (test05) {
            System.out.println("唤醒它start......");
            test05.notify();
            i = 1;
            System.out.println("唤醒它finished......");
        }
    }

    public synchronized void toWait() {
        while (i == 0) {
            try {
                System.out.println("等待开始......");
                wait();
                System.out.println("等待结束......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}