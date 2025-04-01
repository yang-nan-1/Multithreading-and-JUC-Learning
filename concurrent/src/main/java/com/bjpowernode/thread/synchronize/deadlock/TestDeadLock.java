package com.bjpowernode.thread.synchronize.deadlock;

/**
 * @ClassName TestDeadLock
 *
 * @Author Cat
 */
public class TestDeadLock {

    private static Object lock1 = new Object();

    private static Object lock2 = new Object();

    public static void main(String[] args) {
        System.out.println("Thread-main start");

        //第一个线程
        new Thread(() -> {
            synchronized (lock1){
                try {
                    System.out.println("thread-01 start");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("thread-01 end");
                }
            }
        }, "t1").start();

        //第二个线程
        new Thread(() -> {
            synchronized (lock2){
                try {
                    System.out.println("thread-02 start");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("thread-02 end");
                }
            }
        }, "t2").start();

        System.out.println("Thread-main End");
    }
}
