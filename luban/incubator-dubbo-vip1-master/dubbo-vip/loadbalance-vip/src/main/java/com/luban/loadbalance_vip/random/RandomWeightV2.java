package com.luban.loadbalance_vip.random;

import com.luban.loadbalance_vip.ServerIps;

import java.util.ArrayList;
import java.util.List;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class RandomWeightV2 {
    public static String getServer() {

        int totalWeight = 0 ;
        for (Integer weight : ServerIps.ServerIpWeights.values()) {
            totalWeight += weight;
        }

        // 随机出坐标轴位置
        int offset = new java.util.Random().nextInt(totalWeight);

        // 去坐标轴寻找
        for (String ip: ServerIps.ServerIpWeights.keySet()) {
            Integer weight = ServerIps.ServerIpWeights.get(ip);

            if (offset <= weight) {
                return ip;
            }

            offset = offset - weight;
        }

        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }

}
