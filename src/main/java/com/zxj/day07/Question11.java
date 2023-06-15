package com.zxj.day07;


public class Question11 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) print(i);
        for (int i = 9; i > 0; i--) print(i);
    }

    public static void print(int i) {
        for (int j = 1; j <= 10 - i; j++) System.out.print(" ");
        for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
        System.out.println(" ");
    }
}