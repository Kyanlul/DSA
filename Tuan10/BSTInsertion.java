package Tuan10;

import java.util.Scanner;

public class BSTInsertion {
    static void insert(Node2 node2, int value) {
        if (value < node2.data) {
            if (node2.left != null) {
                insert(node2.left, value);
            } else {
                Node2 temp = new Node2(value);
                node2.left = temp;
            }
        } else {
            if (node2.right != null) {
                insert(node2.right, value);
            } else {
                Node2 temp = new Node2(value);
                node2.right = temp;
            }
        }
    }

    static void preOrder(Node2 node2) {
        if (node2 != null) {
            System.out.print(node2.data + " ");
            preOrder(node2.left);
            preOrder(node2.right);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        Node2 head = new Node2(x);
        for (int i = 1; i < n; i++) {
            x = input.nextInt();
            insert(head, x);
        }
        preOrder(head);
        input.close();
    }
}

class Node {
    Node2 left;
    Node2 right;
    int data;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}