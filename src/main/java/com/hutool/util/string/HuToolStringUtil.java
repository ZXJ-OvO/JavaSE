package com.hutool.util.string;

import cn.hutool.core.text.StrSplitter;

import java.util.Arrays;


/**
 * 字符串分割工具类
 */
public class HuToolStringUtil {
    public static void main(String[] args) {

        String str = "中国天安门1989年六月四日";
        // 将字符串分割成指定长度的若干个元素并返回成字符串数组
        String[] strings = StrSplitter.splitByLength(str, 2);
        System.out.println(Arrays.toString(strings));

        // 切分字符串为字符串数组
        String[] strings1 = StrSplitter.splitToArray(str, 2);
        System.out.println(Arrays.toString(strings1));

        // 切分字符串路径，仅支持识别Unix分界符/，返回字符串数组
        String s = "src/main/java/com/hutool/system/HuToolSystemUtil.java";
        String[] strings2 = StrSplitter.splitPathToArray(s);
        System.out.println(Arrays.toString(strings2));

        System.out.println();

    }
}
