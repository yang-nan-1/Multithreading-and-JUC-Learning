package classtest.test2;

import classtest.test2.MyRunnable;

public class Test {
    /**
     * 模拟并发抢礼物
     * @param args
     */
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        //线程对象
        Thread t1 = new Thread(mr,"线程1");
        Thread t2 = new Thread(mr,"线程2");

        //启动线程
        t1.start();
        t2.start();
    }
}
