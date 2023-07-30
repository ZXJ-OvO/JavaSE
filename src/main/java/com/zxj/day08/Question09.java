package com.zxj.day08;

/**
 * 请定义一个方法用于判断一个字符串是否是对称的字符串，并在主方法中测试方法。
 * 例如："abcba"、"上海自来水来自海上"均为对称字符串。
 */
public class Question09 {
    public static void main(String[] args) {
        String s1 = "abccba";
        System.out.println(equals(s1));

    }

    public static boolean equals(String str) {
        // 方法有很多，反转后比较元素是最简单的
        StringBuilder newStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr.append(str.charAt(i));
        }
        System.out.println(newStr);

        return newStr.toString().equals(str);

    }
}
