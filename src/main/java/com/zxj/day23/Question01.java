package com.zxj.day23;


public class Question01 {
    public static final String a = "abcd";
    public static void main(String[] args) {
        String q = "ab" + "cd";
        String w = "ab";
        String e = "cd";
        System.out.println(q == a);
        System.out.println((w + e) == a);
    }
}
