package com.daily.huangpuReview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 需求：给你一个整数 x 。
 * 如果 x 是一个回文整数，打印 true ，否则，返回 false 。
 * 解释：回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * 比如：输入：x = 121		输出：true
 * 比如：输入：x = -121		输出：false
 * 解释：从左向右读, 为 -121。从右向左读, 为 121- 。因此它不是一个回文数。
 * 比如：输入：x = 10		输出：false
 * 解释：从右向左读, 为01。因此它不是一个回文数。
 */
public class Question07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int palindromicInputNumber = scanner.nextInt();
        String palindromicString = palindromicInputNumber + "";
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < palindromicString.length(); i++) {
            arrayList.add(palindromicString.charAt(i));
        }
        Collections.reverse(arrayList);
        StringBuilder result = new StringBuilder();
        for (Character character : arrayList) {
            result.append(character);
        }
        System.out.println(result.toString().equals(palindromicString));
    }
}
