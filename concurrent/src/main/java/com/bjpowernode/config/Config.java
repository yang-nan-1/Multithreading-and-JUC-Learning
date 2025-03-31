package com.bjpowernode.config;

import com.bjpowernode.handler.MySpecialRejectedExecutionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 配置类
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
@Configuration
public class Config {

    /**
     * J.U.C提供的线程池
     *
     * @param redisTemplate
     * @return
     */
    @Bean(name = "threadPoolExecutor")
    public ThreadPoolExecutor threadPoolExecutor (RedisTemplate<Object, Object> redisTemplate) {
        //基于Executor框架实现线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                1,
                15,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2),
                Executors.defaultThreadFactory(),
                //Executors.privilegedThreadFactory(),
                //new ThreadPoolExecutor.DiscardPolicy()
                new MySpecialRejectedExecutionHandler(redisTemplate) //自定义的拒绝策略
        );
        return threadPoolExecutor;
    }

    /**
     * J.U.C提供的线程池2
     *
     * @return
     */
    @Bean(name = "threadPoolExecutor2")
    public ThreadPoolExecutor threadPoolExecutor2 () {
        //基于Executor框架实现线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                1,
                15,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2),
                Executors.defaultThreadFactory(),
                //Executors.privilegedThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        return threadPoolExecutor;
    }

    /**
     * Spring框架提供的线程池
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor applicationTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(16);
        //配置最大线程数
        executor.setMaxPoolSize(64);
        //配置队列大小
        executor.setQueueCapacity(9999);
        //配置线程池中的线程的名称前缀 (指定一下线程名的前缀)
        executor.setThreadNamePrefix("async-order-");
        // rejection-policy：当pool已经达到max pool size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用线程（提交任务的线程）处理该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

    /**
     * 自定义redis序列化
     *
     * @param redisConnectionFactory
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.Object,java.lang.Object>
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());//key的序列化采用字符串的方式，让key的可读性更好
        return redisTemplate;
    }
}