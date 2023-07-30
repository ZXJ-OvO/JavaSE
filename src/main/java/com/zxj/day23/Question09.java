package com.zxj.day23;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@MyTest4(value = "类", bbb = {"java", "redis", "docker"})
public class Question09 {
    @MyTest4(value = "方法", bbb = {"mysql", "elasticsearch", "jsp"})
    public static void test1() {

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> qClass = Class.forName("com.zxj.day23.Question09");
        System.out.println(qClass.isAnnotationPresent(MyTest4.class));

        // 获取类的自定义注解
        Annotation[] annotations = qClass.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解：-->" + annotation.toString());
        }

        // 获取方法的自定义注解
        Method method = qClass.getDeclaredMethod("test1");
        MyTest4 annotation = method.getAnnotation(MyTest4.class);
        System.out.println(annotation.toString());
    }
}

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyTest4 {
    String value();

    double aaa() default 100;

    String[] bbb();
}