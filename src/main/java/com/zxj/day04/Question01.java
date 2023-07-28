package com.zxj.day04;

/**
 * 某部门5名员工的销售额分别是：16、26、36、6、100，请计算出他们部门的总销售额。
 */
public class Question01 {
    public static void main(String[] args) {
        int[] array = {1616, 2626, 36, 6, 100};
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        System.out.println(sum);
    }
}
