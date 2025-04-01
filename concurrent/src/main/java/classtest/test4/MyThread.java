package classtest.test4;

import java.util.Random;

public class MyThread extends Thread{
    static double money=100;
    static int size=3;
    static final double MIN=0.01;
    @Override
    public void run() {
        //同步代码块
        synchronized (MyThread.class){
            if(size==0)
                //判断，共享数据是否到了末尾（已经没有了）
                System.out.println(getName()+"没有抢到红包");
            else {
                double prize = 0 ;
                //还有红包
                if(size==1){
                    //最后一个红包，剩余金额，就是红包金额
                    prize=money;
                }
                else {
                    //需要随机金额
                    Random r=new Random();
                    double bound = money - (size-1)*MIN;
                    prize = r.nextDouble() * bound;
                    if(prize<MIN){
                        prize=MIN;
                    }
                }
                //从money中去除中将金额
                money-=prize;
                size--;
                System.out.println(getName()+"抢到红包"+prize);
            }
        }
    }
}
