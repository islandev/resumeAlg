package com.ben.toutiao;

public class ReversedLinkedList {
    static Node head;

    static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            this.next = null;
        }

        Node() {
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
    }

    Node reverseNode(Node head) {
        Node current = head;
        Node pre = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    void mergeNode(Node a, Node b, Node res) {
        if (a == null) res = a;
        if (b == null) res = b;
        res = new Node(a.val + b.val);
        mergeNode(a.next, b.next, res.next);
    }

    void mergeNodeC(Node a, Node b) {
        Node res = new Node();
        mergeNode(a, b, res);
    }

    int MergeNode(Node a, Node b) {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        ReversedLinkedList list = new ReversedLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);

        list.head.next.next.next = new Node(4);


        ReversedLinkedList list2 = new ReversedLinkedList();
        list.head = new Node(3);

        list.head.next.next = new Node(4);

        list.printList(head);
        head = list.reverseNode(head);
        System.out.println("");
        list.printList(head);

    }
}
