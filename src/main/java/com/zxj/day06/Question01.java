package com.zxj.day06;

/**
 *用户购买机票时，机票原价会按照淡季、旺季，头等舱还是经济舱的情况进行相应的优惠，优惠方案如下：
 * 5-10月为旺季，头等舱9折，经济舱8.5折；
 * 11月到来年4月为淡季，头等舱7折，经济舱6.5折，
 * 请开发程序计算出用户当前机票的优惠价。
 */
public class Question01 {
    public static void main(String[] args) {
        double price = 1000;
        int month = 5;
        String type = "头等舱";
        double discount = 1;
        if (month >= 5 && month <= 10) {
            if (type.equals("头等舱")) {
                discount = 0.9;
            } else if (type.equals("经济舱")) {
                discount = 0.85;
            }
        } else if (month >= 11 || month <= 4) {
            if (type.equals("头等舱")) {
                discount = 0.7;
            } else if (type.equals("经济舱")) {
                discount = 0.65;
            }
        }
        System.out.println("优惠价为：" + price * discount);
    }
}
