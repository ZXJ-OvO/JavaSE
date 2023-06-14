package com.zxj.day05;

/**
 * 在主方法中通过键盘录入三个整数。
 * 定义一个方法，方法接收三个整数变量，在方法中从大到小依次打印三个变量。执行效果如下：
 * 请输入第一个整数：10
 * 请输入第二个整数：30
 * 请输入第三个整数：20
 * 从大到小的顺序是： 30 20 10
 */
public class Question11 {
    public static void main(String[] args) {
        int a = 10;
        int b = 30;
        int c = 20;
        print(a, b, c);
    }

    public static void print(int a, int b, int c) {
        int max = a;
        int min = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        int mid = a + b + c - max - min;
        System.out.println("从大到小的顺序是：" + max + " " + mid + " " + min);
    }
}
