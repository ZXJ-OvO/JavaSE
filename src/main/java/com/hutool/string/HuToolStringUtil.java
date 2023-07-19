package com.hutool.string;

import cn.hutool.core.text.StrSplitter;

import java.util.Arrays;

public class HuToolStringUtil {
    public static void main(String[] args) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("           字符串分割");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        java.lang.String str = "中国天安门1989年六月四日";
        // 将字符串分割成指定长度的
        java.lang.String[] strings = StrSplitter.splitByLength(str, 2);
        System.out.println(Arrays.toString(strings));

        String[] strings1 = StrSplitter.splitToArray(str, 2);
        System.out.println(Arrays.toString(strings1));

    }
}
