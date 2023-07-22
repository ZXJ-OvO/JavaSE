package com.zxj.day16;

import cn.hutool.core.text.StrSplitter;

import java.util.*;

/**
 * 有类似这样的字符串：**"1.2, 3.4, 5.6, 7.8, 5.56, 44.55"**请按照要求，依次完成以下试题。
 * - 以逗号作为分隔符，把已知的字符串分成一个String类型的数组，数组中的每一个元素类似于"1.2","3.4"这样的字符串
 * * 把数组中的每一个元素以"."作为分隔符，把"."左边的元素作为key，右边的元素作为value，封装到Map中，Map中的key和value都是Object类型。
 * * 把map中的key封装的Set中，并把Set中的元素输出。
 * * 把map中的value封装到Collection中，把Collection中的元素输出
 */
public class Question25 {
    public static void main(String[] args) {
        String s = "1.2, 3.4, 5.6, 7.8, 5.56, 44.55";
        String[] strings = StrSplitter.splitToArray(s, ",", 0, true, true);
        Map<Object, Object> hashMap = new HashMap<>();
        Set<Object> set = new HashSet<>();
        List<Object> list = new ArrayList<>();

        String[] array = new String[2];
        for (int i = 0; i < strings.length; i++) {
            array = StrSplitter.splitToArray(strings[i], ".", 0, true, true);
            hashMap.put(array[0], array[1]);
            set.add(array[0]);
            list.add(array[1]);
        }
        System.out.println(set);
        System.out.println(list);
        hashMap.forEach((o, o2) -> System.out.println(o + " --> " + o2));

    }
}
