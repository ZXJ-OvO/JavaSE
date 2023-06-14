package com.zxj.day06;

/**
 * 某系统的数字密码是一个四位数，如1983，为了安全，需要加密后再传输，
 * 加密规则是：对密码中的每位数，都加5,再对10求余，最后将所有数字顺序反转，
 * 得到一串加密后的新数，请设计出满足本需求的加密程序！
 */
public class Question04 {
    public static void main(String[] args) {
        int password = 1983;
        int[] arr = new int[4];

        // 解密过程
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((password / Math.pow(10, i)) % 10);
            arr[i] = (arr[i] + 10 - 5) % 10; // 减去5并取余10
        }

        // 反转输出
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + "\t");
        }
    }
}
