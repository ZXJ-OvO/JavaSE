package com.daily.day07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 第二题:分析以下需求，并用代码实现
 * 定义汽车类Car,包含以下成员：
 * 成员属性:
 * 品牌 brand( String类型)
 * 电量 power(double类型)
 * 成员方法:
 * 报警 warning()   调用方法,可以检验当前电量是否低于10,如果低于10,就打印"***电量不足". 如果不低于10,就打印"***电量充足"  ***代表品牌名称
 * <p>
 * 1.按照以上要求定义Car,属性要私有,生成空参、有参构造，setter和getter方法
 * 2.定义测试类:根据如下需求创建多个对象,调用warning()方法.
 * 特斯拉-50    比亚迪-9
 */
public class Question02 {
    public static void main(String[] args) {
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        class Car {
            private String brand;
            private double power;

            public void warning() {
                if (power < 10) {
                    System.out.println(brand + "电量不足");
                } else {
                    System.out.println(brand + "电量充足");
                }
            }
        }

        new Car("特斯拉", 50).warning();
        new Car("比亚迪", 9).warning();
    }
}
