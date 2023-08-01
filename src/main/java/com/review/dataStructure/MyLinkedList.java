package com.review.dataStructure;

import java.lang.reflect.Array;
import java.util.Collection;

public class MyLinkedList<E> {
    int size = 0;
    Node<E> first;
    Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * 是否包含给定的元素
     *
     * @param o 给定的元素
     * @return 是否包含
     */
    public boolean contains(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index >= 0;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index >= 0;
                index++;
            }
        }
        return false;
    }

    /**
     * 链表的长度
     *
     * @return 链表的长度
     */
    public int size() {
        return size;
    }

    /**
     * 尾部添加元素
     *
     * @param e 要添加的元素
     * @return 是否添加成功
     */
    public boolean add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;

        return true;
    }

    /**
     * 在指定索引位置添加元素
     *
     * @param index   索引
     * @param element 要添加的元素
     */
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            add(element);
        else
            linkBefore(element, node(index));
    }

    public boolean addAll(Collection<? extends E> c) {
        int index = size;
        checkPositionIndex(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }
        for (Object o : a) {
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }
        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }
        size += numNew;
        return true;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据索引删除元素
     *
     * @param index 索引
     * @return 被删除的元素
     */
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;

        return element;
    }

    /**
     * 清空链表
     */
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * 拿到目标索引位置的元素
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    /**
     * 拿到指定索引位置的节点
     *
     * @param index 索引
     * @return 节点
     */
    Node<E> node(int index) {

        Node<E> x;
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

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    public String toString() {

        if (first == null) return "[]";

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        MyLinkedList.Node<E> start = first;
        builder.append(start.item.toString());
        start = start.next;
        while (start != null) {
            builder.append(", ").append(start.item.toString());
            start = start.next;
        }
        builder.append("]");
        return builder.toString();
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
    }

    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    void linkBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;

    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.toString());
        list.add(2, 5);
        System.out.println(list.toString());

    }
}