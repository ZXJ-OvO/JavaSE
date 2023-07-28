package com.customer;

public class Test {
    public static void main(String[] args) {
        StringBuilder builder2 = new StringBuilder("abcde");
      //  builder1.replace(0, 5, "b");
        builder2.delete(1, 3).insert(1, "b");
        System.out.println("111");

    }
}
