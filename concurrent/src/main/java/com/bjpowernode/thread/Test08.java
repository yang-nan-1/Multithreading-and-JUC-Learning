package com.bjpowernode.thread;

/**
 * 线程休眠
 *
 */
public class Test08 {

    public static void main(String[] args) {
        System.out.println("main方法start........." + Thread.currentThread().getName()); //main线程

        Thread thread = new Thread( () -> {
            System.out.println("线程执行start......" + Thread.currentThread().getName()); //thread-0
            try {
                //获取当前线程，把当前线程休眠2秒
                Thread.sleep(20000L); //thread-0 sleep

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行end......" + Thread.currentThread().getName()); //thread-0
        });
        thread.start();

        try {
            Thread.sleep(1000L); //main线程sleep
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main方法end........." + Thread.currentThread().getName()); //main
    }
}