package com.zxj.day03;

/**
 * 让用户依次录入三个整数，求出三个数中的最小值，并打印到控制台。
 */
public class Question11 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个整数：");
            arr[i] = new java.util.Scanner(System.in).nextInt();
            if (i == 0) {
                min = arr[i];
            } else {
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
        }
        System.out.println("最小值为：" + min);

        // Math.max();
    }
}
