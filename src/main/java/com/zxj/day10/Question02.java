package com.zxj.day10;

import java.util.Random;

/**
 * 1. 产生10个 1-100 之间的随机数并存入数组中，随机数不能重复，随后遍历打印数组（元素都在一行打印）
 * 2. 反转数组中元素，再次遍历打印数组（元素都在一行打印）
 * 3. 找出数组中偶数元素并打印在控制台，要求每行打印两个元素
 */
public class Question02 {
    public static void main(String[] args) {
        // 1. 数组去重
        int[] arr = new int[10];
        Random r = new Random();
        // 已生成的随机数的数量
        int generatedCount = 0;
        while (generatedCount < arr.length) {

            int randomNumber = r.nextInt(100) + 1;
            boolean isDuplicate = false;
            // 在每次生成随机数时，遍历已生成的部分（arr[0] 到 arr[generatedCount-1]）进行比较
            for (int i = 0; i < generatedCount; i++) {
                // 当generatedCount == 0的时候，数组只有一个元素存在
                if (arr[i] == randomNumber) {
                    // 标记重复，跳出当前的for循环
                    isDuplicate = true;
                    break;
                }
            }
            // generatorCount第一次为0时，isDuplicate是false
            if (!isDuplicate) {
                // 只有当生成的随机数不重复时，才将其添加到数组中，并递增 generatedCount
                arr[generatedCount] = randomNumber;
                generatedCount++;
            }
        }
        System.out.print("去重后得到的数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        // 2. 反转数组
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = arr[i] ^ arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[arr.length - 1 - i] ^ arr[i];
            arr[i] = arr[i] ^ arr[arr.length - 1 - i];
        }
        System.out.print("\n反转后得到的数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        // 3. 每行打印两个偶数元素
        System.out.println("\n数组中偶数元素有：");
        int lineCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
                lineCount++;
            }
            if (lineCount == 2) {
                lineCount = 0;
                System.out.println();
            }
        }

    }
}
