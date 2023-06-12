package com.zxj.day02;

/**
 * 需求:
 * 定义一个int类型的变量,初始化值为1234,求这个数的个位,十位,百位,千位分别是多少?
 * 运行效果:
 * 1234的个位是4,十位是3,百位是2,千位是1
 */
public class Question02 {
    public static void main(String[] args) {
        int a = 1234;
        System.out.println("个位：" + a / 1000 % 10);
        System.out.println("十位：" + a / 100 % 10);
        System.out.println("百位：" + a / 10 % 10);
        System.out.println("千位：" + a / 1 % 10);
    }
}
