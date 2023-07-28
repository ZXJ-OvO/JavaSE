package com.zxj.day13;

import com.customer.BigDecimalUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 已知手机的价格是3999, 钢化膜的价格是9.9, 店家促销策略为: 满4000打98折.   现在小明买了一台手机和两块钢化膜, 请问小明应该付多少钱(精确到分)？
 */
public class Question16 {
    public static void main(String[] args) {
        double add = BigDecimalUtil.add(3999, 9.9);
        double multiply = BigDecimalUtil.multiply(add, 0.98);
        BigDecimal bigDecimal = BigDecimal.valueOf(multiply).setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal);
    }
}
