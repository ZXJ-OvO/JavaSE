package com.zxj.day04;

/**
 * 某个数组有5个数据：10,20,30,40,50，请将这个数组中的数据进行反转
 */
public class Question05 {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        System.out.println("反转前：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }

        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            // 使用临时变量实现数组元素的反转
            // temp = array[i];
            // array[i] = array[array.length - 1 - i];
            // array[array.length - 1 - i] = temp;

            // 使用位运算实现数组元素的反转
            int a = array[array.length - 1 - i];
            int b = array[i];
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }

        System.out.println("\n反转后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
