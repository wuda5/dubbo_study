package com.luban.mock_demo.provider.impl;

import com.luban.mock_demo.api.HelloService;
import org.apache.dubbo.rpc.RpcException;

import java.util.concurrent.TimeUnit;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String username) {

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello" + username;
    }
}
