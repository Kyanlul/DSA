package Tuan10;

import java.util.*;

class Node4 {
    Node4 left;
    Node4 right;
    int data;

    Node4(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution2 {

    public static void preOrder( Node4 root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

    public static Node4 insert(Node4 root, int data) {
        if (root == null) {
            return new Node4(data);
        }
        else if (data > root.data) {
            root.right = insert(root.right, data);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node4 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}