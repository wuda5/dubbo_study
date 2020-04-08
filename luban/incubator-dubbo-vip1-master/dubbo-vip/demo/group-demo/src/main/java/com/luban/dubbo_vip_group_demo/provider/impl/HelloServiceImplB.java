package com.luban.dubbo_vip_group_demo.provider.impl;


import com.luban.dubbo_vip_group_demo.api.HelloService;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class HelloServiceImplB implements HelloService {

    @Override
    public String sayHello(String username) {
        return "b, hello" + username;
    }
}
