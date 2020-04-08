package com.luban.generic_demo.consumer;

import com.luban.generic_demo.api.HelloService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class Consumer {

    public static void main(String[] args) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("generic-demo-consumer"));
        reference.setInterface(HelloService.class);
        reference.setGeneric(true);
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        GenericService genericService = reference.get();

        String result = (String) genericService.$invoke("sayHello", new String[]{"String"}, new Object[]{"周瑜"});

        System.out.println(result);
    }
}
