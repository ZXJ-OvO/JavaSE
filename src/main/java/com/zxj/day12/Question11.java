package com.zxj.day12;

/**
 * 请完善下列代码，在main方法中调用Inner的method方法,输出30
 */
public class Question11 {
    public static void main(String[] args) {
        // 在此处补全代码
        /*
            内部类能直接访问外部类
            外部类不能直接访问内部类
            想访问内部类成员,需要创建外部类对象
            在根据外部类对象创建内部类对象
            格式:外部类类名.内部类类名 对象名 = new 外部类对象.new 内部类对象()
         */
        Outer.Inner inner = new Outer().new Inner();
        inner.method();
    }
}


class Outer {
    class Inner {
        public void method() {
            int num = 30;
            System.out.println(num);
        }
    }
}