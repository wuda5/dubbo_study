package com.luban.dubbo_vip_loadbalance_demo.consumer;

import com.luban.dubbo_vip_loadbalance_demo.api.HelloService;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class Consumer {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        HelloService helloService = context.getBean("helloService", HelloService.class);

        for (int i=0 ;i <10; i++) {
//            Thread.sleep(1000);
            String result = helloService.sayHello("周瑜");
            System.out.println(result);
        }


    }
}
