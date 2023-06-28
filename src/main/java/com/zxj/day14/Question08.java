package com.zxj.day14;

import java.util.Arrays;

/**
 * 某程序员编写了一个方法，该方法实现的逻辑是从传入的数组中找出最大值，
 * 但考虑到调用者可能会传入一个长度为0的数组，所以要给调用者进行相应的提示，
 * 但是Java中并没有合适的异常类名可以直观的让调用者明白出现的问题，
 * 该程序员想自己设计一个运行时异常ArrayLengthNotZeroException，为自己的方法提供服务，请帮其实现功能.
 */
public class Question08 {
    public static void main(String[] args) throws CusException {
        int[] arr = new int[0];
        getMax(arr);
    }

    public static void getMax(int[] arr) throws CusException {
        System.out.println("请不要传入一个长度为0的数组");
        Arrays.sort(arr);
        if (arr.length == 0) {
            throw new CusException(arr);
        }
        System.out.println(arr[arr.length - 1]);
    }
}

class CusException extends Exception {
    // 重写父类的构造器
    public CusException(int[] arr) {
        super();
        if (arr.length == 0) {
            System.out.println("请不要传入一个长度为0的数组");
        }
    }
}