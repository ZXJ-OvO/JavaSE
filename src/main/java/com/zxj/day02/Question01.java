package com.zxj.day02;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 需求:
 * 身高是具有遗传性的，子女的身高和父母的身高有一定的关系。假定，父母和子女的身高遗传关系如下：
 * 儿子身高（厘米）＝(父亲身高＋母亲身高) ×1.08÷2
 * 女儿身高（厘米）＝(父亲身高×0.923＋母亲身高) ÷2
 * 现有父亲身高177CM,母亲身高165CM。求子女身高分别预计为多少？
 */
public class Question01 {
    public static void main(String[] args) {
        double d = 177.0;
        double e = 165.0;
        BigDecimal father = BigDecimal.valueOf(d);
        BigDecimal mother = BigDecimal.valueOf(e);


        System.out.println("儿子的身高：" + (father.add(mother)).multiply(BigDecimal.valueOf(1.08)).divide(BigDecimal.valueOf(2)).setScale(2, RoundingMode.HALF_UP));
        System.out.println("女儿的身高：" + (father.multiply(BigDecimal.valueOf(0.923)).add(mother).divide(BigDecimal.valueOf(2)).setScale(2, RoundingMode.HALF_UP)));
        ;
    }
}
