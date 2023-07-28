package com.daily.huangpuSETest.demo06;

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

    public boolean sort() {
        if (head == null) {
            System.out.println("链表为空");
            return false;
        }

        if (head.next == null) {
            System.out.println("链表中仅存在一个元素，无意义的排序操作");
            return false;
        }

        Node<E> currentNode = head;

        while (currentNode.next != null) {
//            if (currentNode.data > currentNode.next.data) {
//                E tempNodeData = currentNode.data;
//                currentNode.data = currentNode.next.data;
//                currentNode.next.data = tempNodeData;
//
//            }
//            currentNode = currentNode.next;
        }
        return true;


    }
}