package Tuan10;

public class SelfBalancingTree {
    /*
     * Class node is defined as :
     * class Node
     * int val; //Value
     * int ht; //Height
     * Node left; //Left child
     * Node right; //Right child
     * 
     */

    public static Node1 insert(Node1 root, int val) {
        if (root == null) {
            Node1 node = new Node1();
            node.val = val;
            node.ht = 0;
            return node;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        root.ht = Math.max(height(root.left), height(root.right)) + 1;
        int balanceFactor = balanceFactor(root);

        if (balanceFactor > 1 && val < root.left.val) {
            root = rotateRight(root);
        } else if (balanceFactor > 1 && val > root.left.val) {
            root.left = rotateLeft(root.left);
            root = rotateRight(root);
        } else if (balanceFactor < -1 && val < root.right.val) {
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        } else if (balanceFactor < -1 && val > root.right.val) {
            root = rotateLeft(root);
        }
        return root;
    }

    public static Node1 rotateLeft(Node1 node) {
        Node1 temp = node.right;
        Node1 temp1 = temp.left;
        temp.left = node;
        node.right = temp1;

        node.ht = Math.max(height(node.left), height(node.right)) + 1;
        temp.ht = Math.max(height(temp.left), height(temp.right)) + 1;
        
        return temp;
    }

    public static Node1 rotateRight(Node1 node) {
        Node1 temp = node.left;
        Node1 temp1 = temp.right;
        temp.right = node;
        node.left = temp1;

        node.ht = Math.max(height(node.left), height(node.right)) + 1;
        temp.ht = Math.max(height(temp.left), height(temp.right)) + 1;

        return temp;
    }

    public static int height(Node1 node) {
        if (node == null)
            return -1;
        else {
            return node.ht;
        }
    }

    public static int balanceFactor(Node1 node) {
        if (node == null) {
            return 0;
        } else {
            return (height(node.left) - height(node.right));
        }
    }
}

class Node1 {
    Node1 left;
    Node1 right;
    int val;
    int ht;

    public Node1() {

    }
}