package com.daily.finalExam.Demo03;

import java.util.Random;
import java.util.TreeSet;

/**
 * **需求**
 * 注意：本案例必须使用递归完成，否则不给分。
 * 目前有100名囚犯，每个囚犯的编号是1-200之间的随机数。
 * 现在要求依次随机生成100名囚犯的编号（要求这些囚犯的编号是不能重复的）然后让他们依次站成一排，(注：位置是从1开始计数的)。
 * 接下来，国王命令手下先干掉全部奇数位置处的人。
 * 剩下的人，又从新按位置1开始，再次干掉全部奇数位置处的人，依此类推，
 * 直到最后剩下一个人为止，剩下的这个人为幸存者。
 * 要求找出幸存者的编号，以及该幸存者第一次排位时所占的具体位置值。
 */
public class Test03 {
    public static void main(String[] args) {

        // 生成100个1-200的不重复的囚犯随机编号
        Random random = new Random();
        TreeSet<Integer> integers = new TreeSet<>();
        while (integers.size() < 100) {
            integers.add(random.nextInt(200) + 1);
        }
        System.out.println("1、生成的囚犯随机编号：");
        System.out.println(integers);
        System.out.println();

        // 递归干掉奇数位置的囚犯
        System.out.println("2、干掉奇数位置的囚犯：");
        System.out.println("幸存者的编号是：" + kill(integers));
    }

    private static String kill(TreeSet<Integer> integers) {
        if (integers.size() == 1) {
            return integers.first() + "";
        }
        TreeSet<Integer> newIntegers = new TreeSet<>();
        // 位置是从1开始计数的
        int i = 1;
        for (Integer integer : integers) {
            if (i % 2 == 0) {
                newIntegers.add(integer);
            }
            i++;
        }
        return kill(newIntegers);
    }

}
