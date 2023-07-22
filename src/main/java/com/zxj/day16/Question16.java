package com.zxj.day16;

import java.util.function.Consumer;

public class Question16<T> {
    private Node<T> first;
    private int size;

    public Question16() {
        first = null;
        size = 0;
    }

    public boolean add(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
            size++;
            return true;
        }
        Node<T> currentNode = first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        size++;
        return true;
    }

    public boolean remove(int index) {
        if (size == 0) throw new RuntimeException("无元素可以删除");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            first = first.next;
            size--;
            return true;
        }

        Node<T> currentNode = first;

        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        Node<T> targetDeleteNode = currentNode.next;
        currentNode.next = targetDeleteNode.next;
        targetDeleteNode.next = null;

        size--;
        return true;
    }

    public boolean modify(int index, T data) {
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

        T data1 = currentNode.data;
        return data1;
    }


    public void forEach(Consumer<? super T> action) {
        Node<T> currentNode = first;
        while (currentNode != null) {
            action.accept(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        Question16<Integer> q = new Question16<>();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.forEach(System.out::print);
        System.out.println();

        q.modify(0, 1);
        q.modify(1, 2);
        q.modify(2, 3);
        q.modify(3, 4);
        q.forEach(System.out::print);



//        q.remove(0);
//        q.forEach(System.out::print);
//        System.out.println("---");
//
//        q.remove(2);
//        q.forEach(System.out::print);
//        System.out.println("---");

//        q.remove(3);
//        q.forEach(System.out::print);
//        System.out.println("---");
//
//        q.add(3);
//        q.add(4);
//        q.forEach(System.out::print);
//        System.out.println("---");

    }

}

class Node2<T> {
    T data;
    Node<T> next;

    public Node2(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node2{" + "data=" + data + ", next=" + next + '}';
    }
}

