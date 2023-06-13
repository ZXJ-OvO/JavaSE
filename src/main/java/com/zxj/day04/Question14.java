package com.zxj.day04;

/**
 * 创建一个长度为6的整数数组。
 * 请编写代码，随机生成六个0（包含）-100（不包含）之间的整数存放到数组中，
 * 然后计算出数组中所有元素的和并打印。
 */
public class Question14 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = (int) (Math.random() * 100);
            arr[i] = num;
            sum += num;
        }
        System.out.println("数组中所有元素的和为：" + sum);
    }
}
