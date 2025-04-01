package classtest.test7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import static org.apache.dubbo.rpc.model.ApplicationModel.getName;

public class MyCallable implements Callable {

    List<Integer> list;
    MyCallable(List<Integer> list){
        this.list = list;
    }

    @Override
    public Object call() throws Exception {
        List<Integer> box = new ArrayList<>();
        while (true){
            synchronized (MyCallable.class){
                if(list.size()==0){
                    System.out.println("在此次抽奖过程中"+Thread.currentThread().getName()+"总共产生了"+box.size()+"个奖项");
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
            Thread.sleep(15);
        }
        //获取集合的最大值
        if(box.size()==0)
            return null;
        else
            return Collections.max(box);
    }
}
