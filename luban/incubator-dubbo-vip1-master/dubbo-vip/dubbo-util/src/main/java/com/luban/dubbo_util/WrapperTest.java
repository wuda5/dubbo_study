package com.luban.dubbo_util;

import org.apache.dubbo.common.bytecode.ClassGenerator;
import org.apache.dubbo.common.bytecode.Wrapper;
import org.apache.dubbo.common.utils.ClassHelper;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class WrapperTest {

    public static void main(String[] args) {

        HelloServiceImpl helloService = new HelloServiceImpl("周瑜");

        Wrapper wrapper = Wrapper.getWrapper(HelloService.class);


        System.out.println(wrapper.getPropertyValue(helloService, "name"));

    }
}
