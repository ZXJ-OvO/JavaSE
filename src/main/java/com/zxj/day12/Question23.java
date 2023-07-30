package com.zxj.day12;

import java.util.Scanner;

/**
 * 1、定义一个枚举类
 * 2、在枚举类中定义三个枚举项(CHARGE_TYPE_CHARGED、CHARGE_TYPE_FREE、CHARGE_TYPE_MEMBER_RIGHTS)
 * 3、在该枚举类中定义两个属性分别表示标号和付款类型的名称
 * 4、通过构造方法完成属性的初始化
 * 5、定义一个静态方法：根据标号获取付款名称
 * 6、使用枚举优化上述的if...else代码
 * 某商场的付款类型有三种：自费、免费、会员权益。在系统中进行记录的时候，往往是通过三个标号进行表示：10131001、10131002、10131003。在给用户进行数据展示的时候，
 */
public class Question23 {
    public static void main(String[] args) {
        System.out.println("请输入付款类型的标号：");
        String next = new Scanner(System.in).next();
        System.out.println(ChargeType.getNameByCode(next));
    }
}

//
enum ChargeType {
    CHARGE_TYPE_CHARGED("10131001", "自费"),
    CHARGE_TYPE_FREE("10131002", "免费"),
    CHARGE_TYPE_MEMBER_RIGHTS("10131003", "会员权益");

    private final String code;
    private final String name;

    ChargeType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(String code) {
        for (ChargeType value : ChargeType.values()) {
            if (value.code.equals(code)) {
                return value.name;
            }
        }
        return null;
    }
}