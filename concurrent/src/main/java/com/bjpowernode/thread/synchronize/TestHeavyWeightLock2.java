package com.bjpowernode.thread.synchronize;

public class TestHeavyWeightLock2 {

    public synchronized void doWork1() {
        System.out.println("doWork1线程执行......");
    }

    public void doWork2() {
        synchronized (this) {
            System.out.println("doWork2线程执行......");
        }
    }

    public void doWork3() {
        synchronized (TestHeavyWeightLock2.class) {
            System.out.println("doWork3线程执行......");
        }
    }

    public void doWork4() {
        System.out.println("doWork4线程执行......");
    }
}
