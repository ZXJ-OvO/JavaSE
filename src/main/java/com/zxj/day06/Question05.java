package com.zxj.day06;

/**
 * 对Question04.java的解密程序
 */
public class Question05 {
    public static void main(String[] args) {
        int[] encryptedPassword = {8, 3, 2, 7}; // 加密后的密码

        int[] decryptedPassword = decryptPassword(encryptedPassword);

        System.out.print("解密后的密码为：");
        for (int i = decryptedPassword.length - 1; i >= 0; i--) {
            System.out.print(decryptedPassword[i]);
        }
    }

    /**
     * 解密密码
     */
    public static int[] decryptPassword(int[] encryptedPassword) {
        int[] decryptedPassword = new int[encryptedPassword.length];

        // 还原加密前的密码
        for (int i = 0; i < encryptedPassword.length; i++) {
            decryptedPassword[i] = (encryptedPassword[i] + 5) % 10;
        }

        return decryptedPassword;
    }
}
