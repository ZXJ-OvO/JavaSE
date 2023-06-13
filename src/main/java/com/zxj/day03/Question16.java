package com.zxj.day03;

/**
 * 已知2019年是猪年，请在控制台输出从1949年到2019年中所有是猪年的年份。
 */
public class Question16 {
    public static void main(String[] args) {
        for (int i = 2019; i >= 1949 ; i-=12) {
            System.out.println(i);
        }
    }
}
