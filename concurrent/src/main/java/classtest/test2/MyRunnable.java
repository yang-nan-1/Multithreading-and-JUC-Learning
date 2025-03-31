package classtest.test2;

public class MyRunnable implements Runnable {
    static volatile int gift = 100;
    @Override
    public void run() {
        while(gift >=10){
            try {
                gift--;
                System.out.println(Thread.currentThread().getName()+"发出一份礼物，礼物剩余:"+gift);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(gift<10){
            System.out.println(Thread.currentThread().getName()+"没有礼物了");
        }
    }
}
