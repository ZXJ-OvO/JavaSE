package com.zxj.day15;

public class MyLinkedList<T> {
    // 链表中的第一个节点
    private Node<T> head;
    // 链表的长度
    private int size;

    // 类构造器，给属性初始化赋值
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 添加元素的方法
    public void add(T data) {
        // 根据传递进来的元素创建一个节点
        Node<T> newNode = new Node<>(data);

        // 判断第一个节点是否存在
        if (head == null) {
            // 不存在，则本次添加的元素是链表中的第一个元素
            head = newNode;
        } else {
            // 存在，拿到当前的节点
            Node<T> currentNode = head;

            // 只要当前的节点的后向指针存在数据就代表当前的节点不是最后一个节点
            while (currentNode.next != null) {

                // 循环体内部，当前的节点拿到后向指针的节点交给当前贮存当前节点的变量
                currentNode = currentNode.next;
            }

            // 通过不断的循环判断，游标来到了链表中的最后一个节点，则该节点的后向指针需要指向新节点
            currentNode.next = newNode;
        }

        // 添加成功，链表的长度加一
        size++;
    }

    // 根据索引获取节点数据的方法
    public T get(int index) {

        // 如果传递进来的索引大于等于链表的长度，则抛出索引越界异常
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 索引合法，则将链表的首节点用临时变量接收，因为链表查询数据必须从边界向指定索引一个一个的遍历
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }


    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("usa");
        linkedList.add("nasa");
        linkedList.add("usd");

        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(linkedList.get(i));
        }
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}