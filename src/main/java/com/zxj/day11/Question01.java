package com.zxj.day11;

/**
 * 黑马的员工管理系统中，需要管理讲师、咨询师的数据
 * 讲师的数据有：姓名、年龄、具备的技能；
 * 咨询师的数据有：姓名、年龄、回答问题的总人数。
 * 讲师和咨询师都需要提供打印个人介绍的方法。
 */
public class Question01 {
    public static void main(String[] args) {

    }
}

abstract class Employee {
    public String name;
    public int age;

    public abstract void print();
}

class Teacher extends Employee {
    public String skill;

    @Override
    public void print() {
        System.out.println("姓名：" + name + "，年龄：" + age + "，技能：" + skill);
    }
}

class Counsellor extends Employee {
    public int answerCount;

    @Override
    public void print() {
        System.out.println("姓名：" + name + "，年龄：" + age + "，回答问题的总人数：" + answerCount);
    }
}
