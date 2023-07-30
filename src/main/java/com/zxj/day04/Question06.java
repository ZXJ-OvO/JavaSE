package com.zxj.day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 某公司开发部5名开发人员，要进行项目进展汇报演讲，现在采取随机排名后进行汇报。
 * 请先依次录入5名员工的工号，然后展示出一组随机排名顺序。
 */
public class Question06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入5名员工的工号：");

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            integers.add(in.nextInt());
        }
        Collections.shuffle(integers);
    }
}
