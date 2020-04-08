package com.luban.dubbo_util;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class HelloServiceImpl implements HelloService {

    private String name;

    public HelloServiceImpl(String name) {
        this.name = name;
    }

    @Override
    public Integer getGrade() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer setGrade(Integer g) {
        return null;
    }

    @Override
    public String sayHello() {
        return null;
    }
}
