package com.zxj.day13;

import static java.lang.Math.*;

/**
 * API Math
 */
public class Question01 {
    public static void main(String[] args) {
        // 获取参数绝对值
        System.out.println(abs(-10));

        // 向上取整
        System.out.println(ceil(3.14));
        System.out.println(ceil(8.57));

        // 向下取整
        System.out.println(floor(3.14));
        System.out.println(floor(8.57));

        // 四舍五入
        System.out.println(round(3.14));
        System.out.println(round(89.64));

        // 两值中的最大值
        System.out.println(max(89, 64));

        // a的b次幂  a^2
        System.out.println(pow(2, 2));

        // 返回double类型的[0.0, 1.0]值
        System.out.println(random());
    }
}
