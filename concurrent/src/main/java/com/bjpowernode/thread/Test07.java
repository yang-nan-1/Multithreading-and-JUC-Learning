package com.bjpowernode.thread;

/**
 * 当前线程
 *
 */
public class Test07 extends Thread {

    public Test07() {
        System.out.println("new Test07()......" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("线程执行......" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("main方法........." + Thread.currentThread().getName());

        Test07 test07 = new Test07();
        test07.start();
    }
}