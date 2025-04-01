package com.bjpowernode.thread;

/**
 * 线程interrupt
 *
 */
public class Test14 {

    public static void main(String[] args) throws Exception {

        /*Thread t1 = new Thread( () -> {
            for (int i = 0; i < 10000; i++) {
                //通过中断状态可以优雅地把一个正在运行的线程停下来
                if (Thread.currentThread().isInterrupted()) {
                    break;
                    //return;
                }
                System.out.println(Thread.currentThread().getName() + "......" + Thread.currentThread().isInterrupted()+ i);
            }
        });
        t1.start();*/

        Thread t2 = new Thread( () -> {
            //ThreadUtils.sleep(15);
            //for (int i = 0; i < 10; i++) {
            for (;;) {
                System.out.println("中断睡眠..." + Thread.currentThread().isInterrupted());
            }
        });
        t2.start();

        //main线程
        for (int i=0; i<100; i++) {
            System.out.println(Thread.currentThread().getName() + "......" + i);
        }

        t2.join();

        //t1.interrupt();//中断一个正在运行的线程，但是实际上并没有真正地中断，只是标记了该线程是中断状态

        t2.interrupt();//中断一个正在休眠的线程
    }
}