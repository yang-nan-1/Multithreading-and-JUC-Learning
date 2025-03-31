package classtest.test3;

public class MyRunnable implements Runnable {
    static volatile int number = 1;
    @Override
    public void run() {
        while (number <= 100){
            if (number % 2 == 1)
                System.out.println(Thread.currentThread().getName()+"获取奇数"+number);
            number++;

        }
    }
}
