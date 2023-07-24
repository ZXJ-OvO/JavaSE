package com.zxj.day17;

/**
 * 小姑娘采蘑菇问题，小姑娘第一天摘下若干个蘑菇，当即吃了快一半，还不过瘾，又多吃了一个。
 * 第二天又将仅剩下的蘑菇吃掉了一半，又多吃了一个。
 * 以后每天都吃了前一天剩下的一半多一个。
 * 到第十天，只剩下一个蘑菇。试求第一天共摘了多少蘑菇？
 * f(n + 1) = f(n) - f(n)/2 - 1
 * 2f(n+1) = 2f(n) - f(n) - 2
 * 2f(n+1) = f(n) - 2
 * f(n) = 2f(n+1) + 2
 */
public class Question17 {
    public static void main(String[] args) {
        System.out.println(f(1));
    }

    private static int f(int n) {
        if (n == 10) {
            return 1;
        } else {
            return 2 * f(n + 1) + 2;
        }
    }
}
