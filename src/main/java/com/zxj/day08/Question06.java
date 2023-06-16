package com.zxj.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在假如购物车中存储了如下这些商品：
 * Java入门,宁夏枸杞，黑枸杞，人字拖，特级枸杞，枸杞子。
 * 现在用户不想买枸杞了，选择了批量删除，请完成该需求。
 */
public class Question06 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        System.out.println("删除前：" + list);
        for (int i = list.size() - 1; i > 0; i--) {
            // for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("枸杞")) {
                list.remove(i);
                // 如果采用从后往前遍历，删除元素后的操作和索引游标向前移动的过程是同步的，所以不需要i--
                // 如果采用从前往后遍历，删除元素后的操作和索引游标向前移动的过程是不同步的，所以需要i--
                // i--; // 删除后，后面的元素会往前移，所以要把i减1
            }
        }
        System.out.println("删除后：" + list);
    }
}
