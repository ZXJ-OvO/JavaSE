package com.zxj.day16;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 我们输入一个要注册的用户名,如果之前有该用户名注册过,
 * 京东是不会让相同的用户名注册的,会注册失败.根据以上描述,设计程序,完成注册功能!
 */
public class Question12 {
    public static void main(String[] args) {
        // 不允许重复 无需排序 无需索引 使用HashSet
        HashSet<String> hashSet = new HashSet<>();
        System.out.println("请输入用户名");
        hashSet.add(new Scanner(System.in).nextLine());
        System.out.println("请输入用户名");
        hashSet.add(new Scanner(System.in).nextLine());
        while (hashSet.size() < 2) {
            System.out.println("用户名重复,请重新输入");
            hashSet.add(new Scanner(System.in).nextLine());
        }
        System.out.println("注册成功");
    }
}
