package com.daily.huangpuSETest.demo06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyLinkedList<E> {
    // 封装一个链表
    Node<E> head = null;


    /**
     * 定义了一个私有的内部类，作为链表的结点。
     */
    public static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node<E> add(E e) {
        if (head == null) {
            head = new Node<>(e, null);
        } else {
            // 往后面插入结点。（尾插法）
            Node<E> temp = head;
            // 让temp走到尾部结点
            while (temp.next != null) {
                temp = temp.next;
            }
            // 把当前结点创建出来，加入到尾部结点
            temp.next = new Node<>(e, null);
        }
        return head;
    }

    public void sort() {
        if (head == null) {
            System.out.println("链表为空");
        }

        if (head.next == null) {
            System.out.println("链表中仅存在一个元素，无意义的排序操作");
        }

        ArrayList<Object> list = this.foreach();

        Object[] objects = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            objects[i] = list.get(i);
        }
        Arrays.sort(objects);
        head = null;
        for (Object object : objects) {
            add((E) object);
        }
    }

    public MyLinkedList<?> mergeSort(MyLinkedList<E> list1, MyLinkedList<E> list2) {
        ArrayList<Object> l1 = list1.foreach();
        ArrayList<Object> l2 = list2.foreach();
        List<Object> list = new ArrayList<>();
        list.addAll(l1);
        list.addAll(l2);

        MyLinkedList<Object> linkedList = new MyLinkedList<>();

        Object[] objects = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            objects[i] = list.get(i);
        }

        for (Object o : list) {
            linkedList.add(o);
        }

        linkedList.sort();
        return linkedList;
    }

    public ArrayList<Object> foreach() {
        Node<E> node = head;
        ArrayList<Object> list = new ArrayList<>();
        while (node != null) {
            E data = node.data;
            list.add(data);
            node = node.next;
        }
        return list;
    }
}