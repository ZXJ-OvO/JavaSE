package com.zxj.day16;

import java.util.HashMap;
import java.util.Scanner;

public class Question20 {
    public static void main(String[] args) {
        HashMap<String, Integer> goods = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("录入商品，录入end结束");
            String goodName = scanner.next();
            if (goodName.equals("end")) {
                goods.forEach((s, integer) -> System.out.println(s + " " + integer));
                return;
            }
            if (goods.containsKey(goodName)) {
                goods.put(goodName, goods.get(goodName) + 1);
            } else {
                goods.put(goodName, 1);
            }
        }
    }
}
