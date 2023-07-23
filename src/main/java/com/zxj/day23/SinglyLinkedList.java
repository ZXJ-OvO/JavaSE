package com.zxj.day23;

// Define the Node class for the linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize a node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define the SinglyLinkedList class
public class SinglyLinkedList {
    private Node head;
    private int size;

    // Constructor to initialize an empty linked list
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to delete a node with a given data value
    public boolean delete(int data) {
        if (head == null) {
            return false; // List is empty, nothing to delete
        }

        if (head.data == data) {
            head = head.next; // If the data to delete is in the head node
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next; // Remove the node by skipping it
                size--;
                return true;
            }
            current = current.next;
        }

        return false; // Data not found in the list
    }

    // Method to search for a node with a given data value and return its index
    public int search(int data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == data) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Data not found in the list
    }

    // Method to modify the value of a node at a given index
    public boolean modify(int index, int newData) {
        if (index < 0 || index >= size) {
            return false; // Invalid index
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = newData;
        return true;
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    // Method to convert the list to a string representation
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    // Method to iterate over each node and apply a consumer function
    public void forEach(java.util.function.Consumer<Integer> consumer) {
        Node current = head;
        while (current != null) {
            consumer.accept(current.data);
            current = current.next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        System.out.println("Initial Linked List: " + list);
        System.out.println("Size: " + list.size());

        list.forEach(data -> System.out.print(data + " "));

        System.out.println("\nIndex of 20: " + list.search(20));

        list.modify(1, 25);
        System.out.println("Modified Linked List: " + list);

        list.delete(25);
        System.out.println("Linked List after deleting 25: " + list);
    }
}
