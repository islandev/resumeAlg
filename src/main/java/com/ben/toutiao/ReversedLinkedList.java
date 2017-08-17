package com.ben.toutiao;

public class ReversedLinkedList {


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


    static Node reverseNode(Node head) {
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

    static Node mergeNode(Node a, Node b) {
        Node res = new Node();
        Node h = res;
        if (a == null) return b;
        if (b == null) return a;

        while (a != null || b != null) {
            if (a == null) {
                res.next = b;
                break;
            }
            if (b == null) {
                res.next = a;
                break;
            }
            res.next = new Node(a.val + b.val);
            res = res.next;
            a = a.next;
            b = b.next;
        }
        return h.next;

    }



    public static void main(String[] args) {

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        Node head2 = new Node(3);
        head2.next = new Node(4);


        Node node = reverseNode(mergeNode(reverseNode(head1), reverseNode(head2)));
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
