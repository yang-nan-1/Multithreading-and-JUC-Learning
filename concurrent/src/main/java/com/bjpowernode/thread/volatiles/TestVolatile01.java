package com.bjpowernode.thread.volatiles;

/**
 * @ClassName TestVolatile
 *
 * @Author Cat
 */
public class TestVolatile01 {

    //共享变量
    //private boolean isRunning = true;

    private volatile boolean isRunning = true;

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public static void main(String[] args) throws InterruptedException {
        TestVolatile01 testVolatile2 = new TestVolatile01();

        //线程 t
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start..");
            while (testVolatile2.isRunning()) {

            }
            System.out.println(Thread.currentThread().getName() + " end..");
        }, "t线程");
        t.start();

        Thread.sleep(1000);

        //把isRunning共享变量设置为false
        testVolatile2.setRunning(false);

        System.out.println("isRunning status:" + testVolatile2.isRunning());
    }
}