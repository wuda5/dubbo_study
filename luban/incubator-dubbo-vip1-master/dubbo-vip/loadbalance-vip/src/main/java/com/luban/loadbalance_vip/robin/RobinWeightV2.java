package com.luban.loadbalance_vip.robin;

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
public class RobinWeightV2 {

    private static Integer pos = 0;



    public static String getServer() {

        int totalWeight = 0;
        boolean sameWeight = true;

        Object[] weights = ServerIps.ServerIpWeights.values().toArray();

        for (int i=0; i< weights.length; i++) {
            Integer weight = (Integer) weights[i];
            totalWeight += weight;

            if (sameWeight && i !=0 &&  weight != weights[i-1]) {
                sameWeight = false;
            }
        }


        if (!sameWeight) {

            // 1,2,3,.....1000,1001,1002
            Integer sequenceNum = Sequence.next();

            // 坐标轴
            Integer offset = sequenceNum % totalWeight;
            offset = offset == 0 ? totalWeight : offset;

            // 去坐标轴寻找
            for (String ip : ServerIps.ServerIpWeights.keySet()) {
                Integer weight = ServerIps.ServerIpWeights.get(ip);

                if (offset <= weight) {
                    return ip;
                }

                offset = offset - weight;
            }
        }

        String ip = "";

        synchronized (pos) {
            if (pos.equals(ServerIps.ServerIpWeights.keySet().toArray().length)) pos = 0;

            ip = (String) ServerIps.ServerIpWeights.keySet().toArray()[pos];
            pos++;
        }

        return ip;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
