package classtest.test5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test5 {
    /**
     * 模拟奖池抽奖
     * @param args
     */

    public static void main(String[] args) {
        //创建奖池
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,10,5,20,50,100,200,500,800,2,80,300,700);


        MyThread t1 = new MyThread(list);
        MyThread t2 = new MyThread(list);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}
