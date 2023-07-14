package com.zxj.day10;

/**
 * 类方法中可以直接访问类的成员，不可以直接访问实例成员。
 * 实例方法中既可以直接访问类成员，也可以直接访问实例成员。
 * 实例方法中可以出现this关键字，类方法中不可以出现this关键字的
 */
public class Question12 {
    public static void main(String[] args) {

    }

    public static String schoolName = "itheima";
    public String userName;

    /**
     * 类方法中可以直接访问类的成员，不可以直接访问实例成员。
     * 类方法中不可以出现this关键字的
     */
    public static void test1() {
        System.out.println(schoolName);
        // 无法从 static 上下文引用 'com.zxj.day10.Question12.this'
        // System.out.println(this.userName);
    }

    /**
     * 实例方法中既可以直接访问类成员，也可以直接访问实例成员。
     * 实例方法中可以出现this关键字
     */
    public void test2() {
        System.out.println(schoolName);
        System.out.println(this.userName);
    }

}
