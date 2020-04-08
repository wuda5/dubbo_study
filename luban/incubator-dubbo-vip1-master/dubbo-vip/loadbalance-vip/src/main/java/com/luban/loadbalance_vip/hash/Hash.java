package com.luban.loadbalance_vip.hash;

import com.luban.loadbalance_vip.ServerIps;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class Hash {


    // hash值：服务器ip
    private static SortedMap<Integer, String> vNodes = new TreeMap<>();
    private static Integer vNodeNum = 160;

    static {
        for (String ip : ServerIps.ServerIps) {
            for (int i = 0; i < vNodeNum; i++) {
                vNodes.put(getHash(ip), ip);
            }
        }
    }

    private static String getServer(String client) {
        Integer hash = getHash(client);

        SortedMap<Integer, String> subNodes = vNodes.tailMap(hash);

        Integer firstKey = subNodes.firstKey();

        if (firstKey == null) {
            firstKey = vNodes.firstKey();
        }

        return vNodes.get(firstKey);

    }


    // md5, sha-1, sha-256
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer("client" + i));
        }
    }
}
