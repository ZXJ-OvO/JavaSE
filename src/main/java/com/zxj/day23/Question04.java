package com.zxj.day23;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 反射获取成员变量
 */
public class Question04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> name = Class.forName("com.zxj.day23.Teacher");

        // 返回所有public的成员变量数组
        Field[] fields = name.getFields();
        System.out.println(Arrays.toString(fields));

        // 返回所有的成员变量
        Field[] declaredFields = name.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // 返回单个public的成员变量
        Field announce = name.getField("announce");
        System.out.println(announce);

        // 返回单个成员变量
        Field title = name.getDeclaredField("title");
        System.out.println(title);

        // 返回成员变量的数据类型

        Class<?> type = title.getType();
        System.out.println(type);

        // 取消访问检查
        title.setAccessible(true);

        // 拿到数据
        Object o = title.get(null);
        System.out.println(o.toString());
        Object o1 = announce.get(null);
        System.out.println(o1);

        System.out.println("--");
        // 给对象设置值

        Constructor<?> constructor = name.getConstructor(String.class, Integer.class);
        Object o2 = constructor.newInstance("徐磊", 99);
        announce.set(o2, "是不是疯了");
        Object o3 = announce.get(o2);
        System.out.println(o3.toString());

    }
}
