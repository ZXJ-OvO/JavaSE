package com.zxj.day06;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一个大V直播时发起了抢红包活动，分别有：9、666、188、520、99999五个红包。
 * 请模拟粉丝来抽奖，按照先来先得，随机抽取，抽完即止，
 * 注意：一个红包只能被抽一次，先抽或后抽哪一个红包是随机的
 */
public class Question07 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(666);
        list.add(188);
        list.add(520);
        list.add(99999);
        Collections.shuffle(list);
        int count = 0;
        for (Integer item : list) {
            if (count == 5) {
                break;
            }
            count++;
            System.out.println(count + "号：" + item);
        }
    }
}
