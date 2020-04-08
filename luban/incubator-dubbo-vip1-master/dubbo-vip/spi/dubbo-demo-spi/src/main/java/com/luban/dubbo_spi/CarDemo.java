package com.luban.dubbo_spi;

import com.luban.dubbo_spi.api.Car;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class CarDemo {

    public static void main(String[] args) {
        ExtensionLoader<Car> extensionLoader =
                ExtensionLoader.getExtensionLoader(Car.class);


        Car redCar = extensionLoader.getExtension("red");
        redCar.getColor();
//        Car benz = extensionLoader.getExtension("benz");
//
//
//        Map<String, String> map = new HashMap<>();
//        map.put("car", "black");
//        URL url = new URL("","",1, map);
//
//        benz.getColorForUrl(url);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
