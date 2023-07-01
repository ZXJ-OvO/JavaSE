package com.zxj.day17;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 某商店想统计一下一天内所售出的商品以及商品的数量，请设计程序完成此需求,展示每个售出的商品名称和数量
 * 要求:通过键盘录入商品名称模拟售出的商品，录入一次表示商品售出一次，直到录入end结束,结束之后,将统计结果打印出来.运行结果如下:
 */
public class Question01 {
    public static void main(String[] args) {
        System.out.println("输入end结束商品录入，输入任意其他字符开始录入");
        HashMap<String, Integer> hashMap = new HashMap<>();
        Integer integer = 0;
        while (!(new Scanner(System.in).nextLine().equals("end"))) {
            System.out.println("请输入商品名称：");
            Scanner scanner = new Scanner(System.in);
            String hashMapKey = scanner.nextLine();

            if (hashMap.containsKey(hashMapKey)) {
                hashMap.put(hashMapKey, hashMap.get(hashMapKey) + 1);
            } else {
                hashMap.put(hashMapKey, 1);
            }
            System.out.println("end?继续输入yes");
        }
        System.out.println(hashMap);
    }
}
