package com.zxj.day23;

public class Question03 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Java");
        linkedList.add("MySQL");
        linkedList.add("Docker");
        linkedList.add("Redis");
        linkedList.add("Spring");

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.findNodeByIndex(i) + "\t" + linkedList.get(i));
        }

        System.out.println();
        System.out.println(linkedList.toString());

        System.out.println(linkedList.contain("Docker"));

        System.out.println(linkedList);
    }
}
