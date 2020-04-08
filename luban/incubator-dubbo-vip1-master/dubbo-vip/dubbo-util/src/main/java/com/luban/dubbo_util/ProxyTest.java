package com.luban.dubbo_util;

import org.apache.dubbo.common.bytecode.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class ProxyTest {

    public static void main(String[] args) {

        HelloService helloService = (HelloService) Proxy.getProxy(HelloService.class).newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                return null;
            }
        });

        helloService.sayHello();
        helloService.getGrade();
    }
}
