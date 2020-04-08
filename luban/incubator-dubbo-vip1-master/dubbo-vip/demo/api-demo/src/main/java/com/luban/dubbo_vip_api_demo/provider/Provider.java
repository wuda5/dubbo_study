package com.luban.dubbo_vip_api_demo.provider;

import com.luban.dubbo_vip_api_demo.api.HelloService;
import com.luban.dubbo_vip_api_demo.provider.impl.HelloServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class Provider {

    public static void main(String[] args) throws IOException {

        HelloService helloService = new HelloServiceImpl();

        ServiceConfig<HelloService> config = new ServiceConfig<>();
        config.setInterface(HelloService.class);
        config.setRef(helloService);
        config.setApplication(new ApplicationConfig("api-demo-provider"));
        config.setRegistry(new RegistryConfig("127.0.0.1:2181", "zookeeper"));


        config.export();

        System.in.read();
    }
}
