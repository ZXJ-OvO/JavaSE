package com.zxj.day08;

public class Question08 {
    public static void main(String[] args) {
        String s = "12345";
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            s2+= s.charAt(i);
        }
        s = s2;
        System.out.println(s);
    }
}
