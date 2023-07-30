package com.zxj.day23;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射获取构造器并创建对象
 */
public class Question03 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Teacher teacher = new Teacher("REFLEX ", 26);
        Class<? extends Teacher> aClass = teacher.getClass();
        // 已经弃用
        // Teacher teacher2 = aClass.newInstance();
        // 推荐使用
        Constructor<? extends Teacher> constructor = aClass.getDeclaredConstructor(String.class);

        // 取消检查，暴力反射，本次有效
        constructor.setAccessible(true);
        Teacher teacher1 = constructor.newInstance("我们");
        System.out.println(teacher1);
    }
}
