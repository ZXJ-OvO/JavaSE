package com.hutool.util.convert;


import cn.hutool.core.convert.Convert;

import java.nio.charset.Charset;
import java.util.Arrays;

public class HuToolConvert {
    public static void main(String[] args) {



        // 转换为字符串
        Integer[] integers = {1, 2, 3, 4, 5};
        String str = Convert.toStr(integers);
        System.out.println(str);

        // 转换为String数组
        String s = "abc bcd";
        String[] strArray = Convert.toStrArray(s);
        String[] strArray1 = Convert.toStrArray(integers);
        System.out.println(Arrays.toString(strArray));
        System.out.println(Arrays.toString(strArray1));

        // 转换为字符
        Character aChar = Convert.toChar(s);
        System.out.println(aChar);

        // 转换为字符数组
        Character[] charArray = Convert.toCharArray(s);
        System.out.println(Arrays.toString(charArray));

        // 转换为byte
        int b = 128;
        System.out.println(Convert.toByte(b));

        // 转换为byte数组
        int[] arr = {-128, 127, 0, 128, -129};
        Byte[] bytes = Convert.toByteArray(arr);
        System.out.println(Convert.toStr(bytes));

        // 转换为int
        System.out.println(Convert.toInt("我们"));

        System.out.println("----------------------------------------------------中文特殊转换");

        // 金额转中文形式
        System.out.println(Convert.digitToChinese(1989.64));

        // 中文大写数字金额转换为数字，返回结果以元为单位的BigDecimal类型数字
        System.out.println(Convert.chineseMoneyToNumber("陆万柒仟伍佰伍拾陆元叁角贰分"));

        // 数字中文转成阿拉伯数字
        System.out.println(Convert.chineseToNumber("一千九百八十九"));

        // 阿拉伯数字转成中文，第二个参数用于设置是否为繁体
        System.out.println(Convert.numberToChinese(1989.64, false));


        System.out.println("----------------------------------------------------编码进制转换");

        // 字符串转换成十六进制字字符串，结果为小写
        System.out.println(Convert.toHex("我爱美国", Charset.defaultCharset()));

        // 十六进制转换字符串
        System.out.println(Convert.hexToStr("e68891e788b1e7be8ee59bbd", Charset.defaultCharset()));

        // 给定字符串转换字符编码
        System.out.println(Convert.convertCharset("我爱美国", "utf-8", "gbk"));


    }
}
