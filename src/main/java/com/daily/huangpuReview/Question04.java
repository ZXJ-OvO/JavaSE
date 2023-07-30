package com.daily.huangpuReview;

/**
 * 给定一个范围，比如100~1000，统计这个范围内有多少个质数。
 */
public class Question04 {
    public static void main(String[] args) {
        System.out.println(searchData());

    }

    private static int searchData() {
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            Boolean number = isPrimeNumber(i);
            if (number) count++;
        }
        return count;
    }

    private static Boolean isPrimeNumber(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
