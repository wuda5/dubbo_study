package com.luban.dubbo_vip_group_demo.merger;

import org.apache.dubbo.rpc.cluster.Merger;

/**
 * *************书山有路勤为径***************
 * 鲁班学院
 * 往期资料加木兰老师  QQ: 2746251334
 * VIP课程加安其拉老师 QQ: 3164703201
 * 讲师：周瑜老师
 * *************学海无涯苦作舟***************
 */
public class MyMerger implements Merger<String> {

    @Override
    public String merge(java.lang.String[] items) {

        String result = "";
        for (int i=0; i<items.length; i++) {
            result += items[i];
        }

        return result;

    }
}
