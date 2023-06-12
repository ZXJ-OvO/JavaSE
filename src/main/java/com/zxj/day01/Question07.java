package com.zxj.day01;

/**
 * 请根据以上描述，选用合适的数据类型定义变量用于描述一个学员的信息，并将其输出到屏幕上。输出结果如下：
 * ************************
 * 我的姓名是：张三
 * 我的性别是：男
 * 我的年龄是：18
 * 我的地址是：xx省xx市
 * 我的饭卡余额是：55.55元
 * ************************
 */
public class Question07 {
    public static void main(String[] args) {
        // 姓名
        String name = "张三";
        // 性别
        String gender = "男";
        // 年龄
        int age = 20;
        // 地址
        String address = "美国芝加哥";
        // 余额
        double money = 88.88;

        System.out.println("************************");
        System.out.println("我的姓名是：" + name); // 在输出语句中将变量与字符串拼接
        System.out.println("我的性别是：" + gender);
        System.out.println("我的年龄是：" + age);
        System.out.println("我的地址是：" + address);
        System.out.println("我的饭卡余额是：" + money + "元");
        System.out.println("************************");
    }
}
