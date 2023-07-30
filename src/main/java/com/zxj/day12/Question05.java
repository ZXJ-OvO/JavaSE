package com.zxj.day12;

/**
 * 包装类
 */
public class Question05 {
    public static void main(String[] args) {
        String a = "123321";
        String b = "3.14";

        double v = Double.parseDouble(b);
        System.out.println(v);

        int i = Integer.parseInt(a);
        System.out.println(i);

        // parseInt()返回的是int类型   valueOf()返回的是Integer类型 两者都是将字符串转换为数字 但是valueOf()可以接收对象 但是parseInt()不可以
        Integer integer = Integer.valueOf(a);
        System.out.println(integer);

        // 可以把基本类型的数据转化成字符串类型 怎么操作 ？？？

    }
}
