package com.redis.dynamicthreadpool.dynamic;

import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class DynamicThreadPoolExecutorManager {
    @Resource
    private ApplicationContext applicationContext;
    public void refreshThreadPoolExecutor(Properties properties){
        applicationContext.getBeansOfType(DynamicThreadPoolExecutor.class).forEach((beanName,executor)->{
            executor.setCorePoolSize(Integer.parseInt(properties.getProperty("core-pool-size","16")));
            executor.setMaximumPoolSize(Integer.parseInt(properties.getProperty("maximum-pool-size","16")));
            if(executor.getQueue() instanceof ResizeLinkedBlockingQueue<Runnable>){
                ((ResizeLinkedBlockingQueue) executor.getQueue()).setCapacity(Integer.parseInt(properties.getProperty("queue-capacity","1024")));
            }
        });
    }
}
