package com.luban.dubbo_vip_xml_demo.consumer;

import com.luban.dubbo_vip_xml_demo.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class Consumer {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        HelloService helloService = context.getBean("helloService", HelloService.class);

        // 这里会先进入到mockClusterInvoker
        String result = helloService.sayHello("周瑜");

        System.out.println(result);

        System.in.read();
    }
}
