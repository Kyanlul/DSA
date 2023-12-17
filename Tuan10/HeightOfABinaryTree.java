package Tuan10;

import java.util.*;

class Node3 {
    Node3 left;
    Node3 right;
    int data;

    Node3(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node3 root) {
        if (root == null){
            return -1;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }

    }


    public static Node3 insert(Node3 root, int data) {
        if(root == null) {
            return new Node3(data);
        } else {
            Node3 cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node3 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}