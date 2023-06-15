package com.zxj.day06;

/**
 * 加密：对1983加5模10再反转得到的结果是8346
 * 解密：对8346加5模10再反转得到的结果是1983
 */
public class Question05 {
    public static void main(String[] args) {
        // 加密+解密一体
        System.out.println("结果是：" + encrypt(1983));
    }

    public static String encrypt(int number) {
        int[] numbers = split(number);
        for (int i = 0; i < numbers.length; i++) {
            // i = 0 1 2 3
            numbers[i] = (numbers[i] + 5) % 10;
        }
        reverse(numbers);
        String data = "";
        for (int i = 0; i < numbers.length; i++) {
            data += numbers[i];
        }
        return data;
    }

    public static void reverse(int[] numbers) {
        // 反转数组的
        // numbers = [6, 4, 3, 8]
        //            i        j
        for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
            // 交换i和j位置处的值。
            // 1、把后一个位置处的值交给一个临时变量先存起来
            int temp = numbers[j];
            // 2、把前一个位置处的值赋值给后一个位置处
            numbers[j] = numbers[i];
            // 3、把后一个位置处原来的值（由临时变量记住着）赋值给前一个位置
            numbers[i] = temp;
        }
    }

    public static int[] split(int number) {
        int[] numbers = new int[4];
        numbers[0] = number / 1000;
        numbers[1] = (number / 100) % 10;
        numbers[2] = (number / 10) % 10;
        numbers[3] = number % 10;
        return numbers;
    }
}