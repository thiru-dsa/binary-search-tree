package com.binarysearchtree;

public class BinarySearchTree {

    Node root;
    static class Node {
        int key;
        Node left, right;

        Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }

    BinarySearchTree(int key) {
        root = new Node(key);
    }

    BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        BinarySearchTree.insert(root, value);
    }

    public static Node insert(Node root, int value) {

        if(root == null) {
            return new Node(value);
        }
        if(value < root.key) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    public Node search(Node root, int value) {
        if(root == null || root.key == value) {
            return root;
        }

        if(value < root.key) {
            return search(root.left, value);
        }
        return search(root.right, value);
    }

    public void delete(int value) {
        root = BinarySearchTree.delete(root, value);
    }

    public static Node delete(Node root, int value) {

        if(root == null) return root;

        if(value > root.key) {
            root.right = delete(root.right, value);
        }
        else if(value < root.key) {
            root.left = delete(root.left, value);
        }
        else {
            if(root.right == null) {
                return root.left;
            }
            if(root.left == null) {
                return root.right;
            }

            root.key = findInOrderSuccessorValue(root.right, value) ;
            root.right = delete(root.right, root.key);
        }

        return root;
    }

    public static int findInOrderSuccessorValue(Node root, int value) {
        while (root.left != null) {
            root = root.left;
        }

        return root.key;
    }

}
