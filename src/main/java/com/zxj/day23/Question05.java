package com.zxj.day23;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 反射获取方法对象、执行方法
 */
public class Question05 {
    public static void main(String[] args) throws Exception {
        Class<?> tClass = Class.forName("com.zxj.day23.Teacher");

        // 获取public成员方法
        Method[] methods = tClass.getMethods();
        System.out.println(Arrays.toString(methods));

        // 获取所有成员方法
        Method[] methods1 = tClass.getDeclaredMethods();
        System.out.println(Arrays.toString(methods1));

        // 获取单个的public方法
        Method publicMethod = tClass.getMethod("publicMethod");
        System.out.println(publicMethod);

        // 返回单个方法
        Method privateMethod = tClass.getDeclaredMethod("privateMethod");
        System.out.println(privateMethod);

        // 获取静态方法
        Method staticMethod = tClass.getDeclaredMethod("staticMethod");
        System.out.println(staticMethod);

        // 执行公共方法，传入的对象是类的对象
        Teacher teacher = new Teacher();
        Object invoke = publicMethod.invoke(teacher);
        System.out.println(invoke);

        // 执行静态方法，传入的对象是类对象
        Object invoke1 = staticMethod.invoke(tClass);
        System.out.println(invoke1);

        // 执行私有方法，传入的对象是类的对象
        privateMethod.setAccessible(true);
        Object invoke2 = privateMethod.invoke(teacher);
        System.out.println(invoke2);
    }

}
