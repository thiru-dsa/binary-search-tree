package com.binarytree;

public class BinaryTree<T> {

    static class Node<T> {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    BinaryTree(T data) {
        root = new Node(data);;
    }

    public void insertLeft(Node node, T value) {
        node.left = new Node(value);
    }

    public void insertRight(Node node, T value) {
        node.right = new Node(value);
    }

    public static void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
