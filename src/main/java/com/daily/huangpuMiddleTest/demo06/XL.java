package com.daily.huangpuMiddleTest.demo06;

import java.util.Arrays;
import java.util.StringJoiner;

public class XL<E extends Comparable> {

    private Node<E> head;
    private int size;

    public boolean add(E e) {
        // 先创建这个结点
        Node<E> node = new Node<>(e, null);
        if (head == null) {
            head = node;
        } else {
            // 头结点是有的，用尾插法。找到尾结点。
            Node<E> temp = head;
            while (temp != null) {
                if (temp.next == null) {
                    // temp到了最后一个结点。
                    temp.next = node;
                    break;
                }
                temp = temp.next;
            }
        }
        size++;
        return true;
    }


    public void forEach() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Node<E> temp = head;
        while (temp != null) {
            sj.add(temp.val + "");
            temp = temp.next;
        }
        System.out.println(sj.toString());
    }


    public E deleteAtIndex(int index) {
        // 判断索引是否合法
        checkIndexOutOfBounds(index);
        // 删除结点。
        E val = null;
        if (index == 0) {
            // 删除的是头结点。
            val = head.val;
            head = head.next;
        } else {
            // 删除的是后面的结点
            Node<E> node = node(index - 1);
            val = node.next.val;
            node.next = node.next.next;
        }
        size--;
        return val;

    }

    private Node<E> node(int index) {
        Node<E> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private void checkIndexOutOfBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("delete index out of range 0 -> " + (size - 1));
        }
    }

    public void sort() {
        // 给头结点对应的链表进行排序。
        Object[] arr = new Object[size];
        int index = 0;
        Node<E> temp = head;
        while (temp != null) {
            arr[index++] = temp.val;
            temp = temp.next;
        }
        Arrays.sort(arr);
        // 顺着链表填数据
        Node<E> temp2 = head;
        for (Object o : arr) {
            temp2.val = (E) o;
            temp2 = temp2.next;
        }
    }

    /**
     * 删除结点。
     */
    public void deleteDuplicate() {
        // 拿到头结点，往后想办法删除，删除之后，其实必须返回头结点。
        Node<E> temp = head;
        head = deleteDuplicate(temp);
    }

    public Node<E> deleteDuplicate(Node<E> temp) {
        // 1、极端情况
        if (temp == null || temp.next == null) {
            return temp;
        }

        // 2、判断当前结点和下一个结点是否相等的情况。
        if (temp.val == temp.next.val) {
            // 当前结点和下一个结点是相等的。
            while (temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
            }
            return deleteDuplicate(temp.next);
        } else {
            // 当前结点和下一个结点是不相等的。
            temp.next = deleteDuplicate(temp.next);
            return temp;
        }
    }

    private static class Node<E> {
        E val;
        Node<E> next;

        public Node() {
        }

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }
}
