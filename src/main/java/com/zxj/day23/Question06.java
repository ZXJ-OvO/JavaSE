package com.zxj.day23;

import java.lang.reflect.Method;

/**
 * 集合泛型擦除，反射塞入其他类型的数据
 */
public class Question06 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        doubles.add(1.1);
        doubles.add(2.2);

        System.out.println(integers.getClass() == doubles.getClass());

        Class<? extends ArrayList> listClass = integers.getClass();
        Method method = listClass.getDeclaredMethod("add", Object.class);
        Object invoke = method.invoke(integers, "字符1");
        // Integer类型的ArrayList集合塞入一个字符串
        System.out.println(integers);
        System.out.println(invoke);


        // 基于泛型擦除的机制，直接将原集合交给新集合
        ArrayList list = doubles;
        list.add("字符串");
        System.out.println(list);

    }
}
