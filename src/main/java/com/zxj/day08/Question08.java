package com.zxj.day08;

public class Question08 {
    public static void main(String[] args) {
        String s = "12345";
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            s2.append(s.charAt(i));
        }
        s = s2.toString();
        System.out.println(s);
    }
}
