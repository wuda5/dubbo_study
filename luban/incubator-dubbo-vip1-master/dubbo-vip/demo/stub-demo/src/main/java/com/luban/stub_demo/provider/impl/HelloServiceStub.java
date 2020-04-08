package com.luban.stub_demo.provider.impl;

import com.luban.stub_demo.api.HelloService;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class HelloServiceStub implements HelloService {

    private HelloService helloService;

    public HelloServiceStub(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String username) {

        System.out.println("在消费端执行");
        return helloService.sayHello(username);
    }
}
