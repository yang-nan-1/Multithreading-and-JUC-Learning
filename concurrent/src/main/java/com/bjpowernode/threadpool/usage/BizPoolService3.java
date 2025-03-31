package com.bjpowernode.threadpool.usage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * BizPoolService3
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
@Service
public class BizPoolService3 {

    /**
     * 从spring ioc容器中注入线程池对象
     *
     * 单例的
     *
     */
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor2;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    public void processTask() {
        threadPoolExecutor2.execute(() -> {
            //TODO 要执行的业务逻辑
            //System.out.println("BizPoolService2-->processTask()执行......");
        });
    }
}
