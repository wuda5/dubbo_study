package com.luban.loadbalance_vip.leastactive;

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
public class LeastActive {
    // 这里的伪代码不严谨，只是想表达一下简单的思路,请结合课堂笔记理解

    public static String getServer() {

        Integer leastActiveNum = null;
        for (Map.Entry<String, Integer> entry: ServerIps.ACTIVITY_LIST.entrySet()) {
            if (leastActiveNum == null || entry.getValue() < leastActiveNum) {
                leastActiveNum = entry.getValue();
            }
        }

        // 找最新调用次数的服务器,可能有相等的
        List<String> leastActiveIps = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: ServerIps.ACTIVITY_LIST.entrySet()) {
            Integer activeNum = entry.getValue();
            String ip = entry.getKey();
            if (activeNum == leastActiveNum) {
                leastActiveIps.add(ip);
            }
        }

        if (leastActiveIps.size() > 1) {
            // 走随机或轮询
        } else {
            return leastActiveIps.get(0);
        }

        return null;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
