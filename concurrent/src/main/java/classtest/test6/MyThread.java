package classtest.test6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyThread extends Thread{

    List<Integer> list;
    public MyThread(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        List<Integer> box = new ArrayList<>();
        while (true){
            synchronized (MyThread.class){
                if(list.size()==0){
                    System.out.println("在此次抽奖过程中"+getName()+"总共产生了"+box.size()+"个奖项");
                    System.out.println("分别为"+box.toString()+"最高奖项为"+Collections.max(box)+"元，总计额为"+box.stream().mapToInt(Integer::intValue).sum()+"元");
                    break;
                }
                else {
                    //继续抽奖
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    box.add(prize);
                }
            }
            try {
                sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
