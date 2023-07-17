package com.zxj.day23;

public class LinkedList<E> {
    // 表示链表当中数据的个数
    private int size = 0;
    // 链表当中第一个节点
    private Node<E> first;
    // 表示链表当中最后一个节点
    private Node<E> last;

    public boolean add(E o) {
        return append(o);
    }

    public boolean add(int index, E o) {
        Node<E> node = findNodeByIndex(index);
        insertBeforeNode(node, o);
        size++;
        return true;
    }

    /**
     * 在节点数据 node 之后插入数据 o
     */
    void insertAfterNode(Node<E> node, E o) {
        if (node == null) throw new NullPointerException();
        // newNode 前面的节点为 node 后面的节点是 node.next
        Node<E> newNode = new Node<>(o, node, node.next);
        if (node.next != null) node.next.prev = newNode;
        if (node == last) last = newNode;
        node.next = newNode;
    }

    /**
     * 在节点 node 之前插入数据 o
     */
    void insertBeforeNode(Node<E> node, E o) {
        if (node == null) throw new NullPointerException();
        // newNode 前面你的节点为 node.prev 后面的节点为 node
        Node<E> newNode = new Node<>(o, node.prev, node);
        if (node.prev != null) node.prev.next = newNode;
        else first = newNode;
        node.prev = newNode;
    }

    /**
     * 根据下标找节点
     */
    Node<E> findNodeByIndex(int index) {
        if (index >= size) throw new RuntimeException("输入 index 不合法链表中的数据个数为 " + size);
        Node<E> x;
        // 首先看看 index 和 size / 2 的关系
        // 这里主要是看链表的首和尾部谁距离 index 位置近，那头近就从哪头遍历
        // size >> 1 == size / 2
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;

    }

    void removeNode(Node<E> node) {
        if (node == null) throw new NullPointerException();
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
    }

    /**
     * 根据下标删除某个节点  TODO remove删除失败
     */
    public void remove(int index) {
        // 首先找到第 index 个数据对应的节点
        Node<E> node = findNodeByIndex(index);
        // 删除节点
        removeNode(node);
        size--;
    }

    /**
     * 往链表尾部加入一个数据，功能和 add 一样
     */
    public boolean append(E o) {
        final Node<E> l = last;
        // 新增的节点需要将 prev 指向上一个节点，上一个节点就是链表的 last 节点
        // 新增节点的下一个节点就 null
        final Node<E> newNode = new Node<>(o, last, null);
        last = newNode;
        if (first == null) {
            // 如果链表当中还没有节点，就将其作为第一个节点
            first = newNode;
        } else {
            // 如果链表当中已经有节点，需要将新增的节点连接到链表的尾部
            l.next = newNode;
        }
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean contain(E o) {
        Node<E> start = first;
        while (start != null) {
            if (start.data.equals(o)) return true;
            start = start.next;
        }
        return false;
    }

    private static class Node<E> {
        E data;        // 指向节点的真实存储的数据
        Node<E> prev;        // 前向指针：指向前一个数据
        Node<E> next;        // 后向指针：指向后一个数据

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public String toString() {

        if (first == null) return "[]";

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<E> start = first;
        builder.append(start.data.toString());
        start = start.next;
        while (start != null) {
            builder.append(", ").append(start.data.toString());
            start = start.next;
        }
        builder.append("]");
        return builder.toString();
    }


    public E get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return node(index).data;
    }

    Node<E> node(int index) {
        /*
         * 则从头节点开始查找，否则从尾节点查找
         * 查找位置 index 如果小于节点数量的一半，
         */
        if (index < (size >> 1)) {
            Node<E> x = first;
            // 循环向后查找，直至 i == index
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

}