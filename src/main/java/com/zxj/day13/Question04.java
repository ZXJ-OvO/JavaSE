package com.zxj.day13;

import java.math.BigDecimal;

/**
 * API BigDecimal
 * 【强制】禁止使用构造方法 BigDecimal(double) 的方式把 double 值转化为 BigDecimal 对象。
 * 【强制】BigDecimal 的等值比较应使用 compareTo() 方法，而不是 equals() 方法。
 * 【强制】使用 BigDecimal 来定义值，再进行浮点数的运算操作。
 * 【强制】浮点数之间的等值判断，基本数据类型不能使用 == 进行比较，包装数据类型不能使用 equals进行判断。
 */
public class Question04 {
    public static void main(String[] args) {
        double d = 0.1;
        double d2 = 0.2;
        System.out.println(d + d2);
        System.out.println(d * d2);
        System.out.println(d / d2);
        System.out.println(d - d2);

        // 转换一个double类型的数字为BigDecimal
        BigDecimal BigD = BigDecimal.valueOf(d);
        BigDecimal BigD2 = BigDecimal.valueOf(d2);
        System.out.println("-------------------------------------------------------");
        // 加
        System.out.println(BigD.add(BigD2));

        // 减
        System.out.println(BigD.subtract(BigD2));

        // 乘
        System.out.println(BigD.multiply(BigD2));

        // 除
        System.out.println(BigD.divide(BigD2));

        // 比较大小
        System.out.println(BigD.compareTo(BigD2));


    }
}
