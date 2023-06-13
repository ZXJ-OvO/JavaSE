package com.zxj.day03;

/**
 * 使用for循环打印出九九乘法表。打印效果如下：
 * 1×1=1
 * 1×2=2	2×2=4
 * ...
 * 1×8=8	2×8=16	3×8=24	4×8=32	5×8=40	6×8=48	7×8=56	8×8=64
 * 1×9=9	2×9=18	3×9=27	4×9=36	5×9=45	6×9=54	7×9=63	8×9=72	9*9=81
 */
public class Question19 {
    public static void main(String[] args) {
        System.out.println("打印左对齐正三角");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }

        System.out.println("打印左对齐倒三角");
        for (int i = 9; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }

    }
}
