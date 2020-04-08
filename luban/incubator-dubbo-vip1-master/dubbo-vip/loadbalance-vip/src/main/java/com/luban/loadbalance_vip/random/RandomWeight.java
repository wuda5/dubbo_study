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
public class RandomWeight {


    public static String getServer() {

        List<String> ips = new ArrayList<>();

        for (String ip : ServerIps.ServerIpWeights.keySet()) {
            Integer weight = ServerIps.ServerIpWeights.get(ip);

            for (int i = 0; i < weight; i++) {
                ips.add(ip);
            }
        }

        java.util.Random random = new java.util.Random();
        int index = random.nextInt(ips.size());

        return ips.get(index);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
