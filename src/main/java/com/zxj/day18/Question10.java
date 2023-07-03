package com.zxj.day18;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * ASCII字符集，英文、数字、符号  1个字节
 * GBK字符集，汉字占用2个字节，数字、英文占用1个字节
 * UTF-8字符集，汉字占用3个字节，数字、英文占用1个字节
 */
public class Question10 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "我爱Java";
        byte[] bytes = str.getBytes();  // 使用平台默认字符集编码为字节数组
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = str.getBytes("GBK");// 使用指定字符集编码为字节数组
        System.out.println(Arrays.toString(bytes1));


        String s = new String(bytes); // 使用平台默认字符集解码字节数组为字符串
        System.out.println(s);

        String s1 = new String(bytes1);  // 编码采用GBK，解码采用UTF-8，会出现乱码
        System.out.println(s1);

        String string = new String(bytes1, "GBK");  // 编码采用GBK，解码采用GBK，不会出现乱码
        System.out.println(string);

    }

}
