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
public class RedCar implements Car {

    public void getColor() {
        System.out.println("red");
    }

    @Override
    public void getColorForUrl(URL url) {

    }
}
