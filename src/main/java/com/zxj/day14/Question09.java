package com.zxj.day14;

import java.math.BigDecimal;

/**
 * 我们使用转账的时候,输入金额之后小数点后面只能输入到2位,而在程序内部,实际上是把输入的元,转成了分去操作了,当我们转成功之后,会再把分变成元来展示给用户们,请设计程序,完成所描述的需求
 * 提示:直接将元转成分,再将分转成元(至于软件内部怎么操作分的,我们无需关心)
 */
public class Question09 {
    public static void main(String[] args) {
        System.out.println("请输入金额(单位:元):");
        double money = new java.util.Scanner(System.in).nextDouble();
        BigDecimal cent = BigDecimal.valueOf(money).multiply(BigDecimal.valueOf(100));
        System.out.println("转账成功,您的账户余额为:" + cent.divide(BigDecimal.valueOf(100)));
    }
}
