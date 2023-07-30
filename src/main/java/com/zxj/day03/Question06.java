package com.zxj.day03;

/**
 * 需求：世界最高山峰珠穆朗玛峰高度是：8848.86米=8848860毫米，
 * 假如我有一张足够大的纸，它的厚度是0.1毫米。请问：该纸张折叠多少次，可以折成珠穆朗玛峰的高度？
 */
public class Question06 {
    public static void main(String[] args) {
        System.out.println("该纸张折叠" + fold() + "次，可以折成珠穆朗玛峰的高度");
    }

    private static int fold() {
        int count = 0;
        int v = 1;
        while (v < 8848860) {
            v *= 2;
            count++;
        }
        return count;
    }

    public static int time(int initNumber) {
        // 88488600
        // 1
        int count = 0;
        while (initNumber < 88488600) {
            initNumber *= 2;
            count++;
        }
        return count;
    }
}
