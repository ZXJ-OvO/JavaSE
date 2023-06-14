package com.zxj.day05;

/**
 * 我们知道数学中有九九乘法表。
 * 请定义一个方法，方法的功能是打印nn乘法表。在主方法中键盘录入取值范围为[1-9]的变量n，测试方法。执行效果如下：
 */
public class Question10 {
    public static void main(String[] args) {
        printTable(9);
    }

    public static void printTable(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
