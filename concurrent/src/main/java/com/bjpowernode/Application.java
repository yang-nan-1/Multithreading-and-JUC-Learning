package com.bjpowernode;

import com.bjpowernode.task.MyRunnable;
import com.bjpowernode.threadpool.shutdown.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Application
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //spring ioc容器
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class);

        //从spring容器中拿到一个j.u.c线程池对象
        ThreadPoolExecutor threadPoolExecutor = applicationContext.getBean("threadPoolExecutor",ThreadPoolExecutor.class);

        for (int i = 0; i < 4; i++) {
            //往线程池中提交 线程任务
            threadPoolExecutor.execute(new MyRunnable(i));
        }

        /*BizPoolService3 bizPoolService3 = applicationContext.getBean(BizPoolService3.class);
        int i = 0;
        while (true) {
            bizPoolService3.processTask();
            System.out.println(i);
            i++;
        }*/

//        TestService testService = applicationContext.getBean(TestService.class);
//        testService.doOrder();
//        testService.doSMS();
    }
}
