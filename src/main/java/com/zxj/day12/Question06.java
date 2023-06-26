package com.zxj.day12;

/**
 * String StringBuilder StringBuffer 三者的区别
 * String：不可变的字符序列；底层使用char[]存储
 * StringBuilder：可变的字符序列；线程不安全，效率高；底层使用char[]存储
 * StringBuffer：可变的字符序列；线程安全，效率低；底层使用char[]存储
 * 使用javap -c xxx.class 可以查看底层的字节码文件
 */
public class Question06 {
    public static void main(String[] args) {
        // 利用无参构造器创建一个可变字符串abc
        StringBuilder stringBuilder = new StringBuilder("abc");
        System.out.println(stringBuilder.reverse());    // 反转
        System.out.println(stringBuilder.length());     // 长度
        String string = stringBuilder.toString();       // 转换为String
        System.out.println(string);


        // 在使用循环时，StringBuilder
        // append 任意类型
        stringBuilder.append("123");
        String str1 = "he";
        String str2 = "llo";
        String str3 = "world";
        String str4 = str1 + str2 + str3;

        /*
        使用+或者+=，这两个符号也是java唯二重载过的两个运算符
        底层实际上创建了StringBuilder的对象，调用了append方法，但是由于+或者+=发生在循环体内部，使得底层创建了等同于长度的StringBuioler的对象
         */
        String[] arr = {"he", "llo", "world"};
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        System.out.println(s);


        // StringBuffer
        StringBuffer stringBuffer = new StringBuffer("abc");
        System.out.println(stringBuffer.reverse());    // 反转
        System.out.println(stringBuffer.length());     // 长度
        System.out.println(stringBuffer.append("123"));
        String string1 = stringBuffer.toString();       // 转换为String
        System.out.println(string1);


    }
}
