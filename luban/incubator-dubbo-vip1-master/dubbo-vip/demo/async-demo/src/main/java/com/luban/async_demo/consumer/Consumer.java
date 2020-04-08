package com.luban.async_demo.consumer;

import com.luban.async_demo.api.HelloService;
import com.luban.async_demo.api.WorldService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class Consumer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        HelloService helloService = context.getBean("helloService", HelloService.class);
        WorldService worldService = context.getBean("worldService", WorldService.class);

        // 直接调，返回为null
//        String result = helloService.sayHello("周瑜");
//        System.out.println(result);


        helloService.sayHello("周瑜");
        Future<String> helloFuture = RpcContext.getContext().getFuture();

        worldService.sayHello("周瑜");
        Future<String> worldFuture = RpcContext.getContext().getFuture();


        System.out.println(helloFuture.get());
        System.out.println(worldFuture.get());
    }
}
