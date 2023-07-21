package com.hutool.util.number;

import cn.hutool.core.math.MathUtil;

public class MoneyUtil {
    public static void main(String[] args) {

        // 金额元转分 long cent = MathUtil.yuanToCent(double yuan)
        System.out.println(MathUtil.yuanToCent(1.2));

        // 金额分转元 double yuan = MathUtil.centToYuan(long cent)
        System.out.println(MathUtil.centToYuan(120));
    }
}
