package com.zxj.day03;

/**
 * 某商场购物可以打折，具体规则如下：
 * 普通顾客购不满100元不打折，满100元打9折；
 * 会员购物不满200元打8折，满200元打7.5折；
 * 不同打折规则不累加计算。
 * 请根据此优惠计划进行购物结算，键盘录入顾客的类别（0表示普通顾客，1表示会员）和购物的折前金额（整数即可），输出应付金额（小数类型）。
 */
public class Question13 {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.print("请输入顾客类别（0表示普通顾客，1表示会员）：");
        int type = in.nextInt();
        System.out.print("请输入购物的折前金额：");
        double money = in.nextDouble();
        double discount = 1;
        if (type == 0) {
            if (money >= 100) {
                discount = 0.9;
            }
        } else if (type == 1) {
            if (money >= 200) {
                discount = 0.75;
            } else {
                discount = 0.8;
            }
        }
        System.out.println("应付金额：" + money * discount);
    }
}
