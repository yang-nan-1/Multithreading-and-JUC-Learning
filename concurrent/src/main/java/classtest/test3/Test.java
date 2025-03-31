package classtest.test3;

public class Test {
    /**
     * 两个人对共享资源的获取，这里模拟的取100以内的奇数
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
