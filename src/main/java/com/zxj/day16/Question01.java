package com.zxj.day16;


public class Question01 {
    public static void main(String[] args) {
        test(1, 2, 3, 4, 5);
    }

    public static void test(int... num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        System.out.println(sum);
    }
}
