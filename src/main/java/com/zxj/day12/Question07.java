package com.zxj.day12;

/**
 * 返回任意整形数组的的内容
 */
public class Question07 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        arrayDetails(array);

    }


    public static void arrayDetails(int[] arr) {
        StringBuffer sb = new StringBuffer();
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(",");
            }
        }
        System.out.print(sb);
        System.out.print("]");
    }
}
