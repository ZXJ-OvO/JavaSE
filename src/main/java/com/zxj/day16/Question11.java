package com.zxj.day16;

import java.util.HashSet;
import java.util.Random;

/**
 * 彩票双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
 * 红色球号码从1~33中选择；
 * 蓝色球号码从1~16中选择；
 * 请结合集合所学知识，随机生成一注双色球号码，要求同色号码不重复。
 * Set系列集合：添加的元素是无序、不重复、无索引。
 * HashSet: 无序、不重复、无索引；
 * LinkedHashSet: 有序、不重复、无索引。
 * TreeSet：按照大小默认升序排序、不重复、无索引。
 */
public class Question11 {
    public static void main(String[] args) {
        // 无需排序，无需索引，不允许重复，使用HashSet
        HashSet<Integer> hashSet = new HashSet<>();
        Random random = new Random();
        while (hashSet.size() < 6) {
            hashSet.add(random.nextInt(33) + 1);
        }
        hashSet.add(random.nextInt(16) + 1);
        hashSet.forEach(integer -> System.out.print(integer + " "));
    }
}
