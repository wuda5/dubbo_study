package com.luban.dubbo_spi.impl;

import com.luban.dubbo_spi.api.Car;
import org.apache.dubbo.common.URL;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class BenzCar implements Car {

    private Car car;

    // SPI注入的过程：
    // 1. 通过SpiExtensionFactory获取Car的Adaptive类，所以注入进来的对象其实是一个Adaptive类对象，代理对象...
    public void setBlack(Car car) {
        this.car = car;
    }

    @Override
    public void getColor() {
        car.getColor();
    }

    @Override
    public void getColorForUrl(URL url) {
        car.getColorForUrl(url);
    }
}
