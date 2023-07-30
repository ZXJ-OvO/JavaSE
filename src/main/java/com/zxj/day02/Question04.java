package com.zxj.day02;

import java.math.BigDecimal;

/**
 * 需求:
 * 动物园里有两只老虎，已知两只老虎的体重分别为180kg、200kg，
 * 请用程序实现判断两只老虎的体重是否相同。
 */
public class Question04 {
    public static void main(String[] args) {
        double tiger1 = 180;
        double tiger2 = 200;
        String s = BigDecimal.valueOf(tiger1).compareTo(BigDecimal.valueOf(tiger2)) == 0 ? "相同" : "不同";
        System.out.println(s);
    }
}
