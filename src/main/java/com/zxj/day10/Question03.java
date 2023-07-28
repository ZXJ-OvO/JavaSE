package com.zxj.day10;

import java.util.Random;

/**
 * 1）main方法中，定义一个长度为5的int数组arr
 * 2）main方法中，使用随机数生成5个范围为20 - 30的数字存入arr中（包含20和30，可重复）
 * 3）定义方法遍历数组arr，格式：1, 2, 3, 4（3分）
 * 4）main方法中调用getScore方法，获取方法返回值并在控制台打印输出该返回值。
 * 5）getScore方法内完成：统计指定数组arr中大于平均值的元素的个数，并返回
 */
public class Question03 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(21) + 10;
        }
        printArray(arr);
        System.out.println();
        System.out.println(getScore(arr));


    }

    public static int getScore(int[] arr) {
        int sum = 0;
        for (int k : arr) {
            sum += k;
        }
        int avg = sum / arr.length;
        System.out.println(avg);
        int count = 0;
        for (int j : arr) {
            if (j > avg) {
                count++;
            }
        }
        return count;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
    }
}
