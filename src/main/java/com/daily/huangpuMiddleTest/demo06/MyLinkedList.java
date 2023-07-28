package com.daily.huangpuMiddleTest.demo06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Consumer;

public class MyLinkedList<T> {

    private static class Node<T> {
        T val;
        Node<T> next;

        public Node(T data) {
            this.val = data;
            this.next = null;
        }
    }

    private Node<T> first;
    private int size;

    public int size() {
        return size;
    }

    public boolean add(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = first;

        if (size == 0) {
            first = newNode;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
        return true;
    }


    public boolean deleteAtIndex(int index) {
        if (size == 0) {
            throw new RuntimeException("链表为空");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            first = first.next;
            size--;
            return true;
        }

        Node<T> currentNode = first;

        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        Node<T> targetNode = currentNode.next;
        currentNode.next = targetNode.next;
        targetNode.next = null;
        size--;
        return true;
    }

    public boolean update(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> currentNode = first;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        currentNode.val = data;

        return true;
    }

    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> currentNode = first;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public boolean sort(Comparator<? super T> comparator) {
        if (first == null) {
            throw new RuntimeException("链表为空");
        }
        boolean swapped;
        Node<T> current;
        Node<T> lastSorted = null;
        do {
            swapped = false;
            current = first;

            while (current.next != lastSorted) {
                // comparator.compare(val1, val2)  > 负整数  = 0  < 负整数  当前的数大于后一个节点的值
                if (comparator.compare(current.val, current.next.val) > 0) {
                    // 当前的节点的值交给临时变量
                    T temp = current.val;
                    // 下一个节点的值交给当前的节点的值
                    current.val = current.next.val;
                    // 下一个节点拿到临时变量的值
                    current.next.val = temp;
                    // 至此完成前后两个节点的值的交换 修改交换标记
                    swapped = true;
                }
                // 推进到下一个节点
                current = current.next;
            }
            lastSorted = current; // 最后一个已排序节点，减少比较次数
        } while (swapped);
        return true;
    }

    public void deleteDuplicate() {
        if (first == null) {
            throw new RuntimeException("链表为空");
        }

        HashSet<T> seenElements = new HashSet<>();
        Node<T> currentNode = first;
        Node<T> prevNode = null;

        ArrayList<Integer> indexDuplicate = new ArrayList<>();


        if (size == 1) {
            System.out.println("链表长度为1，无意义的排序操作");
        } else {
            while (currentNode != null) {
                if (seenElements.contains(currentNode.val)) {
                    // 删除重复元素的节点
                    prevNode.next = currentNode.next;
                    currentNode = currentNode.next;
                    size--;
                } else {
                    seenElements.add(currentNode.val);
                    prevNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
            seenElements.clear();
        }

        System.out.println(indexDuplicate.size());
        for (Integer integer : indexDuplicate) {
            deleteAtIndex(integer);
        }

    }

    public void forEach(Consumer<? super T> action) {
        Node<T> currentNode = first;
        while (currentNode != null) {
            action.accept(currentNode.val);
            currentNode = currentNode.next;
        }
    }

}

