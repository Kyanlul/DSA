package Tuan10;

import java.util.Scanner;

public class LowestCommonAncestor {
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

    public static Node2 lca(Node2 root, int v1, int v2) {
        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        } else if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        } else {
            return root;
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
        int v1 = input.nextInt();
        int v2 = input.nextInt();
        System.out.println(lca(head, v1, v2).data);
        input.close();
    }
}

class Node2 {
    Node2 left;
    Node2 right;
    int data;

    public Node2(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}