package com.bjpowernode.thread.volatiles;

/**
 * @ClassName TestVolatile04
 *
 * @Author Cat
 */
public class TestVolatile04 {

    private static int x, y, a, b = 0;
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            //初始化4个变量
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 3; //（1）
                    x = b; //（2）
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 3; //（3）
                    y = a; //（4）
                }
            });
            //两个线程启动
            t1.start();
            t2.start();

            t1.join();
            t2.join();

            count++;
            if (x == 0 && y == 0) {
                System.out.println("(break) 执行次数:" + count + ", x=" + x + ", y=" + y + ", a=" + a + ", b=" + b);
                break;
            }
        }
    }
}