package com.zxj.day08;

/**
 * 打印菱形
 */
public class Question01 {
    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            //换位思考 如果打印是  *  能成一个三角形 那么打印 "  "  个能成一个三角形 只是" "看不到而已, 我们用空格填充  "*"部分
            //这时候倒着打印就行,因为我们的 外循环体i 最大为3  所以里面的K 应该小于或者等于 3-i   并且 k >=0 这样就能打印出一个倒着的看不见的
            //三角形了
            for (int k = 3 - i; k >= 0; k--) {
                System.out.print(" ");
            }
            //首先我们这里 打印一个三角形  这边三角形定义的是  j为0  j小于i*2+1  这样  j就小于可能为 1 3 5 7 的数
            //满足这个条件的时候就打印出来.并且每打印一行就换行打印
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //把里面的这个再根据外循环去倒着打印一遍,就能得到一个菱形
        for (int i = 4; i >= 0; i--) {
            for (int k = 3 - i; k >= 0; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
