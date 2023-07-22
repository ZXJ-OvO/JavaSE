package com.zxj.day16;

import java.util.function.Consumer;

public class Question14<T> {
    // 链表中的第一个节点
    private Node<T> first;

    // 链表的长度
    private int size;


    // 类构造器，给属性初始化赋值
    public Question14() {
        this.first = null;
        this.size = 0;
    }


    // 链表长度的方法
    public int size() {
        // 链表的长度由其他方法维护，因此直接返回
        return size;
    }


    // 添加元素的方法
    public boolean add(T data) {
        // 根据传递进来的元素创建一个节点
        Node<T> newNode = new Node<>(data);

        // 判断第一个节点是否存在
        if (first == null) {
            // 不存在，则本次添加的元素是链表中的第一个元素
            first = newNode;
        } else {
            // 存在，从首节点中拿到节点
            Node<T> currentNode = first;

            // 只要当前的节点中后向指针存在数据就代表当前的节点不是最后一个节点
            while (currentNode.next != null) {
                // 循环体内部，当前的节点拿到后向指针的节点交给当前贮存当前节点的变量
                currentNode = currentNode.next;
            }

            // 通过不断的循环判断，游标来到了链表中的最后一个节点，则该节点的后向指针需要指向新节点
            currentNode.next = newNode;
        }

        // 添加成功，链表的长度加一
        size++;

        // 添加成功，返回true
        return true;
    }


    // 根据索引删除元素的方法
    public boolean remove(int index) {
        // 当链表的首节点为空时，代表着无数据可以被删除
        if (first == null) {

            // 返回删除操作失败
            return false;
        }

        // 如果传递进来的索引大于等于链表的长度
        if (index < 0 || index >= size) {
            // 抛出索引越界异常
            throw new IndexOutOfBoundsException("索引非法");
        }


        // 判断是否删除第一个节点（索引为0）
        if (index == 0) {

            // 更新头节点的后向指针，让第二个节点成为首节点
            first = first.next;

            // 当前节点删除成功，则链表长度减一
            size--;

            // 删除成功
            return true;
        }

        // 索引合法且不为首节点，则将链表的首节点用临时变量接收
        Node<T> currentNode = first;

        // 遍历查找目标索引前一个元素，与修改逻辑不同，删除逻辑涉及节点之间的关联关系，因此需要找到前一个节点然后操作后向指针
        for (int i = 0; i < index - 1; i++) {

            // 通过临时节点变量的后向指针拿到后一个数据，因此需要索引2的数据时应该从索引1的后向指针中拿，佐证了为何循环的条件不是小于等于目标索引
            currentNode = currentNode.next;
        }

        // 通过当前的节点的后向指针找到待删除的节点并用变量接收
        Node<T> nodeToRemove = currentNode.next;

        // 将待删除的节点的前向节点的后向指针与待删除的节点的后向节点关联起来，并且此时已经兼顾了删除的节点是最后一个节点的情况
        currentNode.next = nodeToRemove.next;

        // 设置被删除节点的后向指针为null，防止内存泄漏
        nodeToRemove.next = null;

        // 当前节点删除成功，则链表长度减一
        size--;

        // 删除成功
        return true;
    }


    // 根据索引修改节点的方法
    public boolean update(int index, T newData) {
        // 首先排除索引非法的情况
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引非法");
        }

        // 索引合法，则将链表的首节点用临时变量接收
        Node<T> currentNode = first;

        // 通过遍历找到目标索引对应的节点，与删除逻辑不同，更新操作需要找到对应所应的节点
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        // 将传递进来的新的值赋给当前的节点
        currentNode.data = newData;

        // 修改成功
        return true;
    }


    // 根据索引获取节点数据的方法
    public T get(int index) {

        // 如果传递进来的索引大于等于链表的长度，则抛出索引越界异常
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引非法");
        }

        // 索引合法，则将链表的首节点用临时变量接收
        Node<T> currentNode = first;

        // 遍历查找目标索引元素，此时需要注意循环的终结条件是i < index
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        // 此时的临时节点实际上就是需要取数据的节点，直接拿到数据
        T data = currentNode.data;

        // 找到了目标数据，重节点中拿到数据返回
        return data;
    }


    // forEach循环，传入形参Consumer<? super T> action
    public void forEach(Consumer<? super T> action) {
        // 将链表的首节点用临时变量接收
        Node<T> currentNode = first;

        // 通过循环遍历判断当前的节点是否为最后一个节点，不是最后一个节点就一直遍历
        while (currentNode != null) {

            // Consumer的action的accept方法，掺入当前节点的数据
            action.accept(currentNode.data);

            // 将指针指向下一个节点，进行下一轮循环判断
            currentNode = currentNode.next;
        }
    }

}

// 链表节点类
class Node<T> {

    // 链表中存放的数据
    public T data;

    // 当前节点的后向指针节点
    public Node<T> next;

    // 节点构造器，传入数值给属性初始化，且尾插法中，每次插入的节点都是链表的尾节点，因此后向指针为null
    public Node(T element) {
        this.data = element;
        this.next = null;
    }

    // 为链表重写一个toString
    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", next=" + next + '}';
    }
}