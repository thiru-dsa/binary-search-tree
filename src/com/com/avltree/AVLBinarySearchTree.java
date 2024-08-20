package com.com.avltree;

public class AVLBinarySearchTree {

    Node root;
    static class Node {
        int key;
        Node left, right;
        int height;

        Node(int value) {
            this.key = value;
            left = null;
            right = null;
            height = 0;
        }
    }

    public static int getHeight(Node node) {
        if(node == null) {
            return -1;
        }
        return node.height;
    }

    public AVLBinarySearchTree() {
        root = null;
    }

    public AVLBinarySearchTree(int value) {
        root = new Node(value);
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public static int max(int firstValue, int secondValue) {
        return firstValue > secondValue ? firstValue : secondValue;
    }

    public static int getBalanceFactor(Node node) {
        if(node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    public static Node insert(Node node, int value) {
        if(node == null) {
            return new Node(value);
        }

        if(value < node.key) {
            node.left =  insert(node.left, value);
        } else if(value > node.key) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }

        node.height = 1 + max(getHeight(node.right), getHeight(node.left));

        System.out.println("Node " + node.key + " Height " + node.height);
        int balanceFactor = getBalanceFactor(node);
        // LL Case
        if(balanceFactor > 1 && value < node.left.key) {
            return rightRotate(node);
        }
        // LR Case
        if(balanceFactor > 1 && value > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RR Case
        if(balanceFactor < -1 && value > node.right.key) {
            return leftRotate(node);
        }
        // RL Case
        if(balanceFactor < -1 && value < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public static Node rightRotate(Node z) {
        Node y = z.left;
        Node t3 = y.right;

        y.right = z;
        z.left = t3;

        // update the new height of the tree
        z.height = 1 + max(getHeight(z.right), getHeight(z.left));
        y.height = 1 + max(getHeight(y.right), getHeight(y.left));

        return y;
    }

    public static Node leftRotate(Node z) {
        Node y = z.right;
        Node t3 = y.left;

        y.left = z;
        z.right = t3;

        // update the new height of the tree
        z.height = 1 + max(getHeight(z.right), getHeight(z.left));
        y.height = 1 + max(getHeight(y.right), getHeight(y.left));

        return y;
    }

    public void inorder() {
        inorder(root);
    }

    public static void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public int getRoot() {
        return root.key;
    }
}
