package classtest.test7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test7 {
    /**
     * 模拟奖池抽奖,再进一步，找到是哪一个奖池抽中了大奖
     * @param args
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建奖池
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,10,5,20,50,100,200,500,800,2,80,300,700);

        //创建多线程的参数对象
        MyCallable mc = new MyCallable(list);

        //创建多线程运行结果的管理者对象
        FutureTask<Integer> ft1 = new FutureTask<>(mc);
        FutureTask<Integer> ft2 = new FutureTask<>(mc);

        //创建多线程对象
        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        t1.start();
        t2.start();

        Integer max1 = ft1.get();
        Integer max2 = ft2.get();

        if (max1 > max2)
            System.out.println("在此次抽奖过程中" + t1.getName() + "产生了最大奖项，抽中了" + max1 + "元大奖");
        else
            System.out.println("在此次抽奖过程中" + t2.getName() + "产生了最大奖项，抽中了" + max2 + "元大奖");
    }
}
