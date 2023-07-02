package com.zxj.day18;

/**
 * 猴子第一天摘下若干桃子，当即吃了一半，觉得好不过瘾，于是又多吃了一个
 * 第二天又吃了前天剩余桃子数量的一半，觉得好不过瘾，于是又多吃了一个
 * 以后每天都是吃前天剩余桃子数量的一半，觉得好不过瘾，又多吃了一个
 * 等到第10天的时候发现桃子只有1个了。
 * 需求：请问猴子第一天摘了多少个桃子？
 * 分析：
 * 整体来看，每一天都是做同一个事件，典型的规律化问题，考虑递归三要素：
 * 递归公式：f(n + 1) = f(n) - f(n) / 2 - 1
 * 2f(n + 1) = 2f(n) - f(n) - 2
 * 2f(n + 1) = f(n) - 2
 * f(n) = 2f(n + 1) + 2
 * 递归终结点：f(10) = 1
 * 递归方向：
 */
public class Question03 {
    public static void main(String[] args) {
        System.out.println(getNum(1));
    }

    public static int getNum(int count) {
        if (count == 10) {
            return 1;
        }
        count++;
        return 2 * getNum(count) + 2;
    }
}
