package com.zxj.day05;

import java.util.Scanner;

/**
 * 输出一个int类型的数组内容，要求输出格式为：[11, 22, 33, 44, 55]
 */
public class Question03 {
    private static final Scanner scanner = new Scanner(System.in);
    private static int[] array;

    public static void main(String[] args) {
        System.out.print("请输入数组长度：");
        int num = scanner.nextInt();
        array = new int[num];
        print(num);
    }

    public static void print(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("请输入第" + (i + 1) + "个整数：");
            array[i] = scanner.nextInt();
        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i] + "]");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }
}
