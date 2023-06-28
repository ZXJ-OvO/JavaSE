package com.zxj.day15;

import java.util.LinkedList;

/**
 * LinkedList：基于双链表实现，查询慢，增删相对较快，对首尾元素的增删改查操作极快
 */
public class Question04 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("Java");
        linkedList.addFirst("Spring");
        linkedList.addLast("MySQL");
        linkedList.addLast("Redis");
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeFirst());

        System.out.println("-------------------------------");
        linkedList.forEach(s -> System.out.println(s + "\t"));
    }
}
