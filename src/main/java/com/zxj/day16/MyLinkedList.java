package com.zxj.day16;

import java.util.function.Consumer;

public class MyLinkedList<T> {
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
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


    public boolean remove(int index) {
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

        currentNode.data = data;

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
        return currentNode.data;
    }

    public void foeEach(Consumer<? super T> action) {
        Node<T> currentNode = first;
        while (currentNode != null) {
            action.accept(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        list.foeEach(System.out::println);
        System.out.println();
        list.remove(0);
        list.foeEach(System.out::println);
        System.out.println();

        list.update(1, 2);
        list.foeEach(System.out::println);
        System.out.println();

        System.out.println();

        System.out.println(list.get(2));
    }
}

