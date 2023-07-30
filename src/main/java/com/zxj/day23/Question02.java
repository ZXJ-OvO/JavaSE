package com.zxj.day23;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * 反射拿到构造器
 */
public class Question02 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> teacherClass = Class.forName("com.zxj.day23.Teacher");

        Constructor<?>[] constructors = teacherClass.getConstructors();
        // 只能拿到public的构造器
        System.out.println(Arrays.toString(constructors));

        // 暴力拿到所有构造器
        Constructor<?>[] declaredConstructors = teacherClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        // 返回单个public构造器对象
        Constructor<?> constructor = teacherClass.getConstructor(String.class, Integer.class);
        System.out.println(constructor);


        // 返回单个构造器对象
        Constructor<?> privateConstructor = teacherClass.getDeclaredConstructor(String.class);
        System.out.println(privateConstructor.getName());

        // 返回构造器名
        String name = teacherClass.getName();
        System.out.println(name);

    }

}

class Teacher {
    private String name;
    public Integer id;
    public static String announce = "不自由，毋宁死";
    private static final String title = "王侯将相宁有种乎";

    public Teacher() {
    }

    public Teacher(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    private Teacher(String name) {
        this.name = name;
    }

    public static void staticMethod() {
        System.out.println("反射拿到的静态方法");
    }

    public void publicMethod() {
        System.out.println("反射拿到的公共方法");
    }

    private void privateMethod() {
        System.out.println("反射拿到的私有方法");
    }
}