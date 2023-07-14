package com.zxj.day12;

import java.util.ArrayList;
import java.util.List;

public class Question15 {
    public static void main(String[] args) {
        List<? extends Node> list = new ArrayList<>();

    }
}

class Node<T> {
    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
    }


    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}