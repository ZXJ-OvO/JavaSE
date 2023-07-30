package com.zxj.day23;


import java.lang.annotation.*;
import java.util.Arrays;

/**
 * 自定义注解可以用来标注：类、成员变量、成员方法、局部变量、参数
 */
@info(value = "值")
public class Question08 {
    public static void main(String[] args) {
        // 根据类对象获取类上的所有注解，返回注解数组
        Class<Question08> aClass = Question08.class;
        Annotation[] declaredAnnotations = aClass.getDeclaredAnnotations();
        // declaredAnnotations
        System.out.println(Arrays.toString(declaredAnnotations));
        System.out.println(aClass.isAnnotationPresent(info.class));

    }
}

/**
 * 自定义注解
 */
@Retention(value = RetentionPolicy.CLASS)
@Target(value = ElementType.TYPE)
@interface info {
    // public String name() default "自定义注解";

    public String value(); // 特殊属性

    public String name() default "ZXJ";

    public String Occupation() default "Java工程师";

    public String mail() default "ZXJ-OvO@gmail.com";
}
