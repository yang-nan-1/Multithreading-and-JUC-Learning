package com.bjpowernode.thread.synchronize;

/**
 * synchronized关键字使用语法
 * 1、方法上
 * 2、代码块上
 *
 */
public class Test00 {

    public static void main(String[] args) {
        Test00 test00 = new Test00();
        test00.test1();
        test00.test2();
    }

    public synchronized void test1() {
        System.out.println("test1......");
    }

    public void test2() {
        synchronized(this) {
            System.out.println("test2......");
        }
    }
}