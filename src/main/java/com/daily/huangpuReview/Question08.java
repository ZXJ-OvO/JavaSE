package com.daily.huangpuReview;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 暂时不用考虑数据太大的问题，把本题的核心思路写出来即可
 * 比如：
 * 输入：x = 123
 * 输出：321
 * 输入：x = -123
 * 输出：-321
 * 输入：x = 120
 * 输出：21
 * 输入：x = 0
 * 输出：0
 * 要注意，考虑到特殊情况：2147483647，反转之后就超出范围了，此时就要返回0
 */
public class Question08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int oppositeNumber;

        if (inputNumber > 0) {
            long reverse = reverse(inputNumber);
            System.out.println(reverse);
        } else if (inputNumber < 0) {
            oppositeNumber = inputNumber * (-1);
            long reverse = reverse(oppositeNumber);
            System.out.println(reverse * (-1));

        } else {
            System.out.println(0);
        }
    }

    private static Long reverse(int inputNumber) {
        String inputNumberString = inputNumber + "";
        int stringLength = inputNumberString.length();
        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < stringLength; i++) {
            characters.add(inputNumberString.charAt(i));
        }

        Collections.reverse(characters);

        StringBuilder reverseNumberString = new StringBuilder();
        for (Character character : characters) {
            reverseNumberString.append(character);
        }

        Long reverseNumber = Long.parseLong(reverseNumberString.toString());

        long flag = checkBound(reverseNumber);

        if (flag == 1) {
            return reverseNumber;
        } else if (flag == 0) {
            return 0L;
        }
        return 0L;
    }

    private static Long checkBound(Long toBeCheckedNumber) {
        if (toBeCheckedNumber > Integer.MAX_VALUE || toBeCheckedNumber < Integer.MIN_VALUE) {
            return 0L;
        } else {
            return 1L;
        }
    }

}
