package com.luban.loadbalance_vip.robin;

import com.luban.loadbalance_vip.ServerIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class RobinWeightV3 {

    public static List<Weight> weights = new ArrayList<>();
    public static int totalWeight = 0;

    public static String getServer() {
        if (weights.isEmpty()) {
            for (Map.Entry<String, Integer> entry : ServerIps.ServerIpWeights.entrySet()) {
                String ip = entry.getKey();
                Integer weight = entry.getValue();
                totalWeight += weight;
                weights.add(new Weight(weight, weight, ip));
            }
        }

        Weight maxCurrentWeight = null;
        for (Weight weight: weights) {
            if (maxCurrentWeight == null || weight.getCurrentWeight() > maxCurrentWeight.getCurrentWeight()) {
                maxCurrentWeight = weight;
            }
        }


        maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getCurrentWeight() - totalWeight);

        for (Weight weight: weights) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }


        return maxCurrentWeight.getIp();

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
