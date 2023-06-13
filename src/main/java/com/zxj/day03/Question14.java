package com.zxj.day03;

import java.util.Scanner;

/**
 * 2019年1月1日起，国家推出新的个人所得税政策，起征点上调值5000元。也就是说税前工资扣除三险一金（三险一金数额假设是税前工资的10%）后如果不足5000元，则不交税。如果大于5000元，那么大于5000元的部分按梯度交税，具体梯度比例如下：
 * 0 ~ 3000元的部分，交税3%
 * 3000 ~ 12000元的部分，交税10%
 * 12000 ~ 25000的部分 ， 交税20%
 * 25000 ~ 35000的部分，交税25%
 * 35000 ~ 55000的部分，交税30%
 * 55000 ~ 80000的部分，交税35%
 * 超过80000的部分，交税45%
 * 比如：黑马某学员入职一家企业后，税前工资是15000，则他每月该交个税的部分是15000-1500-5000=8500元，个税缴纳数额是3000×3%+5500×10%=640元。税后工资12860元。
 * 请完成一个个税计算程序，在用户输入税前工资后，计算出他对应的纳税数额，以及税后工资为多少？
 */
public class Question14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入税前工资：");
        double salary = sc.nextDouble();
        double tax = 0;
        double afterInsurance = salary - 1500 - 5000;
        if (afterInsurance < 0) {
            System.out.println("尚未达到起征点，不需要缴纳个人所得税");
        } else if (afterInsurance <= 3000) {
            tax = afterInsurance * 0.03;
        } else if (afterInsurance <= 12000) {
            tax = 3000 * 0.03 + (afterInsurance - 3000) * 0.1;
        } else if (afterInsurance <= 25000) {
            tax = 3000 * 0.03 + 9000 * 0.1 + (afterInsurance - 12000) * 0.2;
        } else if (afterInsurance <= 35000) {
            tax = 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + (afterInsurance - 25000) * 0.25;
        } else if (afterInsurance <= 55000) {
            tax = 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + (afterInsurance - 35000) * 0.3;
        } else if (afterInsurance <= 80000) {
            tax = 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + 20000 * 0.3 + (afterInsurance - 55000) * 0.35;
        } else {
            tax = 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + 20000 * 0.3 + 25000 * 0.35 + (afterInsurance - 80000) * 0.45;
        }
        System.out.println("个人所得税为：" + tax);
    }
}
