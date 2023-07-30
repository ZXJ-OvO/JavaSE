package com.zxj.day10;

import lombok.Data;

/**
 * 1.定一个OldPhone类,定义两个私有属性brand和price,定义空参和有参构造方法,get/set方法
 * 2.在OldPhone类中,定义一个打电话的方法,传递姓名的参数,方法体内输出给谁打电话
 * 3.在OldPhone类中,定义一个发短信的方法,直接输出"发短信"
 * 4.定一个子类NewPhone,继承OldPhone类,在子类中定义玩游戏的特有方法,直接输出内容"玩游戏"
 * 5.定义测试类,创建NewPhone类对象,调用set方法为属性赋值,调用get方法获取属性值
 * 6.调用从父类中继承过来的方法以及自己特有的方法.
 * 注意：Lombok注解生成的代码都是public修饰的
 * 4.定义一个来电显示的方法,输出内容为"显示手机号",
 * 4.定一个子类NewPhone,继承OldPhone类,在子类中重写来电显示的方法,输出内容为"显示手机号","显示归属地","显示头像"
 * 5.定义测试类,创建NewPhone类对象,调用set方法为属性赋值,调用get方法获取属性值
 * 6.调用从父类中继承过来的方法以及重写的方法
 */
public class Question05 {
    public static void main(String[] args) {
        NewPhone newPhone = new NewPhone();
        newPhone.setBrand("华为");
        newPhone.setPrice(99.8);
        System.out.println(newPhone.getBrand() + "：" + newPhone.getPrice());
    }

}

@Data
class OldPhone {
    private String brand;
    private Double price;
}


class NewPhone extends OldPhone {

}

