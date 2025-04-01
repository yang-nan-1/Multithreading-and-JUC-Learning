package classtest.test5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyThread extends Thread{
    List<Integer> list;

    MyThread(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            synchronized (MyThread.class){
                if(list.size()==0){
                    break;
                }
                else {
                    //继续抽奖
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    System.out.println(getName()+"抽中了"+prize+"元的大奖");
                }
            }
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
