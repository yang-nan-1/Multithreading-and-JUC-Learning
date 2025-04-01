package com.bjpowernode.thread;

import java.io.IOException;

/**
 * java线程底层创建的源码分析
 */
public class Test01 {

    public static void main(String[] args) throws IOException {
        //通过lambda方式创建线程
        new Thread( () -> System.out.println(Thread.currentThread().getName()) ).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        // java --> jni --> c++

        //java thread --> linux pthread_create() 创建的一个线程
        //java的线程不是jvm创建的，是os（linux）内核创建的；
        //java thread 和 os 的线程一一对应；

        //启动JVM进程 --> jvm进程中 比如创建100个线程 -->对应 os 创建100个线程
    }
}
