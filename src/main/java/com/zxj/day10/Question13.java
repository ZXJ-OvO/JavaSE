package com.zxj.day10;

import java.util.ArrayList;

public class Question13 {
    private static final ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        test();

        System.out.println(list);

    }

    /*
      静态代码块 最先执行
     */
    static {
        System.out.println("静态代码块被加载一次");
        list.add("Java");
        list.add("MySQL");
        list.add("Redis");
    }

    /*
      实例代码块 创建对象的时候执行
     */ static {
        System.out.println("普通代码块被执行一次");
    }

    public Question13() {
        System.out.println(this + " 构造器执行");
    }

    public static void test() {
        System.out.println("普通方法被执行");
    }
}
