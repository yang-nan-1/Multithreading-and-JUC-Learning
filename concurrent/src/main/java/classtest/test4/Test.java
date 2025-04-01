package classtest.test4;

public class Test {
    /**
     * 简单模拟并发的微信抢红包过程
     * @param args
     */
    public static void main(String[] args) {
        //创建线程
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();

        //设置线程名
        t1.setName("a");
        t2.setName("b");
        t3.setName("c");
        t4.setName("d");
        t5.setName("e");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
