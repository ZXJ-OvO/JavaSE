package com.zxj.day12;

import java.util.StringJoiner;

/**
 * StringJoiner
 */
public class Question08 {
    public static void main(String[] args) {
        // 创建StringJoiner时指定拼接时的分割符号
        StringJoiner joiner1 = new StringJoiner(",");
        System.out.println(joiner1.add("a").add("b").add("c"));

        // 创建StringBuilder对象，并指定拼接操作的起始符号、结束符号、分隔符号
        StringJoiner joiner2 = new StringJoiner(",", "[", "]");
        System.out.println(joiner2.add("a").add("b").add("c"));


    }
}
