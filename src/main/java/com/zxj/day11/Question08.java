package com.zxj.day11;

import lombok.Data;

public class Question08 {
    public static void main(String[] args) {
        TeacherIt teacherIt = new TeacherIt("关羽", 18, "卖牛杂");
        GuiderIt guiderIt = new GuiderIt("张飞", 20, 64);

        teacherIt.personInfo();
        guiderIt.personInfo();
    }
}

abstract class Person {
    public String name;
    public Integer age;

    public abstract void personInfo();

    public void print() {
        personInfo();
        System.out.println("零基础，学IT");
        System.out.println("月薪过万");
        System.out.println("就来黑马程序员");
        System.out.println("黑马程序员");
        System.out.println("成就IT黑马");
    }
}

@Data
class TeacherIt extends Person {
    public String skills;

    public TeacherIt() {
    }

    public TeacherIt(String name, Integer age, String skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

    @Override
    public void personInfo() {
        System.out.println(this.name + this.age + "岁学Java");
        System.out.println(this.name + "的技能" + skills);
    }

}

@Data
class GuiderIt extends Person {
    public Integer total;

    public GuiderIt() {
    }

    public GuiderIt(String name, Integer age, Integer total) {
        this.name = name;
        this.age = age;
        this.total = total;
    }

    @Override
    public void personInfo() {
        System.out.println(this.name + this.age + "岁学Java");
        System.out.println(this.name + "劝退了" + this.total + "人。");
    }
}