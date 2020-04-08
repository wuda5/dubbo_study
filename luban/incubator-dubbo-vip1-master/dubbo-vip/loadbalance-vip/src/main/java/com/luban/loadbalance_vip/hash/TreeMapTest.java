package com.luban.loadbalance_vip.hash;

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
public class TreeMapTest {


    public static void main(String[] args) {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        sortedMap.put(1, "1");
        sortedMap.put(2, "2");
        sortedMap.put(3, "3");
        sortedMap.put(4, "4");
        sortedMap.put(5, "5");
        sortedMap.put(6, "6");
        sortedMap.put(8, "8");
        sortedMap.put(10, "10");


        System.out.println(sortedMap.firstKey());

        SortedMap<Integer, String> subMap = sortedMap.tailMap(7);
        System.out.println(subMap.firstKey());

    }
}
