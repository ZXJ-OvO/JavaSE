package com.zxj.day10;

import java.util.Scanner;

/**
 * 1) 手机号码长度必须为11位数字;
 * 2) 手机号码第一位必须要是1;
 */

public class Question04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入手机号码：");
        String phoneNumber = scanner.nextLine();

        if (checkPhone(phoneNumber)) {
            String lastFourDigits = phoneNumber.substring(phoneNumber.length() - 4);
            System.out.println("手机号码后四位：" + lastFourDigits);
        } else {
            System.out.println("手机号码错误");
        }
    }

    /**
     * ^       表示匹配字符串的开头
     * 1       表示手机号码的第一位必须是数字 1
     * \\d{10} 表示匹配后面的 10 位数字
     * $       表示匹配字符串的结尾
     */
    public static boolean checkPhone(String phoneNumber) {
        String pattern = "^1\\d{10}$";
        return phoneNumber.matches(pattern);
    }
}
/*
    \d       匹配任意数字字符（0-9）。
    \D       匹配任意非数字字符。
    \w       匹配任意字母、数字或下划线字符。
    \W       匹配任意非字母、数字或下划线字符。
    \s       匹配任意空白字符，包括空格、制表符、换行符等。
    \S       匹配任意非空白字符。
    .        匹配任意字符，除了换行符 \n。
    []       字符类，匹配方括号内的任意字符。
    [^]      否定字符类，匹配除了方括号内的字符以外的任意字符。
    *        匹配前面的元素零次或多次。
    +        匹配前面的元素一次或多次。
    ?        匹配前面的元素零次或一次。
    {n}      匹配前面的元素恰好 n 次。
    {n,}     匹配前面的元素至少 n 次。
    {n,m}    匹配前面的元素至少 n 次且不超过 m 次。
    ()       捕获组，将匹配的部分进行分组。
    |        逻辑 OR，匹配两个或多个选择之一。
    ^        匹配字符串的开头。
    $        匹配字符串的结尾。
 */

