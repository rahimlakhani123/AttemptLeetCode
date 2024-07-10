package org.example.ll;

public class DoublyLinkedList<V> {
    Node<V> head;
    Node<V> tail;

    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList();
        ll.insertAtEnd(5);
        ll.insertAtEnd(8);
        ll.insertAtEnd(10);
        ll.insertAtEnd(11);
        ll.print();

        ll.deleteAtStart();
        System.out.println("****************");
        ll.print();


        System.out.println("****************");
        ll.deleteAtEnd();
        ll.print();
    }

    public void insertAtStart(V v) {
        Node node = new Node(v);
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        if (tail == null)
            tail = node;
        head = node;
    }

    public V deleteAtStart() {
        var currHeadsValue = head.v;
        head.next.prev = null;
        head = head.next;
        return currHeadsValue;
    }

    public V deleteAtEnd() {
        var currTailVal = tail.v;
        tail.prev.next = null;
        tail = head.prev;
        return currTailVal;

    }

    public void insertAtEnd(V v) {
        Node node = new Node(v);
        if (tail != null) {
            node.prev = tail;
            tail.next = node;
        }
        if (head == null)
            head = node;

        tail = node;
    }

    public void print() {
        var curr = head;
        while (curr != null) {
            System.out.println(curr.v);
            curr = curr.next;
        }
    }

    class Node<V> {
        V v;
        Node<V> prev;
        Node<V> next;

        public Node(V v) {
            this.v = v;
        }
    }
}
