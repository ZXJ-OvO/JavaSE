package com.zxj.day06;

/**
 * 请把一个整型数组，例如存了数据：11，22，33，拷贝成一个一模一样的新数组出来。
 */
public class Question06 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33};
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
            System.out.print(arr2[i] + "\t");
        }
    }
}
