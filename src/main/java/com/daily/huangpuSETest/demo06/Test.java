package com.daily.huangpuSETest.demo06;

/**
 * 1、在MyLinkedList类中，开发一个sort方法，支持对链表进行升序排序，写完后需要分别测试对这两个链表排序，并分别遍历输出。
 * 2、在MyLinkedList类中，开发一个mergeSort方法，支持将这两个升序排序的链表，再次合并成一个新链表，要求新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：head1 ->  2 → 4 → 1,      head2 →  4 → 1 → 3
 * 返回：head3 ->  1 -> 1 -> 2 -> 3 -> 4 -> 4
 * 评分细则
 * 能正确排序并遍历链表：6分
 * 能合并并排序：10分
 */
public class Test {
    public static void main(String[] args) {
        // 第一个链表：
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.add(2);
        list1.add(4);
        list1.add(1);
        // 第一个链表的头结点：head1
        MyLinkedList.Node<Integer> head1 = list1.head;

        // 第二个链表：
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.add(4);
        list2.add(1);
        list2.add(3);
        // 第二个链表的头结点：head1
        MyLinkedList.Node<Integer> head2 = list2.head;

        // 功能1：在MyLinkedList类中，开发一个sort方法，对两个链表分别排序，并分别遍历输出

        // 功能2：在MyLinkedList类中，开发一个mergeSort方法，支持将这两个升序排序的链表，合并成一个新链表，要求新链表中的节点仍然是递增排序的。
        // ，然后对新链表遍历输出

        System.out.println(list1.foreach());
        list1.sort();
        System.out.println(list1.foreach());

        MyLinkedList<?> myLinkedList = list1.mergeSort(list1, list2);
        System.out.println(myLinkedList.foreach());


    }
}
