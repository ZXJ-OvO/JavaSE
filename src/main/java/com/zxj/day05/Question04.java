package com.zxj.day05;

/**
 * 如果两个int类型的数组，元素个数，对应位置的元素内容都是一样的则认为这2个数组是一模一样的
 */
public class Question04 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 7, 5};
        System.out.println(equalsArray(a, b));
    }

    public static boolean equalsArray(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
