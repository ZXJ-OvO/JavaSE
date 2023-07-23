//package com.zxj.day17;
//
//import java.util.function.Consumer;
//
//public class MyLinkedList<T> {
//    private int size;
//    private Node<T> first;
//
//    public MyLinkedList() {
//        this.size = 0;
//        this.first = null;
//    }
//
//    public boolean add(T data) {
//        Node<T> newNode = new Node<>(data);
//        if (first == null) {
//            first = newNode;
//            size++;
//            return true;
//        }else {
//            Node<T> currentNode = first;
//            while (currentNode.next != null){
//                currentNode = currentNode.next;
//            }
//            Node<T> targetNode = currentNode.next;
//            currentNode.next = targetNode.next;
//            targetNode.next = null;
//            size++;
//
//        }
//
//    }
//
//    public boolean remove(int index) {
//
//
//    }
//
//    public boolean modify(int index, T data) {
//
//    }
//
//    public boolean get(int index) {
//
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public void forEach(Consumer<? super T> action) {
//        Node<T> currentNode = first;
//        while (currentNode != null) {
//            currentNode = currentNode.next;
//            action.accept(currentNode.data);
//        }
//    }
//
//    public static void main(String[] args) {
//        com.zxj.day16.MyLinkedList<String> list = new com.zxj.day16.MyLinkedList<>();
//        list.foeEach(System.out::println);
//
//    }
//}
//
//class Node<T> {
//    T data;
//    Node<T> next;
//
//    public Node(T data) {
//        this.data = data;
//        this.next = null;
//    }
//
//    @Override
//    public String toString() {
//        return "Node{" + "data=" + data + ", next=" + next + '}';
//    }
//}
