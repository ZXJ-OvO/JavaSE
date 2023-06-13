package com.zxj.day02;

import java.util.Scanner;

/**
 * 需求:
 * 一座寺庙里住着三个和尚，已知他们的身高分别为150cm、210cm、165cm，
 * 请用程序实现获取这三个和尚的最高身高。
 */
public class Question05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a和尚身高：");
        double a = sc.nextDouble();
        System.out.print("b和尚身高：");
        double b = sc.nextDouble();
        System.out.print("c和尚身高：");
        double c = sc.nextDouble();

        Double[] array = new Double[]{a, b, c};
        bubbleSort(array);
        System.out.println(array[2]);
    }
    public static void bubbleSort(Double[] arr) {
        double temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
