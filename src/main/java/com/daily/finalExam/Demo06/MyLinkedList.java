package com.daily.finalExam.Demo06;

/**
 * * 大家都知道Java的LinkedList<E>集合是**双链表机制**，现在需要你自己手写一个MyLInkedList<E>集合来模拟LinkedList集合的功能。
 * **具体功能点如下**
 * *  请自定义一个MyLinkedList<E>集合，**要求是基于双链表机制**。
 * *  接着要完成数据的添加方法 public void add(E e)。（需要维护双链表的关系）
 * *  开发一个根据索引获取数据的方法：public E get(int index)。（需要跟LinkedList的优化方案一致）
 * *  开发一个根据索引删除数据的方法：public E delete(int index)。（需要跟LinkedList的优化方案一致）
 * *  开发一个toString()方法，用于输出MyLinkedList<E>集合的内容。
 * *  在main方法里编写代码对上述功能进行测试。
 */
public class MyLinkedList<E> {
    int size = 0;
    Node<E> first;
    Node<E> last;

    public MyLinkedList() {
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;

    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
    }

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

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
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


    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public E delete(int index) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> x = first;
        for (int i = 0; i < size; i++) {
            sb.append(x.item);
            if (i != size - 1) {
                sb.append(",");
            }
            x = x.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {

        MyLinkedList<String> linkedList = new MyLinkedList<>();

        System.out.println("1、测试元素添加方法");
        linkedList.add("喂");
        linkedList.add("是");
        linkedList.add("朱");
        linkedList.add("磊");
        linkedList.add("吗");
        linkedList.add("?");
        linkedList.add("你");
        linkedList.add("就");
        linkedList.add("是");
        linkedList.add("朱");
        linkedList.add("磊");
        System.out.print(linkedList);
        System.out.println("\n");

        System.out.println("2、测试根据索引拿到数据的get方法");
        System.out.print(linkedList.get(2));
        System.out.print(linkedList.get(3));
        System.out.println("\n");

        System.out.println("3、测试根据索引删除元素的delete方法");
        String delete = linkedList.delete(5);
        System.out.println("删除的元素是：" + delete);
        System.out.println("遍历原链表：");
        System.out.print(linkedList);
        System.out.println("\n");

        System.out.println("4、测试toString()方法");
        System.out.println(linkedList.toString());
    }

}


