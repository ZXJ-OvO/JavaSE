package com.zxj.day02;

import java.util.Scanner;

/**
 * 需求:
 * 定义一个int类型的变量,初始化值为1234,求这个数的个位,十位,百位,千位分别是多少?
 * 运行效果:
 * 1234的个位是4,十位是3,百位是2,千位是1
 */
public class Question02 {
    public static void main(String[] args) {
        int a = 1234;
        System.out.println("个位：" + a / 1000 % 10);
        System.out.println("十位：" + a / 100 % 10);
        System.out.println("百位：" + a / 10 % 10);
        System.out.println("千位：" + a % 10);

        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = s.nextInt();
        getNum(num);
    }

    /**
     * 获取一个整数的位数和每一位的数
     */
    public static void getNum(int a){
        // 判断a是几位数，同时打印位数
        int count = 0;
        int temp = a;
        while (temp != 0){
            temp /= 10;
            count++;
        }
        System.out.println(a + "是" + count + "位数");
        // 知道位数后对a求每一位的数
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = a % 10;
            a /= 10;
        }
        // 打印每一位的数
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(arr[i] + "\t");
        }
    }
}
