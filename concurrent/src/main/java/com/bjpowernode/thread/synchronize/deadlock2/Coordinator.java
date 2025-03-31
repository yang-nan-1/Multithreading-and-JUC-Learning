package com.bjpowernode.thread.synchronize.deadlock2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Coordinator
 *
 * @Author Cat
 */
public class Coordinator {

    /**
     * 相当于 哲学家就餐问题：有一个服务员，她发筷子；
     */

    private List<NewMessage> list = new ArrayList<>();

    /**
     * 一次性申请所有锁资源
     *
     * @param message1
     * @param message2
     * @return
     */
    public synchronized boolean apply(NewMessage message1, NewMessage message2) {
        if (list.contains(message1) || list.contains(message2)) {
            return false;
        } else {
            list.add(message1);
            list.add(message2);
            return true;//申请所有的锁资源成功
        }
    }

    public synchronized void free(NewMessage message1, NewMessage message2) {
        list.remove(message1);
        list.remove(message2);
    }
}
