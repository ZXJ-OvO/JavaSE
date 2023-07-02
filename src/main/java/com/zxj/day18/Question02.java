package com.zxj.day18;

/**
 * 需求：计算1-n的和的结果，使用递归思想解决。
 * 分析:  我们先从数学思维上理解递归的流程和核心点
 * 假如我们认为存在一个公式是 f(n) = 1 + 2 + 3 + 4 + 5 + 6 + 7 + …(n-1) + n;
 * 那么公式等价形式就是： f(n) = f(n-1)  + n
 * 递归的终结点：f(1) = 1
 * 递归的方向
 */
public class Question02 {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }
}
