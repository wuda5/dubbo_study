package com.luban.loadbalance_vip.robin;

import com.luban.loadbalance_vip.ServerIps;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class Robin {

    private static Integer pos = 0;

    public static String getServer() {

        String ip = "";

        synchronized (pos) {
            if (pos.equals(ServerIps.ServerIps.size())) pos = 0;

            ip = ServerIps.ServerIps.get(pos);
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
