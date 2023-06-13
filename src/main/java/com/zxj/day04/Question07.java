package com.zxj.day04;

/**
 * 需求:
 * 	请使用静态初始化的方式,创建一个长度为5的整数数组,并为数组中的元素赋值,
 * 	遍历数组,在同一行打印所有元素,元素之间用空格隔开,
 * 	比如1:如果数组为{1,2,3,4,5}打印结果:1 2 3 4 5
 *  比如2:如果数组为{1,2,3,4,5}打印结果:[1, 2, 3, 4, 5]
 */
public class Question07 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i]+", ");
            }
        }
        System.out.println("]");
    }
}
