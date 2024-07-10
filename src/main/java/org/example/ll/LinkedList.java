package org.example.ll;

public class LinkedList {
    Node root;

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(5);
        ll.insertAtEnd(8);
        ll.insertAtEnd(10);
        ll.print();

        System.out.println("******************");

        ll.insertAtPosition(8, 9);

        System.out.println("******************");
        ll.print();

    }

    public void insert(int i) {
        Node node = new Node(i);
        if (root == null) {
            root = node;
        } else {
            node.next = root;
            root = node;
        }
    }

    public void insertAtEnd(int i) {
        Node node = new Node(i);
        if (root == null) {
            root = node;
            return;
        }
        Node curr = root;
        Node prev = null;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = node;
    }

    public void print() {
        Node curr = root;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    public void insertAtPosition(int prevNode, int nodeV) {
        Node curr = root;
        while (curr != null) {
            if (curr.value == prevNode) {
                var node = new Node(nodeV);
                node.next = curr.next;
                curr.next = node;
                break;
            }
            curr = curr.next;
        }
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
