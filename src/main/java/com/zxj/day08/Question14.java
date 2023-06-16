package com.zxj.day08;

import java.util.Scanner;

/**
 * 3.从键盘输入8个整数存放在一个数组中，然后将奇数和偶数分别存入到两个不同的数组中，并按奇数、偶数交替的顺序输出这两个数组中的所有数据（先交替输出，如果奇数个数多，则再输出剩下的奇数，如果偶数个数多，则再输出剩下的偶数）。
 * （提示与要求：
 * 定义一个数组存储从键盘输入的8个整数，先判断这8个整数中奇数和偶数的个数，才能定义存储奇数和偶数的数组的长度；
 * （2）把一个大的数组分别存放在奇数和偶数数组中并交替输出的过程定义为方法）
 */
public class Question14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];

        int oddCount = 0;
        int evenCount = 0;
        System.out.println("请输入8个整数：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("oddCount：" + oddCount);
        System.out.println("evenCount：" + evenCount);

        int[] odd = new int[oddCount];
        int[] even = new int[evenCount];
        int a = -1;
        int b = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                a++;
                even[a] = arr[i];
            } else {
                b++;
                odd[b] = arr[i];
            }
        }
        // 奇数组、偶数组都拿到了
        int[] newArr = new int[arr.length];
        int x = 0;
        int y = 0;
        boolean status = false;
        while (!status) {
            for (int i = 1; i < arr.length; i += 2) {
                newArr[i] = even[x];
                x++;
            }
            for (int i = 0; i < arr.length; i += 2) {
                newArr[i] = odd[y];
                y++;
            }
            status = true;
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println("newArr：" + newArr[i]);
        }
    }
}
