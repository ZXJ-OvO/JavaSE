package com.zxj.day16;

import java.util.function.Consumer;

public class Question15<T> {
    Node1<T> first;
    int size;

    public Question15() {
        this.size = 0;
        this.first = null;
    }

    public int size() {
        return size;
    }


    public boolean add(T data) {
        Node1<T> newNode = new Node1<>(data);
        if (first == null) {
            first = newNode;
        } else {
            Node1<T> currentNode = first;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
        return true;
    }

    public boolean remove(int index) {
        if (first == null) {
            return false;
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            first = first.next;
            size--;
            return true;
        }

        Node1<T> currentNode = first;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        Node1<T> deleteNode = currentNode.next;
        currentNode.next = deleteNode.next;
        deleteNode.next = null;

        size--;

        return true;
    }


    public void update(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node1<T> currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = data;
    }

    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node1<T> currentNode = first;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }


    public void forEach(Consumer<? super T> action) {
        Node1<T> currentNode = first;
        while (currentNode != null) {
            action.accept(currentNode.data);
            currentNode = currentNode.next;

        }
    }


    public static void main(String[] args) {
        Question15<Object> list = new Question15<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(System.out::print);

        System.out.println();
        list.remove(0);
        list.forEach(System.out::print);

        System.out.println();
        list.update(0, 'A');
        list.update(1, 'B');
        list.update(2, 'C');
        list.forEach(System.out::print);

        System.out.println();

    }
}

class Node1<T> {
    T data;
    Node1<T> next;

    public Node1(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node1{" + "data=" + data + ", next=" + next + '}';
    }
}


