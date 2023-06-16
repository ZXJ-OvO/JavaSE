package com.zxj.day08;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * 请编写程序，由键盘录入一个字符串，
 * 把字符串中的所有字母都变成大写后输出,
 * 再把字符串中的所有字母变成小写后输出。
 * * ASCII:
 * * 0-9：48-57
 * * A-Z：65-90
 * * a-z：97-122
 * * 中文：0-65535
 */
public class Question11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串（支持中文、字母、数字）：");
        String str = sc.nextLine();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }
        System.out.println();
        int en = 0;
        int num = 0;
        // 通过ASCII可以知道A-a的差值是32，所以可以通过加减32来实现大小写转换
        for (int i = 0; i < charArray.length; i++) {
            if (97 <= charArray[i] && charArray[i] <= 122) {
                charArray[i] = (char) (charArray[i] - 32);
            } else if (65 <= charArray[i] && charArray[i] <= 90) {
                charArray[i] = (char) (charArray[i] + 32);
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }
    }
}