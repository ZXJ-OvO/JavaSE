package com.zxj.day01;

/**
 * 请编写程序，分别定义8种基本数据类型的变量，并打印变量的值。
 */
public class Question03 {
    public static void main(String[] args) {
        // 定义byte类型变量，值为整数，只要在byte范围即可，byte范围：-128 ~ 127
        byte b = 100;
        System.out.println(b);
        // 定义short类型变量，值为整数，只要在short范围即可
        short s = 12345;
        System.out.println(s);

        // 整数的默认类型就是int类型
        int num = 654321;
        System.out.println(num);

        // 定义long类型的整数，需要在数据的后面加字母（L），大小写不限，建议大写。
        long lo = 123456789L;
        System.out.println(lo);

        // 定义float类型的浮点数，需要在数据的后面加字母（F），大小写不限，建议大写。
        float f = 1.5F;
        System.out.println(f);

        // 浮点型默认类型double
        double d = 123.456;
        System.out.println(d);

        // 布尔型只有两个取值：true和false
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1);
        System.out.println(b2);

        // 定义字符型需要一对英文的单引号包裹，并且只能包含一个字符
        char c = 'a';
        System.out.println(c);

    }
}
