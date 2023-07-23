package com.daily.huangpuMiddleTest.demo06;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class MyLinkedList<T> {
    class Node<T> {
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

    // TODO: 2023/7/23 思路：归并排序？修改泛型声明？排序方法泛型修改Comparator ？节点类的泛型声明修改为Comparable？
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
                /*
                    使用冒泡排序，反复比较相邻的元素，并在它们的顺序不正确时交换它们的位置。
                    每次遍历列表后，最大的元素会冒泡到正确的位置，即在列表的末尾
                    为了优化排序算法并减少不必要的比较，引入了 lastSorted 变量。
                    在每次遍历后，最后一个元素已经在它的正确位置上了
                    所以在下一次遍历时，不需要再去比较和交换这个已经排好序的元素。
                    通过设置 lastSorted 变量为当前节点来表示在这个节点之后的所有元素已经在正确的位置上了。
                 */
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

        Set<T> seenElements = new HashSet<>();
        Node<T> currentNode = first;
        Node<T> prevNode = null;


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

